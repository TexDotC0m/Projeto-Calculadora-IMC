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

public class Obesidade3Activity extends AppCompatActivity {
    public Button BotaoFecharObesidade3;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtPesoObesidade3;
    public TextView txtAlturaObesidade3;
    public TextView txtIMCObesidade3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade3);

        BotaoFecharObesidade3 = findViewById(R.id.BotaoFecharObesidade3);
        txtPesoObesidade3 = findViewById(R.id.PesoObesidade3);
        txtAlturaObesidade3 = findViewById(R.id.AlturaObesidade3);
        txtIMCObesidade3 = findViewById(R.id.IMCObesidade3);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtPesoObesidade3.setText(peso);
        txtAlturaObesidade3.setText(altura);
        txtIMCObesidade3.setText(imc);

        BotaoFecharObesidade3 = findViewById(R.id.BotaoFecharObesidade3);
        BotaoFecharObesidade3.setOnClickListener(view -> {
            finish(); // Fecha a tela atual e volta para a MainActivity
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}