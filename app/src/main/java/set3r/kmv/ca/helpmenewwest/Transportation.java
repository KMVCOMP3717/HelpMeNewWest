package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class Transportation extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mtoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);

        sideMenu();



    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id =item.getItemId();


        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        if(id ==R.id.nav_community){
            Intent intent1 = new Intent(this, Transportation.class);
            this.startActivity(intent1);
            return true;
        }

        if(id == R.id.nav_emergency){
            Intent intent2 = new Intent(this, Emergency.class);
            this.startActivity(intent2);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sideMenu(){
        mtoolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mtoolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_transportation);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.side_menu, menu);
        return true;
    }
    public boolean onOptionItemSelected(MenuItem item){
        int id =item.getItemId();

        if(id ==R.id.nav_community){
            Intent intent1 = new Intent(this, Transportation.class);
            this.startActivity(intent1);
            return true;
        }

        if(id == R.id.nav_emergency){
            Intent intent2 = new Intent(this, Emergency.class);
            this.startActivity(intent2);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void addDrawerItems(){
        String[] categories = {"Park", "Emergency", "Transportation"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);


    }
}
