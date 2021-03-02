package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView;

public final class d extends AbstractVideoTextureView {
    public d(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView
    public final c bLb() {
        AppMethodBeat.i(235190);
        f fVar = new f(new Handler(Looper.getMainLooper()));
        AppMethodBeat.o(235190);
        return fVar;
    }
}
