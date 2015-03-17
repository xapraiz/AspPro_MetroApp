package aspectosprofesionales.metroapp;

import android.text.format.Time;

/**
 * Created by xabier on 17/03/15.
 */
public class Line {
    private Time leftFirst;
    private int leftFrecuency;
    private Time rightFirst;
    private int rightFrecuency;

    public Time getLeftFirst() {
        return leftFirst;
    }

    public void setLeftFirst(Time leftFirst) {
        this.leftFirst = leftFirst;
    }

    public int getLeftFrecuency() {
        return leftFrecuency;
    }

    public void setLeftFrecuency(int leftFrecuency) {
        this.leftFrecuency = leftFrecuency;
    }

    public Time getRightFirst() {
        return rightFirst;
    }

    public void setRightFirst(Time rightFirst) {
        this.rightFirst = rightFirst;
    }

    public int getRightFrecuency() {
        return rightFrecuency;
    }

    public void setRightFrecuency(int rightFrecuency) {
        this.rightFrecuency = rightFrecuency;
    }
}
