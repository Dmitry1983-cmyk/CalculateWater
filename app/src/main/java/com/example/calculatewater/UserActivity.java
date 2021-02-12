package com.example.calculatewater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ims.ImsMmTelManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    TextView txtsex,txtgrow,txtweight,norm;
    ProgressBar progressBar;
    Button btnDrink;
    Integer ml=0;Integer progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        String weigth = intent.getStringExtra("user_weight");
        String grow = intent.getStringExtra("user_grow");
        String sex = intent.getStringExtra("user_sex");

        txtgrow=findViewById(R.id.txtGrow);
        txtsex=findViewById(R.id.txtSex);
        txtweight=findViewById(R.id.txtWeigth);
        norm=findViewById(R.id.norm);
        progressBar=findViewById(R.id.progBar);
        btnDrink=findViewById(R.id.drinkWater);


        //txtweight.setText("Вес  : "+weigth+" кг");
        txtweight.setText(weigth);
        txtsex.setText("Пол  : "+sex);
        txtgrow.setText("Рост : "+grow+" см");

        if(sex=="Мужчина"){
            norm.setText(35*(Integer.parseInt(weigth))+ " ml");
        }else{
            norm.setText(31*(Integer.parseInt(weigth))+ " ml");
        }


    }

    public void drinkWatter_method(View view){
        ml=((200*100)/Integer.parseInt(txtweight.getText().toString()) )/10;
        progress+= ml;
        progressBar.setProgress(progress);
        Toast.makeText(this, "Drink cup of watter"+" prog : "+progress, Toast.LENGTH_SHORT).show();
    }
}