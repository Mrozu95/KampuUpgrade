package kampusupgrade.kampusupgrade.Activity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import kampusupgrade.kampusupgrade.R;

public class NavigationActivity extends AppCompatActivity {

    private BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        runBluetooth();
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
