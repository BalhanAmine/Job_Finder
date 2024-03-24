package com.example.jobfinder;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        String selectedVille = getIntent().getStringExtra("selectedVille");


        int countAnnonces = new Bdd(this).getCountAnnoncesByVille(selectedVille);


        TextView textViewMsg = findViewById(R.id.message);
        String message = "Il y'a actuellement  " + countAnnonces + "annonce(s) sur " + selectedVille;
        textViewMsg.setText(message);
    }
}