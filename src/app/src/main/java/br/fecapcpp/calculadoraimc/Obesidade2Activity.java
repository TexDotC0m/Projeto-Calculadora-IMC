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

public class Obesidade2Activity extends AppCompatActivity {
    public Button BotaoFecharObesidade2;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtPesoObesidade2;
    public TextView txtAlturaObesidade2;
    public TextView txtIMCObesidade2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade2);

        BotaoFecharObesidade2 = findViewById(R.id.BotaoFecharObesidade2);
        txtPesoObesidade2 = findViewById(R.id.PesoObesidade2);
        txtAlturaObesidade2 = findViewById(R.id.AlturaObesidade2);
        txtIMCObesidade2 = findViewById(R.id.IMCObesidade2);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtPesoObesidade2.setText(peso);
        txtAlturaObesidade2.setText(altura);
        txtIMCObesidade2.setText(imc);

        BotaoFecharObesidade2 = findViewById(R.id.BotaoFecharObesidade2);
        BotaoFecharObesidade2.setOnClickListener(view -> {
            finish(); // Fecha a tela atual e volta para a MainActivity
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}