/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Scheduling;

/**
 * Serviço Responsavel por manipulas as saidas de email ou notificacoes  do sistema
 * @author tiago
 */
public class Mail {
    
    public void NotificarPorEmail(Scheduling agendamento){
    
        String emailFormatado = formatarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();
        
        //Usando Classe Email para fazer os envios
        Email email = new Email("Agandamento BarberShop",emailFormatado,destinatario);
        email.enviar();
        
    }

    /**
     * Função auxiliar para formatar o texto do Email
     * @param agendamento
     * @return 
     */
    private String formatarEmail(Scheduling agendamento) {
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        float valor = agendamento.getValor();
        
        return "Olá "+ nomeCliente + " Vai dar um tapa no visu é... Seu agendamento para "+ servico+", esta marcado para dia "+ dataAgendamento
                +" às "+ horaAgendamento + "\n\n O preço para você sai baratin fica R$"+ valor + " \n\nGrande Abraço!!";
    }
    
}
