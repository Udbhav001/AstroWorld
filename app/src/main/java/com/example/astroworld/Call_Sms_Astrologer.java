package com.example.astroworld;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.astroworld.bean.Profile;
import com.example.astroworld.connection.Connection_baseurl;
import com.example.astroworld.connection.SendFunction;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Call_Sms_Astrologer extends Fragment implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener
{
    public static Profile x;
    ArrayList<Profile> arr;
    ListView l;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.call_sms_astrologer,container,false);
        l=v.findViewById(R.id.list);
        arr=new ArrayList<>();
        populateList();
        l.setOnItemClickListener(this);
        return v;
    }

    private void populateList()
    {
        final ArrayList<String> arrlist = new ArrayList<>();
        SendFunction function= new Connection_baseurl().creater().create(SendFunction.class);
        Call<ArrayList<Profile>> call=function.call_sms("1");
        call.enqueue(new Callback<ArrayList<Profile>>() {
            @Override
            public void onResponse(Call<ArrayList<Profile>> call, Response<ArrayList<Profile>> response) {
                arr=response.body();
                if(arr.size()>0) {
                    for (int i = 0; i < arr.size(); i++) {
                        arrlist.add(String.valueOf(i+1)+". "+ arr.get(i).getName());
                    }
                    ArrayAdapter<String> q=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrlist);
                    l.setAdapter(q);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Profile>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        x=arr.get(position);
        AlertDialog.Builder q=new AlertDialog.Builder(getActivity());
        q.setTitle("Choose");
        q.setPositiveButton("Sms", this);
        q.setNeutralButton("Cancel",this);
        q.setNegativeButton("Call",this);
        q.create().show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Intent w;
        switch (which)
        {
            case DialogInterface.BUTTON_POSITIVE:
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameuser,new WriteMessage());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                w = new Intent(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel:" + x.getPhoneno());
                w.setData(uri);
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(w);
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                break;
        }
    }
}
