package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.security.PublicKey;

public final class o {
    private static o HYc;
    private PublicKey HYd = null;

    public static o fQA() {
        AppMethodBeat.i(70303);
        if (HYc == null) {
            HYc = new o();
        }
        o oVar = HYc;
        AppMethodBeat.o(70303);
        return oVar;
    }

    public final String cs(byte[] bArr) {
        AppMethodBeat.i(70304);
        try {
            this.HYd = m.o(MMApplicationContext.getContext(), "lbs_rsa_public_key.pem");
            Log.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
            String str = new String(Base64.encode(m.a(bArr, this.HYd, EncryptUtil.CIPHER_ALGORITHM), 0));
            AppMethodBeat.o(70304);
            return str;
        } catch (Exception e2) {
            Log.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", e2.getMessage());
            AppMethodBeat.o(70304);
            return "";
        }
    }
}
