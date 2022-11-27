package ec.edu.epn.grupo5.clientes.herramientas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(value= Parameterized.class)

public class ParserParametersTest {
    private String fecha;
    private LocalDate expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects=new ArrayList<>();

        objects.add(new Object[]{"02-06-2001", LocalDate.of(2001,6,2)});
        objects.add(new Object[]{"04-05-1999", LocalDate.of(1999,5,4)});
        objects.add(new Object[]{"07-12-2022", LocalDate.of(2022,12,7)});
        objects.add(new Object[]{"02-06-2003", LocalDate.of(2003,6,2)});
        objects.add(new Object[]{"17-01-1880", LocalDate.of(1880,1,17)});
        return objects;
    }

    public ParserParametersTest(String fecha, LocalDate expected) {
        this.fecha = fecha;
        this.expected = expected;
    }

    @Test
    public void given_parameters_when_parse_then_ok(){
        Parser p=new Parser();
        assertEquals(expected, p.stringALocalDate(fecha));
    }

}