package com.edu.uac.co.act2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText ownerTxt, towerTxt, apTxt, areaTxt;
    Button saveBtn, cancelBtn;
    OwnerAccount oc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ownerTxt = findViewById(R.id.ownerText);
        towerTxt = findViewById(R.id.towerText);
        apTxt = findViewById(R.id.aptText);
        areaTxt = findViewById(R.id.areaText);
        saveBtn = findViewById(R.id.saveButton);
        cancelBtn = findViewById(R.id.cancelButton);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(ownerTxt.getText())) {

                    ownerTxt.setError("El campo nombre de propietario es requerido!");

                } else if (TextUtils.isEmpty(towerTxt.getText())) {

                    towerTxt.setError("El campo torre es requerido!");

                } else if (TextUtils.isEmpty(apTxt.getText())) {

                    towerTxt.setError("El campo apartamento es requerido!");

                } else if (TextUtils.isEmpty(areaTxt.getText())) {

                    towerTxt.setError("El campo area es requerido!");

                } else {

                    guardar();

                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    i.putExtra("account", oc);
                    startActivity(i);

                    clearAll();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void guardar() {
        oc = new OwnerAccount(ownerTxt.getText().toString(), towerTxt.getText().toString(), apTxt.getText().toString(), areaTxt.getText().toString());
        Toast.makeText(this, "Contacto Guardado", Toast.LENGTH_SHORT).show();
    }

    public void clearAll() {

        ownerTxt.setText("");
        ownerTxt.setHint("Ejemplo: Juan Gomez");
        towerTxt.setText("");
        apTxt.setText("");
        areaTxt.setText("");
    }

}
