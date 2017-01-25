package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class EventViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_viewer);
        setTitle("Events");
    }

    public void event1Click(View v) {
        Intent i = new Intent(getApplicationContext(), Event1.class);
        startActivity(i);
        setContentView(R.layout.activity_event1);
    }

    public void favouriteClick1(View v) {
        Switch s;
        s = (Switch) findViewById(R.id.eventSwitch1);
        if(s.isChecked()) {
            s.setText("Added to Favourites ");
            Toast.makeText(getApplicationContext(), "Favourited!", Toast.LENGTH_LONG).show();
        } else {
            s.setText("Add to Favourites ");
            Toast.makeText(getApplicationContext(), "Removed!", Toast.LENGTH_LONG).show();
        }
    }

    public void favouriteClick2(View v) {
        Switch s;
        s = (Switch) findViewById(R.id.eventSwitch2);
        if(s.isChecked()) {
            s.setText("Added to Favourites ");
            Toast.makeText(getApplicationContext(), "Favourited!", Toast.LENGTH_LONG).show();
        } else {
            s.setText("Add to Favourites ");
            Toast.makeText(getApplicationContext(), "Removed!", Toast.LENGTH_LONG).show();
        }
    }
}
