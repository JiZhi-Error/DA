package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static com.tencent.mm.ai.b a(f fVar, String str, String str2, String str3, String str4, WxaPkg.Info info, String str5) {
        AppMethodBeat.i(256426);
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            Log.e("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", str4, str3);
            AppMethodBeat.o(256426);
            return null;
        }
        Log.i("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", str2, str4);
        com.tencent.mm.ai.b bVar = new com.tencent.mm.ai.b();
        bVar.appId = str;
        bVar.dtX = str2;
        bVar.processName = str5;
        bVar.dvn = str3;
        bVar.fromScene = 0;
        try {
            JSONObject jSONObject = new JSONObject(str4);
            int optInt = jSONObject.optInt("startTime", 0);
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            double optDouble2 = jSONObject.optDouble("playbackRate", 1.0d);
            bVar.dvv = optInt;
            bVar.iJD = optInt;
            bVar.iJE = optBoolean;
            bVar.loop = optBoolean2;
            bVar.iJG = optDouble;
            bVar.iJH = optDouble2;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", e2, "parseAudioPlayParam", new Object[0]);
        }
        if (str3.startsWith("file://")) {
            bVar.filePath = str3.substring(7);
            Log.i("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", bVar.filePath);
        } else if (str3.contains("base64") && str3.startsWith("data:audio")) {
            bVar.filePath = g.abx(str3.substring(str3.indexOf("base64,") + 7).trim());
            Log.i("MicroMsg.Audio.AudioPlayerParamParser", "base64 decode filePath:%s", bVar.filePath);
        } else if (str3.startsWith("wxblob://")) {
            i<ByteBuffer> iVar = new i<>();
            if (fVar.getFileSystem().b(str3, iVar) == m.OK) {
                bVar.iJU = iVar.value;
                bVar.filePath = str3;
                Log.i("MicroMsg.Audio.AudioPlayerParamParser", "wxblob read ok");
            } else {
                Log.e("MicroMsg.Audio.AudioPlayerParamParser", "wxblob read fail");
                o VV = fVar.getFileSystem().VV(str3);
                if (VV == null || !VV.exists()) {
                    Log.e("MicroMsg.Audio.AudioPlayerParamParser", "wxblob localFile is null");
                } else {
                    bVar.filePath = aa.z(VV.her());
                }
            }
        } else if (!str3.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !str3.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            e c2 = f.c(info);
            if (c2 == null || !c2.isOpen()) {
                Log.e("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", str3);
                org.apache.commons.a.e.closeQuietly(c2);
                AppMethodBeat.o(256426);
                return null;
            }
            bVar.filePath = str3;
            bVar.iJR = c2;
        }
        AppMethodBeat.o(256426);
        return bVar;
    }
}
