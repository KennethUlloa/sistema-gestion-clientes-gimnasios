package ec.edu.epn.grupo5.clientes;

import ec.edu.epn.grupo5.basededatos.ConexionBaseDatos;
import ec.edu.epn.grupo5.basededatos.SQLTable;
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
        String cedula = cliente.getCedula();
        String nombres = cliente.getNombres();
        String apellidos = cliente.getApellidos();
        LocalDate fecha = cliente.getFecha();
        String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String sexo = cliente.getSexo() + "";
        String telefono=cliente.getTelefono();
        String nombreContacto = cliente.getNombreContacto();
        String telefonoContacto = cliente.getTelefonoContacto();
        String correoElectronico = cliente.getCorreoElectronico();
        String direccion = cliente.getDireccion();
        //String formato = "INSERT INTO clientes VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
        String sentencia = ControladorCliente.crearSentenciaInsertar(
                "clientes",
                cedula,
                nombres,
                apellidos,
                sexo,
                fechaFormateada,
                correoElectronico,
                telefono,
                nombreContacto,
                telefonoContacto,
                direccion);
        try{
            conexion.ejecutarSentencia(sentencia);
        }catch (SQLException ex){
            throw new Exception("El sistema no pudo registral al cliente");
        }

    }

    public static String crearSentenciaInsertar(String tabla, String... valores) {
        String consulta = "INSERT INTO " + tabla + " VALUES(";
        for(int i = 0; i < valores.length; i++) {
            consulta += "'" + valores[i] + "'";
            if (i != valores.length - 1){
                consulta += ",";
            }
        }
        consulta += ")";
        return  consulta;
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
