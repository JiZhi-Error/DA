package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.c;
import com.tencent.mm.g.a.x;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.music.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class e extends ab {
    public static final int CTRL_INDEX = 291;
    public static final String NAME = "createAudioInstance";
    private static Vector<String> lDK = new Vector<>();

    static {
        AppMethodBeat.i(145703);
        AppMethodBeat.o(145703);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(145701);
        HashMap hashMap = new HashMap();
        hashMap.put("audioId", k(fVar));
        String n = n("ok", hashMap);
        AppMethodBeat.o(145701);
        return n;
    }

    static String k(f fVar) {
        AppMethodBeat.i(145702);
        final String appId = fVar.getAppId();
        String esG = g.esG();
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", appId, esG);
        a aVar = new a();
        aVar.dtX = esG;
        aVar.cSx = 0;
        aVar.appId = appId;
        aVar.bjm();
        AnonymousClass1 r2 = new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onCreate() {
                AppMethodBeat.i(145695);
                com.tencent.mm.plugin.appbrand.media.a.a.aw(appId, true);
                AppMethodBeat.o(145695);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onResume() {
                AppMethodBeat.i(145696);
                com.tencent.mm.plugin.appbrand.media.a.a.aw(appId, true);
                AppMethodBeat.o(145696);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void a(h.d dVar) {
                AppMethodBeat.i(145697);
                Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", appId);
                com.tencent.mm.plugin.appbrand.media.a.a.aw(appId, false);
                a aVar = new a();
                aVar.cSx = 1;
                aVar.appId = appId;
                aVar.bjm();
                AppMethodBeat.o(145697);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(145698);
                Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", appId);
                a aVar = new a();
                aVar.cSx = 2;
                aVar.appId = appId;
                aVar.bEy();
                h.b(appId, this);
                e.lDK.remove(appId);
                AppMethodBeat.o(145698);
            }
        };
        if (!lDK.contains(appId)) {
            h.a(appId, r2);
            lDK.add(appId);
        }
        AppMethodBeat.o(145702);
        return esG;
    }

    /* access modifiers changed from: package-private */
    public static class a extends a {
        public String appId = "";
        public int cSx = 0;
        public String dtX = "";
        public String jFn = "";

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.d
        public final void YC() {
            AppMethodBeat.i(145699);
            Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", Integer.valueOf(this.cSx));
            this.jFn = "";
            if (this.cSx == 0) {
                this.dtX = c.iS(this.appId, this.dtX);
                Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", this.dtX);
                if (TextUtils.isEmpty(this.dtX)) {
                    this.jFn = "fail to create audio instance";
                }
            } else if (this.cSx == 1) {
                Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
                String str = this.appId;
                Log.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", str);
                x xVar = new x();
                xVar.dCQ.action = 12;
                xVar.dCQ.appId = str;
                com.tencent.mm.plugin.music.b.a.a(xVar);
            } else if (this.cSx == 2) {
                Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
                String str2 = this.appId;
                Log.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", str2);
                x xVar2 = new x();
                xVar2.dCQ.action = 9;
                xVar2.dCQ.appId = str2;
                com.tencent.mm.plugin.music.b.a.a(xVar2);
                com.tencent.mm.plugin.appbrand.media.a.a.acA(this.appId);
            }
            callback();
            AppMethodBeat.o(145699);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.a
        public final void callback() {
            AppMethodBeat.i(145700);
            super.callback();
            if (this.cSx != 0) {
                if (this.cSx != 1) {
                    Log.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
                }
                AppMethodBeat.o(145700);
            } else if (!TextUtils.isEmpty(this.dtX)) {
                Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
                AppMethodBeat.o(145700);
            } else {
                Log.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
                AppMethodBeat.o(145700);
            }
        }
    }
}
