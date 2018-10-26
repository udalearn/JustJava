/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(numberOfCoffees);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_check_box);

        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        int price = calculatePrice();

        String summaryMessage = createOrderSummary(price, hasWhippedCream);
        displayMessage(summaryMessage);

        //String priceMessage = "Total = $" + price;
        //priceMessage = priceMessage + "\nThank you!";
        //displayMessage(priceMessage);
        //display(numberOfCoffees);
        //displayPrice(numberOfCoffees * 5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method increases the number of coffees to order by 1.
     */
    public void incrementQuantity(View view) {
        if(numberOfCoffees == 0){
            enableOrder(true);
        }

        numberOfCoffees = numberOfCoffees + 1;
        displayQuantity(numberOfCoffees);
    }

    /**
     * This method decreases the number of coffees to order by 1.
     */
    public void decrementQuantity(View view) {
        if (numberOfCoffees > 0) {
            numberOfCoffees = numberOfCoffees - 1;
            displayQuantity(numberOfCoffees);
        }

        if(numberOfCoffees == 0) {
            enableOrder(true);
        }
    }


    /**
     * This method enables or disables the order button.
     */
    private void enableOrder(boolean bool) {
        Button orderButton = (Button) findViewById(R.id.order_button);
        orderButton.setEnabled(bool);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method calculates the price of the coffee order
     */
    private int calculatePrice(){
        int price = numberOfCoffees * 5;
        return price;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream){
        String message;

        message = "Name: Kwontum Kwon\n" +
                "Add whipped cream? " + hasWhippedCream + "\n" +
                "Quantity: " + numberOfCoffees + "\n" +
                "Total: $" + price + "\n" +
                "Thank you!";
        return message;
    }

}
