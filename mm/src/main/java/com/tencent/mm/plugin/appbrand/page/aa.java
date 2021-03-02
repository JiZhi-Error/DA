package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "libFileProvider", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "wxaPkgFileProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;)V", "useLazyCodeLoadingMode", "", "getUseLazyCodeLoadingMode", "()Z", "useLazyCodeLoadingMode$delegate", "Lkotlin/Lazy;", "Constants", "luggage-wechat-full-sdk_release"})
public final class aa implements m {
    public static final a nqC = new a((byte) 0);
    private final ICommLibReader nqA;
    private final q nqB;
    private final f nqz = g.ah(new b(this));

    static {
        AppMethodBeat.i(147962);
        AppMethodBeat.o(147962);
    }

    public final boolean bRa() {
        AppMethodBeat.i(147963);
        boolean booleanValue = ((Boolean) this.nqz.getValue()).booleanValue();
        AppMethodBeat.o(147963);
        return booleanValue;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig$Constants;", "", "()V", "COMMON_JS_NAME", "", "TAG", "WEBVIEW_APP_JS_NAME", "supportLazyCodeLoading", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean d(ICommLibReader iCommLibReader) {
            AppMethodBeat.i(230119);
            p.h(iCommLibReader, "$this$supportLazyCodeLoading");
            String[] strArr = {"lazyCodeLoading", "lazyCodeLoading2"};
            for (int i2 = 0; i2 < 2; i2++) {
                String UN = iCommLibReader.UN(strArr[i2]);
                if (!(UN == null || UN.length() == 0)) {
                    AppMethodBeat.o(230119);
                    return true;
                }
            }
            AppMethodBeat.o(230119);
            return false;
        }
    }

    public aa(ICommLibReader iCommLibReader, q qVar) {
        p.h(iCommLibReader, "libFileProvider");
        p.h(qVar, "wxaPkgFileProvider");
        AppMethodBeat.i(183061);
        this.nqA = iCommLibReader;
        this.nqB = qVar;
        AppMethodBeat.o(183061);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ aa nqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(aa aaVar) {
            super(0);
            this.nqD = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(147961);
            a aVar = aa.nqC;
            if (a.d(this.nqD.nqA)) {
                if (!this.nqD.nqB.UW("common.app.js")) {
                    Iterator<ModulePkgInfo> it = this.nqD.nqB.bvz().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Log.i("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return false");
                            z = false;
                            break;
                        }
                        ModulePkgInfo next = it.next();
                        if (next.independent) {
                            StringBuilder append = new StringBuilder().append(next.name);
                            String str = next.name;
                            p.g(str, "m.name");
                            String sb = append.append(n.nm(str, FilePathGenerator.ANDROID_DIR_SEP) ? "" : FilePathGenerator.ANDROID_DIR_SEP).append("common.app.js").toString();
                            if (this.nqD.nqB.UW(sb)) {
                                Log.i("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return true, by independent ".concat(String.valueOf(sb)));
                                z = true;
                                break;
                            }
                        }
                    }
                } else {
                    Log.i("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return true, by common.app.js");
                    z = true;
                }
            } else {
                Log.i("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return false, lib.version=[" + this.nqD.nqA.bvc() + ']');
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(147961);
            return valueOf;
        }
    }
}
