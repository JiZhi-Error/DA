package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class c implements e {
    @Override // com.tencent.mm.plugin.appbrand.canvas.e
    public final Bitmap a(d dVar, String str) {
        AppMethodBeat.i(47473);
        Bitmap a2 = a(dVar, str, null);
        AppMethodBeat.o(47473);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.e
    public final Bitmap a(d dVar, String str, e.a aVar) {
        AppMethodBeat.i(47474);
        Bitmap a2 = a(dVar, str, null, aVar);
        AppMethodBeat.o(47474);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.e
    public final Bitmap a(final d dVar, final String str, Rect rect, final e.a aVar) {
        AppMethodBeat.i(47475);
        f fVar = dVar.czm;
        Bitmap a2 = ((a) fVar.M(a.class)).a(((b) fVar.M(b.class)).b(fVar, str), rect, new a.b() {
            /* class com.tencent.mm.plugin.appbrand.luggage.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.f.a.b
            public final void Q(Bitmap bitmap) {
                AppMethodBeat.i(47472);
                if (aVar == null || bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(47472);
                    return;
                }
                aVar.a(dVar);
                AppMethodBeat.o(47472);
            }
        });
        AppMethodBeat.o(47475);
        return a2;
    }
}
