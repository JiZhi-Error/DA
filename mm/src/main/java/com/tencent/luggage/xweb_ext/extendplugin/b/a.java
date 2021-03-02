package com.tencent.luggage.xweb_ext.extendplugin.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements c {
    private c cJZ;
    private Map<String, b> cKa = new ConcurrentHashMap();
    private com.tencent.luggage.xweb_ext.extendplugin.c cKb;

    public a() {
        AppMethodBeat.i(139354);
        AppMethodBeat.o(139354);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final com.tencent.luggage.xweb_ext.extendplugin.c QK() {
        return this.cKb;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.c cVar) {
        this.cKb = cVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final void a(c cVar) {
        this.cJZ = cVar;
    }

    private String getLogTag() {
        AppMethodBeat.i(139355);
        String format = String.format(Locale.US, "%s(%s)", "MicroMsg.SameLayer.DefaultExtendPluginClientProxy", Integer.valueOf(hashCode()));
        AppMethodBeat.o(139355);
        return format;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final String a(String str, int i2, com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(139356);
        String o = d.o(str, i2);
        Log.i(getLogTag(), "handleJsApi, key:%s, jsapi:%s", o, aVar.Pt());
        b f2 = f(str, i2, o);
        if (f2 == null) {
            Log.w(getLogTag(), "handleJsApi, key:%s, handler is null", o);
            AppMethodBeat.o(139356);
            return "";
        } else if (f2.g(aVar)) {
            if (aVar.Pr()) {
                String h2 = f2.h(aVar);
                AppMethodBeat.o(139356);
                return h2;
            }
            f2.h(aVar);
            AppMethodBeat.o(139356);
            return "";
        } else if (aVar.Pr()) {
            String dP = aVar.dP("ok");
            AppMethodBeat.o(139356);
            return dP;
        } else {
            AppMethodBeat.o(139356);
            return "";
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final void onPluginReady(String str, int i2, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(139357);
        String o = d.o(str, i2);
        Log.i(getLogTag(), "onPluginReady, key:%s", o);
        b f2 = f(str, i2, o);
        if (f2 == null) {
            Log.w(getLogTag(), "onPluginReady, key:%s, handler is null", o);
            AppMethodBeat.o(139357);
            return;
        }
        Log.i(getLogTag(), "onPluginReady, key:%s, handler is ready", o);
        f2.e(surfaceTexture);
        AppMethodBeat.o(139357);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final void onPluginDestroy(String str, int i2) {
        AppMethodBeat.i(139358);
        String o = d.o(str, i2);
        Log.i(getLogTag(), "onPluginDestroy, key:%s", o);
        b f2 = f(str, i2, o);
        if (f2 == null) {
            Log.w(getLogTag(), "onPluginDestroy, key:%s, handler is null", o);
            AppMethodBeat.o(139358);
            return;
        }
        f2.PQ();
        AppMethodBeat.o(139358);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final void onPluginTouch(String str, int i2, MotionEvent motionEvent) {
        AppMethodBeat.i(139359);
        String o = d.o(str, i2);
        Log.v(getLogTag(), "onPluginTouch, key:%s", o);
        b f2 = f(str, i2, o);
        if (f2 == null) {
            Log.w(getLogTag(), "onPluginTouch, key:%s, handler is null", o);
            AppMethodBeat.o(139359);
            return;
        }
        f2.o(motionEvent);
        AppMethodBeat.o(139359);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final void onPluginScreenshotTaken(String str, int i2, Bitmap bitmap) {
        AppMethodBeat.i(178851);
        String o = d.o(str, i2);
        Log.v(getLogTag(), "onPluginScreenshotTaken, key:%s", o);
        b f2 = f(str, i2, o);
        if (f2 == null) {
            Log.w(getLogTag(), "onPluginScreenshotTaken, key:%s, handler is null", o);
            AppMethodBeat.o(178851);
            return;
        }
        f2.s(bitmap);
        AppMethodBeat.o(178851);
    }

    private synchronized b f(String str, int i2, String str2) {
        b bVar;
        AppMethodBeat.i(139360);
        bVar = this.cKa.get(str2);
        if (bVar == null) {
            Log.e(getLogTag(), "getPluginHandler, key:%s, current no handler for this key", str2);
            if (this.cJZ != null) {
                bVar = this.cJZ.dW(str);
                if (bVar != null) {
                    Log.w(getLogTag(), "getPluginHandler, key:%s, created new plugin handler(%s)", str2, Integer.valueOf(bVar.hashCode()));
                    bVar.setId(i2);
                    bVar.setType(str);
                    bVar.a(this);
                    this.cKa.put(str2, bVar);
                } else {
                    Log.e(getLogTag(), "getPluginHandler, key:%s, no handler for this key?", str2);
                }
            }
        }
        AppMethodBeat.o(139360);
        return bVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.c
    public final synchronized void p(String str, int i2) {
        AppMethodBeat.i(215748);
        String o = d.o(str, i2);
        Log.i(getLogTag(), "removePlugin, key:%s", o);
        this.cKa.remove(o);
        AppMethodBeat.o(215748);
    }
}
