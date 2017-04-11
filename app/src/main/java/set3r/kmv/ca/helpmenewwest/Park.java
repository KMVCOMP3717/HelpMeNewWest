package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Park extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mtoolbar;
    private NavigationView navi;
    Button park1;
    Button park2;
    Button park3;
    Button park4;
    Button parkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        park1 = (Button) findViewById(R.id.park1);
        park2 = (Button) findViewById(R.id.park2);
        park3 = (Button) findViewById(R.id.park3);
        park4 = (Button) findViewById(R.id.park4);
        parkList = (Button) findViewById(R.id.parklistbtn);

        navi = (NavigationView) findViewById(R.id.nav_view);
        sideMenu();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void toParkListOnClick(View v) {
        startActivity(new Intent(this, ParkList.class));
    }

    public void toParkTemplateOnClick(View v) {
        startActivity(new Intent(this, ParkTemplate.class));
    }



    public void sideMenu(){
        mtoolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mtoolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_park);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close){
            public void onDrawerOpended(View v){
                super.onDrawerOpened(v);

                invalidateOptionsMenu();
            }
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);

                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.addDrawerListener(mToggle);


        Menu nav_menu = navi.getMenu();
        MenuItem item = nav_menu.findItem(R.id.nav_park);
        MenuItem item2 = nav_menu.findItem(R.id.nav_emergency);
        MenuItem item3 = nav_menu.findItem(R.id.nav_community);



        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(getApplicationContext(), Park.class);
                startActivity(intent);
                return true;
            }
        });
        item2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(getApplicationContext(), Emergency.class);
                startActivity(intent);
                return true;
            }
        });
        item3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(getApplicationContext(), Transportation.class);
                startActivity(intent);
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mToggle.syncState();
    }
}