package com.example.astroworld;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WriteMessage extends Fragment implements View.OnClickListener
{
    Button b;
    TextView t;
    EditText e;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.writemessage,container,false);
        b=v.findViewById(R.id.send);
        t=v.findViewById(R.id.phoneno);
        e=v.findViewById(R.id.message1);
        t.setText(Call_Sms_Astrologer.x.getPhoneno());
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        sendMessage(Call_Sms_Astrologer.x.getPhoneno(),e.getText().toString());
    }

    public  void sendMessage(String phone, String message)
    {
        SmsManager s= SmsManager.getDefault();
        Intent obj=new Intent(getActivity(),WriteMessage.class);
        PendingIntent p= PendingIntent.getActivity(getActivity(),1,obj, PendingIntent.FLAG_ONE_SHOT);
        s.sendTextMessage(phone,"",message,p,null);
        Toast.makeText(getActivity(), "Message Send", Toast.LENGTH_SHORT).show();
    }

}
