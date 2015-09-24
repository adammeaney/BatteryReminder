package com.ameaney.batteryreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

import java.util.Set;

public class BatteryChangedReceiver extends BroadcastReceiver
{
    public BatteryChangedReceiver()
    {
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, filter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
        int percent = (level * 100) / scale;

        if (percent <= 10)
        {
            // Send the notification.
        }
    }
}

/* Fire receiver: am broadcast -a android.intent.action.ACTION_BATTERY_LOW
 * Change emulator battery status: telnet localhost 5554 -> power capacity percent
 */

