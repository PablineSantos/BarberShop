/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Client;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class ClientDAO {
    
    
    /**
     * Insere um cliente dentro do banco de dados
     * @param cliente exige que seja passado um objeto do tipo cliente
     */
    public void insert(Client cliente){
        Database.cliente.add(cliente);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param cliente
     * @return 
     */
    public boolean update(Client cliente){
        
        for (int i = 0; i < Database.cliente.size(); i++) {
            if(idSaoIguais(Database.cliente.get(i),cliente)){
                Database.cliente.set(i, cliente);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do cliente passado
     * @param cliente
     * @return 
     */
    public boolean delete(Client cliente){
        for (Client clienteLista : Database.cliente) {
            if(idSaoIguais(clienteLista,cliente)){
                Database.cliente.remove(clienteLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os clientes do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Client> selectAll(){
        return Database.cliente;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param cliente
     * @param clienteAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Client cliente, Client clienteAComparar) {
        return cliente.getId() ==  clienteAComparar.getId();
    }
    
    
    
}
