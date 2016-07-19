
/**
 * Created by Svitlana on 18.07.2016.
 */
public class Multiply implements BinaryOperation {
    public double calculate(double v, double v1) {
        return v * v1;
    }

    public boolean isBinary() {
        return true;
    }
}
