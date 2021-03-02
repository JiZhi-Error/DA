package com.tencent.mm.plugin.appbrand.game.e.a;

import android.annotation.SuppressLint;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.game.e.a.b;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {
    public static final int CTRL_INDEX = 669;
    public static final String NAME = "editGameRecorderVideo";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        String str;
        String str2;
        AppMethodBeat.i(45142);
        final com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        Log.i("MicroMsg.WAGameJsApiScreenRecorderEdit", "hy: request clip and share");
        String optString = jSONObject.optString("videoSrc");
        String optString2 = jSONObject.optString("bgmSrc");
        final String optString3 = jSONObject.optString("title");
        JSONArray optJSONArray = jSONObject.optJSONArray("timeRange");
        final JSONArray optJSONArray2 = jSONObject.optJSONArray("shareOptions");
        double optDouble = jSONObject.optDouble("volume", 1.0d);
        if (Util.isNullOrNil(optString)) {
            str = "not provide video file src!";
        } else {
            if (Util.isNullOrNil(optString2)) {
                Log.w("MicroMsg.WAGameJsApiScreenRecorderEdit", "hy: not provide bgm, but it's ok");
            }
            if (cVar2.getRuntime() == null) {
                str = "get runtime failed!";
            } else if (cVar2.getRuntime().getFileSystem() == null) {
                str = "get file system failed!";
            } else if (cVar2.getRuntime().getFileSystem().Vj(optString) != m.OK) {
                str = "not found video file!";
            } else if (Util.isNullOrNil(optString2) || cVar2.getRuntime().getFileSystem().Vj(optString2) == m.OK) {
                str = "ok";
            } else {
                str = "not found audio file!";
            }
        }
        if (!"ok".equalsIgnoreCase(str)) {
            a(cVar2, i2, 2, 801, str);
            AppMethodBeat.o(45142);
            return;
        }
        final b.a a2 = a(cVar2, "cut_game_screenrecord.mp4");
        if (a2 == null || Util.isNullOrNil(a2.lsB)) {
            Log.e("MicroMsg.WAGameJsApiScreenRecorderEdit", "hy: WAGameJsApiScreenRecorderOperate, alloc file failed");
            a(cVar2, i2, 2, -1, "internal create file failed!");
            AppMethodBeat.o(45142);
            return;
        }
        try {
            Object z = aa.z(cVar2.getRuntime().OK().VY(optString).her());
            if (!Util.isNullOrNil(optString2)) {
                str2 = aa.z(cVar2.getRuntime().OK().VY(optString2).her());
            } else {
                str2 = null;
            }
            Log.d("MicroMsg.WAGameJsApiScreenRecorderEdit", "hy: retrieved video full path: %s, audio full path: %s, clippedFilePath path: %s", z, str2, a2);
            jSONObject.put("videoPath", z);
            jSONObject.put("videoSlices", optJSONArray);
            if (!Util.isNullOrNil(str2)) {
                jSONObject.put("audioPath", str2);
                jSONObject.put("audioVolume", optDouble);
                jSONObject.put("audioTransBitrate", 64000);
                jSONObject.put("audioTransSamplerate", 44100);
                jSONObject.put("audioTransChannel", 2);
            }
            jSONObject.put("filePath", a2.lsB);
            g(cVar2).a(jSONObject, new d<JSONObject>() {
                /* class com.tencent.mm.plugin.appbrand.game.e.a.c.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, JSONObject jSONObject) {
                    AppMethodBeat.i(45138);
                    JSONObject jSONObject2 = jSONObject;
                    if (i3 != 0 || jSONObject2 == null) {
                        c.this.a(cVar2, i2, i2, i3, str);
                        AppMethodBeat.o(45138);
                        return;
                    }
                    try {
                        com.tencent.mm.plugin.appbrand.game.g.b g2 = c.g(cVar2);
                        g2.getClass();
                        b.d dVar = new b.d();
                        JSONObject optJSONObject = jSONObject2.optJSONObject(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                        if (optJSONObject != null) {
                            dVar.audioBitrate = optJSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, 0);
                            dVar.audioSampleRate = optJSONObject.optInt("samplerate", 0);
                            dVar.audioChannelCount = optJSONObject.optInt("channel", 0);
                        }
                        c.this.a(cVar2, i2, a2, optString3, c.a(cVar2, optJSONArray2), dVar);
                        AppMethodBeat.o(45138);
                    } catch (Exception e2) {
                        c.this.a(cVar2, i2, 1, -1, e2.getMessage());
                        AppMethodBeat.o(45138);
                    }
                }
            });
            AppMethodBeat.o(45142);
        } catch (JSONException e2) {
            a(cVar2, i2, 1, -1, e2.getMessage());
            AppMethodBeat.o(45142);
        } catch (Exception e3) {
            a(cVar2, i2, 1, -1, e3.getMessage());
            AppMethodBeat.o(45142);
        }
    }

    static ArrayList<GameShareOption> a(s sVar, JSONArray jSONArray) {
        AppMethodBeat.i(45139);
        ArrayList<GameShareOption> arrayList = new ArrayList<>(1);
        if (jSONArray == null || jSONArray.length() <= 0) {
            arrayList.add(new GameShareOption(0, sVar.getContext().getString(R.string.a1e), false));
            AppMethodBeat.o(45139);
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new GameShareOption(jSONObject.getInt("id"), jSONObject.getString("name"), jSONObject.optBoolean("needExtUrl", false)));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderEdit", e2, "hy: json exception!", new Object[0]);
                arrayList.clear();
                arrayList.add(new GameShareOption(0, sVar.getContext().getString(R.string.a1e), false));
                AppMethodBeat.o(45139);
                return arrayList;
            }
        }
        AppMethodBeat.o(45139);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void a(com.tencent.mm.plugin.appbrand.service.c cVar, int i2, b.a aVar, String str, ArrayList<GameShareOption> arrayList, b.d dVar) {
        AppMethodBeat.i(45140);
        String str2 = aVar.lsC;
        if (Util.isNullOrNil(str2)) {
            a(cVar, i2, 1, 802, "clipped file lost");
            AppMethodBeat.o(45140);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("errCode", 0);
        hashMap.put("videoPath", str2);
        cVar.i(i2, n("ok", hashMap));
        AppMethodBeat.o(45140);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DefaultLocale"})
    public final void a(s sVar, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(45141);
        Log.w("MicroMsg.WAGameJsApiScreenRecorderEdit", "hy: fail errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("errCode", Integer.valueOf(i4));
        sVar.i(i2, n(String.format("fail: errType: %d, errCode: %d, %s", Integer.valueOf(i3), Integer.valueOf(i4), str), hashMap));
        AppMethodBeat.o(45141);
    }
}
