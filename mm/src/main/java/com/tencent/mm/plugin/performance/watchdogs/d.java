package com.tencent.mm.plugin.performance.watchdogs;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class d implements Runnable {
    private static final d AXI = new d();
    private int AWb = 0;
    public boolean cQp = false;
    private final ActivityManager mActivityManager = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME));

    static {
        AppMethodBeat.i(201181);
        AppMethodBeat.o(201181);
    }

    private d() {
        AppMethodBeat.i(201178);
        AppMethodBeat.o(201178);
    }

    public static d eCN() {
        return AXI;
    }

    public final void run() {
        AppMethodBeat.i(201179);
        List<a> eCO = eCO();
        if (!eCO.isEmpty()) {
            int size = eCO.size();
            ArrayList<IDKey> arrayList = new ArrayList<>();
            arrayList.add(new IDKey(1474, 0, 1));
            arrayList.add(new IDKey(1474, size, 1));
            e.INSTANCE.b(arrayList, false);
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_process_watchdog_count_threshold, 12);
            long j2 = 0;
            for (a aVar : eCO) {
                j2 = aVar.AXJ + j2;
            }
            String replace = Arrays.toString(eCO.toArray()).replace(",", ";");
            if (size >= a2 && size > this.AWb) {
                this.AWb = size;
                e.INSTANCE.a(20846, Integer.valueOf(size), replace, Long.valueOf(j2));
            }
            Log.i("MicroMsg.ProcessWatchDog", "DumpProcesses: %s || pssSum : %s", replace, Long.valueOf(j2));
        }
        h.RTc.o(this, this.cQp ? 300000 : 1800000);
        AppMethodBeat.o(201179);
    }

    public final List<a> eCO() {
        AppMethodBeat.i(201180);
        long currentTimeMillis = System.currentTimeMillis();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.mActivityManager.getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myUid() != runningAppProcessInfo.uid) {
                    Log.e("MicroMsg.ProcessWatchDog", "info with uid [%s] & process name [%s] is not current app [%s]", Integer.valueOf(runningAppProcessInfo.uid), runningAppProcessInfo.processName, Integer.valueOf(Process.myUid()));
                } else {
                    Debug.MemoryInfo[] processMemoryInfo = this.mActivityManager.getProcessMemoryInfo(new int[]{runningAppProcessInfo.pid});
                    a aVar = new a(runningAppProcessInfo.processName, runningAppProcessInfo.pid);
                    if (!(processMemoryInfo == null || processMemoryInfo.length != 1 || processMemoryInfo[0] == null)) {
                        aVar.AXJ = (long) processMemoryInfo[0].getTotalPss();
                    }
                    arrayList.add(aVar);
                }
            }
        }
        Log.i("MicroMsg.ProcessWatchDog", "dumpProcess cost: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(201180);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        long AXJ;
        int pid;
        String processName;

        public a(String str, int i2) {
            this.processName = str;
            this.pid = i2;
        }

        public final String toString() {
            AppMethodBeat.i(201177);
            String str = this.processName + "|pid:" + this.pid + "|pss:" + this.AXJ;
            AppMethodBeat.o(201177);
            return str;
        }
    }
}
