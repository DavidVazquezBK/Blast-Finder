
/*
 * Java Database Connectivity Code Generator v1.0
 * Author: David Vazquez
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import POJO.MaterialPOJO;

public class MaterialJDBC {

    private static final String TABLE = "Material";

    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "(notas, Producto_idProducto, nombre) VALUES (?,?,?)";

    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;

    private static final String SQL_QUERY = "Select * from " + TABLE + " where id=?";

    private static final String SQL_UPDATE = "UPDATE " + TABLE + " set notas=?, Producto_idProducto=?, nombre=? where idMaterial=?";
    private static final String SQL_DELETE = "Delete from " + TABLE
            + " where idMaterial=?";

    public static int insertaMaterial(MaterialPOJO pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT);
            st.setString(1, pojo.getNotas());
            st.setInt(2, pojo.getProducto_idProducto());
            st.setString(3, pojo.getNombre());
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

    public static MaterialPOJO consultar(String id) {
        Connection con = null;
        PreparedStatement st = null;
        MaterialPOJO pojo = new MaterialPOJO();
        try {

            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo.setIdMaterial(rs.getInt("idMaterial"));
                pojo.setNotas(rs.getString("notas"));
                pojo.setProducto_idProducto(rs.getInt("Producto_idProducto"));
                pojo.setNombre(rs.getString("nombre"));
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
        String encabezados[] = {"ID", "Nombre", "Notas", "Producto", "Categoria"};
        DefaultTableModel dt = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("SELECT material.idMaterial as 'id', material.nombre as 'nombre', material.notas as 'notas', producto.nombre as 'producto', categoria.nombre as 'categoria' FROM material,producto,categoria WHERE material.Producto_idProducto=producto.idProducto AND producto.Categoria_idCategoria=categoria.idCategoria");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                ob[0] = rs.getObject("id");
                ob[1] = rs.getObject("nombre");
                ob[2] = rs.getObject("notas");
                ob[3] = rs.getObject("producto");
                ob[4] = rs.getObject("categoria");
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

    public static boolean eliminarMaterial(String id) {
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

    public static boolean actualizaMaterial(MaterialPOJO pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNotas());
            st.setInt(2, pojo.getProducto_idProducto());
            st.setString(3, pojo.getNombre());
            st.setInt(4, pojo.getIdMaterial());
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
