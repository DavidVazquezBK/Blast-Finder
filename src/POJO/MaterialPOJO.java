/*
 * Coded by David Vazquez using NetBeans.
 */
package POJO;

/**
 *
 * @author BurnKill
 */
public class MaterialPOJO {

    private int idMaterial;
    private String notas;
    private int Producto_idProducto;
    private String nombre;

    public MaterialPOJO(int idMaterial, String notas, int Producto_idProducto, String nombre) {
        this.idMaterial = idMaterial;
        this.notas = notas;
        this.Producto_idProducto = Producto_idProducto;
        this.nombre = nombre;
    }

    public MaterialPOJO() {

    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getProducto_idProducto() {
        return Producto_idProducto;
    }

    public void setProducto_idProducto(int Producto_idProducto) {
        this.Producto_idProducto = Producto_idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
