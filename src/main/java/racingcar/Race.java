package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Race {

    private List<Car> carList;
    private int raceCount;

    public Race() {
    }

    public void start(){
        initCar();
        initRace();
    }

    private void initCar() {
        carList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        for(String t : Console.readLine().trim().split(",")){
            Car car = new Car(t);
            if (carList.stream().anyMatch(c -> c.getName().equals(t.trim()))){
                throw new IllegalArgumentException();
            }
            carList.add(car);
        }
    }

    private void initRace() {
        System.out.println("시도할 회수는 몇회인가요?");

        raceCount = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        if (raceCount <= 0){
            throw new IllegalArgumentException();
        }
        raceStart();
    }

    private void raceStart() {
        System.out.println("실행 결과");

        for (int i = 0; i < raceCount; i++) {
            carList.forEach(v -> {
                v.action() ;
                System.out.println(v.toString());
            });
        }

        int maxStack = carList
                .stream()
                .mapToInt(f -> f.getStack())
                .max()
                .getAsInt();

        String finalVictory =  carList
                .stream()
                .filter(f -> f.getStack() == maxStack)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + finalVictory);
    }

}
