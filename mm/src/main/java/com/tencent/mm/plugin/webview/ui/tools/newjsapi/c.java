package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c extends a {
    public static final c JwY = new c();

    static {
        AppMethodBeat.i(210582);
        AppMethodBeat.o(210582);
    }

    private c() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        boolean z;
        AppMethodBeat.i(210581);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Object obj = nVar.params.get("url");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            Log.i("MicroMsg.JsApiAppJoinGroup.", "url is null");
            fVar.IQZ.h(nVar.ISe, "joinGroup:fail", null);
            AppMethodBeat.o(210581);
        } else {
            String aXZ = fVar.IQZ.aXZ(str);
            String str3 = aXZ;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.JsApiAppJoinGroup.", "appId is null");
                fVar.IQZ.h(nVar.ISe, "joinGroup:fail", null);
                AppMethodBeat.o(210581);
            } else {
                Object obj2 = nVar.params.get("signature");
                if (!(obj2 instanceof String)) {
                    obj2 = null;
                }
                String str4 = (String) obj2;
                Object obj3 = nVar.params.get("groupId");
                if (!(obj3 instanceof String)) {
                    obj3 = null;
                }
                String str5 = (String) obj3;
                Object obj4 = nVar.params.get("nonceStr");
                if (!(obj4 instanceof String)) {
                    obj4 = null;
                }
                c.b bVar = new c.b();
                bVar.appId = aXZ;
                bVar.signature = str4;
                bVar.zpX = str5;
                bVar.zpY = (String) obj4;
                ((com.tencent.mm.plugin.messenger.foundation.a.c) g.af(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(fVar.context, bVar);
                fVar.IQZ.h(nVar.ISe, "joinGroup:success", null);
                AppMethodBeat.o(210581);
            }
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return 377;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return as.NAME;
    }
}
