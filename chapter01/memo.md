# Chapter 1

### Authentication vs Authorization
* Authentication(인증)
  * 애플리케이션이 이를 이용하려는 사람을 식별하는 프로세스
* Authorization(권한 부여)
  * 인증된 호출자가 특정 기능과 데이터에 대한 이용 권리가 있는지 확인하는 프로세스

## 웹 취약점(OWASP 참고)
1. 인증과 권한 부여의 취약성
2. 세션 고정
3. XSS
4. CSRF
5. Injection(SQL, XPath, OS, LDAP)
6. 기밀 데이터 노출
7. 메서드 접근 제어 부족
8. 알려진 취약성이 있는 종속성 이용