package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.ui.f;

public final class d {
    private static boolean wFf = false;

    public static String getUserId() {
        AppMethodBeat.i(64305);
        String mD5String = MD5Util.getMD5String(MD5Util.getMD5String(f.getUsername()) + MD5Util.getMD5String(q.aoG()));
        AppMethodBeat.o(64305);
        return mD5String;
    }

    public static String dKd() {
        AppMethodBeat.i(64306);
        String flR = m.flR();
        AppMethodBeat.o(64306);
        return flR;
    }

    public static void dKe() {
        AppMethodBeat.i(64307);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(64307);
    }

    public static boolean dKf() {
        boolean z;
        AppMethodBeat.i(64308);
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        AppMethodBeat.o(64308);
        return z;
    }

    public static void dKg() {
        AppMethodBeat.i(64309);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(64309);
    }

    public static void pl(boolean z) {
        AppMethodBeat.i(64310);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(64310);
    }

    public static boolean dKh() {
        boolean z;
        AppMethodBeat.i(64311);
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        AppMethodBeat.o(64311);
        return z;
    }

    public static void pm(boolean z) {
        AppMethodBeat.i(64312);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(64312);
    }

    public static boolean dKi() {
        boolean z;
        AppMethodBeat.i(64313);
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        AppMethodBeat.o(64313);
        return z;
    }

    public static void pn(boolean z) {
        wFf = z;
    }

    public static boolean dKj() {
        return wFf;
    }

    public static boolean dJX() {
        AppMethodBeat.i(64314);
        boolean dKq = ((i) g.af(i.class)).dKq();
        AppMethodBeat.o(64314);
        return dKq;
    }

    public static boolean dKk() {
        boolean z;
        AppMethodBeat.i(64315);
        Log.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
        if (dKh()) {
            Log.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            AppMethodBeat.o(64315);
            return false;
        }
        i iVar = (i) g.af(i.class);
        if (iVar.dKu() == 1 && iVar.dKq()) {
            Log.e("MicroMsg.FingerPrintUtil", "device is not support");
            AppMethodBeat.o(64315);
            return false;
        } else if (t.fQI().fRm() || t.fQI().fRl()) {
            Log.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            AppMethodBeat.o(64315);
            return false;
        } else if (!t.fQI().fRs().fRa()) {
            Log.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            AppMethodBeat.o(64315);
            return false;
        } else {
            if (!((i) g.af(i.class)).dKr()) {
                g.aAi();
                Object obj = g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.FALSE);
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                } else {
                    z = false;
                }
                if (!z) {
                    Log.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
                    AppMethodBeat.o(64315);
                    return true;
                }
            }
            AppMethodBeat.o(64315);
            return false;
        }
    }

    public static final String fL(Context context) {
        AppMethodBeat.i(64316);
        String str = context.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
        AppMethodBeat.o(64316);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065 A[SYNTHETIC, Splitter:B:17:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a A[SYNTHETIC, Splitter:B:20:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[Catch:{ Exception -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01dc A[SYNTHETIC, Splitter:B:88:0x01dc] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e1 A[SYNTHETIC, Splitter:B:91:0x01e1] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0236  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int fM(android.content.Context r14) {
        /*
        // Method dump skipped, instructions count: 622
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fingerprint.b.d.fM(android.content.Context):int");
    }
}
