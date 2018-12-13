package com.test.owczar.calc;

import android.animation.TypeConverter;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView Wynik;
    EditText editText;private List<String> History;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        History = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Wynik = findViewById(R.id.textView2);
        editText =  findViewById(R.id.editText);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putStringArrayListExtra("History", (ArrayList<String>) History);
        startActivity(intent);
    }


    public void doMath (View view) {
     //   EditText editText =  findViewById(R.id.editText);

        Expression math = new Expression(editText.getText().toString());
        Wynik.setText(String.valueOf(math.calculate()));
        History.add(editText.getText().toString() + " = " + String.valueOf(math.calculate()) );
    }
}
