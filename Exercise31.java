/**
 * Created by lytte on 6/28/2016.
 * Exercise 3.31 from textbook, FX edition
 *
 * Goals of program:
 * Ask for the user to enter exchange rate through label and TextField
 * Label and TextField to get a 0 || 1 use a switch statement
 * Prompt for an amount to convert, determine from above switch,
 *
 * Button takes in information, calls a method, and posts it.
 */
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise31 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Scene origin;
    Stage originWindow;
    //the above variables are for the GridPane below


    @Override
    public void start(Stage primaryStage) throws Exception {
        originWindow=primaryStage;

        Label exchange = new Label("Enter the exchange rate.");
        TextField exchangeValue = new TextField();
        //The above are for exchange rate
        Label rmbSwitch = new Label("Enter 1 if USD > rmb, 0 if RMB > USD");
        TextField rmbUS = new TextField();
        //the above are for the switch statement
        Label dollars = new Label("Amount to be exchanged");
        TextField amount = new TextField();
        //the above are for amount to be transfered
        Label out = new Label("Output: ");
        Text outPut = new Text();
        Button calculate = new Button("exchange");
        //the above are the multiple outputs


            calculate.setOnAction(e -> {
                String exchangeVString, rmbUSString, amountString;
                double exchangeVDouble, amountDouble;
                byte rmbUSByte;
                exchangeVString = exchangeValue.getText();
                rmbUSString = rmbUS.getText();
                amountString = amount.getText();

                try {
                    exchangeVDouble = Double.parseDouble(exchangeVString);
                    rmbUSByte = Byte.valueOf(rmbUSString);
                    amountDouble = Double.parseDouble(amountString);
                    String toFX = valueExchange(exchangeVDouble, rmbUSByte, amountDouble);
                    outPut.setText(toFX);
                }catch(NumberFormatException e1) {
                 outPut.setText("incorrect values");
                }
            });



        GridPane gridA = new GridPane();
        gridA.setAlignment(Pos.CENTER);
        gridA.setPadding(new Insets(10,10,10,10));
        gridA.setVgap(10);
        gridA.setHgap(5);
        //position and rules for the placement of items inside gridA
        gridA.add(exchange, 0,0);
        gridA.add(exchangeValue, 1, 0);
        gridA.add(rmbSwitch, 0, 1);
        gridA.add(rmbUS, 1, 1);
        gridA.add(dollars, 0, 2);
        gridA.add(amount, 1, 2);
        gridA.add(calculate, 0, 4);
        gridA.add(out, 0, 5);
        gridA.add(outPut, 1, 5);
        origin = new Scene(gridA, 500, 400);
        //sets the size of the window and Scene
        originWindow.setScene(origin);
        //sets the Scene
        originWindow.show();
        //shows the window
    }
    public static String valueExchange(double exchangeRate, byte usdRMB , double amount) {
        double finValue;
        String stated=("error, only 0 or 1");
        switch(usdRMB){
            case 0: //is the case for US to Chinese, changes text.
                finValue = exchangeRate*amount;
                //adjusted amount for inputed amount Multiplied by exchange rate.
                stated= ("US currency to Chinese is: " + amount + " to "  + finValue);
                return stated;
            case 1: //is the Case for Chinese to US, changes text
                finValue = exchangeRate*amount;
                //adjusted amount for inputed amount Multiplied by exchange rate.
                stated=("Chinese currency to US currency is: " + amount + " to " + finValue);
                return stated;
            default: //returns an error message
                return stated;
        }

    }
}
