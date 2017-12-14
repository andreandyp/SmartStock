package mx.ipn.escom.controlacceso.bs;

import java.util.List;

import mx.ipn.escom.controlacceso.interfaces.APIServce;
import mx.ipn.escom.controlacceso.map.Empresa;
import mx.ipn.escom.controlacceso.map.InformacionEmpresa;
import mx.ipn.escom.controlacceso.map.Usuario;
import mx.ipn.escom.controlacceso.service.APIUtils;
import retrofit2.Call;

/**
 * Created by gambo on 11/12/2017.
 */

public class EmpresaBs {

    private APIServce mpService;

    public EmpresaBs() {
    }

    public void guardarInformacionEmpresa(Empresa empresa, List<Usuario> listUsuarioGuardar){
        APIUtils apiUtils=new APIUtils();
        mpService= apiUtils.getAPIService();

        Call<Integer> call=mpService.saveInformacion(new InformacionEmpresa(empresa,listUsuarioGuardar));

    }
}
