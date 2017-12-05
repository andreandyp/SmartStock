package mx.ipn.escom.controlacceso.interfaces;

import mx.ipn.escom.controlacceso.map.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gambo on 22/11/2017.
 */

public interface APIServce {

    @GET("controlacceso/{login}/{password}")
    Call<Usuario> getUser(@Path("login") String login,@Path("password") String password);

}
