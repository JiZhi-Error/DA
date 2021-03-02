package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.jsapi.storage.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048DX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask;", "", "()V", "storage", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePosStorage;", f.NAME, "()Lcom/tencent/mm/plugin/appbrand/pip/PipStablePosStorage;", "storage$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
abstract class q {
    private final kotlin.f nDW = g.ah(a.nDX);

    /* access modifiers changed from: protected */
    public final o bTJ() {
        return (o) this.nDW.getValue();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "com/tencent/mm/plugin/appbrand/pip/StablePosTask$storage$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask$storage$2$1;"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<AnonymousClass1> {
        public static final a nDX = new a();

        static {
            AppMethodBeat.i(229284);
            AppMethodBeat.o(229284);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AnonymousClass1 invoke() {
            AppMethodBeat.i(229283);
            AnonymousClass1 r0 = new o() {
                /* class com.tencent.mm.plugin.appbrand.pip.q.a.AnonymousClass1 */
                private final e nDY;

                {
                    AppMethodBeat.i(229282);
                    b M = com.tencent.luggage.a.e.M(com.tencent.luggage.sdk.customize.a.class);
                    p.g(M, "Luggage.customize(ICusto…zeWxaStorage::class.java)");
                    this.nDY = ((com.tencent.luggage.sdk.customize.a) M).NL();
                    AppMethodBeat.o(229282);
                }

                @Override // com.tencent.mm.plugin.appbrand.pip.o
                public final void a(String str, Point point) {
                    AppMethodBeat.i(229279);
                    p.h(str, "appId");
                    p.h(point, "point");
                    this.nDY.cN(aeD(str), String.valueOf(point.x) + "," + point.y);
                    AppMethodBeat.o(229279);
                }

                @Override // com.tencent.mm.plugin.appbrand.pip.o
                public final Point aeC(String str) {
                    AppMethodBeat.i(229280);
                    p.h(str, "appId");
                    String str2 = this.nDY.get(aeD(str), (String) null);
                    if (str2 == null) {
                        Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "PipStablePosStorage#get, pointStr is null");
                        AppMethodBeat.o(229280);
                        return null;
                    }
                    List<String> a2 = n.a(str2, new String[]{","});
                    if (2 != a2.size()) {
                        Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "PipStablePosStorage#unmarshalPoint, size is not 2");
                        AppMethodBeat.o(229280);
                        return null;
                    }
                    Integer buA = n.buA(a2.get(0));
                    Integer buA2 = n.buA(a2.get(1));
                    if (buA == null || buA2 == null) {
                        Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "PipStablePosStorage#unmarshalPoint, x: " + buA + ", y: " + buA2);
                        AppMethodBeat.o(229280);
                        return null;
                    }
                    Point point = new Point(buA.intValue(), buA2.intValue());
                    AppMethodBeat.o(229280);
                    return point;
                }

                private static String aeD(String str) {
                    AppMethodBeat.i(229281);
                    String str2 = str + "#PipStablePos";
                    AppMethodBeat.o(229281);
                    return str2;
                }
            };
            AppMethodBeat.o(229283);
            return r0;
        }
    }
}
