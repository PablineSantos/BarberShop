/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Agenda;
import View.MainMenu;

/**
 *
 * @author tiago
 */
public class MainMenuController {

    private final MainMenu view;

    public MainMenuController(MainMenu view) {
        this.view = view;
    }
    
    
    public void navegarParaAgenda(){
        
        Agenda agenda = new Agenda();
        agenda.setVisible(true);       
    }
    
}
