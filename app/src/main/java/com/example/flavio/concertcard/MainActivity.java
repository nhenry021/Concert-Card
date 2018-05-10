package com.example.flavio.concertcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerTickets = 79.99;
    int numberOfTickets;
    double totalCost;
    String groupChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code to make the text field
        final EditText tickets = (EditText)findViewById(R.id.txtTickets);

        //Code for the Spinner
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);

        //Code for button
        Button cost = (Button)findViewById(R.id.btnCost);

        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View view) {
                //gets the number of tickets from input
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                //calculates the cost based on number use put in
                totalCost = numberOfTickets * costPerTickets;
                //gets the concert the user selected
                groupChoice = group.getSelectedItem().toString();
                //prints it out on the screen
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                result.setText("Cost for "+groupChoice+" is "+currency.format(totalCost));
            }
        });

    }
}
