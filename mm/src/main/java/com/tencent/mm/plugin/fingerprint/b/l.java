package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.soter.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.b.c;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public final class l implements d {
    private String kof;
    private b wFA;
    private b wFB;
    private a wFC;
    WeakReference<WalletBaseUI> wFz;

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(Context context, b bVar, String str) {
        AppMethodBeat.i(64368);
        Log.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
        this.wFA = bVar;
        this.kof = str;
        this.wFz = new WeakReference<>((WalletBaseUI) context);
        this.wFC = new a();
        this.wFz.get().addSceneEndListener(1586);
        this.wFz.get().addSceneEndListener(1638);
        ((i) g.af(i.class)).q(new Object[0]);
        dKm();
        AppMethodBeat.o(64368);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void clear() {
        AppMethodBeat.i(64369);
        Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
        if (!(this.wFz == null || this.wFz.get() == null)) {
            this.wFz.get().removeSceneEndListener(1586);
            this.wFz.get().removeSceneEndListener(1638);
        }
        p.IML.reset();
        if (!(this.wFz == null || this.wFz.get() == null)) {
            this.wFz.clear();
        }
        AppMethodBeat.o(64369);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64370);
        Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (Util.isNullOrNil(str)) {
            str = MMApplicationContext.getContext().getString(R.string.c7y);
        }
        if (qVar instanceof com.tencent.mm.plugin.fingerprint.c.a) {
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
                if (Util.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a) qVar).wFE)) {
                    bh(-1, str);
                    AppMethodBeat.o(64370);
                    return true;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fingerprint.b.l.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(64365);
                        l.this.bh(0, "");
                        AppMethodBeat.o(64365);
                    }
                });
            } else {
                Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
                bh(i3, str);
                com.tencent.mm.plugin.soter.d.a.e(7, i2, i3, "get challenge failed");
                AppMethodBeat.o(64370);
                return true;
            }
        }
        if (qVar instanceof com.tencent.mm.plugin.fingerprint.c.b) {
            if (i3 == 0 && i2 == 0) {
                Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
                com.tencent.mm.plugin.soter.d.a.flJ();
                com.tencent.mm.plugin.soter.d.a.e(0, 0, 0, "OK");
                bi(0, str);
            } else {
                Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
                com.tencent.mm.plugin.soter.d.a.e(8, i2, i3, "open fp pay failed");
                bi(-1, str);
            }
            AppMethodBeat.o(64370);
            return true;
        }
        AppMethodBeat.o(64370);
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(b bVar, int i2) {
        AppMethodBeat.i(64371);
        Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
        this.wFB = bVar;
        j jVar = p.IML.wFO;
        if (jVar == null) {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
            com.tencent.mm.plugin.soter.d.a.e(9, -1000223, -1, "signature is null");
            bi(-1, MMApplicationContext.getContext().getString(R.string.c7y));
        } else if (!(this.wFz == null || this.wFz.get() == null)) {
            this.wFz.get().doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(jVar.RPZ, jVar.signature, this.kof, 2));
            AppMethodBeat.o(64371);
            return;
        }
        AppMethodBeat.o(64371);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(Context context, b bVar) {
    }

    private void dKm() {
        AppMethodBeat.i(64372);
        this.wFC.a(new a.c() {
            /* class com.tencent.mm.plugin.fingerprint.b.l.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.soter.a.c
            public final void a(c cVar) {
                AppMethodBeat.i(64366);
                Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key success");
                if (l.this.wFz == null || l.this.wFz.get() == null) {
                    l.this.bh(-1, "base ui is null");
                    AppMethodBeat.o(64366);
                    return;
                }
                l.this.wFz.get().doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(2), false);
                AppMethodBeat.o(64366);
            }

            @Override // com.tencent.mm.plugin.soter.a.c
            public final void b(c cVar) {
                AppMethodBeat.i(64367);
                if (cVar.errCode == 1006) {
                    Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                    com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
                } else if (cVar.errCode == 6) {
                    com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed");
                    if (!Util.isNullOrNil(cVar.errMsg) && cVar.errMsg.startsWith("java.security.ProviderException")) {
                        l.this.bh(-2, MMApplicationContext.getContext().getString(R.string.agj));
                        AppMethodBeat.o(64367);
                        return;
                    } else if (com.tencent.soter.core.a.hlf() == 1 && !Util.isNullOrNil(cVar.errMsg) && cVar.errMsg.equals("errmsg not specified")) {
                        l.this.bh(-2, MMApplicationContext.getContext().getString(R.string.agk));
                        AppMethodBeat.o(64367);
                        return;
                    }
                } else if (cVar.errCode == 1004) {
                    Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key failed. remove");
                    com.tencent.mm.plugin.soter.d.a.e(5, 4, cVar.errCode, "upload auth key failed");
                } else if (cVar.errCode == 4 || cVar.errCode == 3) {
                    Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: gen auth key failed");
                    com.tencent.mm.plugin.soter.d.a.e(2, -1000223, -1, "gen ask failed");
                } else if (cVar.errCode == 1003) {
                    Log.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo upload ask failed");
                    com.tencent.mm.plugin.soter.d.a.e(3, 4, cVar.errCode, cVar.errMsg);
                } else {
                    Log.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo unknown error when prepare auth key");
                    com.tencent.mm.plugin.soter.d.a.e(1000, -1000223, cVar.errCode, cVar.errMsg);
                }
                l.this.bh(-1, MMApplicationContext.getContext().getString(R.string.agi));
                AppMethodBeat.o(64367);
            }
        }, new com.tencent.mm.plugin.fingerprint.c.c(this.kof, 2));
        AppMethodBeat.o(64372);
    }

    /* access modifiers changed from: package-private */
    public final void bh(int i2, String str) {
        AppMethodBeat.i(64373);
        if (this.wFA != null) {
            this.wFA.bg(i2, str);
        }
        AppMethodBeat.o(64373);
    }

    private void bi(int i2, String str) {
        AppMethodBeat.i(64374);
        if (this.wFB != null) {
            this.wFB.bg(i2, str);
        }
        AppMethodBeat.o(64374);
    }
}
