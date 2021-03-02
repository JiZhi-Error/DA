package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.plugin.teenmode.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/model/BizTeenModeService;", "Lcom/tencent/mm/api/IBizTeenModeService;", "()V", "BIZ_TEEN_MODE_ACCT_OPTION", "", "BIZ_TEEN_MODE_MMKV_KEY_SUFFIX", "BIZ_TEEN_MODE_NO_ACCESS_URL", "IS_TEEN_MODE", "TAG", "bizTeenModeAcctOption", "", "isInit", "", "isTeenMode", "mTeenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "checkInit", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isBizTeenModeAllowAll", "isBizTeenModeDenyAll", "release", "reportRemoveBizContact", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "reportTeenModeToast", "scene", ch.COL_USERNAME, "nickname", "updateTeenModeData", "plugin-biz_release"})
public final class q implements com.tencent.mm.api.q {
    private static MultiProcessMMKV cQe;
    private static boolean iCn;
    private static int iCo;
    private static c iCp = a.iCr;
    public static final q iCq = new q();
    private static boolean isInit;

    static {
        AppMethodBeat.i(212413);
        AppMethodBeat.o(212413);
    }

    private q() {
    }

    public static final /* synthetic */ void aTP() {
        AppMethodBeat.i(212414);
        aTM();
        AppMethodBeat.o(212414);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDataChanged"})
    static final class a implements c {
        public static final a iCr = new a();

        static {
            AppMethodBeat.i(212402);
            AppMethodBeat.o(212402);
        }

        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:7:0x005e  */
        @Override // com.tencent.mm.plugin.teenmode.a.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onDataChanged() {
            /*
            // Method dump skipped, instructions count: 115
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.q.a.onDataChanged():void");
        }
    }

    public static void init() {
        AppMethodBeat.i(212403);
        if (((b) g.af(b.class)) == null) {
            Log.e("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService service null and ignore");
            AppMethodBeat.o(212403);
            return;
        }
        ((b) g.af(b.class)).a(iCp);
        com.tencent.mm.kernel.c.a af = g.af(b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        iCn = ((b) af).Vt();
        com.tencent.mm.kernel.c.a af2 = g.af(b.class);
        p.g(af2, "MMKernel.service(ITeenModeService::class.java)");
        iCo = ((b) af2).fvo();
        int azs = com.tencent.mm.kernel.a.azs();
        if (azs == 0) {
            Log.e("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService invalid account");
            cQe = null;
            AppMethodBeat.o(212403);
            return;
        }
        String str = azs + "_biz_teen_mode_mmkv";
        cQe = MultiProcessMMKV.getMMKV(str, 2);
        aTM();
        isInit = true;
        Log.i("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService key: %s, isTeenMode: %b, bizAcctOption: %d", str, Boolean.valueOf(iCn), Integer.valueOf(iCo));
        AppMethodBeat.o(212403);
    }

    private static void aTL() {
        AppMethodBeat.i(212404);
        if (!isInit) {
            init();
            isInit = true;
        }
        AppMethodBeat.o(212404);
    }

    public static void release() {
        AppMethodBeat.i(212405);
        b bVar = (b) g.af(b.class);
        if (bVar != null) {
            bVar.b(iCp);
            AppMethodBeat.o(212405);
            return;
        }
        AppMethodBeat.o(212405);
    }

    @Override // com.tencent.mm.api.q
    public final boolean Vt() {
        AppMethodBeat.i(212406);
        aTL();
        boolean z = iCn;
        AppMethodBeat.o(212406);
        return z;
    }

    @Override // com.tencent.mm.api.q
    public final boolean Vu() {
        AppMethodBeat.i(212407);
        aTL();
        if (!iCn || iCo == 1) {
            AppMethodBeat.o(212407);
            return true;
        }
        AppMethodBeat.o(212407);
        return false;
    }

    @Override // com.tencent.mm.api.q
    public final boolean Vv() {
        AppMethodBeat.i(212408);
        aTL();
        if (!iCn || iCo != 2) {
            AppMethodBeat.o(212408);
            return false;
        }
        AppMethodBeat.o(212408);
        return true;
    }

    @Override // com.tencent.mm.api.q
    public final void c(com.tencent.mm.api.c cVar) {
        AppMethodBeat.i(212409);
        if (cVar == null) {
            AppMethodBeat.o(212409);
            return;
        }
        if (iCn) {
            String str = cVar.field_username;
            String displayName = aa.getDisplayName(str);
            Log.d("MicroMsg.BizTeenModeService", "reportRemoveBizContact username: %s, nickname: %s", str, displayName);
            h.INSTANCE.a(20911, 1, str, displayName);
        }
        AppMethodBeat.o(212409);
    }

    @Override // com.tencent.mm.api.q
    public final void o(int i2, String str) {
        AppMethodBeat.i(212410);
        if (str == null) {
            AppMethodBeat.o(212410);
            return;
        }
        if (iCn) {
            d(i2, str, aa.getDisplayName(str));
        }
        AppMethodBeat.o(212410);
    }

    @Override // com.tencent.mm.api.q
    public final void d(int i2, String str, String str2) {
        AppMethodBeat.i(212411);
        if (str == null) {
            AppMethodBeat.o(212411);
        } else if (str2 == null) {
            AppMethodBeat.o(212411);
        } else {
            Log.d("MicroMsg.BizTeenModeService", "reportTeenModeToast username: %s, nickname: %s, scene: %d", str, str2, Integer.valueOf(i2));
            h.INSTANCE.a(20912, 1, Integer.valueOf(i2), str, str2);
            AppMethodBeat.o(212411);
        }
    }

    private static void aTM() {
        AppMethodBeat.i(212412);
        Log.v("MicroMsg.BizTeenModeService", "alvinluo updateTeenModeData isTeenMode: %s, bizTeenModeOption: %s", Boolean.valueOf(iCn), Integer.valueOf(iCo));
        MultiProcessMMKV multiProcessMMKV = cQe;
        if (multiProcessMMKV != null) {
            multiProcessMMKV.putBoolean("is_teen_mode", iCn);
        }
        MultiProcessMMKV multiProcessMMKV2 = cQe;
        if (multiProcessMMKV2 != null) {
            multiProcessMMKV2.putInt("biz_teen_mode_acct_option", iCo);
        }
        MultiProcessMMKV multiProcessMMKV3 = cQe;
        if (multiProcessMMKV3 != null) {
            multiProcessMMKV3.apply();
            AppMethodBeat.o(212412);
            return;
        }
        AppMethodBeat.o(212412);
    }
}
