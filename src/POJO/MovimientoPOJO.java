/*
 * Coded by David Vazquez using NetBeans.
 */
package POJO;

import java.sql.Timestamp;

/**
 *
 * @author BurnKill
 */
public class MovimientoPOJO {
    private int idMovimiento;
    private int Material_idMaterial;
    private int Ubicacion_idUbicacion;
    private Timestamp fechaHora;

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getMaterial_idMaterial() {
        return Material_idMaterial;
    }

    public void setMaterial_idMaterial(int Material_idMaterial) {
        this.Material_idMaterial = Material_idMaterial;
    }

    public int getUbicacion_idUbicacion() {
        return Ubicacion_idUbicacion;
    }

    public void setUbicacion_idUbicacion(int Ubicacion_idUbicacion) {
        this.Ubicacion_idUbicacion = Ubicacion_idUbicacion;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }
    
}
