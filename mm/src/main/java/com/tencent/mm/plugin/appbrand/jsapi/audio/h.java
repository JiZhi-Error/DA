package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.c;
import com.tencent.mm.g.a.x;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public class h extends d {
    public static final int CTRL_INDEX = 293;
    public static final String NAME = "getAudioState";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(145711);
        if (jSONObject == null) {
            Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(145711);
            return;
        }
        String optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
            fVar.i(i2, h("fail:audioId is empty", null));
            AppMethodBeat.o(145711);
            return;
        }
        a aVar = new a(this, fVar, i2);
        aVar.appId = fVar.getAppId();
        aVar.dtX = optString;
        aVar.bjm();
        AppMethodBeat.o(145711);
    }

    static class a extends a {
        public String appId = "";
        public int dCS;
        public String dtT;
        public String dtX = "";
        public int duration = 0;
        public int dvv;
        public boolean error = false;
        public double iJH;
        public String iJP = null;
        public int iJW;
        public String jFn;
        public int jnj;
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
            AppMethodBeat.i(145709);
            String str = this.dtX;
            x xVar = new x();
            xVar.dCQ.action = 6;
            xVar.dCQ.dtX = str;
            com.tencent.mm.plugin.music.b.a.a(xVar);
            com.tencent.mm.ai.d dVar = xVar.dCR.dCV;
            if (dVar == null) {
                Log.e("MicroMsg.Audio.JsApiGetAudioState", "audioState is null, audioId:%s", this.dtX);
                this.error = true;
                this.jFn = "return parameter is invalid";
                callback();
                AppMethodBeat.o(145709);
            } else if (dVar.duration < 0 || dVar.dCS < 0) {
                Log.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", Integer.valueOf(dVar.duration), Integer.valueOf(dVar.dCS));
                this.error = true;
                this.jFn = "return parameter is invalid";
                callback();
                AppMethodBeat.o(145709);
            } else {
                this.duration = dVar.duration;
                this.dCS = dVar.dCS;
                this.jnj = dVar.tN ? 1 : 0;
                this.dtT = dVar.dtT;
                this.iJW = dVar.iJW;
                this.dvv = dVar.dvv;
                this.iJP = dVar.iJP;
                b LU = c.LU(this.dtX);
                if (LU != null) {
                    this.iJH = LU.iJH;
                }
                Log.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", Integer.valueOf(this.duration), Integer.valueOf(this.dCS), Integer.valueOf(this.jnj), Integer.valueOf(this.iJW), this.dtT, Integer.valueOf(this.dvv), Double.valueOf(this.iJH));
                callback();
                AppMethodBeat.o(145709);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.a
        public final void callback() {
            AppMethodBeat.i(145710);
            if (this.lAx == null) {
                Log.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
                AppMethodBeat.o(145710);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
            hashMap.put("currentTime", Integer.valueOf(this.dCS));
            hashMap.put("paused", Boolean.valueOf(this.jnj == 1));
            hashMap.put("buffered", Integer.valueOf(this.iJW));
            hashMap.put("src", this.dtT);
            hashMap.put("startTime", Integer.valueOf(this.dvv));
            hashMap.put("playbackRate", Double.valueOf(this.iJH));
            hashMap.put("referrerPolicy", this.iJP);
            String str = TextUtils.isEmpty(this.jFn) ? "" : this.jFn;
            if (this.error) {
                Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", str);
                this.lAx.i(this.lqe, this.lAw.h("fail:".concat(String.valueOf(str)), null));
                AppMethodBeat.o(145710);
                return;
            }
            this.lAx.i(this.lqe, this.lAw.n("ok", hashMap));
            AppMethodBeat.o(145710);
        }
    }
}
