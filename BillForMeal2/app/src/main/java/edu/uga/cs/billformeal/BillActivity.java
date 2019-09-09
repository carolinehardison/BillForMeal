package edu.uga.cs.billformeal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This class connects the UI to the Java Logic
 */
public class BillActivity extends AppCompatActivity {

    EditText amount;
    EditText partySize;
    Button unhappyTip, okTip, happyTip;
    TextView finalAmount;


    /**
     *
     * @param savedInstanceState bundles the data if we were to have opened the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        //obtaining references to UI Components
        amount = findViewById(R.id.amount);
        partySize = findViewById(R.id.partySize);
        unhappyTip = findViewById(R.id.unhappyTip);
        okTip = findViewById(R.id.okTip);
        happyTip = findViewById(R.id.happyTip);
        finalAmount = findViewById(R.id.finalAmount);

        //setting button listeners

        /*
         * I created button listener references so I could
         * reuse the same private listener class
         * rather than typing out 3 separate Listeners
         */
        TipClickListener unhappy = new TipClickListener();
        unhappy.setTip(1.1);
        unhappyTip.setOnClickListener(unhappy);

        TipClickListener ok = new TipClickListener();
        ok.setTip(1.15);
        okTip.setOnClickListener(ok);

        TipClickListener happy = new TipClickListener();
        happy.setTip(1.18);
        happyTip.setOnClickListener(happy);

    }

    /**
     * This class is my button listener
     * Before you can use the onClick Method, you must set the tip value
     */
    private class TipClickListener implements View.OnClickListener {

        private double amt;
        private int party;
        private double tip;

        public void setTip(double tip){
            this.tip = tip;
        }

        @Override
        public void onClick(View v) {

            try{
                party = Integer.parseInt(partySize.getText().toString());
            }catch ( NumberFormatException nfe){
                party = 1;
            }

            try{
                amt = Double.parseDouble(amount.getText().toString());
            }catch ( NumberFormatException nfe){
                amt = 0;
            }finally {
                finalAmount.setText(Calculate.CalculateBill(amt, party, tip));
            }


        }
    }

}
