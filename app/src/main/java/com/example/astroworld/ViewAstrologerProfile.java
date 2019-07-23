package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.astroworld.bean.Profile;
import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAstrologerProfile extends Fragment
{
    Button b;
    EditText name, email, address, phoneno, experience, skill;
    Profile a;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewastrologerprofile, container, false);
        b = v.findViewById(R.id.edit);
        skill=v.findViewById(R.id.skill);
        experience = v.findViewById(R.id.experience);
        name = v.findViewById(R.id.name);
        email = v.findViewById(R.id.email);
        address = v.findViewById(R.id.address);
        phoneno = v.findViewById(R.id.phoneno);
        b.setOnClickListener(new View.OnClickListener()
        {
           @Override
           public void onClick(View v) {
               if (b.getText().toString().equalsIgnoreCase("Edit"))
               {
                   enable();
               }
               else
               {
                   disable();
                   SendFunction sf=new Connection_baseurl().creater().create(SendFunction.class);
                   Call<ArrayList<Profile>> call = sf.updateAstrologer(name.getText().toString(),address.getText().toString(),email.getText().toString(),phoneno.getText().toString(),experience.getText().toString(),skill.getText().toString(),a.getUserid());
                   call.enqueue(new Callback<ArrayList<Profile>>() {
                       @Override
                       public void onResponse(Call<ArrayList<Profile>> call, Response<ArrayList<Profile>> response)
                       {
                           ArrayList<Profile> arr=response.body();
                           if(arr.size()>0)
                           {
                               System.out.println("inside main");
                               Profile ar=arr.get(0);
                               if(ar.getErrormsg().equalsIgnoreCase("success"))
                               {
                                   AstrologerMain.profile.setName(ar.getName());
                                   AstrologerMain.profile.setAddress(ar.getAddress());
                                   AstrologerMain.profile.setEmail(ar.getEmail());
                                   AstrologerMain.profile.setPhoneno(ar.getPhoneno());
                                   AstrologerMain.profile.setExperience(ar.getExperience());
                                   AstrologerMain.profile.setSkill(ar.getSkill());
                                   name.setText(ar.getName());
                                   email.setText(ar.getEmail());
                                   address.setText(ar.getAddress());
                                   skill.setText(ar.getSkill());
                                   experience.setText(ar.getExperience());
                                   phoneno.setText(ar.getPhoneno());
                               }
                               if(ar.getErrormsg().equalsIgnoreCase("success"))
                                   Toast.makeText(getActivity(), "Updated Successfully.", Toast.LENGTH_SHORT).show();
                           }
                       }
                       @Override
                       public void onFailure(Call<ArrayList<Profile>> call, Throwable t)
                       {

                       }
                   });
               }
           }
       });
        showData();
        return v;
    }
    private void showData()
    {
        a=AstrologerMain.profile;
        name.setText(a.getName());
        email.setText(a.getEmail());
        address.setText(a.getAddress());
        skill.setText(a.getSkill());
        experience.setText(a.getExperience());
        phoneno.setText(a.getPhoneno());
    }
    public void enable()
    {
        name.setClickable(true);
        name.setFocusableInTouchMode(true);
        email.setClickable(true);
        email.setFocusableInTouchMode(true);
        address.setClickable(true);
        address.setFocusableInTouchMode(true);
        phoneno.setClickable(true);
        phoneno.setFocusableInTouchMode(true);
        skill.setClickable(true);
        skill.setFocusableInTouchMode(true);
        experience.setClickable(true);
        experience.setFocusableInTouchMode(true);
        b.setText("Update");
    }
    public void disable()
    {
        name.setClickable(false);
        name.setFocusable(false);
        email.setClickable(false);
        email.setFocusable(false);
        address.setClickable(false);
        address.setFocusable(false);
        phoneno.setClickable(false);
        phoneno.setFocusable(false);
        skill.setFocusable(false);
        skill.setClickable(false);
        experience.setClickable(false);
        experience.setFocusable(false);
        b.setText("Edit");
    }
}