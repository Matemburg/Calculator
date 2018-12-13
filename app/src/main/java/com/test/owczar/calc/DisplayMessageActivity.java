package com.test.owczar.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        ArrayList<String> History = getIntent().getStringArrayListExtra("History");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        String message = "";
        for (int i=0;i<History.size();i++)
            message=message+History.get(i)+"\n";
        textView.setText(message);

    }
}
