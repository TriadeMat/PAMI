package com.matheus.anotacao;

import android.health.connect.datatypes.units.Length;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.matheus.anotacao.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        AnotacaoPreferencias preferencias = new AnotacaoPreferencias(MainActivity.this);

        binding.fab.setOnClickListener(view -> {
            String textoRecuperado = binding.edtMsg.getText().toString();

            if (textoRecuperado.equals("")){
                Snackbar.make(view,"Preencha a anotação", Snackbar.LENGTH_LONG).show();
            }else{
                preferencias.salvarAnotacao(textoRecuperado);
                Snackbar.make(view,"Anotação salva com Sucesso!!",Snackbar.LENGTH_LONG).show();
            }
        });
        String anotacao = preferencias.recuperarAnotacao();
        if (!anotacao.equals("")){
            binding.edtMsg.setText(anotacao);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}