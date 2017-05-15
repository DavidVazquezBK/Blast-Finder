
/*
 * Java Database Connectivity Code Generator v1.0
 * Author: David Vazquez
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import POJO.MovimientoPOJO;

public class MovimientoJDBC {

    private static final String TABLE = "Movimiento";

    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "(Material_idMaterial, Ubicacion_idUbicacion, fechaHora) VALUES (?,?,?)";

    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;

    private static final String SQL_QUERY = "Select * from " + TABLE + " where id=?";

    private static final String SQL_UPDATE = "UPDATE " + TABLE + " set Material_idMaterial=?, Ubicacion_idUbicacion=?, fechaHora=? where idMovimiento=?";
    private static final String SQL_DELETE = "Delete from " + TABLE
            + " where idMovimiento=?";

    public static int insertaMovimiento(MovimientoPOJO pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT);
            st.setInt(1, pojo.getMaterial_idMaterial());
            st.setInt(2, pojo.getUbicacion_idUbicacion());
            st.setTimestamp(3, pojo.getFechaHora());
            int id = st.executeUpdate();
            return id;
        } catch (Exception e) {
            System.out.println("Error al insertar " + e);
            return 0;
        } finally {
            JDBC.Conexion.close(con);
            JDBC.Conexion.close(st);
        }
    }

    public static MovimientoPOJO consultar(String id) {
        Connection con = null;
        PreparedStatement st = null;
        MovimientoPOJO pojo = new MovimientoPOJO();
        try {

            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo.setIdMovimiento(rs.getInt("idMovimiento"));
                pojo.setMaterial_idMaterial(rs.getInt("Material_idMaterial"));
                pojo.setUbicacion_idUbicacion(rs.getInt("Ubicacion_idUbicacion"));
                pojo.setFechaHora(rs.getTimestamp("fechaHora"));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar " + e);
        } finally {
            JDBC.Conexion.close(con);
            JDBC.Conexion.close(st);
        }
        return pojo;
    }

    public static DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement st = null;
        String encabezados[] = {"ID", "Material", "Ubicacion", "FechaHora"};
        DefaultTableModel dt = null;
        try {
            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[4];
                ob[0] = rs.getObject("idMovimiento");
                ob[1] = rs.getObject("Material_idMaterial");
                ob[2] = rs.getObject("Ubicacion_idUbicacion");
                ob[3] = rs.getObject("fechaHora");
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al consultar " + e);
        } finally {
            JDBC.Conexion.close(con);
            JDBC.Conexion.close(st);

        }
        return dt;
    }

    public static boolean eliminarMovimiento(String id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement(SQL_DELETE);
            st.setString(1, id);
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar = " + e);
            return false;
        } finally {
            JDBC.Conexion.close(con);
            JDBC.Conexion.close(st);
        }
        return true;
    }

    public static boolean actualizaMovimiento(MovimientoPOJO pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement(SQL_UPDATE);
            st.setInt(1, pojo.getMaterial_idMaterial());
            st.setInt(2, pojo.getUbicacion_idUbicacion());
            st.setTimestamp(3, pojo.getFechaHora());
            st.setInt(4, pojo.getIdMovimiento());
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar = " + e);
            return false;
        } finally {
            JDBC.Conexion.close(con);
            JDBC.Conexion.close(st);
        }
        return true;
    }

}
