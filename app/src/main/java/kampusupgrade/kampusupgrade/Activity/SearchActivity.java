package kampusupgrade.kampusupgrade.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.security.PrivateKey;

import kampusupgrade.kampusupgrade.R;

public class SearchActivity extends AppCompatActivity {

    private TextView univerityTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        univerityTxt = (TextView)findViewById(R.id.univeristyTxt);
    }

    public void searchClick(View view) {
        String searchPhrase = univerityTxt.getText().toString();
        Intent intent = new Intent(SearchActivity.this, ResaultsActivity.class);
        intent.putExtra("BUILDING", searchPhrase);
        startActivity(intent);

    }
}
