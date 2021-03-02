package com.tencent.mm.plugin.appbrand.appcache;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "Lcom/tencent/mm/kernel/service/IService;", "checkIsPageIndexExisted", "", "appId", "", "appVersion", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "Factory", "plugin-appbrand-integration_release"})
public interface bp extends com.tencent.mm.kernel.c.a {
    void UZ(String str);

    boolean aQ(String str, int i2);

    void bvD();

    boolean o(String str, int i2, String str2);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage$Factory;", "", "()V", "TAG", "", "install", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "updatePageIndexWithPkgInfo", "appId", "wxaPkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "plugin-appbrand-integration_release"})
    public static final class a {
        public static final a kOA = new a();

        static {
            AppMethodBeat.i(227993);
            AppMethodBeat.o(227993);
        }

        private a() {
        }

        public static final void d(g gVar) {
            AppMethodBeat.i(227991);
            p.h(gVar, Scopes.PROFILE);
            if (gVar.aBb()) {
                com.tencent.mm.kernel.g.a(bp.class, new e(t.kKS));
            }
            AppMethodBeat.o(227991);
        }

        public static final void a(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            AppMethodBeat.i(227992);
            p.h(str, "appId");
            p.h(wxaPkgWrappingInfo, "wxaPkgWrappingInfo");
            Iterator it = wxaPkgWrappingInfo.iterator();
            while (it.hasNext()) {
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (modulePkgInfo.independent && s.YS(modulePkgInfo.pkgPath)) {
                    try {
                        String ct = WxaPkg.ct(modulePkgInfo.pkgPath, (p.j(ModulePkgInfo.MAIN_MODULE_NAME, modulePkgInfo.name) ? "" : e.UQ(modulePkgInfo.name)) + "/app-config.json");
                        String str2 = ct;
                        if (!(str2 == null || str2.length() == 0)) {
                            String hVar = com.eclipsesource.a.a.aR(ct).si().aU("pages").toString();
                            p.g(hVar, "Json.parse(configJson).a…).get(\"pages\").toString()");
                            t tVar = t.kKS;
                            t.p(str, wxaPkgWrappingInfo.pkgVersion(), hVar);
                            AppMethodBeat.o(227992);
                            return;
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WxaVersionPagePathIndexStorage", "updatePageIndexWithPkgInfo(appId:" + str + ") get exception:" + e2);
                    }
                    AppMethodBeat.o(227992);
                    return;
                }
            }
            AppMethodBeat.o(227992);
        }
    }
}
