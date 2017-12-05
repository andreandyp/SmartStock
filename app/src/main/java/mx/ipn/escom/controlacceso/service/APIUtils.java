package mx.ipn.escom.controlacceso.service;

import mx.ipn.escom.controlacceso.interfaces.APIServce;

/**
 * Created by gambo on 27/11/2017.
 */

public class APIUtils {

    public static final String BASE_URL = "http://10.0.2.2:8081/smartStock/";

    public APIUtils() {
    }

    public APIServce getAPIService() {
        RetrofitClient retrofitClient=new RetrofitClient();
        return retrofitClient.getClient(BASE_URL).create(APIServce.class);
    }
}
