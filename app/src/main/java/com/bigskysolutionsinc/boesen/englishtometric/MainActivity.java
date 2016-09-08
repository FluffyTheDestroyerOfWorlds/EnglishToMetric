package com.bigskysolutionsinc.boesen.englishtometric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String txtHoldNumber;
    String spinnerChoice;
    Double HoldNumber = 0.00;
    Double x;
    Integer NumberSpinner = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText initialNumber =(EditText)findViewById(R.id.nEnteredNumber);
        final Spinner conversionUnits = (Spinner)findViewById(R.id.spinner);


        Button convertedNumber = (Button)findViewById(R.id.btnConvert);
        convertedNumber.setOnClickListener(new View.OnClickListener() {

            final TextView result = ((TextView)findViewById(R.id.sAnswer));
            @Override
            public void onClick(View v) {
                txtHoldNumber = (initialNumber.getText().toString());
                if (! TextUtils.isEmpty(txtHoldNumber)){
                    HoldNumber = Double.parseDouble(txtHoldNumber);
                    spinnerChoice = conversionUnits.getSelectedItem().toString();
                    NumberSpinner = conversionUnits.getSelectedItemPosition();

                    switch (NumberSpinner) {
                        case 0:
                            x = HoldNumber * 2.5;
                            break;
                        case 1:
                            x = HoldNumber * 3.3;
                            break;
                        case 2:
                            x = HoldNumber * 1.6;
                            break;
                        default:
                            x = HoldNumber * 30;
                            break;
                    }
                    result.setText(HoldNumber + " "  + spinnerChoice + " is " + x);
                }

            }
        });
    }
}
