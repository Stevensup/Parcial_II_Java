package Controlador;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import Modelo.Pelicula;

/**
 *
 * @author Steven_Useche Juan_Ochoa
 */
public class Funciones_Pelicula {

    private ArrayList<Pelicula> CR = new ArrayList<Pelicula>();
    private Pelicula b;

    public void add_Cartelera(String nombrePelicula, String tipo_publico, String genero, int durancion,
            int anio_lanzamiento,
            boolean estado_pelicula) {
        b = new Pelicula(nombrePelicula, tipo_publico, genero, durancion, anio_lanzamiento, estado_pelicula);
        CR.add(b);
    }

    public void datos_ingresar_cartelera() {
        String nombrePelicula;
        String tipo_publico;
        String genero;
        int durancion;
        int anio_lanzamiento;
        boolean estado_pelicula = true;
        // PREGUNTAS
        nombrePelicula = JOptionPane.showInputDialog("Ingrese pelicula");
        tipo_publico = JOptionPane.showInputDialog("Ingrese tipo publico");
        genero = JOptionPane.showInputDialog("Ingrese genero");
        durancion = Integer.parseInt(JOptionPane.showInputDialog("Ingresar durancion en mins "));
        anio_lanzamiento = Integer.parseInt(JOptionPane.showInputDialog("Ingresar año lanzamiento "));
        // System.out.println(nombrePelicula + tipo_publico + genero + durancion +
        // anio_lanzamiento);
        // LLAMO LA FUNC DEL ARRAY PARA GUARDAR LOS DATOS
        add_Cartelera(nombrePelicula, tipo_publico, genero, durancion, anio_lanzamiento, estado_pelicula);
    }

    public void listar_Cartelera(int tipo_busqueda, String datos_buscar) {

        if (tipo_busqueda == 0) {
            for (Pelicula pelicula : CR) {
                JOptionPane.showMessageDialog(null,
                        " Pelicula " + pelicula.getNombrePelicula() + " \n Orientado a Publico "
                                + pelicula.getTipo_publico() + " \n Genero " + pelicula.getGenero()
                                + " \n la duracion de la pelicula es de " + pelicula.getDurancion() + " minutos"
                                + " \n Año de lanzamiento: " + pelicula.getAnio_lanzamiento());
            }
        } else {
            String[] indices;
            indices = datos_buscar.split(",");
            for (int i = 0; i < indices.length; i++) {
                JOptionPane.showMessageDialog(null, "Id: " + indices[i] +
                        "\n Pelicula " + CR.get(Integer.parseInt(indices[i])).getNombrePelicula()
                        + " \n Orientado a Publico "
                        + CR.get(Integer.parseInt(indices[i])).getTipo_publico() + " \n Genero "
                        + CR.get(Integer.parseInt(indices[i])).getGenero()
                        + " \n la duracion de la pelicula es de "
                        + CR.get(Integer.parseInt(indices[i])).getDurancion() + " minutos"
                        + " \n Año de lanzamiento: "
                        + CR.get(Integer.parseInt(indices[i])).getAnio_lanzamiento());
            }
        }

    }

    public void eliminar_pelicula() {
        int Delete_pelicula;
        String Filmes;
        JOptionPane.showMessageDialog(null, "------------------------- FILMS -------------------------\n");
        for (int i = 0; i < CR.size(); i++) {
            JOptionPane.showMessageDialog(null,
                    (" Numero de la lista: " + i) + "\n Nombre de la Pelicula: " + CR.get(i).getNombrePelicula()
                            + "\n Dirigido a Publico: "
                            + CR.get(i).getTipo_publico() + "\n Genero: "
                            + CR.get(i).getGenero() + "\n Duracion de la Pelicula: "
                            + CR.get(i).getDurancion() + "\n Año de Lanzamiento: "
                            + CR.get(i).getAnio_lanzamiento());
            // System.out.println(" Nombre de la Pelicula: " + CR.get(i).getNombrePelicula()
            // + "Dirigido a Publico: "
            // + CR.get(i).getTipo_publico() + " Genero: "
            // + CR.get(i).getGenero() + " Duracion de la Pelicula: "
            // + CR.get(i).getDurancion() + " Año de Lanzamiento: "
            // + CR.get(i).getAnio_lanzamiento() + ("Numero en Lista" + i));
        }
        String delete = "Que pelicula desea eliminar \n";
        JOptionPane.showMessageDialog(null, "-------Eliminar con el numero de lista--------\n digitalo por favor \n");
        Delete_pelicula = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el ID de la pelicula a eliminar"));
        // System.out.println(Delete_pelicula);
        CR.remove(Delete_pelicula);
    }

    public void actualizar_pelicula() {
        if (menuBusqueda()) {
            int opcionPeli;
            int opcion_modificar;
            String dato_String;
            int dato_entero;
            opcionPeli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id de la pelicula a modificar"));
            opcion_modificar = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Indique el campo a modificar \n1.Nombre de la pelicula \n2.Genero \n3.Tipo de publico \n4.Duracion \n5.Año \nSalir"));

            switch (opcion_modificar) {
                case 1:
                    dato_String = JOptionPane.showInputDialog("Nuevo nombre");
                    CR.get(opcionPeli).setNombrePelicula(dato_String);
                    break;
                case 2:
                    dato_String = JOptionPane.showInputDialog("Nuevo genero");
                    CR.get(opcionPeli).setGenero(dato_String);
                    break;
                case 3:
                    dato_String = JOptionPane.showInputDialog("Nuevo tipo de publico");
                    CR.get(opcionPeli).setTipo_publico(dato_String);
                    break;
                case 4:
                    dato_entero = Integer.parseInt(JOptionPane.showInputDialog("Nueva duracion"));
                    CR.get(opcionPeli).setDurancion(dato_entero);
                    break;
                case 5:
                    dato_entero = Integer.parseInt(JOptionPane.showInputDialog("Nueva Año"));
                    CR.get(opcionPeli).setAnio_lanzamiento(dato_entero);
                    break;

            }

        }
    }

    public boolean menuBusqueda() {
        int Opcionlistada;
        String dato_string = null;
        int dato_entero = 0;
        boolean existe = false;
        String opcionlista = JOptionPane.showInputDialog(
                "\n\tMenu Inicial \n\t1. Consultar por nombre pelicula \n\t2. Consultar por genero \n\t3. Consultar por tipo de publico \n\t4. Consultar por duracion \n\t5. Buscar por año \n\t6. Salir \n\tDigite la opcion:");
        Opcionlistada = Integer.parseInt(opcionlista);
        switch (Opcionlistada) {
            case 1:
                dato_string = JOptionPane.showInputDialog("Ingrese el nombre");
                if (Buscador_Cartelera(Opcionlistada, dato_string, dato_entero)) {
                    existe = true;
                }
                break;
            case 2:
                dato_string = JOptionPane.showInputDialog("Ingrese el genero");
                if (Buscador_Cartelera(Opcionlistada, dato_string, dato_entero)) {
                    existe = true;
                }
                break;
            case 3:
                dato_string = JOptionPane.showInputDialog("Ingrese el tipo de publico");
                if (Buscador_Cartelera(Opcionlistada, dato_string, dato_entero)) {
                    existe = true;
                }
                break;
            case 4:
                dato_entero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion"));
                if (Buscador_Cartelera(Opcionlistada, dato_string, dato_entero)) {
                    existe = true;
                }
                break;
            case 5:
                dato_entero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año"));
                if (Buscador_Cartelera(Opcionlistada, dato_string, dato_entero)) {
                    existe = true;
                }
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Ha salido del buscador");
            default:
                JOptionPane.showMessageDialog(null, "Opcion no disponible");
                break;
        }
        return existe;
    }

    public boolean Buscador_Cartelera(int opcion_busqueda, String dato_string, int dato_entero) {
        String encontrados = "";
        boolean existe = false;
        int contador_si = 0;

        switch (opcion_busqueda) {
            case 1:
                for (int i = 0; i < CR.size(); i++) {
                    if (CR.get(i).getNombrePelicula().equals(dato_string)) {
                        encontrados += i + ",";
                        contador_si++;
                    }
                }
                if (contador_si > 0) {
                    listar_Cartelera(1, encontrados);
                    existe = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontragon coincidencias");
                }
                break;
            case 2:
                for (int i = 0; i < CR.size(); i++) {
                    if (CR.get(i).getGenero().equals(dato_string)) {
                        encontrados += i + ",";
                        contador_si++;
                    }
                }
                if (contador_si > 0) {
                    listar_Cartelera(1, encontrados);
                    existe = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontragon coincidencias");
                }
                break;
            case 3:
                for (int i = 0; i < CR.size(); i++) {
                    if (CR.get(i).getTipo_publico().equals(dato_string)) {
                        encontrados += i + ",";
                        contador_si++;
                    }
                }
                if (contador_si > 0) {
                    listar_Cartelera(1, encontrados);
                    existe = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontragon coincidencias");
                }
                break;
            case 4:
                for (int i = 0; i < CR.size(); i++) {
                    if (CR.get(i).getDurancion() == dato_entero) {
                        encontrados += i + ",";
                        contador_si++;
                    }
                }
                if (contador_si > 0) {
                    listar_Cartelera(1, encontrados);
                    existe = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontragon coincidencias");
                }
                break;
            case 5:
                for (int i = 0; i < CR.size(); i++) {
                    if (CR.get(i).getAnio_lanzamiento() == dato_entero) {
                        encontrados += i + ",";
                        contador_si++;
                    }
                }
                if (contador_si > 0) {
                    listar_Cartelera(1, encontrados);
                    existe = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontragon coincidencias");
                }
                break;
        }
        return existe;
    }
}
