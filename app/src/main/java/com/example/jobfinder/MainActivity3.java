package com.example.jobfinder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Spinner villeSpinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        villeSpinner = findViewById(R.id.villespinner2);


        String[] villes ={"Agadir", "Casablanca", "Tanger", "Marrakech", "Rabat"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity3.this, android.R.layout.simple_spinner_item, villes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        villeSpinner.setAdapter(adapter);

        Button createAccountButton = findViewById(R.id.creercomptebtn);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();
                String ville = villeSpinner.getSelectedItem().toString();


                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                long newRowId = new Bdd(MainActivity3.this).addUser(email, password, ville);
                if (newRowId != -1) {
                    Toast.makeText(MainActivity3.this, "Utilisateur créé avec succès", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity3.this, MainActivity.class));
                } else {
                    Toast.makeText(MainActivity3.this, "Erreur lors de la création de l'utilisateur", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}