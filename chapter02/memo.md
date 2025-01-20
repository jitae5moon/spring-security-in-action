# Chapter02

### HTTP Basic인증을 이용한 엔드포인트 호출(RFC 7617 참고)
1. `<username>:<password>` 문자열을 Base64로 인코딩
2. 인코딩 된 문자열에 `Basic`을 붙이고 Authorization header 값으로 사용

## 자동으로 구성되는 Bean
* UserDetailsService
* PasswordEncoder
  * 암호를 인코딩한다.
  * 암호가 기존 인코딩과 일치하는지 확인한다.