package ec.edu.epn.grupo5.clientes;

import ec.edu.epn.grupo5.basededatos.ConexionBaseDatos;
import ec.edu.epn.grupo5.clientes.excepciones.ErrorCedula;
import ec.edu.epn.grupo5.validacion.ValidadorCedula;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;


public class ControladorClienteTest {

    @Mock
    private ControladorCliente controladorMock;
    private ConexionBaseDatos conexionMock;

    @Test
    public void given_any_simulated_clienteId_for_delete_when_is_correct_then_ok(){
        controladorMock = Mockito.mock(ControladorCliente.class);
        try {
            Mockito.when(controladorMock.eliminarCliente(Mockito.anyString())).thenReturn(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertTrue(controladorMock.eliminarCliente("1726354796"));
        } catch (ErrorCedula e) {
            e.printStackTrace();
        }
        System.out.println("Test 10");
    };

    @Test
    public void given_clientId_for_delete_when_is_incorrect_then_ok(){
        conexionMock = Mockito.mock(ConexionBaseDatos.class);
        ValidadorCedula validadorCedula = new ValidadorCedula();
        ControladorCliente controladorCliente = new ControladorCliente(conexionMock);
        boolean expected = true;
        try {
            validadorCedula.validar("1726354796");
        } catch (ErrorCedula e) {
            e.printStackTrace();
        }
        try {
            assertEquals(controladorCliente.eliminarCliente("1726354796"),expected);
        } catch (ErrorCedula e) {
            e.printStackTrace();
        }
        System.out.println("Test 11");
    }
}