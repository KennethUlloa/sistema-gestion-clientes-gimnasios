package ec.edu.epn.grupo5.clientes;

import ec.edu.epn.grupo5.basededatos.ConexionBaseDatos;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value= Parameterized.class)
public class ControladorClienteParametersTest {
    ConexionBaseDatos conexionBaseDatos=null;
    ControladorCliente controladorCliente=null;

    private String cedulaCliente;
    private boolean expected;

    @Before
    public void setUp(){

        conexionBaseDatos = new ConexionBaseDatos("jdbc:sqlite:gimnasio.db");
        this.controladorCliente = new ControladorCliente(conexionBaseDatos);
        //registra los clientes que se eliminaran en la prueba
        try {
            conexionBaseDatos.ejecutarSentencia("DELETE FROM clientes;");
            controladorCliente.registrarCliente(new Cliente("1725292542","Angelo Alexandro",
                    "Abad Abarca","15-08-1997",
                    'M',"0963870957",
                    "Diana Abad","0964255255",
                    "abad14@gmail.com","Av.Maldonado"));
            controladorCliente.registrarCliente(new Cliente("1727639633",
                    "Ana Paula",
                    "Panches Mora","01-05-1998",
                    'F',"0963870404",
                    "Diana Abad","0964255255",
                    "anaPaula14@outlook.com","A2C calle 3RA"));
            controladorCliente.registrarCliente(new Cliente("1722214887",
                    "Byron David",
                    "Paredes Atiencia","01-05-1980",
                    'M',"0963870404",
                    "Antonio Paredes","0964255255",
                    "anaPaula14@outlook.com","A2C calle 3RA"));
            controladorCliente.registrarCliente(new Cliente("1805395793",
                    "Franklin Fernando",
                    "Paredes Garcia","01-05-2003",
                    'F',"0963870404",
                    "Jesica Garcia","0964255255",
                    "anaPaula14@outlook.com","E2F A11"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects=new ArrayList<>();
        objects.add(new Object[]{"1725292542",true});
        objects.add(new Object[]{"1727639633",true});
        objects.add(new Object[]{"1600948235",true});
        objects.add(new Object[]{"1722214887",true});
        objects.add(new Object[]{"1805395793",true});
        objects.add(new Object[]{"9999999999",true});
        return objects;
    }

    public ControladorClienteParametersTest(String cedulaCliente, boolean expected) {
        this.cedulaCliente = cedulaCliente;
        this.expected = expected;
    }

    @Test
    public void given_parameters_when_delete_then_ok(){
        assertEquals(expected, controladorCliente.eliminarCliente(cedulaCliente));
    }

    @After
    public void tearDown(){

        try {
            conexionBaseDatos.ejecutarSentencia("DELETE FROM clientes;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}