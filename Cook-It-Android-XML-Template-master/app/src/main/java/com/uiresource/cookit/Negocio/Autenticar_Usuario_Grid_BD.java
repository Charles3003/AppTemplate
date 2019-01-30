package com.uiresource.cookit.Negocio;

public class Autenticar_Usuario_Grid_BD {

    public int Codigo;
    public String Email;
    public String Senha;
    public boolean E_Distribuidora;
    public String Nome_Razao_Social;
    public byte[] Imagem;
    public int Codigo_Perfil;

    public int getCodigo_Perfil() {
        return Codigo_Perfil;
    }

    public void setCodigo_Perfil(int codigo_Perfil) {
        Codigo_Perfil = codigo_Perfil;
    }

    public int getCodigo()
    {
        return Codigo;
    }

    public void setCodigo(int codigo)
    {
        Codigo = codigo;
    }

    public String getNome_Razao_Social()
    {
        return Nome_Razao_Social;
    }

    public void setNome_Razao_Social(String nome_Razao_Social)
    {
        Nome_Razao_Social = nome_Razao_Social;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String email)
    {
        Email = email;
    }

    public String getSenha()
    {
        return Senha;
    }

    public void setSenha(String senha)
    {
        Senha = senha;
    }

    public boolean isE_Distribuidora()
    {
        return E_Distribuidora;
    }

    public void setE_Distribuidora(boolean e_Distribuidora)
    {
        E_Distribuidora = e_Distribuidora;
    }

    public byte[] getImagem()
    {
        return Imagem;
    }

    public void setImagem(byte[] imagem)
    {
        Imagem = imagem;
    }

}
