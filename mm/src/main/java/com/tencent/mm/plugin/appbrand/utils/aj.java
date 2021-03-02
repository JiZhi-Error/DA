package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/WeChatNFCSwitcher;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/IHostNFCSwitcher;", "()V", "disableHostNFC", "", "enableHostNFC", "isNFCUsing", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "toggleWeChatNFCLogicUI", "enable", "plugin-appbrand-integration_release"})
public final class aj implements c {
    public static final aj ohH = new aj();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "enabled", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class a<T> implements d<ResultType> {
        public static final a ohI = new a();

        static {
            AppMethodBeat.i(229603);
            AppMethodBeat.o(229603);
        }

        a() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(229602);
            IPCBoolean iPCBoolean = (IPCBoolean) obj;
            Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "enableHostNFC, enabled: ".concat(String.valueOf(iPCBoolean)));
            if (iPCBoolean.value) {
                aj ajVar = aj.ohH;
                aj.bZw();
            }
            AppMethodBeat.o(229602);
        }
    }

    static {
        AppMethodBeat.i(229608);
        AppMethodBeat.o(229608);
    }

    private aj() {
    }

    public static final /* synthetic */ void bZw() {
        AppMethodBeat.i(229609);
        iW(true);
        AppMethodBeat.o(229609);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.c
    public final boolean u(f fVar) {
        AppMethodBeat.i(229604);
        p.h(fVar, "component");
        c.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.miO;
        boolean u = c.a.u(fVar);
        AppMethodBeat.o(229604);
        return u;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.c
    public final void bHK() {
        AppMethodBeat.i(229605);
        Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "enableHostNFC");
        h.a(MainProcessIPCService.dkO, null, ae.class, a.ohI);
        AppMethodBeat.o(229605);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.c
    public final void bHL() {
        AppMethodBeat.i(229606);
        Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "disableHostNFC");
        iW(false);
        AppMethodBeat.o(229606);
    }

    private static void iW(boolean z) {
        int i2;
        AppMethodBeat.i(229607);
        Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "toggleWeChatNFCLogicUI, enable: ".concat(String.valueOf(z)));
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        packageManager.setComponentEnabledSetting(componentName, i2, 1);
        AppMethodBeat.o(229607);
    }
}
