package com.back.sbb.article;

import com.back.sbb.user.SiteUser;
import com.back.sbb.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.AccessDeniedException;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:/article/list";
    }

    @GetMapping("/article/list")
    public String list(Model model) {
        model.addAttribute("articleList", articleService.getList());
        return "article/list";
    }

    @GetMapping("/article/create")
    public String createForm(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/user/login";
        }

        return "article/create";
    }

    @PostMapping("/article/create")
    public String create(@RequestParam String title,
                         @RequestParam String content,
                         Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/user/login";
        }

        SiteUser author = userService.getUser(authentication.getName());

        articleService.create(title, content, author);

        return "redirect:/article/list";
    }

    @GetMapping("/article/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.get(id));
        return "article/detail";
    }

    @GetMapping("/article/modify/{id}")
    public String modify(
            @PathVariable Long id,
            Authentication authentication,
            Model model
    ) {

        Article article = articleService.get(id);

        if (!article.getAuthor().getUsername()
                .equals(authentication.getName())) {

            throw new AccessDeniedException("수정 권한이 없습니다.");
        }

        model.addAttribute("article", article);

        return "article/modify";
    }

    @PostMapping("/article/modify/{id}")
    public String modify(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String content,
            Authentication authentication
    ) {

        Article article = articleService.get(id);

        if (!article.getAuthor().getUsername()
                .equals(authentication.getName())) {

            throw new AccessDeniedException("수정 권한이 없습니다.");
        }

        articleService.modify(article, title, content);

        return "redirect:/article/detail/" + id;
    }

    @GetMapping("/article/delete/{id}")
    public String delete(
            @PathVariable Long id,
            Authentication authentication
    ) {

        Article article = articleService.get(id);

        if (!article.getAuthor().getUsername()
                .equals(authentication.getName())) {

            throw new AccessDeniedException("삭제 권한이 없습니다.");
        }

        articleService.delete(article);

        return "redirect:/article/list";
    }
}