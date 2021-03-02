package com.tencent.mm.plugin.appbrand.u.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.b.b;
import com.tencent.mm.plugin.appbrand.u.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private d nkf;

    /* renamed from: com.tencent.mm.plugin.appbrand.u.b.a$a  reason: collision with other inner class name */
    public static class C0801a implements b.a {
        protected C0801a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.u.b.b.a
        public void a(AppBrandRuntime appBrandRuntime, JSONObject jSONObject) {
            AppMethodBeat.i(229941);
            try {
                jSONObject.put("switchFs", 1);
                AppMethodBeat.o(229941);
            } catch (JSONException e2) {
                AppMethodBeat.o(229941);
            }
        }
    }

    public final void a(s sVar, i iVar) {
        AppMethodBeat.i(147386);
        Log.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
        this.nkf = new d(sVar, iVar);
        iVar.addJavascriptInterface(this.nkf, "gJavaBroker");
        AppMethodBeat.o(147386);
    }

    public final void bPW() {
        AppMethodBeat.i(147387);
        Log.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
        if (this.nkf == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
            AppMethodBeat.o(147387);
            throw illegalStateException;
        }
        this.nkf.bPS();
        AppMethodBeat.o(147387);
    }

    public final String bPX() {
        AppMethodBeat.i(147388);
        if (this.nkf == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
            AppMethodBeat.o(147388);
            throw illegalStateException;
        }
        StringBuffer stringBuffer = new StringBuffer();
        a(stringBuffer);
        stringBuffer.append(bPR());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(147388);
        return stringBuffer2;
    }

    /* access modifiers changed from: protected */
    public void a(StringBuffer stringBuffer) {
        AppMethodBeat.i(229942);
        stringBuffer.append(";const _switchTimer = true;");
        AppMethodBeat.o(229942);
    }

    /* access modifiers changed from: protected */
    public String bPR() {
        AppMethodBeat.i(147389);
        String afA = com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/node_jsapi.js");
        AppMethodBeat.o(147389);
        return afA;
    }

    static {
        AppMethodBeat.i(229943);
        b.a(new C0801a());
        AppMethodBeat.o(229943);
    }
}
