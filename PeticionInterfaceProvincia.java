package com.example.aplicacionmunicipios;

import retrofit2.Call;
import retrofit2.http.GET;



public interface PeticionInterfaceProvincia {
    @GET("ConsultaProvincia")
    Call<RaizProvincia> pedirProvincia();
}
