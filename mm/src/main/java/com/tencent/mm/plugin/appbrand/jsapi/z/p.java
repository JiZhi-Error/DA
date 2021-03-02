package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class p extends d {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setKeepScreenOn";
    private static boolean mub = false;
    private f lAx;
    private h.c lLT;
    PowerManager.WakeLock wakeLock;

    static /* synthetic */ boolean a(p pVar) {
        AppMethodBeat.i(137681);
        boolean isHeld = pVar.isHeld();
        AppMethodBeat.o(137681);
        return isHeld;
    }

    static /* synthetic */ boolean b(p pVar) {
        AppMethodBeat.i(137682);
        boolean release = pVar.release();
        AppMethodBeat.o(137682);
        return release;
    }

    static /* synthetic */ boolean c(p pVar) {
        AppMethodBeat.i(137683);
        boolean bIU = pVar.bIU();
        AppMethodBeat.o(137683);
        return bIU;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        boolean release;
        AppMethodBeat.i(137677);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(137677);
        } else if (fVar.getContext() == null) {
            Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
            fVar.i(i2, h("fail:context is null", null));
            AppMethodBeat.o(137677);
        } else if (!(fVar.getContext() instanceof Activity)) {
            Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
            fVar.i(i2, h("fail:context is null", null));
            AppMethodBeat.o(137677);
        } else {
            boolean optBoolean = jSONObject.optBoolean("keepScreenOn", false);
            mub = optBoolean;
            Log.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", Boolean.valueOf(optBoolean), fVar.getAppId());
            synchronized (this) {
                try {
                    this.lAx = fVar;
                } catch (Throwable th) {
                    AppMethodBeat.o(137677);
                    throw th;
                }
            }
            if (optBoolean) {
                if (this.lLT == null) {
                    this.lLT = new h.c() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.z.p.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.h.c
                        public final void onDestroy() {
                            AppMethodBeat.i(137674);
                            Log.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
                            if (p.a(p.this)) {
                                p.b(p.this);
                            }
                            h.b(fVar.getAppId(), this);
                            AppMethodBeat.o(137674);
                        }

                        @Override // com.tencent.mm.plugin.appbrand.h.c
                        public final void a(h.d dVar) {
                            AppMethodBeat.i(137675);
                            Log.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
                            if (p.a(p.this)) {
                                p.b(p.this);
                            }
                            AppMethodBeat.o(137675);
                        }

                        @Override // com.tencent.mm.plugin.appbrand.h.c
                        public final void onResume() {
                            AppMethodBeat.i(137676);
                            Log.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
                            if (p.mub) {
                                p.c(p.this);
                            }
                            AppMethodBeat.o(137676);
                        }
                    };
                }
                h.a(fVar.getAppId(), this.lLT);
                release = bIU();
            } else if (isHeld()) {
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
                release = release();
            } else {
                Log.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
                fVar.i(i2, h("fail:has not set screen", null));
                AppMethodBeat.o(137677);
                return;
            }
            if (release) {
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
                fVar.i(i2, h("ok", null));
                AppMethodBeat.o(137677);
                return;
            }
            Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(137677);
        }
    }

    private synchronized boolean bIU() {
        boolean z;
        AppMethodBeat.i(137678);
        if (this.lAx.getContext() == null) {
            Log.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
            z = false;
            AppMethodBeat.o(137678);
        } else {
            Log.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
            Activity activity = (Activity) this.lAx.getContext();
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
            }
            if (!this.wakeLock.isHeld()) {
                this.wakeLock.acquire();
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
            } else {
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
            }
            z = true;
            AppMethodBeat.o(137678);
        }
        return z;
    }

    private synchronized boolean release() {
        boolean z;
        AppMethodBeat.i(137679);
        Log.e("MicroMsg.JsApiSetKeepScreenOn", "release");
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            Log.e("MicroMsg.JsApiSetKeepScreenOn", "wakeLock is  null");
            z = false;
            AppMethodBeat.o(137679);
        } else {
            this.wakeLock.release();
            this.wakeLock = null;
            z = true;
            AppMethodBeat.o(137679);
        }
        return z;
    }

    private synchronized boolean isHeld() {
        boolean z;
        AppMethodBeat.i(137680);
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            z = false;
            AppMethodBeat.o(137680);
        } else {
            z = true;
            AppMethodBeat.o(137680);
        }
        return z;
    }
}
