/*
 * Coded by David Vazquez using NetBeans.
 */
package POJO;

/**
 *
 * @author BurnKill
 */
public class CategoriaPOJO {
    private int idCategoria;
    private String nombre;
    private String iniciales;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    @Override
    public String toString(){
        return getNombre();
    }
}
