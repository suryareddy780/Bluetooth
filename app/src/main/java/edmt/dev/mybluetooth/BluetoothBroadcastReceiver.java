package edmt.dev.mybluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BluetoothBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d("BroadcastActions", "Action "+action+"received");
        int state;
        BluetoothDevice bluetoothDevice;

        switch (action)
        {

            case BluetoothDevice.ACTION_ACL_CONNECTED:
                bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Toast.makeText(context, "Connected to "+bluetoothDevice.getName(),
                        Toast.LENGTH_SHORT).show();
                Log.d("BroadcastActions", "Connected to "+bluetoothDevice.getName());
                break;

            case BluetoothDevice.ACTION_ACL_DISCONNECTED:
                bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Toast.makeText(context, "Disconnected from "+bluetoothDevice.getName(),
                        Toast.LENGTH_SHORT).show();
                Log.d("BroadcastActions","Disconnected from "+bluetoothDevice.getName());
                break;
        }
    }
}