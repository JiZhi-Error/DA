package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.a.d.a;
import com.tencent.soter.core.c.j;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k extends a {
    private a wFx = null;

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void dJV() {
        AppMethodBeat.i(64349);
        Log.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
        this.wEX.prepare();
        AppMethodBeat.o(64349);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJW() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void fK(Context context) {
        AppMethodBeat.i(64350);
        Log.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
        AppMethodBeat.o(64350);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    @TargetApi(16)
    public final int a(final c cVar, boolean z) {
        AppMethodBeat.i(64352);
        if (z) {
            Log.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
            AppMethodBeat.o(64352);
        } else {
            this.wEX.a(MMApplicationContext.getContext(), new f(p.IML.wFE), new b() {
                /* class com.tencent.mm.plugin.fingerprint.b.k.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.fingerprint.b.a.b
                public final void a(com.tencent.mm.plugin.fingerprint.b.a.c cVar) {
                    AppMethodBeat.i(64344);
                    cVar.gz(cVar.errCode, -1);
                    AppMethodBeat.o(64344);
                }
            });
            AppMethodBeat.o(64352);
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final int a(final c cVar) {
        AppMethodBeat.i(64353);
        Log.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", 3000);
        final MTimerHandler mTimerHandler = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.fingerprint.b.k.AnonymousClass2 */
            final /* synthetic */ int nim = 3000;

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(64345);
                Log.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", Integer.valueOf(this.nim));
                k.this.wEX.cancel();
                cVar.gz(2000, -1);
                AppMethodBeat.o(64345);
                return false;
            }
        }, false);
        mTimerHandler.startTimer(3000);
        this.wEX.b(MMApplicationContext.getContext(), new f(p.IML.wFE), new b() {
            /* class com.tencent.mm.plugin.fingerprint.b.k.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.fingerprint.b.a.b
            public final void a(com.tencent.mm.plugin.fingerprint.b.a.c cVar) {
                AppMethodBeat.i(64346);
                mTimerHandler.stopTimer();
                cVar.gz(cVar.errCode, -1);
                AppMethodBeat.o(64346);
            }
        });
        AppMethodBeat.o(64353);
        return 0;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void a(ow owVar, int i2) {
        AppMethodBeat.i(64354);
        Log.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
        owVar.dUR.dUV = dJS();
        owVar.dUR.errCode = !Util.isNullOrNil(owVar.dUR.dUV) ? 0 : 1;
        owVar.dUR.dUW = 2;
        owVar.dUR.dNR = "";
        owVar.dUR.dNS = "";
        if (owVar.dUQ.dUU != null) {
            owVar.dUQ.dUU.run();
        }
        AppMethodBeat.o(64354);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a, com.tencent.mm.plugin.fingerprint.b.a
    public final String dJS() {
        AppMethodBeat.i(64355);
        j jVar = p.IML.wFO;
        if (jVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("json", jVar.RPZ);
                jSONObject.put("signature", jVar.signature);
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.o(64355);
                return jSONObject2;
            } catch (JSONException e2) {
                Log.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", e2.toString());
                Log.printErrStackTrace("MicroMsg.SoterAuthMgrImp", e2, "", new Object[0]);
                AppMethodBeat.o(64355);
                return "";
            }
        } else {
            Log.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
            AppMethodBeat.o(64355);
            return "";
        }
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final Map<String, String> dJZ() {
        AppMethodBeat.i(64357);
        Map<String, String> dJY = dJY();
        AppMethodBeat.o(64357);
        return dJY;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        AppMethodBeat.i(64359);
        Log.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", Boolean.valueOf(z), Boolean.valueOf(z2), bundle);
        this.wEX.a(z, z2, p.IML.wFM, bundle);
        AppMethodBeat.o(64359);
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final int type() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJT() {
        AppMethodBeat.i(64347);
        boolean fN = this.wEX.fN(MMApplicationContext.getContext());
        AppMethodBeat.o(64347);
        return fN;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJU() {
        AppMethodBeat.i(64348);
        boolean dKr = this.wEX.dKr();
        AppMethodBeat.o(64348);
        return dKr;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJX() {
        AppMethodBeat.i(64351);
        boolean dKq = this.wEX.dKq();
        AppMethodBeat.o(64351);
        return dKq;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final Map<String, String> dJY() {
        AppMethodBeat.i(64356);
        Map<String, String> dJY = this.wEX.dJY();
        AppMethodBeat.o(64356);
        return dJY;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dKa() {
        AppMethodBeat.i(64358);
        boolean dKw = this.wEX.dKw();
        Log.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", Boolean.valueOf(dKw));
        AppMethodBeat.o(64358);
        return dKw;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a, com.tencent.mm.plugin.fingerprint.b.a
    public final boolean dJP() {
        AppMethodBeat.i(64360);
        boolean dKt = this.wEX.dKt();
        AppMethodBeat.o(64360);
        return dKt;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void userCancel() {
        AppMethodBeat.i(64361);
        this.wEX.cancel();
        AppMethodBeat.o(64361);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dKb() {
        AppMethodBeat.i(64362);
        boolean fO = this.wEX.fO(MMApplicationContext.getContext());
        AppMethodBeat.o(64362);
        return fO;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dKc() {
        AppMethodBeat.i(64363);
        boolean dKs = this.wEX.dKs();
        AppMethodBeat.o(64363);
        return dKs;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a, com.tencent.mm.plugin.fingerprint.b.a
    public final boolean dJQ() {
        AppMethodBeat.i(64364);
        boolean dJQ = this.wEX.dJQ();
        AppMethodBeat.o(64364);
        return dJQ;
    }
}
