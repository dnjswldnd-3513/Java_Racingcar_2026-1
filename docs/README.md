## 과제 관련 기능목록 및 구현 방식

클래스 제작 : Race,Car

Race는 Racing의 대한 전반적인 기능들을 담당
Car는 전반적으로 자동차 자체의 기능 및 상태를 담당


> ()는 메서드, 아무것도 없으면 상태로 확인해주세요
## Car
    1. name : 이름
    2. stack : 자동차가 얼마나 갔는지를 확인하기 위해 
    3. action () : stack이 증가 및 유지관련 메서드
    4. toString() : Race관련 메세지를 출력해주는 메서드

## Race
    1. Race initCar() : 자동차 관련 세팅 메서드
    2. Race start() : 실제 로직
    3. Race initCount() : 몇번 돌지 등등 Race 관련 메서드
    4. carList : list race 상황중 값을 담기 위해
    5. final_victory : 이후 stream으로 값을 정리함
    6. race_count : 몇번 반복할지

## Main method
1. Race 호출

