package com.example.ejemplocursohorariotemario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Ventana2 extends AppCompatActivity {

    private TextView seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);

        this.seleccion = (TextView) findViewById(R.id.textViewVentana2_2);

    //Recogemos los parámetros enviados por el primer Activity  a través del método getExtras
    Bundle bundle=getIntent().getExtras();  //es una colección, es un map es una caracterísitca del framework
    String dato1=bundle.getString("horario");
    String dato2=bundle.getString("temario");


        this.seleccion.setText(Html.fromHtml("<p><h3>Registro Usuario:</h3></p>" + dato1 + "<br/>" + dato2 + "<br/>"),TextView.BufferType.SPANNABLE);  //SPANNABLE es para que lo cargue de golpe y no aparezca poco a poco
    }

    public void cerrarVentana(View view) {
        finish();
    }
}