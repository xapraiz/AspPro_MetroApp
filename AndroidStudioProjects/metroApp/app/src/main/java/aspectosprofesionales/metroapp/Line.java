package aspectosprofesionales.metroapp;


import java.util.Date;

/**
 * Created by xabier on 17/03/15.
 */
public class Line {
    private Date leftFirst;
    private int leftFrecuency;
    private Date rightFirst;
    private int rightFrecuency;

    public Date getLeftFirst() { return leftFirst;  }

    public void setLeftFirst(Date leftFirst) {
        this.leftFirst = leftFirst;
    }

    public int getLeftFrecuency() {
        return leftFrecuency;
    }

    public void setLeftFrecuency(int leftFrecuency) {
        this.leftFrecuency = leftFrecuency;
    }

    public Date getRightFirst() {
        return rightFirst;
    }

    public void setRightFirst(Date rightFirst) {
        this.rightFirst = rightFirst;
    }

    public int getRightFrecuency() {
        return rightFrecuency;
    }

    public void setRightFrecuency(int rightFrecuency) {
        this.rightFrecuency = rightFrecuency;
    }
}
