package wdsc.ggateway.net.ggatewaytaskscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by PROBOOK on 8/27/2017.
 */

public class MyService extends Service {

    boolean isStarted = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
              //task
              Log.d("ddd","Hello");
            }
        });
        t.start();

        if(Build.VERSION.SDK_INT>19) {
            Intent i = new Intent(getApplicationContext(), MyService.class);
            PendingIntent pi = PendingIntent.getService(getApplicationContext(), 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            manager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pi);
        }

        return Service.START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        isStarted = false;
        super.onDestroy();
    }
}
