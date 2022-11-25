package ec.edu.epn.grupo5.basededatos;

public class InsertSentence implements SQLSentence {
    private final String table;
    private final String[] values;

    public InsertSentence(String tabla, String... values) {
        this.table = tabla;
        this.values = values;
    }

    @Override
    public String getSentence() {
        StringBuilder query = new StringBuilder("INSERT INTO " + table + " VALUES(");
        for(int i = 0; i < values.length; i++) {
            query.append("'").append(values[i]).append("'");
            if (i != values.length - 1){
                query.append(",");
            }
        }
        query.append(")");
        return query.toString();
    }
}
