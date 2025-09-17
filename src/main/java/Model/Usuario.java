/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe representa um usuario do sistema
 * @author tiago
 */
public class Usuario extends Pessoa{

    private String senha;
    private String nivelAcesso;

    /**
     *  Construtor Cmpleto da Classe Usuario
     * @param id identificador
     * @param nome
     * @param sexo
     * @param dataNascimento
     * @param telefone
     * @param email
     * @param rg
     * @param senha
     * @param nivelAcesso é o nível de acesso que a pessoa tem exemplo "Administrador" ou "Funcionario"
     */
    public Usuario(int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg, String senha, String nivelAcesso) {
        super(id, nome, sexo, dataNascimento, telefone, email, rg);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public Usuario(int id, String nome, String senha, String nivelAcesso) {
        super(id, nome);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
    
    public Usuario(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }
    
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    } 
    
    
}
