package devandroid.alves.appgaseta.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.alves.appgaseta.R;
import devandroid.alves.appgaseta.applistacurso.controller.CursoController;
import devandroid.alves.appgaseta.applistacurso.controller.pessoaController;
import devandroid.alves.appgaseta.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    pessoaController controller;
    CursoController cursoController;
    List <String> listaCurso;
    Pessoa pessoa;
    EditText editTextPrimeiroNome;
    EditText editTextSobrenome;
    EditText editTextNomeCursoDesejado;
    EditText editTextTelefoneDeContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        cursoController = new CursoController();
        listaCurso = cursoController.dadosParaSpinner();



        controller = new pessoaController(MainActivity.this);
        controller.toString();
        pessoa = new Pessoa();
        controller.buscar(pessoa);

        // associando class editText e button ao MainActivity.java
        editTextPrimeiroNome = findViewById(R.id.editTextPrimeiroNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);
        editTextNomeCursoDesejado = findViewById(R.id.editTextNomeCursoDesejado);
        editTextTelefoneDeContato = findViewById(R.id.editTextTelefoneDeContato);
        spinner = findViewById(R.id.spinner);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnSalvar = findViewById(R.id.btnSalvar);

        // inserindo valor na tela do app
        editTextPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editTextSobrenome.setText(pessoa.getSobreNome());
        editTextNomeCursoDesejado.setText(pessoa.getCursoDesejado());
        editTextTelefoneDeContato.setText(pessoa.getNumeroTelefone());

        // inserido dados no combo

        //Adapter
        //Layout
        //Injetar adapter ao Spinner - a Lista será gerada

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);



        // acao dos botoes das telas
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextPrimeiroNome.setText("");
                editTextSobrenome.setText("");
                editTextNomeCursoDesejado.setText("");
                editTextTelefoneDeContato.setText("");

                controller.limpar();
            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_LONG).show();
                finish();

            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editTextPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editTextSobrenome.getText().toString());
                pessoa.setCursoDesejado(editTextNomeCursoDesejado.getText().toString());
                pessoa.setNumeroTelefone(editTextTelefoneDeContato.getText().toString());
                Toast.makeText(MainActivity.this, "Cadastro Realizado!" + pessoa.toString(), Toast.LENGTH_LONG).show();

                controller.Salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());
    }
}