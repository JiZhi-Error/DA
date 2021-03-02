package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.g.a.x;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tav.core.AssetExtension;
import org.json.JSONObject;

public class i extends d {
    public static final int CTRL_INDEX = 297;
    public static final String NAME = "operateAudio";
    private l.a lDW;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        long j2 = 0;
        AppMethodBeat.i(145729);
        if (!com.tencent.mm.plugin.appbrand.media.a.a.acB(fVar.getAppId())) {
            Log.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
            fVar.i(i2, h("fail:App is paused or background", null));
            AppMethodBeat.o(145729);
        } else if (jSONObject == null) {
            Log.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(145729);
        } else {
            Log.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", fVar.getAppId(), jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("currentTime", 0);
            String optString2 = jSONObject.optString("operationType");
            if (TextUtils.isEmpty(optString)) {
                Log.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
                fVar.i(i2, h("fail:audioId is empty", null));
                AppMethodBeat.o(145729);
            } else if (TextUtils.isEmpty(optString2)) {
                Log.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
                fVar.i(i2, h("fail:operationType is empty", null));
                AppMethodBeat.o(145729);
            } else {
                if (this.lDW == null) {
                    this.lDW = new l.a(fVar);
                }
                this.lDW.appId = fVar.getAppId();
                this.lDW.bjm();
                a aVar = new a(this, fVar, i2);
                aVar.appId = fVar.getAppId();
                aVar.dtX = optString;
                aVar.dCS = optInt;
                aVar.lDX = optString2;
                if (optString2.equalsIgnoreCase(AssetExtension.SCENE_PLAY)) {
                    long optLong = jSONObject.optLong(AppMeasurement.Param.TIMESTAMP, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (optLong > 0 && optLong < currentTimeMillis) {
                        j2 = currentTimeMillis - optLong;
                    }
                    aVar.iJJ = j2;
                    aVar.iJK = currentTimeMillis;
                }
                c acz = com.tencent.mm.plugin.appbrand.media.a.a.acz(optString);
                if (acz != null) {
                    aVar.lDY = acz.lDY;
                    aVar.lDZ = acz.lDZ;
                    aVar.dtT = acz.dtT;
                }
                aVar.processName = MMApplicationContext.getProcessName();
                aVar.bjm();
                AppMethodBeat.o(145729);
            }
        }
    }

    static final class a extends a {
        public String appId = "";
        public int dCS = 0;
        public String dtT = "";
        public String dtX = "";
        public boolean error = false;
        public long iJJ;
        public long iJK;
        public String jFn;
        private p lAw;
        public f lAx;
        public String lDX = "";
        public String lDY;
        public WxaPkg.Info lDZ;
        public int lqe;
        public String processName = "";

        public a(p pVar, f fVar, int i2) {
            this.lAw = pVar;
            this.lAx = fVar;
            this.lqe = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.d
        public final void YC() {
            boolean aGU;
            AppMethodBeat.i(145727);
            Log.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", this.lDX);
            this.error = false;
            String str = this.lDX;
            if (str.equalsIgnoreCase(AssetExtension.SCENE_PLAY)) {
                b LU = com.tencent.mm.ai.c.LU(this.dtX);
                if (LU == null) {
                    Log.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
                    LU = com.tencent.mm.plugin.appbrand.media.a.b.a(this.lAx, this.appId, this.dtX, this.dtT, this.lDY, this.lDZ, this.processName);
                }
                if (LU != null) {
                    LU.iJN = this.iJJ;
                    LU.iJO = this.iJK;
                }
                String str2 = this.dtX;
                Log.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", str2);
                x xVar = new x();
                xVar.dCQ.action = 1;
                xVar.dCQ.dtX = str2;
                xVar.dCQ.dCT = LU;
                com.tencent.mm.plugin.music.b.a.a(xVar);
                if (xVar.dCR.result) {
                    Log.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
                } else if (com.tencent.mm.ai.c.LT(this.dtX)) {
                    this.error = true;
                    this.jFn = "audio is playing, don't play again";
                } else {
                    this.error = true;
                    this.jFn = "play audio fail";
                }
            } else if (str.equalsIgnoreCase("pause")) {
                String str3 = this.dtX;
                Log.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", str3);
                x xVar2 = new x();
                xVar2.dCQ.action = 2;
                xVar2.dCQ.dtX = str3;
                com.tencent.mm.plugin.music.b.a.a(xVar2);
                if (xVar2.dCR.result) {
                    Log.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
                } else {
                    this.error = true;
                    this.jFn = "pause audio fail";
                }
            } else if (str.equalsIgnoreCase("seek")) {
                Log.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", Integer.valueOf(this.dCS));
                if (this.dCS < 0) {
                    Log.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", Integer.valueOf(this.dCS));
                    this.error = true;
                    this.jFn = "currentTime is invalid";
                } else {
                    String str4 = this.dtX;
                    int i2 = this.dCS;
                    Log.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", str4, Integer.valueOf(i2));
                    x xVar3 = new x();
                    xVar3.dCQ.action = 4;
                    xVar3.dCQ.dtX = str4;
                    xVar3.dCQ.dCS = i2;
                    com.tencent.mm.plugin.music.b.a.a(xVar3);
                    if (xVar3.dCR.result) {
                        Log.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
                    } else {
                        this.error = true;
                        this.jFn = "seek audio fail";
                    }
                }
            } else if (str.equalsIgnoreCase("stop")) {
                String str5 = this.dtX;
                x xVar4 = new x();
                xVar4.dCQ.action = 13;
                xVar4.dCQ.dtX = str5;
                com.tencent.mm.plugin.music.b.a.a(xVar4);
                if (xVar4.dCR.result) {
                    Log.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", str5);
                    x xVar5 = new x();
                    xVar5.dCQ.action = 14;
                    xVar5.dCQ.dtX = str5;
                    com.tencent.mm.plugin.music.b.a.a(xVar5);
                    aGU = xVar5.dCR.result;
                } else {
                    x xVar6 = new x();
                    xVar6.dCQ.action = 17;
                    xVar6.dCQ.dtX = str5;
                    com.tencent.mm.plugin.music.b.a.a(xVar6);
                    aGU = !xVar6.dCR.result ? com.tencent.mm.ai.c.aGU(str5) : true;
                }
                if (aGU) {
                    Log.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
                } else {
                    this.error = true;
                    this.jFn = "stop audio fail";
                }
            } else {
                Log.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
                this.error = true;
                this.jFn = "operationType is invalid";
            }
            if (this.error) {
                Log.e("MicroMsg.Audio.JsApiOperateAudio", this.jFn);
            }
            callback();
            AppMethodBeat.o(145727);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.a
        public final void callback() {
            AppMethodBeat.i(145728);
            super.callback();
            if (this.lAx == null) {
                Log.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
                AppMethodBeat.o(145728);
            } else if (this.error) {
                this.lAx.i(this.lqe, this.lAw.h("fail:" + this.jFn, null));
                AppMethodBeat.o(145728);
            } else {
                this.lAx.i(this.lqe, this.lAw.h("ok", null));
                AppMethodBeat.o(145728);
            }
        }
    }
}
