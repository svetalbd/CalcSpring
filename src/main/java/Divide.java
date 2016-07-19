/**
 * Created by Svitlana on 18.07.2016.
 */
public class Divide implements BinaryOperation {
    @Override
    public double calculate(double v, double v1) {
        return v / v1;
    }

    @Override
    public boolean isBinary() {
        return true;
    }
}
