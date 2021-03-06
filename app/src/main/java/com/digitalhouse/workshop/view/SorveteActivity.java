package com.digitalhouse.workshop.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.digitalhouse.workshop.R;

public class SorveteActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox item1;
    private CheckBox item2;
    private CheckBox item3;
    private TextView totalGeral;
    private Button botaoFinalizar;
    float total = 0F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorvete);

        item1 = findViewById(R.id.checkBox);
        item2 = findViewById(R.id.checkBox2);
        item3 = findViewById(R.id.checkBox3);
        totalGeral = findViewById(R.id.totalGeral);
        botaoFinalizar = findViewById(R.id.botaoFinalizar);

        item1.setOnCheckedChangeListener(this);
        item2.setOnCheckedChangeListener(this);
        item3.setOnCheckedChangeListener(this);


        botaoFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Toast.makeText(SorveteActivity.this, "Sorvetes salvos com sucesso!",Toast.LENGTH_SHORT).show();

            Intent intentVaiPraHome = new Intent(SorveteActivity.this, PizzaActivity.class );
            startActivity(intentVaiPraHome);

            }
        });
    }

    public void finalizarPedido(View view) {

        // Verifica se o item esta preenchido
        if(item1.isChecked()){
            // Sumariza o valor do item 1
            total += Float.parseFloat(item1.getText().toString());
        }
        if(item2.isChecked()){
            total += Float.parseFloat(item2.getText().toString());
        }
        if(item3.isChecked()){
            total += Float.parseFloat(item3.getText().toString());
        }

        totalGeral.setText("TOTAL: R$ "+total);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        finalizarPedido(null);
    }
}
