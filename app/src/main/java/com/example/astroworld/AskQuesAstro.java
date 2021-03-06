package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AskQuesAstro extends Fragment {
    String uid,aid,q,doa;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.askquesastro,container,false);
        ImageView ques=v.findViewById(R.id.ques);
        Picasso.get().load("https://cdn.pixabay.com/photo/2017/03/18/09/01/question-mark-2153514_960_720.jpg").into(ques);

        TextView title=v.findViewById(R.id.title);
        final TextView question=v.findViewById(R.id.question);
        Animation a= AnimationUtils.loadAnimation(getContext(),R.anim.fadeinfadeout);
        title.startAnimation(a);
         aid=AskQuestions.astroid;
         uid=(String)UserMain.profile.getUserid();
        Calendar c= Calendar.getInstance();
        DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
        doa= d.format(c.getTime()).toString();
        Toast.makeText(getActivity(), ""+uid+" "+q, Toast.LENGTH_SHORT).show();
        Button btnask=v.findViewById(R.id.btnask);
        btnask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                q=question.getText().toString();
                Toast.makeText(getContext(), ""+q, Toast.LENGTH_SHORT).show();
                SendFunction function= new Connection_baseurl().creater().create(SendFunction.class);
                Call<String> call=function.question(uid,aid,q,doa);

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String res=response.body();
                        if(res.equalsIgnoreCase("success"))
                        {
                            Toast.makeText(getActivity(), "Your answer is submited", Toast.LENGTH_SHORT).show();


                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getActivity(), "Faliled", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return v;
    }

}
