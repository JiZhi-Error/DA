package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\n\u001a\u00020\u0004*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardIPCHelper;", "", "()V", "TAG", "", "register", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "unregister", "makeKey", "plugin-appbrand-integration_release"})
public final class t {
    public static final t nXI = new t();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    public static final class a<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final a nXJ = new a();

        static {
            AppMethodBeat.i(229514);
            AppMethodBeat.o(229514);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, final d<IPCVoid> dVar) {
            AppMethodBeat.i(229513);
            u uVar = u.nXM;
            String str = iPCString.value;
            p.g(str, "data.value");
            u.i(str, new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.t.a.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(229512);
                    d dVar = dVar;
                    p.g(dVar, "callback");
                    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                    x xVar = x.SXb;
                    AppMethodBeat.o(229512);
                    return xVar;
                }
            });
            AppMethodBeat.o(229513);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    public static final class c<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final c nXK = new c();

        static {
            AppMethodBeat.i(229517);
            AppMethodBeat.o(229517);
        }

        c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(229516);
            u uVar = u.nXM;
            String str = iPCString.value;
            p.g(str, "data.value");
            u.afs(str);
            p.g(dVar, "callback");
            com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
            AppMethodBeat.o(229516);
        }
    }

    static {
        AppMethodBeat.i(229521);
        AppMethodBeat.o(229521);
    }

    private t() {
    }

    private static String j(AppBrandUI appBrandUI) {
        AppMethodBeat.i(229518);
        StringBuilder sb = new StringBuilder();
        ComponentName componentName = appBrandUI.getComponentName();
        p.g(componentName, "this.componentName");
        String sb2 = sb.append(componentName.getShortClassName()).append('@').append(appBrandUI.hashCode()).toString();
        AppMethodBeat.o(229518);
        return sb2;
    }

    public static final void k(AppBrandUI appBrandUI) {
        AppMethodBeat.i(229519);
        p.h(appBrandUI, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (appBrandUI instanceof AppBrandPluginUI) {
            AppMethodBeat.o(229519);
            return;
        }
        WeakReference weakReference = new WeakReference(appBrandUI);
        String j2 = j(appBrandUI);
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(j2), a.nXJ, new b(j2, weakReference));
        AppMethodBeat.o(229519);
    }

    public static final void l(AppBrandUI appBrandUI) {
        AppMethodBeat.i(229520);
        p.h(appBrandUI, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (appBrandUI instanceof AppBrandPluginUI) {
            AppMethodBeat.o(229520);
            return;
        }
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(j(appBrandUI)), c.nXK, null);
        AppMethodBeat.o(229520);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    public static final class b<T> implements d<IPCVoid> {
        final /* synthetic */ String $key;
        final /* synthetic */ WeakReference lzd;

        b(String str, WeakReference weakReference) {
            this.$key = str;
            this.lzd = weakReference;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(IPCVoid iPCVoid) {
            AppMethodBeat.i(229515);
            Log.i("MicroMsg.AppBrandUIMoveTaskToBackGuardIPCHelper", "callback invoke, key:" + this.$key);
            AppBrandUI appBrandUI = (AppBrandUI) this.lzd.get();
            if (appBrandUI != null) {
                appBrandUI.bXz();
                AppMethodBeat.o(229515);
                return;
            }
            AppMethodBeat.o(229515);
        }
    }
}
