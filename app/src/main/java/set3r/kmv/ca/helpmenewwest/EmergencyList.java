package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import set3r.kmv.ca.helpmenewwest.database.DatabaseHelper;
import set3r.kmv.ca.helpmenewwest.database.schema.Police;

public class EmergencyList extends AppCompatActivity {

    List<?> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_list);
        Intent extras = getIntent();
        if (extras != null) {
            list = getEmergencyList(extras.getStringExtra("selection"));
            Log.d("EXTRAS", "" + list.size());
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
                list = helper.getFireStations();
                break;
            case "hospital":
                list = helper.getHospitals();
                break;
            case "police":
                list = helper.getPolice();
                break;
            default:
                break;
        }
        return list;
    }
}

