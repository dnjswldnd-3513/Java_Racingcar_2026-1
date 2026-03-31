package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.IntStream;

public class Car {

    private String name;
    private int stack;

    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("길이");
        if (!name.equals(name.trim())) throw new IllegalArgumentException("이름에 공백이 포함되었습니다.");
        if (name.isBlank()) throw new IllegalArgumentException("빈칸");
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public int getStack() {
        return stack;
    }


    public void action(){
        if (Randoms.pickNumberInRange(0,9) >= 4){
            stack++;
        }
    }

    @Override
    public String toString() {
        return name+" : "+ "-".repeat(stack);
    }
}
