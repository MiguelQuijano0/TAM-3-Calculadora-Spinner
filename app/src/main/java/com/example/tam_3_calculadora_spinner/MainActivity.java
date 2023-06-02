package com.example.tam_3_calculadora_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private EditText et1,et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tv1=findViewById(R.id.tv1);
        spinner1 =(Spinner) findViewById(R.id.spinner);

        String []opciones={"Sumar","Restar","Multiplicar","Dividir","Potencia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spiner_per, opciones);
        spinner1.setAdapter(adapter);
    }
    public void operar(View view) {
        String valor1=et1.getText().toString();
        String valor2=et2.getText().toString();

        int nro1=Integer.parseInt(valor1);
        int nro2=Integer.parseInt(valor2);
        String selec=spinner1.getSelectedItem().toString();


        if (selec.equals("Sumar")) {
            int suma=nro1+nro2;
            String resu=String.valueOf(suma);
            tv1.setText(resu);
        } else
            if (selec.equals("Restar")) {
                int resta=nro1-nro2;
                String resu=String.valueOf(resta);
                tv1.setText(resu);
            }
            else
                if (selec.equals("Multiplicar")) {
                    int multi=nro1*nro2;
                    String resu=String.valueOf(multi);
                    tv1.setText(resu);
                }
                else
                    if (selec.equals("Dividir")) {
                        String error= "ingrese un numero mayor de 0";
                        if (nro2>0){
                            int dividir=nro1/nro2;
                            String resu=String.valueOf(dividir);
                            tv1.setText(resu);
                        }else
                            if (nro2==0){
                                tv1.setText(error);
                            }
                    }else
                        if(selec.equals("Potencia")){
                            if (nro2>=0){
                                int exponente = nro2;
                                int potencia = 1;
                                while(0<exponente){
                                    potencia = potencia*nro1;
                                    exponente--;
                                }
                                String resu=String.valueOf(potencia);
                                tv1.setText(resu);
                            }
                        }
    }
}