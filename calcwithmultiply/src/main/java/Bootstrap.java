import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;



/**
 * Created by Svitlana on 18.07.2016.
 */
public class Bootstrap {
    private Logger logger = Logger.getLogger(Bootstrap.class.getName());

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
        logger.info("New request: "+ expression);
        if (expression.contains("sqrt")){
            expression = expression.replaceAll("sqrt", "s");
        }
        calculatorWithOperations.returnResult(expression);
        //System.out.println(calculatorWithOperations.returnResult(expression));
        logger.info("Successful calculation");
    }

//    private static void log() throws IOException {
//
//        Logger logger = Logger.getLogger("");
//        FileHandler handler = new FileHandler("TestLog.log");
//        handler.setLevel(Level.ALL);
//        handler.setFormatter(new SimpleFormatter());
//        logger.addHandler(handler);
//    }

}
