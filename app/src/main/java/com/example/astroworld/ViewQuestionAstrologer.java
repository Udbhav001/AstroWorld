package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.astroworld.bean.QuestionAnswer;
import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewQuestionAstrologer extends Fragment implements AdapterView.OnItemClickListener
{
    public static ArrayList<QuestionAnswer> arr;
    public static QuestionAnswer questionAnswer;
    ListView list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.viewquesastro,container,false);
        list=v.findViewById(R.id.list);
        list.setOnItemClickListener(this);
        final ArrayList<String> ques=new ArrayList<>();
        SendFunction sf=new Connection_baseurl().creater().create(SendFunction.class);
        Call<ArrayList<QuestionAnswer>> call=sf.viewQuesAstro(AstrologerMain.profile.getUserid());
        call.enqueue(new Callback<ArrayList<QuestionAnswer>>() {
            @Override
            public void onResponse(Call<ArrayList<QuestionAnswer>> call, Response<ArrayList<QuestionAnswer>> response) {
                 arr=response.body();
                if(arr.size()>0)
                {
                    for(int i=0;i<arr.size();i++)
                    {
                        ques.add(String.valueOf(i+1)+". " +arr.get(i).getQuestion());
                    }
                    ArrayAdapter<String> a=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ques);
                    list.setAdapter(a);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<QuestionAnswer>> call, Throwable t) {

            }
        });
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        questionAnswer=arr.get(position);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameastro,new SendAnswer());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
