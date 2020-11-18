package com.example.aplicacionmunicipios;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PeticionXMLMunicipio {
    private static PeticionXMLMunicipio.ComunicacionPedirMunicipio clase_llamante;
    public PeticionXMLMunicipio(PeticionXMLMunicipio.ComunicacionPedirMunicipio clase_llamante) {
        this.clase_llamante = clase_llamante;
    }
    public static void pedirMunicipios(String nom_provincia) {
        //http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio?Provincia=Madrid&Municipio=
        String base = "http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        PeticionInterfaceMunicipio servicio = retrofit.create(PeticionInterfaceMunicipio.class);
        Call<RaizMunicipio> llamada = servicio.pedirMunicipio(nom_provincia,"");
        llamada.enqueue(new Callback<RaizMunicipio>() {
            @Override
            public void onResponse(Call<RaizMunicipio> call, Response<RaizMunicipio> rspns) {
                RaizMunicipio municipios = rspns.body();
                clase_llamante.mostrarDatos(municipios);
            }


            @Override
            public void onFailure(Call<RaizMunicipio> call, Throwable thrwbl) {
                System.out.println("ERROR: " + thrwbl.getMessage());
            }
        });
    }
    public interface ComunicacionPedirMunicipio{
        public void mostrarDatos(RaizMunicipio r);
    }

}
