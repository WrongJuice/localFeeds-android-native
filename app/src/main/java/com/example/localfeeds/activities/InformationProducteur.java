package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.localfeeds.R;

public class InformationProducteur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_producteur);

        Bundle parametres = this.getIntent().getExtras();
        String parametreId_producteur = (String) parametres.get("id_producteur");
        int idProducteur = Integer.parseInt(parametreId_producteur);


    }
}