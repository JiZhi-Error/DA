package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", q.NAME, "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
public final class ab {
    private static boolean nqE = true;
    public static final ab nqF = new ab();

    static {
        AppMethodBeat.i(147973);
        AppMethodBeat.o(147973);
    }

    private ab() {
    }

    public static final void ih(boolean z) {
        nqE = z;
    }

    public static final void k(ac acVar) {
        AppMethodBeat.i(147970);
        p.h(acVar, "page");
        if (acVar.getRuntime() == null) {
            AppMethodBeat.o(147970);
            return;
        }
        try {
            AppBrandRuntime runtime = acVar.getRuntime();
            p.g(runtime, "page.runtime");
            ag(runtime).remove(acVar);
            AppMethodBeat.o(147970);
        } catch (Exception e2) {
            Log.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(e2)));
            AppMethodBeat.o(147970);
        }
    }

    private static a ag(AppBrandRuntime appBrandRuntime) {
        a aVar;
        AppMethodBeat.i(147972);
        a aVar2 = (a) appBrandRuntime.aw(a.class);
        if (aVar2 == null) {
            aVar = new a(appBrandRuntime);
            appBrandRuntime.a(aVar);
        } else {
            aVar = aVar2;
        }
        AppMethodBeat.o(147972);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "luggage-wechat-full-sdk_release"})
    public static final class a extends HashSet<ac> implements n {
        public a(AppBrandRuntime appBrandRuntime) {
            p.h(appBrandRuntime, "runtime");
            AppMethodBeat.i(147966);
            c brl = appBrandRuntime.brl();
            if (brl != null) {
                brl.a(new c.a(this) {
                    /* class com.tencent.mm.plugin.appbrand.page.ab.a.AnonymousClass1 */
                    final /* synthetic */ a nqG;

                    {
                        this.nqG = r1;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.a.c.a
                    public final void a(String str, b bVar) {
                        AppMethodBeat.i(147965);
                        if (bVar == b.DESTROYED) {
                            this.nqG.clear();
                        }
                        AppMethodBeat.o(147965);
                    }
                });
                AppMethodBeat.o(147966);
                return;
            }
            AppMethodBeat.o(147966);
        }

        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(147967);
            if (!(obj instanceof ac)) {
                AppMethodBeat.o(147967);
                return false;
            }
            boolean contains = super.contains((ac) obj);
            AppMethodBeat.o(147967);
            return contains;
        }

        public final /* bridge */ boolean remove(Object obj) {
            AppMethodBeat.i(147968);
            if (!(obj instanceof ac)) {
                AppMethodBeat.o(147968);
                return false;
            }
            boolean remove = super.remove((ac) obj);
            AppMethodBeat.o(147968);
            return remove;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.i(147969);
            int size = super.size();
            AppMethodBeat.o(147969);
            return size;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean l(com.tencent.mm.plugin.appbrand.page.ac r6) {
        /*
        // Method dump skipped, instructions count: 253
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.ab.l(com.tencent.mm.plugin.appbrand.page.ac):boolean");
    }
}
