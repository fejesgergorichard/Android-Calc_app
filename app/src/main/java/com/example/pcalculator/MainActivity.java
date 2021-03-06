package com.example.pcalculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText edtEnterPercent;
    private EditText edtEnterNumber;
    private Button btnCalculate;
    private TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtEnterPercent = (EditText) findViewById(R.id.edtEnterPercent);
        edtEnterNumber = (EditText) findViewById(R.id.edtEnterNumber);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtResult = (TextView) findViewById(R.id.txtResult);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setTextColor(0xFF000000);
                try {
                    float percentValue = Float.parseFloat(edtEnterPercent.getText().toString()) / 100;
                    float numberValue = Float.parseFloat(edtEnterNumber.getText().toString());

                    float result = numberValue * percentValue;

                    txtResult.setText(Float.toString(result));
                } catch (NumberFormatException e) {
                    txtResult.setTextColor(0xFFFF0000);
                    txtResult.setText("Enter a valid number!");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
