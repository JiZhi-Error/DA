package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.xweb.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class k implements w.a {
    private String SHX = "";
    private j SHY = null;
    private l SHZ = null;

    @Override // com.tencent.xweb.w.b
    public final void b(Context context, HashMap<String, String> hashMap) {
        AppMethodBeat.i(154508);
        synchronized (this) {
            try {
                this.SHZ = new l();
                this.SHZ.a(hashMap, this.SHX, this.SHY);
                this.SHZ.execute(new String[0]);
                this.SHX = "";
                this.SHY = null;
            } finally {
                AppMethodBeat.o(154508);
            }
        }
    }

    @Override // com.tencent.xweb.w.b
    public final boolean isBusy() {
        if (this.SHZ == null || this.SHZ.SIi) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.xweb.w.a
    public final void a(String str, j jVar) {
        this.SHX = str;
        this.SHY = jVar;
    }

    @Override // com.tencent.xweb.w.a
    public final void hsE() {
        AppMethodBeat.i(207341);
        if (this.SHZ != null) {
            this.SHZ.b(4, -1, null);
        }
        AppMethodBeat.o(207341);
    }

    public static void OY(long j2) {
        AppMethodBeat.i(154509);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "set time sp is null");
            AppMethodBeat.o(154509);
            return;
        }
        SharedPreferences.Editor edit = sharedPreferencesForPluginUpdateInfo.edit();
        edit.putLong(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME, j2);
        edit.commit();
        AppMethodBeat.o(154509);
    }

    public static boolean hvr() {
        List<ActivityManager.RunningAppProcessInfo> list;
        AppMethodBeat.i(154510);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            AppMethodBeat.o(154510);
            return false;
        }
        int i2 = sharedPreferencesForPluginUpdateInfo.getInt(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_PROCESS_ID, -1);
        if (i2 < 0) {
            AppMethodBeat.o(154510);
            return false;
        }
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        if (i2 == myPid) {
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "current process is updating plugin");
            AppMethodBeat.o(154510);
            return true;
        }
        try {
            list = ((ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
        } catch (Exception e2) {
            Log.e("XWalkPluginUp", e2.getMessage());
            list = null;
        }
        if (list != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == i2) {
                    if (next.uid == myUid) {
                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "other process is in updating plugin progress");
                        AppMethodBeat.o(154510);
                        return true;
                    }
                }
            }
        }
        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update process pid invalid, clear");
        hvs();
        AppMethodBeat.o(154510);
        return false;
    }

    public static void hvs() {
        AppMethodBeat.i(154511);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            AppMethodBeat.o(154511);
            return;
        }
        SharedPreferences.Editor edit = sharedPreferencesForPluginUpdateInfo.edit();
        edit.remove(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_PROCESS_ID);
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress finish");
        AppMethodBeat.o(154511);
    }
}
