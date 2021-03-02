package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a extends f {
    public a() {
        super(null);
    }

    public a(Handler handler, int i2, int i3, int i4) {
        super(handler, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f
    public final int q(Uri uri) {
        AppMethodBeat.i(234963);
        i iVar = i.mCD;
        int r = i.r(uri);
        AppMethodBeat.o(234963);
        return r;
    }
}
