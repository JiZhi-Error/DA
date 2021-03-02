package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.s;

public final class g extends d {
    public g(String str, c cVar, s sVar) {
        super(str, cVar, sVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.d
    public final void cdf() {
        AppMethodBeat.i(135546);
        if (this.oFe != null) {
            b.aXY().a(new b.k() {
                /* class com.tencent.mm.plugin.appbrand.widget.tabbar.g.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void aYg() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void I(Bitmap bitmap) {
                    AppMethodBeat.i(135544);
                    g.this.X(bitmap);
                    AppMethodBeat.o(135544);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void oD() {
                    AppMethodBeat.i(135545);
                    g.this.oFf.a("Failed to load icon via network", g.this);
                    AppMethodBeat.o(135545);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    return g.this.oFe;
                }
            }, this.oFe, (b.h) null);
        }
        AppMethodBeat.o(135546);
    }
}
