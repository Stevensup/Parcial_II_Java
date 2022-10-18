package Modelo;

public class Cliente {

    private String nombrecliente;
    private int Cedula;
    private int  menbresia;


    public Cliente(String nombrecliente, int Cedula, int menbresia) {
        this.nombrecliente = nombrecliente;
        this.Cedula = Cedula;
        this.menbresia = menbresia;

    }

    public String getNombrecliente() {
        return nombrecliente;
    }


    public int getCedula() {
        return Cedula;
    }


    public int getMenbresia() {
        return menbresia;
    }

}
