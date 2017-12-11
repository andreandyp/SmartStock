package mx.ipn.escom.controlacceso.bs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import mx.ipn.escom.controlacceso.bs.exception.InicioSesionException;
import mx.ipn.escom.controlacceso.interfaces.APIServce;
import mx.ipn.escom.controlacceso.map.Usuario;
import mx.ipn.escom.controlacceso.vista.InicioSesionActivity;
import mx.ipn.escom.controlacceso.vista.InicioUsuarioActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gambo on 29/10/2017.
 */

public class UsuarioBs{

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

        Call<Usuario> call=mpService.getUser(usuario,password);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.body()!=null){
                    Intent intent = new Intent(inicioSesionActivity.getBaseContext(),InicioUsuarioActivity.class);
                    inicioSesionActivity.startActivity(intent);
                    inicioSesionActivity.finish();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Intent intent = new Intent(inicioSesionActivity.getBaseContext(),InicioSesionActivity.class);
                inicioSesionActivity.startActivity(intent);
                inicioSesionActivity.finish();
            }
        });*/

    }
}
