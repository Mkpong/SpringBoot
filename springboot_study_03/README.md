# Springboot Stduy 03

## 학습 목표
1. JPA one to many 학습

## 구현 내용
1. Spring security를 이용하여 로그인 처리(springboot_study_01)
2. user목록 페이지 구현 - One to Many를 통해 user정보와 user가 들어가 있는 Team에 정보를 출력한다.
3. team목록 페이지 구현 - 양방향 One to Many를 통해 team에서도 team에 속해있는 user정보를 출력한다.

내가 겪었던 문제들
1. jpa 양방향 무한 참조로 인한 stackoverflow -> 해결방법 -> jsonignore or dto사용!
