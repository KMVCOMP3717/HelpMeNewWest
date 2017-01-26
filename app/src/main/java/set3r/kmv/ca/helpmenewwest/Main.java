package set3r.kmv.ca.helpmenewwest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }
    public void onClickEvent(View view) {

        Intent intent = new Intent(getApplicationContext(), EventViewer.class);
        startActivity(intent);

    }
    public void onClickPark(View view) {

        Intent intent = new Intent(getApplicationContext(), Park.class);
        startActivity(intent);

    }

    public void onClickComm(View view) {

        Intent intent = new Intent(getApplicationContext(), Community.class);
        startActivity(intent);

    }
    public void onClickEm(View view) {

        Intent intent = new Intent(getApplicationContext(), Emergency.class);
        startActivity(intent);

    }
}