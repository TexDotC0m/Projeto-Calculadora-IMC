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

public class Obesidade1Activity extends AppCompatActivity {
    public Button BotaoFecharObesidade1;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtPesoObesidade1;
    public TextView txtAlturaObesidade1;
    public TextView txtIMCObesidade1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade1);

        BotaoFecharObesidade1 = findViewById(R.id.BotaoFecharObesidade1);
        txtPesoObesidade1 = findViewById(R.id.PesoObesidade1);
        txtAlturaObesidade1 = findViewById(R.id.AlturaObesidade1);
        txtIMCObesidade1 = findViewById(R.id.IMCObesidade1);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtPesoObesidade1.setText(peso);
        txtAlturaObesidade1.setText(altura);
        txtIMCObesidade1.setText(imc);

        BotaoFecharObesidade1 = findViewById(R.id.BotaoFecharObesidade1);
        BotaoFecharObesidade1.setOnClickListener(view -> {
            finish(); // Fecha a tela atual e volta para a MainActivity
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}