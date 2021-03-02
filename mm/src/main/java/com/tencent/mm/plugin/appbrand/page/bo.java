package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.c.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onActionbarInstalled", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"})
public class bo implements com.tencent.mm.plugin.appbrand.page.a.b, h {
    private final ac cxr;
    private final com.tencent.mm.plugin.appbrand.page.c.c nuj;

    public bo(ac acVar, com.tencent.mm.plugin.appbrand.page.c.c cVar) {
        p.h(acVar, "page");
        p.h(cVar, "H");
        AppMethodBeat.i(148005);
        this.cxr = acVar;
        this.nuj = cVar;
        AppMethodBeat.o(148005);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bo(com.tencent.mm.plugin.appbrand.page.ac r4) {
        /*
            r3 = this;
            r2 = 148006(0x24226, float:2.074E-40)
            java.lang.String r0 = "page"
            kotlin.g.b.p.h(r4, r0)
            com.tencent.mm.plugin.appbrand.page.c.c r0 = com.tencent.mm.plugin.appbrand.page.c.c.a.y(r4)
            java.lang.String r1 = "IPageStatusBarHelper.Factory.createHelper(page)"
            kotlin.g.b.p.g(r0, r1)
            r3.<init>(r4, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.bo.<init>(com.tencent.mm.plugin.appbrand.page.ac):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.h
    public final void Nj() {
        AppMethodBeat.i(148000);
        ac acVar = this.cxr;
        if (MMHandlerThread.isMainThread()) {
            this.nuj.Nj();
            AppMethodBeat.o(148000);
            return;
        }
        View contentView = acVar.getContentView();
        if (contentView != null) {
            contentView.post(new c(this));
            AppMethodBeat.o(148000);
            return;
        }
        AppMethodBeat.o(148000);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.h
    public final void Nk() {
        AppMethodBeat.i(148001);
        ac acVar = this.cxr;
        if (MMHandlerThread.isMainThread()) {
            this.nuj.Nk();
            AppMethodBeat.o(148001);
            return;
        }
        View contentView = acVar.getContentView();
        if (contentView != null) {
            contentView.post(new a(this));
            AppMethodBeat.o(148001);
            return;
        }
        AppMethodBeat.o(148001);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onForeground() {
        AppMethodBeat.i(148002);
        this.nuj.MV();
        com.tencent.mm.plugin.appbrand.page.c.c cVar = this.nuj;
        if (!(cVar instanceof com.tencent.mm.plugin.appbrand.page.c.a)) {
            cVar = null;
        }
        com.tencent.mm.plugin.appbrand.page.c.a aVar = (com.tencent.mm.plugin.appbrand.page.c.a) cVar;
        if (aVar != null) {
            boolean OD = this.cxr.getWindowAndroid().OD();
            Context context = this.cxr.getContext();
            p.g(context, "page.context");
            Resources resources = context.getResources();
            p.g(resources, "page.context.resources");
            aVar.u(OD, resources.getConfiguration().orientation);
            AppMethodBeat.o(148002);
            return;
        }
        AppMethodBeat.o(148002);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onBackground() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(148003);
        p.h(configuration, "newConfig");
        com.tencent.mm.plugin.appbrand.page.c.c cVar = this.nuj;
        if (!(cVar instanceof com.tencent.mm.plugin.appbrand.page.c.a)) {
            cVar = null;
        }
        com.tencent.mm.plugin.appbrand.page.c.a aVar = (com.tencent.mm.plugin.appbrand.page.c.a) cVar;
        if (aVar != null) {
            this.cxr.post(new b(aVar, this, configuration));
            AppMethodBeat.o(148003);
            return;
        }
        AppMethodBeat.o(148003);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl$onConfigurationChanged$1$1"})
    static final class b implements Runnable {
        final /* synthetic */ bo nuk;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.page.c.a nul;
        final /* synthetic */ Configuration nun;

        b(com.tencent.mm.plugin.appbrand.page.c.a aVar, bo boVar, Configuration configuration) {
            this.nul = aVar;
            this.nuk = boVar;
            this.nun = configuration;
        }

        public final void run() {
            AppMethodBeat.i(147998);
            this.nul.u(this.nuk.cxr.getWindowAndroid().OD(), this.nun.orientation);
            AppMethodBeat.o(147998);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar) {
        AppMethodBeat.i(230122);
        p.h(bVar, "actionBar");
        AppMethodBeat.o(230122);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.h
    public final boolean Nm() {
        AppMethodBeat.i(148004);
        if (this.nuj.Nl() == c.b.HIDDEN) {
            AppMethodBeat.o(148004);
            return true;
        }
        AppMethodBeat.o(148004);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
    public static final class a implements Runnable {
        final /* synthetic */ bo nuk;

        public a(bo boVar) {
            this.nuk = boVar;
        }

        public final void run() {
            AppMethodBeat.i(147997);
            this.nuk.nuj.Nk();
            AppMethodBeat.o(147997);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
    public static final class c implements Runnable {
        final /* synthetic */ bo nuk;

        public c(bo boVar) {
            this.nuk = boVar;
        }

        public final void run() {
            AppMethodBeat.i(147999);
            this.nuk.nuj.Nj();
            AppMethodBeat.o(147999);
        }
    }
}
