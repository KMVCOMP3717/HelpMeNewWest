package set3r.kmv.ca.helpmenewwest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import set3r.kmv.ca.helpmenewwest.database.DatabaseHelper;
import set3r.kmv.ca.helpmenewwest.database.schema.*;

import static android.R.id.list;

public class EmergencyList extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {
    //sidebar
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mtoolbar;
    private NavigationView navi;
    //list
    String type;
    //location services
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent extras = getIntent();
        setContentView(R.layout.activity_emergency_list);
        if (extras != null) {
            ListView listView = (ListView) findViewById(list);
            List list;
            ArrayAdapter adapter;
            DatabaseHelper helper;
            helper = DatabaseHelper.getInstance(this);
            type = extras.getStringExtra("selection");
            switch(type) {
                case "fire":
                    list = helper.getFires();
                    Collections.sort(list, new Comparator<Fire>() {
                        @Override
                        public int compare(Fire o1, Fire o2) {
                            Location loc1 = new Location("");
                            loc1.setLatitude(o1.getLat());
                            loc1.setLongitude(o1.getLng());
                            Location loc2 = new Location("");
                            loc2.setLatitude(o2.getLat());
                            loc2.setLongitude(o2.getLng());
                            return mLastLocation.distanceTo(loc1) - mLastLocation.distanceTo(loc2) < 0 ? -1 : 1;
                        }
                    });
                    break;
                case "hospital":
                    list = helper.getHospitals();
                    Collections.sort(list, new Comparator<Hospital>() {
                        @Override
                        public int compare(Hospital o1, Hospital o2) {
                            Location loc1 = new Location("");
                            loc1.setLatitude(o1.getLat());
                            loc1.setLongitude(o1.getLng());
                            Location loc2 = new Location("");
                            loc2.setLatitude(o2.getLat());
                            loc2.setLongitude(o2.getLng());
                            return mLastLocation.distanceTo(loc1) - mLastLocation.distanceTo(loc2) < 0 ? -1 : 1;
                        }
                    });
                    break;
                default:
                    list = helper.getPolices();
                    Collections.sort(list, new Comparator<Police>() {
                        @Override
                        public int compare(Police o1, Police o2) {
                            Location loc1 = new Location("");
                            loc1.setLatitude(o1.getLat());
                            loc1.setLongitude(o1.getLng());
                            Location loc2 = new Location("");
                            loc2.setLatitude(o2.getLat());
                            loc2.setLongitude(o2.getLng());
                            return mLastLocation.distanceTo(loc1) - mLastLocation.distanceTo(loc2) < 0 ? -1 : 1;
                        }
                    });
                    break;
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
            //adapter.notifyDataSetChanged();
        } else {
            Log.d("EXTRAS", "NO EXTRAS");
        }
        navi = (NavigationView) findViewById(R.id.nav_view);
        sideMenu();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onListItemClick(ListView l, View v, int position, long id){
        Intent intent;
        intent = new Intent(getApplicationContext(), DetailsView.class);
        intent.putExtra("table", type);
        intent.putExtra("id", id);
        startActivity(intent);
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

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }
    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    private void requestPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_LOCATION);
    }

    private void promptSettings() {
        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(this);
        builder.setTitle("Can't Find Location");
        builder.setMessage("Location Permission Denied");
        builder.setCancelable(false);
        builder.show();
    }

    public boolean checkPermission(Context context) {
        int result = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission was granted.
                    if (ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            //You can add here other case statements according to your requirement.
        }

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

