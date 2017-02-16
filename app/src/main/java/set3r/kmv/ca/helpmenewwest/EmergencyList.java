package set3r.kmv.ca.helpmenewwest;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import set3r.kmv.ca.helpmenewwest.database.DatabaseHelper;
import set3r.kmv.ca.helpmenewwest.database.schema.*;

public class EmergencyList extends ListActivity {

    List<?> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent extras = getIntent();
        Log.d("ONCREATE", extras.getStringExtra("selection"));
        setContentView(R.layout.activity_emergency_list);
        if (extras != null) {
            Log.d("EXTRAS", extras.getStringExtra("selection"));
            list = getEmergencyList(extras.getStringExtra("selection"));
            Log.d("EXTRAS", "" + list.size() + list.get(0));
        } else {
            Log.d("EXTRAS", "NO EXTRAS");
        }
        ListView listView = (ListView) findViewById(android.R.id.list);

        ArrayAdapter<?> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    public List<?> getEmergencyList(String name) {
        DatabaseHelper helper;
        List<?> list = null;
        helper = DatabaseHelper.getInstance(this);
        switch (name) {
            case "fire":
                Log.d("HELPER", "Getting Fire Stations");
                list = helper.getFireStations();
                break;
            case "hospital":
                Log.d("HELPER", "Getting Hospitals");
                list = helper.getHospitals();
                break;
            case "police":
                Log.d("HELPER", "Getting Police");
                list = helper.getPolice();
                break;
            default:
                break;
        }
        return list;
    }
}

