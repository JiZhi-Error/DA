package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/AppBrandProcessSharedMMKV;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "SP_NAME", "", "TAG", "UIN", "", "getUIN", "()I", "UIN_BY_SP", "getUIN_BY_SP", "UIN_BY_SP$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
public final class f {
    private static final kotlin.f kIr = g.ah(a.kIt);
    public static final f kIs = new f();

    static {
        AppMethodBeat.i(50163);
        AppMethodBeat.o(50163);
    }

    private f() {
    }

    private static int getUIN() {
        AppMethodBeat.i(227973);
        if (com.tencent.mm.kernel.g.aAc()) {
            p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
            int uin = com.tencent.mm.kernel.a.getUin();
            AppMethodBeat.o(227973);
            return uin;
        }
        int intValue = ((Number) kIr.getValue()).intValue();
        AppMethodBeat.o(227973);
        return intValue;
    }

    public final MultiProcessMMKV VQ() {
        AppMethodBeat.i(50164);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("AppBrandProcessSharedMMKV_" + getUIN());
        AppMethodBeat.o(50164);
        return mmkv;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Integer> {
        public static final a kIt = new a();

        static {
            AppMethodBeat.i(50162);
            AppMethodBeat.o(50162);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(50161);
            Integer valueOf = Integer.valueOf(com.tencent.mm.kernel.a.azs());
            AppMethodBeat.o(50161);
            return valueOf;
        }
    }
}
