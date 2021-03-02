package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.game.luggage.d.a.c;
import com.tencent.mm.plugin.game.luggage.d.a.e;
import com.tencent.mm.plugin.game.luggage.d.a.f;
import com.tencent.mm.plugin.game.luggage.d.a.g;
import com.tencent.mm.plugin.game.luggage.d.a.i;
import com.tencent.mm.plugin.game.luggage.d.a.j;
import com.tencent.mm.plugin.game.luggage.d.a.k;
import com.tencent.mm.plugin.game.luggage.d.a.l;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class d implements com.tencent.mm.plugin.game.luggage.a.a {
    static /* synthetic */ void CS(String str) {
        AppMethodBeat.i(82991);
        azB(str);
        AppMethodBeat.o(82991);
    }

    @Override // com.tencent.mm.plugin.game.luggage.a.a
    public final String azz(String str) {
        AppMethodBeat.i(82988);
        b.gam();
        String aXS = b.aXS(str);
        AppMethodBeat.o(82988);
        return aXS;
    }

    @Override // com.tencent.mm.plugin.game.luggage.a.a
    public final boolean azA(String str) {
        AppMethodBeat.i(82989);
        if (MMApplicationContext.isMainProcess()) {
            azB(str);
        } else {
            h.a(MainProcessIPCService.dkO, new IPCString(str), a.class, null);
        }
        AppMethodBeat.o(82989);
        return false;
    }

    @Override // com.tencent.mm.plugin.game.luggage.a.a
    public final Map<String, Class> dTm() {
        AppMethodBeat.i(186826);
        HashMap hashMap = new HashMap();
        hashMap.put(JsApiAddDownloadTaskStraight.NAME, com.tencent.mm.plugin.game.luggage.d.a.a.class);
        hashMap.put("bookDownloadGame", com.tencent.mm.plugin.game.luggage.d.a.b.class);
        hashMap.put(JsApiCancelDownloadTask.NAME, c.class);
        hashMap.put("getDownloadWidgetTaskInfos", com.tencent.mm.plugin.game.luggage.d.a.d.class);
        hashMap.put(JsApiGetInstallState.NAME, e.class);
        hashMap.put(JsApiInstallDownloadTask.NAME, f.class);
        hashMap.put("jumpDownloaderWidget", g.class);
        hashMap.put("launchApplication", com.tencent.mm.plugin.game.luggage.d.a.h.class);
        hashMap.put(JsApiPauseDownloadTask.NAME, i.class);
        hashMap.put(JsApiQueryDownloadTask.NAME, j.class);
        hashMap.put(JsApiResumeDownloadTask.NAME, k.class);
        hashMap.put("startGameWebview", l.class);
        hashMap.put("startGameWebView", l.class);
        AppMethodBeat.o(186826);
        return hashMap;
    }

    static class a implements com.tencent.mm.ipcinvoker.b<IPCString, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(82987);
            d.CS(iPCString.value);
            AppMethodBeat.o(82987);
        }
    }

    private static void azB(String str) {
        AppMethodBeat.i(82990);
        Log.i("MicroMsg.LuggageGameService", "clearGameCache key:%s", str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        b.gam().b("wx62d9035fd4fd2059", jSONArray);
        AppMethodBeat.o(82990);
    }
}
