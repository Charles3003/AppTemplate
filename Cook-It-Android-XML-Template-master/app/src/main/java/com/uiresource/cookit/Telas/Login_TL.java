package com.uiresource.cookit.Telas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uiresource.cookit.Main;
import com.uiresource.cookit.Negocio.Autenticar_Usuario_Grid_BD;
import com.uiresource.cookit.R;
import com.uiresource.cookit.Servico.Autenticar_Usuario_Service;
import com.uiresource.cookit.Splash;

public class Login_TL extends AppCompatActivity {

    private Button _btn_Logar;
    private Button _btn_Loga_Cadastro;
    private EditText _txt_Email;
    private EditText _txt_Senha;

    private static final String ARQUIVO_PREFERENCIA = "usuario_logado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_tl);

        _btn_Logar = (Button) findViewById(R.id.btn_Logar);
        _btn_Loga_Cadastro = (Button) findViewById(R.id.btn_Cadastro);
        _txt_Email = (EditText) findViewById(R.id.txt_Email);
        _txt_Senha = (EditText) findViewById(R.id.txt_Senha);

        _btn_Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SharedPreferences oSharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editar = oSharedPreferences.edit();

                    if (_txt_Email.getText().toString().isEmpty()) {
                        throw new Exception("Informe o e-mail!");
                    } else if (_txt_Senha.getText().toString().isEmpty()) {
                        throw new Exception("Informe a senha!");
                    }
                    Autenticar_Usuario_Grid_BD oAutenticar_Usuario_Grid_BD = new Autenticar_Usuario_Service(_txt_Email.getText().toString(), _txt_Senha.getText().toString()).execute().get();

                    if (oAutenticar_Usuario_Grid_BD != null) {

                        editar.putString("email_usuario", _txt_Email.getText().toString());
                        editar.commit();

                        Intent intent = new Intent(Login_TL.this, Main.class);
                        startActivity(intent);

                    } else
                        Toast.makeText(getApplicationContext(), "Usuário ou senha está incorreto!", Toast.LENGTH_LONG).show();

                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        _btn_Loga_Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Login_TL.this, Cadastro_Manter_TL.class);
                    startActivity(intent);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
