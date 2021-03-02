package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.io.IOException;

public final class d {
    private static long Iva = -1;

    public static g fUX() {
        AppMethodBeat.i(129765);
        ao azQ = g.aAh().azQ();
        if (azQ == null) {
            g gVar = new g();
            AppMethodBeat.o(129765);
            return gVar;
        }
        Object obj = azQ.get(339969, (Object) null);
        if (obj == null) {
            g gVar2 = new g();
            AppMethodBeat.o(129765);
            return gVar2;
        }
        g cu = new g().cu(e.stringToBytes((String) obj));
        AppMethodBeat.o(129765);
        return cu;
    }

    public static void aB(long j2, long j3) {
        AppMethodBeat.i(129766);
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            g gVar = new g();
            gVar.IvB = j2;
            gVar.IvC = j3;
            azQ.set(339969, e.bytesToString(gVar.toByteArray()));
            azQ.gBI();
        }
        AppMethodBeat.o(129766);
    }

    public static void fUY() {
        AppMethodBeat.i(129767);
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            azQ.set(339969, (Object) null);
            azQ.gBI();
        }
        AppMethodBeat.o(129767);
    }

    public static long fUN() {
        return Iva;
    }

    public static void LU(long j2) {
        Iva = j2;
    }

    public static void fUM() {
        Iva = -1;
    }

    public static g fUZ() {
        AppMethodBeat.i(129768);
        ao azQ = g.aAh().azQ();
        if (azQ == null) {
            g gVar = new g();
            AppMethodBeat.o(129768);
            return gVar;
        }
        Object obj = azQ.get(339971, (Object) null);
        if (obj == null) {
            g gVar2 = new g();
            AppMethodBeat.o(129768);
            return gVar2;
        }
        g cu = new g().cu(e.stringToBytes((String) obj));
        AppMethodBeat.o(129768);
        return cu;
    }

    public static void aC(long j2, long j3) {
        AppMethodBeat.i(129769);
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            g gVar = new g();
            gVar.IvB = j2;
            gVar.IvC = j3;
            azQ.set(339971, e.bytesToString(gVar.toByteArray()));
            azQ.gBI();
        }
        AppMethodBeat.o(129769);
    }

    public static void fVa() {
        AppMethodBeat.i(129770);
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            azQ.set(339971, (Object) null);
            azQ.gBI();
        }
        AppMethodBeat.o(129770);
    }

    public static czk fVb() {
        AppMethodBeat.i(129771);
        ao azQ = g.aAh().azQ();
        if (azQ == null) {
            AppMethodBeat.o(129771);
            return null;
        }
        String str = (String) azQ.get(339989, (Object) null);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(129771);
            return null;
        }
        try {
            czk czk = (czk) new czk().parseFrom(Base64.decode(str, 2));
            AppMethodBeat.o(129771);
            return czk;
        } catch (IllegalArgumentException e2) {
            Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            AppMethodBeat.o(129771);
            return null;
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e3, "", new Object[0]);
            AppMethodBeat.o(129771);
            return null;
        }
    }

    public static void a(czk czk) {
        AppMethodBeat.i(129772);
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            try {
                azQ.set(339989, Base64.encodeToString(czk.toByteArray(), 2));
                azQ.gBI();
                Log.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", Boolean.valueOf(e.fUV()));
                AppMethodBeat.o(129772);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(129772);
    }

    public static czl fVc() {
        AppMethodBeat.i(129773);
        ao azQ = g.aAh().azQ();
        if (azQ == null) {
            Log.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
            AppMethodBeat.o(129773);
            return null;
        }
        String str = (String) azQ.get(339990, (Object) null);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(129773);
            return null;
        }
        try {
            czl czl = (czl) new czl().parseFrom(Base64.decode(str, 2));
            AppMethodBeat.o(129773);
            return czl;
        } catch (IllegalArgumentException e2) {
            Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            AppMethodBeat.o(129773);
            return null;
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e3, "", new Object[0]);
            AppMethodBeat.o(129773);
            return null;
        }
    }

    public static void a(czl czl) {
        AppMethodBeat.i(129774);
        if (czl != null) {
            Log.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", Integer.valueOf(czl.MEJ), Integer.valueOf(czl.MEL));
        }
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            try {
                azQ.set(339990, Base64.encodeToString(czl.toByteArray(), 2));
                azQ.gBI();
                AppMethodBeat.o(129774);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(129774);
    }

    public static int fVd() {
        AppMethodBeat.i(129775);
        ao azQ = g.aAh().azQ();
        if (azQ == null) {
            AppMethodBeat.o(129775);
            return -1;
        }
        Object obj = azQ.get(339972, (Object) null);
        if (obj == null) {
            AppMethodBeat.o(129775);
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        AppMethodBeat.o(129775);
        return intValue;
    }

    public static void afb(int i2) {
        AppMethodBeat.i(129776);
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            azQ.set(339972, Integer.valueOf(i2));
            azQ.gBI();
        }
        AppMethodBeat.o(129776);
    }

    public static void fVe() {
        AppMethodBeat.i(129777);
        ao azQ = g.aAh().azQ();
        if (azQ != null) {
            azQ.set(339972, (Object) null);
            azQ.gBI();
        }
        AppMethodBeat.o(129777);
    }
}
