package com.tencent.mm.plugin.hp.tinker;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tinkerboots.sdk.tinker.a.a;

public class TinkerPatchResultService extends DefaultTinkerResultService {
    private static a ynn = null;
    boolean yno = false;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x010c  */
    @Override // com.tencent.tinker.lib.service.AbstractResultService, com.tencent.tinker.lib.service.DefaultTinkerResultService
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.tinker.lib.service.a r15) {
        /*
        // Method dump skipped, instructions count: 278
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService.a(com.tencent.tinker.lib.service.a):void");
    }

    public static void a(a aVar) {
        ynn = aVar;
    }

    static /* synthetic */ boolean access$000() {
        AppMethodBeat.i(117500);
        zj zjVar = new zj();
        zjVar.efx.dKy = 2;
        EventCenter.instance.publish(zjVar);
        boolean z = zjVar.efy.calling;
        AppMethodBeat.o(117500);
        return z;
    }

    static /* synthetic */ void a(TinkerPatchResultService tinkerPatchResultService) {
        boolean z = true;
        AppMethodBeat.i(117501);
        if (tinkerPatchResultService.yno) {
            Log.w("Tinker.TinkerPatchResultService", "[+] do not call suicide more than one time @ %s", Util.getStack());
            AppMethodBeat.o(117501);
            return;
        }
        tinkerPatchResultService.yno = true;
        Log.i("Tinker.TinkerPatchResultService", "app is background now, i can kill quietly");
        Log.appenderFlushSync();
        t azz = g.azz();
        if (azz.iMB != null) {
            z = azz.iMB.booleanValue();
        }
        if (z) {
            Log.i("Tinker.TinkerPatchResultService", "we are in foreground, trigger reboot now.");
            Intent launchIntentForPackage = tinkerPatchResultService.getPackageManager().getLaunchIntentForPackage(tinkerPatchResultService.getPackageName());
            if (launchIntentForPackage != null) {
                try {
                    com.tencent.mm.a.a.a(tinkerPatchResultService.getApplicationContext(), 112, 1, System.currentTimeMillis() + 1000, launchIntentForPackage, 1073741824, false);
                } catch (Throwable th) {
                    Log.printErrStackTrace("Tinker.TinkerPatchResultService", th, "[-] Fail to set alarm.", new Object[0]);
                    Log.appenderFlushSync();
                }
            } else {
                Log.e("Tinker.TinkerPatchResultService", "failure to get launcher intent, skip reboot logic.");
            }
        } else {
            Log.w("Tinker.TinkerPatchResultService", "we are in background, do not explicitly trigger reboot.");
        }
        c.JYn.bW(MMApplicationContext.getContext());
        AppMethodBeat.o(117501);
    }
}
