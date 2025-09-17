/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Scheduling;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class SchedulingDAO {
    
    /**
     * Insere um agendamento dentro do banco de dados
     * @param agendamento exige que seja passado um objeto do tipo agendamento
     */
    public void insert(Scheduling agendamento){
          
        if(agendamento.getId() == 0){
            agendamento.setId(proximoId());
            Database.agendamento.add(agendamento);
        }
        
        
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param agendamento
     * @return 
     */
    public boolean update(Scheduling agendamento){
        
        for (int i = 0; i < Database.agendamento.size(); i++) {
            if(idSaoIguais(Database.agendamento.get(i),agendamento)){
                Database.agendamento.set(i, agendamento);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do agendamento passado
     * @param agendamento
     * @return 
     */
    public boolean delete(Scheduling agendamento){
        for (Scheduling agendamentoLista : Database.agendamento) {
            if(idSaoIguais(agendamentoLista,agendamento)){
                Database.agendamento.remove(agendamentoLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os agendamentos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Scheduling> selectAll(){
        return Database.agendamento;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param agendamento
     * @param agendamentoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Scheduling agendamento, Scheduling agendamentoAComparar) {
        return agendamento.getId() ==  agendamentoAComparar.getId();
    }
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Scheduling agendamento : Database.agendamento) {           
           int id = agendamento.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
            
        }
        
        return maiorId + 1;
    }
    
}
