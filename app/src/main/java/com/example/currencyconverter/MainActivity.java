package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunction(View view) {
        EditText myTextField = (EditText) findViewById(R.id.myTextField);
        String str = myTextField.getText().toString();

        goToActivity2(str);
    }

    public void goToActivity2(String s) {
        boolean numGiven = true;
        double num = 0.0;
        try {
            num = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            numGiven = false;
            s = "Insert a number";
        }
        if (numGiven) {
            num = num * .77;
            s = String.valueOf(num);
        }
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }
}
