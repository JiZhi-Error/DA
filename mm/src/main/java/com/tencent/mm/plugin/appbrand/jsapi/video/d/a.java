package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.appbrand.page.bu;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b {
    public static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(234921);
        Context context = hVar.getContext();
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = new AppBrandVideoViewControlBar(context);
        AppBrandVideoWrapper appBrandVideoWrapper = new AppBrandVideoWrapper(context);
        appBrandVideoWrapper.setVideoFooterView(appBrandVideoViewControlBar);
        AppBrandVideoView appBrandVideoView = new AppBrandVideoView(context, appBrandVideoWrapper);
        appBrandVideoView.a(appBrandVideoViewControlBar);
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, appBrandVideoView);
        AppMethodBeat.o(234921);
        return coverViewContainer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(234922);
        int i2 = jSONObject.getInt("videoPlayerId");
        AppMethodBeat.o(234922);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public void a(final h hVar, final int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(234923);
        Log.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", Integer.valueOf(i2));
        final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).aB(AppBrandVideoView.class);
        if (appBrandVideoView == null) {
            Log.e("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
            AppMethodBeat.o(234923);
            return;
        }
        final AnonymousClass1 r12 = new bu() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.d.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.page.bu
            public final void Na() {
                AppMethodBeat.i(234914);
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                Log.i("MicroMsg.Video.AppBrandVideoView", "onExitFullScreen");
                if (appBrandVideoView.mvM.bJx()) {
                    appBrandVideoView.mvM.bGL();
                }
                appBrandVideoView.hN(false);
                AppMethodBeat.o(234914);
            }
        };
        final AnonymousClass2 r8 = new i.d() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.d.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
            public final void onForeground() {
                AppMethodBeat.i(234915);
                appBrandVideoView.onUIResume();
                AppMethodBeat.o(234915);
            }
        };
        final AnonymousClass3 r9 = new i.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.d.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
            public final void onBackground() {
                AppMethodBeat.i(234916);
                h.d Uc = com.tencent.mm.plugin.appbrand.h.Uc(hVar.getAppId());
                Log.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", Uc.name());
                if (Uc == h.d.LAUNCH_NATIVE_PAGE) {
                    appBrandVideoView.xr(2);
                    AppMethodBeat.o(234916);
                } else if (Uc == h.d.HIDE) {
                    appBrandVideoView.xr(1);
                    AppMethodBeat.o(234916);
                } else {
                    appBrandVideoView.xr(3);
                    AppMethodBeat.o(234916);
                }
            }
        };
        AnonymousClass4 r4 = new i.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.d.a.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
            public final void onDestroy() {
                AppMethodBeat.i(234917);
                appBrandVideoView.onUIDestroy();
                hVar.b(r8);
                hVar.b(r9);
                hVar.b(this);
                AppMethodBeat.o(234917);
            }
        };
        hVar.a(r8);
        hVar.a(r9);
        hVar.a(r4);
        final boolean optBoolean = jSONObject.optBoolean("independent", false);
        appBrandVideoView.setFullScreenDelegate(new AppBrandVideoView.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.d.a.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a
            public final void xd(int i2) {
                AppMethodBeat.i(234918);
                hVar.gA(optBoolean).a(i2, r12, i2);
                AppMethodBeat.o(234918);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a
            public final void bGL() {
                AppMethodBeat.i(234919);
                hVar.gA(optBoolean).wG(i2);
                AppMethodBeat.o(234919);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a
            public final boolean isFullScreen() {
                AppMethodBeat.i(234920);
                boolean wH = hVar.gA(optBoolean).wH(i2);
                AppMethodBeat.o(234920);
                return wH;
            }
        });
        appBrandVideoView.setContentDescription(view.getContext().getString(R.string.hp));
        appBrandVideoView.setMute(jSONObject.optBoolean("muted", false));
        boolean optBoolean2 = jSONObject.optBoolean("needEvent", false);
        boolean optBoolean3 = jSONObject.optBoolean("autoplay", false);
        Log.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", Boolean.valueOf(optBoolean3), Boolean.valueOf(optBoolean2));
        boolean optBoolean4 = jSONObject.optBoolean("showDanmuBtn", false);
        boolean optBoolean5 = jSONObject.optBoolean("enableDanmu", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("danmuList");
        String optString = jSONObject.optString("objectFit");
        String optString2 = jSONObject.optString("poster");
        boolean optBoolean6 = jSONObject.optBoolean("showBasicControls", true);
        String optString3 = jSONObject.optString("data");
        int optInt = jSONObject.optInt(TencentLocation.EXTRA_DIRECTION, -1);
        boolean optBoolean7 = jSONObject.optBoolean("loop", false);
        boolean optBoolean8 = jSONObject.optBoolean("pageGesture", false);
        boolean optBoolean9 = jSONObject.optBoolean("pageGestureInFullscreen", true);
        double optDouble = jSONObject.optDouble("initialTime", 0.0d);
        boolean optBoolean10 = jSONObject.optBoolean("showProgress", true);
        boolean optBoolean11 = jSONObject.optBoolean("showProgressInControlMode", true);
        boolean optBoolean12 = jSONObject.optBoolean("showFullScreenBtn", true);
        boolean optBoolean13 = jSONObject.optBoolean("showPlayBtn", true);
        boolean optBoolean14 = jSONObject.optBoolean("showCenterPlayBtn", true);
        boolean optBoolean15 = jSONObject.optBoolean("enableProgressGesture", true);
        String optString4 = jSONObject.optString("scene", BuildConfig.KINDA_DEFAULT);
        boolean optBoolean16 = jSONObject.optBoolean("showMuteBtn", false);
        String optString5 = jSONObject.optString("title", "");
        boolean optBoolean17 = jSONObject.optBoolean("showControlProgress", true);
        String optString6 = jSONObject.optString("playBtnPosition", "bottom");
        boolean optBoolean18 = jSONObject.optBoolean("enablePlayGesture", false);
        boolean optBoolean19 = jSONObject.optBoolean("autoPauseIfNavigate", true);
        boolean optBoolean20 = jSONObject.optBoolean("autoPauseIfOpenNative", true);
        String optString7 = jSONObject.optString("backgroundColor");
        appBrandVideoView.setComponent(hVar);
        appBrandVideoView.setCookieData(optString3);
        appBrandVideoView.setIsShowBasicControls(optBoolean6);
        appBrandVideoView.setCover$16da05f7(optString2);
        appBrandVideoView.setFullScreenDirection(optInt);
        appBrandVideoView.setObjectFit(optString);
        appBrandVideoView.setLoop(optBoolean7);
        appBrandVideoView.setPageGesture(optBoolean8);
        appBrandVideoView.setPageGestureInFullscreen(optBoolean9);
        try {
            appBrandVideoView.setVideoPlayerId(H(jSONObject));
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", e2);
        }
        appBrandVideoView.setAutoPlay(optBoolean3);
        appBrandVideoView.setShowDanmakuBtn(optBoolean4);
        appBrandVideoView.setDanmakuEnable(optBoolean5);
        appBrandVideoView.setDanmakuItemList(optJSONArray);
        appBrandVideoView.setInitialTime(optDouble);
        appBrandVideoView.setShowControlProgress(optBoolean17);
        appBrandVideoView.setShowProgress(optBoolean10);
        appBrandVideoView.setShowProgressBarInControlMode(optBoolean11);
        appBrandVideoView.setShowFullScreenBtn(optBoolean12);
        appBrandVideoView.setShowPlayBtn(optBoolean13);
        appBrandVideoView.setShowCenterPlayBtn(optBoolean14);
        appBrandVideoView.hM(optBoolean15);
        if (optString4.equalsIgnoreCase(BuildConfig.KINDA_DEFAULT)) {
            appBrandVideoView.setVideoSource(0);
        } else {
            appBrandVideoView.setVideoSource(1);
        }
        appBrandVideoView.setShowMuteBtn(optBoolean16);
        appBrandVideoView.setTitle(optString5);
        appBrandVideoView.setPlayBtnPosition(optString6);
        appBrandVideoView.setEnablePlayGesture(optBoolean18);
        appBrandVideoView.setAutoPauseIfNavigate(optBoolean19);
        appBrandVideoView.setAutoPauseIfOpenNative(optBoolean20);
        if (!TextUtils.isEmpty(optString7)) {
            int i3 = WebView.NIGHT_MODE_COLOR;
            if ("transparent".equals(optString7)) {
                i3 = 0;
            } else {
                try {
                    i3 = Color.parseColor(optString7);
                } catch (IllegalArgumentException e3) {
                }
            }
            appBrandVideoView.setBackgroundColor(i3);
        }
        if (optBoolean2) {
            appBrandVideoView.setCallback(new com.tencent.mm.plugin.appbrand.jsapi.video.c.b(appBrandVideoView, hVar));
        }
        int optInt2 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, -1);
        String optString8 = jSONObject.optString("filePath");
        boolean optBoolean21 = jSONObject.optBoolean(WeChatBrands.Business.GROUP_LIVE, false);
        Log.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", optString8, Boolean.valueOf(optBoolean21));
        appBrandVideoView.e(optString8, optBoolean21, optInt2);
        AppMethodBeat.o(234923);
    }
}
