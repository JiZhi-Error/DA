package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.t;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.rtmp.TXLiveConstants;
import java.text.DecimalFormat;
import java.util.HashMap;
import org.json.JSONObject;

public final class k extends d {
    private static final int CTRL_INDEX = 732;
    public static final String NAME = "getVideoInfo";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        String str;
        AppMethodBeat.i(46575);
        if (fVar == null) {
            Log.e("MicroMsg.JsApiGetVideoInfo", "fail:internal error");
            AppMethodBeat.o(46575);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.JsApiGetVideoInfo", "fail:data is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46575);
        } else if (fVar.getFileSystem() == null) {
            Log.w("MicroMsg.JsApiGetVideoInfo", "fail:file system is null");
            fVar.i(i2, h("fail:internal error", null));
            AppMethodBeat.o(46575);
        } else {
            String optString = jSONObject.optString("src");
            if (Util.isNullOrNil(optString)) {
                Log.w("MicroMsg.JsApiGetVideoInfo", "fail:data src is null");
                fVar.i(i2, h("fail:invalid data", null));
                AppMethodBeat.o(46575);
            } else if (!optString.startsWith("wxfile://")) {
                Log.w("MicroMsg.JsApiGetVideoInfo", "fail:src path not supported");
                fVar.i(i2, h("fail:src path not be supported", null));
                AppMethodBeat.o(46575);
            } else {
                o VY = fVar.getFileSystem().VY(optString);
                if (VY == null) {
                    fVar.i(i2, h("fail:file doesn't exist", null));
                    AppMethodBeat.o(46575);
                    return;
                }
                t.b aao = t.aao(aa.z(VY.her()));
                if (aao == null) {
                    Log.w("MicroMsg.JsApiGetVideoInfo", "fail:videoInfo is null");
                    fVar.i(i2, h("fail:can't get info from video file", null));
                    AppMethodBeat.o(46575);
                    return;
                }
                switch (aao.rotation) {
                    case 90:
                        str = "right";
                        break;
                    case TXLiveConstants.RENDER_ROTATION_180 /*{ENCODED_INT: 180}*/:
                        str = "down";
                        break;
                    case 270:
                        str = "left";
                        break;
                    default:
                        str = "up";
                        break;
                }
                HashMap hashMap = new HashMap(8);
                hashMap.put("orientation", str);
                hashMap.put("type", aao.type);
                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Float.valueOf(Util.safeParseFloat(new DecimalFormat("#.#").format((double) ((((float) aao.duration) * 1.0f) / 1000.0f)))));
                hashMap.put("size", Integer.valueOf(Math.round((((float) aao.size) * 1.0f) / 1024.0f)));
                hashMap.put("height", Integer.valueOf(aao.height));
                hashMap.put("width", Integer.valueOf(aao.width));
                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, Integer.valueOf(Math.round((((float) aao.bitrate) * 1.0f) / 1000.0f)));
                hashMap.put("fps", Float.valueOf(aao.cKu));
                fVar.i(i2, n("ok", hashMap));
                AppMethodBeat.o(46575);
            }
        }
    }
}
