package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrafficClickFlowReceiver extends BroadcastReceiver {
    private static c GsD = new c();
    private static String GsE;
    private static Map<Long, b> GsF = Collections.synchronizedMap(new HashMap());
    private static List<c> GsG = Collections.synchronizedList(new ArrayList());
    private static List<b> GsH = Collections.synchronizedList(new ArrayList());
    private static List<a> GsI = Collections.synchronizedList(new ArrayList());
    private static int GsK = 0;
    private static com.tencent.mm.plugin.downloader.model.c GsL = new com.tencent.mm.plugin.downloader.model.c();
    private static boolean loP = false;
    private int GsJ = 0;

    static {
        AppMethodBeat.i(123919);
        com.tencent.mm.plugin.downloader.model.c.a(new m() {
            /* class com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void k(long j2, String str) {
                AppMethodBeat.i(123902);
                TrafficClickFlowReceiver.P(11, j2);
                AppMethodBeat.o(123902);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void b(long j2, String str, boolean z) {
                AppMethodBeat.i(123903);
                TrafficClickFlowReceiver.P(13, j2);
                AppMethodBeat.o(123903);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void b(long j2, int i2, boolean z) {
                AppMethodBeat.i(123904);
                TrafficClickFlowReceiver.P(13, j2);
                AppMethodBeat.o(123904);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void Bd(long j2) {
                AppMethodBeat.i(123905);
                TrafficClickFlowReceiver.P(13, j2);
                AppMethodBeat.o(123905);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void Be(long j2) {
                AppMethodBeat.i(123906);
                TrafficClickFlowReceiver.P(13, j2);
                AppMethodBeat.o(123906);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void a(long j2, String str, long j3, long j4) {
                AppMethodBeat.i(194288);
                TrafficClickFlowReceiver.P(12, j2);
                AppMethodBeat.o(194288);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void l(long j2, String str) {
                AppMethodBeat.i(123908);
                TrafficClickFlowReceiver.P(11, j2);
                AppMethodBeat.o(123908);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void Bf(long j2) {
            }
        });
        AppMethodBeat.o(123919);
    }

    public void onReceive(Context context, final Intent intent) {
        AppMethodBeat.i(123912);
        if (intent == null || !intent.getAction().equals("com.tencent.mm.Intent.ACTION_NET_STATS")) {
            AppMethodBeat.o(123912);
            return;
        }
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(194289);
                String stringExtra = intent.getStringExtra("ui");
                if (stringExtra == null) {
                    stringExtra = BuildConfig.COMMAND;
                }
                if (stringExtra.contains(".")) {
                    stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
                }
                int intExtra = intent.getIntExtra("opCode", 0);
                if (intExtra == 10) {
                    a aVar = new a();
                    aVar.GsN = stringExtra;
                    aVar.time = System.currentTimeMillis();
                    TrafficClickFlowReceiver.GsI.add(aVar);
                    Log.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", stringExtra);
                    AppMethodBeat.o(194289);
                    return;
                }
                TrafficClickFlowReceiver.fR(stringExtra, intExtra);
                TrafficClickFlowReceiver.this.GsJ = intExtra;
                AppMethodBeat.o(194289);
            }
        });
        AppMethodBeat.o(123912);
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public String GsN;
        public long endTime;
        public long startTime;

        c() {
        }

        public final String toString() {
            AppMethodBeat.i(123911);
            String str = "UIObject{ui='" + this.GsN + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
            AppMethodBeat.o(123911);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public long endTime;
        public long startTime;

        b() {
        }

        public final String toString() {
            AppMethodBeat.i(123910);
            String str = "DownLoadObject{startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
            AppMethodBeat.o(123910);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public String GsN;
        public long time;

        a() {
        }

        public final String toString() {
            AppMethodBeat.i(123909);
            String str = "ClickObject{ui='" + this.GsN + '\'' + ", time=" + this.time + '}';
            AppMethodBeat.o(123909);
            return str;
        }
    }

    protected static boolean KI(long j2) {
        AppMethodBeat.i(123913);
        Log.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", GsH.toString());
        for (int i2 = 0; i2 < GsH.size(); i2++) {
            if (GsH.get(i2).endTime > j2) {
                AppMethodBeat.o(123913);
                return true;
            }
        }
        Log.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", GsF.toString());
        if (GsF.size() > 0) {
            AppMethodBeat.o(123913);
            return true;
        }
        AppMethodBeat.o(123913);
        return false;
    }

    protected static boolean KJ(long j2) {
        AppMethodBeat.i(123914);
        if (GsH == null) {
            AppMethodBeat.o(123914);
            return true;
        }
        Log.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", GsH.toString());
        for (int i2 = 0; i2 < GsH.size(); i2++) {
            b bVar = GsH.get(i2);
            if (bVar.endTime > j2 && !KK(bVar.startTime)) {
                AppMethodBeat.o(123914);
                return false;
            }
        }
        if (GsF == null) {
            AppMethodBeat.o(123914);
            return true;
        }
        Log.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", GsF.toString());
        if (GsF.size() > 0) {
            for (Map.Entry<Long, b> entry : GsF.entrySet()) {
                if (!KK(entry.getValue().startTime)) {
                    AppMethodBeat.o(123914);
                    return false;
                }
            }
        }
        AppMethodBeat.o(123914);
        return true;
    }

    private static boolean KK(long j2) {
        AppMethodBeat.i(123915);
        if (GsI == null) {
            AppMethodBeat.o(123915);
            return false;
        }
        Log.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", GsI.toString());
        for (int i2 = 0; i2 < GsI.size(); i2++) {
            if (Math.abs(j2 - GsI.get(i2).time) < 10000) {
                AppMethodBeat.o(123915);
                return true;
            }
        }
        AppMethodBeat.o(123915);
        return false;
    }

    protected static int a(int i2, long j2, List<c> list) {
        boolean z;
        AppMethodBeat.i(123916);
        boolean z2 = true;
        while (i2 < GsG.size()) {
            try {
                c cVar = GsG.get(i2);
                if (!z2 || cVar.endTime <= j2) {
                    list.add(cVar);
                    z = z2;
                } else {
                    c cVar2 = new c();
                    cVar2.GsN = cVar.GsN;
                    cVar2.startTime = j2;
                    cVar2.endTime = cVar.endTime;
                    list.add(cVar2);
                    z = false;
                }
                i2++;
                z2 = z;
            } catch (Exception e2) {
                AppMethodBeat.o(123916);
                return -1;
            }
        }
        if (list.size() == 0) {
            c cVar3 = new c();
            cVar3.GsN = GsE;
            cVar3.startTime = j2;
            cVar3.endTime = System.currentTimeMillis();
            list.add(cVar3);
        } else {
            c cVar4 = new c();
            cVar4.GsN = GsE;
            cVar4.startTime = GsD.startTime;
            cVar4.endTime = System.currentTimeMillis();
            list.add(cVar4);
        }
        int size = GsG.size();
        AppMethodBeat.o(123916);
        return size;
    }

    protected static void fAi() {
        AppMethodBeat.i(123917);
        if (GsG == null) {
            AppMethodBeat.o(123917);
            return;
        }
        GsG.clear();
        AppMethodBeat.o(123917);
    }

    static /* synthetic */ void P(int i2, long j2) {
        b bVar;
        AppMethodBeat.i(123918);
        if (i2 == 11) {
            b bVar2 = new b();
            bVar2.startTime = System.currentTimeMillis();
            GsF.put(Long.valueOf(j2), bVar2);
            AppMethodBeat.o(123918);
            return;
        }
        if (i2 == 12) {
            if (!GsF.containsKey(Long.valueOf(j2))) {
                new b().startTime = System.currentTimeMillis();
                AppMethodBeat.o(123918);
                return;
            }
        } else if (i2 == 13 && (bVar = GsF.get(Long.valueOf(j2))) != null) {
            bVar.endTime = System.currentTimeMillis();
            GsH.add(bVar);
            GsF.remove(Long.valueOf(j2));
        }
        AppMethodBeat.o(123918);
    }

    static /* synthetic */ void fR(String str, int i2) {
        AppMethodBeat.i(194290);
        if (i2 == 1) {
            GsE = str;
            AppMethodBeat.o(194290);
            return;
        }
        if (i2 == 3) {
            if (loP) {
                c cVar = new c();
                cVar.GsN = "Background";
                cVar.startTime = GsD.startTime;
                cVar.endTime = System.currentTimeMillis();
                GsG.add(cVar);
                loP = false;
            }
            GsE = str;
            if (str != GsD.GsN) {
                GsD.GsN = str;
                GsD.startTime = System.currentTimeMillis();
                AppMethodBeat.o(194290);
                return;
            }
        } else if (i2 == 4) {
            GsD.endTime = System.currentTimeMillis();
            if (GsD.GsN != null) {
                GsG.add(GsD);
            }
            GsD = new c();
            boolean isTopApplication = Util.isTopApplication(MMApplicationContext.getContext());
            boolean isScreenOn = GreenManUtil.isScreenOn(MMApplicationContext.getContext());
            if (!isTopApplication || !isScreenOn) {
                GsD.startTime = System.currentTimeMillis();
                GsE = "Background";
                loP = true;
                Log.i("MicroMsg.TrafficClickFlow", "come to background isTopApp : %b, isScreenOn : %b", Boolean.valueOf(isTopApplication), Boolean.valueOf(isScreenOn));
            }
            AppMethodBeat.o(194290);
            return;
        } else if (i2 == 5 && GsG.contains(str)) {
            GsE = "Background";
        }
        AppMethodBeat.o(194290);
    }
}
