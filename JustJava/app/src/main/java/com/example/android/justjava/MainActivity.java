/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        // String priceMessage = "Amount due $" + price;
        // String priceMessage = "That would be $" + price + " please";
        // String priceMessage = "You owe " + price + " bucks, dude!";
        // String priceMessage = price + " dollars for " + quantity + " cups of coffee. Pay up";
        /**
        * String priceMessage = "Total= $" + price;
        * priceMessage = priceMessage + "\nThank you!";
        * displayMessage(priceMessage);
        **/
        displayMessage(createOrderSummary(price));

        //calculatePrice(quantity);
        //calculatePrice(quantity, 10);
        //calculatePrice();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numbered) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numbered);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method increments the quantity value on the screen.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity value on the screen.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Creates order summary.
     *
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price) {
        //String msg = "Name: Duh Durd" + "\nQuantity: " + quantity + "\nTotal: $" + calculatePrice() + "\nThank you!";
        String msg = "Name: Duh Durd";
        msg += "\nQuantity: " + quantity;
        msg += "\nTotal: $" + calculatePrice();
        msg += "\nThank you!";
        return msg;
    }
}