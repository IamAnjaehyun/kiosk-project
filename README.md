### Spring-boot 키오스크

## 📢 프로젝트 설명
- 스프링부트를 이용하여 만든 웹 키오스크 프로젝트입니다.
- 유저 역할을 판매자와 구매자로 나누어 구현하였습니다.

## ⚙ 개발 환경
- 운영체제 : Windows 10
-통합개발환경(IDE) : IntelliJ
- JDK 버전 : JDK 1.8
- 데이터 베이스 : JAWSDB MYSQL
- 빌드 툴 : Gradle
- 관리 툴 : GitHub


## 🔌 Dependencies
- Spring Boot DevTools
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
- Menu
- File


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

11/30
*  데이터 삽입되는척하면서 빈값들어감

12/1
*  삭제오류

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
*  기존 배포 경로로 배포시 jar 파일로 압축하여 호스팅 되는 구조이기 때문에</br>
   사진 등록시에 aws 사용하여 외부저장소 생성해야함
*  

## 🔗Link
https://anjh-kiosk.herokuapp.com/
