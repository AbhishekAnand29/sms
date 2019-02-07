package com.example.abhishek.sms2;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ednum,edmsg;
    Button btsend;
    BroadcastReceiver brsent;
    IntentFilter int_sent;
    String sms_sent="Message sent";
    Intent intsent;
    PendingIntent pisent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ednum = (EditText) findViewById(R.id.editText);
        edmsg = (EditText) findViewById(R.id.editText2);
        Button btsend = (Button) findViewById(R.id.button);

        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String no = ednum.getText().toString();
                String msg = edmsg.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(no, null, msg, pi, null);

                Toast.makeText(getApplicationContext(), "Message sent successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}
