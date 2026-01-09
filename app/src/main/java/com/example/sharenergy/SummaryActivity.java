package com.example.sharenergy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        long seconds = getIntent().getLongExtra("seconds", 0);
        String powerbank = getIntent().getStringExtra("powerbank");

        double minutos = Math.ceil(seconds / 60.0);
        if (minutos == 0) minutos = 1;

        double precioBase = 0.50;
        double precioTiempo = minutos * 0.02;
        double precioFinal = precioBase + precioTiempo;

        TextView txtSummary = findViewById(R.id.txtSummary);
        Button btnFinish = findViewById(R.id.btnFinish);
        //Texto que muestra el precio de uso de la powerbank.
        txtSummary.setText(
                "Powerbank: " + powerbank +
                        "\n\nPrecio desbloqueo: 0,50 €" +
                        "\nTiempo de uso: " + minutos + " min" +
                        "\nPrecio por tiempo: " + String.format("%.2f", precioTiempo) + " €" +
                        "\n\nTOTAL A PAGAR: " + String.format("%.2f", precioFinal) + " €"
        );

        btnFinish.setOnClickListener(v -> finishAffinity());
    }
}
