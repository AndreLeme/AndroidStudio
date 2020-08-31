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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        EditText nameText = findViewById(R.id.name_input);
        String name = nameText.getText().toString();
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummary(name, price, hasWhippedCream, hasChocolate));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numbered) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numbered);
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
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     * @param whippedCream adds $1 to price if user checked it
     * @param chocolate adds $2 to price if user checked it
     * @return total price
     */
    private int calculatePrice(boolean whippedCream, boolean chocolate) {
        int price = 5;
        if (whippedCream) { price += 1; }
        if (chocolate) { price += 2; }
        return (quantity * price);
    }

    /**
     * Creates order summary.
     *
     * @param price of the order
     * @param addWhippedCream
     * @param addChocolate
     * @return text summary
     */



    private String createOrderSummary(String nameTextValue, int price, boolean addWhippedCream, boolean addChocolate) {

        String msg = "Name: " + nameTextValue;
        msg += "\nAdd whipped cream? " + addWhippedCream;
        msg += "\nAdd chocolate? " + addChocolate;
        msg += "\nQuantity: " + quantity;
        msg += "\nTotal: $" + price;
        msg += "\nThank you!";
        return msg;
    }
}