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

public class AbaixoDoPesoActivity extends AppCompatActivity {
    public Button BotaoFecharAbaixo;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtPesoAbaixo;
    public TextView txtAlturaAbaixo;
    public TextView txtIMCAbaixo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);

        BotaoFecharAbaixo = findViewById(R.id.BotaoFecharAbaixo);
        txtPesoAbaixo = findViewById(R.id.PesoAbaixo);
        txtAlturaAbaixo = findViewById(R.id.AlturaAbaixo);
        txtIMCAbaixo = findViewById(R.id.IMCAbaixo);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtPesoAbaixo.setText(peso);
        txtAlturaAbaixo.setText(altura);
        txtIMCAbaixo.setText(imc);

        BotaoFecharAbaixo = findViewById(R.id.BotaoFecharAbaixo);
        BotaoFecharAbaixo.setOnClickListener(view -> {
            finish(); // Fecha a tela atual e volta para a MainActivity
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}