package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.o;
import com.tencent.rtmp.TXLivePusher;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.base.d {
    private static final int CTRL_INDEX = 363;
    public static final String NAME = "operateLivePusher";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145889);
        int optInt = jSONObject.optInt("livePusherId");
        AppMethodBeat.o(145889);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean bEV() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean b(final h hVar, int i2, View view, JSONObject jSONObject, final i iVar) {
        AppMethodBeat.i(145890);
        Log.i("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(145890);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (!(view2 instanceof AppBrandLivePusherView)) {
            Log.e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
            AppMethodBeat.o(145890);
            return false;
        }
        final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) view2;
        String optString = jSONObject.optString("type");
        Log.i("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", optString);
        if (optString.equalsIgnoreCase("snapshot")) {
            appBrandLivePusherView.setSnapshotListener(new TXLivePusher.ITXSnapshotListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.live.d.AnonymousClass2 */

                @Override // com.tencent.rtmp.TXLivePusher.ITXSnapshotListener
                public final void onSnapshot(Bitmap bitmap) {
                    AppMethodBeat.i(145888);
                    if (bitmap == null || bitmap.isRecycled()) {
                        Log.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
                        iVar.ZA(d.this.h("fail:snapshot error", null));
                        AppMethodBeat.o(145888);
                        return;
                    }
                    String str = AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    try {
                        BitmapUtil.saveBitmapToImage(bitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
                        com.tencent.mm.plugin.appbrand.ac.i<String> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
                        if (hVar.getFileSystem().a(new o(str), "jpg", true, iVar) != m.OK) {
                            iVar.ZA(d.this.h("fail:snapshot error", null));
                            AppMethodBeat.o(145888);
                            return;
                        }
                        if (bitmap != null && !bitmap.isRecycled()) {
                            Log.i("MicroMsg.JsApiOperateLivePusher", "bitmap recycle " + bitmap.toString());
                            bitmap.recycle();
                        }
                        Log.i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", str, iVar.value);
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempImagePath", iVar.value);
                        hashMap.put("width", Integer.valueOf(width));
                        hashMap.put("height", Integer.valueOf(height));
                        iVar.ZA(d.this.n("ok", hashMap));
                        AppMethodBeat.o(145888);
                    } catch (IOException e2) {
                        Log.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", e2.getMessage());
                        iVar.ZA(d.this.h("fail:snapshot error", null));
                        AppMethodBeat.o(145888);
                    }
                }
            });
            if (!appBrandLivePusherView.j("snapshot", jSONObject)) {
                iVar.ZA(h("fail:snapshot error", null));
            }
        } else if (optString.equalsIgnoreCase("playBGM")) {
            final String optString2 = jSONObject.optString("url");
            if (Util.isNullOrNil(optString2)) {
                Log.w("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
                iVar.ZA(h("fail:url is nil", null));
            } else {
                c.a(hVar, optString2, null, new c.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.live.d.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                    public final void Wz(String str) {
                        AppMethodBeat.i(145887);
                        if (!Util.isNullOrNil(str)) {
                            Log.i("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s", str);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("BGMFilePath", str);
                            } catch (JSONException e2) {
                                Log.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", e2);
                            }
                            if (!appBrandLivePusherView.j("playBGM", jSONObject)) {
                                Log.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", optString2);
                                HashMap<String, Object> hashMap = new HashMap<>();
                                hashMap.put("url", optString2);
                                appBrandLivePusherView.a(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, "download file fail", hashMap);
                            }
                            AppMethodBeat.o(145887);
                            return;
                        }
                        Log.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", optString2);
                        HashMap<String, Object> hashMap2 = new HashMap<>();
                        hashMap2.put("url", optString2);
                        appBrandLivePusherView.a(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, "download file fail", hashMap2);
                        AppMethodBeat.o(145887);
                    }
                });
                iVar.ZA(h("ok", null));
            }
        } else if (appBrandLivePusherView.j(optString, jSONObject)) {
            iVar.ZA(h("ok", null));
        } else {
            iVar.ZA(h("fail", null));
        }
        boolean b2 = super.b(hVar, i2, view, jSONObject, iVar);
        AppMethodBeat.o(145890);
        return b2;
    }
}
