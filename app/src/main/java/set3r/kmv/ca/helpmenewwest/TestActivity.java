package set3r.kmv.ca.helpmenewwest;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class TestActivity extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final long INTERVAL = 1000 * 10;
    private static final long FASTEST_INTERVAL = 1000 * 5;
    TextView tvLocation;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mCurrentLocation;
    String selection;
    Boolean foundLocation = false;

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent extras = getIntent();
        selection = extras.getStringExtra("selection");

        if (!isGooglePlayServicesAvailable()) {
            finish();
        }
        createLocationRequest();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        setContentView(R.layout.activity_test);
        tvLocation = (TextView) findViewById(R.id.tvLocation);

    }

    public void getLocationUpdateClick(final View view) {
        updateUI();
    }

    public void onClickGo(final View view){
        if(mCurrentLocation != null) {
            if (selection.equals("busstop") || selection.equals("skytrain") || selection.equals("alternatefuel")) {
                Intent i = new Intent(getApplicationContext(), TransportationList.class);
                i.putExtra("location", mCurrentLocation);
                i.putExtra("selection", selection);
                startActivity(i);
            } else if (selection.equals("fire") || selection.equals("hospital") || selection.equals("police")) {
                Intent i = new Intent(getApplicationContext(), EmergencyList.class);
                i.putExtra("location", mCurrentLocation);
                i.putExtra("selection", selection);
                startActivity(i);
            } else if (selection.equals("park")) {
                Intent i = new Intent(getApplicationContext(), Park.class);
                i.putExtra("location", mCurrentLocation);
                i.putExtra("selection", selection);
                startActivity(i);
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "Please get your location before first!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.e("conn", "inside on connected");
        startLocationUpdates();
    }

    protected void startLocationUpdates() {
        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(getApplicationContext(), "Location Failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        Log.e("Location", "is changing");
        updateUI();
    }

    private void updateUI() {
        if (null != mCurrentLocation) {
            String lat = String.valueOf(mCurrentLocation.getLatitude()), lng = String.valueOf(mCurrentLocation.getLongitude());
            tvLocation.setText(
                    "Latitude: " + lat + "\n" +
                            "Longitude: " + lng + "\n" +
                            "Accuracy: " + mCurrentLocation.getAccuracy() + "\n" +
                            "Provider: " + mCurrentLocation.getProvider());
        } else {
            Log.e("there", "is no current location");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mGoogleApiClient.isConnected()) {
            startLocationUpdates();
        } else {
            mGoogleApiClient.connect();
        }
    }
}
