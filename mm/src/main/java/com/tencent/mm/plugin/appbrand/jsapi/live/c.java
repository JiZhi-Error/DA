package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.o;
import com.tencent.rtmp.TXLivePlayer;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends d {
    private static final int CTRL_INDEX = 367;
    public static final String NAME = "operateLivePlayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145885);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.o(145885);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean bEV() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean b(final h hVar, int i2, View view, JSONObject jSONObject, final i iVar) {
        String str;
        String str2;
        int i3;
        String str3;
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(145886);
        Log.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView : livePlayerId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(145886);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (!(view2 instanceof AppBrandLivePlayerView)) {
            Log.e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.o(145886);
            return false;
        }
        AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) view2;
        String optString = jSONObject.optString("type");
        Log.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView operateType=%s", optString);
        if (optString.equalsIgnoreCase("snapshot")) {
            appBrandLivePlayerView.setSnapshotListener(new TXLivePlayer.ITXSnapshotListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.live.c.AnonymousClass1 */

                @Override // com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener
                public final void onSnapshot(Bitmap bitmap) {
                    AppMethodBeat.i(145884);
                    if (bitmap == null || bitmap.isRecycled()) {
                        Log.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: bitmap nil");
                        iVar.ZA(c.this.h("fail:snapshot error", null));
                        AppMethodBeat.o(145884);
                        return;
                    }
                    String str = AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    try {
                        BitmapUtil.saveBitmapToImage(bitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
                        com.tencent.mm.plugin.appbrand.ac.i<String> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
                        if (hVar.getFileSystem().a(new o(str), "jpg", true, iVar) != m.OK) {
                            iVar.ZA(c.this.h("fail:snapshot error", null));
                            AppMethodBeat.o(145884);
                            return;
                        }
                        if (bitmap != null && !bitmap.isRecycled()) {
                            Log.i("MicroMsg.JsApiOperateLivePlayer", "bitmap recycle " + bitmap.toString());
                            bitmap.recycle();
                        }
                        Log.i("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: actualPath:%s path:%s", str, iVar.value);
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempImagePath", iVar.value);
                        hashMap.put("width", Integer.valueOf(width));
                        hashMap.put("height", Integer.valueOf(height));
                        iVar.ZA(c.this.n("ok", hashMap));
                        AppMethodBeat.o(145884);
                    } catch (IOException e2) {
                        Log.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: exception %s", e2.getMessage());
                        iVar.ZA(c.this.h("fail:snapshot error", null));
                        AppMethodBeat.o(145884);
                    }
                }
            });
            if (!appBrandLivePlayerView.j("snapshot", jSONObject)) {
                iVar.ZA(h("fail:snapshot error", null));
            }
        } else if (optString.equalsIgnoreCase("requestFullScreen")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                Log.w("MicroMsg.JsApiOperateLivePlayer", "onOperateView directionArr nil");
                i3 = 0;
            } else {
                i3 = optJSONArray.optInt(0, 0);
            }
            Log.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", Integer.valueOf(i3));
            if (appBrandLivePlayerView.lXD == null) {
                Log.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
                z = false;
            } else if (appBrandLivePlayerView.lXD.isFullScreen()) {
                Log.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
            } else {
                appBrandLivePlayerView.lXD.xd(i3);
                appBrandLivePlayerView.lXF = i3;
                appBrandLivePlayerView.ht(true);
            }
            if (z) {
                str3 = "ok";
            } else {
                str3 = "fail";
            }
            iVar.ZA(h(str3, null));
        } else if (optString.equalsIgnoreCase("exitFullScreen")) {
            Log.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
            if (appBrandLivePlayerView.lXD == null) {
                Log.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
            } else if (!appBrandLivePlayerView.lXD.isFullScreen()) {
                Log.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
                z2 = true;
            } else {
                appBrandLivePlayerView.lXD.bGL();
                z2 = true;
            }
            if (z2) {
                str2 = "ok";
            } else {
                str2 = "fail";
            }
            iVar.ZA(h(str2, null));
        } else {
            if (appBrandLivePlayerView.j(optString, jSONObject)) {
                str = "ok";
            } else {
                str = "fail";
            }
            iVar.ZA(h(str, null));
        }
        boolean b2 = super.b(hVar, i2, view, jSONObject, iVar);
        AppMethodBeat.o(145886);
        return b2;
    }
}
