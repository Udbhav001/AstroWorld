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

public class ViewUserProfile extends Fragment {
    Button b;
    EditText name, email, address, phoneno, dob;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewuserprofile, container, false);
        b = v.findViewById(R.id.edit);
        dob = v.findViewById(R.id.dob);
        name = v.findViewById(R.id.name);
        email = v.findViewById(R.id.email);
        address = v.findViewById(R.id.address);
        phoneno = v.findViewById(R.id.phoneno);
        showData();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b.getText().toString().equalsIgnoreCase("Edit")) {
                    enable();
                }
               else {
                    disable();
                    SendFunction sf=new Connection_baseurl().creater().create(SendFunction.class);
                    Call<ArrayList<Profile>> call = sf.updateUser(name.getText().toString(),address.getText().toString(),email.getText().toString(),phoneno.getText().toString(),UserMain.profile.userid);
                    call.enqueue(new Callback<ArrayList<Profile>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Profile>> call, Response<ArrayList<Profile>> response) {
                            ArrayList<Profile> arr=response.body();
                            if(arr.size()>0)
                            {
                                System.out.println("inside main");
                                Profile a=arr.get(0);
                                if(a.getErrormsg().equalsIgnoreCase("success"))
                                {
                                    UserMain.profile.setName(a.getName());
                                    UserMain.profile.setAddress(a.getAddress());
                                    UserMain.profile.setEmail(a.getEmail());
                                    UserMain.profile.setPhoneno(a.getPhoneno());
                                }
                                if(a.getErrormsg().equalsIgnoreCase("success"))
                                    Toast.makeText(getActivity(), "Updated Successfully.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Profile>> call, Throwable t) {

                        }
                    });
                }
            }
        });
        return v;
    }
    private void showData()
    {
        Profile a = UserMain.profile;
        name.setText(a.getName());
        email.setText(a.getEmail());
        address.setText(a.getAddress());
        dob.setText(a.getDob());
        Toast.makeText(getContext(), ""+a.getDob(), Toast.LENGTH_SHORT).show();
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
        b.setText("Update");
    }
    public void disable() {
        name.setClickable(false);
        name.setFocusable(false);
        email.setClickable(false);
        email.setFocusable(false);
        address.setClickable(false);
        address.setFocusable(false);
        phoneno.setClickable(false);
        phoneno.setFocusable(false);
        b.setText("Edit");
    }
}
