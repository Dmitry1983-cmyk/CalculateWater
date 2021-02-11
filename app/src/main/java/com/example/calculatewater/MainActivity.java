package com.example.calculatewater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Switch switchSex;
    TextView txtWeight,txtGrow;
    Button btnNext;
    UserClass user;

    private final static String FILE_NAME = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchSex=findViewById(R.id.switchMale_Female);
        txtWeight=findViewById(R.id.txt_weight);
        txtGrow=findViewById(R.id.txt_grow);
        btnNext=findViewById(R.id.btn_Next);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void nextMethod(View v){
        String getsex;

        if(switchSex.isChecked()){
            getsex="Женщина";
        }
        else {
            getsex="Мужчина";
        }
        if(txtWeight.getText().length()!=0 && txtGrow.getText().length()!=0 &&
                Integer.parseInt(txtGrow.getText().toString())<200 && Integer.parseInt(txtWeight.getText().toString())<300){
            //Toast.makeText(this, "Рост:"+txtGrow.getText().toString()+";\nВес : "+txtWeight.getText().toString()+";\nПол : "+getsex, Toast.LENGTH_SHORT).show();
            user=new UserClass(getsex,Integer.parseInt(txtWeight.getText().toString()),Integer.parseInt(txtGrow.getText().toString()));

            FileOutputStream fos = null;
            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(("Рост:"+txtGrow.getText().toString()+";\nВес : "+txtWeight.getText().toString()+";\nПол : "+getsex).toString().getBytes());
                Toast.makeText(getApplicationContext(), "SAVED!", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            } finally {
                try {
                    if(fos != null)
                        fos.close();

                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        }
        else {
            Toast.makeText(this, "Введены не коректные данные! ", Toast.LENGTH_SHORT).show();
        }
    }



}

/*
    public void saveText(View v){
        FileOutputStream fos = null;
        try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(((EditText)findViewById(R.id.editText)).getText().toString().getBytes());
                Toast.makeText(getApplicationContext(), "SAVED!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if(fos != null)
                    fos.close();

            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void readText(View v){
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String str = new String(bytes);
            ((TextView)findViewById(R.id.textView)).setText(str);
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if(fin != null)
                    fin.close();

            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

*/