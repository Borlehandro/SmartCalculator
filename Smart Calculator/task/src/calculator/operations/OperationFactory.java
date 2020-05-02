package calculator.operations;

import calculator.exceptions.ExpressionFormatException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class OperationFactory {

    public static Operation create(String symbol) throws ExpressionFormatException {
        Properties properties = new Properties();
        try {

            // System.err.println(symbol);

            InputStream in = new FileInputStream("C:\\Users\\Alehandro\\IntelliJIDEAProjects\\JavaLessons\\Smart Calculator\\Smart Calculator\\task\\src\\operation.properties");
            properties.load(in);
            String className = properties.getProperty(symbol);

            if(className == null)
                throw new ExpressionFormatException();
            else return (Operation) Class.forName(className).getConstructor().newInstance();

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            throw new ExpressionFormatException(e);
        }
    }

}