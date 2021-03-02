package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abg;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.xweb.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.xwalk.core.XWalkCoreWrapper;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0003J\b\u0010\u0010\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig;", "", "()V", "KEY_XWEB_INSTALLED", "", "PERSISTENT_UI_CLASS", "", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI;", "[Ljava/lang/Class;", "TAG", "canKeepPersistent", "", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "isPersistentConfigOpen", "isPersistentXWebConfigOpen", "watchApp", "", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class i {
    private static final Class<? extends AppBrandPluginUI>[] kzY = {AppBrandPluginUI.class, AppBrandPluginUI1.class, AppBrandPluginUI2.class, AppBrandPluginUI3.class, AppBrandPluginUI4.class};
    public static final i kzZ = new i();

    static {
        AppMethodBeat.i(50136);
        AppMethodBeat.o(50136);
    }

    private i() {
    }

    public static final boolean a(AppBrandRuntimeContainerWC appBrandRuntimeContainerWC) {
        AppMethodBeat.i(50133);
        p.h(appBrandRuntimeContainerWC, "container");
        Object activity = appBrandRuntimeContainerWC.getActivity();
        if (activity == null) {
            activity = a.kAa.invoke();
        }
        Boolean[] boolArr = new Boolean[2];
        boolArr[0] = Boolean.valueOf(WebView.isX5());
        boolArr[1] = Boolean.valueOf(WebView.isXWalk() && XWalkCoreWrapper.getInstance().hasFeature(2003));
        Log.i("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, containerUI[" + activity.getClass().getSimpleName() + "], kernelConditions[" + org.apache.commons.b.a.toString(boolArr) + ']');
        if (!org.apache.commons.b.a.contains(kzY, activity.getClass()) || !org.apache.commons.b.a.contains(boolArr, Boolean.TRUE)) {
            AppMethodBeat.o(50133);
            return false;
        }
        AppMethodBeat.o(50133);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"checkSaveXWebInstallState", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b kAb = new b();

        static {
            AppMethodBeat.i(50130);
            AppMethodBeat.o(50130);
        }

        b() {
            super(0);
        }

        public static void invoke() {
            AppMethodBeat.i(50129);
            if (WebView.isXWalk()) {
                MultiProcessMMKV.getMMKV("MicroMsg.AppBrandPersistentRuntimeConfig").putBoolean("KEY_XWEB_INSTALLED", XWalkCoreWrapper.getInstance().hasFeature(2003)).commit();
            }
            AppMethodBeat.o(50129);
        }
    }

    public static final void i(Application application) {
        AppMethodBeat.i(50134);
        p.h(application, "app");
        b bVar = b.kAb;
        application.registerActivityLifecycleCallbacks(new c());
        new d().alive();
        AppMethodBeat.o(50134);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$2", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityStarted", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
    public static final class c extends com.tencent.mm.plugin.appbrand.ac.a {
        c() {
        }

        @Override // com.tencent.mm.plugin.appbrand.ac.a
        public final void onActivityStarted(Activity activity) {
            AppMethodBeat.i(50131);
            if (activity instanceof AppBrandUI) {
                b bVar = b.kAb;
                b.invoke();
            }
            AppMethodBeat.o(50131);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/XWebViewInitCompleteEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class d extends IListener<abg> {
        d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abg abg) {
            AppMethodBeat.i(50132);
            b bVar = b.kAb;
            b.invoke();
            AppMethodBeat.o(50132);
            return false;
        }
    }

    public static final boolean brb() {
        AppMethodBeat.i(50135);
        boolean z = MultiProcessMMKV.getMMKV("MicroMsg.AppBrandPersistentRuntimeConfig").getBoolean("KEY_XWEB_INSTALLED", false);
        AppMethodBeat.o(50135);
        return z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Boolean> {
        public static final a kAa = new a();

        static {
            AppMethodBeat.i(227888);
            AppMethodBeat.o(227888);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(227887);
            Log.e("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, container.activity == NULL");
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(227887);
            return bool;
        }
    }
}
