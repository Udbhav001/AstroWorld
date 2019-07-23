package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.astroworld.bean.QuestionAnswer;
import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewUserQuesAns extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.viewuserques,container,false);
        ImageView ques=v.findViewById(R.id.ques);
        Picasso.get().load("https://cdn.pixabay.com/photo/2017/03/18/09/01/question-mark-2153514_960_720.jpg").into(ques);

        final TextView t2=v.findViewById(R.id.t2);
        final TextView t=v.findViewById(R.id.title1);
                SendFunction function= new Connection_baseurl().creater().create(SendFunction.class);
                Call<ArrayList<QuestionAnswer>> call=function.view1(ViewQuestionAnswer.ques.getQuestion(),ViewQuestionAnswer.ques.getAstroid());

                call.enqueue(new Callback<ArrayList<QuestionAnswer>>() {
                    @Override
                    public void onResponse(Call<ArrayList<QuestionAnswer>> call, Response<ArrayList<QuestionAnswer>> response) {

                        ArrayList<QuestionAnswer> arrr=response.body();
                        if(arrr.size()>0)
                        {
                            t2.setText(arrr.get(0).getQuestion());
                            t.setText(arrr.get(0).getAns());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<QuestionAnswer>> call, Throwable t) {

                    }
                });

        return v;
    }
}
