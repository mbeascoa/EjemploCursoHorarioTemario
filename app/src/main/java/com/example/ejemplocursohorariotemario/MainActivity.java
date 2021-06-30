package com.example.ejemplocursohorariotemario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tv1;

    private RadioButton rbtManana, rbtTarde, rbtIndiferente ;
    private CheckBox chkNet, chkJava, chkOracle ;
    private String horario;
    private String temario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.rbtManana = (RadioButton)findViewById(R.id.radioButton1);
        this.rbtTarde = (RadioButton)findViewById(R.id.radioButton2);
        this.rbtIndiferente = (RadioButton)findViewById(R.id.radioButton3);
        this.chkNet = (CheckBox)findViewById(R.id.checkBox1);
        this.chkJava = (CheckBox)findViewById(R.id.checkBox2);
        this.chkOracle = (CheckBox)findViewById(R.id.checkBox3);
    }


    public void mostrarDatos(View view) {
        Intent i = new Intent(this, Ventana2.class );
        // Añadimos tres parámetros con el método putExtra


        if(rbtManana.isChecked()==true){
            horario = rbtManana.getText().toString() + ",";
            chkJava.setEnabled(true);
            chkNet.setEnabled(true);
            chkOracle.setEnabled(true);
        }
        if(rbtTarde.isChecked()==true){
            horario = rbtTarde.getText().toString() + ",";
            chkJava.setEnabled(true);
            chkNet.setEnabled(true);
            chkOracle.setEnabled(true);
        }

        if(rbtIndiferente.isChecked()==true){

            horario =  rbtIndiferente.getText().toString() + ",";
            chkJava.setEnabled(false);
            chkNet.setEnabled(false);
            chkOracle.setEnabled(false);
        }
        if(chkNet.isChecked()==true){

            if (temario == null) {
                temario =  chkNet.getText().toString() + ",";
            }
            else {
                temario =  temario + chkNet.getText().toString() + ",";
            }

        }
        if(chkJava.isChecked()==true){
            if (temario == null) {
                temario =  chkJava.getText().toString() + ",";
            }
            else {
                temario =  temario + chkJava.getText().toString() + ",";
            }

        }
        if(chkOracle.isChecked()==true){
            if (temario == null) {
                temario =  chkOracle.getText().toString() + ",";
            }
            else {
                temario =  temario + chkOracle.getText().toString() + ",";
            }
        }

        if((chkOracle.isChecked() == false) && (chkJava.isChecked() == false) && (chkNet.isChecked()==false) ) {

                temario =  "No ha demostrado interés en ningún tema";
            }
        if((chkOracle.isChecked() == true) && (chkJava.isChecked() == true) && (chkNet.isChecked()==true) ) {

            temario =  "Es un crack, lo quiere todo!!!!!!!!!!!!!!";
        }

       if (horario.equals("Indiferente,") ) {
           temario = "Me da igual que me da los mismo ";
       }
        i.putExtra("horario", horario);
        i.putExtra("temario", temario);


        horario= "";
        temario = "";
        startActivity(i);
    }

    public void gestionarCheckBox (View view) {

        if(rbtIndiferente.isChecked()==true){

            chkJava.setEnabled(false);
            chkNet.setEnabled(false);
            chkOracle.setEnabled(false);

        } else {
            chkJava.setEnabled(true);
            chkNet.setEnabled(true);
            chkOracle.setEnabled(true);

        }

        chkJava.setChecked(false);
        chkNet.setChecked(false);
        chkOracle.setChecked(false);


    }

    public void gestionarRadioButton (View view) {

        if((chkJava.isChecked()==true) && (rbtManana.isChecked()==true)){

            String warning = " El curso de java es solo por la tarde";
            rbtTarde.setChecked(true);
            Toast.makeText(this, warning, Toast.LENGTH_SHORT).show();
        }


    }


}