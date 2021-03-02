package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.wallet_core.c.y;

public final class e extends IListener<jd> implements i {
    private String dDL = "";
    private boolean wEZ = false;
    private jd wFg;
    private int wFh = 0;
    MMHandler wFi = new MMHandler(Looper.getMainLooper());

    public e() {
        AppMethodBeat.i(64320);
        this.__eventId = jd.class.getName().hashCode();
        AppMethodBeat.o(64320);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(jd jdVar) {
        AppMethodBeat.i(64324);
        boolean a2 = a(jdVar);
        AppMethodBeat.o(64324);
        return a2;
    }

    private boolean a(jd jdVar) {
        boolean z;
        AppMethodBeat.i(64321);
        if (!g.aAc()) {
            Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
            AppMethodBeat.o(64321);
            return false;
        }
        Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
        this.wEZ = false;
        if (!(jdVar instanceof jd)) {
            AppMethodBeat.o(64321);
            return false;
        } else if (!d.dJX()) {
            Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
            jd.b bVar = new jd.b();
            bVar.isSuccess = false;
            this.wFg.dNN = bVar;
            this.wEZ = true;
            ctc();
            AppMethodBeat.o(64321);
            return true;
        } else {
            this.wFg = jdVar;
            g.aAi();
            g.aAg().hqi.a(385, this);
            boolean z2 = this.wFg.dNM.dNO;
            this.wFh = this.wFg.dNM.dNP;
            this.dDL = this.wFg.dNM.dNQ;
            if (!z2) {
                String rsaKey = FingerPrintAuth.getRsaKey(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG());
                if (!TextUtils.isEmpty(rsaKey)) {
                    Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
                    com.tencent.mm.plugin.fingerprint.c.e eVar = new com.tencent.mm.plugin.fingerprint.c.e(rsaKey);
                    g.aAi();
                    g.aAg().hqi.a(eVar, 0);
                    z = false;
                } else {
                    Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
                    z = true;
                }
            } else {
                Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
                z = true;
            }
            if (z) {
                Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
                new o(new a(this, (byte) 0)).bDI();
            }
            AppMethodBeat.o(64321);
            return true;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(64322);
        if (qVar instanceof com.tencent.mm.plugin.fingerprint.c.e) {
            jd.b bVar = new jd.b();
            bVar.isSuccess = false;
            Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + i3 + " errmsg" + str);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
                com.tencent.mm.plugin.fingerprint.c.e eVar = (com.tencent.mm.plugin.fingerprint.c.e) qVar;
                String str2 = eVar.wFp;
                String str3 = eVar.dNS;
                String userId = d.getUserId();
                String aoG = q.aoG();
                String hhp = y.hhp();
                if (!TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(d.fL(MMApplicationContext.getContext()), userId, aoG, String.valueOf(this.wFh), hhp, "", str2, str3, Build.MODEL))) {
                    Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
                    bVar.isSuccess = true;
                } else {
                    Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
                }
                String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(d.fL(MMApplicationContext.getContext()), userId, aoG, String.valueOf(this.wFh), hhp, this.dDL, Build.MODEL);
                String genOpenFPSign = FingerPrintAuth.genOpenFPSign(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG(), genPayFPEncrypt);
                bVar.dNR = genPayFPEncrypt;
                bVar.dNS = genOpenFPSign;
            } else {
                Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
            }
            g.aAi();
            g.aAg().hqi.b(385, this);
            this.wFg.dNN = bVar;
            this.wEZ = true;
            ctc();
        }
        AppMethodBeat.o(64322);
    }

    private void ctc() {
        AppMethodBeat.i(64323);
        Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
        if (this.wFg.callback != null) {
            this.wFg.callback.run();
        }
        if (this.wEZ) {
            this.wFg = null;
        }
        AppMethodBeat.o(64323);
    }

    /* access modifiers changed from: package-private */
    public class a implements o.a {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fingerprint.b.o.a
        public final void ZA(final String str) {
            AppMethodBeat.i(64319);
            e.this.wFi.post(new Runnable() {
                /* class com.tencent.mm.plugin.fingerprint.b.e.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(64318);
                    if (TextUtils.isEmpty(str)) {
                        Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
                    }
                    com.tencent.mm.plugin.fingerprint.c.e eVar = new com.tencent.mm.plugin.fingerprint.c.e(str);
                    g.aAi();
                    g.aAg().hqi.a(eVar, 0);
                    AppMethodBeat.o(64318);
                }
            });
            AppMethodBeat.o(64319);
        }
    }
}
