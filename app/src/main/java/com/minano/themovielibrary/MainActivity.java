package com.minano.themovielibrary;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.minano.themovielibrary.controllers.ItemFilterController;
import com.minano.themovielibrary.views.fragments.FragmentSelector;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public int tabbedOption = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if ((findViewById(R.id.small_container) != null) && (getSupportFragmentManager().findFragmentById(R.id.small_container) == null)) {
            FragmentSelector firstFragment = new FragmentSelector();
            getFragmentManager().beginTransaction().add(R.id.small_container, firstFragment).commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.film_latest) {

        } else if (id == R.id.film_most_popular) {
            tabbedOption = ItemFilterController.MOSTPOPULAR_FILMS;
        } else if (id == R.id.film_top_rated) {
            tabbedOption = ItemFilterController.TOPRATED_FILMS;
        } else if (id == R.id.tv_most_popular) {
            tabbedOption = ItemFilterController.MOSTPOPULAR_TVSHOWS;
        } else if (id == R.id.tv_top_rated) {
            tabbedOption = ItemFilterController.TOPRATED_TVSHOWS;
        } else if (id == R.id.tv_latest) {
            // …
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
}
