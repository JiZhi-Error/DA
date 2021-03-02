package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static void init() {
        AppMethodBeat.i(227004);
        AppBrandVideoWrapper.setVideoViewFactory(new f() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.f
            public final String getName() {
                return "Factory#AppBrandVideoNonSameLayerStrategy";
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.f
            public final e dU(Context context) {
                AppMethodBeat.i(227003);
                Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "init, use AppBrandExoVideoViewWrapper");
                c cVar = new c(context, (byte) 0);
                AppMethodBeat.o(227003);
                return cVar;
            }
        });
        AppMethodBeat.o(227004);
    }
}
