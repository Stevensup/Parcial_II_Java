/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import javax.swing.JOptionPane;

/**
 *
 * @author Steven_Useche Juan_Ochoa
 * 
 */
public class Principal {

    public static void main(String[] args) {
        // Scanner dato = new Scanner(System.in);
        int opcionInicial, documento, pass;
        Funciones_Pelicula fucp = new Funciones_Pelicula();
        Funciones_Cliente fucl = new Funciones_Cliente();

        do {
            String nombre = JOptionPane.showInputDialog(
                    "\n\tMenu Inicial \n\t1. Consultar Cartelera \n\t2. Consultar Cliente \n\t3. Administrar Cartelera \n\t4. Salir \n\tDigite la opcion:");
            opcionInicial = Integer.parseInt(nombre);

            switch (opcionInicial) {

                case 1:
                    fucp.listar_Cartelera(0, null);
                    fucp.menuBusqueda();
                    break;
                case 2:
                    fucl.consultar_cliente();
                    break;
                case 3:
                    String salida3 = JOptionPane.showInputDialog("Ingrese USUARIO");
                    documento = Integer.parseInt(salida3);
                    String salida4 = JOptionPane.showInputDialog("Ingrese PASSWORD");
                    pass = Integer.parseInt(salida4);
                    if (documento == 123 && pass == 456) {
                        JOptionPane.showMessageDialog(null, "Ingreso Correcto");
                        int OpcionCartelera;
                        do {
                            String option = JOptionPane.showInputDialog(
                                    "\n\tMenu Inicial \n\t1. Consultar Cartelera \n\t2. Añadir Pelicula \n\t3. Actualizar Pelicula \n\t4. Borrar Pelicula \n\t5. Salir \n\tDigite la opcion:");
                            OpcionCartelera = Integer.parseInt(option);
                            switch (OpcionCartelera) {
                                case 1:
                                    fucp.listar_Cartelera(0, null);
                                    break;
                                case 2:
                                    fucp.datos_ingresar_cartelera();
                                    break;

                                case 3:
                                    fucp.actualizar_pelicula();
                                    break;

                                case 4:
                                    fucp.eliminar_pelicula();
                                    break;

                                case 5:
                                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el servicio");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opcion no disponible");
                            }
                        } while (OpcionCartelera != 5);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingreso Incorrecto");
                    }

                    break;
                default:
                    // String salida5;
                    salida3 = ("Ha salido del programa");
                    JOptionPane.showMessageDialog(null, salida3, "CONSULTA", 0);
                    break;
            }

        } while (opcionInicial != 4);

    }
}
