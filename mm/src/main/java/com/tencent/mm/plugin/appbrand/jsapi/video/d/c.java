package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.AssetExtension;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends d {
    private static final int CTRL_INDEX = 114;
    public static final String NAME = "operateVideoPlayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(234928);
        int optInt = jSONObject.optInt("videoPlayerId");
        AppMethodBeat.o(234928);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(234929);
        Log.i("MicroMsg.JsApiOperateVideoPlayer", "onOperateView videoPlayerId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiOperateVideoPlayer", "view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(234929);
            return false;
        }
        AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).aB(AppBrandVideoView.class);
        if (appBrandVideoView == null) {
            Log.e("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
            AppMethodBeat.o(234929);
            return false;
        }
        String optString = jSONObject.optString("type");
        Log.i("MicroMsg.JsApiOperateVideoPlayer", "onOperateView operateType=%s", optString);
        char c2 = 65535;
        switch (optString.hashCode()) {
            case -802181223:
                if (optString.equals("exitFullScreen")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1222225:
                if (optString.equals("sendDanmu")) {
                    c2 = 7;
                    break;
                }
                break;
            case 3443508:
                if (optString.equals(AssetExtension.SCENE_PLAY)) {
                    c2 = 0;
                    break;
                }
                break;
            case 3526264:
                if (optString.equals("seek")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3540994:
                if (optString.equals("stop")) {
                    c2 = 2;
                    break;
                }
                break;
            case 106440182:
                if (optString.equals("pause")) {
                    c2 = 1;
                    break;
                }
                break;
            case 458133450:
                if (optString.equals("requestFullScreen")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1355420059:
                if (optString.equals("playbackRate")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                appBrandVideoView.start();
                break;
            case 1:
                appBrandVideoView.pause();
                break;
            case 2:
                appBrandVideoView.stop();
                break;
            case 3:
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                int i3 = -1;
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView directionArr nil");
                } else {
                    i3 = optJSONArray.optInt(0, -1);
                }
                appBrandVideoView.p(true, i3);
                break;
            case 4:
                appBrandVideoView.p(false, -1);
                break;
            case 5:
                JSONArray optJSONArray2 = jSONObject.optJSONArray("data");
                if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                    double optDouble = optJSONArray2.optDouble(0, -1.0d);
                    if (optDouble >= 0.0d) {
                        float f2 = (float) optDouble;
                        Log.i("MicroMsg.Video.AppBrandVideoView", "setPlaybackRate %s", Float.valueOf(f2));
                        appBrandVideoView.mvJ.aO(f2);
                        break;
                    } else {
                        Log.i("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", Double.valueOf(optDouble));
                        AppMethodBeat.o(234929);
                        return false;
                    }
                } else {
                    Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
                    AppMethodBeat.o(234929);
                    return false;
                }
                break;
            case 6:
                JSONArray optJSONArray3 = jSONObject.optJSONArray("data");
                if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                    double optDouble2 = optJSONArray3.optDouble(0, -1.0d);
                    if (optDouble2 >= 0.0d) {
                        appBrandVideoView.d(optDouble2, false);
                        break;
                    } else {
                        Log.i("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %s", Double.valueOf(optDouble2));
                        AppMethodBeat.o(234929);
                        return false;
                    }
                } else {
                    Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
                    AppMethodBeat.o(234929);
                    return false;
                }
                break;
            case 7:
                JSONArray optJSONArray4 = jSONObject.optJSONArray("data");
                if (optJSONArray4 != null && optJSONArray4.length() != 0) {
                    if (optJSONArray4.length() != 1) {
                        appBrandVideoView.dG(optJSONArray4.optString(0, ""), optJSONArray4.optString(1, ""));
                        break;
                    } else {
                        appBrandVideoView.dG(optJSONArray4.optString(0, ""), "");
                        break;
                    }
                } else {
                    Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
                    AppMethodBeat.o(234929);
                    return false;
                }
                break;
            default:
                Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView operateType not supported: %s", optString);
                AppMethodBeat.o(234929);
                return false;
        }
        AppMethodBeat.o(234929);
        return true;
    }
}
