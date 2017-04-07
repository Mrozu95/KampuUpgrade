package kampusupgrade.kampusupgrade.Activity;

import android.app.Activity;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jgrapht.graph.DefaultWeightedEdge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import kampusupgrade.kampusupgrade.Algorithm.PathAlgorithm;
import kampusupgrade.kampusupgrade.Data.Room;
import kampusupgrade.kampusupgrade.Data.Screen;
import kampusupgrade.kampusupgrade.R;
import kampusupgrade.kampusupgrade.RestClient.RESTController;

public class NavigationActivity extends AppCompatActivity {

    private ListView listViewScreens;
    private ArrayAdapter<Integer> adapter;

    private BluetoothAdapter bluetoothAdapter;
    private RESTController base;
    private PathAlgorithm pathAlgorithm;
    //List of all screens in the building
    ArrayList<Screen> screenList;
    private Screen startScreen;
    private Screen endScreen;
    private int roomID;
    private int buildingID;
    private Room destinationRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Intent intent = getIntent();
        if (intent != null) {
            roomID = intent.getIntExtra("ROOM_ID", 0);
            buildingID = intent.getIntExtra("BUILDING_ID", 0);
        }

        listViewScreens = (ListView) findViewById(R.id.screenList);

        run();
    }


    private void run()
    {
        //for test starting screen is first screen on the left side of the map
        //collecting data
        new AsyncTask<Integer, Void, ArrayList<Screen>>()
        {
            @Override
            protected ArrayList<Screen> doInBackground(Integer... params) {
                base = new RESTController();
                startScreen = base.getScreenByID(1).get(0);
                destinationRoom = base.getRoomByID(params[1]).get(0);
                return base.getScreenByBuilding(params[0]);
            }

            @Override
            protected void onPostExecute(ArrayList<Screen> listOfScreens)
            {
                screenList = listOfScreens;
                FindNearestScreen();
                runNavigation();
                ArrayList<Integer> screens = pathAlgorithm.getPath();
                adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, screens);
                listViewScreens.setAdapter(adapter);
            }
        }.execute(buildingID, roomID);



        //runBluetooth();
/*        final Thread thread = new Thread() {
            @Override
            public void run() {
                RESTController base = new RESTController();
                lista = base.getScreen();
                final String temp = Integer.toString(lista.get(0).getId());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        testbox = (TextView)findViewById(R.id.testText);
                        testbox.setText("" + Integer.toString(lista.get(0).getId()));
                    }
                });


            }};
        thread.start();*/
    }



    //finds screen to which make a path
    private void FindNearestScreen()
    {
        endScreen = screenList.get(0);
        float diff = 10000000;
        for(Screen screen: screenList)
        {
            float newDiff = CalculateDistanceBetweenScreenAndRoom(destinationRoom, screen);
            if(newDiff < diff)
            {
                endScreen = screen;
                diff = newDiff;
            }
        }
    }

    private float CalculateDistanceBetweenScreenAndRoom(Room room, Screen screen)
    {
        float xDiff = room.getCoordinate().getX() - screen.getCoordinate().getX();
        float yDiff = room.getCoordinate().getY() - screen.getCoordinate().getY();

        float xPow, yPow;
        xPow = xDiff * xDiff;
        yPow = yDiff * yDiff;

        double sum = (xPow + yPow);
        double dist = Math.sqrt(sum);

        return (float)dist;
    }

    private void runNavigation()
    {
        pathAlgorithm = new PathAlgorithm(startScreen, endScreen, screenList);
    }


    private void runBluetooth() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //device doesn't support bluetooth
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext() ,"You need bluetooth", Toast.LENGTH_LONG).show();
        }
        //device support bluetooth
        else {
            //enable bluetooth
            if (!bluetoothAdapter.isEnabled()) {
                int REQUEST_ENABLE_BT = 1;
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
            else
            {

            }
        }
    }


    private void scanDevices()
    {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CANCELED)
        {
            Toast.makeText(getApplicationContext(), "Bluetooth must be turned on", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
