package com.example.recorridoguiadoun.Activity;

import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.recorridoguiadoun.Controllers.GameController;
import com.example.recorridoguiadoun.Models.Saver;
import com.example.recorridoguiadoun.R;

import java.util.Arrays;

public class NavigationMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public SharedPreferences mPrefs;

    private static NavigationMenu menu;
    private static String[] titles;
    private Menu internalMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
        mPrefs = getPreferences(MODE_PRIVATE);
        GameController.loadGame(mPrefs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (GameController.saver.estadoActual) {
            case "Hint":
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame,
                                new HintFragment())
                        .commit();
                break;
            case "Info":
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame,
                                new InfoFragment())
                        .commit();
                break;
            case "Finish":
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame,
                                new FinishFragment())
                        .commit();
                break;
        }
        GameController.updateMenuItems();
        menu = this;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.navigation_menu, menu);

        this.internalMenu = menu;

        return true;
    }


    private void update(){
        MenuItem item;

        System.out.println("->->->" + Arrays.toString(titles));

        if(titles == null) return;

        for(int i = 0; i < titles.length; i++){

            if(titles[i] != null && (item = getMenuItemByStationId(i)) != null){
                item.setTitle(titles[i]);
                item.setEnabled(true);
                System.out.println("Changed value " + item.getTitle() + ", want to " + titles[i]);
            }
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();


        if (id == R.id.nav_home) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion1) {

        } else if (id == R.id.nav_estacion2){

        } else if (id == R.id.nav_estacion3){

        } else if (id == R.id.nav_estacion4){

        } else if (id == R.id.nav_estacion5){

        } else if (id == R.id.nav_estacion6){

        } else if (id == R.id.nav_estacion7){

        } else if (id == R.id.nav_estacion8){

        } else if (id == R.id.nav_estacion9){

        } else if (id == R.id.nav_estacion10){

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void update(String[] titles){
        NavigationMenu.titles = titles;
        NavigationMenu.menu.update();
    }

    public MenuItem getMenuItemByStationId(int id){
        switch (id){
            case 0: return internalMenu.findItem(R.id.nav_estacion1);
            case 1: return internalMenu.findItem(R.id.nav_estacion2);
            case 2: return internalMenu.findItem(R.id.nav_estacion3);
            case 3: return internalMenu.findItem(R.id.nav_estacion4);
            case 4: return internalMenu.findItem(R.id.nav_estacion5);
            case 5: return internalMenu.findItem(R.id.nav_estacion6);
            case 6: return internalMenu.findItem(R.id.nav_estacion7);
            case 7: return internalMenu.findItem(R.id.nav_estacion8);
            case 8: return internalMenu.findItem(R.id.nav_estacion9);
            case 9: return internalMenu.findItem(R.id.nav_estacion10);
            case 10: return internalMenu.findItem(R.id.nav_estacion11);
            default : return null;
        }
    }
}
