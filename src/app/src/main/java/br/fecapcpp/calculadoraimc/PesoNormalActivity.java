package br.fecapcpp.calculadoraimc;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PesoNormalActivity extends AppCompatActivity {
    public Button BotaoFecharNormal;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtPesoNormal;
    public TextView txtAlturaNormal;
    public TextView txtIMCNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peso_normal);

        BotaoFecharNormal = findViewById(R.id.BotaoFecharNormal);
        txtPesoNormal = findViewById(R.id.PesoNormal);
        txtAlturaNormal = findViewById(R.id.AlturaNormal);
        txtIMCNormal = findViewById(R.id.IMCNormal);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtPesoNormal.setText(peso);
        txtAlturaNormal.setText(altura);
        txtIMCNormal.setText(imc);

        BotaoFecharNormal = findViewById(R.id.BotaoFecharNormal);
        BotaoFecharNormal.setOnClickListener(view -> {
            finish(); // Fecha a tela atual e volta para a MainActivity
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}