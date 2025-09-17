/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Service;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class ServiceDAO {
    
    
    /**
     * Insere um servico dentro do banco de dados
     * @param servico exige que seja passado um objeto do tipo servico
     */
    public void insert(Service servico){
        Database.servico.add(servico);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param servico
     * @return 
     */
    public boolean update(Service servico){
        
        for (int i = 0; i < Database.servico.size(); i++) {
            if(idSaoIguais(Database.servico.get(i),servico)){
                Database.servico.set(i, servico);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do servico passado
     * @param servico
     * @return 
     */
    public boolean delete(Service servico){
        for (Service servicoLista : Database.servico) {
            if(idSaoIguais(servicoLista,servico)){
                Database.servico.remove(servicoLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os servicos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Service> selectAll(){
        return Database.servico;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param servico
     * @param servicoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Service servico, Service servicoAComparar) {
        return servico.getId() ==  servicoAComparar.getId();
    }
    
}
