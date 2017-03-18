package kampusupgrade.kampusupgrade.Activity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        String cars[] = {"Mercedes", "Fiat", "Ferrari", "Aston Martin", "Lamborghini", "Skoda", "Volkswagen", "Audi", "Citroen"};

        ArrayList<String> carL = new ArrayList<String>();
        for (int i = 0; i <= 40; i++)
        {
            carL.add("elemencik");
        }



        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carL);
        resultList.setAdapter(adapter);


    }
}
