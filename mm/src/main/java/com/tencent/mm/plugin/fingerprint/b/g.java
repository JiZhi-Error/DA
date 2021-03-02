package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.b.o;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.fingerprint.c.f;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class g implements d {
    int dNP;
    private String dNS = null;
    private String kof = null;
    MMHandler wFi = new MMHandler(new MMHandler.Callback() {
        /* class com.tencent.mm.plugin.fingerprint.b.g.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(64327);
            if (1 == message.what) {
                String string = message.getData().getString("rsaKey");
                if (TextUtils.isEmpty(string)) {
                    Log.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + message.what + " rsaKey is null");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.fingerprint.b.g.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(64326);
                            g.this.wFm.bg(-1, g.this.wFo.getString(R.string.dbz));
                            AppMethodBeat.o(64326);
                        }
                    });
                }
                g.this.wFo.doSceneProgress(new e(string), false);
                AppMethodBeat.o(64327);
                return true;
            }
            AppMethodBeat.o(64327);
            return false;
        }
    });
    b wFm = null;
    private b wFn = null;
    WalletBaseUI wFo = null;
    private String wFp = null;

    public g() {
        AppMethodBeat.i(64332);
        AppMethodBeat.o(64332);
    }

    class a implements o.a {
        private a() {
        }

        /* synthetic */ a(g gVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fingerprint.b.o.a
        public final void ZA(final String str) {
            AppMethodBeat.i(64331);
            if (TextUtils.isEmpty(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fingerprint.b.g.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(64329);
                        g.this.wFm.bg(-1, g.this.wFo.getString(R.string.dbz));
                        AppMethodBeat.o(64329);
                    }
                });
                Log.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
                AppMethodBeat.o(64331);
                return;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.fingerprint.b.g.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(64330);
                    Log.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
                    Message obtainMessage = g.this.wFi.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("rsaKey", str);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    AppMethodBeat.o(64330);
                }
            });
            AppMethodBeat.o(64331);
        }
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(Context context, b bVar, String str) {
        AppMethodBeat.i(64333);
        this.wFo = (WalletBaseUI) context;
        this.wFm = bVar;
        this.kof = str;
        String rsaKey = FingerPrintAuth.getRsaKey(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG());
        com.tencent.mm.plugin.soter.d.a.flI();
        if (TextUtils.isEmpty(rsaKey)) {
            Log.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
            new o(new a(this, (byte) 0)).bDI();
            AppMethodBeat.o(64333);
            return;
        }
        Log.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
        this.wFo.doSceneProgress(new e(rsaKey), false);
        AppMethodBeat.o(64333);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void clear() {
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        b bVar;
        int i4 = 0;
        AppMethodBeat.i(64334);
        if (qVar instanceof e) {
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
                e eVar = (e) qVar;
                this.wFp = eVar.wFp;
                this.dNS = eVar.dNS;
                bVar = this.wFm;
                str = "";
            } else {
                Log.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
                bVar = this.wFm;
                i4 = -1;
                if (Util.isNullOrNil(str)) {
                    str = this.wFo.getString(R.string.dbz);
                }
            }
            bVar.bg(i4, str);
            AppMethodBeat.o(64334);
            return true;
        } else if (qVar instanceof f) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.soter.d.a.flJ();
                com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
                this.wFn.bg(0, "");
            } else {
                this.wFn.bg(-2, "");
            }
            AppMethodBeat.o(64334);
            return true;
        } else {
            AppMethodBeat.o(64334);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(b bVar, int i2) {
        String str;
        AppMethodBeat.i(64335);
        this.wFn = bVar;
        if (TextUtils.isEmpty(this.kof)) {
            Log.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
            bVar.bg(-1, this.wFo.getString(R.string.dbz));
            AppMethodBeat.o(64335);
            return;
        }
        String userId = d.getUserId();
        String aoG = q.aoG();
        String hhp = y.hhp();
        String str2 = "";
        if (d.dJX()) {
            str = FingerPrintAuth.genOpenFPEncrypt(d.fL(MMApplicationContext.getContext()), userId, aoG, String.valueOf(this.dNP), hhp, "", this.wFp, this.dNS, Build.MODEL);
            str2 = FingerPrintAuth.genOpenFPSign(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG(), str);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(this.wFp)) {
            Log.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
        } else if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
        this.wFo.doSceneProgress(new f(str, str2, this.kof, i2), false);
        AppMethodBeat.o(64335);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.d
    public final void a(Context context, final b bVar) {
        AppMethodBeat.i(64336);
        ((i) com.tencent.mm.kernel.g.af(i.class)).a(context, new com.tencent.mm.plugin.fingerprint.b.a.f("", (byte) 0), new com.tencent.mm.plugin.fingerprint.b.a.b() {
            /* class com.tencent.mm.plugin.fingerprint.b.g.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.fingerprint.b.a.b
            public final void a(c cVar) {
                AppMethodBeat.i(64328);
                Log.i("MicroMsg.HwFingerprintOpenDelegate", "result: %s", Integer.valueOf(cVar.errCode));
                String str = "";
                switch (cVar.errCode) {
                    case 0:
                        Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify success");
                        g.this.dNP = cVar.dNP;
                        bVar.bg(0, "");
                        AppMethodBeat.o(64328);
                        return;
                    case 2001:
                        Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify timeout");
                        break;
                    case 2002:
                        Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
                        bVar.bg(-1, "");
                        AppMethodBeat.o(64328);
                        return;
                    case 2005:
                        str = MMApplicationContext.getContext().getString(R.string.hd6);
                        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, cVar.errCode, "fingerprint error");
                        break;
                    case 2007:
                    case 10308:
                        Log.i("MicroMsg.HwFingerprintOpenDelegate", "hy: on error: %s", Integer.valueOf(cVar.errCode));
                        str = MMApplicationContext.getContext().getString(R.string.hd4);
                        if (cVar.errCode == 10308) {
                            str = MMApplicationContext.getContext().getString(R.string.hd5);
                            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                            break;
                        }
                        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, cVar.errCode, "fingerprint error");
                        break;
                }
                bVar.bg(-2, str);
                AppMethodBeat.o(64328);
            }
        });
        AppMethodBeat.o(64336);
    }
}
