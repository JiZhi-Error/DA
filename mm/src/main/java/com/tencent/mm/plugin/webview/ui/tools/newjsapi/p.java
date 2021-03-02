package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.b.c;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "WebPrefetchTask", "plugin-webview_release"})
public final class p extends com.tencent.mm.plugin.webview.d.c.a {
    public static final p JxA = new p();

    static {
        AppMethodBeat.i(210631);
        AppMethodBeat.o(210631);
    }

    private p() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return c.CTRL_INDEX;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return "onWebPageUrlExposed";
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(210630);
        kotlin.g.b.p.h(fVar, "env");
        kotlin.g.b.p.h(nVar, "msg");
        String str = (String) nVar.params.get("urlList");
        if (Util.isNullOrNil(str)) {
            h.hkS();
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            AppMethodBeat.o(210630);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("urlList", str);
            if (((Bundle) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, a.class)).getBoolean("ret")) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            } else {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            }
            AppMethodBeat.o(210630);
        }
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed$WebPrefetchTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-webview_release"})
    public static final class a implements k<Bundle, Bundle> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(210629);
            Bundle J = J(bundle);
            AppMethodBeat.o(210629);
            return J;
        }

        private static Bundle J(Bundle bundle) {
            AppMethodBeat.i(210628);
            Bundle bundle2 = new Bundle();
            if (bundle == null) {
                bundle2.putBoolean("ret", false);
                AppMethodBeat.o(210628);
                return bundle2;
            }
            ArrayList arrayList = new ArrayList();
            try {
                com.tencent.mm.ab.f fVar = new com.tencent.mm.ab.f(bundle.getString("urlList"));
                if (fVar.length() <= 0) {
                    h.hkS();
                    bundle2.putBoolean("ret", false);
                    AppMethodBeat.o(210628);
                    return bundle2;
                }
                int length = fVar.length();
                for (int i2 = 0; i2 < length; i2++) {
                    i pZ = fVar.pZ(i2);
                    String optString = pZ.optString("url");
                    int optInt = pZ.optInt("bizScene");
                    if (optString == null || !kotlin.n.n.aL(optString)) {
                        String optString2 = pZ.optString(IssueStorage.COLUMN_EXT_INFO);
                        e.a aVar = new e.a();
                        aVar.url = optString;
                        aVar.extInfo = optString2;
                        aVar.pmM = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
                        aVar.pmN = optInt;
                        arrayList.add(aVar);
                    } else {
                        h.hkS();
                    }
                }
                if (arrayList.isEmpty()) {
                    h.hkS();
                    bundle2.putBoolean("ret", false);
                    AppMethodBeat.o(210628);
                    return bundle2;
                }
                bundle2.putBoolean("ret", true);
                ((e) g.af(e.class)).cu(arrayList);
                AppMethodBeat.o(210628);
                return bundle2;
            } catch (Exception e2) {
                h.hkS();
            }
        }
    }
}
