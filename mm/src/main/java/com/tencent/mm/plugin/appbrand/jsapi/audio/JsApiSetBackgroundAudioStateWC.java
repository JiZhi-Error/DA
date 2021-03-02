package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioStateWC extends JsApiSetBackgroundAudioState {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
    public final JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(d dVar, f fVar, int i2) {
        AppMethodBeat.i(45954);
        SetBackgroundAudioStateTaskWC setBackgroundAudioStateTaskWC = new SetBackgroundAudioStateTaskWC(dVar, fVar, i2);
        AppMethodBeat.o(45954);
        return setBackgroundAudioStateTaskWC;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
    public final JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(d dVar, f fVar, int i2) {
        AppMethodBeat.i(45955);
        SetBackgroundAudioListenerTaskWC setBackgroundAudioListenerTaskWC = new SetBackgroundAudioListenerTaskWC(dVar, fVar, i2);
        AppMethodBeat.o(45955);
        return setBackgroundAudioListenerTaskWC;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
    public final void a(String str, f fVar) {
        AppMethodBeat.i(45956);
        if (this.lEa != null) {
            l lVar = (l) fVar.av(l.class);
            this.lEa.dMe = lVar.leE.kNW;
            this.lEa.brandName = lVar.brandName;
            this.lEa.appUserName = AppBrandRuntimeWCAccessible.c(fVar);
            Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", Integer.valueOf(this.lEa.dMe), this.lEa.brandName, this.lEa.appUserName);
            final ad.b G = ad.aVe().G(str, true);
            synchronized (G) {
                try {
                    com.tencent.mm.plugin.appbrand.ui.banner.f fVar2 = (com.tencent.mm.plugin.appbrand.ui.banner.f) G.get("StickyBannerChangeListener", null);
                    if (fVar2 == null) {
                        fVar2 = new com.tencent.mm.plugin.appbrand.ui.banner.f() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.ui.banner.f
                            public final void bJ(String str, int i2) {
                                AppMethodBeat.i(45950);
                                String string = G.getString("appId", "");
                                int i3 = G.getInt("pkgType", 0);
                                if ((!string.equals(str) || i3 != i2) && G.JY("setBackgroundAudioState#isPlaying") && h.Ud(string) != h.b.ON_RESUME) {
                                    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("operationType", "pause");
                                    } catch (JSONException e2) {
                                    }
                                    JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b2 = JsApiSetBackgroundAudioStateWC.this.b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.lEa.lAx, JsApiSetBackgroundAudioStateWC.this.lEa.lqe);
                                    b2.lEd = jSONObject.toString();
                                    b2.appId = string;
                                    AppBrandMainProcessService.a(b2);
                                }
                                AppMethodBeat.o(45950);
                            }
                        };
                        G.l("pkgType", Integer.valueOf(lVar.leE.kNW));
                        G.l("StickyBannerChangeListener", fVar2);
                        G.l("appId", fVar.getAppId());
                    }
                    if (this.lEa instanceof SetBackgroundAudioListenerTaskWC) {
                        ((SetBackgroundAudioListenerTaskWC) this.lEa).lEj = fVar2;
                        ((SetBackgroundAudioListenerTaskWC) this.lEa).lEi = G;
                    }
                } finally {
                    AppMethodBeat.o(45956);
                }
            }
            return;
        }
        AppMethodBeat.o(45956);
    }

    public static class SetBackgroundAudioStateTaskWC extends JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask {
        public SetBackgroundAudioStateTaskWC(d dVar, f fVar, int i2) {
            super(dVar, fVar, i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask
        public final String Zn(String str) {
            AppMethodBeat.i(45953);
            String str2 = com.tencent.mm.plugin.image.d.aSY() + str.hashCode();
            AppMethodBeat.o(45953);
            return str2;
        }
    }

    public static class SetBackgroundAudioListenerTaskWC extends JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask {
        private Context context;
        public ad.b lEi;
        public com.tencent.mm.plugin.appbrand.ui.banner.f lEj;

        public SetBackgroundAudioListenerTaskWC(d dVar, f fVar, int i2) {
            super(dVar, fVar, i2);
            AppMethodBeat.i(45951);
            this.context = fVar.getContext();
            AppMethodBeat.o(45951);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
        public final void wL(int i2) {
            AppMethodBeat.i(45952);
            switch (i2) {
                case 0:
                case 1:
                    this.lEi.l("setBackgroundAudioState#isPlaying", Boolean.TRUE);
                    AppBrandStickyBannerLogic.a.d(this.lEj);
                    if (!b.cx(MMApplicationContext.getContext())) {
                        AppBrandFloatBallPermissionHelper.a(this.context, 6, null);
                    }
                    AppMethodBeat.o(45952);
                    return;
                case 2:
                case 3:
                case 4:
                case 7:
                    this.lEi.l("setBackgroundAudioState#isPlaying", Boolean.FALSE);
                    AppBrandStickyBannerLogic.a.c(this.lEj);
                    AppMethodBeat.o(45952);
                    return;
                case 5:
                case 6:
                case 9:
                default:
                    AppMethodBeat.o(45952);
                    return;
                case 8:
                case 11:
                case 12:
                    AppMethodBeat.o(45952);
                    return;
                case 10:
                    AppMethodBeat.o(45952);
                    return;
                case 13:
                    AppMethodBeat.o(45952);
                    return;
                case 14:
                    AppMethodBeat.o(45952);
                    return;
            }
        }
    }
}
