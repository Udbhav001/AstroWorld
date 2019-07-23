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

public class AstrologerMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Intent x;
    public static Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astrologer_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        x=getIntent();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameastro,new HomePage1()).commit();
        profile=(Profile)x.getSerializableExtra("profile");
        NavigationView navigationView1 = (NavigationView) findViewById(R.id.nav_view);
        View hView =  navigationView1.getHeaderView(0);
        TextView t=hView.findViewById(R.id.nav_name);
        System.out.println(profile.getName());
        t.setText(profile.getName());


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
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.viewsig)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameastro,new HomePage1()).commit();
        }
        if (id == R.id.nav_ques)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameastro,new ViewQuestionAstrologer()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_profile)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameastro,new ViewAstrologerProfile()).commit();
        } else if (id == R.id.nav_logout) {

            Intent x=new Intent(AstrologerMain.this,Login.class);
            x.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(x);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
