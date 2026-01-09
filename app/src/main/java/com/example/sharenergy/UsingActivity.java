package com.example.sharenergy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UsingActivity extends AppCompatActivity {
    private long startTime;
    private Handler handler = new Handler();
    private TextView txtTimer;
    private PowerbankManager manager;
    private Powerbank pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using);

        manager = PowerbankManager.getInstance();

        String powerbankId = getIntent().getStringExtra("powerbank");

        pb = powerbankId.equals("PB-001")
                ? manager.pb1
                : manager.pb2;

        TextView txtUsing = findViewById(R.id.txtUsing);
        Button btnReturn = findViewById(R.id.btnReturn);
        txtTimer = findViewById(R.id.txtTimer);

        txtUsing.setText("Usando powerbank: " + pb.id);

        startTime = SystemClock.elapsedRealtime();
        startTimer();

        btnReturn.setOnClickListener(v -> {
            handler.removeCallbacksAndMessages(null);

            long endTime = SystemClock.elapsedRealtime();
            long secondsUsed = (endTime - startTime) / 1000;

            // inicia recarga simulada (30s)
            pb.finalizarUso();

            Intent intent = new Intent(this, SummaryActivity.class);
            intent.putExtra("seconds", secondsUsed);
            intent.putExtra("powerbank", pb.id);
            startActivity(intent);
            finish();
        });

    }
    //Tiempo de uso en tiempo real.
    private void startTimer() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                long elapsedMillis = SystemClock.elapsedRealtime() - startTime;
                long seconds = elapsedMillis / 1000;

                txtTimer.setText("Tiempo de uso: " + seconds + " s");

                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }
}
