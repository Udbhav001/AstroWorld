package com.example.astroworld;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.astroworld.bean.Profile;
import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements DialogInterface.OnClickListener
{
    Profile profile,profile1;
    EditText txtuid,txtpass;
    Button login,register;
    ProgressDialog d;
    TextView forgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        forgot=findViewById(R.id.forgot);
        register=findViewById(R.id.register);
        txtpass=findViewById(R.id.txtpass);
        txtuid=findViewById(R.id.txtuid);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad=new AlertDialog.Builder(Login.this);
                ad.setTitle("Registration");
                ad.setMessage("You want to register as ?");
                ad.setPositiveButton("Astrologer",Login.this);
                ad.setNegativeButton("User",Login.this);
                ad.create().show();

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });
    }

    @Override
    public void onBackPressed()

    {
        finish();
        System.exit(0);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Intent x;
        switch (which)
        {
            case DialogInterface.BUTTON_POSITIVE:
                x=new Intent(this,Registration.class);
                startActivity(x);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                x=new Intent(this,RegistrationUser.class);
                startActivity(x);
                break;}
    }
    public void onLogin()
    {
        final String uid=txtuid.getText().toString();
        String upass=txtpass.getText().toString();
        if(TextUtils.isEmpty(uid)|| TextUtils.isEmpty(upass))
        {
            Toast.makeText(this, "enter userid or password", Toast.LENGTH_SHORT).show();

        }
        else
        {
            d = ProgressDialog.show(Login.this, "", "Connecting to server", true, false, null);
            SendFunction sf=new Connection_baseurl().creater().create(SendFunction.class);
            Call<ArrayList<Profile>> call = sf.Login(uid,upass);
            call.enqueue(new Callback<ArrayList<Profile>>() {
                @Override
                public void onResponse(Call<ArrayList<Profile>> call, Response<ArrayList<Profile>> response) {
                    d.dismiss();
                    ArrayList<Profile> pal=response.body();
                    if(pal.size()>0)
                    {
                        profile=(Profile) pal.get(0);
                        if (profile != null) {

                            Intent x;
                            if(profile.getErrormsg()==null) {
                                Toast.makeText(Login.this, "login success", Toast.LENGTH_SHORT).show();
                                String type = profile.getUsertype();
                                if (type.equals("User")) {
                                    x = new Intent(Login.this, UserMain.class);
                                    x.putExtra("profile", profile);
                                    startActivity(x);
                                } else {
                                    x = new Intent(Login.this, AstrologerMain.class);
                                    x.putExtra("profile", profile);
                                    startActivity(x);
                                }
                            }
                            else
                            {

                                Toast.makeText(Login.this,profile.getErrormsg(), Toast.LENGTH_SHORT).show();
                                forgot.setVisibility(View.VISIBLE);
                            }
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Error in login please retry.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Profile>> call, Throwable t) {
                    d.dismiss();
                    Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }
    public void vforgot(View view) {
        if (profile.getErrormsg().equalsIgnoreCase("User Not Found/Incorrect email or password.")) {
            String str = "Your UserId is " + profile.getUserid() + " and your Password is : " + profile.getPassword();
            SmsManager s = SmsManager.getDefault();
            Intent obj = new Intent(this, WriteMessage.class);
            PendingIntent p = PendingIntent.getActivity(this, 1, obj, PendingIntent.FLAG_ONE_SHOT);
            s.sendTextMessage(profile.getPhoneno(), "", str, p, null);
            Toast.makeText(this, "Message Send", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Invalid User.", Toast.LENGTH_SHORT).show();
        }
    }
}
