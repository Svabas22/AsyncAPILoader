package com.example.asyncapiloader;

public class NeoClass {
    String des,
            orbit_id,
            jd,
            cd,
            dist,
            dist_min,
            dist_max,
            v_rel,
            v_inf,
            t_sigma_f,
            h;

    public NeoClass(String des, String orbit_id, String jd, String cd, String dist, String dist_min, String dist_max, String v_rel, String v_inf, String t_sigma_f, String h) {
        this.des = des;
        this.orbit_id = orbit_id;
        this.jd = jd;
        this.cd = cd;
        this.dist = dist;
        this.dist_min = dist_min;
        this.dist_max = dist_max;
        this.v_rel = v_rel;
        this.v_inf = v_inf;
        this.t_sigma_f = t_sigma_f;
        this.h = h;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getOrbit_id() {
        return orbit_id;
    }

    public void setOrbit_id(String orbit_id) {
        this.orbit_id = orbit_id;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getDist_min() {
        return dist_min;
    }

    public void setDist_min(String dist_min) {
        this.dist_min = dist_min;
    }

    public String getDist_max() {
        return dist_max;
    }

    public void setDist_max(String dist_max) {
        this.dist_max = dist_max;
    }

    public String getV_rel() {
        return v_rel;
    }

    public void setV_rel(String v_rel) {
        this.v_rel = v_rel;
    }

    public String getV_inf() {
        return v_inf;
    }

    public void setV_inf(String v_inf) {
        this.v_inf = v_inf;
    }

    public String getT_sigma_f() {
        return t_sigma_f;
    }

    public void setT_sigma_f(String t_sigma_f) {
        this.t_sigma_f = t_sigma_f;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }
}
