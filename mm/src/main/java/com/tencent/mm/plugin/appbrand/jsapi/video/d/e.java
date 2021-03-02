package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends d {
    private static final int CTRL_INDEX = 87;
    public static final String NAME = "updateVideoPlayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(234933);
        int optInt = jSONObject.optInt("videoPlayerId");
        AppMethodBeat.o(234933);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        boolean z;
        AppMethodBeat.i(234934);
        Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView videoPlayerId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiUpdateVideoPlayer", "view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(234934);
            return false;
        }
        AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).aB(AppBrandVideoView.class);
        if (appBrandVideoView == null) {
            Log.e("MicroMsg.JsApiUpdateVideoPlayer", "view not AppBrandVideoView");
            AppMethodBeat.o(234934);
            return false;
        }
        try {
            if (jSONObject.has("showDanmuBtn")) {
                appBrandVideoView.setShowDanmakuBtn(jSONObject.getBoolean("showDanmuBtn"));
            }
        } catch (JSONException e2) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showDanmuBtn", e2.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("danmuList")) {
                appBrandVideoView.setDanmakuItemList(jSONObject.getJSONArray("danmuList"));
            }
        } catch (JSONException e3) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "danmuList", e3.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("objectFit")) {
                appBrandVideoView.setObjectFit(jSONObject.getString("objectFit"));
            }
        } catch (JSONException e4) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "objectFit", e4.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoplay")) {
                appBrandVideoView.setAutoPlay(jSONObject.getBoolean("autoplay"));
            }
        } catch (JSONException e5) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "autoplay", e5.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showBasicControls")) {
                appBrandVideoView.setIsShowBasicControls(jSONObject.getBoolean("showBasicControls"));
            }
        } catch (JSONException e6) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showBasicControls", e6.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("poster")) {
                appBrandVideoView.setCover$16da05f7(jSONObject.getString("poster"));
            }
        } catch (JSONException e7) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "poster", e7.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(TencentLocation.EXTRA_DIRECTION)) {
                appBrandVideoView.setFullScreenDirection(jSONObject.getInt(TencentLocation.EXTRA_DIRECTION));
            }
        } catch (Exception e8) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", TencentLocation.EXTRA_DIRECTION, e8.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                appBrandVideoView.setMute(jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e9) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "muted", e9.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("loop")) {
                appBrandVideoView.setLoop(jSONObject.getBoolean("loop"));
            }
        } catch (JSONException e10) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "loop", e10.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("data")) {
                appBrandVideoView.setCookieData(jSONObject.getString("data"));
            }
        } catch (JSONException e11) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "data", e11.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("pageGesture")) {
                appBrandVideoView.setPageGesture(jSONObject.getBoolean("pageGesture"));
            }
        } catch (JSONException e12) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "pageGesture", e12.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("pageGestureInFullscreen")) {
                appBrandVideoView.setPageGestureInFullscreen(jSONObject.getBoolean("pageGestureInFullscreen"));
            }
        } catch (JSONException e13) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "pageGestureInFullscreen", e13.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showControlProgress")) {
                appBrandVideoView.setShowControlProgress(jSONObject.getBoolean("showControlProgress"));
            }
        } catch (JSONException e14) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showControlProgress", e14.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showProgress")) {
                appBrandVideoView.setShowProgress(jSONObject.getBoolean("showProgress"));
            }
        } catch (JSONException e15) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showProgress", e15.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showProgressInControlMode")) {
                appBrandVideoView.setShowProgressBarInControlMode(jSONObject.getBoolean("showProgressInControlMode"));
            }
        } catch (JSONException e16) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showProgressInControlMode", e16.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showFullScreenBtn")) {
                appBrandVideoView.setShowFullScreenBtn(jSONObject.getBoolean("showFullScreenBtn"));
            }
        } catch (JSONException e17) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showFullScreenBtn", e17.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showPlayBtn")) {
                appBrandVideoView.setShowPlayBtn(jSONObject.getBoolean("showPlayBtn"));
            }
        } catch (JSONException e18) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showPlayBtn", e18.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showCenterPlayBtn")) {
                appBrandVideoView.setShowCenterPlayBtn(jSONObject.getBoolean("showCenterPlayBtn"));
            }
        } catch (JSONException e19) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showCenterPlayBtn", e19.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableProgressGesture")) {
                appBrandVideoView.hM(jSONObject.getBoolean("enableProgressGesture"));
            }
        } catch (JSONException e20) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "enableProgressGesture", e20.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_DURATION)) {
                appBrandVideoView.setDuration(jSONObject.getInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
            }
        } catch (JSONException e21) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "disableScroll", e21.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(MessengerShareContentUtility.SHARE_BUTTON_HIDE) && jSONObject.getBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE)) {
                Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView hide stop");
                appBrandVideoView.stop();
            }
        } catch (JSONException e22) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", MessengerShareContentUtility.SHARE_BUTTON_HIDE, e22.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("initialTime")) {
                appBrandVideoView.setInitialTime((double) jSONObject.getInt("initialTime"));
            }
        } catch (JSONException e23) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "initialTime", e23.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                if (!jSONObject.getBoolean("needEvent")) {
                    appBrandVideoView.setCallback(null);
                } else {
                    if (appBrandVideoView.mwc != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        appBrandVideoView.setCallback(new b(appBrandVideoView, hVar));
                    }
                }
            }
        } catch (JSONException e24) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "needEvent", e24.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showMuteBtn")) {
                appBrandVideoView.setShowMuteBtn(jSONObject.getBoolean("showMuteBtn"));
            }
        } catch (JSONException e25) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showMuteBtn", e25.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("title")) {
                appBrandVideoView.setTitle(jSONObject.getString("title"));
            }
        } catch (JSONException e26) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "title", e26.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("playBtnPosition")) {
                appBrandVideoView.setPlayBtnPosition(jSONObject.getString("playBtnPosition"));
            }
        } catch (JSONException e27) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "playBtnPosition", e27.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enablePlayGesture")) {
                appBrandVideoView.setEnablePlayGesture(jSONObject.getBoolean("enablePlayGesture"));
            }
        } catch (JSONException e28) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "enablePlayGesture", e28.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfOpenNative")) {
                appBrandVideoView.setAutoPauseIfOpenNative(jSONObject.getBoolean("autoPauseIfOpenNative"));
            }
        } catch (JSONException e29) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "autoPauseIfOpenNative", e29.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfNavigate")) {
                appBrandVideoView.setAutoPauseIfNavigate(jSONObject.getBoolean("autoPauseIfNavigate"));
            }
        } catch (JSONException e30) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "autoPauseIfNavigate", e30.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("filePath")) {
                appBrandVideoView.e(jSONObject.getString("filePath"), jSONObject.optBoolean(WeChatBrands.Business.GROUP_LIVE), jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
            }
        } catch (JSONException e31) {
            Log.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "filePath", e31.getLocalizedMessage());
        }
        AppMethodBeat.o(234934);
        return true;
    }
}
