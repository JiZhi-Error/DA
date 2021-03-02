package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/AppBrandExoVideoView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/ExoVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createVideoTextureView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/IVideoView;", "luggage-commons-jsapi-video-ext_release"})
public final class b extends e {
    public b(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView, com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e
    public final a ea(Context context) {
        AppMethodBeat.i(235248);
        this.mEJ = 1;
        a aVar = new a(context);
        AppMethodBeat.o(235248);
        return aVar;
    }
}
