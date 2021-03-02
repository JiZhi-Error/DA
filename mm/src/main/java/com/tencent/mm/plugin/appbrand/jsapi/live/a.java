package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView;
import com.tencent.mm.plugin.appbrand.page.bu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.base.b {
    private static final int CTRL_INDEX = 364;
    public static final String NAME = "insertLivePlayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(145856);
        j.PP();
        if (jSONObject.optInt("mode", 0) != 2) {
            super.a(fVar, jSONObject, i2);
            AppMethodBeat.o(145856);
        } else if (!(fVar.getContext() instanceof Activity)) {
            Log.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(145856);
        } else {
            try {
                if (android.support.v4.content.b.checkSelfPermission((Activity) fVar.getContext(), "android.permission.RECORD_AUDIO") == 0) {
                    super.a(fVar, jSONObject, i2);
                    AppMethodBeat.o(145856);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", 10001);
                fVar.i(i2, n("fail:system permission denied", hashMap));
                AppMethodBeat.o(145856);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", e2);
                fVar.i(i2, h("fail", null));
                AppMethodBeat.o(145856);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145857);
        int i2 = jSONObject.getInt("livePlayerId");
        AppMethodBeat.o(145857);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(145858);
        CoverViewContainer coverViewContainer = new CoverViewContainer(hVar.getContext(), new AppBrandLivePlayerView(hVar.getContext()));
        coverViewContainer.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(145858);
        return coverViewContainer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(final h hVar, final int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(145859);
        Log.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(145859);
            return;
        }
        TXLiveBase.setAppVersion(String.format("weixin_%s", hVar.getAppId()));
        final AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) ((CoverViewContainer) view).aB(AppBrandLivePlayerView.class);
        final AnonymousClass1 r5 = new bu() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.page.bu
            public final void Na() {
                AppMethodBeat.i(145844);
                AppBrandLivePlayerView appBrandLivePlayerView = appBrandLivePlayerView;
                Log.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
                appBrandLivePlayerView.ht(false);
                AppMethodBeat.o(145844);
            }
        };
        final AnonymousClass2 r7 = new i.d() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
            public final void onForeground() {
                i iVar;
                AppMethodBeat.i(145845);
                l lVar = appBrandLivePlayerView.lXC;
                if (lVar.lYb) {
                    iVar = lVar.k("resume", null);
                } else {
                    iVar = new i();
                }
                Log.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.errorInfo);
                AppMethodBeat.o(145845);
            }
        };
        final AnonymousClass3 r8 = new i.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
            public final void onBackground() {
                AppMethodBeat.i(145846);
                h.d Uc = com.tencent.mm.plugin.appbrand.h.Uc(hVar.getAppId());
                Log.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", Uc.name());
                if (Uc == h.d.LAUNCH_NATIVE_PAGE) {
                    appBrandLivePlayerView.hU(2);
                    AppMethodBeat.o(145846);
                } else if (Uc == h.d.HIDE) {
                    appBrandLivePlayerView.hU(1);
                    AppMethodBeat.o(145846);
                } else {
                    appBrandLivePlayerView.hU(3);
                    AppMethodBeat.o(145846);
                }
            }
        };
        AnonymousClass4 r0 = new i.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
            public final void onDestroy() {
                AppMethodBeat.i(145847);
                appBrandLivePlayerView.onExit();
                hVar.b(this);
                AppMethodBeat.o(145847);
            }
        };
        hVar.a(r7);
        hVar.a(r8);
        hVar.a(r0);
        final boolean optBoolean = jSONObject.optBoolean("independent", false);
        appBrandLivePlayerView.setFullScreenDelegate(new AppBrandLivePlayerView.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.a
            public final void xd(int i2) {
                AppMethodBeat.i(145848);
                hVar.gA(optBoolean).a(i2, r5, i2);
                AppMethodBeat.o(145848);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.a
            public final void bGL() {
                AppMethodBeat.i(145849);
                hVar.gA(optBoolean).wG(i2);
                AppMethodBeat.o(145849);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.a
            public final boolean isFullScreen() {
                AppMethodBeat.i(145850);
                boolean wH = hVar.gA(optBoolean).wH(i2);
                AppMethodBeat.o(145850);
                return wH;
            }
        });
        appBrandLivePlayerView.setExitListener(new AppBrandLivePlayerView.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.b
            public final void bGM() {
                AppMethodBeat.i(145851);
                hVar.b(r8);
                hVar.b(r7);
                AppMethodBeat.o(145851);
            }
        });
        appBrandLivePlayerView.setNeedEvent(jSONObject.optBoolean("needEvent", false));
        appBrandLivePlayerView.setOnFullScreenChangeListener(new AppBrandLivePlayerView.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.c
            public final void n(boolean z, int i2) {
                AppMethodBeat.i(145852);
                b bVar = new b((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("fullScreen", z);
                    jSONObject.put(TencentLocation.EXTRA_DIRECTION, i2);
                    jSONObject.put("livePlayerId", i2);
                } catch (JSONException e2) {
                }
                hVar.a(bVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145852);
            }
        });
        Bundle Y = k.Y(jSONObject);
        l lVar = appBrandLivePlayerView.lXC;
        l.l("initLivePlayer", Y);
        lVar.mVideoView = appBrandLivePlayerView;
        lVar.mVideoView.disableLog(false);
        lVar.cFu.setPlayerView(appBrandLivePlayerView);
        lVar.cEW = Y.getString("playUrl", lVar.cEW);
        lVar.cFx = lVar.n(Y);
        lVar.a(Y, true);
        lVar.cEZ = Y.getBoolean("autoplay", lVar.cEZ);
        if (lVar.cEZ && lVar.cEW != null && !lVar.cEW.isEmpty()) {
            Log.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
            lVar.cFu.startPlay(lVar.cEW, lVar.cFx);
        }
        lVar.mInited = true;
        i iVar = new i();
        Log.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.errorInfo);
        appBrandLivePlayerView.setPlayEventListener(new ITXLivePlayListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass8 */

            @Override // com.tencent.rtmp.ITXLivePlayListener
            public final void onPlayEvent(int i2, Bundle bundle) {
                AppMethodBeat.i(145853);
                Log.i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", Integer.valueOf(i2));
                d dVar = new d((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errCode", i2);
                    jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                    jSONObject.put("livePlayerId", i2);
                } catch (JSONException e2) {
                }
                hVar.a(dVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145853);
            }

            @Override // com.tencent.rtmp.ITXLivePlayListener
            public final void onNetStatus(Bundle bundle) {
                AppMethodBeat.i(145854);
                c cVar = new c((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livePlayerId", i2);
                    JSONObject jSONObject2 = new JSONObject();
                    if (bundle != null) {
                        for (String str : bundle.keySet()) {
                            jSONObject2.put(str, bundle.get(str));
                        }
                    }
                    jSONObject.put("info", jSONObject2);
                } catch (JSONException e2) {
                }
                hVar.a(cVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145854);
            }
        });
        appBrandLivePlayerView.setAudioVolumeEventListener(new TXLivePlayer.ITXAudioVolumeEvaluationListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.a.AnonymousClass9 */

            @Override // com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener
            public final void onAudioVolumeEvaluationNotify(int i2) {
                AppMethodBeat.i(145855);
                C0673a aVar = new C0673a((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livePlayerId", i2);
                    jSONObject.put("volume", i2);
                } catch (JSONException e2) {
                }
                hVar.a(aVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145855);
            }
        });
        appBrandLivePlayerView.setContentDescription(Y.getInt("mode", 0) == 5 ? view.getContext().getString(R.string.hm) : view.getContext().getString(R.string.hl));
        AppMethodBeat.o(145859);
    }

    static final class d extends bc {
        private static final int CTRL_INDEX = 369;
        private static final String NAME = "onLivePlayerEvent";

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static final class b extends bc {
        private static final int CTRL_INDEX = 371;
        private static final String NAME = "onLivePlayerFullScreenChange";

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static final class c extends bc {
        private static final int CTRL_INDEX = 412;
        private static final String NAME = "onLivePlayerNetStatus";

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.a$a  reason: collision with other inner class name */
    static final class C0673a extends bc {
        private static final int CTRL_INDEX = 709;
        private static final String NAME = "onLivePlayerAudioVolume";

        private C0673a() {
        }

        /* synthetic */ C0673a(byte b2) {
            this();
        }
    }
}
