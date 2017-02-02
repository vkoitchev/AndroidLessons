package com.example.o602593.lesson2;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int priceOfCoffee = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPrice(priceOfCoffee);
        display(quantity);
    }

    public void increment (View view)
    {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement (View view)
    {
        if (quantity > 0) {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    public void submitOrder(View view)
    {
        String priceMessage = "You owe " + (quantity * priceOfCoffee) + " quid, pal!";
        displayMessage(priceMessage);
    }

    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("Price: " + NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message)
    {
        TextView priceTextView = (TextView) findViewById(R.id.message_text_view);
        priceTextView.setText(message);
    }
}
