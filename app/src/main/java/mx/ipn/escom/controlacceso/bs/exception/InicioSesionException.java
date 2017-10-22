package mx.ipn.escom.controlacceso.bs.exception;

import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by gambo on 09/10/2017.
 */

public class InicioSesionException extends Exception {

    public InicioSesionException() {
        super();
    }

    public InicioSesionException(String message) {
        super(message);
    }

    public InicioSesionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InicioSesionException(Throwable cause) {
        super(cause);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected InicioSesionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
