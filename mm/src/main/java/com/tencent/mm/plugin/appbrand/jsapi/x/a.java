package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.x.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b {
    public static final int CTRL_INDEX = 705;
    public static final String NAME = "openVideoEditor";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.x.b
    public final void a(final c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226973);
        Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: %s %s", NAME, jSONObject.toString());
        if (cVar.ay(Activity.class) == null) {
            cVar.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(226973);
            return;
        }
        int optInt = jSONObject.optInt("editType");
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkParmas");
        final JSONObject optJSONObject2 = jSONObject.optJSONObject("editorParmas");
        if (optInt == 1) {
            if (optJSONObject == null) {
                cVar.i(i2, h(String.format("fail: sdkParmas get failed", new Object[0]), null));
                AppMethodBeat.o(226973);
                return;
            }
            a(cVar, optJSONObject, new d<JSONObject>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.x.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, JSONObject jSONObject) {
                    AppMethodBeat.i(226966);
                    JSONObject jSONObject2 = new JSONObject();
                    a.a(a.this, cVar, i3, str, jSONObject, jSONObject2);
                    Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "editFormatResult result, %s", jSONObject2.toString());
                    cVar.i(i2, jSONObject2.toString());
                    AppMethodBeat.o(226966);
                }
            });
            AppMethodBeat.o(226973);
        } else if (optInt == 2) {
            if (optJSONObject2 == null) {
                cVar.i(i2, h(String.format("fail: editorParmas get failed", new Object[0]), null));
                AppMethodBeat.o(226973);
                return;
            }
            b(cVar, optJSONObject2, new d<JSONObject>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.x.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, JSONObject jSONObject) {
                    AppMethodBeat.i(226967);
                    JSONObject jSONObject2 = new JSONObject();
                    a.a(a.this, cVar, i3, str, jSONObject, jSONObject2);
                    Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "editFormatResult result, %s", jSONObject2.toString());
                    cVar.i(i2, jSONObject2.toString());
                    AppMethodBeat.o(226967);
                }
            });
            AppMethodBeat.o(226973);
        } else if (optJSONObject == null || optJSONObject2 == null) {
            cVar.i(i2, h(String.format("fail: sdkParmas or editorParmas get failed", new Object[0]), null));
            AppMethodBeat.o(226973);
        } else {
            a(cVar, optJSONObject, new d<JSONObject>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.x.a.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, JSONObject jSONObject) {
                    AppMethodBeat.i(226969);
                    JSONObject jSONObject2 = jSONObject;
                    if (i3 != 0) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("errCode", i3);
                            jSONObject3.put("errMsg", a.this.getName() + ":fail:" + str);
                            Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "editForMediaSdk result, %s", jSONObject3.toString());
                            cVar.i(i2, jSONObject3.toString());
                            AppMethodBeat.o(226969);
                        } catch (JSONException e2) {
                            cVar.i(i2, a.this.h(String.format("fail: editForMediaSdk format result failed, %s", e2.getMessage()), null));
                            AppMethodBeat.o(226969);
                        }
                    } else {
                        optJSONObject2.put("filePath", jSONObject2.optString("wxaFilePath", ""));
                        a.this.b(cVar, optJSONObject2, new d<JSONObject>() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.x.a.AnonymousClass3.AnonymousClass1 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                            @Override // com.tencent.mm.plugin.appbrand.game.g.d
                            public final /* synthetic */ void a(int i2, int i3, String str, JSONObject jSONObject) {
                                AppMethodBeat.i(226968);
                                JSONObject jSONObject2 = new JSONObject();
                                a.a(a.this, cVar, i3, str, jSONObject, jSONObject2);
                                Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "editFormatResult result, %s", jSONObject2.toString());
                                cVar.i(i2, jSONObject2.toString());
                                AppMethodBeat.o(226968);
                            }
                        });
                        AppMethodBeat.o(226969);
                    }
                }
            });
            AppMethodBeat.o(226973);
        }
    }

    private void a(c cVar, JSONObject jSONObject, final d<JSONObject> dVar) {
        AppMethodBeat.i(226974);
        try {
            Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: editForMediaSdk %s %s", NAME, jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            String optString = jSONObject.optString("videoSrc", "");
            if (Util.isNullOrNil(optString)) {
                dVar.a(2, -3, "sdkParmas videoSrc not set", new JSONObject());
                AppMethodBeat.o(226974);
                return;
            }
            jSONObject2.put("videoPath", aa.z(cVar.getRuntime().OK().VY(optString).her()));
            String optString2 = jSONObject.optString("bgmSrc", "");
            if (!Util.isNullOrNil(optString2)) {
                jSONObject2.put("audioPath", aa.z(cVar.getRuntime().OK().VY(optString2).her()));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("timeRange");
            if (optJSONArray != null) {
                jSONObject2.put("videoSlices", optJSONArray);
            }
            jSONObject2.put("audioVolume", jSONObject.optDouble("volume", 1.0d));
            jSONObject2.put("atempo", jSONObject.optDouble("atempo", 1.0d));
            jSONObject2.put("mix", jSONObject.optBoolean("audioMix"));
            final b.a d2 = d(cVar, new Date().getTime() + ".mp4");
            if (d2 == null || Util.isNullOrNil(d2.lsB) || Util.isNullOrNil(d2.lsC)) {
                dVar.a(1, -1, "create file failed", new JSONObject());
                AppMethodBeat.o(226974);
                return;
            }
            jSONObject2.put("filePath", d2.lsB);
            d(cVar).a(jSONObject2, new d<JSONObject>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.x.a.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, JSONObject jSONObject) {
                    AppMethodBeat.i(226970);
                    JSONObject jSONObject2 = jSONObject;
                    if (i3 == 0) {
                        try {
                            jSONObject2.put("filePath", d2.lsB);
                            jSONObject2.put("wxaFilePath", d2.lsC);
                        } catch (JSONException e2) {
                            i2 = 1;
                            i3 = -1;
                            str = e2.getMessage();
                        }
                    }
                    dVar.a(i2, i3, str, jSONObject2);
                    AppMethodBeat.o(226970);
                }
            });
            AppMethodBeat.o(226974);
        } catch (JSONException e2) {
            dVar.a(2, -1, String.format("editForMediaSdk error: " + e2.getMessage(), new Object[0]), new JSONObject());
            AppMethodBeat.o(226974);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(final c cVar, JSONObject jSONObject, final d<JSONObject> dVar) {
        String str;
        AppMethodBeat.i(226975);
        Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: editForNativeView %s %s", NAME, jSONObject.toString());
        final int aK = com.tencent.luggage.sdk.g.a.aK(this);
        f.aK(cVar.getContext()).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.x.a.AnonymousClass5 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(226972);
                if (i2 == aK) {
                    Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: on result callback, result code: %d", Integer.valueOf(i3));
                    if (i3 == 0 || i3 == 3001) {
                        Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: user cancelled share!");
                        dVar.a(3, 803, "user cancelled", new JSONObject());
                    } else if (i3 != -1 || intent == null || !intent.hasExtra("key_req_result")) {
                        dVar.a(1, TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED, "edit file failed", new JSONObject());
                    } else {
                        SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                        final int intExtra = intent.getIntExtra("key_selected_item", 0);
                        Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: is video: %b, video path %s, thumb path: %s, md5: %s, selectedItem: %d", Boolean.valueOf(sightCaptureResult.tkD), sightCaptureResult.zsA, sightCaptureResult.zsB, sightCaptureResult.zsD, Integer.valueOf(intExtra));
                        if (!sightCaptureResult.tkD) {
                            dVar.a(3, TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED, "not a video", new JSONObject());
                        } else if (Util.isNullOrNil(sightCaptureResult.zsC) || Util.isNullOrNil(sightCaptureResult.zsD)) {
                            dVar.a(1, TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED, "edit failed", new JSONObject());
                        } else {
                            final String str = sightCaptureResult.zsA;
                            final String str2 = sightCaptureResult.zsB;
                            Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(str);
                            if (PF != null) {
                                try {
                                    BitmapUtil.saveBitmapToImage(PF, 100, Bitmap.CompressFormat.JPEG, str2, true);
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", e2, "hy: exception when convert bitmap", new Object[0]);
                                }
                            } else {
                                Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: generated thumb path is null!");
                            }
                            a.d(cVar).a(str, new d<b.a>() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.x.a.AnonymousClass5.AnonymousClass1 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                                public final /* synthetic */ void a(int i2, int i3, String str, b.a aVar) {
                                    AppMethodBeat.i(226971);
                                    b.a aVar2 = aVar;
                                    if (i3 != 0) {
                                        try {
                                            dVar.a(i2, i3, str, new JSONObject());
                                            AppMethodBeat.o(226971);
                                        } catch (JSONException e2) {
                                            dVar.a(1, -1, e2.getMessage(), new JSONObject());
                                            AppMethodBeat.o(226971);
                                        }
                                    } else {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("filePath", str);
                                        jSONObject.put("thumbPath", str2);
                                        jSONObject.put("chosenId", intExtra);
                                        jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, aVar2.duration);
                                        jSONObject.put("size", aVar2.fileSize);
                                        dVar.a(0, 0, "ok", jSONObject);
                                        AppMethodBeat.o(226971);
                                    }
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(226972);
                    return true;
                }
                AppMethodBeat.o(226972);
                return false;
            }
        });
        String optString = jSONObject.optString("filePath", "");
        if (Util.isNullOrNil(optString)) {
            dVar.a(2, -3, "editorParmas filePath not set", new JSONObject());
            AppMethodBeat.o(226975);
            return;
        }
        String z = aa.z(cVar.getRuntime().OK().VY(optString).her());
        String optString2 = jSONObject.optString("title", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("buttonOptions");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("toolBars");
        int optInt = jSONObject.optInt("minDuration", -1);
        int optInt2 = jSONObject.optInt("maxDuration", -1);
        Bundle bundle = new Bundle();
        bundle.putInt("k_ext_editor_from", 1);
        bundle.putString("k_ext_wording", optString2);
        bundle.putParcelableArrayList("k_ext_share_options", a(cVar, optJSONArray));
        bundle.putStringArrayList("k_ext_tool_bars", q(optJSONArray2));
        if (optInt > 0) {
            bundle.putInt("minDuration", optInt);
        }
        if (optInt2 > 0) {
            bundle.putInt("maxDuration", optInt2);
        }
        if (cVar.getRuntime() == null || cVar.getRuntime().bsB() == null) {
            str = "";
        } else {
            str = cVar.getRuntime().bsB().brandName;
        }
        ((g) com.tencent.mm.kernel.g.af(g.class)).a(cVar.getContext(), cVar.getAppId(), str, z, aK, bundle);
        AppMethodBeat.o(226975);
    }

    private static ArrayList<GameShareOption> a(c cVar, JSONArray jSONArray) {
        AppMethodBeat.i(226976);
        ArrayList<GameShareOption> arrayList = new ArrayList<>(1);
        if (jSONArray == null || jSONArray.length() <= 0) {
            arrayList.add(new GameShareOption(0, cVar.getContext().getString(R.string.a1c), false));
            AppMethodBeat.o(226976);
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new GameShareOption(jSONObject.getInt("id"), jSONObject.getString("name"), jSONObject.optBoolean("needExtUrl", false)));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", e2, "hy: json exception!", new Object[0]);
                arrayList.clear();
                arrayList.add(new GameShareOption(0, cVar.getContext().getString(R.string.a1c), false));
                AppMethodBeat.o(226976);
                return arrayList;
            }
        }
        AppMethodBeat.o(226976);
        return arrayList;
    }

    private static ArrayList<String> q(JSONArray jSONArray) {
        AppMethodBeat.i(226977);
        ArrayList<String> arrayList = new ArrayList<>(1);
        if (jSONArray == null || jSONArray.length() <= 0) {
            AppMethodBeat.o(226977);
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(jSONArray.getString(i2));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", e2, "hy: convertToolBars json exception! " + e2.getMessage(), new Object[0]);
            }
        }
        AppMethodBeat.o(226977);
        return arrayList;
    }

    static /* synthetic */ void a(a aVar, c cVar, int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        AppMethodBeat.i(226978);
        if (i2 != 0) {
            try {
                jSONObject2.put("errCode", i2);
                jSONObject2.put("errMsg", aVar.getName() + ":fail:" + str);
                AppMethodBeat.o(226978);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", e2, "hy: exception when format edit result", new Object[0]);
                AppMethodBeat.o(226978);
            }
        } else {
            String optString = jSONObject.optString("filePath", "");
            String optString2 = jSONObject.optString("thumbPath", "");
            int optInt = jSONObject.optInt("chosenId", 0);
            long optLong = jSONObject.optLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 0);
            long optLong2 = jSONObject.optLong("size", 0);
            if (Util.isNullOrNil(optString)) {
                jSONObject2.put("errCode", -1);
                jSONObject2.put("errMsg", aVar.getName() + ":fail:parmas error");
                AppMethodBeat.o(226978);
                return;
            }
            if (Util.isNullOrNil(optString2)) {
                try {
                    optString2 = optString + ".jpg";
                    Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(optString);
                    if (PF != null) {
                        BitmapUtil.saveBitmapToImage(PF, 100, Bitmap.CompressFormat.JPEG, optString2, true);
                    } else {
                        Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: generated thumb path is null!");
                    }
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", e3, "hy: exception when convert bitmap", new Object[0]);
                }
            }
            long time = new Date().getTime();
            String str2 = time + ".open_editor_video.mp4";
            b.a a2 = aVar.a(cVar, optString, str2);
            b.a a3 = aVar.a(cVar, optString2, time + ".open_editor_thumb.jpg");
            if (a2 == null) {
                Log.w("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: save video temp file failed!");
                jSONObject2.put("errCode", TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED);
                jSONObject2.put("errMsg", aVar.getName() + ":fail:video file save to file system failed");
                AppMethodBeat.o(226978);
            } else if (a3 == null) {
                Log.w("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: save thumb temp file failed!");
                jSONObject2.put("errCode", TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED);
                jSONObject2.put("errMsg", aVar.getName() + ":fail:video thumb save to file system failed");
                AppMethodBeat.o(226978);
            } else {
                jSONObject2.put("errCode", 0);
                jSONObject2.put("errMsg", aVar.getName() + ":ok");
                jSONObject2.put("chosenId", optInt);
                jSONObject2.put("tempFilePath", a2.lsC);
                jSONObject2.put("tempThumbPath", a3.lsC);
                jSONObject2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1000 * optLong);
                jSONObject2.put("durationUs", 1000 * optLong);
                jSONObject2.put("durationMs", optLong);
                jSONObject2.put("durationS", optLong / 1000);
                jSONObject2.put("size", optLong2);
                AppMethodBeat.o(226978);
            }
        }
    }
}
