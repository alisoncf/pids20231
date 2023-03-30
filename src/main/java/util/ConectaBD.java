package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConectaBD {
    Connection con;
    Statement stmt;
    public static String DataSetName = "jdbc/gdoc";
    public ConectaBD() {
    }

    public void executa(String sql) throws Exception {
        try {

            Context envContext = new InitialContext();
            Context initContext = (Context) envContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) initContext.lookup(DataSetName);
             con = ds.getConnection();
             stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
    }
    public Long inserirReturningId(String sql) throws Exception {
        try {

            Context envContext = new InitialContext();
            Context initContext = (Context) envContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) initContext.lookup(DataSetName);
             con = ds.getConnection();
             stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {                
                return rs.getLong("id");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
        return null;
    }

    public ResultSet getResultset(String sql) throws Exception {
        try {

            Context envContext = new InitialContext();
            Context initContext = (Context) envContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) initContext.lookup(DataSetName);
            con = ds.getConnection();
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
           
        }

    }

    public void fecha() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
        }
    }

}
