/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Scheduling;
import Model.Client;
import Model.DAO.SchedulingDAO;
import Model.DAO.ClientDAO;
import Model.DAO.ServiceDAO;
import Model.Service;
import Service.Mail;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class AgendaController {

    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
    
        //Buscar Lista com agendamentos do banco de dados
        SchedulingDAO agendamentoDAO = new SchedulingDAO();
        ArrayList<Scheduling> agendamentos = agendamentoDAO.selectAll();//depurar aqui
        
        //Exibir essa lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaClientes(){
        //Buscar Clientes do banco
        ClientDAO clienteDAO = new ClientDAO();
        ArrayList<Client> clientes = clienteDAO.selectAll();
        
        //Exibir clientes no combobox cliente
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServicos(){
    
        //Buscar Servicos do Banco
        ServiceDAO servicoDAO = new ServiceDAO();
        ArrayList<Service> servicos = servicoDAO.selectAll();
        
        //Exibir Servicos na combobox Service
        helper.preencherServicos(servicos);
    }

    public void atualizaValor() {
        Service servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }

    public void agendar() {
        
        //Buscar Objeto Scheduling da Tela
        Scheduling agendamento = helper.obterModelo();
        
        //Salvar no banco de dados
        SchedulingDAO agendamentoDAO = new SchedulingDAO();
        agendamentoDAO.insert(agendamento);
        
        //atualizar Tabela
        atualizaTabela();
        
        helper.limparTela();
       
        //notifica cliente por email
        Mail correio = new Mail();
        correio.NotificarPorEmail(agendamento);
    }
    
}
