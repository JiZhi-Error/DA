package com.tencent.mm.aa.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.aa.b.c;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class e {
    public String gIx;
    private volatile boolean gc;
    public c hpp;
    public f hpq;
    public d hpr;
    private volatile boolean hps;
    public a hpt;

    public interface a {
        void S(String str, int i2);
    }

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        int i2 = 0;
        AppMethodBeat.i(144809);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i2 = str2.length();
        }
        objArr[1] = Integer.valueOf(i2);
        Log.d("MicroMsg.MiniJsBridge", "publishHandler, event: %s, data size: %d", objArr);
        AppMethodBeat.o(144809);
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i2) {
        AppMethodBeat.i(144810);
        if (!this.gc) {
            String as = this.hpp.hpk.as(str, "fail:JsApi core not started");
            AppMethodBeat.o(144810);
            return as;
        }
        String h2 = this.hpp.h(str, str2, i2);
        AppMethodBeat.o(144810);
        return h2;
    }

    public final boolean at(String str, String str2) {
        AppMethodBeat.i(144811);
        f fVar = this.hpq;
        com.tencent.mm.aa.b.e Fy = fVar.hpu.Fy(str);
        if (Fy == null) {
            Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", str);
            AppMethodBeat.o(144811);
            return false;
        } else if (!fVar.hpi.pP(Fy.getIndex())) {
            Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", str);
            AppMethodBeat.o(144811);
            return false;
        } else {
            if (Util.isNullOrNil(str2)) {
                str2 = "{}";
            }
            Log.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), 0);
            fVar.hpr.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", str, str2, "undefined", f.ayR()), null);
            AppMethodBeat.o(144811);
            return true;
        }
    }

    public final boolean a(c cVar, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(144812);
        f fVar = this.hpq;
        if (cVar == null) {
            Log.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
            AppMethodBeat.o(144812);
            return false;
        }
        com.tencent.mm.aa.b.e Fy = fVar.hpu.Fy(cVar.name);
        if (Fy == null) {
            Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", cVar);
            AppMethodBeat.o(144812);
            return false;
        } else if (!fVar.hpi.pP(Fy.getIndex())) {
            Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", cVar);
            AppMethodBeat.o(144812);
            return false;
        } else {
            String jSONObject = cVar.toJSONObject().toString();
            Log.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", cVar.name, Integer.valueOf(jSONObject.length()), 0);
            fVar.hpr.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", cVar.name, jSONObject, "undefined", f.ayR()), valueCallback);
            AppMethodBeat.o(144812);
            return true;
        }
    }

    public final void onStop() {
        AppMethodBeat.i(144813);
        Log.v("MicroMsg.MiniJsBridge", "onStop(%s)", this.gIx);
        this.gc = false;
        this.hpr.destroy();
        c cVar = this.hpp;
        cVar.hpk.quit();
        cVar.hph.hpn.recycle();
        if (this.hpt != null) {
            this.hpt.S(this.gIx, 4);
            this.hpt = null;
        }
        AppMethodBeat.o(144813);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(144814);
        if (this.hps) {
            AppMethodBeat.o(144814);
            return;
        }
        Log.v("MicroMsg.MiniJsBridge", "onPause(%s)", this.gIx);
        this.hps = true;
        if (this.hpr.ayP()) {
            this.hpr.pause();
        } else {
            a(cVar, null);
        }
        if (this.hpt != null) {
            this.hpt.S(this.gIx, 3);
        }
        AppMethodBeat.o(144814);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(144815);
        if (!this.hps) {
            AppMethodBeat.o(144815);
            return;
        }
        Log.v("MicroMsg.MiniJsBridge", "onResume(%s)", this.gIx);
        if (this.hpr.ayP()) {
            this.hpr.resume();
        } else {
            a(cVar, null);
        }
        this.hps = false;
        if (this.hpt != null) {
            this.hpt.S(this.gIx, 2);
        }
        AppMethodBeat.o(144815);
    }

    public final void onStart() {
        AppMethodBeat.i(144816);
        if (this.gc) {
            AppMethodBeat.o(144816);
            return;
        }
        Log.v("MicroMsg.MiniJsBridge", "onStart(%s)", this.gIx);
        this.gc = true;
        if (this.hpt != null) {
            this.hpt.S(this.gIx, 1);
        }
        Iterator<b> it = this.hpp.hpj.hpo.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(144816);
    }

    public final ad.b ayQ() {
        return this.hpp.hph.hpn;
    }

    public final void a(d dVar) {
        AppMethodBeat.i(144817);
        if (this.hpr != null) {
            Log.e("MicroMsg.MiniJsBridge", "can not initialize again.");
            AppMethodBeat.o(144817);
            return;
        }
        this.hpr = dVar;
        AppMethodBeat.o(144817);
    }
}
