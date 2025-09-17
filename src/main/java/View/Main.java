/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Scheduling;
import Model.Client;
import Model.DAO.Database;
import Model.DAO.UserDAO;
import Model.Service;
import Model.User;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class Main {
    
    
    public static void main(String[] args){
      
        String nome = "tiago";
        System.out.println(nome);
        
        Service corte = new Service(1, "corte", 30);
        
        System.out.println(corte.getDescricao());
        System.out.println(corte.getValor());
        
        
        User tiago = new User(1, "tiago", 'M', "09/05/1996", "92408407", "tiagoluz.h607@gmail.com", "24578874", "123456", "administrador");
        System.out.println(tiago.getNome());
        System.out.println(tiago.getDataNascimento()); //debugar aqui
        
        Client link = new Client(1, "tiago", 'M', "09/05/1996", "92408407", "tiagoluz.h607@gmail.com", "24578874","Rua teste 654 canudos", "95478452");
        System.out.println(link.getNome());
        System.out.println(link.getDataNascimento()); //debugar aqui
        
        //Nao consigo estanciar a classe é abstrata
        //Pessoa pessoinha = new Pessoa(1, "capirotin");
        //System.out.println(pessoinha.getNome());
        
        
        //--------------------- Criando Um Scheduling -----------------------------------------------------
        Scheduling agendamento = new Scheduling(1, link, corte, 30, "09/07/2018 23:51");
        System.out.println(agendamento.getCliente().getNome()); //debugar aqui
        System.out.println(agendamento.getData());
        
        
        Database.inicia();
        
        //Testando DAO
        UserDAO usuarioDAO = new UserDAO();
        usuarioDAO.insert(tiago);
        ArrayList<User> usuarios = usuarioDAO.selectAll();
        tiago.setNome("tiago luz");
        usuarioDAO.update(tiago);
        usuarios = usuarioDAO.selectAll();
        usuarioDAO.delete(tiago);
        usuarios = usuarioDAO.selectAll();
         
        
        
        
   }
    
    
}
