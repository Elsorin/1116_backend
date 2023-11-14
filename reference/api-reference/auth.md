# Auth

{% hint style="info" %}
[https://github.com/20230601sy/1116\_backend/blob/main/src/main/java/com/project /bank/config/SecurityConfig.java](../../src/main/java/com/project/bank/config/SecurityConfig.java)
{% endhint %}

```java
.antMatchers(HttpMethod.GET, 	"/", "/hasUser").permitAll()
.antMatchers(HttpMethod.POST, 	"/login").permitAll()

// WEBUSER, CUSTOMER, MANAGER, ADMIN

.antMatchers(HttpMethod.GET, 	"/user").authenticated()
.antMatchers(HttpMethod.POST, 	"/user").permitAll()
.antMatchers(HttpMethod.PUT, 	"/user").authenticated()
.antMatchers(HttpMethod.DELETE, "/user").authenticated()

.antMatchers(HttpMethod.GET, 	"/approval").hasRole("ADMIN")
.antMatchers(HttpMethod.POST, 	"/approval").hasRole("ADMIN")

.antMatchers(HttpMethod.GET, 	"/account/*").hasAnyRole("CUSTOMER", "MANAGER")
.antMatchers(HttpMethod.POST, 	"/account").hasRole("CUSTOMER")
.antMatchers(HttpMethod.POST, 	"/account/*").hasAnyRole("MANAGER")
.antMatchers(HttpMethod.DELETE, "/account/*").hasAnyRole("CUSTOMER")
.antMatchers(HttpMethod.DELETE, "/account/*/*").hasAnyRole("MANAGER")

.antMatchers(HttpMethod.GET, 	"/transaction/*").hasAnyRole("CUSTOMER", "MANAGER")
.antMatchers(HttpMethod.POST, 	"/transaction/*").hasAnyRole("CUSTOMER", "MANAGER")
.antMatchers(HttpMethod.PUT, 	"/transaction/*").hasAnyRole("CUSTOMER")

.antMatchers(HttpMethod.GET, 	"/qna").permitAll()
.antMatchers(HttpMethod.GET, 	"/qna/*").hasRole("ADMIN")
.antMatchers(HttpMethod.POST, 	"/qna").hasRole("ADMIN")
.antMatchers(HttpMethod.PUT, 	"/qna/*").hasRole("ADMIN")
.antMatchers(HttpMethod.DELETE, "/qna/*").hasRole("ADMIN")

.anyRequest().denyAll()
```

(TBD)
