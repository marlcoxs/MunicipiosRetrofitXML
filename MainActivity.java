package com.example.aplicacionmunicipios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements PeticionXMLProvincia.ComunicacionPedirProvincia, PeticionXMLMunicipio.ComunicacionPedirMunicipio, PeticionXMLTemperatura.ComunicacionPedirTemperatura{
    Spinner sp_provincias;
    Spinner sp_municipios;
    Button btn_buscar;
    WebView wv_mostrar;
    String nombre_provincia="";
    List<String> lista_provincias=new ArrayList<>();
    List<Provincia> lista_objeto_provincia=new ArrayList<>();

    List<Municipio> lista_objeto_municipio=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp_provincias=findViewById(R.id.spn1);
        sp_municipios=findViewById(R.id.spn2);
        btn_buscar=findViewById(R.id.btn);
        wv_mostrar=findViewById(R.id.web_view);





        PeticionXMLProvincia p1=new PeticionXMLProvincia(this);
        PeticionXMLProvincia.pedirProvicias();
        PeticionXMLMunicipio p2=new PeticionXMLMunicipio(this);
        PeticionXMLTemperatura p3=new PeticionXMLTemperatura(this);
        AdapterView.OnItemSelectedListener oyente= new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Provincia p=(Provincia) sp_provincias.getSelectedItem();
                nombre_provincia=p.getNp();
                PeticionXMLMunicipio.pedirMunicipios(nombre_provincia);
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        sp_provincias.setOnItemSelectedListener(oyente);
        btn_buscar.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Provincia provincia_sel=(Provincia) sp_provincias.getSelectedItem();
                Municipio municipio_sel=(Municipio) sp_municipios.getSelectedItem();
                String codigo_pro=String.valueOf(provincia_sel.getCpine());
                CodigoMunicipio codigo_mun=municipio_sel.getCodigo_muni();
                String codigo_municipio=codigo_mun.getCm();
                while (codigo_pro.length()<2)
                {
                    codigo_pro="0"+codigo_pro;
                }
                while (codigo_municipio.length()<3)
                {
                    codigo_municipio="0"+codigo_municipio;
                }
                String codigo_final=codigo_pro+codigo_municipio;
                PeticionXMLTemperatura.pedirTemperatura(codigo_final);
            }
        });




    }

    @Override
    public void mostrarDatos(RaizProvincia r) {
        List<Provincia> lista=r.getProvinciero();
        ArrayAdapter adaptador_provincias=new ArrayAdapter(this,android.R.layout.simple_spinner_item,lista);
        sp_provincias.setAdapter(adaptador_provincias);

    }

    @Override
    public void mostrarDatos(RaizMunicipio r) {
        List<Municipio> lista=r.getMunicipiero();
        ArrayAdapter adaptador_municipios=new ArrayAdapter(this,android.R.layout.simple_spinner_item,lista);
        sp_municipios.setAdapter(adaptador_municipios);
    }

    @Override
    public void mostrarDatos(RaizTemperatura r) {
        String html=PintaHTML.hacerTabla(r);
        wv_mostrar.loadData(html,"text/html","UTF-8");
    }

}