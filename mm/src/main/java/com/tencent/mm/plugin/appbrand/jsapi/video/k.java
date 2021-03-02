package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class k implements j {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j
    public final int v(String str, String str2) {
        AppMethodBeat.i(234642);
        Log.v("WxPlayer/".concat(String.valueOf(str)), str2);
        AppMethodBeat.o(234642);
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j
    public final int d(String str, String str2) {
        AppMethodBeat.i(234643);
        Log.d("WxPlayer/".concat(String.valueOf(str)), str2);
        AppMethodBeat.o(234643);
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j
    public final int i(String str, String str2) {
        AppMethodBeat.i(234644);
        Log.i("WxPlayer/".concat(String.valueOf(str)), str2);
        AppMethodBeat.o(234644);
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j
    public final int w(String str, String str2) {
        AppMethodBeat.i(234645);
        Log.w("WxPlayer/".concat(String.valueOf(str)), str2);
        AppMethodBeat.o(234645);
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j
    public final int e(String str, String str2) {
        AppMethodBeat.i(234646);
        Log.e("WxPlayer/".concat(String.valueOf(str)), str2);
        AppMethodBeat.o(234646);
        return 1;
    }
}
