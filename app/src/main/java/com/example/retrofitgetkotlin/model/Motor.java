package com.example.retrofitgetkotlin.model;

public class Motor {

    Engineer engineer = new Engineer();

    public Motor(Engineer engineer) {
        this.engineer = engineer;
    }

    public void KoinMotor() {
        engineer.MauMaXe();
    }
}
