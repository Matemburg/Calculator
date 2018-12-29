package com.test.owczar.calc;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    TextView history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        myDb = new DatabaseHelper(this);
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("ID: " + res.getString(0) + "\n");
            buffer.append("Expression: " + res.getString(1) + "\n");
        }
        history = findViewById(R.id.history);
        history.setMovementMethod(new ScrollingMovementMethod());
        history.append(buffer.toString());
    }

    public void clearHistory(View view) {
        myDb.deleteData();
        Toast.makeText(this, "History cleared", Toast.LENGTH_LONG).show();
        history.setText("Empty");

    }
}