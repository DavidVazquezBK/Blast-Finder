
/*
 * Java Database Connectivity Code Generator v1.0
 * Author: David Vazquez
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import POJO.UbicacionPOJO;

public class UbicacionJDBC {

    private static final String TABLE = "Ubicacion";

    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "(nombre, descripcion) VALUES (?,?)";

    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;

    private static final String SQL_QUERY = "Select * from " + TABLE + " where id=?";

    private static final String SQL_UPDATE = "UPDATE " + TABLE + " set nombre=?, descripcion=? where idUbicacion=?";
    private static final String SQL_DELETE = "Delete from " + TABLE
            + " where idUbicacion=?";

    public static int insertaUbicacion(UbicacionPOJO pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT);
            st.setString(1, pojo.getNombre());
            st.setString(2, pojo.getDescripcion());
            int id = st.executeUpdate();
            return id;
        } catch (Exception e) {
            System.out.println("Error al insertar " + e);
            return 0;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
    }

    public static UbicacionPOJO consultar(String id) {
        Connection con = null;
        PreparedStatement st = null;
        UbicacionPOJO pojo = new UbicacionPOJO();
        try {

            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo.setIdUbicacion(rs.getInt("idUbicacion"));
                pojo.setNombre(rs.getString("nombre"));
                pojo.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

    public static DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement st = null;
        String encabezados[] = {"ID", "Nombre", "Descripci�n"};
        DefaultTableModel dt = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];
                ob[0] = rs.getObject("idUbicacion");
                ob[1] = rs.getObject("nombre");
                ob[2] = rs.getObject("descripcion");
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al consultar " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);

        }
        return dt;
    }

    public static boolean eliminarUbicacion(String id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
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
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public static boolean actualizaUbicacion(UbicacionPOJO pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNombre());
            st.setString(2, pojo.getDescripcion());
            st.setInt(3, pojo.getIdUbicacion());
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar = " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

}
