package com.example.astroworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    Button b;
    RadioGroup radioGroup;
    String gender="Male";
    RadioButton a,c;
    EditText pass,reenterpass,userid,email,address,name,phoneno,experience,skills,regno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        pass=findViewById(R.id.pass);
        reenterpass=findViewById(R.id.reenterpass);
        b=findViewById(R.id.btn);
        b.setOnClickListener(this);
        userid=findViewById(R.id.userid);
        email=findViewById(R.id.email);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        phoneno=findViewById(R.id.phoneno);
        experience=findViewById(R.id.exp);
        skills=findViewById(R.id.skill);
        regno= findViewById(R.id.regNo);
        a=findViewById(R.id.male);
        c=findViewById(R.id.female);
        radioGroup=findViewById(R.id.radio);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Hello chai pe lo.", Toast.LENGTH_SHORT).show();
        String password=pass.getText().toString().trim();
        final String repassword=reenterpass.getText().toString().trim();
        if(password.equals(repassword))
        {
            String userid_string=userid.getText().toString().trim(),name_string=name.getText().toString().trim();
            String address_string=address.getText().toString().trim(),email_string=email.getText().toString().trim();
            String phoneno_string=phoneno.getText().toString().trim(),experience_string=experience.getText().toString().trim();
            String registrationo=regno.getText().toString().trim();
            String skill_string=skills.getText().toString().trim();
            int id=radioGroup.getCheckedRadioButtonId();
            if(id==R.id.female)
                gender="Female";
            SendFunction function= new Connection_baseurl().creater().create(SendFunction.class);
            Call<String> call=function.registerAstrologer(userid_string,name_string,address_string,email_string,gender,phoneno_string,experience_string,skill_string,registrationo,password);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String res=response.body();
                    if(res.equalsIgnoreCase("success"))
                    {
                        Toast.makeText(Registration.this, "Registration Successfull", Toast.LENGTH_LONG).show();
                        Intent x=new Intent(Registration.this,Login.class);
                        startActivity(x);
                    }

                    else
                    if(res.equalsIgnoreCase("exists"))
                    {
                        userid.setText("");
                        Toast.makeText(Registration.this, "UserId Exists. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(Registration.this, "Faliled", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            Toast.makeText(this, "Password doesn't match.", Toast.LENGTH_SHORT).show();
            pass.setText("");
            reenterpass.setText("");
        }
    }
}
