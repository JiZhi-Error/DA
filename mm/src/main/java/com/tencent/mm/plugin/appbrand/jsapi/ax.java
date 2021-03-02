package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.game.d.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class ax extends aw<c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.s] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.aw
    public final /* synthetic */ Bitmap i(c cVar) {
        AppMethodBeat.i(45466);
        c cVar2 = cVar;
        q runtime = cVar2.getRuntime();
        Log.i("MicroMsg.JsApiCaptureScreenWC", "getBitmapFromView appId:%s, isGame:%b", runtime.mAppId, Boolean.valueOf(runtime.NA()));
        if (runtime.NA()) {
            b bVar = (b) cVar2.S(b.class);
            if (bVar != null) {
                Bitmap a2 = com.tencent.magicbrush.b.a(bVar.getMagicBrush().cLA);
                AppMethodBeat.o(45466);
                return a2;
            }
            Log.printErrStackTrace("MicroMsg.JsApiCaptureScreenWC", new d(), "hy: you're not on game service!", new Object[0]);
            AppMethodBeat.o(45466);
            return null;
        }
        Bitmap i2 = super.i(cVar2);
        AppMethodBeat.o(45466);
        return i2;
    }
}
