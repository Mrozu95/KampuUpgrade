package kampusupgrade.kampusupgrade.Activity;

import android.app.Activity;
import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import kampusupgrade.kampusupgrade.R;
public class ResaultsActivity extends AppCompatActivity {

    private ListView resultList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resaults);

        resultList = (ListView)findViewById(R.id.ResultList);

        ArrayList<String> carL = new ArrayList<String>();
        for (int i = 0; i <= 40; i++)
        {
            carL.add("elemencik");
        }



        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carL);
        resultList.setAdapter(adapter);

        //list listener
        resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent navInt = new Intent(ResaultsActivity.this, NavigationActivity.class);
                startActivity(navInt);

            }
        });
    }
}
