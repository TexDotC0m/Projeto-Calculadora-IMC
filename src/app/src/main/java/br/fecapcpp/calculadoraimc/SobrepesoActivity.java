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

public class SobrepesoActivity extends AppCompatActivity {
    public Button BotaoFecharSobrepeso;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtPesoSobrepeso;
    public TextView txtAlturaSobrepeso;
    public TextView txtIMCSobrepeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobrepeso);

        BotaoFecharSobrepeso = findViewById(R.id.BotaoFecharSobrepeso);
        txtPesoSobrepeso = findViewById(R.id.PesoSobrepeso);
        txtAlturaSobrepeso = findViewById(R.id.AlturaSobrepeso);
        txtIMCSobrepeso = findViewById(R.id.IMCSobrepeso);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtPesoSobrepeso.setText(peso);
        txtAlturaSobrepeso.setText(altura);
        txtIMCSobrepeso.setText(imc);

        BotaoFecharSobrepeso = findViewById(R.id.BotaoFecharSobrepeso);
        BotaoFecharSobrepeso.setOnClickListener(view -> {
            finish(); // Fecha a tela atual e volta para a MainActivity
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}