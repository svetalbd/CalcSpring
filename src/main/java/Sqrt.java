/**
 * Created by Svitlana on 19.07.2016.
 */
public class Sqrt implements UnaryOperation{
    @Override
    public double calculate(Double aDouble) {
        return Math.sqrt(aDouble);
    }

    @Override
    public boolean isBinary() {
        return false;
    }
}
