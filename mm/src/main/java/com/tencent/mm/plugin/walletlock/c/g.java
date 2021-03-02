package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.fingerprint.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.soter.core.c.j;

public enum g {
    instance;
    
    public String IwV;
    public j IwW;
    int mType = -1;

    private g(String str) {
    }

    public static g valueOf(String str) {
        AppMethodBeat.i(129918);
        g gVar = (g) Enum.valueOf(g.class, str);
        AppMethodBeat.o(129918);
        return gVar;
    }

    static {
        AppMethodBeat.i(129933);
        AppMethodBeat.o(129933);
    }

    public final void afe(int i2) {
        AppMethodBeat.i(129919);
        Log.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", Integer.valueOf(this.mType), Integer.valueOf(i2));
        this.mType = i2;
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC, Integer.valueOf(i2));
        com.tencent.mm.kernel.g.aAh().azQ().gBI();
        AppMethodBeat.o(129919);
    }

    public final int fVr() {
        AppMethodBeat.i(129920);
        if (this.mType == -1) {
            this.mType = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC, (Object) 0)).intValue();
        }
        int i2 = this.mType;
        AppMethodBeat.o(129920);
        return i2;
    }

    public static boolean fUV() {
        AppMethodBeat.i(129921);
        boolean fUV = b.fUV();
        AppMethodBeat.o(129921);
        return fUV;
    }

    public static void yD(boolean z) {
        AppMethodBeat.i(129922);
        b.yD(z);
        AppMethodBeat.o(129922);
    }

    public static boolean fUJ() {
        AppMethodBeat.i(129923);
        boolean fUJ = a.fUJ();
        Log.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", Boolean.valueOf(fUJ));
        AppMethodBeat.o(129923);
        return fUJ;
    }

    public static void fVs() {
        AppMethodBeat.i(129924);
        a.yA(true);
        AppMethodBeat.o(129924);
    }

    public static boolean fUK() {
        AppMethodBeat.i(129925);
        boolean fUK = a.fUK();
        AppMethodBeat.o(129925);
        return fUK;
    }

    public static void fVt() {
        AppMethodBeat.i(129926);
        a.yB(true);
        AppMethodBeat.o(129926);
    }

    public static void yE(boolean z) {
        AppMethodBeat.i(129927);
        Log.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
        yF(z);
        b.yD(false);
        a.yB(false);
        if (z) {
            a.fUI();
        }
        AppMethodBeat.o(129927);
    }

    public static void yF(boolean z) {
        AppMethodBeat.i(129928);
        a.yA(false);
        if (z) {
            a.fUI();
        }
        AppMethodBeat.o(129928);
    }

    public final boolean fUG() {
        AppMethodBeat.i(129929);
        if (this.mType == 1) {
            boolean fUW = b.fUW();
            AppMethodBeat.o(129929);
            return fUW;
        } else if (this.mType == 2) {
            Log.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", Boolean.valueOf(a.fUL()));
            boolean fUL = a.fUL();
            AppMethodBeat.o(129929);
            return fUL;
        } else {
            AppMethodBeat.o(129929);
            return false;
        }
    }

    public static void fUM() {
        AppMethodBeat.i(129930);
        d.fUM();
        a.fUM();
        AppMethodBeat.o(129930);
    }

    public static boolean fVu() {
        AppMethodBeat.i(129931);
        if (!fVv() || !m.flS() || !com.tencent.soter.core.a.fN(MMApplicationContext.getContext())) {
            AppMethodBeat.o(129931);
            return false;
        }
        AppMethodBeat.o(129931);
        return true;
    }

    public static boolean fVv() {
        AppMethodBeat.i(129932);
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("TouchLockFunction", 0) != 1) {
            AppMethodBeat.o(129932);
            return true;
        }
        AppMethodBeat.o(129932);
        return false;
    }
}
