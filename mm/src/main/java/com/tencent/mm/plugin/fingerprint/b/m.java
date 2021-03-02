package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.b.c;
import java.lang.ref.WeakReference;

public final class m implements d {
    int dNP;
    private String kof = "";
    private a wFC;
    private String wFE;
    String wFF;
    String wFG;
    private b wFm = null;
    private b wFn = null;
    WeakReference<WalletBaseUI> wFz = null;

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(Context context, b bVar, String str) {
        AppMethodBeat.i(64379);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
        this.wFC = new a();
        this.wFz = new WeakReference<>((WalletBaseUI) context);
        this.wFm = bVar;
        this.kof = str;
        this.wFz.get().addSceneEndListener(1586);
        this.wFz.get().addSceneEndListener(1638);
        com.tencent.mm.plugin.soter.d.a.flI();
        ((i) g.af(i.class)).q(new Object[0]);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
        h.INSTANCE.dN(1104, 35);
        this.wFC.a(new a.c() {
            /* class com.tencent.mm.plugin.fingerprint.b.m.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.soter.a.c
            public final void a(c cVar) {
                AppMethodBeat.i(64376);
                if (m.this.wFz == null || m.this.wFz.get() == null) {
                    m.this.bj(-1, "base ui is null");
                    AppMethodBeat.o(64376);
                    return;
                }
                m.this.wFz.get().doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(1), false);
                AppMethodBeat.o(64376);
            }

            @Override // com.tencent.mm.plugin.soter.a.c
            public final void b(c cVar) {
                AppMethodBeat.i(64377);
                if (cVar.errCode == 1006) {
                    Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                    com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
                } else if (cVar.errCode == 6) {
                    com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed");
                    if (!Util.isNullOrNil(cVar.errMsg) && cVar.errMsg.startsWith("java.security.ProviderException")) {
                        m.this.bj(-2, MMApplicationContext.getContext().getString(R.string.agj));
                        AppMethodBeat.o(64377);
                        return;
                    } else if (com.tencent.soter.core.a.hlf() == 1 && !Util.isNullOrNil(cVar.errMsg) && cVar.errMsg.equals("errmsg not specified")) {
                        m.this.bj(-2, MMApplicationContext.getContext().getString(R.string.agk));
                        AppMethodBeat.o(64377);
                        return;
                    }
                } else if (cVar.errCode == 1004) {
                    Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
                    com.tencent.mm.plugin.soter.d.a.d(5, 4, cVar.errCode, "upload auth key failed");
                } else if (cVar.errCode == 4 || cVar.errCode == 3) {
                    Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
                    com.tencent.mm.plugin.soter.d.a.d(2, -1000223, -1, "gen ask failed");
                } else if (cVar.errCode == 1003) {
                    Log.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
                    com.tencent.mm.plugin.soter.d.a.d(3, 4, cVar.errCode, cVar.errMsg);
                } else {
                    Log.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
                    com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, cVar.errCode, cVar.errMsg);
                }
                h.INSTANCE.dN(1104, 34);
                m.this.bj(-1, MMApplicationContext.getContext().getString(R.string.agi));
                AppMethodBeat.o(64377);
            }
        }, new com.tencent.mm.plugin.fingerprint.c.c(this.kof, 1));
        AppMethodBeat.o(64379);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void clear() {
        AppMethodBeat.i(64380);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
        if (!(this.wFz == null || this.wFz.get() == null)) {
            this.wFz.get().removeSceneEndListener(1586);
            this.wFz.get().removeSceneEndListener(1638);
        }
        this.wFm = null;
        p.IML.reset();
        if (!(this.wFz == null || this.wFz.get() == null)) {
            this.wFz.clear();
        }
        AppMethodBeat.o(64380);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(Context context, final b bVar) {
        AppMethodBeat.i(64381);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "request authentication");
        if (Util.isNullOrNil(this.wFE)) {
            Log.w("MicroMsg.SoterFingerprintOpenDelegate", "no challenge!!");
            AppMethodBeat.o(64381);
            return;
        }
        h.INSTANCE.dN(1104, 41);
        ((i) g.af(i.class)).a(context, new f(this.wFE), new com.tencent.mm.plugin.fingerprint.b.a.b() {
            /* class com.tencent.mm.plugin.fingerprint.b.m.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.fingerprint.b.a.b
            public final void a(com.tencent.mm.plugin.fingerprint.b.a.c cVar) {
                AppMethodBeat.i(64375);
                Log.i("MicroMsg.SoterFingerprintOpenDelegate", "authentication result: %s", Integer.valueOf(cVar.errCode));
                String str = "";
                switch (cVar.errCode) {
                    case 0:
                        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify success");
                        m.this.dNP = cVar.dNP;
                        m.this.wFF = cVar.wFF;
                        m.this.wFG = cVar.wFG;
                        h.INSTANCE.dN(1104, 40);
                        bVar.bg(0, "");
                        AppMethodBeat.o(64375);
                        return;
                    case 2000:
                    case 2001:
                        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify timeout");
                        AppMethodBeat.o(64375);
                        return;
                    case 2002:
                        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
                        bVar.bg(-1, "");
                        AppMethodBeat.o(64375);
                        return;
                    case 2005:
                        str = MMApplicationContext.getContext().getString(R.string.hd6);
                        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, cVar.errCode, "fingerprint error");
                        h.INSTANCE.dN(1104, 39);
                        break;
                    case 2007:
                    case 10308:
                        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", Integer.valueOf(cVar.errCode));
                        str = MMApplicationContext.getContext().getString(R.string.hd4);
                        if (cVar.errCode != 10308) {
                            if (Build.VERSION.SDK_INT == 27 && "Xiaomi".equals(Build.MANUFACTURER)) {
                                str = MMApplicationContext.getContext().getString(R.string.agi);
                            }
                            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, cVar.errCode, "fingerprint error");
                            h.INSTANCE.dN(1104, 39);
                            break;
                        } else {
                            str = MMApplicationContext.getContext().getString(R.string.hd5);
                            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                            break;
                        }
                    case 2009:
                        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", Integer.valueOf(cVar.errCode));
                        str = MMApplicationContext.getContext().getString(R.string.hd4);
                        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, cVar.errCode, "fingerprint error");
                        com.tencent.mm.plugin.soter.d.a.aaw(2);
                        break;
                }
                bVar.bg(-2, str);
                AppMethodBeat.o(64375);
            }
        });
        AppMethodBeat.o(64381);
    }

    /* access modifiers changed from: package-private */
    public final void bj(int i2, String str) {
        AppMethodBeat.i(64382);
        if (this.wFm != null) {
            this.wFm.bg(i2, str);
        }
        AppMethodBeat.o(64382);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64383);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (Util.isNullOrNil(str)) {
            str = MMApplicationContext.getContext().getString(R.string.dbz);
        }
        if (qVar instanceof com.tencent.mm.plugin.fingerprint.c.a) {
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
                com.tencent.mm.plugin.fingerprint.c.a aVar = (com.tencent.mm.plugin.fingerprint.c.a) qVar;
                if (Util.isNullOrNil(aVar.wFE)) {
                    bj(-1, str);
                    AppMethodBeat.o(64383);
                    return true;
                }
                this.wFE = aVar.wFE;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fingerprint.b.m.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(64378);
                        m.this.bj(0, "");
                        AppMethodBeat.o(64378);
                    }
                });
            } else {
                Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
                bj(i3, str);
                com.tencent.mm.plugin.soter.d.a.d(7, i2, i3, "get challenge failed");
                AppMethodBeat.o(64383);
                return true;
            }
        }
        if (qVar instanceof com.tencent.mm.plugin.fingerprint.c.b) {
            if (i3 == 0 && i2 == 0) {
                Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
                com.tencent.mm.plugin.soter.d.a.flJ();
                com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
                bk(0, str);
            } else {
                Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
                com.tencent.mm.plugin.soter.d.a.d(8, i2, i3, "open fp pay failed");
                bk(-1, str);
            }
            AppMethodBeat.o(64383);
            return true;
        }
        AppMethodBeat.o(64383);
        return false;
    }

    private void bk(int i2, String str) {
        AppMethodBeat.i(64384);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
        clear();
        this.wFn.bg(i2, str);
        this.wFn = null;
        AppMethodBeat.o(64384);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(b bVar, int i2) {
        AppMethodBeat.i(64385);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
        this.wFn = bVar;
        if (Util.isNullOrNil(this.wFF)) {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
            com.tencent.mm.plugin.soter.d.a.d(9, -1000223, -1, "signature is null");
            bj(-1, MMApplicationContext.getContext().getString(R.string.dbz));
        } else if (!(this.wFz == null || this.wFz.get() == null)) {
            this.wFz.get().doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(this.wFF, this.wFG, this.kof, 1));
            AppMethodBeat.o(64385);
            return;
        }
        AppMethodBeat.o(64385);
    }
}
