package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.soter.e.b;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.a.a;

public final class c implements i, d {
    d.a Ivb = null;
    private d.a Ivc = null;
    private boolean Ivd = false;
    boolean isCancelled = false;
    private String krw = null;

    @Override // com.tencent.mm.plugin.walletlock.fingerprint.a.d
    public final void a(d.a aVar, Bundle bundle) {
        AppMethodBeat.i(129677);
        this.krw = bundle.getString("key_pay_passwd");
        this.Ivd = bundle.getBoolean("key_fp_lock_offline_mode");
        Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", this.krw, Boolean.valueOf(this.Ivd));
        this.Ivb = aVar;
        this.isCancelled = false;
        g.instance.IwV = null;
        g.instance.IwW = null;
        com.tencent.mm.kernel.g.azz().a(1967, this);
        com.tencent.mm.kernel.g.azz().a(1548, this);
        if (this.Ivd) {
            g.instance.IwV = String.valueOf(System.currentTimeMillis());
            yC(false);
            AppMethodBeat.o(129677);
        } else if (MMApplicationContext.getDefaultPreference() == null) {
            if (this.Ivb != null) {
                this.Ivb.bg(2, "system error");
            }
            AppMethodBeat.o(129677);
        } else {
            e flM = com.tencent.mm.plugin.soter.d.d.flM();
            String str = flM.FhU;
            String str2 = flM.hFF;
            Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", str, str2);
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                b.a(true, new com.tencent.mm.plugin.soter.d.g() {
                    /* class com.tencent.mm.plugin.walletlock.fingerprint.a.c.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.soter.d.g
                    public final void bg(int i2, String str) {
                        AppMethodBeat.i(129676);
                        if (c.this.isCancelled) {
                            AppMethodBeat.o(129676);
                        } else if (i2 == 0) {
                            e flM = com.tencent.mm.plugin.soter.d.d.flM();
                            c.lx(flM.FhU, flM.hFF);
                            AppMethodBeat.o(129676);
                        } else {
                            if (c.this.Ivb != null) {
                                c.this.Ivb.bg(2, "init soter failed");
                            }
                            AppMethodBeat.o(129676);
                        }
                    }
                });
                AppMethodBeat.o(129677);
                return;
            }
            lx(str, str2);
            AppMethodBeat.o(129677);
        }
    }

    private void yC(boolean z) {
        AppMethodBeat.i(129678);
        Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", Boolean.valueOf(z));
        a.a(new com.tencent.soter.a.b.b<com.tencent.soter.a.b.c>() {
            /* class com.tencent.mm.plugin.walletlock.fingerprint.a.c.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
            @Override // com.tencent.soter.a.b.b
            public final /* synthetic */ void a(com.tencent.soter.a.b.c cVar) {
                AppMethodBeat.i(129675);
                com.tencent.soter.a.b.c cVar2 = cVar;
                Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey onResult errCode: %d, errMsg: %s, isCancelled: %b", Integer.valueOf(cVar2.errCode), cVar2.errMsg, Boolean.valueOf(c.this.isCancelled));
                if (!c.this.isCancelled) {
                    if (cVar2.isSuccess()) {
                        Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo update wallet lock auth key success");
                        if (c.this.Ivb != null) {
                            c.this.Ivb.bg(0, "prepare auth key ok");
                        }
                        m.aaz(0);
                        AppMethodBeat.o(129675);
                        return;
                    }
                    Log.e("MicroMsg.FingerprintLockOpenDelegate", "alvinluo error when prepare auth key");
                    h.jY(2, cVar2.errCode);
                    if (c.this.Ivb != null) {
                        c.this.Ivb.bg(2, cVar2.errMsg);
                    }
                    if (cVar2.errCode == 1004) {
                        a.aqK(3);
                        int flU = m.flU() + 1;
                        m.aaz(flU);
                        if (flU >= m.Fia) {
                            Log.w("MicroMsg.FingerprintLockOpenDelegate", "remove ask");
                            com.tencent.soter.core.a.hll();
                        }
                    }
                }
                AppMethodBeat.o(129675);
            }
        }, z, 3, this.Ivd ? null : new g(this.krw), new f());
        AppMethodBeat.o(129678);
    }

    static void lx(String str, String str2) {
        AppMethodBeat.i(129679);
        com.tencent.mm.kernel.g.azz().a(new e(str, str2), 0);
        AppMethodBeat.o(129679);
    }

    @Override // com.tencent.mm.plugin.walletlock.fingerprint.a.d
    public final void a(d.a aVar, String str, String str2, String str3) {
        AppMethodBeat.i(129680);
        Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
        this.Ivc = aVar;
        com.tencent.mm.kernel.g.azz().a(new f(str2, str3, str), 0);
        AppMethodBeat.o(129680);
    }

    @Override // com.tencent.mm.plugin.walletlock.fingerprint.a.d
    public final void release() {
        AppMethodBeat.i(129681);
        Log.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
        this.Ivb = null;
        this.Ivc = null;
        this.isCancelled = true;
        com.tencent.mm.kernel.g.azz().b(1967, this);
        com.tencent.mm.kernel.g.azz().b(1548, this);
        AppMethodBeat.o(129681);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(129682);
        Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (this.isCancelled) {
            AppMethodBeat.o(129682);
            return;
        }
        if (qVar instanceof e) {
            if (i2 == 0 && i3 == 0) {
                e eVar = (e) qVar;
                g.instance.IwV = eVar.wFE;
                yC(eVar.Ivf);
                AppMethodBeat.o(129682);
                return;
            } else if (this.Ivb != null) {
                this.Ivb.bg(7, "get challenge failed");
                AppMethodBeat.o(129682);
                return;
            }
        } else if (qVar instanceof f) {
            if (i2 == 0 && i3 == 0) {
                h.yG(true);
                if (this.Ivc != null) {
                    this.Ivc.bg(0, "open touch lock ok");
                    AppMethodBeat.o(129682);
                    return;
                }
            } else {
                a.aqK(3);
                h.yG(false);
                if (this.Ivc != null) {
                    this.Ivc.bg(6, "open touch lock failed");
                }
            }
        }
        AppMethodBeat.o(129682);
    }
}
