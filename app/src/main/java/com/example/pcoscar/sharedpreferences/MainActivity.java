package com.example.pcoscar.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    private EditText txtcorreo;

    private EditText txtnombre;
    private EditText txtdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcorreo=findViewById(R.id.editText);
        txtnombre=findViewById(R.id.txt_nombre);
        txtdatos=findViewById(R.id.txt_datos);

        SharedPreferences preference=getSharedPreferences("datos", Context.MODE_PRIVATE);
        txtcorreo.setText(preference.getString("mail",""));



    }

    public  void Buscar(View view){
        String nombre=txtnombre.getText().toString();
        SharedPreferences preference =getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos =preference.getString(nombre,"");
        if (datos.trim().length()==0){
            Toast.makeText(this,"No se encontro ningun registro" , Toast.LENGTH_SHORT).show();
        }else {
            txtdatos.setText(datos);
        }

    }

    public  void Guardarx (View view){

        String nombre=txtnombre.getText().toString();
        String datos=txtdatos.getText().toString();

        SharedPreferences preference =getSharedPreferences("agenda",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =preference.edit();
        editor.putString(nombre , datos);
        editor.commit();

        Toast.makeText(this,"Contacto fue guardado", Toast.LENGTH_SHORT).show();



    }

    //metodo para el boton guardar
    public void Guardar(View view){

        if (txtcorreo.getText().toString().trim().equalsIgnoreCase("")) {
            Toast.makeText(this, "ingrese correo", Toast.LENGTH_LONG).show();
            return;
        }

            SharedPreferences preference = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preference.edit();

            editor.putString("mail", txtcorreo.getText().toString());
            editor.commit();

            finish();


    }
}
