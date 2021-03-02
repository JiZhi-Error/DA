package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static long Iva = -1;

    private static JSONArray aWf(String str) {
        AppMethodBeat.i(129656);
        if (str == null) {
            AppMethodBeat.o(129656);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            AppMethodBeat.o(129656);
            return jSONArray;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e2, "", new Object[0]);
            AppMethodBeat.o(129656);
            return null;
        }
    }

    private static HashSet<String> S(JSONArray jSONArray) {
        AppMethodBeat.i(129657);
        if (jSONArray == null) {
            AppMethodBeat.o(129657);
            return null;
        }
        try {
            HashSet<String> hashSet = new HashSet<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(jSONArray.getJSONObject(i2).getString("fid"));
            }
            AppMethodBeat.o(129657);
            return hashSet;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e2, "", new Object[0]);
            AppMethodBeat.o(129657);
            return null;
        }
    }

    private static String fUH() {
        AppMethodBeat.i(129658);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, (Object) null);
        AppMethodBeat.o(129658);
        return str;
    }

    public static boolean aWg(String str) {
        AppMethodBeat.i(129659);
        Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", str);
        try {
            JSONArray aWf = aWf(fUH());
            HashSet<String> S = S(aWf);
            if (aWf == null) {
                Log.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
                aWf = new JSONArray();
            }
            if (S == null) {
                Log.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
                S = new HashSet<>();
            }
            Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", aWf.toString());
            if (!S.contains(str)) {
                Log.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", str, Boolean.FALSE);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fid", str);
                aWf.put(jSONObject);
                Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", aWf.toString());
                g.aAh().azQ().set(ar.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, aWf.toString());
                g.aAh().azQ().gBI();
                AppMethodBeat.o(129659);
                return true;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e2, "", new Object[0]);
        }
        AppMethodBeat.o(129659);
        return false;
    }

    public static boolean aWh(String str) {
        AppMethodBeat.i(129660);
        String fUH = fUH();
        Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", str, fUH);
        HashSet<String> S = S(aWf(fUH));
        if (S == null || !S.contains(str)) {
            AppMethodBeat.o(129660);
            return false;
        }
        AppMethodBeat.o(129660);
        return true;
    }

    public static void fUI() {
        AppMethodBeat.i(129661);
        Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", Util.getStack());
        g.aAh().azQ().set(ar.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, (Object) null);
        g.aAh().azQ().gBI();
        AppMethodBeat.o(129661);
    }

    public static boolean fUJ() {
        AppMethodBeat.i(129662);
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(129662);
        return booleanValue;
    }

    public static void yA(boolean z) {
        AppMethodBeat.i(129663);
        Log.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", Boolean.valueOf(z));
        g.aAh().azQ().set(ar.a.USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        g.aAh().azQ().gBI();
        AppMethodBeat.o(129663);
    }

    public static boolean fUK() {
        AppMethodBeat.i(129664);
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLETLOCK_FACEID_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(129664);
        return booleanValue;
    }

    public static void yB(boolean z) {
        AppMethodBeat.i(129665);
        Log.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", Boolean.valueOf(z));
        g.aAh().azQ().set(ar.a.USERINFO_WALLETLOCK_FACEID_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        g.aAh().azQ().gBI();
        AppMethodBeat.o(129665);
    }

    public static void aB(long j2, long j3) {
        AppMethodBeat.i(129667);
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            com.tencent.mm.plugin.walletlock.gesture.a.g gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
            gVar.IvB = j2;
            gVar.IvC = j3;
            azQ.set(ar.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, e.bytesToString(gVar.toByteArray()));
            azQ.gBI();
        }
        AppMethodBeat.o(129667);
    }

    public static void fUM() {
        Iva = -1;
    }

    public static long fUN() {
        return Iva;
    }

    public static void LU(long j2) {
        Iva = j2;
    }

    public static boolean fUL() {
        com.tencent.mm.plugin.walletlock.gesture.a.g cu;
        AppMethodBeat.i(129666);
        ao azQ = g.aAh().azQ();
        if (azQ == null) {
            cu = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
            String str = (String) azQ.get(ar.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, (Object) null);
            if (str == null) {
                cu = new com.tencent.mm.plugin.walletlock.gesture.a.g();
            } else {
                cu = new com.tencent.mm.plugin.walletlock.gesture.a.g().cu(e.stringToBytes(str));
            }
        }
        if (cu.IvB != -1) {
            e.a(cu);
            if (cu.IvC / 1000 < 30) {
                aB(cu.IvB, cu.IvC);
                AppMethodBeat.o(129666);
                return true;
            }
            ao azQ2 = g.aAh().azQ();
            if (azQ2 != null) {
                azQ2.set(ar.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, (Object) null);
                azQ2.gBI();
            }
            AppMethodBeat.o(129666);
            return false;
        }
        AppMethodBeat.o(129666);
        return false;
    }
}
