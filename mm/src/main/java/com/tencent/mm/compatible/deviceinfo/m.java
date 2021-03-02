package com.tencent.mm.compatible.deviceinfo;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.BufferedReader;

public final class m {
    static int gHQ = 0;
    static String gHR = null;

    public static int aon() {
        int i2;
        int i3;
        int i4 = 15;
        AppMethodBeat.i(155662);
        if (n.aot()) {
            i2 = 7;
        } else {
            i2 = n.aou() ? 3 : 1;
        }
        if (ae.gKs.gHT && ae.gKs.gHV == 0) {
            Log.d("MicroMsg.CpuChecker", "disable armv6 by server ");
            i2 &= -3;
        }
        if (ae.gKs.gHT && ae.gKs.gHU == 0) {
            Log.d("MicroMsg.CpuChecker", "disable armv7 by server ");
            i2 &= -5;
        }
        int numCores = n.getNumCores();
        if (numCores > 16) {
            numCores = 15;
        } else if (numCores <= 0) {
            numCores = 1;
        }
        int i5 = Util.getInt(aoo(), 0) / 1000;
        if (numCores >= 8) {
            i3 = i5 * 4;
        } else if (numCores >= 4) {
            i3 = i5 * 2;
        } else if (numCores > 1) {
            i3 = (i5 * 3) >> 1;
        } else {
            i3 = i5;
        }
        int i6 = i3 / 100;
        if (i6 > 200) {
            i6 = 200;
        } else if (i6 < 5) {
            i6 = 5;
        }
        if (i6 > 5 || numCores < 4) {
            i4 = i6;
        }
        int i7 = ((i2 + (numCores << 4)) << 8) + i4;
        gHQ = i7;
        AppMethodBeat.o(155662);
        return i7;
    }

    public static String aoo() {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(155663);
        try {
            bufferedReader = new BufferedReader(new u("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    NullPointerException nullPointerException = new NullPointerException("null was returned while reading cpuinfo_max_freq.");
                    AppMethodBeat.o(155663);
                    throw nullPointerException;
                }
                String trim = readLine.trim();
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(155663);
                return trim;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(155663);
                    return AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } catch (Throwable th3) {
                    th = th3;
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(155663);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(155663);
            throw th;
        }
    }

    public static String aop() {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(155665);
        try {
            bufferedReader = new BufferedReader(new u("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    NullPointerException nullPointerException = new NullPointerException("null was returned while reading scaling_cur_freq.");
                    AppMethodBeat.o(155665);
                    throw nullPointerException;
                }
                String trim = readLine.trim();
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(155665);
                return trim;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(155665);
                    return AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(155665);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            Log.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(155665);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(155665);
            throw th;
        }
    }
}
