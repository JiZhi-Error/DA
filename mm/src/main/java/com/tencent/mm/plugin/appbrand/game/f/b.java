package com.tencent.mm.plugin.appbrand.game.f;

import android.util.Base64;
import com.tencent.luggage.game.page.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.protocal.protobuf.fdn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public final class b {
    WeakReference<AppBrandRuntime> cuB;
    public fdn lsZ;
    public MMHandler lta = new MMHandler("canvas_security_guard");
    public PublicKey ltb;

    b(fdn fdn, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(45170);
        this.lsZ = fdn;
        this.cuB = new WeakReference<>(appBrandRuntime);
        if (this.lsZ == null || this.lsZ.Nzg == null || this.lsZ.Nzg.zy == null) {
            Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: no pubkey retrieved");
            this.ltb = null;
            AppMethodBeat.o(45170);
            return;
        }
        try {
            this.ltb = KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(new String(this.lsZ.Nzg.zy).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0)));
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.WAGameCanvasSecurityGuard", th, "hy: can not retrieve rsa key!", new Object[0]);
            this.ltb = null;
        }
        Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: sample config: %s", this.lsZ.Nzf);
        AppMethodBeat.o(45170);
    }

    public final boolean bDk() {
        return this.lsZ != null && this.lsZ.NyX;
    }

    public final d bDl() {
        AppMethodBeat.i(45171);
        if (bsz() != null) {
            d dVar = (d) bsz().S(d.class);
            AppMethodBeat.o(45171);
            return dVar;
        }
        Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: GamePageLogicExt not found");
        AppMethodBeat.o(45171);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final ag bsz() {
        AppMethodBeat.i(180199);
        if (this.cuB.get() == null || this.cuB.get().brh() == null || this.cuB.get().brh().getCurrentPage() == null || !(this.cuB.get().brh().getCurrentPage().getCurrentPageView() instanceof ag)) {
            Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: runtime released");
            AppMethodBeat.o(180199);
            return null;
        }
        ag agVar = (ag) this.cuB.get().brh().getCurrentPage().getCurrentPageView();
        AppMethodBeat.o(180199);
        return agVar;
    }

    public final boolean bDm() {
        AppMethodBeat.i(45172);
        if (bDl() == null || bDl().MQ() == null || bDl().MQ().getMagicBrush().isDestroyed()) {
            AppMethodBeat.o(45172);
            return false;
        }
        AppMethodBeat.o(45172);
        return true;
    }
}
