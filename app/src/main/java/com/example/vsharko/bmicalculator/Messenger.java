package com.example.vsharko.bmicalculator;

import android.content.Context;

import com.example.vsharko.bmicalcilator.R;

public class Messenger{
    float BMI;
    String state;
    String message;

    float underWeight=18.5f,normalWeight=24.9f,overWeight=29.9f;

    public Messenger(float BMI, Context context) {
        this.BMI = BMI;

        if(BMI<=underWeight){
            //underWeight
            this.message=context.getString(R.string.underWeightMessage);
            this.state =context.getString(R.string.underWeight);
        }else if(BMI<=normalWeight && BMI>underWeight){
            //normalWeight
            this.message=context.getString(R.string.normalWeightMessage);
            this.state =context.getString(R.string.normalWeight);
        }else if(BMI<=overWeight && BMI>normalWeight){
            //overWeight
            this.message=context.getString(R.string.overWeightMessage);
            this.state=context.getString(R.string.overWeight);
        }else{
            //Obesity
            this.message=context.getString(R.string.obesityMessage);
            this.state =context.getString(R.string.obesity);
        }
    }

    public String getBMI() {
        return String.format("%.1f",BMI);
    }

    public String getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }


}
