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

import java.util.List;

import devandroid.alves.appgaseta.R;
import devandroid.alves.appgaseta.applistacurso.apoio.UtilGasEta;
import devandroid.alves.appgaseta.applistacurso.controller.CombustivelController;
import devandroid.alves.appgaseta.applistacurso.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {
    Double valorGasolina;
    Double valorEtanol;
    String recomendacao;
    CombustivelController controller;
    Combustivel combustivelGas;
    Combustivel combustivelEta;

    EditText editTextLitroGasolina;
    EditText editTextLitroEtanol;
    Button btnCalcular;
    Button btnSalvar;
    Button btnLimpar;
    Button btnFinalizar;

    TextView textResultado;

    List<Combustivel> dados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);
        dados = controller.getListaDeDados();
        // PEGANDO ITEM PARA ALTERACAO ATRAVES DO VETOR
       Combustivel objAlterar = dados.get(4);
        //POPULANDO VALORES ALTERADO
       objAlterar.setNomeCombustivel("***EtanolTest**");
       objAlterar.setPrecoCombustivel(2.10);
       objAlterar.setRecomendacao("Nao abastecer");

       // fazendo papel da tela e deletando dados
        controller.deletarObject(18);



       // PASSANDO DADS A SER ALTERADOS PARA CONTROLADORA
       controller.alterarDados(objAlterar);

        editTextLitroGasolina = findViewById(R.id.editTextLitroGasolina);
        editTextLitroEtanol = findViewById(R.id.editTextLitroEtanol);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        textResultado = findViewById(R.id.textResultado);

        //acao botoes
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadoOk = true;


                //tratando erro campo vazio
                if (TextUtils.isEmpty(editTextLitroGasolina.getText())) {
                    editTextLitroGasolina.setError("* Campo Obrigatório");
                    //manter foco do curso no campo
                    editTextLitroGasolina.requestFocus();
                    isDadoOk = false;
                    // manter botao salvar desabilitado
                    btnSalvar.setEnabled(false);
                } else if (TextUtils.isEmpty(editTextLitroEtanol.getText())) {
                    editTextLitroEtanol.setError("* Campo Obrigatório");
                    editTextLitroEtanol.requestFocus();
                    isDadoOk = false;
                    // manter botao salvar desabilitado
                    btnSalvar.setEnabled(false);
                } else if (isDadoOk) {
                    valorGasolina = Double.parseDouble(editTextLitroGasolina.getText().toString());
                    valorEtanol = Double.parseDouble(editTextLitroEtanol.getText().toString());
                    recomendacao = UtilGasEta.CalcularMelhorOpcao(valorGasolina, valorEtanol);

                    textResultado.setText(recomendacao);
                    btnSalvar.setEnabled(true);

                } else {
                    Toast.makeText(GasEtaActivity.this,
                            "Por favor, digite os dados Obrigatórios...", Toast.LENGTH_LONG).show();
                    btnSalvar.setEnabled(false);
                }
            }
        });
        
// ERROR AO CLICAR NO BOTAO SALVAR 
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combustivelGas = new Combustivel();
                combustivelEta = new Combustivel();

                combustivelGas.setNomeCombustivel("Gasolina");
                combustivelGas.setPrecoCombustivel(valorGasolina);

                combustivelEta.setNomeCombustivel("Etanol");
                combustivelEta.setPrecoCombustivel(valorEtanol);

                combustivelGas.setRecomendacao(UtilGasEta.CalcularMelhorOpcao(valorGasolina, valorEtanol));
                combustivelEta.setRecomendacao(UtilGasEta.CalcularMelhorOpcao(valorGasolina,valorEtanol));

                controller.salvar(combustivelGas);
                controller.salvar(combustivelEta);

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextLitroGasolina.setText("");
                editTextLitroEtanol.setText("");
                btnSalvar.setEnabled(false);
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
