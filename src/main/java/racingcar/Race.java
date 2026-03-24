package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Race {

    private List<Car> carList;
    private int race_Count;

    public Race() {
    }

    public void start(){
        initCar();
        initRace();
    }

    private void initRace() {
    }

    private void initCar() {
        carList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String text = camp.nextstep.edu.missionutils.Console.readLine();

        for(String t : text.trim().split(",")){
            if (!t.equals(t.trim())) throw new IllegalArgumentException("이름에 공백이 포함되었습니다.");

            if (carList.stream().anyMatch(c -> c.getName().equals(t.trim()))){
                throw new IllegalArgumentException();
            }

            if(t.length() > 5){
                throw new IllegalArgumentException("이름의 길이가 잘못되었습니다.");
            }
            Car car = new Car(t.trim());
            carList.add(car);
        }
    }


}
