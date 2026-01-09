package com.example.sharenergy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {

    LinearLayout cardPB1, cardPB2;
    TextView txtPB1Status, txtPB2Status;
    View statusPB1, statusPB2;

    PowerbankManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        manager = PowerbankManager.getInstance();

        cardPB1 = findViewById(R.id.cardPB1);
        cardPB2 = findViewById(R.id.cardPB2);
        txtPB1Status = findViewById(R.id.txtPB1Status);
        txtPB2Status = findViewById(R.id.txtPB2Status);
        statusPB1 = findViewById(R.id.statusPB1);
        statusPB2 = findViewById(R.id.statusPB2);

        actualizarVista();

        cardPB1.setOnClickListener(v -> alquilar(manager.pb1));
        cardPB2.setOnClickListener(v -> alquilar(manager.pb2));
    }

    private void actualizarVista() {
        actualizarPowerbank(manager.pb1, txtPB1Status, statusPB1, cardPB1);
        actualizarPowerbank(manager.pb2, txtPB2Status, statusPB2, cardPB2);
    }
//Estados de uso de las powerbanks.
    private void actualizarPowerbank(
            Powerbank pb,
            TextView txtStatus,
            View statusCircle,
            LinearLayout card
    ) {
        if (pb.estaRecargando()) {
            txtStatus.setText("Estado: Recargando");
            txtStatus.setTextColor(Color.parseColor("#F9A825"));
            statusCircle.setBackgroundResource(R.drawable.circle_yellow);
            card.setEnabled(false);

        } else if (pb.estaEnUso()) {
            txtStatus.setText("Estado: No disponible");
            txtStatus.setTextColor(Color.parseColor("#D32F2F"));
            statusCircle.setBackgroundResource(R.drawable.circle_red);
            card.setEnabled(false);

        } else {
            txtStatus.setText("Estado: Disponible");
            txtStatus.setTextColor(Color.parseColor("#2E7D32"));
            statusCircle.setBackgroundResource(R.drawable.circle_green);
            card.setEnabled(true);
        }
    }

    private void alquilar(Powerbank pb) {
        if (!pb.estaDisponible()) return;

        pb.disponible = false;
        pb.tiempoRecargaFin = 0; // 🔴 EN USO

        Intent intent = new Intent(this, UsingActivity.class);
        intent.putExtra("powerbank", pb.id);
        startActivity(intent);
    }
}
