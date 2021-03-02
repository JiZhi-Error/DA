package com.tencent.mm.modelstat;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    private static c jmA;
    private MMHandler handler = null;
    private MTimerHandler jmB = null;
    private final int jmC = 20971520;
    private ArrayList<b> jmD = new ArrayList<>();
    private String jmE = null;
    private long jmF = 0;
    private ArrayList<C0459c> jmG = new ArrayList<>();
    private boolean jmH = false;
    private Map<String, Boolean> jmI = new HashMap();
    private long jmJ = 0;
    private long jmK = 0;
    private List<d> jmL = new ArrayList();

    static /* synthetic */ String AG(long j2) {
        AppMethodBeat.i(151045);
        String AF = AF(j2);
        AppMethodBeat.o(151045);
        return AF;
    }

    static /* synthetic */ void a(c cVar, a aVar) {
        AppMethodBeat.i(151044);
        cVar.a(aVar);
        AppMethodBeat.o(151044);
    }

    static /* synthetic */ String dg(Context context) {
        AppMethodBeat.i(151041);
        String topActivityName = getTopActivityName(context);
        AppMethodBeat.o(151041);
        return topActivityName;
    }

    public static c bgb() {
        AppMethodBeat.i(151020);
        if (jmA == null) {
            synchronized (c.class) {
                try {
                    if (jmA == null) {
                        jmA = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(151020);
                    throw th;
                }
            }
        }
        c cVar = jmA;
        AppMethodBeat.o(151020);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(151021);
        if (CrashReportFactory.hasDebuger()) {
            Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", MMApplicationContext.isMMProcess());
        }
        com.tencent.f.j.a bqt = com.tencent.f.j.a.bqt("ClickFlow");
        this.handler = new MMHandler(bqt);
        this.handler.setLogging(false);
        this.jmB = new MTimerHandler(bqt, (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.modelstat.c.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(151008);
                boolean isScreenOn = GreenManUtil.isScreenOn(MMApplicationContext.getContext());
                String dg = c.dg(MMApplicationContext.getContext());
                boolean z = !Util.isNullOrNil(dg);
                Log.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", Boolean.valueOf(isScreenOn), Boolean.valueOf(z), dg);
                if (!isScreenOn || !z) {
                    c.this.handler.post(new Runnable() {
                        /* class com.tencent.mm.modelstat.c.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(151007);
                            c.a(c.this);
                            AppMethodBeat.o(151007);
                        }
                    });
                    AppMethodBeat.o(151008);
                    return false;
                }
                AppMethodBeat.o(151008);
                return true;
            }
        }, true);
        this.jmB.setLogging(false);
        AppMethodBeat.o(151021);
    }

    public final void commitNow() {
        AppMethodBeat.i(151022);
        Log.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", (Boolean) new SyncTask<Boolean>(Boolean.FALSE) {
            /* class com.tencent.mm.modelstat.c.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(151009);
                c.a(c.this);
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(151009);
                return bool;
            }
        }.exec(this.handler), Long.valueOf(Util.milliSecondsToNow(Util.nowMilliSecond())));
        AppMethodBeat.o(151022);
    }

    public final void j(final Intent intent) {
        AppMethodBeat.i(151023);
        if (intent == null || !intent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")) {
            AppMethodBeat.o(151023);
            return;
        }
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.modelstat.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(151010);
                String stringExtra = intent.getStringExtra("ui");
                int intExtra = intent.getIntExtra("uiHashCode", 0);
                int intExtra2 = intent.getIntExtra("opCode", 0);
                long longExtra = intent.getLongExtra("nowMilliSecond", 0);
                long longExtra2 = intent.getLongExtra("elapsedRealtime", 0);
                Log.d("MicroMsg.ClickFlowStatReceiver", "onReceive op:%d ui:%s hash:0x%x time:%d, elapsed time:%d", Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Long.valueOf(Util.milliSecondsToNow(longExtra)), Long.valueOf(longExtra2));
                if (2147483632 == intExtra2) {
                    c.a(c.this);
                    AppMethodBeat.o(151010);
                    return;
                }
                c.a(c.this, intExtra2, stringExtra, intExtra, longExtra, longExtra2);
                AppMethodBeat.o(151010);
            }
        });
        AppMethodBeat.o(151023);
    }

    private static boolean AE(long j2) {
        return j2 == 0;
    }

    private Pair<Integer, ArrayList<b>> v(ArrayList<b> arrayList) {
        long j2;
        AppMethodBeat.i(151024);
        ArrayList arrayList2 = new ArrayList();
        long nowMilliSecond = Util.nowMilliSecond();
        try {
            ArrayList arrayList3 = new ArrayList();
            long j3 = 0;
            int i2 = 0;
            while (i2 < arrayList.size()) {
                b bVar = arrayList.get(i2);
                if (bVar.time < 0 || bVar.time > nowMilliSecond || nowMilliSecond - bVar.time > 50400000) {
                    Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", Long.valueOf(bVar.time), Long.valueOf(nowMilliSecond - bVar.time), Integer.valueOf(bVar.dJY), bVar.jmT);
                    AppMethodBeat.o(151024);
                    return null;
                }
                if (bVar.dJY == 4) {
                    if (j3 < bVar.time) {
                        j2 = bVar.time;
                    }
                    j2 = j3;
                } else if (bVar.dJY != 3) {
                    Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", Integer.valueOf(bVar.dJY), bVar.jmT);
                    AppMethodBeat.o(151024);
                    return null;
                } else {
                    arrayList3.add(bVar);
                    j2 = j3;
                }
                i2++;
                j3 = j2;
            }
            if (arrayList3.size() == 0) {
                AppMethodBeat.o(151024);
                return null;
            }
            Collections.sort(arrayList3);
            Collections.sort(this.jmL);
            b bVar2 = new b();
            Iterator it = arrayList3.iterator();
            b bVar3 = bVar2;
            while (it.hasNext()) {
                b bVar4 = (b) it.next();
                if (!bVar4.jmT.equals(bVar3.jmT)) {
                    a(bVar3, bVar4.jmV);
                    arrayList2.add(bVar4);
                    bVar3.jmU = bVar4.time;
                    bVar3 = bVar4;
                } else if (bVar4.time - bVar3.time > 10800000) {
                    Log.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", Long.valueOf(bVar4.time), Long.valueOf(bVar3.time));
                    bVar3.time = bVar4.time;
                }
            }
            if (!arrayList2.isEmpty()) {
                a((b) arrayList2.get(arrayList2.size() - 1), j3);
            }
            bVar3.jmU = arrayList.get(arrayList.size() - 1).time;
            if (((b) arrayList2.get(arrayList2.size() - 1)).time > j3) {
                ((b) arrayList2.get(arrayList2.size() - 1)).jmU = nowMilliSecond;
            } else if (j3 > nowMilliSecond) {
                ((b) arrayList2.get(arrayList2.size() - 1)).jmU = nowMilliSecond;
            }
            if (((b) arrayList2.get(arrayList2.size() - 1)).jmU - ((b) arrayList2.get(0)).time > 50400000) {
                Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
                AppMethodBeat.o(151024);
                return null;
            }
            Log.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", 0, Integer.valueOf(arrayList2.size()), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
            Pair<Integer, ArrayList<b>> create = Pair.create(0, arrayList2);
            AppMethodBeat.o(151024);
            return create;
        } catch (Exception e2) {
            N(15008, Util.stackTraceToString(e2));
            Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(151024);
            return null;
        }
    }

    private void a(b bVar, long j2) {
        AppMethodBeat.i(151025);
        if (bVar.jmV <= 0) {
            AppMethodBeat.o(151025);
            return;
        }
        int c2 = c(bVar.jmV, 0, this.jmL.isEmpty() ? 0 : this.jmL.size() - 1);
        if (c2 != -1) {
            if (bVar.jmL == null) {
                bVar.jmL = new ArrayList();
            }
            int size = this.jmL.size();
            for (int i2 = c2; i2 < size; i2++) {
                d dVar = this.jmL.get(i2);
                if (dVar.time > bVar.jmV && dVar.time <= j2) {
                    bVar.jmL.add(dVar);
                }
                if (dVar.time >= j2) {
                    break;
                }
            }
        }
        AppMethodBeat.o(151025);
    }

    private int c(long j2, int i2, int i3) {
        AppMethodBeat.i(151026);
        if (this.jmL == null || this.jmL.isEmpty()) {
            AppMethodBeat.o(151026);
            return -1;
        }
        int i4 = (i2 + i3) / 2;
        if (i3 - i2 == 0 || i3 - i2 == 1) {
            if (j2 < this.jmL.get(i3).time) {
                i3 = i2;
            }
        } else if (j2 < this.jmL.get(i4).time) {
            i3 = c(j2, i2, i4);
        } else {
            i3 = j2 > this.jmL.get(i4).time ? c(j2, i4, i3) : i4;
        }
        AppMethodBeat.o(151026);
        return i3;
    }

    private static void N(int i2, String str) {
        AppMethodBeat.i(151027);
        e.INSTANCE.kvStat(13328, i2 + ",0,0,0,0,0,0,0,0,0,0,0,0," + str);
        AppMethodBeat.o(151027);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.modelstat.c$c  reason: collision with other inner class name */
    public static class C0459c {
        int hhs;
        int id;
        long jmW;
        String jmX;
        ArrayList<Pair<String, Boolean>> jmY;
        ArrayList<Pair<String, String>> jmZ;
        String name;
        float rate;

        private C0459c() {
            AppMethodBeat.i(151017);
            this.jmY = new ArrayList<>();
            this.jmZ = new ArrayList<>();
            AppMethodBeat.o(151017);
        }

        /* synthetic */ C0459c(byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(151018);
            StringBuilder sb = new StringBuilder();
            sb.append("ReportConfigEvent{");
            sb.append("id=" + this.id);
            sb.append(", name='" + this.name + "'");
            sb.append(", expireTime=" + this.jmW);
            sb.append(", rate=" + this.rate);
            sb.append(", logId=" + this.hhs);
            sb.append(", pagesType='" + this.jmX + "'");
            sb.append(", pageList=[");
            Iterator<Pair<String, Boolean>> it = this.jmY.iterator();
            while (it.hasNext()) {
                Pair<String, Boolean> next = it.next();
                sb.append("{" + ((String) next.first) + "," + next.second + "}");
                sb.append(",");
            }
            sb.append("]");
            sb.append(", specialPVPages=[");
            Iterator<Pair<String, String>> it2 = this.jmZ.iterator();
            while (it2.hasNext()) {
                Pair<String, String> next2 = it2.next();
                sb.append("{" + ((String) next2.first) + "," + ((String) next2.second) + "}");
                sb.append(",");
            }
            sb.append("]}");
            String sb2 = sb.toString();
            AppMethodBeat.o(151018);
            return sb2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        Map<String, Boolean> jmI = new HashMap();
        long jmJ;
        long jmK;
        List<C0459c> jmS = new ArrayList();

        private a() {
            AppMethodBeat.i(151013);
            AppMethodBeat.o(151013);
        }

        public final String toString() {
            AppMethodBeat.i(151014);
            String str = "Config{nextUpdateInterval=" + this.jmJ + ", samplePeriod=" + this.jmK + ", eventList=" + this.jmS + '}';
            AppMethodBeat.o(151014);
            return str;
        }

        static a PR(String str) {
            AppMethodBeat.i(151015);
            a aVar = new a();
            try {
                Map<String, String> parseXml = XmlParser.parseXml(str, "eventSampleConf", null);
                if (parseXml == null) {
                    Log.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", str);
                    C0458a aVar2 = new C0458a("reportConfigMap is null");
                    AppMethodBeat.o(151015);
                    throw aVar2;
                }
                aVar.jmJ = Util.getLong(parseXml.get(".eventSampleConf.nextUpdateInterval"), 0);
                if (aVar.jmJ <= 0 || aVar.jmJ > 432000) {
                    aVar.jmJ = 432000;
                }
                aVar.jmK = Util.getLong(parseXml.get(".eventSampleConf.samplePeriod"), 0);
                int i2 = 0;
                while (true) {
                    C0459c cVar = new C0459c((byte) 0);
                    String str2 = ".eventSampleConf.events.event" + (i2 > 0 ? Integer.valueOf(i2) : "") + ".";
                    int i3 = i2 + 1;
                    cVar.id = Util.getInt(parseXml.get(str2 + "id"), 0);
                    if (cVar.id > 0) {
                        cVar.jmW = Util.getLong(parseXml.get(str2 + "expireTime"), 0);
                        cVar.name = parseXml.get(str2 + "name");
                        cVar.rate = Util.getFloat(parseXml.get(str2 + "rate"), 0.0f);
                        cVar.hhs = Util.getInt(parseXml.get(str2 + "logId"), 0);
                        cVar.jmX = parseXml.get(str2 + "pages.$type");
                        ArrayList<Pair<String, Boolean>> arrayList = new ArrayList<>();
                        int i4 = 0;
                        while (true) {
                            String str3 = str2 + "pages.page" + (i4 > 0 ? Integer.valueOf(i4) : "") + ".";
                            int i5 = i4 + 1;
                            String str4 = parseXml.get(str3 + "$id");
                            if (str4 == null) {
                                break;
                            }
                            boolean equals = parseXml.get(str3 + "$action").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                            arrayList.add(new Pair<>(str4, Boolean.valueOf(equals)));
                            aVar.jmI.put(str4, Boolean.valueOf(equals));
                            i4 = i5;
                        }
                        cVar.jmY = arrayList;
                        ArrayList<Pair<String, String>> arrayList2 = new ArrayList<>();
                        int i6 = 0;
                        while (true) {
                            String str5 = str2 + "specialPVPages.pageItem" + (i6 > 0 ? Integer.valueOf(i6) : "") + ".";
                            int i7 = i6 + 1;
                            String str6 = parseXml.get(str5 + "$prePage");
                            if (str6 == null) {
                                break;
                            }
                            arrayList2.add(new Pair<>(str6, parseXml.get(str5 + "$page")));
                            i6 = i7;
                        }
                        cVar.jmZ = arrayList2;
                        aVar.jmS.add(cVar);
                        Log.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", cVar);
                        i2 = i3;
                    } else {
                        Log.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", aVar);
                        AppMethodBeat.o(151015);
                        return aVar;
                    }
                }
            } catch (Exception e2) {
                C0458a aVar3 = new C0458a(e2);
                AppMethodBeat.o(151015);
                throw aVar3;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.modelstat.c$a$a  reason: collision with other inner class name */
        public static class C0458a extends Exception {
            C0458a(String str) {
                super(str);
            }

            C0458a(Throwable th) {
                super(th);
            }
        }
    }

    private void a(a aVar) {
        AppMethodBeat.i(151028);
        this.jmJ = aVar.jmJ;
        if (this.jmJ <= 0 || this.jmJ > 432000) {
            this.jmJ = 432000;
        }
        this.jmK = aVar.jmK;
        this.jmG.clear();
        this.jmG.addAll(aVar.jmS);
        this.jmI.clear();
        this.jmI.putAll(aVar.jmI);
        if (this.jmI.containsKey("*") && this.jmI.get("*").booleanValue()) {
            this.jmH = true;
        }
        Log.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", Integer.valueOf(this.jmG.size()), Long.valueOf(this.jmJ), Long.valueOf(this.jmK));
        AppMethodBeat.o(151028);
    }

    private static boolean a(long j2, float f2, long j3) {
        long j4;
        AppMethodBeat.i(151029);
        if (CrashReportFactory.hasDebuger()) {
            AppMethodBeat.o(151029);
            return true;
        } else if (f2 <= 0.0f) {
            AppMethodBeat.o(151029);
            return false;
        } else {
            int i2 = 10000 / ((int) (10000.0f * f2));
            int i3 = (int) j2;
            int i4 = (i3 ^ (i3 >> 16)) * 73244475;
            int i5 = (i4 ^ (i4 >> 16)) * 73244475;
            int i6 = (i5 >> 16) ^ i5;
            int i7 = i6 % i2;
            long nowSecond = Util.nowSecond();
            if (j3 == 0) {
                j4 = 259200;
            } else {
                j4 = j3;
            }
            int i8 = (int) ((nowSecond / j4) % ((long) i2));
            boolean z = i7 == i8;
            Log.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", Boolean.valueOf(z), Long.valueOf(j2), Float.valueOf(f2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
            AppMethodBeat.o(151029);
            return z;
        }
    }

    private static void a(List<b> list, C0459c cVar, SparseArray<String> sparseArray) {
        int i2;
        int i3;
        boolean z = false;
        AppMethodBeat.i(151030);
        String str = cVar.jmX;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -929554094:
                if (str.equals("respective")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3117816:
                if (str.equals("ends")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3433103:
                if (str.equals("page")) {
                    c2 = 0;
                    break;
                }
                break;
            case 379114255:
                if (str.equals("continuous")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                Log.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", cVar);
                sparseArray.put(cVar.hhs, Util.nullAsNil(sparseArray.get(cVar.hhs)) + cVar.id + ";");
                AppMethodBeat.o(151030);
                return;
            case 1:
                Log.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", cVar);
                for (int i4 = 0; i4 < list.size(); i4 = i2 + 1) {
                    int i5 = 0;
                    i2 = i4;
                    while (i5 < cVar.jmY.size()) {
                        if (((String) cVar.jmY.get(i5).first).equals(list.get(i2).jmT)) {
                            sparseArray.put(cVar.hhs, Util.nullAsNil(sparseArray.get(cVar.hhs)) + cVar.id + ";");
                            i5 = cVar.jmY.size();
                            i3 = list.size();
                        } else {
                            i3 = i2;
                        }
                        i5++;
                        i2 = i3;
                    }
                }
                AppMethodBeat.o(151030);
                return;
            case 2:
                Log.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", cVar);
                if (list.size() >= 2) {
                    if (!(cVar.jmY.size() == 2)) {
                        Log.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + cVar.jmY.toString());
                        AppMethodBeat.o(151030);
                        return;
                    }
                    String str2 = (String) cVar.jmY.get(1).first;
                    if (list.get(0).jmT.equals((String) cVar.jmY.get(0).first) && list.get(list.size() - 1).jmT.equals(str2)) {
                        sparseArray.put(cVar.hhs, Util.nullAsNil(sparseArray.get(cVar.hhs)) + cVar.id + ";");
                        AppMethodBeat.o(151030);
                        return;
                    }
                }
                break;
            case 3:
                Log.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", cVar);
                ArrayList<Pair<String, Boolean>> arrayList = cVar.jmY;
                if (arrayList.size() > 0) {
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < list.size()) {
                            int size2 = arrayList.size() - 1;
                            int i6 = size;
                            while (((String) arrayList.get(size2).first).equals(list.get(i6).jmT)) {
                                if (size2 == 0) {
                                    z = true;
                                } else {
                                    size2--;
                                    i6--;
                                }
                            }
                            size = (arrayList.size() - size2) + i6;
                        }
                    }
                }
                if (z) {
                    sparseArray.put(cVar.hhs, Util.nullAsNil(sparseArray.get(cVar.hhs)) + cVar.id + ";");
                    break;
                }
                break;
        }
        AppMethodBeat.o(151030);
    }

    private void a(long j2, ArrayList<b> arrayList, ConfigFile configFile) {
        C0459c cVar;
        AppMethodBeat.i(151031);
        long j3 = arrayList.get(0).time;
        long j4 = arrayList.get(arrayList.size() - 1).jmU;
        long nowSecond = Util.nowSecond();
        int i2 = 0;
        while (true) {
            try {
                if (i2 >= this.jmG.size()) {
                    cVar = null;
                    break;
                } else if ("app".equals(this.jmG.get(i2).jmX)) {
                    cVar = this.jmG.get(i2);
                    break;
                } else {
                    i2++;
                }
            } catch (Exception e2) {
                N(15004, Util.stackTraceToString(e2));
                Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", Util.stackTraceToString(e2));
                AppMethodBeat.o(151031);
                return;
            }
        }
        if (cVar == null) {
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
            if (AE(j2)) {
                a(configFile, 13604, TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND, j3, j4);
                AppMethodBeat.o(151031);
                return;
            }
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
            AppMethodBeat.o(151031);
        } else if (cVar.jmW <= nowSecond || !a(j2, cVar.rate, this.jmK)) {
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", cVar, Long.valueOf(nowSecond));
            AppMethodBeat.o(151031);
        } else {
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", cVar, Long.valueOf(nowSecond));
            a(configFile, cVar.hhs, cVar.id, j3, j4);
            AppMethodBeat.o(151031);
        }
    }

    private static void a(ConfigFile configFile, int i2, int i3, long j2, long j3) {
        AppMethodBeat.i(151032);
        long nowMilliSecond = Util.nowMilliSecond();
        if (j2 > j3 || j2 < 0 || j3 < 0 || j2 > nowMilliSecond || j3 > nowMilliSecond) {
            Log.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(nowMilliSecond));
            AppMethodBeat.o(151032);
            return;
        }
        int nullAsNil = Util.nullAsNil(configFile.getIntegerValue("SEQ_".concat(String.valueOf(i2))));
        configFile.saveValue("SEQ_".concat(String.valueOf(i2)), nullAsNil + 1);
        long nullAsNil2 = Util.nullAsNil(configFile.getLongValue("LastQuit_".concat(String.valueOf(i3))));
        configFile.saveValue("LastQuit_".concat(String.valueOf(i3)), j3);
        if (nullAsNil2 <= 0 || nullAsNil2 > j2) {
            nullAsNil2 = j2;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", 1).put("tbe", j2 / 1000).put("ten", j3 / 1000).put(LocaleUtil.INDONESIAN_NEWNAME, (j3 - j2) / 1000).put("lten", nullAsNil2 / 1000).put("inbg", (j2 - nullAsNil2) / 1000);
        b(i2, String.valueOf(i3), nullAsNil, jSONObject.toString());
        AppMethodBeat.o(151032);
    }

    private void a(long j2, ArrayList<b> arrayList, ConfigFile configFile, int i2) {
        AppMethodBeat.i(151033);
        try {
            long nowMilliSecond = Util.nowMilliSecond();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                JSONObject jSONObject = new JSONObject();
                b bVar = arrayList.get(i3);
                if (bVar.jmU < bVar.time || bVar.time < 0 || bVar.jmU < 0 || bVar.jmU > nowMilliSecond || bVar.time > nowMilliSecond) {
                    Log.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", Long.valueOf(bVar.time), Long.valueOf(bVar.jmU), Long.valueOf(nowMilliSecond));
                    AppMethodBeat.o(151033);
                    return;
                }
                jSONObject.put("p", bVar.jmT).put("tbe", bVar.time / 1000).put(LocaleUtil.INDONESIAN_NEWNAME, (bVar.jmU - bVar.time) / 1000);
                if (bVar.jmL != null && !bVar.jmL.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < bVar.jmL.size(); i4++) {
                        d dVar = bVar.jmL.get(i4);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("w", dVar.jna).put("t", dVar.type).put("tbp", "{" + dVar.left + ";" + dVar.top + "}");
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("wf", jSONArray2);
                }
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("t", 2).put("errt", i2).put("pf", jSONArray);
            if (AE(j2)) {
                int nullAsNil = Util.nullAsNil(configFile.getIntegerValue("SEQ_13604"));
                configFile.saveValue("SEQ_13604", nullAsNil + 1);
                b(13604, "100002", nullAsNil, jSONObject3.toString());
            }
            SparseArray sparseArray = new SparseArray();
            if (this.jmG.size() == 0) {
                Log.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
            }
            for (int i5 = 0; i5 < this.jmG.size(); i5++) {
                C0459c cVar = this.jmG.get(i5);
                if (cVar.jmW <= Util.nowSecond() || !a(j2, cVar.rate, this.jmK)) {
                    Log.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", cVar, Long.valueOf(Util.nowSecond()));
                } else {
                    a(arrayList, cVar, sparseArray);
                }
            }
            for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                int keyAt = sparseArray.keyAt(i6);
                int nullAsNil2 = Util.nullAsNil(configFile.getIntegerValue("SEQ_".concat(String.valueOf(keyAt))));
                configFile.saveValue("SEQ_".concat(String.valueOf(keyAt)), nullAsNil2 + 1);
                b(keyAt, (String) sparseArray.get(keyAt), nullAsNil2, jSONObject3.toString());
            }
            AppMethodBeat.o(151033);
        } catch (Exception e2) {
            N(15005, Util.stackTraceToString(e2));
            Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(151033);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r12v5, types: [org.json.JSONObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v87, types: [java.util.Map] */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0705, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0706, code lost:
        N(15006, com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r4));
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a7, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a8, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r4));
        com.tencent.matrix.trace.core.AppMethodBeat.o(151034);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0149, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x014a, code lost:
        com.tencent.mm.vfs.s.deleteFile(r17);
        java.lang.System.gc();
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", r4, "OutOfMemoryError", new java.lang.Object[0]);
        N(15010, com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r4));
        com.tencent.matrix.trace.core.AppMethodBeat.o(151034);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x05a0 A[Catch:{ Exception -> 0x06c3, OutOfMemoryError -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x05c2 A[Catch:{ Exception -> 0x06c3, OutOfMemoryError -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x07b6  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x07c7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0149 A[ExcHandler: OutOfMemoryError (r4v15 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:6:0x0070] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r38, java.util.ArrayList<com.tencent.mm.modelstat.c.b> r40, com.tencent.mm.sdk.storage.ConfigFile r41) {
        /*
        // Method dump skipped, instructions count: 2007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.c.b(long, java.util.ArrayList, com.tencent.mm.sdk.storage.ConfigFile):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[SYNTHETIC, Splitter:B:25:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099 A[SYNTHETIC, Splitter:B:28:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00aa A[SYNTHETIC, Splitter:B:34:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00af A[SYNTHETIC, Splitter:B:37:0x00af] */
    @android.annotation.SuppressLint({"UseSparseArrays"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.HashMap<java.lang.Long, java.util.ArrayList<com.tencent.mm.modelstat.c.b>> PQ(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.c.PQ(java.lang.String):java.util.HashMap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[SYNTHETIC, Splitter:B:30:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d A[SYNTHETIC, Splitter:B:33:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094 A[SYNTHETIC, Splitter:B:41:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0099 A[SYNTHETIC, Splitter:B:44:0x0099] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(java.lang.String r10, java.util.HashMap<java.lang.Long, java.util.ArrayList<com.tencent.mm.modelstat.c.b>> r11) {
        /*
        // Method dump skipped, instructions count: 181
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.c.b(java.lang.String, java.util.HashMap):void");
    }

    private static void b(int i2, String str, int i3, String str2) {
        AppMethodBeat.i(151037);
        try {
            String replace = str2.replace(",", ";");
            int ceil = (int) Math.ceil(((double) replace.length()) / 6000.0d);
            for (int i4 = 0; i4 < ceil; i4++) {
                String str3 = str + "," + i3 + "," + i4 + "," + ceil + ",0,0,," + replace.substring(i4 * 6000, Math.min((i4 + 1) * 6000, replace.length()));
                Log.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", Integer.valueOf(i2), str, str3);
                e.INSTANCE.idkeyStat(346, 4, 1, false);
                e.INSTANCE.a(i2, str3, true, true);
            }
            AppMethodBeat.o(151037);
        } catch (Exception e2) {
            N(15009, Util.stackTraceToString(e2));
            Log.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(151037);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements Serializable, Comparable<b> {
        int dJY = 0;
        List<d> jmL = null;
        String jmT = null;
        long jmU;
        long jmV = 0;
        long time = 0;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(b bVar) {
            return (int) (this.time - bVar.time);
        }

        b() {
        }

        public final String toString() {
            AppMethodBeat.i(151016);
            String format = String.format(Locale.getDefault(), "[%s,%d,%s]", this.jmT, Integer.valueOf(this.dJY), c.AG(this.time));
            AppMethodBeat.o(151016);
            return format;
        }
    }

    /* access modifiers changed from: package-private */
    public static class d implements Serializable, Comparable<d> {
        String jna = null;
        int left;
        long time = 0;
        int top;
        int type = 0;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(d dVar) {
            return (int) (this.time - dVar.time);
        }

        d() {
        }

        public final String toString() {
            AppMethodBeat.i(151019);
            String format = String.format(Locale.getDefault(), "[%s,%s]", this.jna, c.AG(this.time));
            AppMethodBeat.o(151019);
            return format;
        }
    }

    private static String AF(long j2) {
        AppMethodBeat.i(151038);
        if (j2 < 100000000000L) {
            String format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j2 * 1000));
            AppMethodBeat.o(151038);
            return format;
        }
        String str = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j2)) + String.format(Locale.getDefault(), ".%03d", Long.valueOf(j2 % 1000));
        AppMethodBeat.o(151038);
        return str;
    }

    private static boolean isAppOnForeground(Context context) {
        AppMethodBeat.i(151039);
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                AppMethodBeat.o(151039);
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId()) || runningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId() + ":tools") || runningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId() + ":toolsmp"))) {
                    AppMethodBeat.o(151039);
                    return true;
                }
            }
            AppMethodBeat.o(151039);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", e2, "isAppOnForeground", new Object[0]);
        }
    }

    private static String getTopActivityName(Context context) {
        AppMethodBeat.i(151040);
        if (!isAppOnForeground(context)) {
            AppMethodBeat.o(151040);
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (Build.VERSION.SDK_INT >= 23) {
                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    AppMethodBeat.o(151040);
                    return "";
                }
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = it.next().getTaskInfo().topActivity;
                    if (componentName == null) {
                        AppMethodBeat.o(151040);
                        return null;
                    }
                    String className = componentName.getClassName();
                    if (className.contains(".")) {
                        className = className.substring(className.lastIndexOf(".") + 1);
                    }
                    AppMethodBeat.o(151040);
                    return className;
                }
                AppMethodBeat.o(151040);
                return "";
            }
            String className2 = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
            if (className2.contains(".")) {
                className2 = className2.substring(className2.lastIndexOf(".") + 1);
            }
            AppMethodBeat.o(151040);
            return className2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", e2.getMessage(), Util.stackTraceToString(e2));
        }
    }

    static /* synthetic */ void a(c cVar) {
        long j2;
        String str;
        AppMethodBeat.i(151042);
        if (cVar.jmD == null || cVar.jmD.size() == 0) {
            Log.e("MicroMsg.ClickFlowStatReceiver", "page info array size is 0");
            AppMethodBeat.o(151042);
            return;
        }
        Pair<Integer, ArrayList<b>> v = cVar.v(cVar.jmD);
        cVar.jmD.clear();
        cVar.jmL.clear();
        if (v == null) {
            Log.e("MicroMsg.ClickFlowStatReceiver", "report failed :getResumeList return null ");
            AppMethodBeat.o(151042);
            return;
        }
        int intValue = ((Integer) v.first).intValue();
        ArrayList<b> arrayList = (ArrayList) v.second;
        int i2 = 0;
        if (MMApplicationContext.isMMProcess() && g.aAf().azp()) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azj()) {
                g.aAf();
                i2 = com.tencent.mm.kernel.a.getUin();
            }
        }
        if (i2 == 0) {
            Log.e("MicroMsg.ClickFlowStatReceiver", "report get uin failed  , maybe AccNotReady,  but report it");
        }
        long longValue = new p(i2).longValue();
        if (cVar.jmE == null) {
            cVar.jmE = com.tencent.mm.loader.j.b.aKB() + "ClickFlow/";
            o oVar = new o(cVar.jmE);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
        }
        final ConfigFile configFile = new ConfigFile(cVar.jmE + "stg_20971520_" + longValue + ".cfg");
        final String str2 = cVar.jmE + "ReportConfig_20971520_" + longValue + ".xml";
        if (cVar.jmG == null || cVar.jmG.size() == 0) {
            byte[] aW = s.aW(str2, 0, -1);
            if (aW != null) {
                str = new String(aW);
            } else {
                str = "";
            }
            try {
                if (CrashReportFactory.hasDebuger() && s.YS("/sdcard/reportConfig-android.xml")) {
                    byte[] aW2 = s.aW("/sdcard/reportConfig-android.xml", 0, -1);
                    Log.w("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString: use /sdcard/reportConfig-android.xml as config, cgi config is ignored!!!");
                    str = aW2 != null ? new String(aW2) : "";
                }
                if (TextUtils.isEmpty(str)) {
                    Log.i("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString xml is empty and don't use /sdcard/reportConfig-android.xml");
                } else {
                    cVar.a(a.PR(str));
                }
            } catch (a.C0458a e2) {
                Log.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", e2, "", new Object[0]);
                Log.e("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString throwable :%s %s", e2.getMessage(), Util.stackTraceToString(e2));
                N(15013, Util.stackTraceToString(e2));
            }
        }
        if (!AE(longValue)) {
            long nowSecond = Util.nowSecond();
            long nullAs = Util.nullAs(configFile.getLongValue("LAST_UPDATE_CONFIG"), 0);
            if (nullAs - nowSecond > 432000) {
                j2 = 0;
            } else {
                j2 = nullAs;
            }
            boolean z = ((j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) <= 0 || (cVar.jmJ > 0 ? 1 : (cVar.jmJ == 0 ? 0 : -1)) <= 0 || ((cVar.jmJ + j2) > nowSecond ? 1 : ((cVar.jmJ + j2) == nowSecond ? 0 : -1)) < 0) && cVar.jmF + 3600 < nowSecond;
            Log.i("MicroMsg.ClickFlowStatReceiver", "readReportConfig shouldUpdate:%b now:%d lastCheckUpdateConfigDiff:%d lastUpdate:%d diff:%d  updateintval:%d", Boolean.valueOf(z), Long.valueOf(nowSecond), Long.valueOf(nowSecond - cVar.jmF), Long.valueOf(j2), Long.valueOf(nowSecond - j2), Long.valueOf(cVar.jmJ));
            if (z) {
                com.tencent.mm.network.g gVar = g.aAg().hqi.iMw;
                if (gVar == null) {
                    Log.d("MicroMsg.ClickFlowStatReceiver", "dispatcher is null");
                } else {
                    if (new j(new com.tencent.mm.bw.b(Util.decodeHexString(configFile.getValue("versionBuffer")))).doScene(gVar, new i() {
                        /* class com.tencent.mm.modelstat.c.AnonymousClass4 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(151012);
                            if (qVar.getType() == 1126 && i2 == 0 && i3 == 0) {
                                final bmy bmy = (bmy) ((j) qVar).jof.iLL.iLR;
                                if (bmy == null) {
                                    Log.e("MicroMsg.ClickFlowStatReceiver", "NetSceneUpdateEventConfig onSceneEnd resp is null");
                                    AppMethodBeat.o(151012);
                                    return;
                                }
                                c.this.handler.post(new Runnable() {
                                    /* class com.tencent.mm.modelstat.c.AnonymousClass4.AnonymousClass1 */

                                    public final void run() {
                                        Integer valueOf;
                                        Integer valueOf2;
                                        int length;
                                        String str;
                                        boolean z;
                                        long j2;
                                        AppMethodBeat.i(151011);
                                        configFile.saveValue("LAST_UPDATE_CONFIG", Util.nowSecond());
                                        if (bmy.LVA == null || bmy.LVA.zy.length <= 0 || bmy.LVy == null || bmy.LVy.zy.length <= 0) {
                                            Object[] objArr = new Object[2];
                                            if (bmy.LVA == null) {
                                                valueOf = null;
                                            } else {
                                                valueOf = Integer.valueOf(bmy.LVA.zy.length);
                                            }
                                            objArr[0] = valueOf;
                                            if (bmy.LVy == null) {
                                                valueOf2 = null;
                                            } else {
                                                valueOf2 = Integer.valueOf(bmy.LVy.zy.length);
                                            }
                                            objArr[1] = valueOf2;
                                            Log.e("MicroMsg.ClickFlowStatReceiver", "OnSceneEnd NetSceneUpdateEventConfig failed, eventsampleconf:%s, versionbuffer:%s", objArr);
                                            AppMethodBeat.o(151011);
                                            return;
                                        }
                                        e.INSTANCE.idkeyStat(346, 3, 1, false);
                                        String encodeHexString = Util.encodeHexString(bmy.LVy.zy);
                                        String value = configFile.getValue("versionBuffer");
                                        configFile.saveValue("versionBuffer", encodeHexString);
                                        com.tencent.mm.bw.b bVar = bmy.LVA;
                                        try {
                                            str = new String(com.tencent.mm.b.s.T(bVar.zy), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                                        } catch (Exception e2) {
                                            Object[] objArr2 = new Object[3];
                                            if (bVar == null) {
                                                length = 0;
                                            } else {
                                                length = bVar.zy.length;
                                            }
                                            objArr2[0] = Integer.valueOf(length);
                                            objArr2[1] = e2.getMessage();
                                            objArr2[2] = Util.stackTraceToString(e2);
                                            Log.e("MicroMsg.ClickFlowStatReceiver", "decompress failed, configString length %d, msg:%s  [%s]", objArr2);
                                            str = null;
                                        }
                                        if (TextUtils.isEmpty(str)) {
                                            e.INSTANCE.idkeyStat(346, 2, 1, false);
                                            AppMethodBeat.o(151011);
                                            return;
                                        }
                                        try {
                                            a PR = a.PR(str);
                                            s.f(str2, str.getBytes(), str.getBytes().length);
                                            c.a(c.this, PR);
                                            z = true;
                                        } catch (Exception e3) {
                                            Log.e("MicroMsg.ClickFlowStatReceiver", "readReportConfig failed :%s  [%s]", e3.getMessage(), Util.stackTraceToString(e3));
                                            z = false;
                                        }
                                        if (!encodeHexString.equals(value)) {
                                            Log.i("MicroMsg.ClickFlowStatReceiver", "idKeyStat, configOK:%b", Boolean.valueOf(z));
                                            e eVar = e.INSTANCE;
                                            if (z) {
                                                j2 = 0;
                                            } else {
                                                j2 = 1;
                                            }
                                            eVar.idkeyStat(346, j2, 1, false);
                                        }
                                        AppMethodBeat.o(151011);
                                    }
                                });
                                AppMethodBeat.o(151012);
                                return;
                            }
                            AppMethodBeat.o(151012);
                        }
                    }) == 0) {
                        cVar.jmF = nowSecond;
                    }
                }
            }
        }
        cVar.a(longValue, arrayList, configFile);
        cVar.a(longValue, arrayList, configFile, intValue);
        if (!AE(longValue)) {
            cVar.b(longValue, arrayList, configFile);
        }
        AppMethodBeat.o(151042);
    }

    static /* synthetic */ void a(c cVar, int i2, String str, int i3, long j2, long j3) {
        AppMethodBeat.i(151043);
        long nowMilliSecond = Util.nowMilliSecond();
        if (TextUtils.isEmpty(str) || j2 > nowMilliSecond) {
            Log.e("MicroMsg.ClickFlowStatReceiver", "writeToList page:%s  start - time = %d", str, Long.valueOf(nowMilliSecond - j2));
            AppMethodBeat.o(151043);
            return;
        }
        b bVar = new b();
        bVar.dJY = i2;
        bVar.jmT = str.contains(".") ? str.substring(str.lastIndexOf(".") + 1) : str;
        if (5 == i2 || 6 == i2) {
            bVar.dJY = 4;
        } else if (!(3 == i2 || 4 == i2)) {
            Log.i("MicroMsg.ClickFlowStatReceiver", "writeToList error opCode:%d  (%s)", Integer.valueOf(i2), str);
            AppMethodBeat.o(151043);
            return;
        }
        bVar.time = j2;
        bVar.jmV = j3;
        cVar.jmD.add(bVar);
        Log.i("MicroMsg.ClickFlowStatReceiver", "ActivityState op:%d time:%s 0x%x %s useTime:%d", Integer.valueOf(bVar.dJY), AF(bVar.time), Integer.valueOf(i3), bVar.jmT, Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
        if (bVar.dJY == 3) {
            cVar.jmB.stopTimer();
            AppMethodBeat.o(151043);
            return;
        }
        if (bVar.dJY == 4) {
            cVar.jmB.stopTimer();
            cVar.jmB.startTimer(5000);
        }
        AppMethodBeat.o(151043);
    }
}
