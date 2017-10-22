package mx.ipn.escom.controlacceso.map;

import java.util.Date;

/**
 * Created by gambo on 09/10/2017.
 */

public class Usuario extends Persona {

    /**
     *
     */
    private String login;

    /**
     *
     */
    private String password;

    public Usuario(String nombre, String primerApellido, String segundoApellido, Date nacimiento, String login, String password) {
        super(nombre, primerApellido, segundoApellido, nacimiento);
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
