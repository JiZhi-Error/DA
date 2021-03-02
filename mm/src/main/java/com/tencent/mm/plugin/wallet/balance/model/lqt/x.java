package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.IOException;
import kotlin.n.d;
import org.xwalk.core.XWalkEnvironment;

public final class x {
    private static x HtZ;
    private cux Hua;

    public static x fMZ() {
        AppMethodBeat.i(68491);
        if (HtZ == null) {
            HtZ = new x();
        }
        x xVar = HtZ;
        AppMethodBeat.o(68491);
        return xVar;
    }

    public final void a(cux cux) {
        AppMethodBeat.i(68492);
        Log.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", Integer.valueOf(cux.MAf), Integer.valueOf(cux.MAh), Integer.valueOf(cux.MAg));
        this.Hua = cux;
        if (cux != null) {
            try {
                ((a) g.ah(a.class)).getWalletCacheStg().set(ar.a.USERINFO_LQT_REDEEM_CACHE_STRING_SYNC, new String(cux.toByteArray(), d.ISO_8859_1));
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", e2, "", new Object[0]);
            }
        }
        if (ac.jPE) {
            this.Hua.MAf = XWalkEnvironment.TEST_APK_START_VERSION;
            this.Hua.MAh = 50000000;
            this.Hua.MAg = 50000000;
        }
        AppMethodBeat.o(68492);
    }

    public final cux fNa() {
        AppMethodBeat.i(182502);
        if (this.Hua == null) {
            Log.d("MicroMsg.LqtOnClickRedeemCache", "cache is null");
            String str = (String) ((a) g.ah(a.class)).getWalletCacheStg().get(ar.a.USERINFO_LQT_REDEEM_CACHE_STRING_SYNC, "");
            if (!Util.isNullOrNil(str)) {
                try {
                    this.Hua = (cux) new cux().parseFrom(str.getBytes(d.ISO_8859_1));
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", e2, "", new Object[0]);
                }
            }
        }
        cux cux = this.Hua;
        AppMethodBeat.o(182502);
        return cux;
    }
}
