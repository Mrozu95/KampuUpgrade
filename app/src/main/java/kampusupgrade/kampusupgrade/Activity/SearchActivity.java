package kampusupgrade.kampusupgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void searchClick(View view) {
        switch (view.getId())
        {
            case R.id.searchBtn:
                Intent intent = new Intent(SearchActivity.this, ResaultsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
