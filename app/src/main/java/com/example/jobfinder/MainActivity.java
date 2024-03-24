package com.example.jobfinder;

import static com.example.jobfinder.R.id.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {
    private Bdd bdd;
    private TextView toastTextView;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bdd = new Bdd(this);
        toastTextView = findViewById(erreur);
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showTextInToastTextView(String message) {

        toastTextView.setText(message);
    }

    public void Connecter(View view) {
        EditText emailEditText = findViewById(email);
        EditText motEditText = findViewById(password);

        String email = emailEditText.getText().toString();
        String password = motEditText.getText().toString();


        if (email.isEmpty() || password.isEmpty()) {
            showTextInToastTextView("Veuillez entrer votre email et mot de passe.");
            return;
        }


        boolean utilisateurExiste = bdd.verifierUtilisateur(email, password);

        if (utilisateurExiste) {

            showToast("Connexion réussie");


            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        } else {

            showTextInToastTextView("L'email ou le mot de passe saisi est incorrect.");
        }
    }

    public void InscriptionLink(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}