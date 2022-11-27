package ec.edu.epn.grupo5.clientes.herramientas;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void given_localDate_when_parse_to_string_then_ok(){
        assertEquals("15-04-2000", Parser.localDateAString(LocalDate.of(2000,4,15)));

    }


}