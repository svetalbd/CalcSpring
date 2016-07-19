import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by Svitlana on 18.07.2016.
 */
public class Bootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();
    }

    public void execute(){
        CalculatorImpl calculatorWithOperations = new CalculatorImpl();
        calculatorWithOperations.chooseOperation('*', new Multiply());
        calculatorWithOperations.chooseOperation('/', new Divide());
        calculatorWithOperations.chooseOperation('s', new Sqrt());
        System.out.println("Enter your expression, please, without spaces and brackets: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        if (expression.contains("sqrt")){
            expression = expression.replaceAll("sqrt", "s");
        }
        System.out.println(calculatorWithOperations.returnResult(expression));
    }

}
