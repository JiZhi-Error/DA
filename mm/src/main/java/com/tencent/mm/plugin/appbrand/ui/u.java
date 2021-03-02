package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.Application;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001c\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardLogic;", "", "()V", "TAG", "", "onMMTaskToFrontListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function0;", "", "install", "application", "Landroid/app/Application;", "registerOnMMTaskToFrontListener", "key", "block", "unregisterOnMMTaskToFrontListener", "plugin-appbrand-integration_release"})
public final class u {
    private static final ConcurrentHashMap<String, kotlin.g.a.a<x>> nXL = new ConcurrentHashMap<>();
    public static final u nXM = new u();

    static {
        AppMethodBeat.i(229528);
        AppMethodBeat.o(229528);
    }

    private u() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardLogic$install$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityPostStarted", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
    public static final class a extends com.tencent.mm.plugin.appbrand.ac.a {
        a() {
        }

        public final void onActivityPostStarted(Activity activity) {
            Activity gIw;
            AppMethodBeat.i(229524);
            p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            u uVar = u.nXM;
            if (u.nXL.size() > 0) {
                int taskId = activity.getTaskId();
                com.tencent.mm.ui.j.a aVar = (com.tencent.mm.ui.j.a) g.af(com.tencent.mm.ui.j.a.class);
                if (aVar == null || (gIw = aVar.gIw()) == null) {
                    AppMethodBeat.o(229524);
                    return;
                } else if (taskId == gIw.getTaskId()) {
                    Log.i("MicroMsg.AppBrandUIMoveTaskToBackGuardLogic", "onActivityPostStarted " + activity + ", invoke onMMTaskToFront");
                    h.RTc.aZ(RunnableC0811a.nXN);
                }
            }
            AppMethodBeat.o(229524);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.u$a$a  reason: collision with other inner class name */
        static final class RunnableC0811a implements Runnable {
            public static final RunnableC0811a nXN = new RunnableC0811a();

            static {
                AppMethodBeat.i(229523);
                AppMethodBeat.o(229523);
            }

            RunnableC0811a() {
            }

            public final void run() {
                AppMethodBeat.i(229522);
                u uVar = u.nXM;
                for (Map.Entry entry : u.nXL.entrySet()) {
                    ((kotlin.g.a.a) entry.getValue()).invoke();
                }
                AppMethodBeat.o(229522);
            }
        }
    }

    public static final void install(Application application) {
        AppMethodBeat.i(229525);
        p.h(application, "application");
        application.registerActivityLifecycleCallbacks(new a());
        AppMethodBeat.o(229525);
    }

    public static void i(String str, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(229526);
        p.h(str, "key");
        p.h(aVar, "block");
        nXL.put(str, aVar);
        AppMethodBeat.o(229526);
    }

    public static void afs(String str) {
        AppMethodBeat.i(229527);
        p.h(str, "key");
        nXL.remove(str);
        AppMethodBeat.o(229527);
    }
}
