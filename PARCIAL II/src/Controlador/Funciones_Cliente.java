package Controlador;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import Modelo.Cliente;

/**
 *
 * @author Steven_Useche Juan_Ochoa
 */
public class Funciones_Cliente {

    private ArrayList<Cliente> CL = new ArrayList<Cliente>();
    private Cliente c;
    final int coste = 10000;

    public boolean add_Cliente(String nombrecliente, int Cedula, int menbresia) {
        boolean registro = false;
        c = new Cliente(nombrecliente, Cedula, menbresia);
        if (CL.add(c)) {
            registro = true;
        }
        return registro;
    }

    public void consultar_cliente() {
        int documento, indice = -1, opcion;
        documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de documento"));
        if (CL.size() > 0) {
            for (int i = 0; i < CL.size(); i++) {
                if (CL.get(i).getCedula() == documento) {
                    indice = i;
                }
            }
            if (indice >= 0) {
                validarPago(CL.get(indice).getMenbresia());
            } else {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "El documento no existe \n¿Desea crearlo? \n1.Si \n2.No \nIngrese la opcion deseada"));
                switch (opcion) {
                    case 1:
                        datos_ingresar_cliente();
                        break;
                    case 2:
                        validarPago(1);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                        break;
                }

            }
        } else {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "El documento no existe \n¿Desea crearlo? \n1.Si \n2.No \nIngrese la opcion deseada"));
            switch (opcion) {
                case 1:
                    datos_ingresar_cliente();
                    break;
                case 2:
                    validarPago(1);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }

        }
    }

    public void datos_ingresar_cliente() {
        String nombrecliente;
        int Cedula;
        int menbresia;
        // PREGUNTAS
        nombrecliente = JOptionPane.showInputDialog(null, "Digite el nombre del cliente");
        Cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cedula"));
        menbresia = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Seleccione el tipo de mmebresia \n1.Estandar \n2.Premium \n3.Platino \n4.Oro \nDigite la menbresia"));
        if (add_Cliente(nombrecliente, Cedula, menbresia)) {
            JOptionPane.showMessageDialog(null, "Registro Existoso");
        } else {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear al cliente");
        }

    }

    public void validarPago(int tipo_menbresia) {
        int cantidadBoletas;
        double valorFinal, valorDescuento;

        cantidadBoletas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de boletas a comprar"));

        switch (tipo_menbresia) {
            case 1:
                if (cantidadBoletas > 2) {
                    valorDescuento = (cantidadBoletas * coste) * 0.05;
                    valorFinal = (cantidadBoletas * coste) - valorDescuento;
                } else {
                    valorFinal = (cantidadBoletas * coste);
                }
                JOptionPane.showMessageDialog(null,
                        "El valor a pagar por las " + cantidadBoletas + " boletas es \n$" + valorFinal);
                break;
            case 2:
                valorDescuento = (cantidadBoletas * coste) * 0.15;
                valorFinal = (cantidadBoletas * coste) - valorDescuento;
                JOptionPane.showMessageDialog(null,
                        "El valor a pagar por las " + cantidadBoletas + " boletas es \n$" + valorFinal);
                break;
            case 3:
                valorDescuento = (cantidadBoletas * coste) * 0.25;
                valorFinal = (cantidadBoletas * coste) - valorDescuento;
                cantidadBoletas++;
                JOptionPane.showMessageDialog(null,
                        "El valor a pagar por las " + cantidadBoletas + " boletas es \n$" + valorFinal);
                break;
            case 4:
                valorDescuento = (cantidadBoletas * coste) * 0.40;
                valorFinal = (cantidadBoletas * coste) - valorDescuento;
                cantidadBoletas += 2;
                JOptionPane.showMessageDialog(null,
                        "El valor a pagar por las " + cantidadBoletas + " boletas es \n$" + valorFinal);
                break;
        }
    }
}