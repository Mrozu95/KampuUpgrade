package kampusupgrade.kampusupgrade.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import kampusupgrade.kampusupgrade.R;
import kampusupgrade.kampusupgrade.RestClient.RESTBuilding;
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
                ArrayList<RESTBuilding> building = restController.getBuilding();
                restController.getBuilding();
               Log.d("REST WORKS", building.get(0).getStreet() + "-" + building.get(1).getStreet());

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

