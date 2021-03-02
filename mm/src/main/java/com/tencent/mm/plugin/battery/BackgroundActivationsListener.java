package com.tencent.mm.plugin.battery;

import android.app.ActivityManager;
import android.app.Notification;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.tencent.matrix.report.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.List;

public final class BackgroundActivationsListener extends NotificationListenerService {
    public final void onCreate() {
        boolean z;
        AppMethodBeat.i(200993);
        super.onCreate();
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onCreate");
        ComponentName componentName = new ComponentName(this, BackgroundActivationsListener.class);
        if (Build.VERSION.SDK_INT >= 24) {
            Log.i("MicroMsg.battery.BackgroundActivationsListener", "requestRebind");
            requestRebind(componentName);
            AppMethodBeat.o(200993);
            return;
        }
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "requestRebind Legacy");
        ActivityManager activityManager = (ActivityManager) getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager == null) {
            Log.w("MicroMsg.battery.BackgroundActivationsListener", "am is null");
            AppMethodBeat.o(200993);
            return;
        }
        List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (runningServices == null || runningServices.isEmpty()) {
            Log.w("MicroMsg.battery.BackgroundActivationsListener", "runningServices is empty");
            AppMethodBeat.o(200993);
            return;
        }
        Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ActivityManager.RunningServiceInfo next = it.next();
            if (next.service.equals(componentName) && next.pid == Process.myPid()) {
                z = true;
                break;
            }
        }
        if (z) {
            Log.i("MicroMsg.battery.BackgroundActivationsListener", "service is running, skip");
            AppMethodBeat.o(200993);
            return;
        }
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "try manually rebind service");
        ComponentName componentName2 = new ComponentName(this, BackgroundActivationsListener.class);
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(componentName2, 2, 1);
        packageManager.setComponentEnabledSetting(componentName2, 1, 1);
        AppMethodBeat.o(200993);
    }

    public final void onDestroy() {
        AppMethodBeat.i(200994);
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onDestroy");
        super.onDestroy();
        AppMethodBeat.o(200994);
    }

    public final void onNotificationPosted(StatusBarNotification statusBarNotification) {
        String str;
        AppMethodBeat.i(200995);
        super.onNotificationPosted(statusBarNotification);
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onNotificationPosted");
        Notification notification = statusBarNotification.getNotification();
        if (Build.VERSION.SDK_INT >= 26) {
            str = notification.getChannelId();
        } else {
            str = null;
        }
        if ("FOREGROUND_SERVICE".equals(str)) {
            Log.d("MicroMsg.battery.BackgroundActivationsListener", "sbn = " + statusBarNotification.toString());
            String[] stringArray = notification.extras.getStringArray("android.foregroundApps");
            String packageName = getApplication().getPackageName();
            if (stringArray != null) {
                for (String str2 : stringArray) {
                    if (packageName.equals(str2)) {
                        Log.w("MicroMsg.battery.BackgroundActivationsListener", "AMS on updateForegroundApps, notification = " + notification.toString());
                        a.C0226a.cB(false);
                    } else {
                        Log.w("MicroMsg.battery.BackgroundActivationsListener", "AMS on updateForegroundApps for others, pkg = ".concat(String.valueOf(str2)));
                        a.C0226a.cB(true);
                    }
                }
            }
        }
        AppMethodBeat.o(200995);
    }

    public final void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        AppMethodBeat.i(200996);
        super.onNotificationRemoved(statusBarNotification);
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onNotificationRemoved");
        AppMethodBeat.o(200996);
    }

    public final void onListenerConnected() {
        AppMethodBeat.i(200997);
        super.onListenerConnected();
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onListenerConnected");
        AppMethodBeat.o(200997);
    }

    public final void onListenerDisconnected() {
        AppMethodBeat.i(200998);
        super.onListenerDisconnected();
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onListenerDisconnected");
        AppMethodBeat.o(200998);
    }
}
