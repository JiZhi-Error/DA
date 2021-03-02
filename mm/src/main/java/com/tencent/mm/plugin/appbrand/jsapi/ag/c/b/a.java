package com.tencent.mm.plugin.appbrand.jsapi.ag.c.b;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

public final class a implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a {
    private AppBrandRuntime kEc = null;
    private i.a lEv = null;
    private volatile boolean mIsPushing = false;
    private boolean mJN = true;
    private boolean mKk = false;

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final b Qm() {
        AppMethodBeat.i(139515);
        b bVar = new b();
        AppMethodBeat.o(139515);
        return bVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final c Qn() {
        AppMethodBeat.i(139516);
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.c cVar = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.c();
        AppMethodBeat.o(139516);
        return cVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void a(o oVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(215870);
        this.mJN = bundle.getBoolean("enableMic", this.mJN);
        bMd();
        if (bundle.getBoolean("isVoip", false)) {
            e z2 = z(aVar);
            if (z2 == null) {
                Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
                z2 = new e();
                com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar).a(z2);
                z = true;
            } else {
                z = false;
            }
            if (oVar != null) {
                z2.mJO = oVar;
                Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", oVar.PH());
            }
            z2.c(com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar), this.mJN);
            if (z && this.mIsPushing) {
                Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, is pushing");
                e.a(com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar), oVar);
            }
            AppMethodBeat.o(215870);
            return;
        }
        Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not voip");
        AppMethodBeat.o(215870);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void b(com.tencent.luggage.xweb_ext.extendplugin.a aVar, Bundle bundle) {
        AppMethodBeat.i(215871);
        this.mJN = bundle.getBoolean("enableMic", this.mJN);
        bMd();
        e z = z(aVar);
        if (z != null) {
            z.c(com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar), this.mJN);
            AppMethodBeat.o(215871);
            return;
        }
        Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
        AppMethodBeat.o(215871);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void a(o oVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(215872);
        e z = z(aVar);
        if (z != null) {
            if (z.mJO == oVar) {
                z.mJO = null;
                Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", oVar.PH());
            }
            AppMethodBeat.o(215872);
            return;
        }
        Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
        AppMethodBeat.o(215872);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void b(o oVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(215873);
        this.mIsPushing = true;
        this.kEc = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar);
        bMd();
        if (z(aVar) != null) {
            e.a(com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar), oVar);
            AppMethodBeat.o(215873);
            return;
        }
        Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
        AppMethodBeat.o(215873);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void c(o oVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(215874);
        this.mIsPushing = false;
        bMd();
        e z = z(aVar);
        if (z != null) {
            AppBrandRuntime y = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar);
            if (y != null) {
                Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", y.mAppId, oVar.PH());
                e.b(y, 2);
                y.b(z);
            }
            AppMethodBeat.o(215874);
            return;
        }
        Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
        AppMethodBeat.o(215874);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final boolean a(o oVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar, int i2) {
        AppMethodBeat.i(215875);
        e z = z(aVar);
        if (z != null) {
            boolean a2 = z.a(oVar, i2);
            AppMethodBeat.o(215875);
            return a2;
        }
        Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
        AppMethodBeat.o(215875);
        return false;
    }

    private static e z(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(215876);
        AppBrandRuntime y = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar);
        if (y != null) {
            e eVar = (e) y.aw(e.class);
            AppMethodBeat.o(215876);
            return eVar;
        }
        AppMethodBeat.o(215876);
        return null;
    }

    private void bMd() {
        AppMethodBeat.i(215877);
        if (!this.mIsPushing || !this.mJN) {
            bMf();
            AppMethodBeat.o(215877);
            return;
        }
        bMe();
        AppMethodBeat.o(215877);
    }

    private void bMe() {
        AppMethodBeat.i(215878);
        if (this.lEv != null) {
            Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar, already blink");
            AppMethodBeat.o(215878);
            return;
        }
        if (this.kEc != null) {
            Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar");
            this.lEv = a.C0775a.ah(this.kEc).a(a.b.VOICE);
        }
        AppMethodBeat.o(215878);
    }

    private void bMf() {
        AppMethodBeat.i(215879);
        if (this.lEv != null) {
            Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "dismissBlink");
            this.lEv.dismiss();
            this.lEv = null;
        }
        AppMethodBeat.o(215879);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, final a.AbstractC0191a aVar2) {
        AppMethodBeat.i(139517);
        if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
            AppMethodBeat.o(139517);
            return;
        }
        com.tencent.mm.plugin.appbrand.h.b bVar = (com.tencent.mm.plugin.appbrand.h.b) aVar;
        JSONObject Ps = bVar.Ps();
        final String optString = Ps.optString("backgroundImage");
        String optString2 = Ps.optString("backgroundMD5");
        if (Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
            AppMethodBeat.o(139517);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a(bVar.lqg, optString, optString2, new b.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a
            public final void Wz(String str) {
                AppMethodBeat.i(139513);
                if (aVar2 != null) {
                    aVar2.F(optString, str);
                }
                AppMethodBeat.o(139513);
            }
        });
        AppMethodBeat.o(139517);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, final String str, String str2, final a.AbstractC0191a aVar2) {
        AppMethodBeat.i(178855);
        if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
            AppMethodBeat.o(178855);
            return;
        }
        com.tencent.mm.plugin.appbrand.h.b bVar = (com.tencent.mm.plugin.appbrand.h.b) aVar;
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertFilterImageToLocalPath, url is null");
            AppMethodBeat.o(178855);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a(bVar.lqg, str, str2, new b.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a
            public final void Wz(String str) {
                AppMethodBeat.i(139514);
                if (aVar2 != null) {
                    aVar2.F(str, str);
                }
                AppMethodBeat.o(139514);
            }
        });
        AppMethodBeat.o(178855);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, final String str, String str2, boolean z, final a.b bVar) {
        AppMethodBeat.i(215880);
        if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
            Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, invokeContext is not AppBrandInvokeContext");
            bVar.Qi();
            AppMethodBeat.o(215880);
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, resourcePath is null");
            bVar.Qi();
            AppMethodBeat.o(215880);
        } else {
            f NN = aVar.NN();
            if (NN == null) {
                Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, component is null");
                bVar.Qi();
                AppMethodBeat.o(215880);
                return;
            }
            com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a(NN, str, z, str2, new b.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a
                public final void Wz(String str) {
                    AppMethodBeat.i(178854);
                    if (bVar != null) {
                        if (str == null) {
                            bVar.Qi();
                            AppMethodBeat.o(178854);
                            return;
                        }
                        bVar.F(str, str);
                    }
                    AppMethodBeat.o(178854);
                }
            });
            AppMethodBeat.o(215880);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void b(com.tencent.luggage.xweb_ext.extendplugin.a aVar, final a.AbstractC0191a aVar2) {
        AppMethodBeat.i(139518);
        if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
            AppMethodBeat.o(139518);
            return;
        }
        com.tencent.mm.plugin.appbrand.h.b bVar = (com.tencent.mm.plugin.appbrand.h.b) aVar;
        final String optString = bVar.Ps().optString("url");
        if (Util.isNullOrNil(optString)) {
            Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
            aVar.dP("fail:invalid data");
            AppMethodBeat.o(139518);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a(bVar.lqg, optString, null, new b.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a
            public final void Wz(String str) {
                AppMethodBeat.i(215869);
                if (aVar2 != null) {
                    aVar2.F(optString, s.k(str, false));
                }
                AppMethodBeat.o(215869);
            }
        });
        AppMethodBeat.o(139518);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final String c(com.tencent.luggage.xweb_ext.extendplugin.a aVar, Bundle bundle) {
        c cVar;
        AppMethodBeat.i(215881);
        boolean z = this.mKk;
        boolean z2 = bundle.getBoolean("isVoip", z);
        Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, oldIsVoip: %b, newIsVoip: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.mKk = z2;
        if (!z2 || z) {
            Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not voip mode");
        } else {
            AppBrandRuntime y = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(aVar);
            if (!(y == null || (cVar = (c) y.aw(c.class)) == null)) {
                String bMg = cVar.bMg();
                Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", bMg);
                AppMethodBeat.o(215881);
                return bMg;
            }
        }
        AppMethodBeat.o(215881);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, Bitmap bitmap) {
        AppMethodBeat.i(139519);
        if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
            AppMethodBeat.o(139519);
        } else if (bitmap == null || bitmap.isRecycled()) {
            Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, bitmap is null");
            aVar.dP("fail:snapshot error");
            AppMethodBeat.o(139519);
        } else {
            f fVar = ((com.tencent.mm.plugin.appbrand.h.b) aVar).lqg;
            String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
                com.tencent.mm.plugin.appbrand.ac.i<String> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
                if (fVar.getFileSystem() == null) {
                    aVar.dP("fail");
                    AppMethodBeat.o(139519);
                } else if (fVar.getFileSystem().a(new com.tencent.mm.vfs.o(str), "jpg", true, iVar) != m.OK) {
                    Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
                    aVar.dP("fail:snapshot error");
                    AppMethodBeat.o(139519);
                } else {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "bitmap recycle " + bitmap.toString());
                        bitmap.recycle();
                    }
                    Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, actualPath:%s path:%s", str, iVar.value);
                    HashMap hashMap = new HashMap();
                    hashMap.put("tempImagePath", iVar.value);
                    hashMap.put("width", Integer.valueOf(width));
                    hashMap.put("height", Integer.valueOf(height));
                    aVar.f("ok", hashMap);
                    AppMethodBeat.o(139519);
                }
            } catch (IOException e2) {
                Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", e2);
                aVar.dP("fail:snapshot error");
                AppMethodBeat.o(139519);
            }
        }
    }
}
