package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.luggage.game.page.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.q;

@SuppressLint({"ViewConstructor"})
public final class c extends x {
    public c(Context context, q qVar) {
        super(context, qVar, new a((byte) 0));
        AppMethodBeat.i(45176);
        AppMethodBeat.o(45176);
    }

    static final class a extends f {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.page.w.a, com.tencent.luggage.game.page.f
        public final ac a(w wVar) {
            AppMethodBeat.i(174729);
            d dVar = new d();
            dVar.a(new i.d() {
                /* class com.tencent.mm.plugin.appbrand.game.f.c.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
                public final void onForeground() {
                    AppMethodBeat.i(45173);
                    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
                    AppMethodBeat.o(45173);
                }
            });
            dVar.a(new i.b() {
                /* class com.tencent.mm.plugin.appbrand.game.f.c.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                public final void onBackground() {
                    AppMethodBeat.i(45174);
                    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
                    AppMethodBeat.o(45174);
                }
            });
            AppMethodBeat.o(174729);
            return dVar;
        }
    }
}
