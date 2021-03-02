package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.b.d;
import com.tinkerboots.sdk.tinker.a.a;
import java.io.File;

public class TinkerServerResultService extends DefaultTinkerResultService {
    private static boolean SKJ = false;
    private static a ynn = null;

    @Override // com.tencent.tinker.lib.service.AbstractResultService, com.tencent.tinker.lib.service.DefaultTinkerResultService
    public final void a(com.tencent.tinker.lib.service.a aVar) {
        AppMethodBeat.i(3457);
        if (aVar == null) {
            ShareTinkerLog.v("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
            AppMethodBeat.o(3457);
            return;
        }
        ShareTinkerLog.v("Tinker.TinkerServerResultService", "receive result: %s", aVar.toString());
        b.ll(getApplicationContext());
        if (ynn != null) {
            ynn.a(aVar);
        }
        if (aVar.isSuccess) {
            ShareTinkerLog.v("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
            ad(new File(aVar.SjJ));
            if (!b(aVar)) {
                ShareTinkerLog.v("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
                AppMethodBeat.o(3457);
                return;
            } else if (SKJ) {
                ShareTinkerLog.v("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
                new d.b(getApplicationContext(), new d.a() {
                    /* class com.tinkerboots.sdk.tinker.service.TinkerServerResultService.AnonymousClass1 */

                    @Override // com.tinkerboots.sdk.b.d.a
                    public final void onScreenOff() {
                        AppMethodBeat.i(3456);
                        TinkerServerResultService.restartProcess();
                        AppMethodBeat.o(3456);
                    }
                });
                AppMethodBeat.o(3457);
                return;
            }
        } else {
            ShareTinkerLog.v("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
        }
        AppMethodBeat.o(3457);
    }

    static void restartProcess() {
        AppMethodBeat.i(3458);
        ShareTinkerLog.v("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tinkerboots/sdk/tinker/service/TinkerServerResultService", "restartProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tinkerboots/sdk/tinker/service/TinkerServerResultService", "restartProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(3458);
    }
}
