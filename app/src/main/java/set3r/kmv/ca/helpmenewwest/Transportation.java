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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Transportation extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mtoolbar;
    private NavigationView navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);

        navi = (NavigationView) findViewById(R.id.nav_view);
        sideMenu();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void sideMenu(){
        mtoolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mtoolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_transportation);
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
                Intent intent = new Intent(getApplicationContext(), ParkList.class);
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

    public void onClickSkytrain(View v) {
        Intent i = new Intent(getApplicationContext(), TestActivity.class);
        i.putExtra("selection", "skytrain");
        startActivity(i);
    }

    public void onClickBus(View v) {
        Intent i = new Intent(getApplicationContext(), TestActivity.class);
        i.putExtra("selection", "busstop");
        startActivity(i);
    }

    public void onClickAltFuel(View v) {
        Intent i = new Intent(getApplicationContext(), TestActivity.class);
        i.putExtra("selection", "alternativefuel");
        startActivity(i);
    }
}
