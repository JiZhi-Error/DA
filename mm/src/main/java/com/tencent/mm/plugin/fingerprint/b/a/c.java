package com.tencent.mm.plugin.fingerprint.b.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.soter.a.b.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public int dNP = 0;
    public String dNR;
    public String dNS;
    public int errCode = -1;
    public String errMsg;
    public String wFF;
    public String wFG;

    public static c a(a aVar) {
        AppMethodBeat.i(64400);
        c cVar = new c();
        if (aVar.isSuccess()) {
            T t = aVar.RQu;
            if (t != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("json", t.RPZ);
                    jSONObject.put("signature", t.signature);
                    cVar.wFF = t.RPZ;
                    cVar.wFG = t.signature;
                    p.IML.wFO = t;
                    cVar.errCode = 0;
                    Log.i("MicroMsg.BiometricPayAuthenticationResult", "soter authen result: %s, sign: %s", cVar.wFF, cVar.wFG);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.BiometricPayAuthenticationResult", e2, "", new Object[0]);
                    cVar.errCode = 3000;
                }
            } else {
                Log.e("MicroMsg.BiometricPayAuthenticationResult", "signature result is null");
                cVar.errCode = 3000;
            }
        } else if (aVar.errCode == 1007 || aVar.errCode == 1027 || aVar.errCode == 1018) {
            Log.i("MicroMsg.BiometricPayAuthenticationResult", "init error, maybe key invalid. remove former key and give suggestion");
            cVar.errCode = 2007;
            p.IML.wFM = true;
        } else if (aVar.errCode == 1021 || aVar.errCode == 1022) {
            Log.i("MicroMsg.BiometricPayAuthenticationResult", "too many trial");
            cVar.errCode = 10308;
        } else if (aVar.errCode == 1020) {
            Log.i("MicroMsg.BiometricPayAuthenticationResult", "user cancelled");
            cVar.errCode = 2000;
        } else if (aVar.errCode == 1023) {
            Log.e("MicroMsg.BiometricPayAuthenticationResult", "add authenticate task failed");
            cVar.errCode = 2009;
        } else {
            cVar.errCode = 2005;
        }
        AppMethodBeat.o(64400);
        return cVar;
    }

    public static c ai(String str, int i2, int i3) {
        AppMethodBeat.i(64401);
        c cVar = new c();
        cVar.errCode = i2;
        cVar.dNP = i3;
        cVar.dNR = FingerPrintAuth.genPayFPEncrypt(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG(), String.valueOf(i3), y.hhp(), str, Build.MODEL);
        cVar.dNS = FingerPrintAuth.genOpenFPSign(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG(), cVar.dNR);
        AppMethodBeat.o(64401);
        return cVar;
    }
}
