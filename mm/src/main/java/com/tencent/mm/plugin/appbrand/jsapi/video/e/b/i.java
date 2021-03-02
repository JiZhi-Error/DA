package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/InferContentTypeLogic;", "", "()V", "inferer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "getInferer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "value", "", "useContentInferer", "getUseContentInferer", "()Z", "setUseContentInferer", "(Z)V", "infer", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"})
public final class i {
    private static boolean mCC = true;
    public static final i mCD = new i();

    static {
        AppMethodBeat.i(235244);
        AppMethodBeat.o(235244);
    }

    private i() {
    }

    public static boolean bKL() {
        return mCC;
    }

    public static void hS(boolean z) {
        AppMethodBeat.i(235242);
        Log.i("MicroMsg.InferContentTypeLogic", "useContentInferer#set, value: ".concat(String.valueOf(z)));
        mCC = z;
        AppMethodBeat.o(235242);
    }

    public static int r(Uri uri) {
        l lVar;
        AppMethodBeat.i(235243);
        boolean z = mCC;
        Log.i("MicroMsg.InferContentTypeLogic", "inferer#get, useContentInferer: ".concat(String.valueOf(z)));
        if (z) {
            lVar = c.mBV;
        } else {
            lVar = l.mCK;
        }
        int r = lVar.r(uri);
        AppMethodBeat.o(235243);
        return r;
    }
}
