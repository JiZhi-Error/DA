package com.tencent.xweb.xwalk.updater;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.nio.channels.FileLock;
import java.util.Iterator;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class h {
    static boolean SJv = false;
    static FileLock SJw = null;

    public static synchronized boolean hvR() {
        boolean z;
        synchronized (h.class) {
            AppMethodBeat.i(207370);
            if (SJv) {
                XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
                AppMethodBeat.o(207370);
                z = true;
            } else {
                SharedPreferences mMKVSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("XWEB_UPDATING_TAG");
                int i2 = mMKVSharedPreferences.getInt("UpdatingProcessId", -1);
                if (i2 == Process.myPid()) {
                    XWalkInitializer.addXWalkInitializeLog("error current process is in updating progress");
                    AppMethodBeat.o(207370);
                    z = true;
                } else if (i2 < 0) {
                    AppMethodBeat.o(207370);
                    z = false;
                } else {
                    ActivityManager activityManager = (ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                    if (activityManager == null || activityManager.getRunningAppProcesses() == null) {
                        AppMethodBeat.o(207370);
                        z = false;
                    } else {
                        Process.myPid();
                        int myUid = Process.myUid();
                        Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ActivityManager.RunningAppProcessInfo next = it.next();
                            if (next.pid == i2) {
                                if (next.uid == myUid) {
                                    XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
                                    AppMethodBeat.o(207370);
                                    z = true;
                                }
                            }
                        }
                        Process.myPid();
                        SharedPreferences.Editor edit = mMKVSharedPreferences.edit();
                        edit.remove("UpdatingProcessId");
                        edit.commit();
                        AppMethodBeat.o(207370);
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public static synchronized boolean hvS() {
        boolean z = true;
        synchronized (h.class) {
            AppMethodBeat.i(207371);
            if (hvR()) {
                XWalkEnvironment.addXWalkInitializeLog("is updating, start updating progress failed");
                z = false;
                AppMethodBeat.o(207371);
            } else {
                SJv = true;
                int myPid = Process.myPid();
                SharedPreferences.Editor edit = XWalkEnvironment.getMMKVSharedPreferences("XWEB_UPDATING_TAG").edit();
                edit.putInt("UpdatingProcessId", myPid);
                edit.putLong("Start_Time", System.currentTimeMillis());
                edit.commit();
                XWalkInitializer.addXWalkInitializeLog("onInUpdatingProgress suc");
                AppMethodBeat.o(207371);
            }
        }
        return z;
    }

    public static synchronized void hvT() {
        synchronized (h.class) {
            AppMethodBeat.i(207372);
            if (!SJv) {
                AppMethodBeat.o(207372);
            } else {
                SJv = false;
                Process.myPid();
                SharedPreferences.Editor edit = XWalkEnvironment.getMMKVSharedPreferences("XWEB_UPDATING_TAG").edit();
                edit.remove("UpdatingProcessId");
                edit.commit();
                XWalkInitializer.addXWalkInitializeLog("finish updating progress");
                AppMethodBeat.o(207372);
            }
        }
    }
}
