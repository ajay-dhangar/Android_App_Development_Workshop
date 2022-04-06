package com.example.broghtcastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    // Step 2

     Switch wifiSwitch;
     WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       wifiSwitch = findViewById(R.id.mySwitch);
       wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    wifiManager.setWifiEnabled(true);
                    wifiSwitch.setText("Wi-Fi is ON");

                }
                else {
                    wifiManager.setWifiEnabled(false);
                    wifiSwitch.setText("Wi-Fi is OFF");
                }
            }
        });
    }

    private BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra =intent.getIntExtra(wifiManager.EXTRA_WIFI_STATE, wifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiStateExtra){
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiSwitch.setText("WI-FI is ON");
                    wifiSwitch.setChecked(true);
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiSwitch.setText("WI-Fi is OFF");
                    wifiSwitch.setChecked(false);
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiReceiver);
    }
}