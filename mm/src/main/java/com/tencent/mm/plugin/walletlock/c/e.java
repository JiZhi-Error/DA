package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.b.a;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public final class e extends a {
    private static b IwO;

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void init() {
        AppMethodBeat.i(129897);
        Log.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", Util.stackTraceToString(new Throwable()));
        int nullAsInt = Util.nullAsInt(g.aAh().azQ().get(40, (Object) null), 0);
        Log.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", Integer.valueOf(nullAsInt), Integer.valueOf(nullAsInt & TPMediaCodecProfileLevel.HEVCHighTierLevel61));
        if ((nullAsInt & TPMediaCodecProfileLevel.HEVCHighTierLevel61) != 0) {
            Log.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
            com.tencent.mm.plugin.walletlock.fingerprint.a.b bVar = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
            IwO = bVar;
            bVar.init();
            g gVar = g.instance;
            boolean fVu = g.fVu();
            Log.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", Boolean.valueOf(m.flS()), Boolean.valueOf(fVu));
            if (com.tencent.mm.plugin.walletlock.gesture.a.b.fUV() && !fVu) {
                boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false);
                Log.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", Boolean.valueOf(z));
                if (z) {
                    c cVar = new c();
                    IwO = cVar;
                    cVar.init();
                    bFX();
                    AppMethodBeat.o(129897);
                    return;
                }
            }
        } else if (com.tencent.mm.plugin.walletlock.gesture.a.b.fUV()) {
            Log.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
            c cVar2 = new c();
            IwO = cVar2;
            cVar2.init();
            g gVar2 = g.instance;
            g.yF(false);
        } else {
            Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
            IwO = new a();
            g gVar3 = g.instance;
            g.yE(false);
            IwO.init();
        }
        bFX();
        AppMethodBeat.o(129897);
    }

    private static void bFX() {
        AppMethodBeat.i(129898);
        Log.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", Integer.valueOf(g.instance.fVr()));
        AppMethodBeat.o(129898);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean a(Activity activity, b.AbstractC1929b bVar) {
        AppMethodBeat.i(129899);
        if (IwO != null) {
            boolean a2 = IwO.a(activity, bVar);
            AppMethodBeat.o(129899);
            return a2;
        }
        AppMethodBeat.o(129899);
        return false;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void a(Activity activity, b.AbstractC1929b bVar, b.a aVar) {
        AppMethodBeat.i(129900);
        if (IwO != null) {
            IwO.a(activity, bVar, aVar);
        }
        AppMethodBeat.o(129900);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void l(Activity activity, int i2) {
        AppMethodBeat.i(129901);
        super.l(activity, i2);
        AppMethodBeat.o(129901);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void b(Activity activity, int i2, int i3) {
        AppMethodBeat.i(129902);
        super.b(activity, i2, i3);
        AppMethodBeat.o(129902);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void aQ(Activity activity) {
        AppMethodBeat.i(129903);
        if (IwO != null) {
            IwO.aQ(activity);
        }
        AppMethodBeat.o(129903);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void m(Activity activity, int i2) {
        AppMethodBeat.i(129904);
        Intent intent = new Intent();
        intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.close_wallet_lock");
        com.tencent.mm.br.c.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
        AppMethodBeat.o(129904);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final b.AbstractC1929b fUE() {
        AppMethodBeat.i(129905);
        if (IwO != null) {
            b.AbstractC1929b fUE = IwO.fUE();
            AppMethodBeat.o(129905);
            return fUE;
        }
        AppMethodBeat.o(129905);
        return null;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean fUF() {
        AppMethodBeat.i(129906);
        g gVar = g.instance;
        if (!g.fUV()) {
            g gVar2 = g.instance;
            if (!g.fUJ()) {
                AppMethodBeat.o(129906);
                return false;
            }
        }
        AppMethodBeat.o(129906);
        return true;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean fUG() {
        AppMethodBeat.i(129907);
        if (IwO != null) {
            boolean fUG = IwO.fUG();
            AppMethodBeat.o(129907);
            return fUG;
        }
        AppMethodBeat.o(129907);
        return false;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void j(Activity activity, Intent intent) {
        AppMethodBeat.i(129908);
        if (IwO != null) {
            IwO.j(activity, intent);
            AppMethodBeat.o(129908);
            return;
        }
        super.j(activity, intent);
        AppMethodBeat.o(129908);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void c(Activity activity, Intent intent, int i2) {
        AppMethodBeat.i(129909);
        if (IwO != null) {
            IwO.c(activity, intent, i2);
            AppMethodBeat.o(129909);
            return;
        }
        super.c(activity, intent, i2);
        AppMethodBeat.o(129909);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void aeZ(int i2) {
        AppMethodBeat.i(129910);
        if (i2 == 1) {
            Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
            c cVar = new c();
            IwO = cVar;
            cVar.init();
            g gVar = g.instance;
            g.yF(true);
            AppMethodBeat.o(129910);
        } else if (i2 == 2) {
            Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
            com.tencent.mm.plugin.walletlock.fingerprint.a.b bVar = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
            IwO = bVar;
            bVar.init();
            g gVar2 = g.instance;
            g.yD(false);
            AppMethodBeat.o(129910);
        } else if (i2 == 3) {
            Log.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
            a aVar = new a();
            IwO = aVar;
            aVar.init();
            AppMethodBeat.o(129910);
        } else if (i2 == 0) {
            Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
            a aVar2 = new a();
            IwO = aVar2;
            aVar2.init();
            g gVar3 = g.instance;
            g.yE(true);
            AppMethodBeat.o(129910);
        } else {
            Log.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
            AppMethodBeat.o(129910);
        }
    }
}
