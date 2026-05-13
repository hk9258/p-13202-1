# 게시판 만들기 - 2차 테스트

## 기술 스택

- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Thymeleaf
- MySQL
- Lombok
- Validation
- Bootstrap

---

# 1차 요구사항 구현

- [x] 유저가 루트 url로 접속시에 게시글 리스트 페이지(http://주소:포트/article/list)가 나온다.
- [x] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [x] 게시글 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [x] 게시글 등록이 되면 해당 게시글 리스트 페이지로 리다이렉트 된다.
- [x] 리스트 페이지에서 해당 게시글을 클릭하면 상세페이지로 이동한다.
- [x] 게시글 상세 페이지에는 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.

---

# 2차 요구사항

- [x] 게시글 상세페이지에 수정 버튼이 있다.
- [x] 게시글 수정 기능이 구현되어 있다.
- [x] 게시글 상세페이지에 삭제 버튼이 있다.
- [x] 게시글 삭제 기능이 구현되어 있다.
- [x] 모든 페이지 상단에 루트 디렉토리로 이동하는 버튼이 있다.
- [x] 모든 페이지 상단에 로그인 / 로그아웃 버튼이 있다.
- [x] 모든 페이지 상단에 회원가입 버튼이 있다.
- [x] 회원가입 기능이 구현되어 있다.
- [x] 로그인 기능이 구현되어 있다.
- [x] 로그아웃 기능이 구현되어 있다.
- [x] 로그인 여부를 검사하여 게시글 작성 접근을 제한하였다.
- [x] 본인 글에 대해서만 수정 / 삭제가 가능하다.
- [x] 게시글 리스트에 번호, 제목, 작성자, 생성일 컬럼이 출력된다.
- [-] 검색 기능

---

# 구현 설명

## 회원 기능

- 회원가입 시 비밀번호 확인 검증을 진행하도록 구현하였습니다.
- Spring Security를 활용하여 로그인 / 로그아웃 기능을 구현하였습니다.
- BCryptPasswordEncoder를 사용하여 비밀번호를 암호화하였습니다.

## 게시글 기능

- 게시글 작성 시 현재 로그인한 사용자를 작성자로 저장하도록 구현하였습니다.
- 게시글 수정 / 삭제 시 작성자와 로그인 사용자를 비교하여 권한을 검사하도록 구현하였습니다.

## UI

- Bootstrap 기반 UI를 적용하였습니다.
- 공통 navbar를 사용하여 모든 페이지에서 홈 / 로그인 / 회원가입 이동이 가능하도록 구현하였습니다.

---

# 미비사항 or 막힌 부분

- 선택 기능인 검색 기능은 구현하지 못했습니다.
- Spring Security 적용 과정에서 로그인 접근 제한 및 권한 처리 부분에서 어려움이 있었습니다.
- Docker MySQL 연결 과정에서 포트 충돌 및 DB 연결 오류가 발생하여 해결하였습니다.

---

# UI / UX

## 회원가입 페이지
- URL : http://localhost:8080/user/signup

[(캡처 이미지 첨부)](http://localhost:8080/user/signup)

---

## 로그인 페이지
- URL : http://localhost:8080/user/login

<img width="781" height="567" alt="스크린샷 2026-05-13 오후 3 01 44" src="https://github.com/user-attachments/assets/29fe1307-eff8-4130-b0b5-68909e13c60b" />


---

## 게시글 등록 페이지
- URL : http://localhost:8080/article/create

<img width="784" height="756" alt="스크린샷 2026-05-13 오후 3 02 22" src="https://github.com/user-attachments/assets/23f1cac0-00c2-4e4c-a2d2-272fad905989" />

---

## 게시글 리스트 페이지
- URL : http://localhost:8080/article/list

<img width="785" height="536" alt="스크린샷 2026-05-13 오후 2 53 46" src="https://github.com/user-attachments/assets/677f345a-9daa-4db3-a190-e95614cce9e4" />

---

## 게시글 상세 페이지
- URL : http://localhost:8080/article/detail/{id}

<img width="781" height="552" alt="스크린샷 2026-05-13 오후 2 54 15" src="https://github.com/user-attachments/assets/ded58a26-bc85-4284-bb9b-981249bb6eb2" />
