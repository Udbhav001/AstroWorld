package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AskQuestions extends Fragment
{
public  static String astroid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button viewastro,askques,viewanwer;
        final Spinner listastro;
            View v=inflater.inflate(R.layout.askquestion,container,false);
            viewastro=v.findViewById(R.id.viewastro);
            askques=v.findViewById(R.id.askques);
            listastro=v.findViewById(R.id.astrolist);
            viewanwer=v.findViewById(R.id.viewanswer);
        SendFunction sf=new Connection_baseurl().creater().create(SendFunction.class);
        Call<ArrayList<String>> call = sf.askQuestions(UserMain.profile.getUserid());
        Toast.makeText(getContext(), "renu", Toast.LENGTH_SHORT).show();
       call.enqueue(new Callback<ArrayList<String>>() {

          @Override
          public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
       ArrayList<String> astro=new ArrayList<>();
              ArrayList<String> arr=response.body();
        if(arr.size()>0)
              {
                  for(int i=0;i<arr.size();i++)
                  {
                     astro.add((String)arr.get(i));
                  }
                  ArrayAdapter<String> ad=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,astro);
                  listastro.setAdapter(ad);

              }
              else
              {
                  Toast.makeText(getContext(), "error in login.Retry", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<ArrayList<String>> call, Throwable t) {
              Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();

          }
      });
viewastro.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameuser,new ViewAstrologerProfileonclick());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        astroid=(String) listastro.getSelectedItem();

    }
});
askques.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameuser,new AskQuesAstro());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        astroid=(String) listastro.getSelectedItem();


    }
});
viewanwer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameuser,new ViewQuestionAnswer());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        astroid=(String) listastro.getSelectedItem();


    }
});


            return v;

    }

}
