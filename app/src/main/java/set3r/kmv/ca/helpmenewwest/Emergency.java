package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
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
}
