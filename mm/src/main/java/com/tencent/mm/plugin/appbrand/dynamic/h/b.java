package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.c.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    private static final MTimerHandler lpf = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.h.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(121426);
            BaseIPCService Fs = j.aya().Fs(SupportProcessIPCService.dkO);
            if (Fs != null) {
                Fs.eo(false);
            }
            AppMethodBeat.o(121426);
            return false;
        }
    }, true);

    static {
        AppMethodBeat.i(121434);
        AppMethodBeat.o(121434);
    }

    public static void bCl() {
        AppMethodBeat.i(121431);
        if (!g.Fp(SupportProcessIPCService.dkO)) {
            Log.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
            AppMethodBeat.o(121431);
            return;
        }
        int size = b.a.hnP.size();
        if (size != 0) {
            Log.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", Integer.valueOf(size));
            AppMethodBeat.o(121431);
            return;
        }
        Log.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
        lpf.startTimer(Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(121431);
    }

    public static void bCm() {
        AppMethodBeat.i(121432);
        if (!g.Fp(SupportProcessIPCService.dkO)) {
            Log.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
            AppMethodBeat.o(121432);
            return;
        }
        Log.i("MicroMsg.DynamicProcessPerformance", "kill support process");
        lpf.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.h.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(121427);
                a a2 = c.a(Process.myPid(), new a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/appbrand/dynamic/performance/DynamicProcessPerformance$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/appbrand/dynamic/performance/DynamicProcessPerformance$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                AppMethodBeat.o(121427);
            }
        }, 500);
        AppMethodBeat.o(121432);
    }

    public static void bCn() {
        AppMethodBeat.i(121433);
        Log.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
        if (com.tencent.mm.ipcinvoker.c.axW().Fo(ToolsProcessIPCService.dkO)) {
            h.a(ToolsProcessIPCService.dkO, null, c.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.h.b.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(121428);
                    Log.i("MicroMsg.DynamicProcessPerformance", "on kill process tools callback");
                    i.Fr(ToolsProcessIPCService.dkO);
                    AppMethodBeat.o(121428);
                }
            });
        }
        if (com.tencent.mm.ipcinvoker.c.axW().Fo(ToolsMpProcessIPCService.dkO)) {
            h.a(ToolsMpProcessIPCService.dkO, null, c.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.h.b.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(121429);
                    Log.i("MicroMsg.DynamicProcessPerformance", "on kill process tools mp callback");
                    i.Fr(ToolsMpProcessIPCService.dkO);
                    AppMethodBeat.o(121429);
                }
            });
        }
        if (com.tencent.mm.ipcinvoker.c.axW().Fo(SupportProcessIPCService.dkO)) {
            h.a(SupportProcessIPCService.dkO, null, c.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.h.b.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(121430);
                    Log.i("MicroMsg.DynamicProcessPerformance", "on kill process support callback");
                    i.Fr(SupportProcessIPCService.dkO);
                    AppMethodBeat.o(121430);
                }
            });
        }
        AppMethodBeat.o(121433);
    }
}
