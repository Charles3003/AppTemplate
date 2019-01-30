package com.uiresource.cookit.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.uiresource.cookit.Main;
import com.uiresource.cookit.R;

public class Cadastro_Manter_TL extends AppCompatActivity {

    private ImageButton _btn_Distribuidora;
    private ImageButton _btn_Comprador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tl);

        _btn_Distribuidora = (ImageButton) findViewById(R.id.btn_Distribuidora);
        _btn_Comprador = (ImageButton) findViewById(R.id.btn_Comprador);

        _btn_Distribuidora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(Cadastro_Manter_TL.this, Cadastro_Geral_Manter_TL.class);

                    Bundle oPerfil = new Bundle();
                    oPerfil.putString("perfil_nome", "Distribuidora");
                    intent.putExtras(oPerfil);

                    startActivity(intent);

                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        _btn_Comprador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Intent intent = new Intent(Cadastro_Manter_TL.this, Cadastro_Geral_Manter_TL.class);

                    Bundle oPerfil = new Bundle();
                    oPerfil.putString("perfil_nome", "Comprador");

                    intent.putExtras(oPerfil);
                    startActivity(intent);

                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
