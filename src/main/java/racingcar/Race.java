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
    private void initRace() {
        System.out.println("시도할 회수는 몇회인가요?\n");

        race_Count = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        if (race_Count <= 0){
            throw new IllegalArgumentException();
        }
        raceStart();
    }

    private void raceStart() {
        System.out.println("실행 결과");
        for (int i = 0; i < race_Count; i++) {
            carList.forEach(v -> v.action());
            carList.forEach(v -> System.out.println(v.toString()));
            System.out.println();
        }

        int maxStack = carList.stream().mapToInt(f -> f.getStack()).max().getAsInt();

        String final_victory =  carList.stream()
                .sorted((e1,e2) -> Integer.compare(e2.getStack(),e1.getStack()))
                .filter(f -> f.getStack() == maxStack)
                .map(Car::getName).collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + final_victory);
    }

}
