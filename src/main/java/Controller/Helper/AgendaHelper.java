/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Scheduling;
import Model.Client;
import Model.Service;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tiago
 */
public class AgendaHelper implements IHelper{

    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }
    
    
    public void preencherTabela(ArrayList<Scheduling> agendamentos){
        
        //Tabela tambem funciona com MVC precisamos pegar o mode da tabela
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo o tableModel
        
        for (Scheduling agendamento : agendamentos) {
            
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
            
        }        
        
    }
    
    public void preencherClientes(ArrayList<Client> clientes){
        
        DefaultComboBoxModel comboBoxmodel = (DefaultComboBoxModel) view.getJComboBoxCliente().getModel();
        
        for (Client cliente : clientes) {
            comboBoxmodel.addElement(cliente); //aqui esta a sacada adicionar cliente e nao cliente getnome()          
        }  
    }

    public void preencherServicos(ArrayList<Service> servicos) {
        
        DefaultComboBoxModel comboBoxmodel = (DefaultComboBoxModel) view.getJComboBoxServico().getModel();
        
        for (Service servico : servicos) {
            comboBoxmodel.addElement(servico);
        }
        
    }

    public Service obterServico() {
        return (Service) view.getJComboBoxServico().getSelectedItem();
    }
    
    public Client obterCliente(){
        return (Client) view.getJComboBoxCliente().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getTextValor().setText(valor+"");
    }

    
    @Override
    public Scheduling obterModelo() {
        
        String idString = view.getTextId().getText();
        int id = Integer.parseInt(idString);
        Client cliente = obterCliente();
        Service servico = obterServico();
        String valorString = view.getTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getTextFormatedData().getText();
        String hora = view.getTextFormatedHora().getText();
        String dataHora = data + " " + hora;
        String observacao = view.getTextObservacao().getText();
        
        Scheduling agendamento = new Scheduling(id, cliente, servico, valor, dataHora, observacao);
        return agendamento;
        
    }

    @Override
    public void limparTela() {
        view.getTextId().setText("0");
        view.getTextFormatedData().setText("");
        view.getTextFormatedHora().setText("");
        view.getTextObservacao().setText("");
    }

    


    
}
