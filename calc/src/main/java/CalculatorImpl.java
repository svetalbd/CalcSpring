import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Svitlana on 18.07.2016.
 */
public class CalculatorImpl implements Calculator{
    private HashMap<Character, Operation> operators = new HashMap<>();
    {
        operators.put('+', new PlusOperation());
        operators.put('-', new MinusOperation());
    }

    protected StringBuilder firstVar = new StringBuilder();
    protected StringBuilder secondVar = new StringBuilder();
    protected StringBuilder result = new StringBuilder(" = ");
    BinaryOperation binaryOperation;
    UnaryOperation unaryOperation;

    @Override
    public void readExpression(String expression) {
        List<String> listOfConversationsToRPN = new ArrayList<String>();
        char operation;
        boolean firstIsRead = false;
        boolean secondIsRead = false;
        char currentChar;

        expression = expression.replaceAll(" ", "");
        expression = expression.replaceAll(",", ".");
        expression = expression.toLowerCase();

        for (int i = 0; i < expression.length(); i++){
            currentChar = expression.charAt(i);
            if (operators.containsKey(currentChar)) {
                if (operators.get(currentChar).isBinary()) {
                    binaryOperation = (BinaryOperation) operators.get(currentChar);
                } else {
                    unaryOperation = (UnaryOperation) operators.get(currentChar);
                }
                firstIsRead = true;
            } else {
                if (!firstIsRead){
                    firstVar.append(currentChar);
                } else {
                    secondVar.append(currentChar);
                }
            }
        }

    }

    @Override
    public void chooseOperation(Character operation, Operation newOperation) {
        operators.put(operation, newOperation);

    }

    @Override
    public void returnResult(String expression) {
        readExpression(expression);
        if (unaryOperation != null && secondVar.toString() != ""){
            result.append(unaryOperation.calculate(Double.valueOf(secondVar.toString())));
        } else if (binaryOperation != null && secondVar.toString() != ""){
            if (firstVar.toString() == ""){
                firstVar.append(0);
            }
            result.append(binaryOperation.calculate(Double.valueOf(firstVar.toString()), Double.valueOf(secondVar.toString())));
        }
        System.out.println(result.toString());
        //return result.toString();
    }
}
