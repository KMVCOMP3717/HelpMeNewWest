package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static set3r.kmv.ca.helpmenewwest.R.id.plist1;

public class ParkList extends AppCompatActivity {
    Button listItem1;
    Button listItem2;
    Button listItem3;
    Button listItem4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);

        listItem1 = (Button)findViewById(R.id.plist1);
        listItem2 = (Button)findViewById(R.id.plist2);
        listItem3 = (Button)findViewById(R.id.plist3);
        listItem4 = (Button)findViewById(R.id.plist4);
    }

    public void toListItemOnClick(View v) {
        startActivity(new Intent(this, ParkTemplate.class));
    }
}
