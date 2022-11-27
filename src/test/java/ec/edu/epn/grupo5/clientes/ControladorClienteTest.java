package ec.edu.epn.grupo5.clientes;

import ec.edu.epn.grupo5.basededatos.ConexionBaseDatos;
import ec.edu.epn.grupo5.clientes.excepciones.ErrorCedula;
import ec.edu.epn.grupo5.validacion.ValidadorCedula;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.w3c.dom.ls.LSOutput;

import static org.junit.Assert.*;

public class ControladorClienteTest {
    @Mock
    ControladorCliente controladorMock;
    ConexionBaseDatos conexionMock;

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
    @Test
    public void given_any_simulated_clientID_for_delete_when_is_correct_then_ok() throws Exception{
        controladorMock= Mockito.mock(ControladorCliente.class);
        Mockito.when(controladorMock.eliminarCliente(Mockito.anyString())).thenReturn(true);
        assertTrue(controladorMock.eliminarCliente("1726354796"));
        System.out.println("Test 10");
        }
    @Test
    public void given_clientID_for_delete_when_is_correct_then_ok() throws Exception{
        ValidadorCedula validadorCedula = new ValidadorCedula();
        ConexionBaseDatos conexionMock = Mockito.mock(ConexionBaseDatos.class);
        ControladorCliente controladorCliente = new ControladorCliente(conexionMock);
        boolean expected = true;
        validadorCedula.validar("1726354796");
        assertEquals(controladorCliente.eliminarCliente("1726354796"),expected);
        System.out.println("Test 11");
    }
}

