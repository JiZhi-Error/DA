package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J'\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onIntercepted", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", DownloadInfo.PRIORITY, "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class d<T extends AppBrandRuntime> implements e<T> {
    public static final a nvO = new a((byte) 0);

    static {
        AppMethodBeat.i(219740);
        AppMethodBeat.o(219740);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.b.e
    public final boolean a(T t, String str, Runnable runnable) {
        AppMethodBeat.i(219738);
        p.h(t, "runtime");
        p.h(str, "scene");
        w brh = t.brh();
        p.g(brh, "runtime.pageContainer");
        t currentPage = brh.getCurrentPage();
        g a2 = currentPage != null ? currentPage.a(i.SILENT) : null;
        if (a2 == null) {
            Log.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "navigateBackInterceptionInfo is null");
            AppMethodBeat.o(219738);
            return false;
        } else if (a2.adY(str)) {
            Log.i("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "scene:[" + str + "] intercept!!");
            m(t, str);
            AppMethodBeat.o(219738);
            return true;
        } else {
            AppMethodBeat.o(219738);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.b.e
    public final e.a bSD() {
        return e.a.C0772a.nvP;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.b.e
    public final i bSE() {
        return i.SILENT;
    }

    public void m(T t, String str) {
        AppMethodBeat.i(219739);
        p.h(t, "runtime");
        p.h(str, "scene");
        AppMethodBeat.o(219739);
    }
}
