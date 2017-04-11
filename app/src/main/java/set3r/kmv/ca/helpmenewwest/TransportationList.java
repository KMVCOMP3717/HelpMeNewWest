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

public class TransportationList extends ListActivity {
    List<?> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent extras = getIntent();
        setContentView(R.layout.activity_transportation_list);
        if (extras != null) {
            Log.d("EXTRAS", extras.getStringExtra("selection"));
            list = getTransportationList(extras.getStringExtra("selection"));
            Log.d("EXTRAS", "" + list.size() + list.get(0));
        } else {
            Log.d("EXTRAS", "NO EXTRAS");
        }
        ListView listView = (ListView) findViewById(android.R.id.list);

        ArrayAdapter<?> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    public List<?> getTransportationList(String name) {
        DatabaseHelper helper;
        List<?> list = null;
        helper = DatabaseHelper.getInstance(this);
        switch (name) {
            case "skytrain":
                Log.d("HELPER", "Getting skytrain");
                list = helper.getSkytrains();
                break;
            case "bus":
                Log.d("HELPER", "Getting bus");
                list = helper.getBusStops();
                break;
            case "altfuels":
                Log.d("HELPER", "Getting altfuel");
                list = helper.getAlternativeFuels();
                break;
            default:
                break;
        }
        return list;
    }
}
