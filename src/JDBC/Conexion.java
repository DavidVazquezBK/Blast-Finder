package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Conexion {

    private static String jdbcHost;
    private static String jdbcUser;
    private static String jdbcPass;
    private static final String JDBC_BD = "blastfinder";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String jdbcUrl;
    private static Driver controlador = null;

    static ResultSet rs;
    static PreparedStatement st = null;
    static Connection con = null;

    public static synchronized Connection getConnection() throws SQLException {
        if (controlador == null) {
            try {
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                controlador = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(controlador);
            } catch (Exception e) {
                System.out.println("Error en el driver " + e);
            }
        }
        inicializa();
        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
    }

    public static void close(Connection rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión " + e);
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar ResultSet " + e);
        }
    }

    public static void close(PreparedStatement rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar PreparedStatement" + e);
        }
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            InputStream inputStream = Conexion.class.getResourceAsStream("/config/prefs.properties");
            props.load(inputStream);
            inputStream.close();
            jdbcHost = props.getProperty("host");
            jdbcUser = props.getProperty("user");
            jdbcPass = props.getProperty("pass");
            System.out.println(jdbcPass);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            jdbcHost = "localhost";
            jdbcUser = "root";
            jdbcPass = "";
        }
        try {
            Connection con = Conexion.getConnection();
            System.out.println(con);
        } catch (Exception e) {
            System.out.println("Error = " + e);
            e.printStackTrace();
        }
    }

    public static void inicializa() {

        Properties props = new Properties();
        try {
            InputStream inputStream = Conexion.class.getResourceAsStream("/config/prefs.properties");
            props.load(inputStream);
            inputStream.close();
            jdbcHost = props.getProperty("host");
            jdbcUser = props.getProperty("user");
            jdbcPass = props.getProperty("pass");
            jdbcUrl = "jdbc:mysql://" + jdbcHost + "/" + JDBC_BD;
            System.out.println(jdbcPass);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            jdbcHost = "localhost";
            jdbcUser = "root";
            jdbcPass = "";
        }
    }
}
