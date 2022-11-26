package ec.edu.epn.grupo5.clientes;

import ec.edu.epn.grupo5.basededatos.*;
import ec.edu.epn.grupo5.validacion.ValidadorCedula;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ControladorCliente {
    //a
    private ConexionBaseDatos conexion;

    public ControladorCliente(ConexionBaseDatos conexion) {
        this.conexion = conexion;
    }

    public void registrarCliente(Cliente cliente) throws Exception{

        InsertSentence sentencia = new InsertSentence(
                "clientes",
                cliente.getCedula(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getSexo() + "",
                cliente.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                cliente.getCorreoElectronico(),
                cliente.getTelefono(),
                cliente.getNombreContacto(),
                cliente.getTelefonoContacto(),
                cliente.getDireccion());
        try{

            conexion.ejecutarSentencia(sentencia.getSentence());
        }catch (SQLException ex){
            throw new Exception("El sistema no pudo registral al cliente");
        }
    }
    public Cliente consultarCliente(String cedula) throws Exception {
        ValidadorCedula validadorCedula = new ValidadorCedula();
        validadorCedula.validar(cedula);
        try{
            SQLTable resultado = conexion.realizarConsulta("select * from clientes where cedula="+cedula);
            String nombres = resultado.getValueAt(0,"nombres");
            String apellidos = resultado.getValueAt(0,"apellidos");
            String fecha = resultado.getValueAt(0,"fecha_nacimiento");
            char sexo = resultado.getValueAt(0,"sexo").charAt(0);
            String telefono = resultado.getValueAt(0,"telefono");
            String nombreContacto = resultado.getValueAt(0,"nombre_contacto");
            String telefonoContacto = resultado.getValueAt(0,"telefono_contacto");
            String correoElectronico = resultado.getValueAt(0,"correo_electronico");
            String direccion = resultado.getValueAt(0,"direccion");
            return new Cliente(cedula, nombres, apellidos, fecha, sexo, telefono, nombreContacto,
                    telefonoContacto, correoElectronico, direccion);
        }catch (Exception ex){
            throw new Exception("El sistema no pudo realizar la consulta");
        }
    }
}
