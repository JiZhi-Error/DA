package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u001a\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/xeffect/XEffectLib;", "", "()V", "libLoader", "Lkotlin/Function1;", "", "", "load", "name", "setLoader", "loader", "renderlib_release"})
public final class d {
    private static b<? super String, x> RxM = a.RxO;
    public static final d RxN = new d();

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends q implements b<String, x> {
        public static final a RxO = new a();

        static {
            AppMethodBeat.i(237044);
            AppMethodBeat.o(237044);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(237043);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            System.loadLibrary(str2);
            x xVar = x.SXb;
            AppMethodBeat.o(237043);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(237047);
        AppMethodBeat.o(237047);
    }

    private d() {
    }

    public static void R(b<? super String, x> bVar) {
        AppMethodBeat.i(237045);
        p.h(bVar, "loader");
        RxM = bVar;
        AppMethodBeat.o(237045);
    }

    public static final void load(String str) {
        AppMethodBeat.i(237046);
        p.h(str, "name");
        RxM.invoke(str);
        AppMethodBeat.o(237046);
    }
}
