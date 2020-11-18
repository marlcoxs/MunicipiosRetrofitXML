package com.example.aplicacionmunicipios;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeticionInterfaceMunicipio {
    @GET("ConsultaMunicipio")
        //?Provincia={provincia}&Municipio=
    Call<RaizMunicipio> pedirMunicipio(@Query("provincia") String provincia,
                                       @Query("municipio") String municipio);

}
