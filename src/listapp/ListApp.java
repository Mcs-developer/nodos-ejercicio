/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listapp;

import javax.swing.JOptionPane;

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
        int option = 1; // si
        int id = 1;
        String[] genders = {"M", "F"};
        do {
            String msj = "Bienvenido al juego de listas, aqui podra realizar operaciones con listas, como agregar, eliminar, y leer\n";
            msj += "Estas son las opciones que se pueden realizar:\n";

            msj += "1. Agregar persona al inicio de la lista\n";
            msj += "2. Agregar persona al final de la lista\n";
            msj += "3. Agregar persona antes de..\n";
            msj += "4. Agregar persona despues de..\n";
            msj += "5. Eliminar persona al inicio de la lista\n";
            msj += "6. Eliminar persona del final de la lista\n";
            msj += "7. Eliminar persona en una posicion determinada\n";
            msj += "8. Mostrar lo que hay en la lista\n";
            msj += "9. Actualizar persona\n";
            msj += "10. Salir";

            String respuesta = JOptionPane.showInputDialog(msj);
            if (respuesta != null) {
                switch (respuesta) {
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        String cedula;
                        do {
                             cedula = JOptionPane.showInputDialog(null, "Escriba la cédula de la persona");
                             if(lp.tamano > 0 && lp.contiene(cedula)) JOptionPane.showMessageDialog(null, "Esta persona ya existe en la lista");
                        }while(lp.tamano > 0 && lp.contiene(cedula));
                        //buscar cedula, si existe mostrar mensaje, sino continuar...
                        String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre de la persona");
                        String apellido = JOptionPane.showInputDialog(null, "Escriba el apellido de la persona");
                        int seleccion = JOptionPane.showOptionDialog(null, "Eliga el género", "Genero", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, genders, null);

                        if (respuesta.equals("1")) {
                            lp.adicionarAlInicio(new Persona(id, cedula, nombre, apellido, seleccion == 0 ? "M" : "F"));
                        } else if (respuesta.equals("2")) {
                            lp.adicionarAlFinal(new Persona(id, cedula, nombre, apellido, seleccion == 0 ? "M" : "F"));
                        } else {
                            String posicion = JOptionPane.showInputDialog((respuesta.equals("3") ? "Antes " : "Despues ") + "de que persona ?\n\n" + lp.toString());
                            if (isInteger(posicion)) {
                                if (respuesta.equals("3")) {
                                    lp.insertarAntesDe(new Persona(Integer.parseInt(posicion), null, null, null, null), new Persona(id, cedula, nombre, apellido, seleccion == 0 ? "M" : "F"));
                                } else {
                                    lp.insertarDespuesDe(new Persona(Integer.parseInt(posicion), null, null, null, null), new Persona(id, cedula, nombre, apellido, seleccion == 0 ? "M" : "F"));
                                }
                            }
                        }
                        id++;
                        break;
                    case "5":
                        lp.quitarAlInicio();
                        JOptionPane.showMessageDialog(null, "Primera persona eliminada");
                        break;
                    case "6":
                        lp.quitarAlFinal();
                        JOptionPane.showMessageDialog(null, "Ultima persona eliminada");
                        break;
                    case "7":
                        String posicion = JOptionPane.showInputDialog("Que persona desea eliminar ?\n\n" + lp.toString());
                        if (isInteger(posicion)) {
                            lp.eliminarNodo(new Persona(Integer.parseInt(posicion), null, null, null, null));
                        }
                        break;
                    case "8":
                        JOptionPane.showMessageDialog(null, lp.toString());
                        break;
                    case "9":
                        String p = JOptionPane.showInputDialog("Que registro desea actualizar ?\n\n" + lp.toString());
                        if (isInteger(p)) {
                            try {
                                Persona temp = lp.getPersona(new Persona(Integer.parseInt(p), null, null, null, null));
                                String nuevaCedula;
                                do {
                                    nuevaCedula = JOptionPane.showInputDialog(null, "Nueva cedula", temp.getCedula());
                                    if(lp.contiene(nuevaCedula) && !temp.getCedula().equals(nuevaCedula)) JOptionPane.showMessageDialog(null, "Esta cédula ya existe, por favor digite otro número");
                                } while (lp.contiene(nuevaCedula) && !temp.getCedula().equals(nuevaCedula));
                                String nuevoNombre = JOptionPane.showInputDialog(null, "Nuevo nombre", temp.getNombre());
                                String nuevoApellido = JOptionPane.showInputDialog(null, "Nuevo apellido", temp.getApellido());
                                int nuevaseleccion = JOptionPane.showOptionDialog(null, "Eliga el género", "Genero", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, genders, null);

                                temp.setCedula(nuevaCedula);
                                temp.setNombre(nuevoNombre);
                                temp.setApellido(nuevoApellido);
                                temp.setSexo((nuevaseleccion == 0 ? "M" : "F"));
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, "Persona no encontrada para actualizar");
                            }

                        }
                        break;
                    case "10":
                        option = 0;
                        continue;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no encontrada");
                        continue;
                }
            }

            option = JOptionPane.showConfirmDialog(null, "¿Desea terminar el programa y ver la lista?", "Alerta!", JOptionPane.YES_NO_OPTION);

        } while (option == 1);

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public void test() {
        //Test Adicionar al final
//        lp.adicionarAlFinal(new Persona("A"));
//        lp.adicionarAlFinal(new Persona("B"));
//        lp.adicionarAlFinal(new Persona("C"));
//        lp.adicionarAlFinal(new Persona("D"));
//        lp.adicionarAlFinal(new Persona("E"));

        //Test adicionar al principio
//        lp.adicionarAlInicio(new Persona("A"));
//        lp.adicionarAlInicio(new Persona("B"));
//        lp.adicionarAlInicio(new Persona("C"));
//        lp.adicionarAlInicio(new Persona("D"));
//        lp.adicionarAlInicio(new Persona("E"));
        //adicionar despues de 
//        lp.insertarDespuesDe(new Persona("C"), new Persona("Z"));
        //adicionar antes de
//        lp.insertarAntesDe(new Persona("C"), new Persona("Z"));
        //test adicionar alternado
//        lp.adicionarAlFinal(new Persona("A"));
//        lp.adicionarAlFinal(new Persona("B"));
//        lp.adicionarAlInicio(new Persona("C"));
//        lp.adicionarAlInicio(new Persona("D"));
//        lp.adicionarAlFinal(new Persona("E"));
        //quitar al inicio
//        lp.quitarAlInicio();
//        lp.quitarAlInicio();
        //quitar al final
//        lp.quitarAlFinal();
//        lp.quitarAlFinal();
        //quitar elemento
//        lp.eliminarNodo(new Persona("E"));
    }

}
