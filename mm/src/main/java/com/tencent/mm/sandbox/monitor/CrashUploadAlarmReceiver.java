package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.Log;

public class CrashUploadAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
        if (a.gvV() == 0 || a.gvW() == 0) {
            b.js(context);
        }
    }
}
