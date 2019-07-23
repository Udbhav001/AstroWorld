package com.example.astroworld;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class compatibility extends Fragment
{
    de.hdodenhof.circleimageview.CircleImageView user,com1,com2;
    TextView usertext,com1text,com2text;
    String str;
    int us,com1id,com2id;
    String username,com1name,com2name;
    int day,month;
    String txt;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.compatibality,container,false);
        getDate();
        user=v.findViewById(R.id.zodiac);
        com1=v.findViewById(R.id.image1);
        com2=v.findViewById(R.id.image2);
        usertext=v.findViewById(R.id.zodiac_text);
        com1text=v.findViewById(R.id.image1_text);
        com2text=v.findViewById(R.id.image2_text);
        selectZodiac();
        findCompatibility();
        System.out.print("Hello renu"+us+" "+com1id+" "+com2id+" "+username+" "+com1name+" "+com2name);
        placezodiac(us,com1id,com2id,username,com1name,com2name);
        return v;
    }

    private void placezodiac(int us1, int com1id1, int com2id1, String username1, String com1name1, String com2name1)
    {
        user.setImageResource(us1);
        com1.setImageResource(com1id1);
        com2.setImageResource(com2id1);
        usertext.setText(username1);
        com1text.setText(com1name1);
        com2text.setText(com2name1);
    }

    private void findCompatibility()
    {
        if(str.equalsIgnoreCase("Aries"))
        {
            us=R.drawable.sign9;
            username="Aries";
            com1id=R.drawable.sign3;
            com1name="Gemini";
            com2id=R.drawable.sign1;
            com2name="Taurus";
        }
        else if(str.equalsIgnoreCase("Taurus"))
        {
            us=R.drawable.sign1;
            username="Taurus";
            com1id=R.drawable.sign9;
            com1name="Aries";
            com2id=R.drawable.sign7;
            com2name="Libra";
        }
        else if(str.equalsIgnoreCase("Gemini"))
        {
            us=R.drawable.sign3;
            username="Gemini";
            com1id=R.drawable.sign12;
            com1name="Pisces";
            com2id=R.drawable.sign6;
            com2name="Virgo";
        }
        else if(str.equalsIgnoreCase("Cancer"))
        {
            us=R.drawable.sign4;
            username="Cancer";
            com1id=R.drawable.sign2;
            com1name="Scorpio";
            com2id=R.drawable.sign1;
            com2name="Taurus";
        }
        else if(str.equalsIgnoreCase("Leo"))
        {
            us=R.drawable.sign5;
            username="Leo";
            com1id=R.drawable.sign8;
            com1name="Sagittarius";
            com2id=R.drawable.sign4;
            com2name="Cancer";
        }
        else if(str.equalsIgnoreCase("Virgo"))
        {
            us=R.drawable.sign6;
            username="Virgo";
            com1id=R.drawable.sign11;
            com1name="Aquarius";
            com2id=R.drawable.sign8;
            com2name="Sagittarius";
            System.out.print("HEllo");
        }
        else if(str.equalsIgnoreCase("Libra"))
        {
            us=R.drawable.sign7;
            username="Libra";
            com1id=R.drawable.sign6;
            com1name="Virgo";
            com2id=R.drawable.sign4;
            com2name="Cancer";
        }
        else if(str.equalsIgnoreCase("Scorpio"))
        {
            us=R.drawable.sign2;
            username="Scorpio";
            com1id=R.drawable.sign12;
            com1name="Pisces";
            com2id=R.drawable.sign5;
            com2name="Leo";
        }
        else if(str.equalsIgnoreCase("Sagittarius"))
        {
            us=R.drawable.sign8;
            username="Sagittarius";
            com1id=R.drawable.sign12;
            com1name="Pisces";
            com2id=R.drawable.sign10;
            com2name="Capricorn";
        }
        else if(str.equalsIgnoreCase("Capricorn"))
        {
            us=R.drawable.sign10;
            username="Capricorn";
            com1id=R.drawable.sign11;
            com1name="Aquarius";
            com2id=R.drawable.sign1;
            com2name="Taurus";
        }
        else if(str.equalsIgnoreCase("Aquarius")) {
            us=R.drawable.sign11;
            username="Aquarius";
            com1id=R.drawable.sign10;
            com1name="Capricorn";
            com2id=R.drawable.sign8;
            com2name="Sagittarius";
        }

        else if(str.equalsIgnoreCase("Pisces")) {
            us=R.drawable.sign12;
            username="Pisces";
            com1id=R.drawable.sign3;
            com1name="Gemini";
            com2id=R.drawable.sign2;
            com2name="Scorpio";
        }

    }


    private void selectZodiac() {
        if((month==3 && day>20 && day<31) || (month==4 && day<20)){
            str="Aries";
        }
        else if((month==4 && day>19 && day<31) || (month==5 && day<21))
        {
            str="Taurus";
        }
        else if((month==5 && day>20 && day<32) || (month==6 && day<21))
        {
            str="Gemini";
        }
        if((month==6 && day>20 && day<31) || (month==7 && day<23))
        {
            str="Cancer";
        }
        if((month==7 && day>22 && day<32) || (month==8 && day<23))
        {
            str="Leo";
        }
        if((month==8 && day>22 && day<32) || (month==9 && day<23))
        {
            str="Virgo";
        }
        if((month==9 && day>22 && day<31) || (month == 10 && day<23))
        {
            Toast.makeText(getActivity(), "HBD RENU", Toast.LENGTH_SHORT).show();
            str="Libra";
        }
        if((month==10 && day>22 && day<32) || (month==11 && day<22))
        {
            str="Scorpio";
        }
        if((month==11 && day>21 && day<31) || (month==12 && day<22))
        {
            str="Sagittarius";
        }
        if((month==12 && day>21 && day<32) || (month==1 && day<20))
        {
            str="Capricorn";
        }
        if((month==1 && day>19 && day<32) || (month==2 && day<19))
        {
            str="Aquarius";
        }
        if((month==2 && day>18 && day<29) || (month==3 && day<21))
        {
            str="Pisces";
        }
    }

    private void getDate() {
        String ddmm = UserMain.profile.getDob();
        day = Integer.parseInt(ddmm.substring(0, 2));
        month = Integer.parseInt(ddmm.substring(3, 5));
    }
}
