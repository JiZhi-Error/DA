package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"})
public final class d {
    private static final f ofd = g.ah(a.ofg);
    public static final d ofe = new d();

    private static MultiProcessMMKV VQ() {
        AppMethodBeat.i(51352);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) ofd.getValue();
        AppMethodBeat.o(51352);
        return multiProcessMMKV;
    }

    static {
        AppMethodBeat.i(51351);
        AppMethodBeat.o(51351);
    }

    private d() {
    }

    private static long bYU() {
        AppMethodBeat.i(229568);
        long millis = TimeUnit.MINUTES.toMillis(((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_appbrand_recommend_plugin_pkg_prefetch_interval, 60L));
        AppMethodBeat.o(229568);
        return millis;
    }

    public final void bYV() {
        AppMethodBeat.i(51353);
        if (!c.bYQ()) {
            AppMethodBeat.o(51353);
        } else if (!c.bYS()) {
            AppMethodBeat.o(51353);
        } else if (bYW()) {
            AppMethodBeat.o(51353);
        } else {
            VQ().putLong("KEY_LAST_CHECK_TIMESTAMP", Util.nowMilliSecond());
            ((w) com.tencent.mm.kernel.g.af(w.class)).bb("gh_b489f391e008@app", 0);
            AppMethodBeat.o(51353);
        }
    }

    private static boolean bYW() {
        AppMethodBeat.i(229569);
        if (Util.nowMilliSecond() - VQ().getLong("KEY_LAST_CHECK_TIMESTAMP", 0) <= bYU()) {
            AppMethodBeat.o(229569);
            return true;
        }
        AppMethodBeat.o(229569);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final a ofg = new a();

        static {
            AppMethodBeat.i(51350);
            AppMethodBeat.o(51350);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(51349);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("__appbrand_recommend_fakenative_pkg_predownload_preriod_limit__");
            AppMethodBeat.o(51349);
            return singleMMKV;
        }
    }
}
