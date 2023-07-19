package devandroid.alves.appgaseta.applistacurso.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import devandroid.alves.appgaseta.R;
import devandroid.alves.appgaseta.applistacurso.apoio.UtilGasEta;
import devandroid.alves.appgaseta.applistacurso.controller.GasEtaController;
import devandroid.alves.appgaseta.applistacurso.model.Combustivel;

public class GasEtaActivity  extends AppCompatActivity {
    Double valorGasolina;
    Double valorEtanol;
    String recomendacao;

    UtilGasEta  utilGasEta;
    GasEtaController controller;
    //GasEtaController gasEtaController = new GasEtaController();
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;
    EditText editTextLitroGasolina;
    EditText editTextLitroEtanol;
    Button btnCalcular;
    Button btnSalvar;
    Button btnLimpar;
    Button btnFinalizar;

    TextView textResultado;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        editTextLitroGasolina = findViewById(R.id.editTextLitroGasolina);
        editTextLitroEtanol = findViewById(R.id.editTextLitroEtanol);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        textResultado = findViewById(R.id.textResultado);


        //UtilGasEta.MetodoEstatico();
        //utilGasEta.MetodoNaoStatico();

        //Exibindo mensagem do return do metodo na tela
        /*Toast.makeText(GasEtaActivity.this,
                UtilGasEta.CalcularMelhorOpcao(5.50,3.70),
                Toast.LENGTH_LONG).show();*/

        //acao botoes
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadoOk = true;



                //tratando erro campo vazio
                if (TextUtils.isEmpty(editTextLitroGasolina.getText())){
                    editTextLitroGasolina.setError("* Campo Obrigatório");
                    //manter foco do curso no campo
                    editTextLitroGasolina.requestFocus();
                    isDadoOk = false;
                }else if (TextUtils.isEmpty(editTextLitroEtanol.getText())) {
                    editTextLitroEtanol.setError("* Campo Obrigatório");
                    editTextLitroEtanol.requestFocus();
                    isDadoOk = false;
                } else if (isDadoOk){
                    valorGasolina = Double.parseDouble(editTextLitroGasolina.getText().toString());
                    valorEtanol = Double.parseDouble(editTextLitroEtanol.getText().toString());
                    recomendacao = UtilGasEta.CalcularMelhorOpcao(valorGasolina, valorEtanol);

                    textResultado.setText(recomendacao);

                }else{
                    Toast.makeText(GasEtaActivity.this,
                            "Por favor, digite os dados Obrigatórios...", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // TODO DESABILITAR BOTAO SALVAR
                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();
                combustivelGasolina.setNomeCombustivel("Gasolina");
                combustivelGasolina.setPrecoCombustivel(valorGasolina);

                combustivelEtanol.setNomeCombustivel("Etanol");
                combustivelEtanol.setPrecoCombustivel(valorEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.CalcularMelhorOpcao(valorGasolina,valorEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.CalcularMelhorOpcao(valorGasolina,valorEtanol));

                int parada = 0;
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextLitroGasolina.setText("");
                editTextLitroEtanol.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "VOLTE SEMPRE, VAI CORINTHIANS!!!", Toast.LENGTH_LONG).show();
                finish();

            }
        });

    }
}
