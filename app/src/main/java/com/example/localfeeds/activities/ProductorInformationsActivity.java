package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.localfeeds.R;
import com.example.localfeeds.datas.ProductorService;
import com.example.localfeeds.models.Productor;

public class ProductorInformationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_producteur);

        Bundle parametres = this.getIntent().getExtras();
        String parametreId_producteur = (String) parametres.get("id_producteur");

        Productor productor = new ProductorService().getProductorById(parametreId_producteur);

        ImageButton arrow = findViewById(R.id.arrow_button);
        LinearLayout hiddenView = findViewById(R.id.hidden_view);
        CardView cardView = findViewById(R.id.base_cardview);

        TextView champAdresse = findViewById(R.id.vue_information_producteur_champ_adresse);
        TextView champHoraires = findViewById(R.id.vue_information_producteur_champ_horaires);
        TextView champDescription = findViewById(R.id.vue_information_producteur_champ_description);

        champAdresse.setText(productor.getAdresse());
        champHoraires.setText(productor.getSchedule());
        champDescription.setText(productor.getDesc());

        arrow.setOnClickListener(view -> {

            if (hiddenView.getVisibility() == View.VISIBLE) {

                TransitionManager.beginDelayedTransition(cardView,
                        new AutoTransition());
                hiddenView.setVisibility(View.GONE);
                arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
            }

            else {

                TransitionManager.beginDelayedTransition(cardView,
                        new AutoTransition());
                hiddenView.setVisibility(View.VISIBLE);
                arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
            }
        });
    }
}