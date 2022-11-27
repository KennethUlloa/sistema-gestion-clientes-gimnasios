package ec.edu.epn.grupo5.clientes;

import ec.edu.epn.grupo5.basededatos.ConexionBaseDatos;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControladorClienteTest {
    @Test
    public void given_insert_client_when_not_valid_cedula_then_error(){
       Cliente c= new Cliente("1514","Angelo Alexandro",
                "Abad Abarca","15-08-1997",
                'M',"0963870957",
                "Diana Abad","0964255255",
                "abad14@gmail.com","Av.Maldonado");

       ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos("jdbc:sqlite:gimnasio.db");
       ControladorCliente controladorCliente=new ControladorCliente(conexionBaseDatos);

        Exception error=null;
        try {
            controladorCliente.registrarCliente(c);
        } catch (Exception e) {
            error=e;
        }

        assertNotNull(error);
    }
}