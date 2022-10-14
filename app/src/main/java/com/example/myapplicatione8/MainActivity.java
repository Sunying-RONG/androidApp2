package com.example.myapplicatione8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String mont_paris[] = {
            "06:08 -> 11:00  4h51 ",
            "08:57 -> 12:46  3h48",
            "11:27 -> 15:46  4h19",
            "12:57 -> 16:46  3h49",
            "14:57 -> 18:46  3h48",
            "16:57 -> 20:46  3h49",
            "17:37 -> 21:47  4h09",
            "18:24 -> 22:50  4h26"
    };
    String mont_lyon[] = {
            "05:03 -> 07:20  2h17",
            "06:08 -> 08:25  2h17",
            "06:20 -> 09:54  3h33",
            "06:20 -> 10:40  4h19"
    };
    String msg_warning[] = {
            "Please input available cities."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitCity(View view) {
        EditText depart_city_input = findViewById(R.id.dc);
        String depart_city = depart_city_input.getText().toString();

        EditText arrival_city_input = findViewById(R.id.ac);
        String arrival_city = arrival_city_input.getText().toString();

        String[] msg_display = testCity(depart_city, arrival_city);

        StringBuilder msgBuilder = new StringBuilder();
        for (String s : msg_display) {
            msgBuilder.append(s + "\n");
        }
        ListView horaire_list = findViewById(R.id.horaire_list);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.simple_row, R.id.textView, msg_display);

        horaire_list.setAdapter(listAdapter);

    }

    public String[] testCity(String dc, String ac) {
        if (dc.equals("Montpellier") && ac.equals("Paris")) {
            return mont_paris;
        } else if (dc.equals("Montpellier") && ac.equals("Lyon")) {
            return mont_lyon;
        } else {
            return msg_warning;
        }
    }
}