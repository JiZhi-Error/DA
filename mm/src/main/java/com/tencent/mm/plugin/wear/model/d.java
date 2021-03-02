package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.plugin.wear.model.a.b;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d {
    b IxF = new a();
    com.tencent.mm.plugin.wear.model.e.b IxG = new com.tencent.mm.plugin.wear.model.e.b();
    public i IxH = new i();
    j IxI = new j();
    p IxJ = new p();

    public d() {
        AppMethodBeat.i(29980);
        AppMethodBeat.o(29980);
    }

    public final boolean fVW() {
        AppMethodBeat.i(29981);
        if (fVX() == null || fVX().fWb().size() <= 0) {
            AppMethodBeat.o(29981);
            return false;
        }
        AppMethodBeat.o(29981);
        return true;
    }

    public final b fVX() {
        AppMethodBeat.i(29982);
        if (!this.IxF.isAvailable() || !this.IxF.fWc()) {
            AppMethodBeat.o(29982);
            return null;
        }
        b bVar = this.IxF;
        AppMethodBeat.o(29982);
        return bVar;
    }

    public final boolean cv(byte[] bArr) {
        b.a w;
        AppMethodBeat.i(29983);
        if (bArr == null) {
            AppMethodBeat.o(29983);
            return false;
        } else if (!fVW()) {
            AppMethodBeat.o(29983);
            return false;
        } else {
            MMApplicationContext.getContext();
            String format = String.format("/wechat/%s/%d", "phone", Long.valueOf(System.currentTimeMillis()));
            b fVX = fVX();
            if (fVX == null) {
                AppMethodBeat.o(29983);
                return false;
            }
            if (bArr.length > 92160) {
                w = fVX.x(format, bArr);
            } else {
                w = fVX.w(format, bArr);
            }
            if (w.code == 0) {
                AppMethodBeat.o(29983);
                return true;
            }
            AppMethodBeat.o(29983);
            return false;
        }
    }

    public final byte[] cw(byte[] bArr) {
        byte[] bArr2 = null;
        AppMethodBeat.i(29984);
        byte[] sessionKey = this.IxG.getSessionKey();
        if (bArr == null || sessionKey == null) {
            AppMethodBeat.o(29984);
        } else {
            try {
                Log.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", g.getMessageDigest(sessionKey));
                SecretKeySpec secretKeySpec = new SecretKeySpec(sessionKey, "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(2, secretKeySpec);
                bArr2 = instance.doFinal(bArr);
                AppMethodBeat.o(29984);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e2, "", new Object[0]);
                AppMethodBeat.o(29984);
            }
        }
        return bArr2;
    }

    public final byte[] cx(byte[] bArr) {
        byte[] bArr2 = null;
        AppMethodBeat.i(29985);
        byte[] sessionKey = this.IxG.getSessionKey();
        if (bArr == null || sessionKey == null) {
            AppMethodBeat.o(29985);
        } else {
            try {
                Log.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", g.getMessageDigest(sessionKey));
                bArr2 = com.tencent.mm.plugin.wear.a.a.j(bArr, sessionKey);
                AppMethodBeat.o(29985);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e2, "", new Object[0]);
                AppMethodBeat.o(29985);
            }
        }
        return bArr2;
    }
}
