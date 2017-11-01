package com.example.navigationmenu;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    //Variable creation:
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    //Override method:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Set layout for activity
        mToolbar = (Toolbar) findViewById(R.id.nav_action); //Finds Toolbar with name nav_action
        setSupportActionBar(mToolbar); //Displays activity name
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);//Finds DrawerLayout-i with name drawerLayout
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);//Adds "Open" and "Close" to the ActionBar.
        mDrawerLayout.addDrawerListener(mToggle);//Drawer activities.
        mToggle.syncState(); //Syncronize mToggle variable.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();//Fragment action starts

        fragmentTransaction.add(R.id.main_container, new HomeFragment());//Changes Fragment to 'HomeFragment'
        fragmentTransaction.commit();//Connects Fragment
        getSupportActionBar().setTitle("Home fragment...");//Changes Fragment title

        navigationView = (NavigationView)findViewById(R.id.navigation_menu);//Finds NavigationView with name navigation_menu
        //New method:
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //-changes Item id
                switch (item.getItemId()) {
                    //"case..." activate corresponding Fragment dependant on choice
                    case R.id.nav_home_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();//Fragment activity start
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());//Changes Fragment onto corresponding Fragment
                        fragmentTransaction.commit();//Connects Fragments
                        getSupportActionBar().setTitle("Home fragment");//Changes Fragment title
                        item.setChecked(true);//Connects Item value to true
                        mDrawerLayout.closeDrawers(); //Close Drawer
                        break;//Closes Fragment
                    case R.id.nav_email_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new EmailFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Email fragment");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_calendar_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new CalendarFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Calendar fragment");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;
                }
                return true; //Return result
            }
            });
        }
    //New meetod:
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) { //Check if item is selected
            return true;//Upon positive result, return true
        }
        return super.onOptionsItemSelected(item);//Return upon negative result
    }
}