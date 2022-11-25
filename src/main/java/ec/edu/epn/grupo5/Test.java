package ec.edu.epn.grupo5;

import ec.edu.epn.grupo5.basededatos.ConexionBaseDatos;
import ec.edu.epn.grupo5.basededatos.SQLTable;


public class Test {
    public static void main(String[] args) {
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos("jdbc:sqlite:gimnasio.db");
        try {
            SQLTable resultado = conexionBaseDatos.ejecutarSentencia("select * from clientes");
            System.out.println(resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
