package com.uiresource.cookit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.uiresource.cookit.Telas.Login_TL;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        changeStatusBarColor();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences oSharedPreferences = getSharedPreferences("usuario_logado", 0);
                if ((oSharedPreferences.contains("email_usuario"))) {
                    Intent intent = new Intent(Splash.this, Main.class);
                    startActivity(intent);
                } else {
                    startActivity(new Intent(Splash.this, Login_TL.class));
                    finish();
                }
            }
        }, 3 * 1000);
    }
}

