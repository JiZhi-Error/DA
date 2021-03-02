package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends JsApiOperateBackgroundAudio<d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.f, int] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio
    public final /* synthetic */ JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.d dVar, d dVar2, int i2) {
        AppMethodBeat.i(45905);
        JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC setBackgroundAudioListenerTaskWC = new JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC(dVar, dVar2, i2);
        AppMethodBeat.o(45905);
        return setBackgroundAudioListenerTaskWC;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio
    public final /* synthetic */ void l(d dVar) {
        f fVar;
        AppMethodBeat.i(45904);
        d dVar2 = dVar;
        if (this.lEa != null) {
            AppBrandSysConfigLU OM = dVar2.NP().OM();
            this.lEa.dMe = OM.leE.kNW;
            this.lEa.brandName = OM.brandName;
            this.lEa.appUserName = AppBrandRuntimeWCAccessible.c(dVar2);
            final ad.b G = ad.aVe().G(ad.JX("AppBrandService#" + dVar2.hashCode()), true);
            synchronized (G) {
                try {
                    f fVar2 = (f) G.get("StickyBannerChangeListener", null);
                    if (fVar2 == null) {
                        fVar = new f() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.j.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.ui.banner.f
                            public final void bJ(String str, int i2) {
                                AppMethodBeat.i(45902);
                                String string = G.getString("appId", "");
                                int i3 = G.getInt("pkgType", 0);
                                if ((!string.equals(str) || i3 != i2) && G.JY("operateBackgroundAudio#isPlaying") && h.Ud(string) != h.b.ON_RESUME) {
                                    Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onStickyBannerChanged, pause the music");
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("operationType", "pause");
                                    } catch (JSONException e2) {
                                    }
                                    JsApiOperateBackgroundAudio.OperateBackgroundAudioTask operateBackgroundAudioTask = new JsApiOperateBackgroundAudio.OperateBackgroundAudioTask(j.this, j.this.lEa.lAx, j.this.lEa.lqe);
                                    operateBackgroundAudioTask.lEd = jSONObject.toString();
                                    operateBackgroundAudioTask.appId = string;
                                    AppBrandMainProcessService.a(operateBackgroundAudioTask);
                                }
                                AppMethodBeat.o(45902);
                            }
                        };
                        l lVar = (l) dVar2.av(l.class);
                        if (lVar != null) {
                            G.l("pkgType", Integer.valueOf(lVar.leE.kNW));
                        }
                        G.l("StickyBannerChangeListener", fVar);
                        G.l("appId", dVar2.getAppId());
                    } else {
                        fVar = fVar2;
                    }
                    if (((h.c) G.get("AppBrandLifeCycle.Listener", null)) == null) {
                        AnonymousClass2 r0 = new h.c() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.j.AnonymousClass2 */

                            @Override // com.tencent.mm.plugin.appbrand.h.c
                            public final void onDestroy() {
                                AppMethodBeat.i(45903);
                                String string = G.getString("appId", "");
                                Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onDestroy, appId:%s", string);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "stop");
                                } catch (JSONException e2) {
                                }
                                JsApiOperateBackgroundAudio.OperateBackgroundAudioTask operateBackgroundAudioTask = new JsApiOperateBackgroundAudio.OperateBackgroundAudioTask(j.this, j.this.lEa.lAx, j.this.lEa.lqe);
                                operateBackgroundAudioTask.lEd = jSONObject.toString();
                                operateBackgroundAudioTask.appId = string;
                                AppBrandMainProcessService.b(operateBackgroundAudioTask);
                                AppMethodBeat.o(45903);
                            }
                        };
                        G.l("AppBrandLifeCycle.Listener", r0);
                        this.lEa.cxI = r0;
                    }
                    if (this.lEa instanceof JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC) {
                        ((JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC) this.lEa).lEj = fVar;
                        ((JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC) this.lEa).lEi = G;
                    }
                } finally {
                    AppMethodBeat.o(45904);
                }
            }
            return;
        }
        AppMethodBeat.o(45904);
    }
}
