package com.tencent.mm.blink;

import android.os.SystemClock;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public final class a {
    private static boolean gkA = false;
    private static long gkB = 0;
    private static long gkC = 0;
    private static long gkD = 0;
    private static long gkE = 0;
    private static byte gkF = 0;
    public static final int[] gkd = {0, 1, 2};
    public static final int[] gke = {3, 13, 23};
    public static final int[] gkf = {4, 14, 24};
    public static final int[] gkg = {5, 15, 25};
    public static final int[] gkh = {6, 16, 26};
    public static final int[] gki = {7, 17, 27};
    public static final int[] gkj = {8, 18, 28};
    public static final int[] gkk = {9, 19, 29};
    public static final int[] gkl = {63, 69, 75};
    public static final int[] gkm = {64, 70, 76};
    public static final int[] gkn = {65, 71, 77};
    public static final int[] gko = {66, 72, 78};
    private static final int[] gkp = {0};
    private static final int[] gkq = {3};
    private static final int[] gkr = {9};
    private static final int[] gks = {10};
    private static final int[] gkt = {11};
    private static final int[] gku = {12};
    private static final int[] gkv = {13};
    private static final int[] gkw = {14};
    private static final ArrayList<long[]> gkx = new ArrayList<>();
    private static final ArrayList<Object[]> gky = new ArrayList<>();
    private static long gkz = 0;

    public static void r(long j2, long j3) {
        AppMethodBeat.i(131796);
        j.r(j2, j3);
        AppMethodBeat.o(131796);
    }

    public static void q(String str, long j2) {
        AppMethodBeat.i(131797);
        j.q(str, j2);
        AppMethodBeat.o(131797);
    }

    public static void CM(String str) {
        AppMethodBeat.i(131798);
        j.FT(str);
        AppMethodBeat.o(131798);
    }

    static {
        AppMethodBeat.i(131814);
        AppMethodBeat.o(131814);
    }

    public static void s(long j2, long j3) {
        AppMethodBeat.i(131799);
        gkx.add(new long[]{709, j2, j3});
        AppMethodBeat.o(131799);
    }

    public static void t(long j2, long j3) {
        AppMethodBeat.i(131800);
        gkx.add(new long[]{783, j2, j3});
        AppMethodBeat.o(131800);
    }

    public static void gn(String str) {
        AppMethodBeat.i(131803);
        if (nN(512) && MMApplicationContext.getLaunchName().equals(str)) {
            gkA = true;
            Log.i("MicroMsg.BlinkStartup", "report this time");
        }
        AppMethodBeat.o(131803);
    }

    public static void WU() {
        AppMethodBeat.i(131804);
        nN(512);
        AppMethodBeat.o(131804);
    }

    public static void yI(long j2) {
        AppMethodBeat.i(131805);
        if (System.currentTimeMillis() - j2 > 200) {
            nN(512);
            gkA = false;
        }
        AppMethodBeat.o(131805);
    }

    public static void u(long j2, long j3) {
        gkB = j2;
        gkC = j3;
        gkD = gkB;
        gkE = gkC;
    }

    private static void a(int[] iArr, long j2) {
        AppMethodBeat.i(131807);
        Log.i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j2));
        s((long) iArr[0], j2);
        if (com.tencent.mm.f.a.zF) {
            s((long) iArr[1], j2);
            AppMethodBeat.o(131807);
            return;
        }
        s((long) iArr[2], j2);
        AppMethodBeat.o(131807);
    }

    private static void b(int[] iArr, long j2) {
        AppMethodBeat.i(131808);
        Log.i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j2));
        gkx.add(new long[]{910, (long) iArr[0], j2});
        AppMethodBeat.o(131808);
    }

    public static boolean aka() {
        AppMethodBeat.i(131809);
        if (!gkA) {
            AppMethodBeat.o(131809);
            return false;
        }
        boolean nN = nN(256);
        AppMethodBeat.o(131809);
        return nN;
    }

    private static boolean nN(int i2) {
        AppMethodBeat.i(131810);
        if ((gkF & i2) == 0) {
            gkF = (byte) (gkF | i2);
            Log.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", Integer.valueOf(i2));
            AppMethodBeat.o(131810);
            return true;
        }
        AppMethodBeat.o(131810);
        return false;
    }

    private static void yJ(long j2) {
        AppMethodBeat.i(131811);
        if (j2 > 10000) {
            ajZ();
        }
        AppMethodBeat.o(131811);
    }

    public static void nO(int i2) {
        AppMethodBeat.i(131812);
        if (gkD == 0) {
            Log.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
            AppMethodBeat.o(131812);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - gkD;
        switch (i2) {
            case 1:
                if (nN(1)) {
                    a(gke, currentTimeMillis);
                    gkD = System.currentTimeMillis();
                    AppMethodBeat.o(131812);
                    return;
                }
                break;
            case 2:
                if (nN(2)) {
                    a(gkf, currentTimeMillis);
                    gkD = System.currentTimeMillis();
                    AppMethodBeat.o(131812);
                    return;
                }
                break;
            case 3:
                if (nN(4)) {
                    a(gkg, currentTimeMillis);
                    gkD = System.currentTimeMillis();
                    AppMethodBeat.o(131812);
                    return;
                }
                break;
            case 4:
                if (nN(8)) {
                    a(gkh, currentTimeMillis);
                    gkD = System.currentTimeMillis();
                    AppMethodBeat.o(131812);
                    return;
                }
                break;
            case 5:
                if (nN(16)) {
                    yJ(currentTimeMillis);
                    a(gki, currentTimeMillis);
                    gkD = System.currentTimeMillis();
                    AppMethodBeat.o(131812);
                    return;
                }
                break;
            case 6:
                if (nN(32)) {
                    yJ(currentTimeMillis);
                    a(gkj, currentTimeMillis);
                    gkD = System.currentTimeMillis();
                    break;
                }
                break;
        }
        AppMethodBeat.o(131812);
    }

    public static void akb() {
        AppMethodBeat.i(131813);
        long currentTimeMillis = System.currentTimeMillis() - gkB;
        a(gkk, currentTimeMillis);
        if (currentTimeMillis <= 3000) {
            a(gkl, 1);
        } else if (currentTimeMillis > 3000 && currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            a(gkm, 1);
        } else if (currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME || currentTimeMillis > 10000) {
            a(gko, 1);
        } else {
            a(gkn, 1);
        }
        a(gkd, 1);
        long elapsedRealtime = SystemClock.elapsedRealtime() - gkC;
        b(gkq, elapsedRealtime);
        if (elapsedRealtime <= 2000) {
            b(gkr, 1);
        } else if (elapsedRealtime > 2000 && elapsedRealtime <= 4000) {
            b(gks, 1);
        } else if (elapsedRealtime > 4000 && elapsedRealtime <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            b(gkt, 1);
        } else if (elapsedRealtime > ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME && elapsedRealtime <= 8000) {
            b(gku, 1);
        } else if (elapsedRealtime <= 8000 || elapsedRealtime > 10000) {
            b(gkw, 1);
        } else {
            b(gkv, 1);
        }
        b(gkp, 1);
        gky.add(new Object[]{15854, new Object[]{Long.valueOf(elapsedRealtime)}});
        AppMethodBeat.o(131813);
    }

    public static ArrayList<long[]> akc() {
        return gkx;
    }

    public static ArrayList<Object[]> akd() {
        return gky;
    }

    public static void ajZ() {
        AppMethodBeat.i(259561);
        nN(512);
        gkA = false;
        AppMethodBeat.o(259561);
    }
}
