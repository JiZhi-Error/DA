package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.t;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.component.TAVPlayer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class i extends d {
    private static final int CTRL_INDEX = 733;
    public static final String NAME = "compressVideo";
    AtomicBoolean mdI = new AtomicBoolean(false);

    public i() {
        AppMethodBeat.i(46573);
        AppMethodBeat.o(46573);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        t.a aVar;
        t.a aVar2;
        AppMethodBeat.i(46574);
        if (this.mdI.get()) {
            Log.i("MicroMsg.JsApiCompressVideo", "is compressing now");
            fVar.i(i2, h("fail:is compressing now", null));
            AppMethodBeat.o(46574);
        } else if (fVar == null) {
            Log.e("MicroMsg.JsApiCompressVideo", "fail:component is null");
            AppMethodBeat.o(46574);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.JsApiCompressVideo", "fail:data is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46574);
        } else {
            String optString = jSONObject.optString("src");
            if (Util.isNullOrNil(optString)) {
                Log.w("MicroMsg.JsApiCompressVideo", "fail:data src is empty");
                fVar.i(i2, h("fail:invalid data", null));
                AppMethodBeat.o(46574);
            } else if (!optString.startsWith("wxfile://")) {
                Log.w("MicroMsg.JsApiCompressVideo", "fail:src path not supported");
                fVar.i(i2, h("fail:src path not be supported", null));
                AppMethodBeat.o(46574);
            } else {
                q fileSystem = fVar.getFileSystem();
                if (fileSystem == null) {
                    Log.w("MicroMsg.JsApiCompressVideo", "fail:runtime fileSystem is null");
                    fVar.i(i2, h("fail:internal error", null));
                    AppMethodBeat.o(46574);
                    return;
                }
                o VY = fileSystem.VY(optString);
                if (VY == null) {
                    Log.w("MicroMsg.JsApiCompressVideo", "fail:srcFile is null");
                    fVar.i(i2, h("fail:file doesn't exist", null));
                    AppMethodBeat.o(46574);
                    return;
                }
                String z = aa.z(VY.her());
                if (!s.YS(z)) {
                    Log.w("MicroMsg.JsApiCompressVideo", "fail:filePath is null or without exist file");
                    fVar.i(i2, h("fail:file doesn't exist", null));
                    AppMethodBeat.o(46574);
                } else if (!jSONObject.has("quality") && !jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) && !jSONObject.has("fps") && !jSONObject.has("resolution")) {
                    Log.w("MicroMsg.JsApiCompressVideo", "no quality config");
                    fVar.i(i2, h("fail:invalid data", null));
                    AppMethodBeat.o(46574);
                } else if (jSONObject.has("quality")) {
                    Log.i("MicroMsg.JsApiCompressVideo", "compress with quality config");
                    String optString2 = jSONObject.optString("quality");
                    Log.i("MicroMsg.JsApiCompressVideo", "quality: %s", optString2);
                    t.b aao = t.aao(z);
                    int i3 = aao == null ? 720 : aao.width;
                    int i4 = aao == null ? 540 : aao.height;
                    char c2 = 65535;
                    switch (optString2.hashCode()) {
                        case -1078030475:
                            if (optString2.equals(FirebaseAnalytics.b.MEDIUM)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 107348:
                            if (optString2.equals("low")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 3202466:
                            if (optString2.equals("high")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            aVar2 = new t.a(z, 0, 0, Math.round(((float) i3) * 0.8f), Math.round(((float) i4) * 0.8f), Math.round(((float) t.meG) * 2.0f), c.Dme);
                            break;
                        case 1:
                            aVar2 = new t.a(z, 0, 0, Math.round(((float) i3) * 0.5f), Math.round(((float) i4) * 0.5f), Math.round(((float) t.meG) * 1.5f), c.Dme);
                            break;
                        case 2:
                            aVar2 = new t.a(z, 0, 0, Math.round(((float) i3) * 0.3f), Math.round(((float) i4) * 0.3f), t.meG, c.Dme);
                            break;
                        default:
                            aVar2 = null;
                            break;
                    }
                    a(fVar, i2, aVar2);
                    AppMethodBeat.o(46574);
                } else {
                    Log.i("MicroMsg.JsApiCompressVideo", "compress with advance config");
                    float optDouble = (float) jSONObject.optDouble("resolution", 1.0d);
                    float round = (optDouble <= 0.0f || optDouble > 1.0f) ? 1.0f : (((float) Math.round(optDouble * 10.0f)) * 1.0f) / 10.0f;
                    t.b aao2 = t.aao(z);
                    if (aao2 == null) {
                        Log.w("MicroMsg.JsApiCompressVideo", "fail:videoInfo is null");
                        fVar.i(i2, h("fail:can't get info from video file", null));
                        AppMethodBeat.o(46574);
                        return;
                    }
                    int round2 = Math.round(((float) aao2.width) * round);
                    int round3 = Math.round(((float) aao2.height) * round);
                    int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, Math.round((((float) t.meG) * 1.0f) / 1000.0f)) * 1000;
                    if (optInt <= 0 || optInt >= aao2.bitrate) {
                        optInt = t.meG;
                    }
                    float optDouble2 = (float) jSONObject.optDouble("fps", (double) c.Dme);
                    if (optDouble2 < 1.0f || optDouble2 > aao2.cKu) {
                        optDouble2 = c.Dme;
                    }
                    Log.i("MicroMsg.JsApiCompressVideo", "ratio: %f, bitrate: %d, fps: %f", Float.valueOf(round), Integer.valueOf(optInt), Float.valueOf(optDouble2));
                    if (round2 == 0 || round3 == 0) {
                        aVar = new t.a(z, TAVExporter.VIDEO_EXPORT_WIDTH, TAVPlayer.VIDEO_PLAYER_WIDTH, 0, 0, optInt, optDouble2);
                    } else {
                        aVar = new t.a(z, 0, 0, round2, round3, optInt, optDouble2);
                    }
                    a(fVar, i2, aVar);
                    AppMethodBeat.o(46574);
                }
            }
        }
    }

    private void a(final f fVar, final int i2, final t.a aVar) {
        AppMethodBeat.i(226903);
        this.mdI.compareAndSet(false, true);
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.i.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            public final void run() {
                boolean z;
                AppMethodBeat.i(46572);
                int aan = t.aan(aVar.filePath);
                i iVar = i.this;
                f fVar = fVar;
                int i2 = i2;
                switch (aan) {
                    case -50006:
                        z = false;
                        break;
                    case -50002:
                        Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, video duration error");
                        fVar.i(i2, iVar.h("fail:compress failed, video duration error", null));
                        z = true;
                        break;
                    case -50001:
                        Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file not exist");
                        fVar.i(i2, iVar.h("fail:file doesn't exist", null));
                        z = true;
                        break;
                    case 1:
                        Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file type not be supported");
                        fVar.i(i2, iVar.h("fail:compress failed, video type not be supported", null));
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                if (z) {
                    i.this.mdI.compareAndSet(true, false);
                    AppMethodBeat.o(46572);
                    return;
                }
                String a2 = t.a(aVar);
                if (!s.YS(a2)) {
                    Log.i("MicroMsg.JsApiCompressVideo", "compressed file not exist");
                    fVar.i(i2, i.this.h("fail:compress failed, generate path failed", null));
                    i.this.mdI.compareAndSet(true, false);
                    AppMethodBeat.o(46572);
                } else if (fVar == null || fVar.getFileSystem() == null) {
                    Log.i("MicroMsg.JsApiCompressVideo", "component or file system is null");
                    i.this.mdI.compareAndSet(true, false);
                    AppMethodBeat.o(46572);
                } else if (a2.equals(aVar.filePath)) {
                    Log.e("MicroMsg.JsApiCompressVideo", "file not be compressed, probably video no need to compress or file format not be supported");
                    fVar.i(i2, i.this.h("fail:compress failed", null));
                    i.this.mdI.compareAndSet(true, false);
                    AppMethodBeat.o(46572);
                } else {
                    com.tencent.mm.plugin.appbrand.ac.i<String> iVar2 = new com.tencent.mm.plugin.appbrand.ac.i<>();
                    fVar.getFileSystem().a(new o(a2), (String) null, false, iVar2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("tempFilePath", iVar2.value);
                    hashMap.put("size", Long.valueOf(Math.round((((double) s.boW(a2)) * 1.0d) / 1024.0d)));
                    fVar.i(i2, i.this.n("ok", hashMap));
                    i.this.mdI.compareAndSet(true, false);
                    AppMethodBeat.o(46572);
                }
            }
        });
        AppMethodBeat.o(226903);
    }
}
