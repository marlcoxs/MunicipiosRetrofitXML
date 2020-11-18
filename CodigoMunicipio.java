package com.example.aplicacionmunicipios;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name="consulta_municipiero", strict =false)

public class CodigoMunicipio {

        @Element(name = "cp")
        private String cp;
        @Element(name = "cm")
        private String cm;

        public String getCp() {
            return cp;
        }

        public void setCp(String cp) {
            this.cp = cp;
        }

        public String getCm() {
            return cm;
        }

        public void setCm(String cm) {
            this.cm = cm;
        }

        @Override
        public String toString() {
            return "Codigo_Municipio{" + "cp=" + cp + ", cm=" + cm + '}';
        }
    }


