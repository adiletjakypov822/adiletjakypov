package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DebtConnectDB {
    
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "12345";

    public Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return connection;
    }

    public List<Debt> getAllDebts() {
        String SQL = "select amount, person_name FROM debt_card";
        List<Debt> debts = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Debt debt = new Debt();
                debt.setAmount(rs.getString("amount"));
                debt.setPersonName(rs.getString("person_name"));
                debts.add(debt);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return debts;
    }
    public Debt saveDebt(Debt debt){
        String SQL = "insert into debt_card (person_name, amount) values ('"+debt.getPersonName()+"', '"+debt.getAmount()+"')";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL);
            System.out.println("New object saved " + debt);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return debt;
    }

    public void resetDatabase(){
        String SQL = "delete from debt_card";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL);
            System.out.println("Database was reset!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
