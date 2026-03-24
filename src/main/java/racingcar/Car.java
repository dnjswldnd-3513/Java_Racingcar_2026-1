package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.IntStream;

public class Car {

    private String name;
    private int stack;

    public Car(String name) {
        if (name.isBlank()) throw new IllegalArgumentException();
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public int getStack() {
        return stack;
    }


    public void action(){
        int ck = Randoms.pickNumberInRange(0,9);
        if (ck >= 4){
            stack++;
        }
    }

    @Override
    public String toString() {
        return name+" : "+ "-".repeat(stack);
    }
}
