package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Park extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mtoolbar;
    Button park1;
    Button park2;
    Button park3;
    Button park4;
    Button parkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        park1 = (Button)findViewById(R.id.park1);
        park2 = (Button)findViewById(R.id.park2);
        park3 = (Button)findViewById(R.id.park3);
        park4 = (Button)findViewById(R.id.park4);
        parkList = (Button)findViewById(R.id.parklistbtn);

        sideMenu();
    }

    public void toParkListOnClick(View v) {
        startActivity(new Intent(this, ParkList.class));
    }

    public void toParkTemplateOnClick(View v) {
        startActivity(new Intent(this, DetailsView.class));
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
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_park);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
