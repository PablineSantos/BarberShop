/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.User;
import View.Login;

/**
 *
 * @author tiago
 */
public class LoginHelper implements IHelper{

    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    @Override
    public User obterModelo(){
        
        String nome = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        User modelo = new User(0, nome, senha);
        
        return modelo;
    }
    
    public void setarModelo(User modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTextUsuario().setText(nome);
        view.getTextSenha().setText(senha);
    }
    
    @Override
    public void limparTela(){
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    }

    
}
