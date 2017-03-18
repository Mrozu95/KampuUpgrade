package kampusupgrade.kampusupgrade.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import kampusupgrade.kampusupgrade.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

