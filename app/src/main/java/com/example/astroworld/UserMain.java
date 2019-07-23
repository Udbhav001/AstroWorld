package com.example.astroworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.astroworld.bean.Profile;

import java.io.Serializable;

public class UserMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Serializable {
    Intent x;
    public static Profile profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        x=getIntent();
        profile=(Profile)x.getSerializableExtra("profile");
        NavigationView navigationView1 = (NavigationView) findViewById(R.id.nav_view);
        View hView =  navigationView1.getHeaderView(0);
        TextView t=hView.findViewById(R.id.nav_name);
        System.out.println(profile.getName());
        t.setText(profile.getName());
        getSupportFragmentManager().beginTransaction().replace(R.id.frameuser,new HomePage()).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else

            {
                super.onBackPressed();
        }
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_sunshine) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameuser,new HomePage()).commit();
        } else if (id == R.id.nav_question) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameuser,new AskQuestions()).commit();
        } else if (id == R.id.nav_compatibility) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameuser,new compatibility()).commit();
        } else if (id == R.id.nav_game) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameuser,new Game()).commit();
        } else if (id == R.id.nav_profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameuser,new ViewUserProfile()).commit();

        } else if (id == R.id.nav_contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameuser,new Call_Sms_Astrologer()).commit();

        } else if (id == R.id.nav_mysign){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameuser,new ViewMyZodiacSign()).commit();
        } else if(id == R.id.nav_logout) {

            Intent x=new Intent(UserMain.this,Login.class);
            x.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(x);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
