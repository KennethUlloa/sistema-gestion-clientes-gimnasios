package ec.edu.epn.grupo5.basededatos;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteSentenceTest {
    @Test
    public void given_delete_sentence_when_created_then_ok () throws Exception {
        DeleteSentence deleteSentence = new DeleteSentence("tabla", "id = 1");
        String expected = "DELETE FROM tabla WHERE id = 1";
        assertEquals(expected, deleteSentence.getSentence());
        System.out.println("DeleteSentence: Test 1");
    }

    @Test
    public void given_delete_sentence_when_no_condition_then_ok () throws Exception {
        DeleteSentence deleteSentence = new DeleteSentence("tabla", "");
        String expected = "DELETE FROM tabla";
        assertEquals(expected, deleteSentence.getSentence());
        System.out.println("DeleteSentence: Test 2");
    }
}