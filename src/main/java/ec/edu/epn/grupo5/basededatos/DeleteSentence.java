package ec.edu.epn.grupo5.basededatos;

public class DeleteSentence implements SQLSentence {
    private final String table;
    private final String condition;

    public DeleteSentence(String table, String condition) {
        this.table = table;
        this.condition = condition;
    }
    @Override
    public String getSentence() throws Exception {
        if (condition.equals("")) return "DELETE FROM " + table;
        return String.format("DELETE FROM %s WHERE %s", table, condition);
    }
}
