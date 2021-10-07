package com.deborah.formulariodecadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText nome, idade;
    private RadioButton feminino, masculino, outros;
    private TextView resultadoNome, resultadoIdade, resultadoGenero;
    private Object View;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        idade = findViewById(R.id.editIdade);
        feminino = findViewById(R.id.radioButtonFeminino);
        masculino = findViewById(R.id.radioButtonMasculino);
        outros = findViewById(R.id.radioButtonOutros);
        resultadoNome = findViewById(R.id.resultadoNome);
        resultadoIdade = findViewById(R.id.resultadoIdade);
        resultadoGenero = findViewById(R.id.resultadoGenero);
        Button botaoCadastrar = findViewById(R.id.bt_Cadastrar);


        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editNome = nome.getText().toString();
                String editIdade = idade.getText().toString();

                if (editNome.isEmpty() || editIdade.isEmpty()) {
                    Snackbar.make(view, "Preencha o nome e a idade", Snackbar.LENGTH_SHORT).show();
                } else {
                    RadioButtonSelecionado(view);
                }
            }

        });

    }
    private void RadioButtonSelecionado(View view){



        String editNome = nome.getText().toString();
        String editIdade = idade.getText().toString();

        if (feminino.isChecked()){
          resultadoNome.setText(editNome);
          resultadoIdade.setText(editIdade);
          resultadoGenero.setText("Genero: Feminino");

        } else if (masculino.isChecked()){
            resultadoNome.setText(editNome);
            resultadoIdade.setText(editIdade);
            resultadoGenero.setText("Genero: Masculino");
        } else{
            Snackbar.make(view, "Coloque o seu genero", Snackbar.LENGTH_SHORT).show();

        }

    }
}

