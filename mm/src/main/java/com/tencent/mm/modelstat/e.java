package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e {
    private static e jnm;
    private int jnn = -1;
    private int jno = g.sHCENCODEVIDEOTIMEOUT;
    private int jnp = 3000;
    private int jnq = 1000;
    private int jnr = 20;
    private ArrayList<Pair<Float, Float>> jns = new ArrayList<>();
    private ArrayList<Pair<Float, Float>> jnt = new ArrayList<>();
    private long startTime = 0;

    public e() {
        AppMethodBeat.i(151070);
        AppMethodBeat.o(151070);
    }

    public static e bge() {
        AppMethodBeat.i(151071);
        if (jnm == null) {
            synchronized (e.class) {
                try {
                    if (jnm == null) {
                        jnm = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(151071);
                    throw th;
                }
            }
        }
        e eVar = jnm;
        AppMethodBeat.o(151071);
        return eVar;
    }

    public final void a(final int i2, final boolean z, final boolean z2, final float f2, final float f3, final int i3) {
        AppMethodBeat.i(151072);
        Log.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3));
        if (com.tencent.mm.kernel.g.aAf().azp()) {
            com.tencent.mm.kernel.g.aAf();
            if (!com.tencent.mm.kernel.a.azj()) {
                com.tencent.mm.bf.b.beB().a(f2, f3, i3, "", "", z2 ? 1 : 0, i2);
                if (this.jnt.size() == 0 && this.jns.size() == 0 && !PS(h.aqJ().getValue("AndroidIndoorSensorReport"))) {
                    AppMethodBeat.o(151072);
                    return;
                }
                if (!CrashReportFactory.hasDebuger()) {
                    com.tencent.mm.kernel.g.aAf();
                    int ch = i.ch(com.tencent.mm.kernel.a.getUin() + 5, 100);
                    if (ch > this.jnn) {
                        com.tencent.mm.kernel.g.aAf();
                        Log.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", Long.valueOf(new p(com.tencent.mm.kernel.a.getUin()).longValue()), Integer.valueOf(ch), Integer.valueOf(this.jnn));
                        AppMethodBeat.o(151072);
                        return;
                    }
                }
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.modelstat.e.AnonymousClass1 */

                    public final void run() {
                        Pair pair;
                        int i2;
                        AppMethodBeat.i(151060);
                        try {
                            if (com.tencent.mm.kernel.g.aAf().azp()) {
                                com.tencent.mm.kernel.g.aAf();
                                if (!com.tencent.mm.kernel.a.azj()) {
                                    long nowMilliSecond = Util.nowMilliSecond();
                                    if (e.this.startTime == 0 || nowMilliSecond - e.this.startTime >= 1800000) {
                                        ArrayList arrayList = z2 ? e.this.jns : e.this.jnt;
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 < arrayList.size()) {
                                                if (e.F(f2, ((Float) ((Pair) arrayList.get(i3)).first).floatValue()) && e.F(f3, ((Float) ((Pair) arrayList.get(i3)).second).floatValue())) {
                                                    pair = (Pair) arrayList.get(i3);
                                                    break;
                                                }
                                                i3++;
                                            } else {
                                                pair = null;
                                                break;
                                            }
                                        }
                                        if (pair == null) {
                                            Log.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                                            AppMethodBeat.o(151060);
                                            return;
                                        }
                                        e.this.startTime = nowMilliSecond;
                                        StringBuilder sb = new StringBuilder();
                                        com.tencent.mm.kernel.g.aAf();
                                        final String sb2 = sb.append(new p(com.tencent.mm.kernel.a.getUin()).toString()).append("_").append(e.this.startTime).toString();
                                        StringBuilder append = new StringBuilder().append(pair.first).append(",").append(pair.second).append(",").append(i2).append(",");
                                        int i4 = z ? 1 : 2;
                                        if (z2) {
                                            i2 = 10;
                                        } else {
                                            i2 = 20;
                                        }
                                        final String sb3 = append.append(i2 + i4).append(",").append(f2).append(",").append(f3).append(",0,").append(i3).append(",").append(e.this.startTime).append(",").toString();
                                        final c cVar = new c();
                                        Context context = MMApplicationContext.getContext();
                                        int i5 = e.this.jnp;
                                        int i6 = e.this.jnr;
                                        if (cVar.cnK == null) {
                                            cVar.cnK = (WifiManager) context.getSystemService("wifi");
                                        }
                                        cVar.jnS = i5;
                                        cVar.jnr = i6;
                                        cVar.startTime = Util.nowMilliSecond();
                                        cVar.jnT = true;
                                        cVar.dBz = com.tencent.f.h.RTc.ba(cVar.dQN);
                                        final b bVar = new b();
                                        MMApplicationContext.getContext();
                                        boolean tT = bVar.tT(e.this.jnq);
                                        if (!tT) {
                                            Log.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", Boolean.TRUE, Boolean.valueOf(tT));
                                            bVar.bgf();
                                            cVar.bgf();
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(13381, sb3 + sb2 + ",-10002,ERROR:StartFailed.");
                                            AppMethodBeat.o(151060);
                                            return;
                                        }
                                        com.tencent.mm.kernel.g.aAi();
                                        new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                                            /* class com.tencent.mm.modelstat.e.AnonymousClass1.AnonymousClass1 */
                                            boolean jnA = false;

                                            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                                            public final boolean onTimerExpired() {
                                                AppMethodBeat.i(151059);
                                                boolean isAppOnForeground = GreenManUtil.isAppOnForeground(MMApplicationContext.getContext());
                                                long nowMilliSecond = Util.nowMilliSecond();
                                                long j2 = nowMilliSecond - e.this.startTime;
                                                if (j2 <= ((long) e.this.jno)) {
                                                    if (isAppOnForeground) {
                                                        this.jnA = false;
                                                        AppMethodBeat.o(151059);
                                                        return true;
                                                    } else if (!this.jnA) {
                                                        this.jnA = true;
                                                        AppMethodBeat.o(151059);
                                                        return true;
                                                    }
                                                }
                                                Log.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", Boolean.valueOf(this.jnA), Boolean.valueOf(isAppOnForeground), Long.valueOf(j2));
                                                e.this.startTime = 0;
                                                String bgf = bVar.bgf();
                                                String bgf2 = cVar.bgf();
                                                try {
                                                    if (Util.isNullOrNil(bgf) || Util.isNullOrNil(bgf2)) {
                                                        Log.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", bgf, bgf2);
                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(13381, sb3 + sb2 + (!Util.isNullOrNil(bgf) ? ",-10011,ERROR:StopFailed." : ",-10012,ERROR:StopFailed."));
                                                        AppMethodBeat.o(151059);
                                                        return false;
                                                    }
                                                    String str = bgf + bgf2;
                                                    int ceil = (int) Math.ceil(((double) str.length()) / 5400.0d);
                                                    for (int i2 = 0; i2 < ceil; i2++) {
                                                        String str2 = sb3 + sb2 + "_" + nowMilliSecond + "_" + ceil + "_" + (j2 > ((long) e.this.jno) ? "1" : "2") + "," + (i2 + 1) + "," + str.substring(i2 * 5400, Math.min((i2 + 1) * 5400, str.length()));
                                                        Log.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", Integer.valueOf(i2), Integer.valueOf(ceil), Integer.valueOf(str.length()), Integer.valueOf(str2.length()), str2);
                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(13381, str2);
                                                    }
                                                    AppMethodBeat.o(151059);
                                                    return false;
                                                } catch (Exception e2) {
                                                    Log.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", e2.getMessage());
                                                }
                                            }
                                        }, true).startTimer(3000);
                                        AppMethodBeat.o(151060);
                                        return;
                                    }
                                    Log.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", Long.valueOf(nowMilliSecond - e.this.startTime));
                                    AppMethodBeat.o(151060);
                                    return;
                                }
                            }
                            AppMethodBeat.o(151060);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", e2.getMessage());
                            AppMethodBeat.o(151060);
                        }
                    }
                });
                AppMethodBeat.o(151072);
                return;
            }
        }
        AppMethodBeat.o(151072);
    }

    public final boolean PS(String str) {
        AppMethodBeat.i(151073);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151073);
            return false;
        }
        try {
            String[] split = str.split(",");
            this.jnn = Util.getInt(split[0], -1);
            if (this.jnn > 101) {
                Assert.assertTrue(false);
            }
            this.jno = Util.getInt(split[1], g.sHCENCODEVIDEOTIMEOUT);
            this.jnp = Util.getInt(split[2], 3000);
            this.jnq = Util.getInt(split[3], 1000);
            this.jnr = Util.getInt(split[4], 20);
            int i2 = Util.getInt(split[5], 0);
            for (int i3 = 0; i3 < i2; i3++) {
                String[] split2 = split[i3 + 6].split(";");
                if ("1".equals(split2[0])) {
                    this.jns.add(new Pair<>(Float.valueOf(Util.safeParseFloat(split2[1])), Float.valueOf(Util.safeParseFloat(split2[2]))));
                } else {
                    this.jnt.add(new Pair<>(Float.valueOf(Util.safeParseFloat(split2[1])), Float.valueOf(Util.safeParseFloat(split2[2]))));
                }
            }
            Log.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", Integer.valueOf(this.jno), Integer.valueOf(this.jnp), Integer.valueOf(this.jnq), Integer.valueOf(this.jnr), Integer.valueOf(i2), Integer.valueOf(this.jns.size()), Integer.valueOf(this.jnt.size()));
            AppMethodBeat.o(151073);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", e2.getMessage(), str);
            AppMethodBeat.o(151073);
            return false;
        }
    }

    class c {
        WifiManager cnK;
        Future dBz;
        Runnable dQN = new com.tencent.f.i.h() {
            /* class com.tencent.mm.modelstat.e.c.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "MicroMsg.IndoorReporter_WIFI_Scan";
            }

            public final void run() {
                int i2;
                int i3;
                AppMethodBeat.i(151067);
                Log.i("MicroMsg.IndoorReporter", "start wifi");
                while (c.this.jnT) {
                    try {
                        long nowMilliSecond = Util.nowMilliSecond();
                        List<ScanResult> scanResults = c.this.cnK.getScanResults();
                        String str = "";
                        if (scanResults == null || scanResults.size() <= 0) {
                            i2 = 0;
                        } else {
                            Collections.sort(scanResults, new Comparator<ScanResult>() {
                                /* class com.tencent.mm.modelstat.e.c.AnonymousClass1.AnonymousClass1 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                                @Override // java.util.Comparator
                                public final /* bridge */ /* synthetic */ int compare(ScanResult scanResult, ScanResult scanResult2) {
                                    return scanResult2.level - scanResult.level;
                                }
                            });
                            int i4 = 0;
                            i2 = 0;
                            while (true) {
                                if (i4 >= scanResults.size()) {
                                    break;
                                }
                                ScanResult scanResult = scanResults.get(i4);
                                if (scanResult != null && !Util.isNullOrNil(scanResult.BSSID) && !Util.isNullOrNil(scanResult.SSID)) {
                                    str = str + scanResult.SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "") + ";" + scanResult.BSSID + ";" + scanResult.level + ";";
                                    i3 = i2 + 1;
                                    if (i3 >= c.this.jnr) {
                                        i2 = i3;
                                        break;
                                    }
                                } else {
                                    i3 = i2;
                                }
                                i4++;
                                i2 = i3;
                            }
                        }
                        String str2 = (nowMilliSecond - c.this.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i2 + ";" + str;
                        Log.i("MicroMsg.IndoorReporter", "%d %s", Integer.valueOf(str2.length()), str2);
                        c.this.jnU.add(str2);
                        c.this.cnK.startScan();
                        Thread.sleep((long) c.this.jnS);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.IndoorReporter", "Except:%s", e2.getMessage());
                        AppMethodBeat.o(151067);
                        return;
                    }
                }
                AppMethodBeat.o(151067);
            }
        };
        int jnS = 0;
        boolean jnT = false;
        List<String> jnU = new ArrayList();
        int jnr = 0;
        long startTime = 0;

        c() {
            AppMethodBeat.i(151068);
            AppMethodBeat.o(151068);
        }

        public final String bgf() {
            AppMethodBeat.i(151069);
            this.jnT = false;
            try {
                if (this.dBz != null && !this.dBz.isDone()) {
                    this.dBz.get(500, TimeUnit.MILLISECONDS);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", e2.getMessage());
            }
            String str = this.jnU.size() + ";#";
            for (int i2 = 0; i2 < this.jnU.size(); i2++) {
                str = str + this.jnU.get(i2) + "#";
            }
            AppMethodBeat.o(151069);
            return str;
        }
    }

    class b {
        private HandlerThread handlerThread = null;
        long hwQ = 0;
        long jnG = 0;
        a jnH = null;
        a jnI = null;
        a jnJ = null;
        private Long jnK = null;
        ArrayList<Long> jnL = new ArrayList<>();
        ArrayList<a> jnM = new ArrayList<>();
        ArrayList<a> jnN = new ArrayList<>();
        ArrayList<a> jnO = new ArrayList<>();
        ArrayList<float[]> jnP = new ArrayList<>();
        private SensorEventListener jnQ = new SensorEventListener() {
            /* class com.tencent.mm.modelstat.e.b.AnonymousClass1 */

            public final void onAccuracyChanged(Sensor sensor, int i2) {
            }

            public final void onSensorChanged(SensorEvent sensorEvent) {
                AppMethodBeat.i(151062);
                if (sensorEvent == null) {
                    AppMethodBeat.o(151062);
                    return;
                }
                long nowMilliSecond = Util.nowMilliSecond();
                if (sensorEvent.sensor.getType() == 1) {
                    b.this.jnH = new a(sensorEvent);
                } else if (sensorEvent.sensor.getType() == 2) {
                    b.this.jnI = new a(sensorEvent);
                } else if (sensorEvent.sensor.getType() == 4) {
                    b.this.jnJ = new a(sensorEvent);
                }
                long j2 = nowMilliSecond - b.this.hwQ;
                if (!(b.this.jnH == null || b.this.jnI == null || b.this.jnJ == null || (j2 <= b.this.jnG && j2 >= 0))) {
                    float[] fArr = new float[9];
                    SensorManager.getRotationMatrix(fArr, null, b.this.jnH.values, b.this.jnI.values);
                    float[] fArr2 = new float[3];
                    SensorManager.getOrientation(fArr, fArr2);
                    b.this.hwQ = nowMilliSecond;
                    b.this.jnL.add(Long.valueOf(nowMilliSecond));
                    b.this.jnM.add(b.this.jnH);
                    b.this.jnN.add(b.this.jnI);
                    b.this.jnO.add(b.this.jnJ);
                    b.this.jnP.add(fArr2);
                    int size = b.this.jnM.size() - 1;
                    Log.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", Integer.valueOf(b.this.jnM.size()), Integer.valueOf(b.this.jnM.get(size).accuracy), Float.valueOf(b.this.jnM.get(size).values[0]), Float.valueOf(b.this.jnM.get(size).values[1]), Float.valueOf(b.this.jnM.get(size).values[2]));
                    Log.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", Long.valueOf(j2), Integer.valueOf(b.this.jnH.accuracy), Float.valueOf(b.this.jnH.values[0]), Float.valueOf(b.this.jnH.values[1]), Float.valueOf(b.this.jnH.values[2]), Integer.valueOf(b.this.jnI.accuracy), Float.valueOf(b.this.jnI.values[0]), Float.valueOf(b.this.jnI.values[1]), Float.valueOf(b.this.jnI.values[2]), Integer.valueOf(b.this.jnJ.accuracy), Float.valueOf(b.this.jnJ.values[0]), Float.valueOf(b.this.jnJ.values[1]), Float.valueOf(b.this.jnJ.values[2]), Float.valueOf(fArr2[0]), Float.valueOf(fArr2[1]), Float.valueOf(fArr2[2]));
                }
                AppMethodBeat.o(151062);
            }
        };
        private SensorManager sensorManager;

        b() {
            AppMethodBeat.i(151063);
            AppMethodBeat.o(151063);
        }

        public final boolean tT(int i2) {
            boolean z;
            AppMethodBeat.i(151064);
            try {
                if (this.sensorManager == null) {
                    this.sensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
                }
                if (this.handlerThread == null) {
                    this.handlerThread = d.hD("MicroMsg.IndoorReporter", 1);
                    this.handlerThread.start();
                }
                Handler handler = new Handler(this.handlerThread.getLooper());
                z = this.sensorManager.registerListener(this.jnQ, this.sensorManager.getDefaultSensor(1), 3, handler) && this.sensorManager.registerListener(this.jnQ, this.sensorManager.getDefaultSensor(4), 3, handler) && this.sensorManager.registerListener(this.jnQ, this.sensorManager.getDefaultSensor(2), 3, handler);
            } catch (Exception e2) {
                Log.e("MicroMsg.IndoorReporter", "start except:%s", e2.getMessage());
                z = false;
            }
            if (!z) {
                try {
                    if (this.sensorManager != null) {
                        this.sensorManager.unregisterListener(this.jnQ);
                        this.sensorManager = null;
                    }
                } catch (Exception e3) {
                }
                try {
                    if (this.handlerThread != null) {
                        this.handlerThread.quit();
                        this.handlerThread = null;
                    }
                } catch (Exception e4) {
                }
            }
            this.jnG = (long) i2;
            this.jnK = Long.valueOf(Util.nowMilliSecond());
            AppMethodBeat.o(151064);
            return z;
        }

        public final String bgf() {
            AppMethodBeat.i(151065);
            try {
                if (this.sensorManager != null) {
                    this.sensorManager.unregisterListener(this.jnQ);
                    this.sensorManager = null;
                }
            } catch (Exception e2) {
            }
            try {
                if (this.handlerThread != null) {
                    this.handlerThread.quit();
                    this.handlerThread = null;
                }
            } catch (Exception e3) {
            }
            Log.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", Integer.valueOf(this.jnL.size()));
            String str = this.jnK + ";" + this.jnL.size() + ";#";
            for (int i2 = 0; i2 < this.jnL.size(); i2++) {
                String str2 = (str + (this.jnL.get(i2).longValue() - this.jnK.longValue()) + ";") + a(this.jnM.get(i2));
                Log.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", Integer.valueOf(i2), Integer.valueOf(this.jnM.get(i2).accuracy), Float.valueOf(this.jnM.get(i2).values[0]), Float.valueOf(this.jnM.get(i2).values[1]), Float.valueOf(this.jnM.get(i2).values[2]), a(this.jnM.get(i2)));
                str = ((str2 + a(this.jnO.get(i2))) + a(this.jnN.get(i2))) + String.format("%.3f;%.3f;%.3f;#", Float.valueOf(this.jnP.get(i2)[0]), Float.valueOf(this.jnP.get(i2)[1]), Float.valueOf(this.jnP.get(i2)[2]));
            }
            Log.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", Integer.valueOf(str.length()), str);
            AppMethodBeat.o(151065);
            return str;
        }

        private static String a(a aVar) {
            AppMethodBeat.i(151066);
            try {
                new String();
                String format = String.format("%d;%.3f;%.3f;%.3f;", Integer.valueOf(aVar.accuracy), Float.valueOf(aVar.values[0]), Float.valueOf(aVar.values[1]), Float.valueOf(aVar.values[2]));
                AppMethodBeat.o(151066);
                return format;
            } catch (Exception e2) {
                AppMethodBeat.o(151066);
                return "0;0;0;0;";
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public int accuracy = 0;
        public float[] values;

        public a(SensorEvent sensorEvent) {
            AppMethodBeat.i(151061);
            if (sensorEvent != null) {
                this.accuracy = sensorEvent.accuracy;
                this.values = new float[sensorEvent.values.length];
                System.arraycopy(sensorEvent.values, 0, this.values, 0, sensorEvent.values.length);
            }
            AppMethodBeat.o(151061);
        }
    }

    static /* synthetic */ boolean F(float f2, float f3) {
        AppMethodBeat.i(151074);
        if (((double) Math.abs(f2 - f3)) < Math.pow(0.1d, 2.0d)) {
            AppMethodBeat.o(151074);
            return true;
        }
        AppMethodBeat.o(151074);
        return false;
    }
}
