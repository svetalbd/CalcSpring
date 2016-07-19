/**
 * Created by Svitlana on 18.07.2016.
 */
public class PlusOperation implements BinaryOperation {
    @Override
    public double calculate(double firstVar, double secondVar) {
        return firstVar + secondVar;
    }

    @Override
    public boolean isBinary() {
        return true;
    }
}
