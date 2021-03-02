package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b {
    private static e JLt;
    private static final String URL = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1h) + "/jsserver.js?wechat_pkgid=jscore_lib");

    public interface a {
        void azT(String str);
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(200137);
        b(aVar);
        AppMethodBeat.o(200137);
    }

    static {
        AppMethodBeat.i(200138);
        AppMethodBeat.o(200138);
    }

    public static void vC() {
        AppMethodBeat.i(200131);
        Log.i("MicroMsg.GameJsServerCommLibPkg", "load");
        AppMethodBeat.o(200131);
    }

    private static String getCode() {
        AppMethodBeat.i(200133);
        e eVar = new e();
        JLt = eVar;
        eVar.m(URL, true, false);
        e eVar2 = JLt;
        if (eVar2.JLD == null || eVar2.JLD.JNr == null) {
            AppMethodBeat.o(200133);
            return null;
        }
        String gkR = eVar2.JLD.JNr.gkR();
        AppMethodBeat.o(200133);
        return gkR;
    }

    public static void destroy() {
        AppMethodBeat.i(200134);
        JLt.zE(false);
        AppMethodBeat.o(200134);
    }

    public static String gkn() {
        AppMethodBeat.i(200135);
        if (JLt == null) {
            AppMethodBeat.o(200135);
            return null;
        }
        String gkx = JLt.gkx();
        AppMethodBeat.o(200135);
        return gkx;
    }

    private static void b(a aVar) {
        AppMethodBeat.i(200136);
        if (aVar != null) {
            aVar.azT(getCode());
        }
        AppMethodBeat.o(200136);
    }

    public static void a(final a aVar) {
        AppMethodBeat.i(200132);
        if (!AppBrandMainProcessService.isLive()) {
            d.b("", new com.tencent.mm.plugin.wepkg.model.a() {
                /* class com.tencent.mm.plugin.wepkg.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wepkg.model.a
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    AppMethodBeat.i(200130);
                    b.c(aVar);
                    AppMethodBeat.o(200130);
                }
            });
            AppMethodBeat.o(200132);
            return;
        }
        b(aVar);
        AppMethodBeat.o(200132);
    }
}
