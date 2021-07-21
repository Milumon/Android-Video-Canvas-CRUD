package com.isil.mobileapp.model;

public class Auto {

    String idAuto;
    String marca;
    String modelo;
    String placa;
    String propietario;

    public Auto() {
    }

    public Auto(String idAuto, String marca, String modelo, String placa, String propietario) {
        this.idAuto = idAuto;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.propietario = propietario;
    }

    public String getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(String idAuto) {
        this.idAuto = idAuto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
