package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.m;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.protocal.protobuf.evi;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class j<SERVICE extends d> extends f<SERVICE> implements com.tencent.mm.plugin.appbrand.debugger.j {
    public static final b.a cBs = new a((byte) 0);
    private m cBt;
    private o cvW;

    static final class a implements b.a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(146863);
        AppMethodBeat.o(146863);
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.j
    public final void ds(String str) {
        AppMethodBeat.i(146854);
        Log.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", str);
        evi evi = new evi();
        evi.Ntn = ((d) NN()).Oq().getComponentId();
        evi.Ntm = str;
        this.cvW.a(v.a(evi, this.cBt, "domEvent"));
        AppMethodBeat.o(146854);
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.j
    public final String Mh() {
        AppMethodBeat.i(146855);
        JSONObject Or = ((d) NN()).Or();
        String format = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", Or.toString(), ((d) NN()).NP().getAppConfig().lcc);
        AppMethodBeat.o(146855);
        return format;
    }

    public j(SERVICE service) {
        super(service);
        AppMethodBeat.i(146856);
        super.b(com.tencent.mm.plugin.appbrand.debugger.j.class, this);
        AppMethodBeat.o(146856);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final i Mk() {
        AppMethodBeat.i(146857);
        this.cvW = new o();
        o oVar = this.cvW;
        AppMethodBeat.o(146857);
        return oVar;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean Mj() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void c(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(146858);
        super.c(appBrandRuntime);
        ((d) NN()).bEb();
        if (v.liX != null) {
            this.cBt = v.liX;
            v.liX = null;
        } else {
            this.cBt = new m();
        }
        this.cBt.a((d) NN(), ((d) NN()).NP().ON().extInfo);
        this.cvW.a(this.cBt);
        AppMethodBeat.o(146858);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void Mw() {
        AppMethodBeat.i(146859);
        super.Mw();
        this.cvW.lix.bringToFront();
        AppMethodBeat.o(146859);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void MC() {
        AppMethodBeat.i(146860);
        Om();
        AppMethodBeat.o(146860);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.f
    public final boolean dt(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void MD() {
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean j(int i2, String str) {
        AppMethodBeat.i(146861);
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.cvW.ad(i2, str);
        AppMethodBeat.o(146861);
        return true;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean d(String str, String str2, int i2) {
        AppMethodBeat.i(146862);
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        Log.d("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(i2));
        this.cvW.lit = str;
        o oVar = this.cvW;
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        Object[] objArr = new Object[6];
        objArr[0] = "WeixinJSBridge";
        objArr[1] = "WeixinJSBridge";
        objArr[2] = str;
        objArr[3] = str2;
        objArr[4] = i2 == 0 ? "undefined" : String.valueOf(i2);
        objArr[5] = cx.ayR();
        oVar.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", objArr), null);
        AppMethodBeat.o(146862);
        return true;
    }
}
