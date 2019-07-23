package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class HomePage1 extends Fragment implements View.OnClickListener
{int i;
    public  static String sign;

ImageView sign1,sign2,sign3,sign4,sign5,sign6,sign7,sign8,sign9,sign10,sign11,sign12;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.homepage,container,false);

    sign1=v.findViewById(R.id.sign1);
        sign1=v.findViewById(R.id.sign1);
        sign2=v.findViewById(R.id.sign2);
        sign3=v.findViewById(R.id.sign3);
        sign4=v.findViewById(R.id.sign4);
        sign5=v.findViewById(R.id.sign5);
        sign6=v.findViewById(R.id.sign6);
        sign7=v.findViewById(R.id.sign7);
        sign8=v.findViewById(R.id.sign8);
        sign9=v.findViewById(R.id.sign9);
        sign10=v.findViewById(R.id.sign10);
        sign11=v.findViewById(R.id.sign11);
        sign12=v.findViewById(R.id.sign12);
        sign1.setOnClickListener(this);
        sign2.setOnClickListener(this);
        sign3.setOnClickListener(this);
        sign4.setOnClickListener(this);
        sign5.setOnClickListener(this);
        sign6.setOnClickListener(this);
        sign7.setOnClickListener(this);
        sign8.setOnClickListener(this);
        sign9.setOnClickListener(this);
        sign10.setOnClickListener(this);
        sign11.setOnClickListener(this);
        sign12.setOnClickListener(this);








        return v;

    }

    @Override
    public void onClick(View v)
    {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameastro,new ViewSign());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        if(v.getId()==R.id.sign1)
        {
            sign="ARIES";

            Toast.makeText(getActivity(), "Vineet", Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.sign2)
        {
            sign="PISCES";
        }
        if(v.getId()==R.id.sign3)
        {
            sign="VIRGO";
        }
        if(v.getId()==R.id.sign4)
        {
            sign="GEMINI";
        }
        if(v.getId()==R.id.sign5)
        {
            sign="ACQUARIUS";
        }
        if(v.getId()==R.id.sign6)
        {
            sign="SCORPIO";
        }
        if(v.getId()==R.id.sign7)
        {
            sign="CAPRICORN";
        }
        if(v.getId()==R.id.sign8)
        {
            sign="LIBRA";
        }
        if(v.getId()==R.id.sign9)
        {
            sign="SAGITTARIUS";
        }
        if(v.getId()==R.id.sign10)
        {
            sign="CANCER";
        }
        if(v.getId()==R.id.sign11)
        {
            sign="TAURUS";
        }
        if(v.getId()==R.id.sign12)
        {
            sign="LEO";
        }




    }
}
