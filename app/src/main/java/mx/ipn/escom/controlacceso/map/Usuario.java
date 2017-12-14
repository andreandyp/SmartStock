package mx.ipn.escom.controlacceso.map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gambo on 09/10/2017.
 */

public class Usuario extends Persona implements Serializable{


    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private String password;

    public Usuario() {
    }

    public Usuario(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public Usuario(String nombre,String primerApellido,String segundoApellido,String login,String password){
        super(nombre,primerApellido,segundoApellido,null);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
