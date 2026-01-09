package com.example.sharenergy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        long seconds = getIntent().getLongExtra("seconds", 0);
        String powerbank = getIntent().getStringExtra("powerbank");

        double minutes = Math.ceil(seconds / 60.0);
        if (minutes == 0) minutes = 1;

        double precioDesbloqueo = 0.50;
        double precioTiempo = minutes * 0.02;
        double precioTotal = precioDesbloqueo + precioTiempo;

        TextView txtSummary = findViewById(R.id.txtSummary);
        TextView txtTotal = findViewById(R.id.txtTotal);
        Button btnFinish = findViewById(R.id.btnFinish);

        txtSummary.setText(
                "Powerbank: " + powerbank + "\n\n" +
                        "Precio desbloqueo: 0,50 €\n" +
                        "Tiempo de uso: " + (long) minutes + " min\n" +
                        "Precio por tiempo: " + String.format(Locale.US, "%.2f €", precioTiempo) + "\n\n" +
                        "TOTAL A PAGAR:"
        );

        txtTotal.setText(String.format(Locale.US, "%.2f €", precioTotal));

        btnFinish.setOnClickListener(v -> finishAffinity());
    }
}
