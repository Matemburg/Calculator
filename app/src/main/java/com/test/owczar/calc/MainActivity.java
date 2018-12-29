package com.test.owczar.calc;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.mariuszgromada.math.mxparser.*;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    TextView Wynik;
    EditText editText;
    //private List<String> History;

    DatabaseHelper myDb;

    //public static final String EXTRA_MESSAGE = "Kalkulator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  History = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Wynik = findViewById(R.id.textView2);
        editText =  findViewById(R.id.editText);
        myDb = new DatabaseHelper(this);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
       // intent.putStringArrayListExtra("History", (ArrayList<String>) History);
        startActivity(intent);
    }


    public void doMath (View view) {
     //   EditText editText =  findViewById(R.id.editText);

        Expression math = new Expression(editText.getText().toString());
        Wynik.setText(String.valueOf(math.calculate()));
       // History.add(editText.getText().toString() + " = " + String.valueOf(math.calculate()) );

        if(myDb.insertData(editText.getText().toString()))
            Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
    }
}
