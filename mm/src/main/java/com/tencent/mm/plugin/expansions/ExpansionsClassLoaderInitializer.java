package com.tencent.mm.plugin.expansions;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;

@Keep
public final class ExpansionsClassLoaderInitializer {
    private static final String TAG = "MicroMsg.ExpansionsClassLoaderInitializer";

    @Keep
    public final void initializeClassLoader(Application application, ClassLoader classLoader) {
        String str;
        AppMethodBeat.i(152965);
        c.gj(TAG, "[+] Enter initializeClassLoader.");
        if (application != null) {
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) application.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid && next.processName != null && !next.processName.equals("")) {
                    str = next.processName;
                    break;
                }
            }
        }
        str = null;
        if (str.endsWith(":push")) {
            c.gj(TAG, "[!] push process needn't initialize Expansions.");
        } else if (str.endsWith(":isolated_process0")) {
            c.gj(TAG, "[!] tbs isolated process cannot initialize Expansions.");
        } else {
            a.cMn();
            a.cMm();
        }
        c.gj(TAG, "[+] Exit initializeClassLoader.");
        AppMethodBeat.o(152965);
    }
}
