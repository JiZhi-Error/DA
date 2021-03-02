package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;

final class b implements f {
    e lmA;
    Runnable lmB = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.a.b.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(121213);
            i.Fq(SupportProcessIPCService.dkO);
            AppMethodBeat.o(121213);
        }
    };
    Runnable lmC = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.a.b.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(121215);
            if (!c.axW().Fo(SupportProcessIPCService.dkO)) {
                AppMethodBeat.o(121215);
                return;
            }
            h.a(SupportProcessIPCService.dkO, null, a.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.a.b.AnonymousClass2.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(121214);
                    Log.i("MicroMsg.DynamicPagePerformance", "exitTask onCallback");
                    i.Fr(SupportProcessIPCService.dkO);
                    AppMethodBeat.o(121214);
                }
            });
            AppMethodBeat.o(121215);
        }
    };
    Runnable lmD = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.a.b.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(121217);
            if (!c.axW().Fo(SupportProcessIPCService.dkO)) {
                AppMethodBeat.o(121217);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("forceKillProcess", true);
            h.a(SupportProcessIPCService.dkO, bundle, a.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.a.b.AnonymousClass3.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(121216);
                    Log.i("MicroMsg.DynamicPagePerformance", "killProcessTask onCallback");
                    i.Fr(SupportProcessIPCService.dkO);
                    AppMethodBeat.o(121216);
                }
            });
            AppMethodBeat.o(121217);
        }
    };

    b(e eVar) {
        AppMethodBeat.i(121219);
        this.lmA = eVar;
        AppMethodBeat.o(121219);
    }

    @Override // com.tencent.mm.modelappbrand.f
    public final void exit() {
        AppMethodBeat.i(121220);
        com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.lmC);
        AppMethodBeat.o(121220);
    }

    @Override // com.tencent.mm.modelappbrand.f
    public final void restart() {
        AppMethodBeat.i(121221);
        com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.lmD);
        com.tencent.mm.plugin.appbrand.dynamic.b.j(this.lmB, 2000);
        AppMethodBeat.o(121221);
    }

    @Override // com.tencent.mm.modelappbrand.f
    public final void Ln(String str) {
        AppMethodBeat.i(121222);
        Set<View> ch = this.lmA.ch(str);
        if (ch == null || ch.isEmpty()) {
            AppMethodBeat.o(121222);
            return;
        }
        for (View view : ch) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                Log.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", Integer.valueOf(view.hashCode()));
                ((IPCDynamicPageView) view).onPause();
            }
        }
        AppMethodBeat.o(121222);
    }

    @Override // com.tencent.mm.modelappbrand.f
    public final void Lo(String str) {
        AppMethodBeat.i(121223);
        Set<View> ch = this.lmA.ch(str);
        if (ch == null || ch.isEmpty()) {
            AppMethodBeat.o(121223);
            return;
        }
        for (View view : ch) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                Log.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", Integer.valueOf(view.hashCode()));
                ((IPCDynamicPageView) view).onResume();
            }
        }
        AppMethodBeat.o(121223);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            boolean z = false;
            AppMethodBeat.i(121218);
            Bundle bundle2 = bundle;
            if (bundle2 != null && bundle2.getBoolean("forceKillProcess", false)) {
                z = true;
            }
            if (z) {
                com.tencent.mm.plugin.appbrand.dynamic.h.b.bCm();
            } else {
                com.tencent.mm.plugin.appbrand.dynamic.h.b.bCl();
            }
            dVar.bn(null);
            AppMethodBeat.o(121218);
        }
    }
}
