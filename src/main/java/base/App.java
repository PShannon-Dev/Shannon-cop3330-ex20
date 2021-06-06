package base;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class App {
    Scanner input = new Scanner(System.in);
    Scanner county = new Scanner(System.in);

    public static void main(String[] args) {
        //instances
        App myApp = new App();
        TaxCalculator calc = new TaxCalculator();

        //input
        myApp.input(calc);

        //output
        myApp.print_total(calc);
    }

    public void input(TaxCalculator calculator)
    {
        //take input for order amount and state/county lived in
            System.out.print("What is the order amount? ");
            calculator.setOrder(input.nextBigDecimal());

            System.out.print("What state do you live in? ");
            calculator.setState(input.next().toUpperCase());

            System.out.print("What county do you live in? ");
            calculator.setCounty(county.nextLine().toUpperCase());

    }

    public void print_total(TaxCalculator calculator)
    {
        //calculate tax and total then print
        calculator.decideTax();
        calculator.calculateTotal();

        //string builder for one output
        StringBuilder b = new StringBuilder();

        DecimalFormat df = new DecimalFormat("$0.00");
        if((calculator.getState().equals("WISCONSIN") || calculator.getState().equals("ILLINOIS")))
            b.append("The tax is " + df.format(calculator.taxValue) + ".\nThe total is " + df.format(calculator.total));
        else
            b.append("The total is " + df.format(calculator.total));
        System.out.println(b);
    }
}
