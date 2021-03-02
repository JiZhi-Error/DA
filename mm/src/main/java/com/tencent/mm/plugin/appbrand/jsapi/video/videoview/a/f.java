package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/ExoVideoViewFactory;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoViewFactory;", "()V", "createVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/ExoVideoViewWrapper;", "context", "Landroid/content/Context;", "getName", "", "luggage-commons-jsapi-video-ext_release"})
public final class f implements com.tencent.mm.plugin.appbrand.jsapi.video.f {
    public static final f mFb = new f();

    static {
        AppMethodBeat.i(235279);
        AppMethodBeat.o(235279);
    }

    private f() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.f
    public final String getName() {
        return "ExoVideoViewFactory";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.f
    public final /* synthetic */ e dU(Context context) {
        AppMethodBeat.i(235278);
        g gVar = new g(context);
        AppMethodBeat.o(235278);
        return gVar;
    }
}
