package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.k;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.a;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.c.b;
import java.util.HashMap;
import java.util.Map;

public final class j extends a {
    private a wFC;

    static /* synthetic */ a b(j jVar) {
        AppMethodBeat.i(64452);
        a dKz = jVar.dKz();
        AppMethodBeat.o(64452);
        return dKz;
    }

    static /* synthetic */ void dKA() {
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void prepare() {
        AppMethodBeat.i(64433);
        Log.i("MicroMsg.SoterBiometricPayManager", "prepare");
        if (((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).type() != 2) {
            Log.i("MicroMsg.SoterBiometricPayManager", "set soter manager");
            k kVar = new k();
            kVar.a(this);
            g.b(com.tencent.mm.plugin.fingerprint.d.a.class, kVar);
        }
        if (b.hlG().hlI().get(1).equals("WechatAuthKeyPay&null")) {
            Log.i("MicroMsg.SoterBiometricPayManager", "init error, reinit");
            b.hlG().DQ(false);
            h.INSTANCE.dN(1104, 46);
            com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g() {
                /* class com.tencent.mm.plugin.fingerprint.b.a.j.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.soter.d.g
                public final void bg(int i2, String str) {
                    AppMethodBeat.i(64424);
                    if (i2 != 0 || !com.tencent.soter.a.a.hlC()) {
                        Log.i("MicroMsg.SoterBiometricPayManager", "init failed: %s, %s", Integer.valueOf(i2), str);
                        AppMethodBeat.o(64424);
                        return;
                    }
                    Log.i("MicroMsg.SoterBiometricPayManager", "init success: %s", Integer.valueOf(i2));
                    AppMethodBeat.o(64424);
                }
            });
        }
        AppMethodBeat.o(64433);
    }

    private a dKz() {
        AppMethodBeat.i(64434);
        if (this.wFC == null) {
            this.wFC = new a();
        }
        a aVar = this.wFC;
        AppMethodBeat.o(64434);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final Map<String, String> dJY() {
        AppMethodBeat.i(64435);
        HashMap hashMap = new HashMap();
        e flM = d.flM();
        String str = flM.FhU;
        String str2 = flM.hFF;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        AppMethodBeat.o(64435);
        return hashMap;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final int dKu() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKq() {
        AppMethodBeat.i(64436);
        boolean dKp = dKp();
        AppMethodBeat.o(64436);
        return dKp;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKp() {
        boolean z;
        AppMethodBeat.i(64437);
        if (ae.gKx.gIE == 1) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = ae.gKz.edB;
        boolean hlC = com.tencent.soter.a.a.hlC();
        Log.i("MicroMsg.SoterBiometricPayManager", "is support: %s, %s, %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(hlC));
        if ((z || z2) && hlC) {
            AppMethodBeat.o(64437);
            return true;
        }
        AppMethodBeat.o(64437);
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean fN(Context context) {
        boolean z;
        AppMethodBeat.i(64438);
        if ((ae.gKz.gKq & 1) > 0) {
            z = true;
        } else {
            z = false;
        }
        boolean aU = com.tencent.soter.core.a.aU(context, 1);
        Log.i("MicroMsg.SoterBiometricPayManager", "is support fp: %s, %s", Boolean.valueOf(z), Boolean.valueOf(aU));
        if (!z || !aU) {
            AppMethodBeat.o(64438);
            return false;
        }
        AppMethodBeat.o(64438);
        return true;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean fO(Context context) {
        boolean z;
        AppMethodBeat.i(64439);
        if ((ae.gKz.gKq & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        boolean aU = com.tencent.soter.core.a.aU(context, 2);
        Log.i("MicroMsg.SoterBiometricPayManager", "is support fp: %s, %s", Boolean.valueOf(z), Boolean.valueOf(aU));
        if (!z || !aU) {
            AppMethodBeat.o(64439);
            return false;
        }
        AppMethodBeat.o(64439);
        return true;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKs() {
        AppMethodBeat.i(64440);
        boolean aV = com.tencent.soter.core.a.aV(MMApplicationContext.getContext(), 2);
        AppMethodBeat.o(64440);
        return aV;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKr() {
        AppMethodBeat.i(64441);
        boolean aV = com.tencent.soter.core.a.aV(MMApplicationContext.getContext(), 1);
        AppMethodBeat.o(64441);
        return aV;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dJQ() {
        AppMethodBeat.i(64442);
        boolean aW = com.tencent.soter.core.a.aW(MMApplicationContext.getContext(), 2);
        AppMethodBeat.o(64442);
        return aW;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKt() {
        AppMethodBeat.i(64443);
        boolean aW = com.tencent.soter.core.a.aW(MMApplicationContext.getContext(), 1);
        AppMethodBeat.o(64443);
        return aW;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(Context context, f fVar, final d dVar) {
        AppMethodBeat.i(64444);
        Log.i("MicroMsg.SoterBiometricPayManager", "request fingerprint authorize for pay");
        a(context, fVar, new b() {
            /* class com.tencent.mm.plugin.fingerprint.b.a.j.AnonymousClass2 */
            private int wFZ;

            @Override // com.tencent.mm.plugin.fingerprint.b.a.b
            public final void a(c cVar) {
                AppMethodBeat.i(64425);
                Log.i("MicroMsg.SoterBiometricPayManager", "authorize pay result: %s, %s", Integer.valueOf(cVar.errCode), cVar.errMsg);
                e b2 = e.b(cVar);
                if (b2.isSuccess()) {
                    b2.retryCount++;
                    dVar.onSuccess(b2);
                    AppMethodBeat.o(64425);
                    return;
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int i2 = currentTimeMillis - this.wFZ;
                if (i2 > 0) {
                    b2.retryCount++;
                    this.wFZ = currentTimeMillis;
                }
                Log.d("MicroMsg.SoterBiometricPayManager", "retryCount: %s", Integer.valueOf(b2.retryCount));
                if (b2.canRetry() && i2 > 0) {
                    Log.d("MicroMsg.SoterBiometricPayManager", "do retry: %s", Integer.valueOf(b2.retryCount));
                    dVar.onRetry(b2);
                    AppMethodBeat.o(64425);
                } else if (!b2.canRetry()) {
                    Log.d("MicroMsg.SoterBiometricPayManager", "do fail: %s", Integer.valueOf(b2.retryCount));
                    dVar.onFail(b2);
                    AppMethodBeat.o(64425);
                } else {
                    Log.i("MicroMsg.SoterBiometricPayManager", "do fast, do nothing");
                    AppMethodBeat.o(64425);
                }
            }
        });
        AppMethodBeat.o(64444);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKw() {
        AppMethodBeat.i(64445);
        boolean bqh = com.tencent.soter.core.a.bqh(com.tencent.mm.plugin.fingerprint.b.d.dKd());
        Log.i("MicroMsg.SoterBiometricPayManager", "py: hasAuthKey: %b", Boolean.valueOf(bqh));
        AppMethodBeat.o(64445);
        return bqh;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void q(Object... objArr) {
        AppMethodBeat.i(64446);
        if (com.tencent.soter.core.a.bqh(com.tencent.mm.plugin.fingerprint.b.d.dKd())) {
            com.tencent.soter.core.a.dE(com.tencent.mm.plugin.fingerprint.b.d.dKd(), false);
            Log.i("MicroMsg.SoterBiometricPayManager", "change to new authkey name");
            b.hlG().hlI().put(1, m.aay(1));
        }
        AppMethodBeat.o(64446);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(Context context, f fVar, final b bVar) {
        AppMethodBeat.i(64447);
        Log.i("MicroMsg.SoterBiometricPayManager", "request fingerprint authorize: %s, %s", Integer.valueOf(fVar.scene), fVar.wFE);
        dKz().a(new a.AbstractC1741a() {
            /* class com.tencent.mm.plugin.fingerprint.b.a.j.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.soter.a.AbstractC1741a
            public final void b(com.tencent.soter.a.b.a aVar) {
                AppMethodBeat.i(64426);
                Log.i("MicroMsg.SoterBiometricPayManager", "authentication success");
                j.dKA();
                if (bVar != null) {
                    bVar.a(c.a(aVar));
                }
                AppMethodBeat.o(64426);
            }

            @Override // com.tencent.mm.plugin.soter.a.AbstractC1741a
            public final void a(int i2, com.tencent.soter.a.b.a aVar) {
                AppMethodBeat.i(64427);
                com.tencent.mm.plugin.soter.d.a.n(3, aVar.errCode, 1);
                Log.i("MicroMsg.SoterBiometricPayManager", "authentication failed: %s", Integer.valueOf(i2));
                if (i2 != 1) {
                    if (aVar.errCode == 1021) {
                        j.this.wFC.cancel();
                    }
                    if (bVar != null) {
                        bVar.a(c.a(aVar));
                    }
                } else if (bVar != null) {
                    c cVar = new c();
                    cVar.errCode = 2002;
                    bVar.a(cVar);
                    AppMethodBeat.o(64427);
                    return;
                }
                AppMethodBeat.o(64427);
            }
        }, context, fVar.scene, 1, fVar.wFE);
        AppMethodBeat.o(64447);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void b(Context context, f fVar, final b bVar) {
        AppMethodBeat.i(64448);
        Log.i("MicroMsg.SoterBiometricPayManager", "request faceid authorize: %s, %s", Integer.valueOf(fVar.scene), fVar.wFE);
        dKz().a(new a.AbstractC1741a() {
            /* class com.tencent.mm.plugin.fingerprint.b.a.j.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.soter.a.AbstractC1741a
            public final void b(com.tencent.soter.a.b.a aVar) {
                AppMethodBeat.i(64428);
                Log.i("MicroMsg.SoterBiometricPayManager", "authentication success");
                j.dKA();
                if (bVar != null) {
                    bVar.a(c.a(aVar));
                }
                AppMethodBeat.o(64428);
            }

            @Override // com.tencent.mm.plugin.soter.a.AbstractC1741a
            public final void a(int i2, com.tencent.soter.a.b.a aVar) {
                AppMethodBeat.i(64429);
                com.tencent.mm.plugin.soter.d.a.n(3, aVar.errCode, 1);
                Log.i("MicroMsg.SoterBiometricPayManager", "authentication failed: %s", Integer.valueOf(i2));
                if (i2 != 1) {
                    if (aVar.errCode == 1022) {
                        j.this.wFC.cancel();
                    }
                    if (bVar != null) {
                        bVar.a(c.a(aVar));
                    }
                } else if (bVar != null) {
                    c cVar = new c();
                    cVar.errCode = 2002;
                    bVar.a(cVar);
                    AppMethodBeat.o(64429);
                    return;
                }
                AppMethodBeat.o(64429);
            }
        }, context, fVar.scene, 2, fVar.wFE);
        AppMethodBeat.o(64448);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(boolean z, boolean z2, boolean z3, Bundle bundle) {
        final int i2 = 0;
        AppMethodBeat.i(64449);
        Log.i("MicroMsg.SoterBiometricPayManager", "on post pay: %s, %s, %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        if (!z && z3) {
            final String string = bundle != null ? bundle.getString("pwd") : "";
            if (bundle != null) {
                i2 = bundle.getInt("key_open_biometric_type");
            }
            if (Util.isNullOrNil(string)) {
                Log.e("MicroMsg.SoterBiometricPayManager", "no pwd. can not change auth key");
                AppMethodBeat.o(64449);
                return;
            }
            com.tencent.f.h.RTc.o(new Runnable() {
                /* class com.tencent.mm.plugin.fingerprint.b.a.j.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(64432);
                    j.this.q(new Object[0]);
                    j.b(j.this).a(new a.c() {
                        /* class com.tencent.mm.plugin.fingerprint.b.a.j.AnonymousClass5.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.soter.a.c
                        public final void a(c cVar) {
                            AppMethodBeat.i(64430);
                            Log.i("MicroMsg.SoterBiometricPayManager", "hy: gen auth key onResult: errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.errMsg);
                            j.dKA();
                            p.IML.reset();
                            AppMethodBeat.o(64430);
                        }

                        @Override // com.tencent.mm.plugin.soter.a.c
                        public final void b(c cVar) {
                            AppMethodBeat.i(64431);
                            j.dKA();
                            com.tencent.mm.plugin.soter.d.a.n(2, cVar.errCode, 1);
                            AppMethodBeat.o(64431);
                        }
                    }, new com.tencent.mm.plugin.fingerprint.c.c(string, i2));
                    AppMethodBeat.o(64432);
                }
            }, 500);
        }
        AppMethodBeat.o(64449);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void cancel() {
        AppMethodBeat.i(64450);
        if (this.wFC != null) {
            this.wFC.cancel();
        }
        AppMethodBeat.o(64450);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final com.tencent.mm.plugin.fingerprint.d.d dKv() {
        AppMethodBeat.i(64451);
        com.tencent.mm.plugin.fingerprint.b.m mVar = new com.tencent.mm.plugin.fingerprint.b.m();
        AppMethodBeat.o(64451);
        return mVar;
    }
}
