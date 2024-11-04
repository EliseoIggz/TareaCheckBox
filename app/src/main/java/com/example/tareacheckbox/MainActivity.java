package com.example.tareacheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox cBManzana = findViewById(R.id.cBManzana);
        CheckBox cBNaranja = findViewById(R.id.cBNaranja);
        CheckBox cBFresa = findViewById(R.id.cBFresa);
        Button botonComer = findViewById(R.id.botonComer);

        ArrayList<String> frutas = new ArrayList<>();

        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String fruit = buttonView.getText().toString();
                if (isChecked) {
                    frutas.add(fruit);
                } else {
                    frutas.remove(fruit);
                }
            }
        };

        cBManzana.setOnCheckedChangeListener(checkedChangeListener);
        cBNaranja.setOnCheckedChangeListener(checkedChangeListener);
        cBFresa.setOnCheckedChangeListener(checkedChangeListener);

        botonComer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!frutas.isEmpty()) {
                    Toast.makeText(MainActivity.this, frutas.toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "No hay frutas seleccionadas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}