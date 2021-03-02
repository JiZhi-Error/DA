package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b extends com.tencent.mm.plugin.webview.d.c.a {
    public static final b JwW = new b();

    static {
        AppMethodBeat.i(210580);
        AppMethodBeat.o(210580);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        boolean z;
        String str = null;
        AppMethodBeat.i(210579);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Object obj = nVar.params.get("url");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str2 = (String) obj;
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            Log.i("MicroMsg.JsApiAppBindGroup.", "url is null");
            fVar.IQZ.h(nVar.ISe, "bindGroup:fail", null);
            AppMethodBeat.o(210579);
        } else {
            String aXZ = fVar.IQZ.aXZ(str2);
            String str4 = aXZ;
            if (str4 == null || str4.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.JsApiAppBindGroup.", "appId is null");
                fVar.IQZ.h(nVar.ISe, "bindGroup:fail", null);
                AppMethodBeat.o(210579);
            } else {
                Object obj2 = nVar.params.get("signature");
                if (!(obj2 instanceof String)) {
                    obj2 = null;
                }
                String str5 = (String) obj2;
                Object obj3 = nVar.params.get("groupId");
                if (!(obj3 instanceof String)) {
                    obj3 = null;
                }
                String str6 = (String) obj3;
                Object obj4 = nVar.params.get("nonceStr");
                if (obj4 instanceof String) {
                    str = obj4;
                }
                c.b bVar = new c.b();
                bVar.appId = aXZ;
                bVar.signature = str5;
                bVar.zpX = str6;
                bVar.zpY = str;
                ((c) g.af(c.class)).a(fVar.context, bVar, new a(str6, fVar, nVar));
                AppMethodBeat.o(210579);
            }
        }
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "success", "", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "groupOpenId", "onDealEnd"})
    static final class a implements c.a {
        final /* synthetic */ f CDE;
        final /* synthetic */ String JwX;
        final /* synthetic */ n pGr;

        a(String str, f fVar, n nVar) {
            this.JwX = str;
            this.CDE = fVar;
            this.pGr = nVar;
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.c.a
        public final void a(boolean z, String str, String str2) {
            AppMethodBeat.i(210578);
            if (z) {
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    Log.i("MicroMsg.JsApiAppBindGroup.", "success:" + this.JwX);
                    HashMap hashMap = new HashMap();
                    hashMap.put("openId", str2);
                    h hVar = this.CDE.IQZ;
                    String str4 = this.pGr.ISe;
                    StringBuilder sb = new StringBuilder();
                    b bVar = b.JwW;
                    hVar.h(str4, sb.append("bindGroup:success").toString(), hashMap);
                    AppMethodBeat.o(210578);
                    return;
                }
            }
            Log.i("MicroMsg.JsApiAppBindGroup.", "fail:".concat(String.valueOf(str)));
            h hVar2 = this.CDE.IQZ;
            String str5 = this.pGr.ISe;
            StringBuilder sb2 = new StringBuilder();
            b bVar2 = b.JwW;
            hVar2.h(str5, sb2.append("bindGroup:fail").toString(), null);
            AppMethodBeat.o(210578);
        }
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return 376;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return ar.NAME;
    }
}
