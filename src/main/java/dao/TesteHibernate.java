/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.JPAUtil;
import javax.persistence.EntityManager;
import modelo.Usuario;

/**
 *
 * @author tiago
 */
public class TesteHibernate {
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        //Codigo de Persistencia Aqui
            
        em.getTransaction().commit();
        em.close();
        
    }
}
