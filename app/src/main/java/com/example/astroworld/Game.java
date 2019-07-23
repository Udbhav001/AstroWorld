package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class Game extends Fragment
{
    TextView t,w;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.game,container,false);
        Random r = new Random();
        int a = r.nextInt(50 - 0)+50;
        t=v.findViewById(R.id.textView2);
        w=v.findViewById(R.id.textw);
        String str;
        t.setText(String.valueOf(a)+"%");
        if(a<60)
            str="You are not so lucky.";
        else if(a<80)
            str="You are Lucky";
        else
            str="You are very lucky";
        w.setText(str);
        return v;
    }
}
