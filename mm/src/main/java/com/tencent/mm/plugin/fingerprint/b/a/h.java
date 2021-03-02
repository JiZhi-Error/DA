package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Map;

public final class h extends a {
    private a wFX;

    static /* synthetic */ a a(h hVar) {
        AppMethodBeat.i(64423);
        a dKx = hVar.dKx();
        AppMethodBeat.o(64423);
        return dKx;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void prepare() {
        AppMethodBeat.i(64410);
        if (((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).type() != 1) {
            Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "set soter manager");
            c cVar = new c();
            cVar.a(this);
            g.b(com.tencent.mm.plugin.fingerprint.d.a.class, cVar);
        }
        if (q.is64BitRuntime()) {
            Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "not support 64bit");
            AppMethodBeat.o(64410);
            return;
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.fingerprint.b.a.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(64405);
                if (!d.dKi()) {
                    try {
                        h.a(h.this, MMApplicationContext.getContext());
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", e2, "", new Object[0]);
                        d.pm(false);
                    }
                }
                if (!d.dKj()) {
                    try {
                        com.tencent.mm.plugin.fingerprint.a.class.getClassLoader();
                        if (!TextUtils.isEmpty(j.dZ("teec"))) {
                            Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
                            j.Ed("fingerprintauth");
                            d.pn(true);
                        } else {
                            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
                            d.pn(false);
                        }
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", th, "", new Object[0]);
                        d.pn(false);
                    }
                }
                h.dKy();
                AppMethodBeat.o(64405);
            }
        }, getClass().getName());
        AppMethodBeat.o(64410);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final Map<String, String> dJY() {
        return null;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final int dKu() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKp() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(64411);
        if (ae.gKx.gIE == 1) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = ae.gKz.edB;
        int[] IG = a.IG();
        if (IG != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= IG.length) {
                    break;
                } else if (1 == IG[i2]) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "is support: %s, %s, %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            if (z || !z2 || z3) {
                AppMethodBeat.o(64411);
                return false;
            }
            AppMethodBeat.o(64411);
            return true;
        }
        z2 = false;
        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "is support: %s, %s, %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        if (z) {
        }
        AppMethodBeat.o(64411);
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKq() {
        AppMethodBeat.i(64412);
        if (!dKp() || !d.dKi() || !d.dKj()) {
            AppMethodBeat.o(64412);
            return false;
        }
        AppMethodBeat.o(64412);
        return true;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean fN(Context context) {
        AppMethodBeat.i(64413);
        boolean dKq = dKq();
        AppMethodBeat.o(64413);
        return dKq;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean fO(Context context) {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKs() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKr() {
        AppMethodBeat.i(64414);
        dKx();
        if (this.wFX == null) {
            AppMethodBeat.o(64414);
            return false;
        }
        int[] IF = this.wFX.IF();
        if (IF == null || IF.length <= 0) {
            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "ids is null");
        }
        try {
            this.wFX.release();
        } catch (Exception e2) {
        }
        this.wFX = null;
        if (IF == null || IF.length <= 0) {
            AppMethodBeat.o(64414);
            return false;
        }
        AppMethodBeat.o(64414);
        return true;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dJQ() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKt() {
        return false;
    }

    private a dKx() {
        AppMethodBeat.i(64415);
        this.wFX = a.IE();
        a aVar = this.wFX;
        AppMethodBeat.o(64415);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKw() {
        return true;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void q(Object... objArr) {
        AppMethodBeat.i(64416);
        if (objArr.length <= 0) {
            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "hy: param incorrect");
            AppMethodBeat.o(64416);
            return;
        }
        String userId = d.getUserId();
        if (d.dJX()) {
            FingerPrintAuth.clearData(d.fL(MMApplicationContext.getContext()), userId, ((Integer) objArr[0]).intValue());
        } else {
            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "device is not support FingerPrintAuth");
        }
        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "clear fingerprint data id:" + userId + " clear_rsa_key_level:" + objArr[0]);
        AppMethodBeat.o(64416);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(Context context, f fVar, final d dVar) {
        AppMethodBeat.i(64417);
        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "request fingerprint authorize for pay");
        a(context, fVar, new b() {
            /* class com.tencent.mm.plugin.fingerprint.b.a.h.AnonymousClass2 */
            private int wFZ;

            @Override // com.tencent.mm.plugin.fingerprint.b.a.b
            public final void a(c cVar) {
                AppMethodBeat.i(64406);
                Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "authorize pay result: %s, %s", Integer.valueOf(cVar.errCode), cVar.errMsg);
                e b2 = e.b(cVar);
                if (b2.isSuccess()) {
                    b2.retryCount++;
                    dVar.onSuccess(b2);
                    AppMethodBeat.o(64406);
                    return;
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int i2 = currentTimeMillis - this.wFZ;
                if (i2 > 0) {
                    b2.retryCount++;
                    this.wFZ = currentTimeMillis;
                }
                if (!b2.canRetry() || b2.retryCount >= 3 || i2 <= 0) {
                    dVar.onFail(b2);
                    AppMethodBeat.o(64406);
                    return;
                }
                dVar.onRetry(b2);
                AppMethodBeat.o(64406);
            }
        });
        AppMethodBeat.o(64417);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(Context context, final f fVar, final b bVar) {
        AppMethodBeat.i(64418);
        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "request fingerprint authorize: %s", fVar.dDL);
        if (this.wFX == null) {
            Log.d("MicroMsg.HuaweiBiometricPayManagerImpl", "open auth once");
            dKx();
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.fingerprint.b.a.h.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(64409);
                a a2 = h.a(h.this);
                if (a2 == null) {
                    if (bVar != null) {
                        bVar.a(c.ai(fVar.dDL, -1, -1));
                    }
                    AppMethodBeat.o(64409);
                    return;
                }
                if (!(a2.a(new a.b() {
                    /* class com.tencent.mm.plugin.fingerprint.b.a.h.AnonymousClass3.AnonymousClass1 */

                    @Override // com.huawei.b.a.b
                    public final void bQ(int i2, int i3) {
                        AppMethodBeat.i(64407);
                        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on status: %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), -1);
                        AppMethodBeat.o(64407);
                    }

                    @Override // com.huawei.b.a.b
                    public final void D(int i2, int i3, int i4) {
                        AppMethodBeat.i(64408);
                        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on result: %s, %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), -1);
                        if (bVar != null) {
                            bVar.a(c.ai(fVar.dDL, i2, i3));
                        }
                        AppMethodBeat.o(64408);
                    }
                }, a2.IF()) == 0 || bVar == null)) {
                    bVar.a(c.ai(fVar.dDL, -1, -1));
                }
                AppMethodBeat.o(64409);
            }
        }, 300);
        AppMethodBeat.o(64418);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void b(Context context, f fVar, b bVar) {
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(boolean z, boolean z2, boolean z3, Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final com.tencent.mm.plugin.fingerprint.d.d dKv() {
        AppMethodBeat.i(64420);
        com.tencent.mm.plugin.fingerprint.b.g gVar = new com.tencent.mm.plugin.fingerprint.b.g();
        AppMethodBeat.o(64420);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void cancel() {
        AppMethodBeat.i(64419);
        if (this.wFX != null) {
            try {
                this.wFX.abort();
                this.wFX.release();
                AppMethodBeat.o(64419);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(64419);
    }

    static /* synthetic */ void a(h hVar, Context context) {
        AppMethodBeat.i(64421);
        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "initTASecureWorld");
        if (!hVar.dKp()) {
            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "device is not support");
            AppMethodBeat.o(64421);
        } else if (d.fM(context) != 0) {
            d.pm(false);
            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "copyTAFromAssets failed!");
            AppMethodBeat.o(64421);
        } else {
            d.pm(true);
            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "copyTAFromAssets success!");
            AppMethodBeat.o(64421);
        }
    }

    static /* synthetic */ void dKy() {
        AppMethodBeat.i(64422);
        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "initRsaKey");
        if (!d.dKi()) {
            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "device is not support");
            AppMethodBeat.o(64422);
        } else if (t.fQI().fRm() || t.fQI().fRl()) {
            Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "user had not reg wxpay or is isSimpleReg");
            AppMethodBeat.o(64422);
        } else {
            try {
                String userId = d.getUserId();
                Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "initRsaKey userId:".concat(String.valueOf(userId)));
                String rsaKey = FingerPrintAuth.getRsaKey(d.fL(MMApplicationContext.getContext()), userId, q.aoG());
                if (TextUtils.isEmpty(rsaKey)) {
                    Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "FingerPrintAuth.getRsaKey() is null");
                    rsaKey = FingerPrintAuth.genRsaKey(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG());
                }
                if (TextUtils.isEmpty(rsaKey)) {
                    Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "FingerPrintAuth.genRsaKey() return null");
                    AppMethodBeat.o(64422);
                    return;
                }
                Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "initRsaKey success!");
                AppMethodBeat.o(64422);
            } catch (Exception | UnsatisfiedLinkError e2) {
                Log.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", e2, "", new Object[0]);
                AppMethodBeat.o(64422);
            }
        }
    }
}
