package com.example.aplicacionmunicipios;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
class Temperatura {
    @Element(name="maxima")
    private String tmp_max;
    @Element(name="minima")
    private String tmp_min;

    public String getTmp_max() {
        return tmp_max;
    }

    public void setTmp_max(String tmp_max) {
        this.tmp_max = tmp_max;
    }

    public String getTmp_min() {
        return tmp_min;
    }

    public void setTmp_min(String tmp_min) {
        this.tmp_min = tmp_min;
    }

    @Override
    public String toString() {
        return "Temperatura{" + "tmp_max=" + tmp_max + ", tmp_min=" + tmp_min + '}';
    }

}