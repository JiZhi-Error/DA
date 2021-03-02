package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import android.os.Handler;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

public final class b extends f {
    static /* synthetic */ void a(b bVar, String str, String str2, c.AbstractC0716c cVar) {
        AppMethodBeat.i(234967);
        super.a(str, str2, cVar);
        AppMethodBeat.o(234967);
    }

    public b(Handler handler) {
        super(handler);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a, com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(final String str, final String str2, final c.AbstractC0716c cVar) {
        AppMethodBeat.i(234965);
        i iVar = i.mCD;
        if (i.bKL()) {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(234964);
                    b.a(b.this, str, str2, cVar);
                    AppMethodBeat.o(234964);
                }
            });
            AppMethodBeat.o(234965);
            return;
        }
        super.a(str, str2, cVar);
        AppMethodBeat.o(234965);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f
    public final int q(Uri uri) {
        AppMethodBeat.i(234966);
        i iVar = i.mCD;
        int r = i.r(uri);
        AppMethodBeat.o(234966);
        return r;
    }
}
