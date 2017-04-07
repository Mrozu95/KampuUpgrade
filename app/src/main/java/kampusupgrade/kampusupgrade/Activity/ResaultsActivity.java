package kampusupgrade.kampusupgrade.Activity;

import android.app.Activity;
import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;
import kampusupgrade.kampusupgrade.R;
import kampusupgrade.kampusupgrade.RestClient.RESTController;

public class ResaultsActivity extends AppCompatActivity {

    private ListView resultList;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> results;
    private ArrayList<Building> buildingsList;
    private ArrayList<Room> roomList;
    private String searchPhrase;
    private RESTController base;
    private int buildingID;

    //on which state is list. 0 = buildings 1 = rooms
    private int listStage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resaults);

        Intent intent = getIntent();
        if(intent != null)
        {
            searchPhrase = intent.getStringExtra("BUILDING");
            searchPhrase.toLowerCase();
        }


        listStage = 0;
        results = new ArrayList<>();
        resultList = (ListView) findViewById(R.id.ResultList);
        setUpListener();

        run();
    }

    private void run()
    {
/*        final Thread thread = new Thread() {
            @Override
            public void run() {
                base = new RESTController();
                buildingsList = base.getBuilding();
                for (Building building: buildingsList)
                {
                    if(building.getName().toLowerCase().contains(searchPhrase))
                    {
                        results.add(building.getName());
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, results);
                        resultList.setAdapter(adapter);
                    }
                });


            }};
        thread.start();*/
        new AsyncTask<Void, Void, ArrayList<Building>>(){

            @Override
            protected ArrayList<Building> doInBackground(Void... params)
            {
                base = new RESTController();
                return base.getBuilding();
            }

            @Override
            protected void onPostExecute(ArrayList<Building> buildings)
            {
                //TODO extend searching by streets names
                for (Building building: buildings)
                {
                    if(building.getName().toLowerCase().contains(searchPhrase))
                    {
                        results.add(building.getName());
                    }
                }
                if(!results.isEmpty())
                {
                    adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, results);
                    resultList.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Cant resolve name", Toast.LENGTH_SHORT).show();
                }

            }
        }.execute();
    }


    private void setUpListener()
    {
        //list listener
        resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if(listStage == 0)
                {
                    //get clicked Item
                    String buildingName = (String)((TextView)view).getText();

                    new AsyncTask<String, Void, ArrayList<Room>>()
                    {
                        @Override
                        protected ArrayList<Room> doInBackground(String... params)
                        {
                            base = new RESTController();
                            buildingID = base.getBuildingByName(params[0]).get(0).getId();
                            results.clear();
                            return base.getRoomByBuilding(buildingID);
                        }

                        @Override
                        protected void onPostExecute(ArrayList<Room> list)
                        {
                            roomList = list;
                            for (Room room: list)
                            {
                                if(room.getName().compareTo("null") == 0)
                                {
                                    results.add(room.getWing() + " " + Integer.toString(room.getNumber()));
                                }
                                else
                                results.add(room.getWing() + " " +  Integer.toString(room.getNumber()) + " (" + room.getName() + ")" );
                            }
                            listStage = 1;
                            adapter.notifyDataSetChanged();
                        }
                    }.execute(buildingName);
                }
                else if(listStage == 1)
                {
                    String roomName = ((TextView)view).getText().toString();
                    int roomID = 0;
                    String[] parts = roomName.split(" ");
                    String wing = parts[0];
                    int roomNumber = Integer.parseInt(parts[1]);

                    for (Room room: roomList)
                    {
                        if(room.getWing().compareTo(wing) == 0)
                        {
                            if(room.getNumber() == roomNumber)
                            {
                                roomID = room.getId();
                                break;
                            }
                        }
                    }
                    listStage = 0;
                    Intent navInt = new Intent(ResaultsActivity.this, NavigationActivity.class);
                    navInt.putExtra("ROOM_ID", roomID);
                    navInt.putExtra("BUILDING_ID", buildingID);
                    startActivity(navInt);
                }
            }
        });
    }

}
