package kampusupgrade.kampusupgrade.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;
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
                restController.getRoom();
               Log.d("REST WORKS:    ","" + room.get(0).getNumber() + room.get(0).getWing() + room.get(0).building.getStreet() + room.get(0).coordinate.getX() + + room.get(0).coordinate.getY() ) ;

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

