package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.u;
import java.io.BufferedReader;

public final class TrafficStats {
    private static long CURRENT_TIMESTAMP = System.currentTimeMillis();
    public static final String DEV_FILE = "/proc/self/net/dev";
    public static final String GPRSLINE = "rmnet0";
    private static o NET_DEV_FILE = null;
    private static final String TAG = "MicroMsg.SDK.TrafficStats";
    public static final String WIFILINE = "tiwlan0";
    private static o XT_STATS_FILE;
    private static long lastMobileRx;
    private static long lastMobileTx;
    private static long lastWifiRx;
    private static long lastWifiTx;
    private static long lastWxMobileRx;
    private static long lastWxMobileTx;
    private static long lastWxWifiRx;
    private static long lastWxWifiTx;
    private static long mobileRx;
    private static long mobileTx;
    private static long wifiRx;
    private static long wifiTx;
    private static long wxMobileRx;
    private static long wxMobileTx;
    private static long wxWifiRx;
    private static long wxWifiTx;

    static {
        AppMethodBeat.i(157851);
        try {
            o oVar = new o("/proc/" + Process.myPid() + "/net/dev");
            if (!oVar.isFile()) {
                oVar = null;
            }
            NET_DEV_FILE = oVar;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "Failed init NET_DEV_FILE.", new Object[0]);
        }
        try {
            o oVar2 = new o("/proc/net/xt_qtaguid/stats");
            if (!oVar2.isFile()) {
                oVar2 = null;
            }
            XT_STATS_FILE = oVar2;
        } catch (Exception e3) {
            Log.printErrStackTrace(TAG, e3, "Failed init XT_STATS_FILE.", new Object[0]);
        }
        AppMethodBeat.o(157851);
    }

    private TrafficStats() {
    }

    public static long getWifiTx(long j2) {
        return wifiTx > j2 ? wifiTx : j2;
    }

    public static long getWifiRx(long j2) {
        return wifiRx > j2 ? wifiRx : j2;
    }

    public static long getMobileTx(long j2) {
        return mobileTx > j2 ? mobileTx : j2;
    }

    public static long getMobileRx(long j2) {
        return mobileRx > j2 ? mobileRx : j2;
    }

    public static long getWxWifiTx(long j2) {
        return wxWifiTx > j2 ? wxWifiTx : j2;
    }

    public static long getWxWifiRx(long j2) {
        return wxWifiRx > j2 ? wxWifiRx : j2;
    }

    public static long getWxMobileTx(long j2) {
        return wxMobileTx > j2 ? wxMobileTx : j2;
    }

    public static long getWxMobileRx(long j2) {
        return wxMobileRx > j2 ? wxMobileRx : j2;
    }

    public static long updateWifiTx(long j2) {
        AppMethodBeat.i(230402);
        update();
        long wifiTx2 = getWifiTx(j2);
        AppMethodBeat.o(230402);
        return wifiTx2;
    }

    public static long updateWifiRx(long j2) {
        AppMethodBeat.i(230403);
        update();
        long wifiRx2 = getWifiRx(j2);
        AppMethodBeat.o(230403);
        return wifiRx2;
    }

    public static long updateMobileTx(long j2) {
        AppMethodBeat.i(230404);
        update();
        long mobileTx2 = getMobileTx(j2);
        AppMethodBeat.o(230404);
        return mobileTx2;
    }

    public static long updateMobileRx(long j2) {
        AppMethodBeat.i(230405);
        update();
        long mobileRx2 = getMobileRx(j2);
        AppMethodBeat.o(230405);
        return mobileRx2;
    }

    public static void reset(Context context) {
        AppMethodBeat.i(230406);
        lastMobileTx = -1;
        lastMobileRx = -1;
        lastWifiTx = -1;
        lastWifiRx = -1;
        lastWxMobileRx = -1;
        lastWxMobileTx = -1;
        lastWxWifiRx = -1;
        lastWxWifiTx = -1;
        if (Build.VERSION.SDK_INT >= 28) {
            updateNsm(context);
            AppMethodBeat.o(230406);
            return;
        }
        updateFile();
        AppMethodBeat.o(230406);
    }

    public static void reset() {
        AppMethodBeat.i(157847);
        lastMobileTx = -1;
        lastMobileRx = -1;
        lastWifiTx = -1;
        lastWifiRx = -1;
        lastWxMobileRx = -1;
        lastWxMobileTx = -1;
        lastWxWifiRx = -1;
        lastWxWifiTx = -1;
        updateFile();
        AppMethodBeat.o(157847);
    }

    public static void updateFile() {
        Throwable th;
        long j2;
        long j3;
        long j4;
        Throwable th2;
        long j5;
        long j6;
        long j7;
        AppMethodBeat.i(157848);
        if (checkIfFrequently()) {
            Log.i(TAG, "updateFile frequently just return");
            AppMethodBeat.o(157848);
            return;
        }
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        BufferedReader bufferedReader = null;
        try {
            if (NET_DEV_FILE != null) {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new u(NET_DEV_FILE));
                    try {
                        bufferedReader2.readLine();
                        bufferedReader2.readLine();
                        long j13 = 0;
                        while (true) {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split("[ :\t]+");
                            int i2 = split[0].length() == 0 ? 1 : 0;
                            if (!split[i2 + 0].equals(LocaleUtil.LAO)) {
                                if (split[i2 + 0].startsWith("rmnet") || split[i2 + 0].startsWith("ccmni")) {
                                    j8 += Long.parseLong(split[i2 + 9]);
                                    j9 += Long.parseLong(split[i2 + 1]);
                                } else {
                                    j10 += Long.parseLong(split[i2 + 9]);
                                    j13 += Long.parseLong(split[i2 + 1]);
                                }
                            }
                        }
                        if (lastMobileTx < 0) {
                            lastMobileTx = j8;
                            Log.v(TAG, "fix loss newMobileTx %d", Long.valueOf(j8));
                        }
                        if (lastMobileRx < 0) {
                            lastMobileRx = j9;
                            Log.v(TAG, "fix loss newMobileRx %d", Long.valueOf(j9));
                        }
                        if (lastWifiTx < 0) {
                            lastWifiTx = j10;
                            Log.v(TAG, "fix loss newWifiTx %d", Long.valueOf(j10));
                        }
                        if (lastWifiRx < 0) {
                            lastWifiRx = j13;
                            Log.v(TAG, "fix loss newWifiRx %d", Long.valueOf(j13));
                        }
                        if (j13 - lastWifiRx < 0) {
                            Log.v(TAG, "minu %d", Long.valueOf(j13 - lastWifiRx));
                        }
                        if (j10 - lastWifiTx < 0) {
                            Log.v(TAG, "minu %d", Long.valueOf(j10 - lastWifiTx));
                        }
                        mobileTx = j8 >= lastMobileTx ? j8 - lastMobileTx : j8;
                        if (j9 >= lastMobileRx) {
                            j5 = j9 - lastMobileRx;
                        } else {
                            j5 = j9;
                        }
                        mobileRx = j5;
                        if (j10 >= lastWifiTx) {
                            j6 = j10 - lastWifiTx;
                        } else {
                            j6 = j10;
                        }
                        wifiTx = j6;
                        if (j13 >= lastWifiRx) {
                            j7 = j13 - lastWifiRx;
                        } else {
                            j7 = j13;
                        }
                        wifiRx = j7;
                        lastMobileTx = j8;
                        lastMobileRx = j9;
                        lastWifiTx = j10;
                        lastWifiRx = j13;
                        Util.qualityClose(bufferedReader2);
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th2 = th3;
                        bufferedReader = bufferedReader2;
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(157848);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(157848);
                    throw th2;
                }
            }
            if (XT_STATS_FILE != null) {
                try {
                    int myUid = Process.myUid();
                    BufferedReader bufferedReader3 = new BufferedReader(new u(XT_STATS_FILE));
                    try {
                        bufferedReader3.readLine();
                        long j14 = 0;
                        long j15 = 0;
                        while (true) {
                            String readLine2 = bufferedReader3.readLine();
                            if (readLine2 == null) {
                                break;
                            }
                            String[] split2 = readLine2.split("[ :\\t]+");
                            if (Integer.parseInt(split2[3]) == myUid) {
                                String str = split2[1];
                                long parseLong = Long.parseLong(split2[5]);
                                long parseLong2 = Long.parseLong(split2[7]);
                                if (str.startsWith("rmnet") || str.startsWith("ccmni")) {
                                    j12 += parseLong;
                                    j11 += parseLong2;
                                } else if (!str.equals(LocaleUtil.LAO)) {
                                    j14 += parseLong;
                                    j15 += parseLong2;
                                }
                            }
                        }
                        if (lastWxMobileRx < 0) {
                            lastWxMobileRx = j12;
                        }
                        if (lastWxMobileTx < 0) {
                            lastWxMobileTx = j11;
                        }
                        if (lastWxWifiRx < 0) {
                            lastWxWifiRx = j14;
                        }
                        if (lastWxWifiTx < 0) {
                            lastWxWifiTx = j15;
                        }
                        wxMobileTx = j11 >= lastWxMobileTx ? j11 - lastWxMobileTx : j11;
                        if (j12 >= lastWxMobileRx) {
                            j2 = j12 - lastWxMobileRx;
                        } else {
                            j2 = j12;
                        }
                        wxMobileRx = j2;
                        if (j15 >= lastWxWifiTx) {
                            j3 = j15 - lastWxWifiTx;
                        } else {
                            j3 = j15;
                        }
                        wxWifiTx = j3;
                        if (j14 >= lastWxWifiRx) {
                            j4 = j14 - lastWxWifiRx;
                        } else {
                            j4 = j14;
                        }
                        wxWifiRx = j4;
                        lastWxMobileTx = j11;
                        lastWxMobileRx = j12;
                        lastWxWifiTx = j15;
                        lastWxWifiRx = j14;
                        Util.qualityClose(bufferedReader3);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader3;
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(157848);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(157848);
                    throw th;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "Failed retrieving TrafficStats.", new Object[0]);
        }
        Log.i(TAG, "updateFile current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", Long.valueOf(wifiRx), Long.valueOf(wifiTx), Long.valueOf(mobileRx), Long.valueOf(mobileTx), Long.valueOf(wxWifiRx), Long.valueOf(wxWifiTx), Long.valueOf(wxMobileRx), Long.valueOf(wxMobileTx));
        AppMethodBeat.o(157848);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02e4  */
    @android.annotation.TargetApi(23)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void updateNsm(android.content.Context r34) {
        /*
        // Method dump skipped, instructions count: 773
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.TrafficStats.updateNsm(android.content.Context):void");
    }

    private static boolean checkIfFrequently() {
        AppMethodBeat.i(182968);
        if (System.currentTimeMillis() - CURRENT_TIMESTAMP < 2000) {
            AppMethodBeat.o(182968);
            return true;
        }
        CURRENT_TIMESTAMP = System.currentTimeMillis();
        AppMethodBeat.o(182968);
        return false;
    }

    public static void update() {
        AppMethodBeat.i(157850);
        updateFile();
        AppMethodBeat.o(157850);
    }

    public static void update(String str, Context context) {
        AppMethodBeat.i(230408);
        if (Build.VERSION.SDK_INT >= 28) {
            updateNsm(context);
            AppMethodBeat.o(230408);
            return;
        }
        updateFile();
        AppMethodBeat.o(230408);
    }
}
