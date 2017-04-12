package set3r.kmv.ca.helpmenewwest;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;o
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import set3r.kmv.ca.helpmenewwest.database.DatabaseHelper;
import set3r.kmv.ca.helpmenewwest.database.schema.AlternativeFuel;
import set3r.kmv.ca.helpmenewwest.database.schema.BusStop;
import set3r.kmv.ca.helpmenewwest.database.schema.Fire;
import set3r.kmv.ca.helpmenewwest.database.schema.Hospital;
import set3r.kmv.ca.helpmenewwest.database.schema.Police;
import set3r.kmv.ca.helpmenewwest.database.schema.Skytrain;
import set3r.kmv.ca.helpmenewwest.database.schema.Park;

public class DetailsView extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    private Marker mCurrLocationMarker;
    private DatabaseHelper helper;
    private TextView view1;
    private TextView view1content;
    private TextView view2;
    private TextView view2content;
    private TextView view3;
    private TextView view3content;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i;
        String table;
        Long id;
        helper = DatabaseHelper.getInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        view1 = (TextView) findViewById(R.id.view1);
        view1content = (TextView) findViewById(R.id.view1content);
        view2 = (TextView) findViewById(R.id.view2);
        view2content = (TextView) findViewById(R.id.view2content);
        view3 = (TextView) findViewById(R.id.view3);
        view3content = (TextView) findViewById(R.id.view3content);

        i = getIntent();
        table = i.getStringExtra("table");
        id = i.getLongExtra("id", 0L);
        Log.e("EXTRA", "" + id);
        processExtras(table,id);

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Initialize Google Play Services
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION },
                    MY_PERMISSIONS_REQUEST_LOCATION);
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
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
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    private void requestPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_LOCATION);
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
        int result = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
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
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
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

    public void processExtras(String table, Long id) {
        switch(table.toLowerCase()) {
            case "busstop":
                updateBus(helper.getBusStop(id));
                break;
            case "skytrain":
                updateSky(helper.getSkytrain(id));
                break;
            case "police":
                updatePolice(helper.getPolice(id));
                break;
            case "hospital":
                updateHospital(helper.getHospital(id));
                break;
            case "fire":
                updateFire(helper.getFire(id));
                break;
            case "alternativefuel":
                updateAltFuel(helper.getAlternativeFuel(id));
                break;
            case "park":
                updatePark(helper.getPark(id));
                break;
        }
    }

    public void updateBus(BusStop b) {
        view1.setText("On-street");
        view1content.setText(b.getAddress());

        LatLng temp = new LatLng(b.getLat(), b.getLng());
        mMap.addMarker(new MarkerOptions().position(temp).title(b.getAddress()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(temp));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }

    public void updateSky(Skytrain s) {
        view1.setText("Name");
        view1content.setText(s.getName());
        view2.setText("Address");
        view2content.setText(s.getAddress());


        LatLng temp = new LatLng(s.getLat(), s.getLng());
        mMap.addMarker(new MarkerOptions().position(temp).title(s.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(temp));

        /*LatLng temp = new LatLng(s.getLat(), s.getLng());
        mMap.addMarker(new MarkerOptions().position(temp).title(s.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(temp));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));*/

    }

    public void updatePolice(Police p) {
        view1.setText("Name");
        view1content.setText(p.getName());
        view2.setText("Address");
        view2content.setText(p.getAddress());

        LatLng temp = new LatLng(p.getLat(), p.getLng());
        mMap.addMarker(new MarkerOptions().position(temp).title(p.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(temp));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }

    public void updateHospital(Hospital h) {
        view1.setText("Name");
        view1content.setText(h.getName());
        view2.setText("Address");
        view2content.setText(h.getAddress());

        LatLng temp = new LatLng(h.getLat(), h.getLng());
        mMap.addMarker(new MarkerOptions().position(temp).title(h.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(temp));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }

    public void updateFire(Fire f) {
        view1.setText("Name");
        view1content.setText(f.getName());
        view2.setText("Address");
        view2content.setText(f.getAddress());

        LatLng temp = new LatLng(f.getLat(), f.getLng());
        mMap.addMarker(new MarkerOptions().position(temp).title(f.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(temp));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }

    public void updateAltFuel(AlternativeFuel af) {
        view1.setText("On-street");
        view1content.setText(af.getAddress());

        LatLng temp = new LatLng(af.getLat(), af.getLng());
        mMap.addMarker(new MarkerOptions().position(temp).title(af.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(temp));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }

    public void updatePark(Park p) {
        view1.setText("Name");
        view1content.setText(p.getName());
        view2.setText("Address");
        view2content.setText(p.getAddress());
        view3.setText("Description");
        view3content.setText(p.getDescription());

        LatLng temp = new LatLng(p.getLat(), p.getLng());
        mMap.addMarker(new MarkerOptions().position(temp).title(p.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(temp));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }
}
