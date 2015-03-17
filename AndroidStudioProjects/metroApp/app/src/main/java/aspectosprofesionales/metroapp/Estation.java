package aspectosprofesionales.metroapp;

/**
 * Created by xabier on 17/03/15.
 */
public class Estation {
    private String name;
    private Line line1;
    private Line line2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Line getLine1() {
        return line1;
    }

    public void setLine1(Line line1) {
        this.line1 = line1;
    }

    public Line getLine2() {
        return line2;
    }

    public void setLine2(Line line2) {
        this.line2 = line2;
    }
}
