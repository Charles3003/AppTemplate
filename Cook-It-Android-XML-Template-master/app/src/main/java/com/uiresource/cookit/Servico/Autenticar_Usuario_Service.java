package com.uiresource.cookit.Servico;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.uiresource.cookit.Negocio.Autenticar_Usuario_Grid_BD;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class Autenticar_Usuario_Service extends AsyncTask<Void, Void, Autenticar_Usuario_Grid_BD> {
    private String Email;
    private String Senha;

    public Autenticar_Usuario_Service(String pEmail, String pSenha){
        Email = pEmail;
        Senha = pSenha;
    }

    @Override
    protected Autenticar_Usuario_Grid_BD doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("http://192.168.0.4:7071/api/Usuario/?pEmail=" + Email + "&pSenha=" + Senha);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }

            Gson gson = new Gson();
            Autenticar_Usuario_Grid_BD oUsuario = gson.fromJson(resposta.toString(), Autenticar_Usuario_Grid_BD.class);
           // for (int i = 0; i < oUsuario.length; i++){
               // Log.d("maria", oUsuario[i].getEmail());
            //}
           String a = oUsuario.getEmail();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }
        return new Gson().fromJson(resposta.toString(), Autenticar_Usuario_Grid_BD.class);
    }
}
