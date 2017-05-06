/*
 * Java Database Connectivity Code Generator v1.0
 * Author: David Vazquez
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import POJO.ProductoPOJO;

public class ProductoJDBC {

    private static final String TABLE = "Producto";

    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "(nombre, Categoria_idCategoria, iniciales) VALUES (?,?,?)";

    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;


    private static final String SQL_UPDATE = "UPDATE " + TABLE + " set nombre=?, Categoria_idCategoria=?, iniciales=? where idProducto=?";
    private static final String SQL_DELETE = "Delete from " + TABLE
            + " where idProducto=?";

    public static int insertaProducto(ProductoPOJO pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT);
            st.setString(1, pojo.getNombre());
            st.setInt(2, pojo.getCategoria_idCategoria());
            st.setString(3, pojo.getIniciales());
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

    public static ProductoPOJO consultar(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ProductoPOJO pojo = new ProductoPOJO();
        try {

            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo.setIdProducto(rs.getInt("idProducto"));
                pojo.setNombre(rs.getString("nombre"));
                pojo.setCategoria_idCategoria(rs.getInt("Categoria_idCategoria"));
                pojo.setIniciales(rs.getString("iniciales"));
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
        String encabezados[] = {"ID", "Nombre", "notas", "producto","categoria"};
        DefaultTableModel dt = null;
        try {
            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement("SELECT producto.idProducto as 'id', producto.nombre as 'nombre',categoria.nombre as 'categoria',producto.iniciales as 'iniciales' FROM producto,categoria WHERE producto.Categoria_idCategoria=categoria.idCategoria");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[4];
                ob[0] = rs.getObject("id");
                ob[1] = rs.getObject("nombre");
                ob[2] = rs.getObject("categoria");
                ob[3] = rs.getObject("iniciales");
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

    public static boolean eliminarProducto(String id) {
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

    public static boolean actualizaProducto(ProductoPOJO pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = JDBC.Conexion.getConnection();
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNombre());
            st.setInt(2, pojo.getCategoria_idCategoria());
            st.setString(3, pojo.getIniciales());
            st.setInt(4, pojo.getIdProducto());
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
