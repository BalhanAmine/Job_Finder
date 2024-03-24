package com.example.jobfinder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Spinner spinnerCategorie, spinnerSecteur, spinnerVille;
    private EditText editTextTitre, editTextDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinnerCategorie = findViewById(R.id.categorierspinner);
        spinnerSecteur = findViewById(R.id.secteurspinner);
        spinnerVille = findViewById(R.id.villespinner);
        editTextTitre = findViewById(R.id.titreinput);
        editTextDescription = findViewById(R.id.descriptioninput);

        String[] categories = {"Informatique et Technologies", "Vente et Marketing", "Santé et Médical", "Juridique"};
        ArrayAdapter<String> categorieAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinnerCategorie.setAdapter(categorieAdapter);

        String[] secteurs = {"Public", "Privé"};
        ArrayAdapter<String> secteurAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, secteurs);
        spinnerSecteur.setAdapter(secteurAdapter);

        String[] villes = {"Agadir", "Casablanca", "Tanger", "Marrakech", "Rabat"};
        ArrayAdapter<String> villeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, villes);
        spinnerVille.setAdapter(villeAdapter);

        Button buttonSuivant = findViewById(R.id.suivant);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titre = editTextTitre.getText().toString();
                String description = editTextDescription.getText().toString();
                String categorie = spinnerCategorie.getSelectedItem().toString();
                String secteur = spinnerSecteur.getSelectedItem().toString();
                String ville = spinnerVille.getSelectedItem().toString();

                long result = new Bdd(MainActivity2.this).addAnnonce(titre, categorie, secteur, description, ville);

                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("selectedVille", ville);
                startActivity(intent);
            }
        });
    }
}