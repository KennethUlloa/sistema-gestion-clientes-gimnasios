package ec.edu.epn.grupo5.basededatos;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertSentenceTest {
    @Test
    public void given_insert_sentence_when_created_then_ok() throws Exception {
        InsertSentence insertSentence = new InsertSentence("clientes",
                "Kenneth Ulloa",
                "03-07-2000",
                "ulloakenth@gmail.com");
        String expected = "INSERT INTO clientes VALUES('Kenneth Ulloa','03-07-2000','ulloakenth@gmail.com')";
        assertEquals(expected, insertSentence.getSentence());
        System.out.println("Test 1");
    }

    @Test
    public void given_insert_sentence_when_no_table_then_error() {
        InsertSentence insertSentence = new InsertSentence("",
                "Kenneth Ulloa",
                "03-07-2000",
                "ulloakenth@gmail.com");
        assertThrows(Exception.class, insertSentence::getSentence);
        System.out.println("Test 2");
    }



}