package kampusupgrade.kampusupgrade.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;
import kampusupgrade.kampusupgrade.Data.Screen;
import kampusupgrade.kampusupgrade.R;
import kampusupgrade.kampusupgrade.RestClient.RESTController;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Thread thread = new Thread() {
            @Override
            public void run() {
                RESTController restController = new RESTController();
                ArrayList<Room> room = restController.getRoom();
                room.get(1);



               //Log.d("REST WORKS:    ","" + screen.get(0).getId() + " " +screen.get(0).building.getStreet() + " " + screen.get(0).neighbours.get(0).getId()+  " " + screen.get(0).neighbours.get(0).getDistance()) ;

            }

        };
        thread.start();
    }

    public void signIn(View view) {

        switch (view.getId())
        {
            case R.id.signInBtn:
                Intent intent = new Intent(LoginActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }



}

