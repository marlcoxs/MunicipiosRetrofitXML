package com.example.aplicacionmunicipios;

import java.util.List;

public class PintaHTML {
    public static String hacerTabla(RaizTemperatura r) {
        String html="<html><head></head><body>";
        String nombre_municipio=r.getNombre_municipio();
        html=html+"<h1 align=center >"+nombre_municipio+"</h1>";
        html=html+"<table border=1 align=center><tr><th>Fecha</th><th>Temperatura Máxima</th><th>Temperatura Mínima</th></tr>";
        List<Dia> lista_dias=r.getPrediccion();
        for (Dia dia : lista_dias) {
            String fecha=dia.getFecha();
            String[] lista=fecha.split("-");
            String fecha_final=lista[2]+"-"+lista[1];
            Temperatura temperatura=dia.getTemperatura();
            String tmp_max=temperatura.getTmp_max();
            String tmp_min=temperatura.getTmp_min();
            html=html+"<tr><td>"+fecha_final+"</td><td>"+tmp_max+"</td><td>"+tmp_min+"</td></tr>";
        }
        html=html+"</table></body></html>";
        return html;
    }
}
