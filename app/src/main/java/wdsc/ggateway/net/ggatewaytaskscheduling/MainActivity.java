package wdsc.ggateway.net.ggatewaytaskscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(getApplicationContext(), MyService.class);
        PendingIntent pi = PendingIntent.getService(getApplicationContext(),0,i,PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if(Build.VERSION.SDK_INT <=19){
            manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 3000, pi);
        }else {
            manager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pi);
        }

    }
}
