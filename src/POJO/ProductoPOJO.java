/*
 * Coded by David Vazquez using NetBeans.
 */
package POJO;

/**
 *
 * @author BurnKill
 */
public class ProductoPOJO {

    private int idProducto;
    private String nombre;
    private int Categoria_idCategoria;
    private String iniciales;

    @Override
    public String toString() {
        return getNombre();
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria_idCategoria() {
        return Categoria_idCategoria;
    }

    public void setCategoria_idCategoria(int Categoria_idCategoria) {
        this.Categoria_idCategoria = Categoria_idCategoria;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

}
