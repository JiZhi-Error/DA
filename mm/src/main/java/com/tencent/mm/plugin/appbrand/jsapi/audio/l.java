package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.y;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.a.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.json.JSONObject;

public class l extends d {
    public static final int CTRL_INDEX = 292;
    public static final String NAME = "setAudioState";
    private a lDW;

    public static final class b extends bc {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAudioStateChange";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        String str;
        String str2;
        Pair pair;
        AppMethodBeat.i(145749);
        if (!com.tencent.mm.plugin.appbrand.media.a.a.acB(fVar.getAppId())) {
            Log.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
            fVar.i(i2, h("fail:App is paused or background", null));
            AppMethodBeat.o(145749);
        } else if (jSONObject == null) {
            Log.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(145749);
        } else {
            Log.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("startTime", 0);
            String optString2 = jSONObject.optString("src");
            if (Util.isNullOrNil(optString2)) {
                Log.e("MicroMsg.Audio.WxaAudioUtils", "src is empty");
                str = "";
            } else if (!optString2.startsWith("wxfile://")) {
                if (optString2.length() <= 250) {
                    Log.i("MicroMsg.Audio.WxaAudioUtils", "getRealSrc:src:%s", optString2);
                }
                str = optString2;
            } else if (fVar.getFileSystem() == null) {
                Log.e("MicroMsg.Audio.WxaAudioUtils", "getFileSystem() is null");
                str = "";
            } else {
                o VY = fVar.getFileSystem().VY(optString2);
                if (VY == null || !VY.exists()) {
                    Log.e("MicroMsg.Audio.WxaAudioUtils", "localFile is null");
                    str = "";
                } else {
                    String z = aa.z(VY.her());
                    if (z != null && !z.startsWith("file://")) {
                        z = "file://".concat(String.valueOf(z));
                    }
                    Log.i("MicroMsg.Audio.WxaAudioUtils", "getRealSrc:src:%s", z);
                    str = z;
                }
            }
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            double optDouble2 = jSONObject.optDouble("playbackRate", 1.0d);
            if (optDouble2 < 0.5d || optDouble2 > 2.0d) {
                optDouble2 = 1.0d;
            }
            Long valueOf = Long.valueOf(jSONObject.optLong(AppMeasurement.Param.TIMESTAMP, 0));
            Long l = 0L;
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (!optBoolean) {
                valueOf2 = 0L;
            } else if (valueOf.longValue() > 0 && valueOf.longValue() <= valueOf2.longValue()) {
                l = Long.valueOf(valueOf2.longValue() - valueOf.longValue());
            }
            if (TextUtils.isEmpty(optString)) {
                Log.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
                fVar.i(i2, h("fail:audioId is empty", null));
                AppMethodBeat.o(145749);
            } else if (TextUtils.isEmpty(str)) {
                Log.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
                fVar.i(i2, h("fail:src is empty", null));
                AppMethodBeat.o(145749);
            } else {
                if (this.lDW == null) {
                    this.lDW = new a(fVar);
                }
                this.lDW.appId = fVar.getAppId();
                this.lDW.bjm();
                c cVar = new c(this, fVar, i2);
                cVar.appId = fVar.getAppId();
                cVar.dtX = optString;
                cVar.dtT = str;
                cVar.dvv = optInt;
                cVar.iJE = optBoolean;
                cVar.loop = optBoolean2;
                cVar.lDZ = e(fVar, str);
                cVar.iJG = optDouble;
                cVar.iJH = optDouble2;
                cVar.processName = MMApplicationContext.getProcessName();
                cVar.iJJ = l.longValue();
                cVar.iJK = valueOf2.longValue();
                com.tencent.mm.plugin.appbrand.jsapi.u.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.u.a) e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
                if (aVar == null) {
                    pair = new Pair(null, "invalidReferrer");
                } else {
                    String af = aVar.af(jSONObject);
                    if (af != null) {
                        com.tencent.mm.plugin.appbrand.jsapi.u.c aaF = aVar.aaF(af);
                        if (aaF == null) {
                            aaF = aVar.x(fVar);
                        }
                        if (com.tencent.mm.plugin.appbrand.jsapi.u.c.NO_REFERRER == aaF) {
                            str2 = null;
                        } else if (com.tencent.mm.plugin.appbrand.jsapi.u.c.ORIGIN == aaF) {
                            str2 = aVar.y(fVar);
                        }
                        pair = new Pair(af, str2);
                    }
                    str2 = "invalidReferrer";
                    pair = new Pair(af, str2);
                }
                cVar.iJP = (String) pair.first;
                cVar.iJQ = (String) pair.second;
                cVar.bjm();
                com.tencent.mm.plugin.appbrand.media.a.c cVar2 = new com.tencent.mm.plugin.appbrand.media.a.c();
                cVar2.lDZ = cVar.lDZ;
                cVar2.lDY = jSONObject.toString();
                cVar2.dtT = str;
                com.tencent.mm.plugin.appbrand.media.a.a.a(optString, cVar2);
                AppMethodBeat.o(145749);
            }
        }
    }

    public WxaPkg.Info e(f fVar, String str) {
        return null;
    }

    static class c extends a {
        public String appId = "";
        public String dtT = "";
        public String dtX = "";
        public int dvv = 0;
        public boolean error = false;
        public boolean iJE = false;
        public double iJG;
        public double iJH;
        public long iJJ;
        public long iJK;
        public String iJP = null;
        public String iJQ = null;
        public String jFn;
        private p lAw;
        public f lAx;
        public WxaPkg.Info lDZ;
        public boolean loop = false;
        public int lqe;
        public String processName = "";

        public c(p pVar, f fVar, int i2) {
            this.lAw = pVar;
            this.lAx = fVar;
            this.lqe = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.d
        public final void YC() {
            String str;
            com.tencent.mm.ai.b bVar;
            AppMethodBeat.i(145747);
            Log.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
            this.error = false;
            this.jFn = "";
            com.tencent.mm.ai.b LU = com.tencent.mm.ai.c.LU(this.dtX);
            com.tencent.mm.ai.b bVar2 = new com.tencent.mm.ai.b();
            bVar2.dtX = this.dtX;
            bVar2.dvn = this.dtT;
            bVar2.dvv = this.dvv;
            bVar2.iJD = this.dvv;
            bVar2.iJE = this.iJE;
            bVar2.loop = this.loop;
            bVar2.processName = this.processName;
            bVar2.iJG = this.iJG;
            bVar2.appId = this.appId;
            bVar2.fromScene = 0;
            bVar2.iJH = this.iJH;
            bVar2.iJL = this.iJJ;
            bVar2.iJM = this.iJK;
            bVar2.iJP = this.iJP;
            bVar2.iJQ = this.iJQ;
            if (LU == null || !this.dtT.equalsIgnoreCase(LU.dvn) || !com.tencent.mm.ai.c.LT(this.dtX)) {
                Log.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", this.appId, this.dtX, this.dtT, Integer.valueOf(this.dvv));
                if (this.dtT.startsWith("file://")) {
                    bVar2.filePath = this.dtT.substring(7);
                    Log.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", bVar2.filePath);
                } else if (this.dtT.contains("base64") && this.dtT.startsWith("data:audio")) {
                    bVar2.filePath = g.abx(this.dtT.substring(this.dtT.indexOf("base64,") + 7).trim());
                    Log.i("MicroMsg.Audio.JsApiSetAudioState", "base64 decode filePath:%s", bVar2.filePath);
                } else if (this.dtT.startsWith("wxblob://")) {
                    i<ByteBuffer> iVar = new i<>();
                    if (this.lAx.getFileSystem().b(this.dtT, iVar) == m.OK) {
                        bVar2.iJU = iVar.value;
                        bVar2.filePath = this.dtT;
                        Log.i("MicroMsg.Audio.JsApiSetAudioState", "wxblob read ok");
                    } else {
                        Log.e("MicroMsg.Audio.JsApiSetAudioState", "wxblob read fail");
                        o VV = this.lAx.getFileSystem().VV(this.dtT);
                        if (VV == null || !VV.exists()) {
                            Log.e("MicroMsg.Audio.JsApiSetAudioState", "wxblob localFile is null");
                            this.error = true;
                            this.jFn = "wxblob localFile is null";
                        } else {
                            bVar2.filePath = aa.z(VV.her());
                        }
                    }
                } else if (!this.dtT.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !this.dtT.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
                    com.tencent.mm.ai.e c2 = com.tencent.mm.plugin.appbrand.media.a.f.c(this.lDZ);
                    if (c2 == null || !c2.isOpen()) {
                        org.apache.commons.a.e.closeQuietly(c2);
                        this.error = true;
                        this.jFn = "the file not exist for src";
                        Log.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", this.dtT);
                        callback();
                        AppMethodBeat.o(145747);
                        return;
                    }
                    if (LU == null || !this.dtT.equalsIgnoreCase(LU.dvn) || TextUtils.isEmpty(LU.filePath)) {
                        f fVar = this.lAx;
                        str = this.dtT;
                        if (Util.isNullOrNil(str)) {
                            Log.e("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
                            bVar = bVar2;
                        } else if (fVar.getFileSystem() == null) {
                            Log.e("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
                            bVar = bVar2;
                        } else {
                            o VY = fVar.getFileSystem().VY(str);
                            if (VY == null || !VY.exists()) {
                                Log.e("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
                                bVar = bVar2;
                            } else {
                                str = aa.z(VY.her());
                                Log.i("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", str);
                                bVar = bVar2;
                            }
                        }
                    } else {
                        str = LU.filePath;
                        bVar = bVar2;
                    }
                    bVar.filePath = str;
                    bVar2.iJR = c2;
                }
                if (!this.error) {
                    com.tencent.mm.ai.c.m(bVar2);
                }
                callback();
                AppMethodBeat.o(145747);
                return;
            }
            Log.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
            Log.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", bVar2.dtX, bVar2.dvn);
            x xVar = new x();
            xVar.dCQ.action = 18;
            xVar.dCQ.dtX = bVar2.dtX;
            xVar.dCQ.dCT = bVar2;
            com.tencent.mm.plugin.music.b.a.a(xVar);
            if (!xVar.dCR.result) {
                this.error = true;
                this.jFn = "not to set audio param, the audioId is err";
                Log.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
            }
            callback();
            AppMethodBeat.o(145747);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.a
        public final void callback() {
            AppMethodBeat.i(145748);
            super.callback();
            if (this.lAx == null) {
                Log.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                AppMethodBeat.o(145748);
            } else if (this.error) {
                this.lAx.i(this.lqe, this.lAw.h("fail:" + this.jFn, null));
                AppMethodBeat.o(145748);
            } else {
                this.lAx.i(this.lqe, this.lAw.h("ok", null));
                AppMethodBeat.o(145748);
            }
        }
    }

    public static class a extends a {
        public int action;
        public String appId = "";
        public f lAx;
        private String lEI;
        private IListener lEJ = new IListener<y>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.l.a.AnonymousClass1 */

            {
                AppMethodBeat.i(161228);
                this.__eventId = y.class.getName().hashCode();
                AppMethodBeat.o(161228);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(y yVar) {
                AppMethodBeat.i(145743);
                y yVar2 = yVar;
                String str = yVar2.dCW.appId;
                if (!a.this.appId.equals(str)) {
                    Log.i("MicroMsg.Audio.JsApiSetAudioState", "appId is not equals preAppId, don't send any event, appId:%s, eventAppId:%s, action:%d", a.this.appId, str, Integer.valueOf(yVar2.dCW.action));
                    AppMethodBeat.o(145743);
                    return false;
                }
                HashMap hashMap = new HashMap();
                String str2 = yVar2.dCW.state;
                a.this.lEI = yVar2.dCW.dtX;
                Log.d("MicroMsg.Audio.JsApiSetAudioState", "mAudioListener callback action:%d， audioId:%s, state:%s", Integer.valueOf(yVar2.dCW.action), a.this.lEI, str2);
                hashMap.put("state", str2);
                hashMap.put("audioId", a.this.lEI);
                a.this.action = yVar2.dCW.action;
                if (a.this.action == 4) {
                    hashMap.put("errMsg", yVar2.dCW.errMsg);
                    hashMap.put("errCode", Integer.valueOf(yVar2.dCW.errCode));
                }
                a.this.lEk = new JSONObject(hashMap).toString();
                a.this.callback();
                AppMethodBeat.o(145743);
                return true;
            }
        };
        public String lEk;

        public a(f fVar) {
            AppMethodBeat.i(256425);
            this.lAx = fVar;
            AppMethodBeat.o(256425);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.d
        public final void YC() {
            AppMethodBeat.i(145745);
            Log.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
            com.tencent.mm.plugin.appbrand.media.a.a.acA(this.appId);
            com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.lEJ);
            AppMethodBeat.o(145745);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.a
        public final void callback() {
            AppMethodBeat.i(145746);
            if (this.lAx == null) {
                Log.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                AppMethodBeat.o(145746);
                return;
            }
            Log.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", Integer.valueOf(this.action), this.lEk);
            if (Util.isNullOrNil(this.lEk)) {
                Log.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
                AppMethodBeat.o(145746);
                return;
            }
            new b().h(this.lAx).Zh(this.lEk).a(c.INSTANCE.Zm(this.appId).Zz(this.lEI));
            AppMethodBeat.o(145746);
        }
    }
}
