package com.example.sharenergy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtPhone = findViewById(R.id.edtPhone);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String telefono = edtPhone.getText().toString().trim();

            if (esTelefonoValido(telefono)) {
                Intent intent = new Intent(LoginActivity.this, SelectActivity.class);
                intent.putExtra("telefono", telefono);
                startActivity(intent);
            } else {
                Toast.makeText(
                        this,
                        "Ups, el número de teléfono no es válido.\nPor favor introduce un número correcto.",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
    //Validacion del numero de telefono

    private boolean esTelefonoValido(String telefono) {
        if (telefono.length() != 9) return false;
        if (!telefono.matches("[0-9]+")) return false;
        return telefono.startsWith("6") || telefono.startsWith("7");
    }
}
