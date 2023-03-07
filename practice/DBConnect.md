## MYSQL - SpringBoot 연결하기
Spring boot 기본 프로젝트를 생성하고 나면 resources/application.properties 에서 MYSQL을 연결할 수 있다. 

### application.properties 설정

```
# MYSQL DATABASE SETTING
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/(database schema)?serverTimezone=Asia/Seoul
spring.datasource.username=(username)
spring.datasource.password=(password)

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true

# MUSTACHE
spring.mustache.expose-request-attributes=true

# MySQL ? ??? ?.
spring.jpa.database=mysql

# MySQL ?? ??
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

1. username : mysql connection을 만들때 사용한 이름 (기본은 root)
2. password : mysql connection을 만들때 사용한 비밀번호
3. database schema : 해당 프로젝트에서 사용할 데이터베이스 스키마

해당 코드를 모두 작성하면 springboot에서 mysql을 사용할 때 설정한 DB로 연결되게 된다.
