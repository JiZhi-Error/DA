package com.tencent.mm.plugin.appbrand;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J!\u0010\u000b\u001a\u00020\t2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/AppBrandProcessSharedPersistentRuntimeStore;", "", "()V", "TAG", "", "runtimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "contains", "", "runtime", "isAllEquals", "array", "", "objectToMatch", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "isEmpty", "onRuntimeFinish", "", "appId", "poll", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "pollOrCreate", "remotePop", "remove", "stash", "plugin-appbrand-integration_release"})
public final class k {
    private static final ConcurrentHashMap<String, q> kAg = new ConcurrentHashMap<>();
    public static final k kAh = new k();

    static {
        AppMethodBeat.i(50146);
        AppMethodBeat.o(50146);
    }

    private k() {
    }

    public static final boolean isEmpty() {
        AppMethodBeat.i(50139);
        boolean isEmpty = kAg.isEmpty();
        AppMethodBeat.o(50139);
        return isEmpty;
    }

    public static final q a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandRuntimeContainerWC appBrandRuntimeContainerWC) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(175099);
        p.h(appBrandInitConfigWC, "cfg");
        p.h(appBrandRuntimeContainerWC, "container");
        q remove = kAg.remove(appBrandInitConfigWC.appId);
        if (remove != null) {
            f(remove);
            Boolean[] boolArr = new Boolean[4];
            boolArr[0] = Boolean.valueOf(remove.bss() == appBrandInitConfigWC.ldK);
            boolArr[1] = Boolean.valueOf(remove.brt());
            if (!remove.isFinishing()) {
                z = true;
            } else {
                z = false;
            }
            boolArr[2] = Boolean.valueOf(z);
            if (remove.isDestroyed()) {
                z2 = false;
            }
            boolArr[3] = Boolean.valueOf(z2);
            Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "pollOrCreate, existed runtime[" + remove.getAppId() + "], conditions[" + org.apache.commons.b.a.toString(boolArr) + ']');
            if (a(boolArr, Boolean.TRUE)) {
                remove.a((ak) appBrandRuntimeContainerWC);
                AppMethodBeat.o(175099);
                return remove;
            }
        }
        AppMethodBeat.o(175099);
        return null;
    }

    public static final void c(q qVar) {
        AppMethodBeat.i(50142);
        p.h(qVar, "runtime");
        Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "stash ".concat(String.valueOf(qVar)));
        qVar.a((ak) null);
        String appId = qVar.getAppId();
        p.g(appId, "runtime.appId");
        kAg.put(appId, qVar);
        try {
            AppBrandRemoteTaskController appBrandRemoteTaskController = qVar.kDi;
            p.g(appBrandRemoteTaskController, "runtime.mRemoteController");
            if (appBrandRemoteTaskController.getAppId() == null) {
                Log.e("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "stash, null == runtime.mRemoteController.appId, updateRuntimeProps(" + qVar + ')');
                qVar.kDi.M(qVar);
            }
            String str = MainProcessIPCService.dkO;
            String appId2 = qVar.getAppId();
            h azG = g.aAe().azG();
            p.g(azG, "MMKernel.process().current()");
            XIPCInvoker.a(str, new IPC_PARAM_stashPersistentApp(appId2, azG.getProcessName(), qVar.kDi), ai.class);
            AppMethodBeat.o(50142);
        } catch (c e2) {
            AppMethodBeat.o(50142);
        }
    }

    public static final boolean d(q qVar) {
        AppMethodBeat.i(227893);
        if (qVar == null) {
            AppMethodBeat.o(227893);
            return false;
        }
        boolean containsValue = kAg.containsValue(qVar);
        AppMethodBeat.o(227893);
        return containsValue;
    }

    public static final boolean e(q qVar) {
        boolean z;
        AppMethodBeat.i(50143);
        p.h(qVar, "runtime");
        if (Build.VERSION.SDK_INT >= 24) {
            z = kAg.remove(qVar.getAppId(), qVar);
        } else if (d(qVar)) {
            kAg.remove(qVar.getAppId());
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f(qVar);
        }
        AppMethodBeat.o(50143);
        return z;
    }

    private static void f(q qVar) {
        AppMethodBeat.i(50145);
        try {
            new a(qVar).invoke();
            AppMethodBeat.o(50145);
        } catch (c e2) {
            Log.e("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "remotePop runtime:" + qVar + ", exception:" + e2);
            AppMethodBeat.o(50145);
        }
    }

    public static final void Ue(String str) {
        AppMethodBeat.i(227894);
        p.h(str, "appId");
        Log.i("MicroMsg.AppBrandProcessSharedPersistentRuntimeStore", "onRuntimeFinish appId =".concat(String.valueOf(str)));
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPC_PARAM_onRuntimeFinish(str), ag.class, null);
        AppMethodBeat.o(227894);
    }

    private static boolean a(Object[] objArr, Object obj) {
        AppMethodBeat.i(50138);
        for (int i2 = 0; i2 < 4; i2++) {
            if (!p.j(objArr[i2], obj)) {
                AppMethodBeat.o(50138);
                return false;
            }
        }
        AppMethodBeat.o(50138);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<IPCVoid> {
        final /* synthetic */ q kAi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar) {
            super(0);
            this.kAi = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ IPCVoid invoke() {
            AppMethodBeat.i(50137);
            IPCVoid iPCVoid = (IPCVoid) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(this.kAi.getAppId()), ah.class);
            AppMethodBeat.o(50137);
            return iPCVoid;
        }
    }
}
