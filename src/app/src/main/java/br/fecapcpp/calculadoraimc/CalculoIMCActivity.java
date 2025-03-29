package br.fecapcpp.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.DecimalFormat;

public class CalculoIMCActivity extends AppCompatActivity {

    private Button btn2Voltar;
    private Button btnLimpar;
    private Button btnCalcular;

    EditText campoAltura;
    EditText campoPeso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imcactivity);

        campoAltura = findViewById(R.id.Altura);
        campoPeso = findViewById(R.id.Peso);

        btnCalcular = findViewById(R.id.BotaoCalcular);
        btnCalcular.setOnClickListener(view -> {
            calcular();
        });

        btn2Voltar = findViewById(R.id.BotaoFechar1);
        btn2Voltar.setOnClickListener(view -> {
            finish(); // Fecha a tela atual e volta para a MainActivity
        });

        btnLimpar = findViewById(R.id.BotaoLimpar);
        btnLimpar.setOnClickListener(view -> {
            EditText campoAltura = findViewById(R.id.Altura);
            EditText campoPeso = findViewById(R.id.Peso);
            campoAltura.setText("");
            campoPeso.setText("");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(){
        String alturaTexto = campoAltura.getText().toString();
        String pesoTexto = campoPeso.getText().toString();

        // Validação para evitar crash por campos vazios
     //  if (alturaTexto.isEmpty() || pesoTexto.isEmpty()) {
        //    resultado.setText("Por favor, preencha todos os campos!");
          //  return;
       // }

        float altura = Float.parseFloat(alturaTexto);
        float peso = Float.parseFloat(pesoTexto);
        float imc = peso / (altura * altura);

        DecimalFormat df = new DecimalFormat("#.##");
        String resultadoImc = df.format(imc);

        Intent intent;

        if (imc < 18.5) {
            intent = new Intent(this, AbaixoDoPesoActivity.class);
        }
        else if (imc >= 18.5 && imc < 25) {
            intent = new Intent(this, PesoNormalActivity.class);
        }
        else if (imc >= 25 && imc < 30) {
            intent = new Intent(this, SobrepesoActivity.class);
        }
        else if (imc >= 30 && imc < 35) {
            intent = new Intent(this, Obesidade1Activity.class);
        }
        else if (imc >= 35 && imc < 40) {
            intent = new Intent(this, Obesidade2Activity.class);
        }
        else {
            intent = new Intent(this, Obesidade3Activity.class);
        }
        intent.putExtra("imc",resultadoImc);
        intent.putExtra("peso",pesoTexto);
        intent.putExtra("altura",alturaTexto);
            startActivity(intent);

    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

}