package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void goClick(View view) {
        Intent i = new Intent(getApplicationContext(), EventViewer.class);
        startActivity(i);
        setContentView(R.layout.activity_event_viewer);
    }
}
