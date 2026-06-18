# 📌 I로 만들기





## 🔗 문제 링크

- [코딩테스트 연습 - l로 만들기 | 프로그래머스 스쿨](https://school.programmers.co.kr/learn/courses/30/lessons/181834)
  
  

## 💡 문제 해결 전략

다음과 같이 입력 값 제한 사항이 있으므로,  

* `myString`은 알파벳 소문자로 이루어진 문자열입니다.

풀이 과정에서 toLowerCase()를 사용하거나 toUpperCase()를 사용할 필요는 없다.



그래서 문자열의 길이를 활용하여 for (int i=0; i < myString.length(); i++)로 변경했다.

그러나 myString[0]이 될 것 같았는데 에러가 발생했다.

문자열 중에 n번째 문자를 가져오는 메서드의 이름이 기억이 나지 않았고,

IDE를 켜서 String 타입이 사용 가능한 메서드 중에서 char str2 = str.charAt(0); 를 찾을 수 있었다.



if ( myString.charAt(i) > 'l' ) 이게 앞서는 문자열인 경우라고 생각했는데 테스트 케이스 결과가 잘못되었다.

그래서 해당 부분을 if ( myString.charAt(i) < 'l' )로 고치니까 되었다.

아스키 코드는 a가 z보다 작아서 그런 것인지 나중에 확인해봐야 겠다.



<!-- 문제를 어떻게 접근했는지, 어떤 알고리즘/자료구조를 사용했는지 적어주세요 -->

<!-- 그림이나 예시를 들어 설명하면 나중에 복습할 때 좋습니다 -->

## 💻 코드

```java
class Solution {
    public String solution(String myString) {
        // 입력값 검증
        if(myString == null || "".equals(myString.trim())) {
            return myString;
        }

        // 최종 반환 값
        String answer = "";

        // 각 문자의 크기 비교 후 anwer에 추가
        for (int i=0; i < myString.length(); i++) {
            if ( myString.charAt(i) < 'l' ) {
                // 알파벳 순서에서 l보다 앞서는 모든 문자를 l로 바꾸기
                answer += 'l';
            } else {
                // 그 외 문자는 유지
                answer += myString.charAt(i);
            }
        } // for

        return answer;
    }
}
```



## 📝 비고

<!-- 풀면서 겪은 어려운 점, 주의해야 할 점, 못 풀었다면 왜 못 풀었는지 등 생각나는 것을 자유롭게 적어주세요. 없으면 생략 가능합니다 -->

<!-- ⚠️ 답을 봤다면 반드시 "답을 봤다"고 적어주세요! (복습 및 자가 점검용) -->

- [ ] 스스로 해결
- [x] 스스로 해결 (IDE 활용)
- [ ] 답을 보고 해결
- [ ] 못 풀었음
  
  

다른 사람의 풀이를 보니,

다음과 같이 toCharArray()를 사용하면 String 을 char의 배열로 바꿀 수 있다.

```java
for (char c : myString.toCharArray()) {
```



아스키 코드 변환 사이트([ASCII 코드 변환 - 진수 변환 - 계산 사이트](https://ko.calc-site.com/bases/ascii))에서

"azAZㄱㅎ"를 변환한 결과는 다음과 같다.



| 문자  | ASCII/Unicode 값 |
| --- | --------------- |
| a   | 97              |
| z   | 122             |
| A   | 65              |
| Z   | 90              |
| ㄱ   | 12593           |
| ㅎ   | 12622           |



이에 따라 if ( myString.charAt(i) < 'l' ) { 를 사용하는게 맞음을 확인하였다.


