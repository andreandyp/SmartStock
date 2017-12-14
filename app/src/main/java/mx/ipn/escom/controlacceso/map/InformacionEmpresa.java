package mx.ipn.escom.controlacceso.map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gambo on 11/12/2017.
 */

public class InformacionEmpresa implements Serializable {

    @SerializedName("Empresa")
    @Expose
    private Empresa empresa;

    @SerializedName("listUsuarios")
    @Expose
    private List<Usuario> listUsuario;

    public InformacionEmpresa() {
    }

    public InformacionEmpresa(Empresa empresa, List<Usuario> listUsuario) {
        this.empresa = empresa;
        this.listUsuario = listUsuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }
}
