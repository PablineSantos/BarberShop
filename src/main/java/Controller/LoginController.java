/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.Database;
import Model.DAO.UserDAO;
import Model.User;
import View.Login;
import View.MainMenu;

/**
 *
 * @author tiago
 */
public class LoginController {
    
    private Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
        Database.inicia(); //comando para iniciar o banco de dados
    }
    
    public void entrarNoSistema(){
    
        //Pegar User da View        
        User usuarioNaoAutenticado = helper.obterModelo(); //depurar aqui
        
        //Pesquisa User no Database
        UserDAO usuarioDAO = new UserDAO();
        User usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuarioNaoAutenticado);
        
        //Se o usuario da view tiver mesmo usuario e senha que o usuario vindo do banco direcionar para menu principal
        if(usuarioAutenticado != null){
            
            MainMenu menuPrincipal = new MainMenu();
            menuPrincipal.setVisible(true);
            this.view.dispose(); //fecha a view atual
        }else{
            this.view.exibeMensagem("Usuario ou senha incorretos");
        }
        
    }
    
    public void FizTendeu(){
        
        //Vou fazer a Logica que preciso aqui
        System.out.println("Busquei do banco fiz tendeu.");
        
        //Retornando feedback ao usuario
        this.view.exibeMensagem("Executei o FizTendeu");
        
    }
    
}
