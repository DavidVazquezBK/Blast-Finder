package utilidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 * Creador de JDBC's para aplicaciones Java y MySQL.
 * Versión: 1.3.1
 *
 * @author BurnKill
 */
public class JDBCGenerator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce nombre de tabla");
        String tabla = scanner.next();

        System.out.println("Introduce numero de variables sin contar ID");
        int numeroPropiedades = scanner.nextInt();

        //VARIABLES Y TIPOS
        String[] nombrePropiedades = new String[numeroPropiedades];
        String[] tipoPropiedades = new String[numeroPropiedades];
        String[] encabezados = new String[numeroPropiedades];

        System.out.println("Ingresa tipo de variable, su nombre y display en encabezado. Repite cuantas veces necesites. Siempre separa presionado [INTRO]");

        for (int i = 0; i < numeroPropiedades; i++) {
            tipoPropiedades[i] = scanner.next();
            nombrePropiedades[i] = scanner.next();
            encabezados[i] = scanner.next();
        }
        //COMENZAR IMPRESIÓN
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println("\n");

        imprime1Inicio(tabla);
        imprime2Variables(tabla, numeroPropiedades, nombrePropiedades);
        imprime3Inserta(tabla, numeroPropiedades, nombrePropiedades, tipoPropiedades);
        imprime4Consultar(tabla, numeroPropiedades, nombrePropiedades, tipoPropiedades);
        imprime5Carga(tabla, numeroPropiedades, nombrePropiedades, tipoPropiedades, encabezados);
        imprime6Elimina(tabla, numeroPropiedades, nombrePropiedades, tipoPropiedades, encabezados);
        imprime7Actualiza(tabla, numeroPropiedades, nombrePropiedades, tipoPropiedades, encabezados);
        System.out.println("}");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
    }

    public static void imprime1Inicio(String tabla) {
        System.out.println("/*\n"
                + " * Java Database Connectivity Code Generator v1.0\n"
                + " * Author: David Vazquez\n"
                + " */\n"
                + "package jdbc;\n"
                + "\n"
                + "import java.sql.Connection;\n"
                + "import java.sql.PreparedStatement;\n"
                + "import java.sql.ResultSet;\n"
                + "import javax.swing.table.DefaultTableModel;\n"
                + "import POJO." + tabla + "POJO;\n"
                + "\n"
                + "public class " + tabla + "JDBC {");
        System.out.println("");
    }

    public static void imprime2Variables(String tabla, int numeroPropiedades, String[] nombrePropiedades) {
        System.out.print(" private static final String TABLE = \"" + tabla + "\";" + "\n");
        System.out.println("");
        System.out.print("private static final String SQL_INSERT = \"INSERT INTO \" + TABLE + \"(");

        for (int i = 0; i < numeroPropiedades; i++) {
            if (i == numeroPropiedades - 1) {
                System.out.print(nombrePropiedades[i] + "");
            } else {
                System.out.print(nombrePropiedades[i] + ", ");
            }

        }
        System.out.print(") VALUES (");

        for (int i = 0; i < numeroPropiedades; i++) {
            if (i == numeroPropiedades - 1) {
                System.out.print("?");
            } else {
                System.out.print("?,");
            }

        }

        System.out.println(")\";");

        //SQL_QUERY_ALL
        System.out.println("");
        System.out.println("private static final String SQL_QUERY_ALL = \"Select * from \" + TABLE;");
        System.out.println("");
        //SQL_QUERY
        System.out.println("private static final String SQL_QUERY = \"Select * from \" + TABLE + \" where id=?\";");
        System.out.println("");
        //SQL UPDATE
        System.out.print("private static final String SQL_UPDATE = \"UPDATE \" + TABLE + \" set ");

        for (int i = 0; i < numeroPropiedades; i++) {
            if (i == numeroPropiedades - 1) {
                System.out.print(nombrePropiedades[i] + "=? ");
            } else {
                System.out.print(nombrePropiedades[i] + "=?, ");
            }

        }
        System.out.println("where id" + tabla + "=?\";");

        //SQL_DELETE
        System.out.println(" private static final String SQL_DELETE = \"Delete from \" + TABLE\n"
                + "            + \" where id" + tabla + "=?\";");
        System.out.println("");
    }

    public static void imprime3Inserta(String tabla, int numeroPropiedades, String[] nombrePropiedades, String[] tipoPropiedades) {
        System.out.println(" public static int inserta" + tabla + "(" + tabla + "POJO pojo) {\n"
                + "        Connection con = null;\n"
                + "        PreparedStatement st = null;\n"
                + "        try {\n"
                + "            con = JDBC.Conexion.getConnection();\n"
                + "            st = con.prepareStatement(SQL_INSERT);");
        for (int i = 0; i < numeroPropiedades; i++) {
            System.out.println("st.set" + tipoPropiedades[i] + "(" + (i + 1) + ", pojo.get" + Character.toUpperCase(nombrePropiedades[i].charAt(0)) + nombrePropiedades[i].substring(1) + "());");
        }

        System.out.println("int id = st.executeUpdate();\n"
                + "            return id;\n"
                + "        } catch (Exception e) {\n"
                + "            System.out.println(\"Error al insertar \" + e);\n"
                + "            return 0;\n"
                + "        } finally {\n"
                + "            JDBC.Conexion.close(con);\n"
                + "            JDBC.Conexion.close(st);\n"
                + "        }\n"
                + "    }");
        System.out.println("");
    }

    public static void imprime4Consultar(String tabla, int numeroPropiedades, String[] nombrePropiedades, String[] tipoPropiedades) {
        System.out.println(" public static " + tabla + "POJO consultar(String id) {\n"
                + "        Connection con = null;\n"
                + "        PreparedStatement st = null;\n"
                + "        " + tabla + "POJO pojo = new " + tabla + "POJO();");

        System.out.println(" try {\n"
                + "\n"
                + "            con = JDBC.Conexion.getConnection();\n"
                + "            st = con.prepareStatement(SQL_QUERY);\n"
                + "            st.setString(1, id);\n"
                + "            ResultSet rs = st.executeQuery();\n"
                + "            while (rs.next()) {");

        System.out.println(" pojo.setId" + tabla + "(rs.getInt(\"id" + tabla + "\"));");

        for (int i = 0; i < numeroPropiedades; i++) {
            System.out.println(" pojo.set" + Character.toUpperCase(nombrePropiedades[i].charAt(0)) + nombrePropiedades[i].substring(1) + "(rs.get" + tipoPropiedades[i] + "(\"" + nombrePropiedades[i] + "\"));");
        }

        System.out.println("}\n"
                + "        } catch (Exception e) {\n"
                + "            System.out.println(\"Error al consultar \" + e);\n"
                + "        } finally {\n"
                + "            JDBC.Conexion.close(con);\n"
                + "            JDBC.Conexion.close(st);\n"
                + "        }\n"
                + "        return pojo;\n}");
        System.out.println("");
    }

    public static void imprime5Carga(String tabla, int numeroPropiedades, String[] nombrePropiedades, String[] tipoPropiedades, String[] encabezados) {

        System.out.print("public static DefaultTableModel cargarTabla() {\n"
                + "        Connection con = null;\n"
                + "        PreparedStatement st = null;\n"
                + "        String encabezados[] = {");
        System.out.print("\"" + "ID" + "\", ");
        for (int i = 0; i < numeroPropiedades; i++) {
            if (i == numeroPropiedades - 1) {
                System.out.print("\"" + encabezados[i] + "\"");
            } else {
                System.out.print("\"" + encabezados[i] + "\", ");
            }
        }
        System.out.println("};");

        System.out.println(" DefaultTableModel dt = null;\n"
                + "        try {\n"
                + "            con = JDBC.Conexion.getConnection();\n"
                + "            st = con.prepareStatement(SQL_QUERY);\n"
                + "            dt = new DefaultTableModel();\n"
                + "            dt.setColumnIdentifiers(encabezados);\n"
                + "            ResultSet rs = st.executeQuery();\n"
                + "            while (rs.next()) {\n"
                + "                Object ob[] = new Object[" + (numeroPropiedades + 1) + "];");

        System.out.println(" ob[0] = rs.getObject(\"id" + tabla + "\");");
        for (int i = 0; i < numeroPropiedades; i++) {
            System.out.println("ob[" + (i + 1) + "] = rs.getObject(\"" + nombrePropiedades[i] + "\");");
        }
        System.out.println(" dt.addRow(ob);\n"
                + "            }\n"
                + "            rs.close();\n"
                + "        } catch (Exception e) {\n"
                + "            System.out.println(\"Error al consultar \" + e);\n"
                + "        } finally {\n"
                + "            JDBC.Conexion.close(con);\n"
                + "            JDBC.Conexion.close(st);\n"
                + "            \n"
                + "        }\n"
                + "        return dt;\n"
                + "    }");
        System.out.println("");
    }

    public static void imprime6Elimina(String tabla, int numeroPropiedades, String[] nombrePropiedades, String[] tipoPropiedades, String[] encabezados) {
        System.out.println("public static boolean eliminar" + tabla + "(String id) {\n"
                + "        Connection con = null;\n"
                + "        PreparedStatement st = null;\n"
                + "        try {\n"
                + "            con = JDBC.Conexion.getConnection();\n"
                + "            st = con.prepareStatement(SQL_DELETE);\n"
                + "            st.setString(1, id);\n"
                + "            int num = st.executeUpdate();\n"
                + "            if (num == 0) {\n"
                + "                return false;\n"
                + "            }\n"
                + "        } catch (Exception e) {\n"
                + "            System.out.println(\"Error al eliminar = \" + e);\n"
                + "            return false;\n"
                + "        } finally {\n"
                + "            JDBC.Conexion.close(con);\n"
                + "            JDBC.Conexion.close(st);\n"
                + "        }\n"
                + "        return true;\n"
                + "    }");
        System.out.println("");
    }

    public static void imprime7Actualiza(String tabla, int numeroPropiedades, String[] nombrePropiedades, String[] tipoPropiedades, String[] encabezados) {
        System.out.println("public static boolean actualiza" + tabla + "(" + tabla + "POJO pojo) {\n"
                + "        Connection con = null;\n"
                + "        PreparedStatement st = null;\n"
                + "        try {\n"
                + "            con = JDBC.Conexion.getConnection();\n"
                + "            st = con.prepareStatement(SQL_UPDATE);");
        int i = 0;
        for (; i < numeroPropiedades; i++) {

            System.out.println(" st.set" + tipoPropiedades[i] + "(" + (i + 1) + ", pojo.get" + Character.toUpperCase(nombrePropiedades[i].charAt(0)) + nombrePropiedades[i].substring(1) + "());");
        }
        System.out.println("    st.setInt(" + (i + 1) + ", pojo.getId" + tabla + "());");
        System.out.println("int num = st.executeUpdate();\n"
                + "            if (num == 0) {\n"
                + "                return false;\n"
                + "            }\n"
                + "        } catch (Exception e) {\n"
                + "            System.out.println(\"Error al actualizar = \" + e);\n"
                + "            return false;\n"
                + "        } finally {\n"
                + "            JDBC.Conexion.close(con);\n"
                + "            JDBC.Conexion.close(st);\n"
                + "        }\n"
                + "        return true;\n"
                + "    }");
        System.out.println("");
    }
}
