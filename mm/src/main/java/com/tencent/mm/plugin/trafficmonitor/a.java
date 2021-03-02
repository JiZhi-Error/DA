package com.tencent.mm.plugin.trafficmonitor;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.u;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<Integer, Long> Gsk = new HashMap();
    private static Map<Integer, Long> Gsl = new HashMap();
    private static Map<Integer, Long> Gsm = new HashMap();
    private static Map<Integer, Long> Gsn = new HashMap();
    private static Map<Integer, Long> Gso = new HashMap();
    private static Map<Integer, Long> Gsp = new HashMap();
    private static Map<Integer, Long> Gsq = new HashMap();
    private static Map<Integer, Long> Gsr = new HashMap();
    private static Map<Integer, Long> Gss = new HashMap();
    private static Map<Integer, Long> Gst = new HashMap();
    private static Map<Integer, Long> Gsu = new HashMap();
    private static Map<Integer, Long> Gsv = new HashMap();
    private static Map<Integer, Long> Gsw = new HashMap();
    private static Map<Integer, Long> Gsx = new HashMap();
    private static Map<Integer, Long> Gsy = new HashMap();
    private static Map<Integer, Long> Gsz = new HashMap();
    private static final o NET_DEV_FILE;
    private static final o XT_STATS_FILE;

    static {
        o oVar = null;
        AppMethodBeat.i(123887);
        o oVar2 = new o("/proc/" + Process.myPid() + "/net/dev");
        if (!oVar2.isFile()) {
            oVar2 = null;
        }
        NET_DEV_FILE = oVar2;
        o oVar3 = new o("/proc/net/xt_qtaguid/stats");
        if (oVar3.isFile()) {
            oVar = oVar3;
        }
        XT_STATS_FILE = oVar;
        AppMethodBeat.o(123887);
    }

    public static void init(int i2) {
        AppMethodBeat.i(123878);
        Gss.put(Integer.valueOf(i2), 0L);
        Gst.put(Integer.valueOf(i2), 0L);
        Gsu.put(Integer.valueOf(i2), 0L);
        Gsv.put(Integer.valueOf(i2), 0L);
        Gsw.put(Integer.valueOf(i2), 0L);
        Gsx.put(Integer.valueOf(i2), 0L);
        Gsy.put(Integer.valueOf(i2), 0L);
        Gsz.put(Integer.valueOf(i2), 0L);
        Gsk.put(Integer.valueOf(i2), 0L);
        Gsl.put(Integer.valueOf(i2), 0L);
        Gsm.put(Integer.valueOf(i2), 0L);
        Gsn.put(Integer.valueOf(i2), 0L);
        Gso.put(Integer.valueOf(i2), 0L);
        Gsp.put(Integer.valueOf(i2), 0L);
        Gsq.put(Integer.valueOf(i2), 0L);
        Gsr.put(Integer.valueOf(i2), 0L);
        AppMethodBeat.o(123878);
    }

    public static long ach(int i2) {
        AppMethodBeat.i(123879);
        if (Gso == null) {
            AppMethodBeat.o(123879);
            return 0;
        } else if (Gso.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123879);
            return 0;
        } else if (Gso.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gso.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123879);
            return longValue;
        } else {
            AppMethodBeat.o(123879);
            return 0;
        }
    }

    public static long aci(int i2) {
        AppMethodBeat.i(123880);
        if (Gsp == null) {
            AppMethodBeat.o(123880);
            return 0;
        } else if (Gsp.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123880);
            return 0;
        } else if (Gsp.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsp.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123880);
            return longValue;
        } else {
            AppMethodBeat.o(123880);
            return 0;
        }
    }

    public static long acj(int i2) {
        AppMethodBeat.i(123881);
        if (Gsy == null) {
            AppMethodBeat.o(123881);
            return 0;
        } else if (Gsy.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123881);
            return 0;
        } else if (Gsy.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsy.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123881);
            return longValue;
        } else {
            AppMethodBeat.o(123881);
            return 0;
        }
    }

    public static long ack(int i2) {
        AppMethodBeat.i(123882);
        if (Gsz == null) {
            AppMethodBeat.o(123882);
            return 0;
        } else if (Gsz.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123882);
            return 0;
        } else if (Gsz.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsz.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123882);
            return longValue;
        } else {
            AppMethodBeat.o(123882);
            return 0;
        }
    }

    public static long acl(int i2) {
        AppMethodBeat.i(123883);
        if (Gsw == null) {
            AppMethodBeat.o(123883);
            return 0;
        } else if (Gsw.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123883);
            return 0;
        } else if (Gsw.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsw.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123883);
            return longValue;
        } else {
            AppMethodBeat.o(123883);
            return 0;
        }
    }

    public static long acm(int i2) {
        AppMethodBeat.i(123884);
        if (Gsx == null) {
            AppMethodBeat.o(123884);
            return 0;
        } else if (Gsx.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(123884);
            return 0;
        } else if (Gsx.get(Integer.valueOf(i2)).longValue() > 0) {
            long longValue = Gsx.get(Integer.valueOf(i2)).longValue();
            AppMethodBeat.o(123884);
            return longValue;
        } else {
            AppMethodBeat.o(123884);
            return 0;
        }
    }

    public static void reset(int i2) {
        AppMethodBeat.i(123885);
        Gst.put(Integer.valueOf(i2), -1L);
        Gss.put(Integer.valueOf(i2), -1L);
        Gsv.put(Integer.valueOf(i2), -1L);
        Gsu.put(Integer.valueOf(i2), -1L);
        Gsl.put(Integer.valueOf(i2), -1L);
        Gsk.put(Integer.valueOf(i2), -1L);
        Gsn.put(Integer.valueOf(i2), -1L);
        Gsm.put(Integer.valueOf(i2), -1L);
        update(i2);
        AppMethodBeat.o(123885);
    }

    public static void update(int i2) {
        BufferedReader bufferedReader;
        Throwable th;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        AppMethodBeat.i(123886);
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            if (NET_DEV_FILE != null) {
                bufferedReader = new BufferedReader(new u(NET_DEV_FILE));
                try {
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("[ :\t]+");
                        int i3 = split[0].length() == 0 ? 1 : 0;
                        if (split[i3 + 0].equals(LocaleUtil.LAO)) {
                            j9 = j13;
                        } else if (split[i3 + 0].startsWith("rmnet") || split[i3 + 0].startsWith("ccmni")) {
                            j10 += Util.getLong(split[i3 + 9], 0);
                            j11 += Util.getLong(split[i3 + 1], 0);
                        } else {
                            j12 += Util.getLong(split[i3 + 9], 0);
                            j9 = Util.getLong(split[i3 + 1], 0) + j13;
                        }
                        j13 = j9;
                    }
                    if (Gsk.get(Integer.valueOf(i2)).longValue() < 0) {
                        Gsk.put(Integer.valueOf(i2), Long.valueOf(j10));
                    }
                    if (Gsl.get(Integer.valueOf(i2)).longValue() < 0) {
                        Gsl.put(Integer.valueOf(i2), Long.valueOf(j11));
                    }
                    if (Gsm.get(Integer.valueOf(i2)).longValue() < 0) {
                        Gsm.put(Integer.valueOf(i2), Long.valueOf(j12));
                    }
                    if (Gsn.get(Integer.valueOf(i2)).longValue() < 0) {
                        Gsn.put(Integer.valueOf(i2), Long.valueOf(j13));
                    }
                    Gso.put(Integer.valueOf(i2), Long.valueOf(j10 >= Gsk.get(Integer.valueOf(i2)).longValue() ? j10 - Gsk.get(Integer.valueOf(i2)).longValue() : j10));
                    Map<Integer, Long> map = Gsp;
                    Integer valueOf = Integer.valueOf(i2);
                    if (j11 >= Gsl.get(Integer.valueOf(i2)).longValue()) {
                        j6 = j11 - Gsl.get(Integer.valueOf(i2)).longValue();
                    } else {
                        j6 = j11;
                    }
                    map.put(valueOf, Long.valueOf(j6));
                    Map<Integer, Long> map2 = Gsq;
                    Integer valueOf2 = Integer.valueOf(i2);
                    if (j12 >= Gsm.get(Integer.valueOf(i2)).longValue()) {
                        j7 = j12 - Gsm.get(Integer.valueOf(i2)).longValue();
                    } else {
                        j7 = j12;
                    }
                    map2.put(valueOf2, Long.valueOf(j7));
                    Map<Integer, Long> map3 = Gsr;
                    Integer valueOf3 = Integer.valueOf(i2);
                    if (j13 >= Gsn.get(Integer.valueOf(i2)).longValue()) {
                        j8 = j13 - Gsn.get(Integer.valueOf(i2)).longValue();
                    } else {
                        j8 = j13;
                    }
                    map3.put(valueOf3, Long.valueOf(j8));
                    Gsk.put(Integer.valueOf(i2), Long.valueOf(j10));
                    Gsl.put(Integer.valueOf(i2), Long.valueOf(j11));
                    Gsm.put(Integer.valueOf(i2), Long.valueOf(j12));
                    Gsn.put(Integer.valueOf(i2), Long.valueOf(j13));
                    Util.qualityClose(bufferedReader);
                    bufferedReader2 = bufferedReader;
                } catch (Exception e2) {
                    try {
                        Gsw.put(Integer.valueOf(i2), 0L);
                        Gsx.put(Integer.valueOf(i2), 0L);
                        Gsy.put(Integer.valueOf(i2), 0L);
                        Gsz.put(Integer.valueOf(i2), 0L);
                        Gss.put(Integer.valueOf(i2), -1L);
                        Gst.put(Integer.valueOf(i2), -1L);
                        Gsu.put(Integer.valueOf(i2), -1L);
                        Gsv.put(Integer.valueOf(i2), -1L);
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(123886);
                    } catch (Throwable th2) {
                        th = th2;
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(123886);
                        throw th;
                    }
                }
            }
            try {
                if (XT_STATS_FILE != null) {
                    int myUid = Process.myUid();
                    BufferedReader bufferedReader3 = new BufferedReader(new u(XT_STATS_FILE));
                    bufferedReader3.readLine();
                    long j16 = 0;
                    long j17 = 0;
                    while (true) {
                        String readLine2 = bufferedReader3.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        String[] split2 = readLine2.split("[ :\\t]+");
                        if (Util.getInt(split2[3], 0) == myUid) {
                            String str = split2[1];
                            long j18 = Util.getLong(split2[5], 0);
                            long j19 = Util.getLong(split2[7], 0);
                            if (str.startsWith("rmnet") || str.startsWith("ccmni")) {
                                j15 += j18;
                                j14 += j19;
                            } else {
                                if (!str.equals(LocaleUtil.LAO)) {
                                    j5 = j16 + j18;
                                    j17 += j19;
                                } else {
                                    j5 = j16;
                                }
                                j16 = j5;
                            }
                        }
                    }
                    if (Gst.get(Integer.valueOf(i2)).longValue() < 0) {
                        Gst.put(Integer.valueOf(i2), Long.valueOf(j15));
                    }
                    if (Gss.get(Integer.valueOf(i2)).longValue() < 0) {
                        Gss.put(Integer.valueOf(i2), Long.valueOf(j14));
                    }
                    if (Gsv.get(Integer.valueOf(i2)).longValue() < 0) {
                        Gsv.put(Integer.valueOf(i2), Long.valueOf(j16));
                    }
                    if (Gsu.get(Integer.valueOf(i2)).longValue() < 0) {
                        Gsu.put(Integer.valueOf(i2), Long.valueOf(j17));
                    }
                    Gsw.put(Integer.valueOf(i2), Long.valueOf(j14 >= Gss.get(Integer.valueOf(i2)).longValue() ? j14 - Gss.get(Integer.valueOf(i2)).longValue() : j14));
                    Map<Integer, Long> map4 = Gsx;
                    Integer valueOf4 = Integer.valueOf(i2);
                    if (j15 >= Gst.get(Integer.valueOf(i2)).longValue()) {
                        j2 = j15 - Gst.get(Integer.valueOf(i2)).longValue();
                    } else {
                        j2 = j15;
                    }
                    map4.put(valueOf4, Long.valueOf(j2));
                    Map<Integer, Long> map5 = Gsy;
                    Integer valueOf5 = Integer.valueOf(i2);
                    if (j17 >= Gsu.get(Integer.valueOf(i2)).longValue()) {
                        j3 = j17 - Gsu.get(Integer.valueOf(i2)).longValue();
                    } else {
                        j3 = j17;
                    }
                    map5.put(valueOf5, Long.valueOf(j3));
                    Map<Integer, Long> map6 = Gsz;
                    Integer valueOf6 = Integer.valueOf(i2);
                    if (j16 >= Gsv.get(Integer.valueOf(i2)).longValue()) {
                        j4 = j16 - Gsv.get(Integer.valueOf(i2)).longValue();
                    } else {
                        j4 = j16;
                    }
                    map6.put(valueOf6, Long.valueOf(j4));
                    Gss.put(Integer.valueOf(i2), Long.valueOf(j14));
                    Gst.put(Integer.valueOf(i2), Long.valueOf(j15));
                    Gsu.put(Integer.valueOf(i2), Long.valueOf(j17));
                    Gsv.put(Integer.valueOf(i2), Long.valueOf(j16));
                    Util.qualityClose(bufferedReader3);
                    bufferedReader2 = bufferedReader3;
                }
                Util.qualityClose(bufferedReader2);
                AppMethodBeat.o(123886);
            } catch (Exception e3) {
                bufferedReader = bufferedReader2;
                Gsw.put(Integer.valueOf(i2), 0L);
                Gsx.put(Integer.valueOf(i2), 0L);
                Gsy.put(Integer.valueOf(i2), 0L);
                Gsz.put(Integer.valueOf(i2), 0L);
                Gss.put(Integer.valueOf(i2), -1L);
                Gst.put(Integer.valueOf(i2), -1L);
                Gsu.put(Integer.valueOf(i2), -1L);
                Gsv.put(Integer.valueOf(i2), -1L);
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(123886);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(123886);
                throw th;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            Gsw.put(Integer.valueOf(i2), 0L);
            Gsx.put(Integer.valueOf(i2), 0L);
            Gsy.put(Integer.valueOf(i2), 0L);
            Gsz.put(Integer.valueOf(i2), 0L);
            Gss.put(Integer.valueOf(i2), -1L);
            Gst.put(Integer.valueOf(i2), -1L);
            Gsu.put(Integer.valueOf(i2), -1L);
            Gsv.put(Integer.valueOf(i2), -1L);
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(123886);
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(123886);
            throw th;
        }
    }
}
