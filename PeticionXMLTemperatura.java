package com.example.aplicacionmunicipios;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PeticionXMLTemperatura {
    private static PeticionXMLTemperatura.ComunicacionPedirTemperatura clase_llamante;
    public PeticionXMLTemperatura(PeticionXMLTemperatura.ComunicacionPedirTemperatura clase_llamante) {
        this.clase_llamante = clase_llamante;
    }
    public static void pedirTemperatura(String codigo)
    {
        String baseUrl = "http://www.aemet.es/";

        //Instancia a retrofit agregando la baseURL y el convertidor GSON
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        //Se crea el servicio
        PeticionInterfaceTemperatura service = retrofit.create(PeticionInterfaceTemperatura.class);

        //Se realiza la llamada
        Call<RaizTemperatura> llamada = service.getTemperaturas(codigo);
        llamada.enqueue(new Callback<RaizTemperatura>() {
            @Override
            public void onResponse(Call<RaizTemperatura> call, Response<RaizTemperatura> rspns) {
                RaizTemperatura temperaturas=rspns.body();
                clase_llamante.mostrarDatos(temperaturas);
            }

            @Override
            public void onFailure(Call<RaizTemperatura> call, Throwable thrwbl) {
                System.out.println("Error: "+thrwbl.getLocalizedMessage());
            }
        });
    }
    public interface ComunicacionPedirTemperatura{
        public void mostrarDatos(RaizTemperatura r);
    }

}
