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
import android.widget.Toast;

import com.example.astroworld.bean.QuestionAnswer;
import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewQuestionAnswer extends Fragment implements AdapterView.OnItemClickListener
{
    public static QuestionAnswer ques;
    ArrayList<QuestionAnswer> arr;
    String aid=AskQuestions.astroid;
String uid= UserMain.profile.getUserid();
    ListView list;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.viewanswer,container,false);
        list=v.findViewById(R.id.list);
        list.setOnItemClickListener(this);
        final ArrayList<String> ques=new ArrayList<>();
        SendFunction sf=new Connection_baseurl().creater().create(SendFunction.class);
        Call<ArrayList<QuestionAnswer>> call=sf.viewanswer(uid,aid);
        Toast.makeText(getActivity(), "HEllO", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<ArrayList<QuestionAnswer>>() {
            @Override
            public void onResponse(Call<ArrayList<QuestionAnswer>> call, Response<ArrayList<QuestionAnswer>> response) {
                arr=response.body();
                if(arr.size()>0)
                {
                    Toast.makeText(getActivity(), ""+arr.size(), Toast.LENGTH_SHORT).show();
                    for(int i=0;i<arr.size();i++)
                    {
                        ques.add(String.valueOf(i+1)+". "+arr.get(i).getQuestion());
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (arr.get(position).getStatus().equalsIgnoreCase("Pending")) {
            Toast.makeText(getActivity(), "Answer not posted. Stay tuned.", Toast.LENGTH_SHORT).show();
        } else {
            ques=arr.get(position);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameuser, new ViewUserQuesAns());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
