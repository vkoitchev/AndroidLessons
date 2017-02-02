package com.example.o602593.lesson2;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int priceOfCoffee = 2;

    TextView quantityTextView;
    TextView priceTextView;
    Button increaseButton;
    Button decreaseButton;
    Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();
        installOnClickListeners();
        displayPrice(priceOfCoffee);
        display(quantity);
    }

    private void installOnClickListeners() {
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                display(quantity);
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity > 0) {
                    quantity--;
                    display(quantity);
                }
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitOrder();
            }
        });
    }

    public void submitOrder() {
        String priceMessage = "You owe " + (quantity * priceOfCoffee) + " quid, pal!";
        displayMessage(priceMessage);
    }

    private void display(int number) {
        quantityTextView.setText(String.valueOf(number));
    }

    private void displayPrice(int number) {
        priceTextView.setText("" + NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        priceTextView.setText(message);
    }

    private void findViewsById() {
        priceTextView = (TextView) findViewById(R.id.message_text_view);
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        increaseButton = (Button) findViewById(R.id.increaseButton);
        decreaseButton = (Button) findViewById(R.id.decreaseButton);
        orderButton = (Button) findViewById(R.id.order_button);
    }
}
