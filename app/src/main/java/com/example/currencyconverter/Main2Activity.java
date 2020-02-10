package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        textView2.setText(str + " pounds");
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
