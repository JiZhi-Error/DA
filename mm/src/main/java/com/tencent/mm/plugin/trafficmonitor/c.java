package com.tencent.mm.plugin.trafficmonitor;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<Integer, Long> Gss = new HashMap();
    private static Map<Integer, Long> Gst = new HashMap();
    private static Map<Integer, Long> Gsu = new HashMap();
    private static Map<Integer, Long> Gsv = new HashMap();
    private static Map<Integer, Long> Gsw = new HashMap();
    private static Map<Integer, Long> Gsx = new HashMap();
    private static Map<Integer, Long> Gsy = new HashMap();
    private static Map<Integer, Long> Gsz = new HashMap();

    static {
        AppMethodBeat.i(123897);
        AppMethodBeat.o(123897);
    }

    public static void init(int i2) {
        AppMethodBeat.i(123890);
        Gss.put(Integer.valueOf(i2), 0L);
        Gst.put(Integer.valueOf(i2), 0L);
        Gsu.put(Integer.valueOf(i2), 0L);
        Gsv.put(Integer.valueOf(i2), 0L);
        Gsw.put(Integer.valueOf(i2), 0L);
        Gsx.put(Integer.valueOf(i2), 0L);
        Gsy.put(Integer.valueOf(i2), 0L);
        Gsz.put(Integer.valueOf(i2), 0L);
        AppMethodBeat.o(123890);
    }

    public static void reset(int i2) {
        AppMethodBeat.i(123891);
        Gst.put(Integer.valueOf(i2), -1L);
        Gss.put(Integer.valueOf(i2), -1L);
        Gsv.put(Integer.valueOf(i2), -1L);
        Gsu.put(Integer.valueOf(i2), -1L);
        AppMethodBeat.o(123891);
    }

    public static long acj(int i2) {
        AppMethodBeat.i(123892);
        if (Gsy == null) {
            AppMethodBeat.o(123892);
            return 0;
        } else if (Gsy.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123892);
            return 0;
        } else if (Gsy.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsy.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123892);
            return longValue;
        } else {
            AppMethodBeat.o(123892);
            return 0;
        }
    }

    public static long ack(int i2) {
        AppMethodBeat.i(123893);
        if (Gsz == null) {
            AppMethodBeat.o(123893);
            return 0;
        } else if (Gsz.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123893);
            return 0;
        } else if (Gsz.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsz.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123893);
            return longValue;
        } else {
            AppMethodBeat.o(123893);
            return 0;
        }
    }

    public static long acl(int i2) {
        AppMethodBeat.i(123894);
        if (Gsw == null) {
            AppMethodBeat.o(123894);
            return 0;
        } else if (Gsw.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123894);
            return 0;
        } else if (Gsw.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsw.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123894);
            return longValue;
        } else {
            AppMethodBeat.o(123894);
            return 0;
        }
    }

    public static long acm(int i2) {
        AppMethodBeat.i(123895);
        if (Gsx == null) {
            AppMethodBeat.o(123895);
            return 0;
        } else if (Gsx.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123895);
            return 0;
        } else if (Gsx.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsx.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123895);
            return longValue;
        } else {
            AppMethodBeat.o(123895);
            return 0;
        }
    }

    @TargetApi(23)
    public static void update(int i2) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        AppMethodBeat.i(123896);
        long j9 = 0;
        NetworkStatsManager networkStatsManager = (NetworkStatsManager) MMApplicationContext.getContext().getSystemService("netstats");
        if (networkStatsManager == null) {
            AppMethodBeat.o(123896);
            return;
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        try {
            NetworkStats querySummary = networkStatsManager.querySummary(1, null, 0, System.currentTimeMillis());
            long j10 = 0;
            long j11 = 0;
            while (querySummary.hasNextBucket()) {
                querySummary.getNextBucket(bucket);
                if (bucket.getUid() == Process.myUid()) {
                    j11 += bucket.getRxBytes();
                    j10 += bucket.getTxBytes();
                }
            }
            long j12 = 0 + j11;
            long j13 = 0 + j10;
            if (!b.n(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE")) {
                init(i2);
                AppMethodBeat.o(123896);
                return;
            }
            NetworkStats querySummary2 = networkStatsManager.querySummary(0, null, 0, System.currentTimeMillis());
            long j14 = 0;
            long j15 = 0;
            while (querySummary2.hasNextBucket()) {
                querySummary2.getNextBucket(bucket);
                if (bucket.getUid() == Process.myUid()) {
                    j15 += bucket.getRxBytes();
                    j14 = bucket.getTxBytes() + j14;
                }
            }
            long j16 = 0 + j15;
            long j17 = 0 + j14;
            j3 = j12;
            j2 = j13;
            j4 = j16;
            j9 = j17;
            if (Gst.get(Integer.valueOf(i2)).longValue() < 0) {
                Gst.put(Integer.valueOf(i2), Long.valueOf(j4));
            }
            if (Gss.get(Integer.valueOf(i2)).longValue() < 0) {
                Gss.put(Integer.valueOf(i2), Long.valueOf(j9));
            }
            if (Gsv.get(Integer.valueOf(i2)).longValue() < 0) {
                Gsv.put(Integer.valueOf(i2), Long.valueOf(j3));
            }
            if (Gsu.get(Integer.valueOf(i2)).longValue() < 0) {
                Gsu.put(Integer.valueOf(i2), Long.valueOf(j2));
            }
            Map<Integer, Long> map = Gsw;
            Integer valueOf = Integer.valueOf(i2);
            if (j9 >= Gss.get(Integer.valueOf(i2)).longValue()) {
                j5 = j9 - Gss.get(Integer.valueOf(i2)).longValue();
            } else {
                j5 = j9;
            }
            map.put(valueOf, Long.valueOf(j5));
            Map<Integer, Long> map2 = Gsx;
            Integer valueOf2 = Integer.valueOf(i2);
            if (j4 >= Gst.get(Integer.valueOf(i2)).longValue()) {
                j6 = j4 - Gst.get(Integer.valueOf(i2)).longValue();
            } else {
                j6 = j4;
            }
            map2.put(valueOf2, Long.valueOf(j6));
            Map<Integer, Long> map3 = Gsy;
            Integer valueOf3 = Integer.valueOf(i2);
            if (j2 >= Gsu.get(Integer.valueOf(i2)).longValue()) {
                j7 = j2 - Gsu.get(Integer.valueOf(i2)).longValue();
            } else {
                j7 = j2;
            }
            map3.put(valueOf3, Long.valueOf(j7));
            Map<Integer, Long> map4 = Gsz;
            Integer valueOf4 = Integer.valueOf(i2);
            if (j3 >= Gsv.get(Integer.valueOf(i2)).longValue()) {
                j8 = j3 - Gsv.get(Integer.valueOf(i2)).longValue();
            } else {
                j8 = j3;
            }
            map4.put(valueOf4, Long.valueOf(j8));
            Gss.put(Integer.valueOf(i2), Long.valueOf(j9));
            Gst.put(Integer.valueOf(i2), Long.valueOf(j4));
            Gsu.put(Integer.valueOf(i2), Long.valueOf(j2));
            Gsv.put(Integer.valueOf(i2), Long.valueOf(j3));
            AppMethodBeat.o(123896);
        } catch (Exception e2) {
            j2 = 0;
            Gsw.put(Integer.valueOf(i2), 0L);
            Gsx.put(Integer.valueOf(i2), 0L);
            Gsy.put(Integer.valueOf(i2), 0L);
            Gsz.put(Integer.valueOf(i2), 0L);
            Gss.put(Integer.valueOf(i2), -1L);
            Gst.put(Integer.valueOf(i2), -1L);
            Gsu.put(Integer.valueOf(i2), -1L);
            Gsv.put(Integer.valueOf(i2), -1L);
            Log.e("NsmTrafficStats", "query traffic stats failed, e = " + e2.getMessage());
            j3 = 0;
            j4 = 0;
        }
    }
}
