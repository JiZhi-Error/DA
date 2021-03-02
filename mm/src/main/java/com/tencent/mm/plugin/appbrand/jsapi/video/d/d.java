package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class d extends c {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "removeVideoPlayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(234931);
        int optInt = jSONObject.optInt("videoPlayerId", 0);
        AppMethodBeat.o(234931);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(234932);
        Log.i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiRemoveVideoPlayer", "view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(234932);
            return false;
        }
        final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).aB(AppBrandVideoView.class);
        if (appBrandVideoView == null) {
            Log.w("MicroMsg.JsApiRemoveVideoPlayer", "view not AppBrandVideoView");
            AppMethodBeat.o(234932);
            return false;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.d.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(234930);
                appBrandVideoView.clean();
                AppMethodBeat.o(234930);
            }
        });
        super.b(hVar, i2, view, jSONObject);
        AppMethodBeat.o(234932);
        return true;
    }
}
