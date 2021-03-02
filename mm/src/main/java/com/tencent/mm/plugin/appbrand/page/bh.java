package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashSet;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "Factory", "luggage-wechat-full-sdk_release"})
public interface bh {
    public static final a ntk = a.ntl;

    void ay(String str, boolean z);

    void bSc();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory;", "", "()V", "createInjector", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "IMPL", "luggage-wechat-full-sdk_release"})
    public static final class a {
        static final /* synthetic */ a ntl = new a();

        static {
            AppMethodBeat.i(183070);
            AppMethodBeat.o(183070);
        }

        private a() {
        }

        public static bh d(a<?> aVar) {
            WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap;
            AppMethodBeat.i(183069);
            p.h(aVar, "renderer");
            c cVar = (c) aVar.NN();
            if (cVar == null) {
                p.hyc();
            }
            WxaPkgWrappingInfo wxaPkgWrappingInfo = ((AppBrandSysConfigLU) cVar.av(AppBrandSysConfigLU.class)).leE;
            if (((wxaPkgWrappingInfo == null || (wxaRuntimeModulePluginListMap = wxaPkgWrappingInfo.kOb) == null) ? 0 : wxaRuntimeModulePluginListMap.kOk.size()) > 0) {
                WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap2 = wxaPkgWrappingInfo.kOb;
                if (wxaRuntimeModulePluginListMap2 == null) {
                    p.hyc();
                }
                p.g(wxaRuntimeModulePluginListMap2, "wrappingInfo.separatedPlugins!!");
                C0773a aVar2 = new C0773a(aVar, wxaRuntimeModulePluginListMap2);
                AppMethodBeat.o(183069);
                return aVar2;
            }
            b bVar = new b();
            AppMethodBeat.o(183069);
            return bVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$createInjector$1", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "luggage-wechat-full-sdk_release"})
        public static final class b implements bh {
            b() {
            }

            @Override // com.tencent.mm.plugin.appbrand.page.bh
            public final void ay(String str, boolean z) {
                AppMethodBeat.i(183068);
                p.h(str, "moduleName");
                AppMethodBeat.o(183068);
            }

            @Override // com.tencent.mm.plugin.appbrand.page.bh
            public final void bSc() {
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0019\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$IMPL;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "separatedPluginsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;)V", "TAG", "", "injectedScriptNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pkgReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "getPkgReader", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "pkgReader$delegate", "Lkotlin/Lazy;", "injectPlugins", "", "moduleName", "useLazyCodeLoading", "", "onReloadURL", "evaluateScriptFile", DownloadInfo.FILENAME, "luggage-wechat-full-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.page.bh$a$a  reason: collision with other inner class name */
        public static final class C0773a implements bh {
            private final String TAG = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
            private final f ntm = g.ah(new C0774a(this));
            private final HashSet<String> ntn = new HashSet<>();
            private final a<?> nto;
            private final WxaRuntimeModulePluginListMap ntp;

            public C0773a(a<?> aVar, WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap) {
                p.h(aVar, "renderer");
                p.h(wxaRuntimeModulePluginListMap, "separatedPluginsMap");
                AppMethodBeat.i(183067);
                this.nto = aVar;
                this.ntp = wxaRuntimeModulePluginListMap;
                AppMethodBeat.o(183067);
            }

            private final void a(a<?> aVar, String str) {
                AppMethodBeat.i(183064);
                if (this.ntn.contains(str)) {
                    AppMethodBeat.o(183064);
                    return;
                }
                Log.i(this.TAG, "inner evaluateScriptFile fileName(" + str + ") hash(" + hashCode() + ')');
                aVar.eD(str, aVar.bQt().adT(str));
                this.ntn.add(str);
                AppMethodBeat.o(183064);
            }

            @Override // com.tencent.mm.plugin.appbrand.page.bh
            public final void ay(String str, boolean z) {
                AppMethodBeat.i(183065);
                p.h(str, "moduleName");
                Log.i(this.TAG, "injectPlugins moduleName(" + str + ") useLazyCodeLoading(" + z + ") hash(" + hashCode() + ')');
                List<WxaPluginPkgInfo> Vz = this.ntp.Vz(str);
                if (Vz == null) {
                    String Wf = LaunchParcel.Wf(str);
                    if (p.j(Wf, str)) {
                        Vz = null;
                    } else {
                        WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = this.ntp;
                        p.g(Wf, "fixedName");
                        Vz = wxaRuntimeModulePluginListMap.Vz(Wf);
                    }
                }
                if (Vz == null || Vz.isEmpty()) {
                    Log.i(this.TAG, "injectPlugins, try with module(" + str + "), get empty pluginList");
                    AppMethodBeat.o(183065);
                    return;
                }
                for (WxaPluginPkgInfo wxaPluginPkgInfo : Vz) {
                    bn.a aVar = bn.kOt;
                    String a2 = bn.a.a(str, wxaPluginPkgInfo);
                    if (!z || !((q) this.ntm.getValue()).UW(a2 + "/common.app.js")) {
                        a(this.nto, a2 + "/pageframe.js");
                    } else {
                        a(this.nto, a2 + "/common.app.js");
                        a(this.nto, a2 + "/webview.app.js");
                    }
                }
                AppMethodBeat.o(183065);
            }

            @Override // com.tencent.mm.plugin.appbrand.page.bh
            public final void bSc() {
                AppMethodBeat.i(183066);
                this.ntn.clear();
                AppMethodBeat.o(183066);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "invoke"})
            /* renamed from: com.tencent.mm.plugin.appbrand.page.bh$a$a$a  reason: collision with other inner class name */
            static final class C0774a extends kotlin.g.b.q implements kotlin.g.a.a<q> {
                final /* synthetic */ C0773a ntq;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0774a(C0773a aVar) {
                    super(0);
                    this.ntq = aVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ q invoke() {
                    AppMethodBeat.i(183062);
                    c cVar = (c) this.ntq.nto.NN();
                    if (cVar == null) {
                        p.hyc();
                    }
                    r M = bg.M(cVar.NP());
                    if (M == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IWxaPkgRuntimeReader");
                        AppMethodBeat.o(183062);
                        throw tVar;
                    }
                    r rVar = M;
                    AppMethodBeat.o(183062);
                    return rVar;
                }
            }
        }
    }
}
