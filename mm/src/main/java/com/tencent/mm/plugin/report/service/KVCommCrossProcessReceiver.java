package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import com.tencent.mars.Mars;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver extends BroadcastReceiver {
    private static MMHandler Cye;
    private static int Cyf = 10000;
    private static volatile long Cyg = 10000;
    private static volatile int Cyh = -1;
    private static BroadCastData Cyi = new BroadCastData();
    private static String className = "";
    private static Object lock = new Object();

    static {
        AppMethodBeat.i(143830);
        AnonymousClass1 r0 = new MMHandler("kv_report") {
            /* class com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(143819);
                super.handleMessage(message);
                if (message.what == 1) {
                    KVCommCrossProcessReceiver.access$000();
                }
                AppMethodBeat.o(143819);
            }
        };
        Cye = r0;
        r0.setLogging(false);
        AppMethodBeat.o(143830);
    }

    public void onReceive(Context context, final Intent intent) {
        AppMethodBeat.i(143822);
        if (intent == null) {
            Log.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
            AppMethodBeat.o(143822);
            return;
        }
        Cye.post(new Runnable() {
            /* class com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(143820);
                Log.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", Long.valueOf(Thread.currentThread().getId()));
                KVCommCrossProcessReceiver.a(KVCommCrossProcessReceiver.this, intent);
                AppMethodBeat.o(143820);
            }
        });
        AppMethodBeat.o(143822);
    }

    public static void eOA() {
        if (100 >= 0) {
            Cyg = 100;
        }
    }

    public static void eOB() {
        Cyh = 1000;
    }

    public static void a(KVReportDataInfo kVReportDataInfo) {
        AppMethodBeat.i(143823);
        Log.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", Long.valueOf(kVReportDataInfo.dQR), Long.valueOf(kVReportDataInfo.dDw), Boolean.valueOf(kVReportDataInfo.CxY), Boolean.valueOf(kVReportDataInfo.Cyr));
        synchronized (lock) {
            try {
                Cyi.CxU.add(kVReportDataInfo);
            } catch (Throwable th) {
                AppMethodBeat.o(143823);
                throw th;
            }
        }
        if (Cyg == 0 || eOC()) {
            Cye.obtainMessage(1).sendToTarget();
            AppMethodBeat.o(143823);
        } else if (Cye.hasMessages(1)) {
            AppMethodBeat.o(143823);
        } else {
            Cye.sendEmptyMessageDelayed(1, Cyg);
            AppMethodBeat.o(143823);
        }
    }

    public static void a(StIDKeyDataInfo stIDKeyDataInfo) {
        AppMethodBeat.i(143824);
        Log.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", Long.valueOf(stIDKeyDataInfo.oIi), Long.valueOf(stIDKeyDataInfo.key), Long.valueOf(stIDKeyDataInfo.value), Boolean.valueOf(stIDKeyDataInfo.CxY));
        if (c.Wj((int) stIDKeyDataInfo.oIi)) {
            Log.e("MicroMsg.ReportManagerKvCheck", "exception:%s", Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code, IDKey:(" + stIDKeyDataInfo.oIi + "," + stIDKeyDataInfo.key + ")")));
            stIDKeyDataInfo.oIi = 1566;
            stIDKeyDataInfo.key = 1;
            stIDKeyDataInfo.value = 1;
        }
        synchronized (lock) {
            try {
                Cyi.CxV.add(stIDKeyDataInfo);
            } catch (Throwable th) {
                AppMethodBeat.o(143824);
                throw th;
            }
        }
        if (Cyg == 0 || eOC()) {
            Cye.obtainMessage(1).sendToTarget();
            AppMethodBeat.o(143824);
        } else if (Cye.hasMessages(1)) {
            AppMethodBeat.o(143824);
        } else {
            Cye.sendEmptyMessageDelayed(1, Cyg);
            AppMethodBeat.o(143824);
        }
    }

    public static void aM(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(143825);
        Log.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", Integer.valueOf(arrayList.size()), Boolean.FALSE);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (c.Wj((int) arrayList.get(i2).GetID())) {
                Log.e("MicroMsg.ReportManagerKvCheck", "exception:%s", Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code. IDKey:(" + arrayList.get(i2).GetID() + "," + arrayList.get(i2).GetKey() + ")")));
                arrayList.get(i2).SetID(1566);
                arrayList.get(i2).SetKey(1);
                arrayList.get(i2).SetValue(1);
            }
        }
        synchronized (lock) {
            try {
                Cyi.CxW.add(new GroupIDKeyDataInfo(arrayList));
            } catch (Throwable th) {
                AppMethodBeat.o(143825);
                throw th;
            }
        }
        if (Cyg == 0 || eOC()) {
            Cye.obtainMessage(1).sendToTarget();
            AppMethodBeat.o(143825);
        } else if (Cye.hasMessages(1)) {
            AppMethodBeat.o(143825);
        } else {
            Cye.sendEmptyMessageDelayed(1, Cyg);
            AppMethodBeat.o(143825);
        }
    }

    private static boolean eOC() {
        AppMethodBeat.i(143826);
        if (Cyh <= 0) {
            AppMethodBeat.o(143826);
            return false;
        } else if (Cyi == null) {
            AppMethodBeat.o(143826);
            return false;
        } else {
            try {
                if (Cyi.CxV.size() + Cyi.CxW.size() + Cyi.CxU.size() >= Cyh) {
                    AppMethodBeat.o(143826);
                    return true;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", e2);
            }
            AppMethodBeat.o(143826);
            return false;
        }
    }

    public static void eOD() {
        AppMethodBeat.i(143827);
        if (Cye == null) {
            AppMethodBeat.o(143827);
            return;
        }
        Cye.removeMessages(1);
        MMHandler mMHandler = Cye;
        mMHandler.handleMessage(mMHandler.obtainMessage(1));
        AppMethodBeat.o(143827);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        r3 = r0.CxW;
        r4 = r0.CxV;
        r5 = r0.CxU;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        if (com.tencent.mm.kernel.l.cL(com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()) != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        if (com.tencent.mm.sdk.platformtools.MMApplicationContext.isMMProcessExist() != false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
        r1 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        if (r1.hasNext() == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        r0 = r1.next();
        com.tencent.mm.plugin.report.service.f.f(r0.CxX, r0.CxY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        r1 = r4.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        if (r1.hasNext() == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        r0 = r1.next();
        com.tencent.mm.plugin.report.service.f.c((int) r0.oIi, (int) r0.key, (int) r0.value, r0.CxY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a4, code lost:
        r6 = r5.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
        if (r6.hasNext() == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        r5 = r6.next();
        com.tencent.mm.plugin.report.service.f.a((int) r5.dQR, (int) r5.dDw, r5.value, r5.Cyr, r5.CxY, r5.Cys);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(143828);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        r6 = new android.content.Intent();
        r6.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        r8 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getPackageName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e3, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.className) == false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e5, code lost:
        com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.className = com.tencent.mm.sdk.platformtools.MMApplicationContext.getSourcePackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ff, code lost:
        r6.setComponent(new android.content.ComponentName(r8, com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.className));
        r6.putExtra("type", 1);
        r7 = new android.os.Bundle();
        r7.putParcelable("BUNDLE_IDKEYGROUP", r0);
        r6.putExtra("INTENT_IDKEYGROUP", r7);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", java.lang.Integer.valueOf(r5.size()), java.lang.Integer.valueOf(r4.size()), java.lang.Integer.valueOf(r3.size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext().sendBroadcast(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0150, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(143828);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0155, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0156, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.ReportManagerKvCheck", r0, "sendBroadcastMessageDirectly", new java.lang.Object[0]);
        com.tencent.matrix.trace.core.AppMethodBeat.o(143828);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void access$000() {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.access$000():void");
    }

    static /* synthetic */ void a(KVCommCrossProcessReceiver kVCommCrossProcessReceiver, Intent intent) {
        BroadCastData broadCastData;
        AppMethodBeat.i(143829);
        try {
            switch (IntentUtil.getIntExtra(intent, "type", 0)) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("INTENT_IDKEYGROUP");
                    if (!(bundleExtra == null || (broadCastData = (BroadCastData) bundleExtra.getParcelable("BUNDLE_IDKEYGROUP")) == null)) {
                        ArrayList<GroupIDKeyDataInfo> arrayList = broadCastData.CxW;
                        ArrayList<StIDKeyDataInfo> arrayList2 = broadCastData.CxV;
                        ArrayList<KVReportDataInfo> arrayList3 = broadCastData.CxU;
                        Log.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                        Iterator<GroupIDKeyDataInfo> it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupIDKeyDataInfo next = it.next();
                            if (next != null) {
                                e.e(next.CxX, next.CxY);
                            }
                        }
                        Iterator<StIDKeyDataInfo> it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            StIDKeyDataInfo next2 = it2.next();
                            if (next2 != null) {
                                e.b(next2.oIi, next2.key, next2.value, next2.CxY);
                            }
                        }
                        Iterator<KVReportDataInfo> it3 = arrayList3.iterator();
                        while (it3.hasNext()) {
                            KVReportDataInfo next3 = it3.next();
                            if (next3 != null) {
                                e.a(next3.dQR, next3.dDw, next3.value, next3.Cyr, next3.CxY, next3.Cys);
                            }
                        }
                        break;
                    }
                case 2:
                    Log.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive TYPE_ONCRASHOREXCEPTION");
                    Mars.onSingalCrash(0);
                    break;
            }
            if (l.cL(MMApplicationContext.getContext())) {
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(143821);
                        if (l.cL(MMApplicationContext.getContext())) {
                            Log.e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
                            Log.appenderFlushSync();
                            Mars.onSingalCrash(0);
                            a a2 = c.a(Process.myPid(), new a());
                            Object obj = new Object();
                            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/report/service/KVCommCrossProcessReceiver$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                            Process.killProcess(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/report/service/KVCommCrossProcessReceiver$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        }
                        AppMethodBeat.o(143821);
                    }
                }, 5000);
            }
            AppMethodBeat.o(143829);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e2, "", new Object[0]);
            AppMethodBeat.o(143829);
        }
    }
}
