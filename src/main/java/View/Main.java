/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.DAO.Banco;
import Model.DAO.UsuarioDAO;
import Model.Servico;
import Model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class Main {
    
    
    public static void main(String[] args){
      
        String nome = "tiago";
        System.out.println(nome);
        
        Servico corte = new Servico(1, "corte", 30);
        
        System.out.println(corte.getDescricao());
        System.out.println(corte.getValor());
        
        
        Usuario tiago = new Usuario(1, "tiago", 'M', "09/05/1996", "92408407", "tiagoluz.h607@gmail.com", "24578874", "123456", "administrador");
        System.out.println(tiago.getNome());
        System.out.println(tiago.getDataNascimento()); //debugar aqui
        
        Cliente link = new Cliente(1, "tiago", 'M', "09/05/1996", "92408407", "tiagoluz.h607@gmail.com", "24578874","Rua teste 654 canudos", "95478452");
        System.out.println(link.getNome());
        System.out.println(link.getDataNascimento()); //debugar aqui
        
        //Nao consigo estanciar a classe é abstrata
        //Pessoa pessoinha = new Pessoa(1, "capirotin");
        //System.out.println(pessoinha.getNome());
        
        
        //--------------------- Criando Um Agendamento -----------------------------------------------------
        Agendamento agendamento = new Agendamento(1, link, corte, 30, "09/07/2018 23:51");
        System.out.println(agendamento.getCliente().getNome()); //debugar aqui
        System.out.println(agendamento.getData());
        
        
        Banco.inicia();
        
        //Testando DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insert(tiago);
        ArrayList<Usuario> usuarios = usuarioDAO.selectAll();
        tiago.setNome("tiago luz");
        usuarioDAO.update(tiago);
        usuarios = usuarioDAO.selectAll();
        usuarioDAO.delete(tiago);
        usuarios = usuarioDAO.selectAll();
        
        
        
        
   }
    
    
}
