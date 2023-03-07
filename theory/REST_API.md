## API란?
- Application Programming Interface
- 응용 프로그램에서 사용할 수 있도록 다른 응용프로그램을 제어할 수 있게 만든 인터페이스
- 내부를 몰라도 정의되어 있는 기능을 쉽게 사용가능(ex. 마우스, 키보드등)

## REST란?
- Representational State Transfer
- 자원(data)의 이름으로 구분하여 해당 데이터의 상태를 교환하는 것
- 서버와 클라이언트의 통신 방식 중 하나
- HTTP URI를 통해 data를 명시, HTTP Method를 통해 자원 교환

> **HTTP Method : Create, Read , Update , Delete (CRUD)**

## REST 특징
1. Server-Client 구조
자원(data)를 가지고 있는 Server와 자원(data)를 요청하는 Client가 독립적으로 분리되어 있어야 한다.

2. Stateless
요청 간에 Client의 정보가 Server에 저장되지 않아야 한다.
Server는 각각의 요청을 모두 다르게 인식하고 처리

3. Cacheable
HTTP 프로토콜을 그대로 사용 -> HTTP의 특징인 캐싱기능을 적용함으로써
대량의 요청을 효율적으로 처리할 수 있다.

4. 계층화(Layered System)
Client는 서버의 상태와 관계없이 REST API 서버로 요청을 보낸다.
즉, 서버의 변화가 생겨도 Client의 요청은 변하지 않는다.

5. Code on Demand(Optional)
주로 자바스크립트를 사용할때 사용하는 기능
server에서 client로 코드,스크립트(로직)을 전달

6. 인터페이스 일관성(Uniform Interface)
정보가 표준 형식으로 전송되기 위해 통합 인터페이스 제공
-> HTTP 프로토콜을 따르는 모든 플랫폼에서 사용 가능하게 설계해야 한다.

## REST의 장점

1. HTTP 표준 프로토콜을 사용하는 모든 플랫폼에서 사용 가능하다.(인터페이스 일관성)
2. Server와 Client의 역할을 명확히 분리할 수 있다.
3. 여러 서비스 설계에서 생길 수 있는 문제를 최소화 -> 일관성이 있기 때문

## REST API란?
- REST 아키텍처의 조건을 준수하는 API
- REST 아키텍처를 구현하는 웹 서비스를 RESTful 하다고 표현

## REST API 특징
- REST 기반으로 시스템을 분산하여 확장성, 재사용성을 높임
- HTTP 표준을 따르고 있기 때문에 여러 프로그래밍 언어로 개발 가능

## REST API 설계 규칙
1. 웹 기반의 REST API는 URI를 통해 자원을 표현해야 한다.
2. 자원(data)에 대한 조작은 HTTP Method를 통해 표현해야 한다.
   - URI에는 행위가 들어가면 안됨
   - HEADER를 통해 CRUD 표현
3. 메세지를 통한 리소스 조작
   - HEADER를 통해 content-type을 지정하여 데이터 전달(HTML , XML , JSON, TEXT)
4. 기타 규칙
   1. URI에는 소문자를 사용
   2. 언더바 사용X -> 하이픈 사용 O
   3. 파일의 확장자 표현 X
