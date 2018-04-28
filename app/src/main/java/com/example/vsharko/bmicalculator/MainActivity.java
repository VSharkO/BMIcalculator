package com.example.vsharko.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vsharko.bmicalcilator.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Messenger messenger;
    BMIcalculator calculator;

    @BindView(R.id.calculateButton_main) Button button;
    @BindView(R.id.inputHeight) EditText heightInput;
    @BindView(R.id.inputWeight) EditText weightInput;
    @BindView(R.id.amountBMI_main) TextView bmiAmount;
    @BindView(R.id.amountState_main) TextView state;
    @BindView(R.id.message_main) TextView message;
    @BindView(R.id.imageView_main) ImageView picture;
    @BindView(R.id.bottomLL_main) LinearLayout linearLayout;

    String regexWeight = "[1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-9][0-9]|3[0-4][0-9]|350";
    String regexHeight = "^[1](\\.\\d+)?$|^[2](\\.[0-5]+)?$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        linearLayout.setVisibility(View.GONE);
    }




    @OnClick(R.id.calculateButton_main)
    public void onClick(View view){

        if(heightInput.getText().toString().matches(regexHeight)&&
                weightInput.getText().toString().matches(regexWeight)){
            float result;
            float height=Float.parseFloat(heightInput.getText().toString());
            int weight=Integer.parseInt(weightInput.getText().toString());
            calculator = new BMIcalculator(height,weight);
            result=calculator.calculateBMI();
            updateInterface(result);
        }else{

            Toast.makeText(this,"You need to input valid parameters!",Toast.LENGTH_SHORT).show();
        }
    }

    public void updateInterface(float result){
        linearLayout.setVisibility(View.VISIBLE);
        messenger = new Messenger(result,this);
        bmiAmount.setText(messenger.getBMI());
        state.setText(messenger.getState());
        message.setText(messenger.getMessage());

        switch (messenger.getState()){
            case "Underweight":
                linearLayout.setBackgroundColor(this.getResources().getColor(R.color.bcgCritical));
                picture.setImageResource(R.drawable.under_weight);
                break;
            case "Normal weight":
                linearLayout.setBackgroundColor(this.getResources().getColor(R.color.bcgNormal));
                picture.setImageResource(R.drawable.normal_weight);
                break;
            case "Overweight":
                linearLayout.setBackgroundColor(this.getResources().getColor(R.color.bcgOverweight));
                picture.setImageResource(R.drawable.over_weight);
                break;
            case "Obesity":
                linearLayout.setBackgroundColor(this.getResources().getColor(R.color.bcgCritical));
                picture.setImageResource(R.drawable.obesity);
                break;
        }

    }
}
