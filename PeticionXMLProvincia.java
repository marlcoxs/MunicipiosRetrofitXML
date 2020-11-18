package com.example.aplicacionmunicipios;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PeticionXMLProvincia {
    private static ComunicacionPedirProvincia clase_llamante;
    public PeticionXMLProvincia(ComunicacionPedirProvincia clase_llamante) {
        this.clase_llamante = clase_llamante;
    }

    public static void pedirProvicias()
    {
        //http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia
        String base="http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        PeticionInterfaceProvincia servicio=retrofit.create(PeticionInterfaceProvincia.class);
        Call<RaizProvincia> llamada=servicio.pedirProvincia();
        llamada.enqueue(new Callback<RaizProvincia>() {
            @Override
            public void onResponse(Call<RaizProvincia> call, Response<RaizProvincia> rspns) {
                RaizProvincia provincias = rspns.body();
                clase_llamante.mostrarDatos(provincias);
            }



            @Override
            public void onFailure(Call<RaizProvincia> call, Throwable thrwbl) {
                System.out.println("ERROR: "+thrwbl.getLocalizedMessage());
            }
        });


    }
    public interface ComunicacionPedirProvincia{
        public void mostrarDatos(RaizProvincia r);
    }
}
