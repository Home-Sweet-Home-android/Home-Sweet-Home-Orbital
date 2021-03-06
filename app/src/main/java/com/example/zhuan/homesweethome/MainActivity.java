package com.example.zhuan.homesweethome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton5);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        BotNavAnimationRemover.disableShiftMode(bottomNavigationView);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HelloSceneformActivity.class);
                startActivity(intent);
            }
        });

        loadFragment(new MainMenu2Fragment());
    }

    private boolean loadFragment (Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container2, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch(item.getItemId()){
            case R.id.navigation_my_collection:
                fragment = new MyCollectionFragment();
                break;

            case R.id.navigation_brands:
                fragment = new BrandsActivity();
                break;

            case R.id.navigation_browse:
                fragment = new MainMenu2Fragment();
                break;

            case R.id.navigation_help:
                fragment = new HelpFragment();
                break;
        }

        return loadFragment(fragment);
    }
}
