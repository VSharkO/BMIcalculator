package com.example.vsharko.bmicalculator;

public class BMIcalculator {

    public BMIcalculator(float height,int weight){
        this.height=height;
        this.weight=weight;
    }

    float height;
    int weight;

    public float calculateBMI(){
        float result=weight/(height*height);
        return result;
    }
}
