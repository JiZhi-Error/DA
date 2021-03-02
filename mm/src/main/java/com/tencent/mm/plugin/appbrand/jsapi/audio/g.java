package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g extends d {
    public static final int CTRL_INDEX = 290;
    public static final String NAME = "destroyAudioInstance";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(145708);
        a(fVar, jSONObject, i2, fVar.getJsRuntime());
        AppMethodBeat.o(145708);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2, o oVar) {
        AppMethodBeat.i(256424);
        if (jSONObject == null) {
            Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(256424);
            return;
        }
        Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", jSONObject.toString());
        String optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
            fVar.i(i2, h("fail:audioId is empty", null));
            AppMethodBeat.o(256424);
            return;
        }
        a aVar = new a(this, fVar, i2);
        aVar.appId = fVar.getAppId();
        aVar.dtX = optString;
        aVar.bjm();
        c.INSTANCE.Zm(fVar.getAppId()).remove(optString);
        AppMethodBeat.o(256424);
    }

    /* access modifiers changed from: package-private */
    public static class a extends a {
        public String appId = "";
        public String dtX = "";
        public boolean error = false;
        private p lAw;
        public f lAx;
        public int lqe;

        public a(p pVar, f fVar, int i2) {
            this.lAw = pVar;
            this.lAx = fVar;
            this.lqe = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.d
        public final void YC() {
            AppMethodBeat.i(145706);
            Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
            this.error = c.aGW(this.dtX);
            callback();
            AppMethodBeat.o(145706);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.a
        public final void callback() {
            AppMethodBeat.i(145707);
            super.callback();
            Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
            if (this.lAx == null) {
                Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
                AppMethodBeat.o(145707);
            } else if (this.error) {
                this.lAx.i(this.lqe, this.lAw.h("fail", null));
                AppMethodBeat.o(145707);
            } else {
                this.lAx.i(this.lqe, this.lAw.h("ok", null));
                AppMethodBeat.o(145707);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p
    public final boolean bEi() {
        return true;
    }
}
