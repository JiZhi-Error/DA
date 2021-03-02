package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/AppBrandExoVideoTextureView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/AppBrandNonSameLayerExoMediaPlayer;", "luggage-commons-jsapi-video-ext_release"})
public final class a extends AbstractVideoTextureView {
    public a(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView
    public final /* synthetic */ c bLb() {
        AppMethodBeat.i(235247);
        b bVar = new b(new Handler(Looper.getMainLooper()));
        AppMethodBeat.o(235247);
        return bVar;
    }
}
