package com.tencent.mm.plugin.appbrand.m;

import com.eclipsesource.v8.V8;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.lang.ref.WeakReference;

public final class w {
    private static boolean loA = false;

    static {
        AppMethodBeat.i(107806);
        bMH();
        AppMethodBeat.o(107806);
    }

    public static void bMH() {
        AppMethodBeat.i(107804);
        if (loA) {
            AppMethodBeat.o(107804);
            return;
        }
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_v8_init_flag_new, "");
        String bAc = m.bAc();
        if (!Util.isNullOrNil(a2)) {
            bAc = !Util.isNullOrNil(bAc) ? a2 + " " + bAc : a2;
        }
        if (Util.isNullOrNil(bAc)) {
            bAc = "--min_semi_space_size=4 --max_semi_space_size=8 --wasm_tier_up --wasm_lazy_compilation";
        }
        if (MMApplicationContext.isAppBrandProcess()) {
            bAc = bAc + " --no-wasm-code-gc";
        }
        Log.i("MicroMsg.AppBrandJsRuntimeFactory", "set v8 flag:%s", bAc);
        V8.setFlags(bAc);
        loA = true;
        x.a(new x.a() {
            /* class com.tencent.mm.plugin.appbrand.m.w.AnonymousClass1 */

            @Override // com.tencent.mm.appbrand.v8.x.a
            public final void gz(String str) {
                AppMethodBeat.i(107803);
                h.INSTANCE.kvStat(17693, str);
                AppMethodBeat.o(107803);
            }
        });
        AppMethodBeat.o(107804);
    }

    public static i a(int i2, String str, byte[] bArr, boolean z, boolean z2, boolean z3, com.tencent.mm.plugin.appbrand.jsapi.g gVar) {
        int i3;
        int i4;
        i cVar;
        AppMethodBeat.i(204363);
        IJSRuntime.Config config = new IJSRuntime.Config();
        config.dpj = str;
        config.dpk = bArr;
        String str2 = ((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_native_buffer_use_native, false) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        Log.i("MicroMsg.AppBrandJsRuntimeFactory", "hy: use native buffer type: %s", str2);
        config.dpl = str2;
        config.dpm = ((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_jsbridge_function_direct_evaluate, true);
        config.dpn = z3;
        config.dpo = z;
        config.dpp = z2;
        config.dps = new WeakReference<>(gVar);
        a aVar = a.C0356a.hnM;
        c Fu = a.Fu("100377");
        if (Fu == null || !Fu.isValid()) {
            i3 = 0;
        } else {
            i3 = Util.getInt(Fu.gzz().get("isolateContextLibVersion"), 0);
        }
        a aVar2 = a.C0356a.hnM;
        c Fu2 = a.Fu("100377");
        if (Fu2 == null) {
            Log.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
            i4 = 2;
        } else if (!Fu2.isValid()) {
            Log.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
            i4 = 2;
        } else {
            i4 = Util.getInt(Fu2.gzz().get("JsRuntime"), 2);
            Log.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", Integer.valueOf(i4));
        }
        boolean z4 = i4 == 2 && (i2 >= i3 || i2 == 0);
        Log.i("MicroMsg.AppBrand.JsRuntimeABTests", "supportLibVer:%d currentLibVer:%d userNodeJS:%b", Integer.valueOf(i3), Integer.valueOf(i2), Boolean.valueOf(z4));
        if (z4) {
            cVar = new x(config);
        } else {
            cVar = new c(config);
        }
        if (cVar instanceof c) {
            h.INSTANCE.idkeyStat(434, 5, 1, false);
            Log.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
        } else if (cVar instanceof x) {
            h.INSTANCE.idkeyStat(434, 6, 1, false);
            Log.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
        }
        h.INSTANCE.idkeyStat(434, 0, 1, false);
        AppMethodBeat.o(204363);
        return cVar;
    }

    public static String c(i iVar) {
        if (iVar instanceof c) {
            return "J2V8-Package";
        }
        if (iVar instanceof x) {
            return "NodeJS";
        }
        return "unknown";
    }
}
