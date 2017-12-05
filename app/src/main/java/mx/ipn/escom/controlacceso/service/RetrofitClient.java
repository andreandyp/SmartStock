package mx.ipn.escom.controlacceso.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gambo on 22/11/2017.
 */

public class RetrofitClient {

    private Retrofit retrofit;

    public RetrofitClient() {
    }

    public RetrofitClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Retrofit getClient(String baseUrl){
        return new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
}
