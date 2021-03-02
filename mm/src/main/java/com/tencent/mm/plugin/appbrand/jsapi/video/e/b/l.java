package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/UrlContentTypeInferer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "()V", "infer", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"})
public final class l implements h {
    public static final l mCK = new l();

    static {
        AppMethodBeat.i(235246);
        AppMethodBeat.o(235246);
    }

    private l() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h
    public final int r(Uri uri) {
        AppMethodBeat.i(235245);
        if (uri == null || !com.tencent.mm.plugin.appbrand.jsapi.video.l.aaW(uri.toString())) {
            AppMethodBeat.o(235245);
            return 3;
        }
        AppMethodBeat.o(235245);
        return 2;
    }
}
