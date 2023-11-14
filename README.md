# Welcome!

## Welcome to Ezen Bank

Welcome to Ezen Bank! Here you'll find all the documentation you need to get up and running with the Ezen Bank API.

{% hint style="info" %}
**Good to know:** This document is more readily _available on the web:_

[https://20230601sy.gitbook.io/1116\_backend/](https://20230601sy.gitbook.io/1116\_backend/)
{% endhint %}

## Want to jump right in?

Feeling like an eager beaver? Jump in to the quick start docs and get making your first request:

{% content-ref url="quick-start.md" %}
[quick-start.md](quick-start.md)
{% endcontent-ref %}

## Want to deep dive?

Dive a little deeper and start exploring our API reference to get an idea of everything that's possible with the API:

{% content-ref url="reference/api-reference/" %}
[api-reference](reference/api-reference/)
{% endcontent-ref %}

***

## Here's what we did last month

{% hint style="info" %}
[https://github.com/20230601sy/1020\_backend](https://github.com/20230601sy/1020\_backend)
{% endhint %}

## Getting Started with STS

This project was coded with STS, JAVA JDK 11 with some libraries\
(spring web, devtools, security, lombok, jdbc, jpa, gson, jwt)\
with Oracle DB (changed to use PostgreSQL)\
rootProject.name = '1020\_backend'

## Available Scripts

구현 기능 (POSTMAN까지 확인 완료)\
\-. 회원가입, 로그인, 계좌, 거래, QnA\
\-. 회원가입 시 id 중복 체크\
\-. 회원가입 직후 Role은 WEBUSER로 자동 설정\
\-. ADMIN이 CUSTOMER로 변경해야 계좌 개설 등 은행 기능 이용 가능\
\-. 로그인된 회원에 대한 본인 정보 조회, 수정, 탈퇴\
\-. 계좌 조회, 계좌 개설, 계좌 해지\
\-. QnA 조회는 전체 가능, 등록, 수정, 삭제는 ADMIN만 가능

## List

1. 거래 적용 → 계좌, 거래 with manager
2. security config uri 권한 확인
3. login 유지 시간 확인!!! 마이페이지 → 정보수정
4. user detail impl - role 반환 수정
5. 모든 data 개인정보 암호화
6. 계좌 0원일 때만 해지하고 0원이 아닐 경우 다른 계좌에 이체하고 해지하거나 출금 후 해지 유도
7. 함수명, uri 정리, user, checkUser 변경
8. .get()s 처리, return type 정리해서 경우의 수 state diagram 정리 후 handling
9. 최대 개설 가능한 계좌 개수 제한
10. 계좌 이체 (-) 금액 불가능하도록... DTO?
11. 로그인 후 들어갈 수 있는 페이지 구분 @front, isAuth state 구분
12. 아이디, 비밀번호 찾기, modal design
13. paging 처리
14. MANAGER가 CUSTOMER 개인정보 조회를 하기 위한 인증 프로세스? ㅡ\_ㅡ
15. MANAGER 월말 결산 이자 지급 ㅡ\_ㅡ
16. financial product id ... 🤬
17. 로그인 자동저장, 마이페이지 성별 사진 바꾸기
18. Container, make Tables, 환율 계산 기능 (front)
19. 해지된 계좌 기록 처리...남겨야 하지 않을까...
20. img assets, 마이페이지 링크 수정

## Memo

거래\
\-. 화면에 사용자가 입력하는 건 무조건 받는 사람 계좌번호임\
\-. 보내는 사람 계좌 번호도 저장은 해놔야 함\
\-. A → B 의 직접 거래보다는 A → 은행, 은행 → B의 2 steps로 분리\
\-. A, B는 entity에 저장하지 않도록 @Transient 처리\
\-. 거래 type 지정으로 방향 지정하기로 함\
근데 모든 거래를 은행이 개설한 대표 계좌(?)를 경유해야 하는 게 되는 건가 흐음...\
뭐... log 남기는 걸 은행 계좌에 남기게 되는 셈인감...

모든 Role... 은 걍 한눈에 보기 편하려고 SecurityConfig에서 먼저 거르는 작업을 하는 것으로 변경\
세부적인 조건이 필요한 거는...물론 @PreAuthroize("hasRole('ROLE\_USER') and (#account.username == principal.username)") 요딴식이 좀더 편하겠지만...

## History

1. 정보수정 front에서 값 입력이 왜 안될까?\
   값을 입력하는 것만 수정하도록 방식 바꿔야 할지 아니면 수정이 가능한지 확인해볼 것...\
   userInfo → user (state 해결)
2. Pattern 관점에서 Controller Service 영역 구분 및 handling\
   backend가 frontend와의 대화는 message로 하는 게 아니라 status로 하면 된다는 사실에...\
   생각이 좀 정리된 듯\
   data를 보내야 하는 거는 보내야할 data 타입을 리턴하고, \
   데이터를 수반하지 않은 경우는 경우의 수 int가 용이\
   frontend에서 고민해야 할일을 괜히 하는 척 오지랖 ㄴㄴ

### Q

security test 순서

***

## Useful Links

{% embed url="https://www.gitbook.com/" %}

Move to Frontend side

{% embed url="https://getbootstrap.kr/docs/5.3/getting-started/introduction/" %}

{% embed url="https://www.canva.com/" %}

(TBD)
