package com.example.simon_nolet_tp1_v0_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox chk_password = (CheckBox)findViewById(R.id.chk_password);
        final EditText et_password = (EditText)findViewById(R.id.et_password);

        chk_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else{
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }

    public void onClickbtn_valider(View view){
        EditText et_password = (EditText)findViewById(R.id.et_password);
        TextView tv_valider = (TextView)findViewById(R.id.tv_valider);
        String passwordSaisi = et_password.getText().toString();

        if (passwordSaisi.length() >= 10 && caractereSpecial(passwordSaisi) &&
                majuscule(passwordSaisi) && minuscule(passwordSaisi) && chiffre(passwordSaisi)){

            tv_valider.setTextColor(getResources().getColor(R.color.colorValide));
            tv_valider.setText(getResources().getString(R.string.tv_valide));

        } else{
            tv_valider.setTextColor(getResources().getColor(R.color.colorErreur));
            tv_valider.setText(getResources().getString(R.string.tv_nonvalide));
        }

    }

    public boolean majuscule(String password){

        boolean trouver = false;

        if (!password.equals(password.toLowerCase())){

            trouver = true;

        }

        return trouver;
    }

    public boolean minuscule(String password){

        boolean trouver = false;

        if (!password.equals(password.toUpperCase())){

            trouver = true;

        }

        return trouver;
    }

    public boolean chiffre(String password){

        boolean trouver = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                trouver = true;
            }
        }

        return trouver;
    }

    public boolean caractereSpecial(String password){

        boolean trouver = false;

        if (!password.matches("[A-Za-z0-9 ]*")){

            trouver = true;

        }

        return trouver;
    }


}