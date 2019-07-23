package com.example.astroworld;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationUser extends AppCompatActivity implements View.OnClickListener{

    final Calendar myCalendar= Calendar.getInstance();
    EditText dateset,userid,name,address,email,phoneno,pass,repass,phone;
    RadioGroup radioGroup;
    RadioButton a,b;
    Button btn;
    String gender="Male";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationuser);
        userid=findViewById(R.id.userid);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phoneno);
        pass=findViewById(R.id.pass);
        repass=findViewById(R.id.reenterpass);
        dateset=findViewById(R.id.date);
        datefinder();
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(this);
        radioGroup=findViewById(R.id.radiogrp);
    }

    @Override
    public void onClick(View v)
    {
        String pass_string=pass.getText().toString().trim();
        String repas_string=repass.getText().toString().trim();
        if(pass_string.equals(repas_string)) {
            String name_string = name.getText().toString().trim(), userid_string = userid.getText().toString().trim();
            String email_string = email.getText().toString().trim(), address_string = address.getText().toString().trim();
            String phone_string = phone.getText().toString().trim(), date_string = dateset.getText().toString();
            String date_reg_string=currentdate();
            int id = radioGroup.getCheckedRadioButtonId();
            if (id == R.id.female)
                gender = "Female";
            SendFunction function = new Connection_baseurl().creater().create(SendFunction.class);
            Call<String> call = function.registerUser(userid_string, name_string, address_string, email_string, gender, phone_string, date_string,date_reg_string, pass_string);
            Toast.makeText(this, ""+date_reg_string+" "+date_string, Toast.LENGTH_SHORT).show();
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String res=response.body();
                    if(res.equalsIgnoreCase("success"))
                    {
                        Toast.makeText(RegistrationUser.this, "Registration Successfull.", Toast.LENGTH_SHORT).show();
                        Intent x=new Intent(RegistrationUser.this,Login.class);
                        startActivity(x);
                    }
                    else
                    if(res.equalsIgnoreCase("exist"))
                    {
                        Toast.makeText(RegistrationUser.this, "Userid already exists, please try another.", Toast.LENGTH_SHORT).show();
                        userid.setText("");
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(RegistrationUser.this, "Failure", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            Toast.makeText(this, "Password doesn't match. Please enter again", Toast.LENGTH_SHORT).show();
            pass.setText("");
            repass.setText("");
        }
    }
    public void datefinder()
    {
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dateset.setText(sdf.format(myCalendar.getTime()));
            }

        };

        dateset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RegistrationUser.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    public String currentdate()
    {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        return df.format(c);
    }
}
