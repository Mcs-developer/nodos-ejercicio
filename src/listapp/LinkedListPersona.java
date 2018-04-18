/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listapp;

import java.util.NoSuchElementException;

/**
 *
 * @author mchara
 */
public class LinkedListPersona  {
    private Nodo inicio;

    public int tamano = 0;
    
    public void adicionarAlInicio(Persona p) {
        inicio = new Nodo(p,inicio);
        tamano++;
    }
    
    public Persona obtenerPrimero()
    {
        if(inicio == null) throw new NoSuchElementException();
        
        return inicio.getPersona();
    }
    
    public Persona quitarAlInicio(){
        inicio = inicio.getSiguiente();
        tamano--;
        return this.obtenerPrimero();
        
    }
    
    
    public void adicionarAlFinal(Persona p){
        if(inicio == null)
            adicionarAlInicio(p);
        else {
            Nodo tmp = inicio;
            while(tmp.getSiguiente() != null) tmp = tmp.getSiguiente();
            tmp.setSiguiente(new Nodo(p, null));
            tamano++;
        }
        
    }
    
    public Persona obternerUltimo(){
        if(inicio == null) throw new NoSuchElementException();
        Nodo tmp = inicio;
        while(tmp.getSiguiente() != null) tmp = tmp.getSiguiente();
        
        return tmp.getPersona();
        
    }
    
    public void quitarAlFinal(){
        Nodo tmp = inicio;
        Nodo anterior = null;
        while(tmp.getSiguiente() != null){
           anterior = tmp;
           tmp = tmp.getSiguiente();
        }
        anterior.setSiguiente(null);
        tamano--;
    }
    
    
    public void insertarDespuesDe(Persona clave, Persona insertar){
        Nodo tmp = inicio;
        while(tmp != null && !tmp.getPersona().equals(clave)) tmp = tmp.getSiguiente();
        
        if(tmp != null) {
            tmp.setSiguiente(new Nodo(insertar,tmp.getSiguiente()));
        }
    }
    
    public void insertarAntesDe(Persona clave, Persona insertar){
       
        if(inicio == null) return;
        
        if(inicio.getPersona().equals(clave)){
            adicionarAlInicio(insertar);
            return;
        }
        
        Nodo anterior = null;
        Nodo actual = inicio;
        
        while(actual != null && !actual.getPersona().equals(clave)){
            anterior = actual;
            actual = actual.getSiguiente();
        }
        
        if(actual != null){
            anterior.setSiguiente(new Nodo(insertar,actual));
        }
    }
    
    
    public void eliminarNodo(Persona p){
        if(inicio == null) return;
        
        if(inicio.getPersona().equals(p)){
            inicio = inicio.getSiguiente();
            return;
        }
        
        Nodo anterior = null;
        Nodo actual = inicio;
        
        while(actual != null && !actual.getPersona().equals(p)){
            anterior = actual;
            actual = actual.getSiguiente();
        }
        
        if(actual == null){
            throw new RuntimeException("No se puede eliminar");
        }
        
        anterior.setSiguiente(actual.getSiguiente());
    }
    
    public Persona getPersona(Persona p){
        if(inicio.getPersona().equals(p)){
           
            return inicio.getPersona();
        }
        
        Nodo tmp = inicio.getSiguiente();
        
        while(tmp != null && !tmp.getPersona().equals(p)){
            tmp = tmp.getSiguiente();
        }
        
        if(tmp == null)
            throw new RuntimeException("No se puede actualizar");
        
        return tmp.getPersona();
    }
    
    public boolean contiene(String cedula){
        if (inicio == null) throw new IndexOutOfBoundsException();
        
        Nodo tmp = inicio;
        while(tmp != null){
            if(tmp.getPersona().getCedula().equals(cedula))
                return true;
            tmp = tmp.getSiguiente();
        }
        
       return false;
    }
    
    

    @Override
    public String toString() {
        String str = "";
        Nodo tmp = inicio;
        while(tmp != null){
            
            str += tmp.getPersona().getCod() + ". " + 
                  tmp.getPersona().getCedula() + " - " + 
                  tmp.getPersona().getNombre() + " " + 
                  tmp.getPersona().getApellido() + " - " +
                  tmp.getPersona().getSexo() + "\n";
            tmp = tmp.getSiguiente();
            
        }
        return str; //To change body of generated methods, choose Tools | Templates.
    }
    
}
