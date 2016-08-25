package com.example.imeitest;

import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	public Button bt_get_imei;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_get_imei = (Button) findViewById(R.id.bt_get_imei);
        bt_get_imei.setOnClickListener(this);
    }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_get_imei:
			TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
			String IMEI= tm.getDeviceId();
			Toast.makeText(MainActivity.this, "imei:"+IMEI, Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
    
}
