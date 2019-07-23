package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.astroworld.bean.Profile;
import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAstrologerProfileonclick extends Fragment
{
    EditText name, email, address, phoneno, experience, skill;
    Profile a=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.viewastrologerprofileonclick,container,false);
        skill=v.findViewById(R.id.skill);
        experience = v.findViewById(R.id.experience);
        name = v.findViewById(R.id.name);
        email = v.findViewById(R.id.email);
        address = v.findViewById(R.id.address);
        System.out.println("Renu");
        phoneno = v.findViewById(R.id.phoneno);
        SendFunction sf=new Connection_baseurl().creater().create(SendFunction.class);
        Toast.makeText(getActivity(), ""+AskQuestions.astroid, Toast.LENGTH_SHORT).show();
        Call<ArrayList<Profile>> call=sf.viewAstrologer(AskQuestions.astroid);
        System.out.println("renu");
        call.enqueue(new Callback<ArrayList<Profile>>() {
            @Override
            public void onResponse(Call<ArrayList<Profile>> call, Response<ArrayList<Profile>> response)
            {
                System.out.println("Renu");
                ArrayList<Profile> arr=response.body();
                Toast.makeText(getActivity(), ""+arr.toString(), Toast.LENGTH_SHORT).show();

                if(arr.size()>0)
                {
                    a=arr.get(0);
                    System.out.println("Hello Renu "+a.getAddress());

                    name.setText(a.getName());
                    email.setText(a.getEmail());
                    address.setText(a.getAddress());
                    skill.setText(a.getSkill());
                    experience.setText(a.getExperience());
                    phoneno.setText(a.getPhoneno());
                }
                else
                {
                    Toast.makeText(getActivity(), "in else", Toast.LENGTH_SHORT).show();


                }
            }
            @Override
            public void onFailure(Call<ArrayList<Profile>> call, Throwable t) {

            }
        });
       // showData();
        return v;
    }
    private void showData()

    {
        if(a!=null) {
            name.setText(a.getName());
            email.setText(a.getEmail());
            address.setText(a.getAddress());
            skill.setText(a.getSkill());
            experience.setText(a.getExperience());
            phoneno.setText(a.getPhoneno());
        }
    }
}