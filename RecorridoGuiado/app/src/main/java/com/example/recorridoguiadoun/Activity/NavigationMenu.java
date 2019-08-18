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
        NavigationView navigationView1 = findViewById(R.id.nav_view);
        Menu menu = navigationView1.getMenu();
        String titles[] = GameController.updateMenuItems();
        MenuItem menuItem;

        for (int i = 0; i < titles.length; i++) {
            if (titles[i] != null) {
                menuItem = getMenuItemByStationId(i,menu);
                menuItem.setTitle(titles[i]);
                menuItem.setIcon(R.drawable.ic_done_all_black_24dp);
                menuItem.setEnabled(true);
            }
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();


        if (id == R.id.nav_home) {
            switch (GameController.saver.estadoActual){
                case "Hint":
                    fragmentManager.beginTransaction()
                            .replace(R.id.content_frame,
                                    new HintFragment())
                            .commit();
                    break;
                case "Info":
                    GameController.saver.estacionActual = GameController.saver.ruta[GameController.saver.pos];
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

        } else if (id == R.id.nav_estacion1) {
            GameController.saver.estacionActual = GameController.saver.ruta[0];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion2){
            GameController.saver.estacionActual = GameController.saver.ruta[1];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion3){
            GameController.saver.estacionActual = GameController.saver.ruta[2];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion4){
            GameController.saver.estacionActual = GameController.saver.ruta[3];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion5){
            GameController.saver.estacionActual = GameController.saver.ruta[4];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion6){
            GameController.saver.estacionActual = GameController.saver.ruta[5];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion7){
            GameController.saver.estacionActual = GameController.saver.ruta[6];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion8){
            GameController.saver.estacionActual = GameController.saver.ruta[7];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion9){
            GameController.saver.estacionActual = GameController.saver.ruta[8];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion10){
            GameController.saver.estacionActual = GameController.saver.ruta[9];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        } else if (id == R.id.nav_estacion11){
            GameController.saver.estacionActual = GameController.saver.ruta[10];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new InfoFragment())
                    .commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public MenuItem getMenuItemByStationId(int id, Menu menu){
        switch (id){
            case 0: return menu.findItem(R.id.nav_estacion1);
            case 1: return menu.findItem(R.id.nav_estacion2);
            case 2: return menu.findItem(R.id.nav_estacion3);
            case 3: return menu.findItem(R.id.nav_estacion4);
            case 4: return menu.findItem(R.id.nav_estacion5);
            case 5: return menu.findItem(R.id.nav_estacion6);
            case 6: return menu.findItem(R.id.nav_estacion7);
            case 7: return menu.findItem(R.id.nav_estacion8);
            case 8: return menu.findItem(R.id.nav_estacion9);
            case 9: return menu.findItem(R.id.nav_estacion10);
            case 10: return menu.findItem(R.id.nav_estacion11);
            default : return null;
        }
    }
}
