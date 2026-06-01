package com.matheus.modularpamimatheuslogincomshared;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    EditText nome, email, senha;
    Button criar, entrar;
    CheckBox chkbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponents();

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String valNome  = nome.getText().toString();
                String valEmail = email.getText().toString();
                String valSenha = senha.getText().toString();

                boolean dadosValidados = validarDados(valNome, valEmail, valSenha);
                if (dadosValidados) {
                    Usuario usuario = new Usuario();
                    usuario.setNome(nome.getText().toString());
                    usuario.setEmail(email.getText().toString());
                    usuario.setSenha(senha.getText().toString());
                    if (chkbox.isChecked()) {
                        preferences = getSharedPreferences("login.xml", MODE_PRIVATE);
                        SharedPreferences.Editor dadosLogin = preferences.edit();

                        dadosLogin.putString("Nome", usuario.getNome());
                        dadosLogin.putString("Email", usuario.getEmail());
                        dadosLogin.putString("Senha", usuario.getSenha());
                        dadosLogin.apply();
                    }

                    nome.setText("");
                    email.setText("");
                    senha.setText("");

                    Toast.makeText(MainActivity.this, "Dados: " + usuario.getNome().toString() +
                            usuario.getEmail().toString() + usuario.getSenha().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Digite todos os dados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initComponents() {
        nome   = findViewById(R.id.edt_nome);
        email  = findViewById(R.id.edt_email);
        senha  = findViewById(R.id.edt_senha);
        entrar = findViewById(R.id.btn_entrar);
        criar  = findViewById(R.id.btn_novo);
        chkbox = findViewById(R.id.checkBox);
    }

    private boolean validarDados( String valNome, String valEmail, String valSenha ) {
        boolean retorno = true;

        if (valNome.equals("")) {
            retorno = false;
            nome.setError("Esse campo nao pode ficar vazio");
            nome.requestFocus();

        }
        if (valEmail.equals("")) {
            retorno = false;
            email.setError("Esse campo nao pode ficar vazio");
        }
        if (valSenha.equals("Esse campo nao pode ficar vazio")) {
            retorno = false;
            senha.setError("Esse campo nao pode ficar vazio");
        }
        return retorno;
    }
}
