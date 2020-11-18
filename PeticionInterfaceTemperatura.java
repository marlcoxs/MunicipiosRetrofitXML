package com.example.aplicacionmunicipios;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PeticionInterfaceTemperatura {
    @GET("xml/municipios/localidad_{user}.xml")
    Call<RaizTemperatura> getTemperaturas(@Path("user") String user);
}
