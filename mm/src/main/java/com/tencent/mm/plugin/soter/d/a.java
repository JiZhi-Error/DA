package com.tencent.mm.plugin.soter.d;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class a {
    private static int FhS = -1;
    private static int FhT = -1;

    public static void aat(int i2) {
        FhS = i2;
    }

    public static void flI() {
        AppMethodBeat.i(130826);
        if (FhS == -1) {
            Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.o(130826);
            return;
        }
        h.INSTANCE.a(12925, Integer.valueOf(FhS));
        AppMethodBeat.o(130826);
    }

    public static void flJ() {
        AppMethodBeat.i(130827);
        if (FhS == -1) {
            Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.o(130827);
            return;
        }
        h.INSTANCE.a(12926, Integer.valueOf(FhS));
        AppMethodBeat.o(130827);
    }

    public static void d(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(130828);
        if (FhS == -1) {
            Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.o(130828);
            return;
        }
        h.INSTANCE.a(13413, Integer.valueOf(FhS), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        FhS = -1;
        AppMethodBeat.o(130828);
    }

    public static void e(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(130829);
        if (FhS == -1) {
            Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.o(130829);
            return;
        }
        h.INSTANCE.a(16992, Integer.valueOf(FhS), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        AppMethodBeat.o(130829);
    }

    public static void flK() {
        AppMethodBeat.i(130830);
        FhT = (int) (System.currentTimeMillis() / 1000);
        AppMethodBeat.o(130830);
    }

    public static void aau(int i2) {
        AppMethodBeat.i(130831);
        if (FhT == -1) {
            Log.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            AppMethodBeat.o(130831);
            return;
        }
        h.INSTANCE.a(12927, Integer.valueOf(FhT), Integer.valueOf(i2));
        FhT = -1;
        AppMethodBeat.o(130831);
    }

    public static void aav(int i2) {
        AppMethodBeat.i(130832);
        if (FhT == -1) {
            Log.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            AppMethodBeat.o(130832);
            return;
        }
        h.INSTANCE.a(16995, Integer.valueOf(FhT), Integer.valueOf(i2));
        FhT = -1;
        AppMethodBeat.o(130832);
    }

    public static void ja(int i2, int i3) {
        AppMethodBeat.i(130833);
        Log.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        h.INSTANCE.a(14381, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(130833);
    }

    public static void n(int i2, int i3, long j2) {
        int i4;
        AppMethodBeat.i(130834);
        switch (i3) {
            case -3:
                if (i2 == 1) {
                    i4 = 12;
                    break;
                }
                i4 = -1;
                break;
            case -2:
                if (i2 == 1) {
                    i4 = 11;
                    break;
                }
                i4 = -1;
                break;
            case 4:
                if (!ae.gKz.edB) {
                    i4 = 8;
                    break;
                } else {
                    i4 = 7;
                    break;
                }
            case 6:
                i4 = 3;
                break;
            case 1001:
                i4 = 5;
                break;
            case 1003:
                if (!ae.gKz.edB) {
                    i4 = 10;
                    break;
                } else {
                    i4 = 9;
                    break;
                }
            case 1004:
                i4 = 4;
                break;
            case TXLiteAVCode.EVT_CAMERA_REMOVED:
                if (i2 == 3) {
                    i4 = 0;
                    break;
                }
                i4 = -1;
                break;
            default:
                i4 = -1;
                break;
        }
        if (i4 != -1) {
            Log.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", 672, Integer.valueOf(i4), Long.valueOf(j2));
            h.INSTANCE.idkeyStat(672, (long) i4, j2, false);
        }
        AppMethodBeat.o(130834);
    }

    public static void aaw(int i2) {
        AppMethodBeat.i(130835);
        String stackTraceToString = Util.stackTraceToString(new Throwable());
        Log.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", 3, Integer.valueOf(i2), stackTraceToString);
        HashMap hashMap = new HashMap();
        hashMap.put("sceneType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        hashMap.put("scene", String.valueOf(i2));
        h.INSTANCE.e("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(stackTraceToString)), hashMap);
        AppMethodBeat.o(130835);
    }

    public static void t(int i2, String str, int i3) {
        AppMethodBeat.i(130836);
        h.INSTANCE.a(17806, Integer.valueOf(i2), str, Integer.valueOf(i3));
        AppMethodBeat.o(130836);
    }

    public static void cx(int i2, String str) {
        AppMethodBeat.i(130837);
        h.INSTANCE.a(17805, Integer.valueOf(i2), str);
        AppMethodBeat.o(130837);
    }

    public static void flL() {
        AppMethodBeat.i(192230);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.soter.d.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(192229);
                String aUb = z.aUb();
                if (!Util.isNullOrNil(m.Fib) && !m.Fib.equals(aUb)) {
                    g.aAi();
                    boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                    String aay = m.aay(1);
                    String aax = m.aax(1);
                    boolean bqh = com.tencent.soter.core.a.bqh(aay);
                    boolean bqh2 = com.tencent.soter.core.a.bqh(aax);
                    if (booleanValue && !bqh && bqh2) {
                        boolean bqh3 = com.tencent.soter.core.a.bqh(m.flR());
                        Log.i("MicroMsg.FingerpirntReporter", "report key valid before pay: %s", Boolean.valueOf(bqh3));
                        if (bqh3) {
                            h.INSTANCE.dN(1104, 50);
                            AppMethodBeat.o(192229);
                            return;
                        }
                        h.INSTANCE.dN(1104, 49);
                    }
                }
                AppMethodBeat.o(192229);
            }
        });
        AppMethodBeat.o(192230);
    }
}
