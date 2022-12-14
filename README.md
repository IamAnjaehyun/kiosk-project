### Spring-boot 키오스크

## 📢 프로젝트 설명
- 스프링부트를 이용하여 만든 웹 키오스크 프로젝트입니다.
- 유저 역할을 판매자와 구매자로 나누어 구현하였습니다.

## ⚙ 개발 환경
- 운영체제 : Windows 10, MacOS
- 통합개발환경(IDE) : IntelliJ
- JDK 버전 : JDK 1.8
- 데이터 베이스 : JAWSDB MYSQL
- 빌드 툴 : Gradle
- 관리 툴 : GitHub


## 🔌 Dependencies
- Spring Boot DevTools
- Spring Security
- Lombok
- Spring Data JPA
- Mysql Driver
- Spring Web
- Thymeleaf


## 💻 기술 스택
- 백엔드
  - SpringBoot, Spring Data JPA
- 프론트엔드
  - HTML, CSS, Javascript, Thymeleaf
- 데이터베이스
  - MySQL, MySQL Workbench


## 🛠 DB 설계
- Cart
- CartItem
- Item
- Order
- OrderItem
- Sale
- SaleItem
- User


## 🕹 제작 일지
11/26
*  로컬에서 db에 있는 값 받아온 뒤 출력 가능
*  jawsdb에 데이터베이스 생성 후 crud 구현 예정

11/27
*  jawsdb와 연동시 호스팅이 되지 않는오류 발생

11/28
*  jawsdb와 연동 성공

11/29
*  jawsdb와 연동은 성공하였으나 사용자에게 권한이 없어 데이터 삽입 불가능
-> max_connection 오류 한번에 한 곳에서만 사용하면 오류일어나지 않음 

11/30
*  데이터 삽입되는척하면서 빈값들어감
-> html의 thymeleaf 오류였음

12/1
*  CRUD 기능 중 삭제 기능 오류

12/2
*  CRUD 기능 구현 완료
*  장바구니 기능 구현 위한 Cart domain, service, repository 생성 (Cartlist domain 생각중)

12/3
*  CART 와 CARTPRODUCT domain 만들었지만 , 기능 구현 실패

12/4
*  사진 업로드 위한 여러 자료들을 찾아보았으며, 구현 시도해보았지만 실패

12/5
*  파일 업로드 기능 구현 완료
*  로컬환경에서는 파일 업로드 성공하였으나, 호스팅시 상품 등록 자체가 무효화되는 현상
*  업로드 된 파일을 img로 인식하지 못하는 현상

12/6
*  파일 업로드 기능 구현 완료 +( 사진 파일 올라가지 않던 것 수정 / path 수정)
*  css 파일 수정
*  file domain 삭제 및 menu 도메인에 filepath 추가
*  기존 배포 경로로 배포시 jar 파일로 압축하여 호스팅 되는 구조이기 때문에 </br>
   사진 등록시에 aws 사용하여 외부저장소 생성해야함
*  맥으로 파일 옮기다 git 잘못 건들여서 commit 3일치 날아가서 복구완료
*  3~4일치 커밋이 2일간 커밋한 것 처럼 바뀜. 

12/7
*  장바구니 서비스 제작 시작

12/8
*  https://startbootstrap.com/template/shop-homepage 템플릿 사용 
*  메뉴 구조 변경 및 domain 수정
*  spring security 도입으로 인해 사진을 업로드하여 뿌려줘도 인식하지 못하는 현상 발생
*  JPA 수정하려 하였으나 실패

12/9 
*  spirng security 기능 도입으로 인해 cart 및 order 기능 구현 완료
*  기능 구현 완료 후 heroku로 배포하였으나 회원가입 후 로그인 과정에서 오류 발생

12/10
*  Spring Security 버전 업그레이드로 인해 extends 할 수 없는 오류 발생
*  Bean 처리로 사진 업로드 기능 복구 성공

12/11
*  사진 업로드시 사진이 깨지는 오류 발생, boot 재구동시 사진이 보이는 현상 발생

12/12
*  html 구조 변경
*  파일을 저장할 때 uuid 를 사용하지 않고 MD5Generator을 사용해서 파일명을 저장하도록 변경

12/13
*  html 배너 및 상단바 수정
*  yaml create-drop > update 로 수정
*  관리자, 사용자 USER 추가
*  음식사진 추가 및 실 사용가능하게 음식 등록

12/14
*  발표대비 코드 정리

## 🔗Link
https://anjh-kiosk.herokuapp.com/
