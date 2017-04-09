package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Emergency extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        sideMenu();
    }
    public void onClickPolice(View v) {
        Intent i = new Intent(getApplicationContext(), EmergencyList.class);
        i.putExtra("selection", "police");
        startActivity(i);
    }

    public void onClickFire(View v) {
        Intent i = new Intent(getApplicationContext(), EmergencyList.class);
        i.putExtra("selection", "fire");
        startActivity(i);
    }

    public void onClickHospital(View v) {
        Intent i = new Intent(getApplicationContext(), EmergencyList.class);
        i.putExtra("selection", "hospital");
        startActivity(i);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sideMenu(){
        mtoolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mtoolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_emergency);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
