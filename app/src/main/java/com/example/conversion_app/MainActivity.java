package com.example.conversion_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RadioButton dinarToEuro , euroToDinar ;
    EditText entree;
    TextView sortie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entree = (EditText) findViewById(R.id.monnaie);
        sortie = (TextView) findViewById(R.id.resultat);

        euroToDinar = (RadioButton) findViewById(R.id.conv1);
        dinarToEuro = (RadioButton) findViewById(R.id.conv2);

        euroToDinar.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return false;
            }
        });

        dinarToEuro.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return false;
            }
        });

    }

    public void convertir(View v) {

        if (entree.getText().toString().equals("")) {
            AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Un champ incorrect");
            alertDialog
                    .setMessage("Il faut insérer un chiffre à convertir !!");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            });
            alertDialog.show();


        } else {
            float valeurInitiale = Float.valueOf(entree.getText().toString());

            float resultat;
            if (euroToDinar.isChecked()) {
                resultat = euroToDinar(valeurInitiale);
            } else {
                resultat = dinarsToEuro(valeurInitiale);
            }

            sortie.setText(String.valueOf(resultat));
        }
    }

    private float euroToDinar(float valeurEuro) {
        return (float) (valeurEuro * 3.14);
    }

    private float dinarsToEuro(float valeurDinar) {
        return (float) (valeurDinar * 0.31);
    }
}