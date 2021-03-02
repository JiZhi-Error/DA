package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.api.c;
import com.tencent.mm.api.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/model/BizTeenModeServiceProxy;", "Lcom/tencent/mm/api/IBizTeenModeService;", "()V", "isInited", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "checkInit", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isBizTeenModeAllowAll", "isBizTeenModeDenyAll", "isTeenMode", "release", "reportRemoveBizContact", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "reportTeenModeToast", "scene", "", ch.COL_USERNAME, "", "nickname", "Companion", "plugin-biz_release"})
public final class r implements q {
    public static final a iCt = new a((byte) 0);
    private MultiProcessMMKV cQe;
    private boolean iCs;

    static {
        AppMethodBeat.i(212422);
        AppMethodBeat.o(212422);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/model/BizTeenModeServiceProxy$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void aTL() {
        AppMethodBeat.i(212415);
        if (!this.iCs) {
            String str = com.tencent.mm.kernel.a.azs() + "_biz_teen_mode_mmkv";
            this.cQe = MultiProcessMMKV.getMMKV(str, 2);
            Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo initBizTeenModeServiceProxy key: %s", str);
            this.iCs = true;
        }
        AppMethodBeat.o(212415);
    }

    @Override // com.tencent.mm.api.q
    public final boolean Vt() {
        AppMethodBeat.i(212416);
        aTL();
        MultiProcessMMKV multiProcessMMKV = this.cQe;
        if (multiProcessMMKV != null) {
            boolean z = multiProcessMMKV.getBoolean("is_teen_mode", false);
            AppMethodBeat.o(212416);
            return z;
        }
        AppMethodBeat.o(212416);
        return false;
    }

    @Override // com.tencent.mm.api.q
    public final boolean Vu() {
        int i2 = -1;
        AppMethodBeat.i(212417);
        aTL();
        MultiProcessMMKV multiProcessMMKV = this.cQe;
        boolean z = multiProcessMMKV != null ? multiProcessMMKV.getBoolean("is_teen_mode", false) : false;
        if (!z) {
            AppMethodBeat.o(212417);
            return true;
        }
        MultiProcessMMKV multiProcessMMKV2 = this.cQe;
        if (multiProcessMMKV2 != null) {
            i2 = multiProcessMMKV2.getInt("biz_teen_mode_acct_option", -1);
        }
        Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo isBizTeenModeAllowAll isTeenMode: %b, bizTeenModeAcctOption: %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (!z || i2 == 1) {
            AppMethodBeat.o(212417);
            return true;
        }
        AppMethodBeat.o(212417);
        return false;
    }

    @Override // com.tencent.mm.api.q
    public final boolean Vv() {
        boolean z;
        int i2 = -1;
        AppMethodBeat.i(212418);
        aTL();
        MultiProcessMMKV multiProcessMMKV = this.cQe;
        if (multiProcessMMKV != null) {
            z = multiProcessMMKV.getBoolean("is_teen_mode", false);
        } else {
            z = false;
        }
        MultiProcessMMKV multiProcessMMKV2 = this.cQe;
        if (multiProcessMMKV2 != null) {
            i2 = multiProcessMMKV2.getInt("biz_teen_mode_acct_option", -1);
        }
        Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo isBizTeenModeDenyAll isTeenMode: %b, bizTeenModeAcctOption: %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (!z || i2 != 2) {
            AppMethodBeat.o(212418);
            return false;
        }
        AppMethodBeat.o(212418);
        return true;
    }

    @Override // com.tencent.mm.api.q
    public final void c(c cVar) {
        AppMethodBeat.i(212419);
        Log.w("MicroMsg.BizTeenModeServiceProxy", "reportRemoveBizContact not implemented in non-MM process");
        AppMethodBeat.o(212419);
    }

    @Override // com.tencent.mm.api.q
    public final void o(int i2, String str) {
        AppMethodBeat.i(212420);
        Log.w("MicroMsg.BizTeenModeServiceProxy", "reportTeenModeToast not implemented in non-MM process");
        AppMethodBeat.o(212420);
    }

    @Override // com.tencent.mm.api.q
    public final void d(int i2, String str, String str2) {
        AppMethodBeat.i(212421);
        Log.w("MicroMsg.BizTeenModeServiceProxy", "reportTeenModeToast not implemented in non-MM process");
        AppMethodBeat.o(212421);
    }
}
