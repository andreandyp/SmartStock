package mx.ipn.escom.controlacceso.map;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gambo on 07/12/2017.
 */

public class Empresa implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombreComercial")
    @Expose
    private String nombreComercial;
    @SerializedName("Dominio")
    @Expose
    private String dominio;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("confirmarPassword")
    @Expose
    private String confirmarPassword;

    public Empresa() {
    }

    public Empresa(String nombreComercial, String dominio, String correo, String password) {
        this.nombreComercial = nombreComercial;
        this.dominio = dominio;
        this.correo = correo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", dominio='" + dominio + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", confirmarPassword='" + confirmarPassword + '\'' +
                '}';
    }
}
