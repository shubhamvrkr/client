package com.cardroid.psl.obdcardroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.cardroid.psl.obdcardroid.Fragments.Aboutus;
import com.cardroid.psl.obdcardroid.Fragments.Dashboard;
import com.cardroid.psl.obdcardroid.Fragments.Request;
import com.cardroid.psl.obdcardroid.Fragments.VehicleInfo;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,Aboutus.OnFragmentInteractionListener,Dashboard.OnFragmentInteractionListener
        ,VehicleInfo.OnFragmentInteractionListener,Request.OnFragmentInteractionListener {


    NavigationView navigationView;
    int viewId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().getItem(viewId));


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Fragment fragment =null;
        String title = null;

        if (id == R.id.dashboard) {

            viewId =0;
            fragment = new Dashboard();
            title ="Dashboard";

        } else if (id == R.id.requests) {

            viewId =1;
            fragment = new Request();
            title ="Requests";

        } else if (id == R.id.vehicalinfo) {

            viewId =2;
            fragment = new VehicleInfo();
            title ="Vehicle info";

        } else if (id == R.id.aboutus) {

            viewId =3;
            fragment = new Aboutus();
            title ="About us";


        } else if (id == R.id.setting) {

            //handle settingnt
            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(this,SettingActivity.class);
            startActivity(intent);

        } else if (id == R.id.sos) {

            //handle SOS functionality

            setFragmentOnViewID(viewId);


        }else if (id == R.id.senddata) {

            //handle send data functionality

            setFragmentOnViewID(viewId);

        }

        if (fragment != null) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
// set the toolbar title
        if (getSupportActionBar() != null &&title!=null) {
            getSupportActionBar().setTitle(title);
        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            Log.d("drawer","open");
            drawer.closeDrawer(GravityCompat.START);
        }


        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onPostResume() {

        setFragmentOnViewID(viewId);
        super.onPostResume();

    }
    public void setFragmentOnViewID(int viewid){

        Log.d("viewID",String.valueOf(viewid));
        Fragment fragment =null;
        String title =null;

        if(viewId==0){

            fragment = new Dashboard();
            title ="Dashboard";

        }else if(viewId==1){

            fragment = new Request();
            title ="Request";

        }else if(viewId==2){

            fragment = new VehicleInfo();
            title ="Vehicle info";

        }else if(viewId==3) {

            fragment = new Aboutus();
            title ="About us";

        }

        if(fragment!=null) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();

        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

    }
}
