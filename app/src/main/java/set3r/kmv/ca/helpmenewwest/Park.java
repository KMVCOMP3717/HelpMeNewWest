package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Park extends AppCompatActivity {
    Button park1;
    Button park2;
    Button park3;
    Button park4;
    Button parkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        park1 = (Button)findViewById(R.id.park1);
        park2 = (Button)findViewById(R.id.park2);
        park3 = (Button)findViewById(R.id.park3);
        park4 = (Button)findViewById(R.id.park4);
        parkList = (Button)findViewById(R.id.parklistbtn);
    }

    public void toParkListOnClick(View v) {
        startActivity(new Intent(this, ParkList.class));
    }

    public void toParkTemplateOnClick(View v) {
        startActivity(new Intent(this, ParkTemplate.class));
    }
}
