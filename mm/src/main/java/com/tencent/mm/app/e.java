package com.tencent.mm.app;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class e implements j.a {
    private volatile Bitmap dku = null;
    com.tencent.mm.aj.e dkv;

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final void a(j jVar) {
        AppMethodBeat.i(19431);
        if (jVar instanceof e.a) {
            p.aYn().a((e.a) jVar);
        }
        AppMethodBeat.o(19431);
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap Wg() {
        AppMethodBeat.i(19433);
        if (this.dku == null) {
            synchronized (this) {
                try {
                    if (this.dku == null) {
                        this.dku = a.decodeResource(MMApplicationContext.getContext().getResources(), R.raw.default_avatar);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(19433);
                    throw th;
                }
            }
        }
        Bitmap bitmap = this.dku;
        AppMethodBeat.o(19433);
        return bitmap;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap ga(String str) {
        AppMethodBeat.i(19434);
        if (this.dkv == null) {
            this.dkv = p.aYn();
        }
        Bitmap Mk = com.tencent.mm.aj.e.Mk(str);
        AppMethodBeat.o(19434);
        return Mk;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap a(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(19435);
        Bitmap e2 = c.e(str, i2, i3, i4);
        AppMethodBeat.o(19435);
        return e2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap fZ(String str) {
        AppMethodBeat.i(19432);
        Bitmap a2 = c.a(str, false, -1, null);
        AppMethodBeat.o(19432);
        return a2;
    }
}
