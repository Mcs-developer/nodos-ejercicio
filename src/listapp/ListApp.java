/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listapp;

/**
 *
 * @author mchara
 */
public class ListApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedListPersona lp = new LinkedListPersona();
        
        lp.adicionarAlInicio(new Persona("Marlon"));
        lp.adicionarAlInicio(new Persona("Brayan"));
        lp.adicionarAlInicio(new Persona("CESAR"));
        
        lp.quitarAlFinal();
    }
    
}
