package mx.ipn.escom.controlacceso.bs;

import android.content.Intent;

import java.io.IOException;

import mx.ipn.escom.controlacceso.interfaces.APIServce;
import mx.ipn.escom.controlacceso.vista.InicioSesionActivity;
import mx.ipn.escom.controlacceso.vista.InicioUsuarioActivity;

/**
 * Created by gambo on 29/10/2017.
 */

public class UsuarioBs {

    private InicioSesionActivity inicioSesionActivity;

    public UsuarioBs() {
    }

    public UsuarioBs(InicioSesionActivity inicioSesionActivity) {
        this.inicioSesionActivity = inicioSesionActivity;
    }

    public void validarInicioSesion(String usuario, String password, APIServce mpService) throws IOException, InterruptedException {

        Intent intent = new Intent(inicioSesionActivity.getBaseContext(),InicioUsuarioActivity.class);
        inicioSesionActivity.startActivity(intent);
        inicioSesionActivity.finish();

        /*final List<BlockingQueue<Usuario>> blockingDeque = new ArrayList<>();

        Call<Usuario> call = mpService.getUser(usuario, password);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.body() != null) {
                    Intent intent = new Intent(inicioSesionActivity.getBaseContext(), InicioUsuarioActivity.class);
                    inicioSesionActivity.startActivity(intent);
                    inicioSesionActivity.finish();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Intent intent = new Intent(inicioSesionActivity.getBaseContext(), InicioSesionActivity.class);
                inicioSesionActivity.startActivity(intent);
                inicioSesionActivity.finish();
            }
        });*/

    }
}
