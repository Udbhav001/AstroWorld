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

import com.squareup.picasso.Picasso;

public class ViewMyZodiacSign extends Fragment
{
    de.hdodenhof.circleimageview.CircleImageView img;
    TextView text;
    String str="";
    int day,month;
    String txt;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.viewmysign,container,false);
        getDate();

        img=v.findViewById(R.id.img);
        text=v.findViewById(R.id.textq);
        String path=selectZodiac();
        Picasso.get().load(path).into(img);
        text.setText(str);
        //text.setText(txt);
        //  Taurus : "http://www.pngmart.com/files/5/Taurus-PNG-Pic.png"
        // Aquarius : https://www.the-astrology-of-love.com/wp-content/uploads/2017/02/Aquarius.png
        // Cancer : https://3.bp.blogspot.com/-oPoTPSo3zjE/WZbEuu-rLTI/AAAAAAAADr8/Yul-yxqdREMw8iya0dr6Lqg5kf2wHXziwCPcBGAYYCw/s1600/cancer-2018-horoscopes-astrology-zodiac.png
        // Aries : https://4.bp.blogspot.com/-gz3jWKGIA7Q/WZa20KKvnAI/AAAAAAAADrQ/Xb0Egpkh8H4RJPOB8uIX12tZEPaNd9EOACLcBGAs/s1600/aries-2018-years-horoscope-predictions.png
        // Leo : https://2.bp.blogspot.com/-qFmHPT4V6Vw/WX731AB8SGI/AAAAAAAAL_s/E39apg9HKasw6SKrg_2SNSKa9KvUkcTgQCLcBGAs/s1600/aslan-burcu-2018-yillik-burc-yorumlari.png
        // Pisces : https://2.bp.blogspot.com/-h54HZ-iRfT8/WZrv8ROk3XI/AAAAAAAADuI/RUMS6fIE0CsSbx-5eKtp5KEcWwDvDuJtQCLcBGAs/s1600/pisces-2018-horoscope.png
        // Capricorn : https://2.bp.blogspot.com/-fNE0JqdSEnY/WZruLD6fFOI/AAAAAAAADt4/qfz_tT6cwLY3ijDlef-Wvl1pSUIhWwF9gCLcBGAs/s1600/capricorn-2018-horoscopes.png
        // Virgo : http://pngimg.com/uploads/virgo/virgo_PNG21.png
        // Libra : https://3.bp.blogspot.com/--UM4wqgKSc0/WZrhItda58I/AAAAAAAADtQ/fFBjowu54fYpCFVFZU1mqEH8XAYPB7hRgCLcBGAs/s1600/libra-2018-horoscopes-astrology.png
        // Sagittarius : https://i.pinimg.com/originals/2f/19/98/2f1998ce6b2c10037b4b720a85d82bb1.png
        return v;
    }

    private String selectZodiac() {
        String a="http://www.pngmart.com/files/5/Taurus-PNG-Pic.png";
        int arr[]={31,28,31,30,31,30,31,31,30,31,30,31};
        int d=arr[month-1];
        if((month==3 && day>20 && day<31) || (month==4 && day<20)){
            a = "https://4.bp.blogspot.com/-gz3jWKGIA7Q/WZa20KKvnAI/AAAAAAAADrQ/Xb0Egpkh8H4RJPOB8uIX12tZEPaNd9EOACLcBGAs/s1600/aries-2018-years-horoscope-predictions.png";
            str="Aries";
        }
        else if((month==4 && day>19 && day<31) || (month==5 && day<21))
        {
            str="Taurus";
            a="http://www.pngmart.com/files/5/Taurus-PNG-Pic.png";
        }
        else if((month==5 && day>20 && day<32) || (month==6 && day<21))
        {
            str="Gemini";
        }
        if((month==6 && day>20 && day<31) || (month==7 && day<23))
        {
            a="https://3.bp.blogspot.com/-oPoTPSo3zjE/WZbEuu-rLTI/AAAAAAAADr8/Yul-yxqdREMw8iya0dr6Lqg5kf2wHXziwCPcBGAYYCw/s1600/cancer-2018-horoscopes-astrology-zodiac.png";
            str="Cancer";
        }
        if((month==7 && day>22 && day<32) || (month==8 && day<23))
        {
            a="https://2.bp.blogspot.com/-qFmHPT4V6Vw/WX731AB8SGI/AAAAAAAAL_s/E39apg9HKasw6SKrg_2SNSKa9KvUkcTgQCLcBGAs/s1600/aslan-burcu-2018-yillik-burc-yorumlari.png";
            str="Leo";
        }
        if((month==8 && day>22 && day<32) || (month==9 && day<23))
        {
            a="http://pngimg.com/uploads/virgo/virgo_PNG21.png";
            str="Virgo";
        }
        if((month==9 && day>22 && day<31) || (month == 10 && day<23))
        {
            Toast.makeText(getActivity(), "HBD RENU", Toast.LENGTH_SHORT).show();
            a="https://3.bp.blogspot.com/--UM4wqgKSc0/WZrhItda58I/AAAAAAAADtQ/fFBjowu54fYpCFVFZU1mqEH8XAYPB7hRgCLcBGAs/s1600/libra-2018-horoscopes-astrology.png";
            str="Libra";
        }
        if((month==10 && day>22 && day<32) || (month==11 && day<22))
        {
            str="Scorpio";
        }
        if((month==11 && day>21 && day<31) || (month==12 && day<22))
        {
            a="https://i.pinimg.com/originals/2f/19/98/2f1998ce6b2c10037b4b720a85d82bb1.png";
            str="sSagittarius";
        }
        if((month==12 && day>21 && day<32) || (month==1 && day<20))
        {
            a="https://2.bp.blogspot.com/-fNE0JqdSEnY/WZruLD6fFOI/AAAAAAAADt4/qfz_tT6cwLY3ijDlef-Wvl1pSUIhWwF9gCLcBGAs/s1600/capricorn-2018-horoscopes.png";
            str="Capricorn";
        }
        if((month==1 && day>19 && day<32) || (month==2 && day<19))
        {
            a="https://www.the-astrology-of-love.com/wp-content/uploads/2017/02/Aquarius.png";
            str="Aquarius";
        }
        if((month==2 && day>18 && day<29) || (month==3 && day<21))
        {
            a="https://2.bp.blogspot.com/-h54HZ-iRfT8/WZrv8ROk3XI/AAAAAAAADuI/RUMS6fIE0CsSbx-5eKtp5KEcWwDvDuJtQCLcBGAs/s1600/pisces-2018-horoscope.png";
            str="Pisces";
        }
        return a;
    }

    private void getDate()
    {
      String ddmm=  UserMain.profile.getDob();
      day= Integer.parseInt(ddmm.substring(0,2));
      month= Integer.parseInt(ddmm.substring(3,5));
    }
       /* cal = new GregorianCalendar();
        Date thedate = null;
        try
        {
            thedate = new SimpleDateFormat("dd/mm/yyy", Locale.ENGLISH).parse(UserMain.profile.getDob());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        cal.setTime(thedate);
        day=cal.get(Calendar.DAY_OF_MONTH);
        month=cal.get(Calendar.MONTH);
        Toast.makeText(getActivity(), ""+day+" "+month, Toast.LENGTH_SHORT).show();
    }*/
}
