package pl.maciek_rychlinski.model;

import pl.maciek_rychlinski.constraint.Divided;

import javax.validation.constraints.Min;

public class NumberBean {

    @Divided(by = 3)
    @Min(value = 3)
    private int number;

    public NumberBean(@Min(value = 3) int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
