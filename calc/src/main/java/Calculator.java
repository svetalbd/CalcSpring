/**
 * Created by Svitlana on 18.07.2016.
 */
public interface Calculator {
    public void readExpression(String expression);
    public void chooseOperation(Character operation, Operation newOperation);
    public void returnResult(String expression);
}
