package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.soter.a.c.b;

public final class m {
    public static int Fia = 2;
    public static String Fib = "";
    public static String Fic = "";
    public static String Fid = "";
    private static String TAG = "MicroMsg.SoterUtil";

    public static void flO() {
        AppMethodBeat.i(130854);
        boolean z = Util.getInt(((a) g.aAd().af(a.class)).aqJ().getValue("SoterEntry"), 0) == 1;
        Log.i(TAG, "alvinluo dynamic config support soter: %b", Boolean.valueOf(z));
        if (z) {
            Log.d(TAG, "alvinluo set all soter support flag to true");
            ae.gKz.edB = true;
            ae.gKz.gKq = 255;
            ae.gKx.gIE = 1;
            ae.gKx.gIF = 1;
            Log.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", Boolean.valueOf(ae.gKz.edB), Integer.valueOf(ae.gKx.gIE), Integer.valueOf(ae.gKx.gIF));
        }
        AppMethodBeat.o(130854);
    }

    private static String flP() {
        AppMethodBeat.i(130855);
        try {
            String messageDigest = com.tencent.mm.b.g.getMessageDigest(Fib.getBytes());
            if (messageDigest != null) {
                String substring = messageDigest.substring(0, 8);
                AppMethodBeat.o(130855);
                return substring;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "alvinluo get md5 exception", new Object[0]);
        }
        AppMethodBeat.o(130855);
        return "";
    }

    public static String flQ() {
        AppMethodBeat.i(192231);
        try {
            g.aAf();
            String messageDigest = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.ayV().getBytes());
            if (messageDigest != null) {
                String substring = messageDigest.substring(0, 8);
                AppMethodBeat.o(192231);
                return substring;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "alvinluo get md5 exception", new Object[0]);
        }
        AppMethodBeat.o(192231);
        return "";
    }

    public static String aax(int i2) {
        AppMethodBeat.i(192232);
        if (i2 == 1) {
            String str = "WechatAuthKeyPay&" + Fib;
            AppMethodBeat.o(192232);
            return str;
        }
        String format = String.format("SoterAuthKey_salt%s_scene%d", com.tencent.soter.core.c.g.nullAsNil(flP()), Integer.valueOf(i2));
        AppMethodBeat.o(192232);
        return format;
    }

    public static String aay(int i2) {
        AppMethodBeat.i(192233);
        String format = String.format("SoterAuthKeyV2_salt%s_scene%d", com.tencent.soter.core.c.g.nullAsNil(flQ()), Integer.valueOf(i2));
        AppMethodBeat.o(192233);
        return format;
    }

    public static String flR() {
        AppMethodBeat.i(130856);
        String str = b.hlG().hlI().get(1, "");
        if (Util.isNullOrNil(str)) {
            str = "WechatAuthKeyPay&" + Fib;
        }
        AppMethodBeat.o(130856);
        return str;
    }

    public static boolean flS() {
        AppMethodBeat.i(261620);
        boolean flT = flT();
        AppMethodBeat.o(261620);
        return flT;
    }

    private static boolean flT() {
        AppMethodBeat.i(130859);
        if (!ae.gKz.edB) {
            Log.i(TAG, "hy: dynamic config is not support soter");
            AppMethodBeat.o(130859);
            return false;
        }
        boolean hlC = com.tencent.soter.a.a.hlC();
        AppMethodBeat.o(130859);
        return hlC;
    }

    public static int flU() {
        AppMethodBeat.i(130860);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_SOTER_UPLOAD_AK_FAILURE_INT_SYNC, (Object) 0)).intValue();
        AppMethodBeat.o(130860);
        return intValue;
    }

    public static void aaz(int i2) {
        AppMethodBeat.i(130861);
        g.aAh().azQ().set(ar.a.USERINFO_SOTER_UPLOAD_AK_FAILURE_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(130861);
    }

    public static int flV() {
        AppMethodBeat.i(130862);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_SOTER_AUTHORIZE_FAILURE_INT_SYNC, (Object) 0)).intValue();
        AppMethodBeat.o(130862);
        return intValue;
    }

    public static void aaA(int i2) {
        AppMethodBeat.i(130863);
        g.aAh().azQ().set(ar.a.USERINFO_SOTER_AUTHORIZE_FAILURE_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(130863);
    }

    public static boolean hf(Context context) {
        AppMethodBeat.i(130857);
        if (!flT() || !com.tencent.soter.core.a.fN(context)) {
            AppMethodBeat.o(130857);
            return false;
        }
        AppMethodBeat.o(130857);
        return true;
    }
}
