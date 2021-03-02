package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public class b implements i {
    private static b xvn;
    private boolean gYQ = false;
    private boolean xvm = false;

    public static b dTd() {
        AppMethodBeat.i(89930);
        if (xvn == null) {
            synchronized (b.class) {
                try {
                    if (xvn == null) {
                        xvn = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(89930);
                    throw th;
                }
            }
        }
        b bVar = xvn;
        AppMethodBeat.o(89930);
        return bVar;
    }

    private void release() {
        AppMethodBeat.i(89932);
        this.gYQ = false;
        g.azz().b(1311, this);
        AppMethodBeat.o(89932);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(89933);
        if (qVar.getType() == 1311) {
            Log.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
            if (!g.aAf().azp()) {
                Log.w("MicroMsg.GameConfigUpdater", "account not init.");
            } else {
                Log.i("MicroMsg.GameConfigUpdater", "updateTime, isForceUpdate: %b", Boolean.valueOf(this.xvm));
                if (!this.xvm) {
                    g.aAh().azQ().set(ar.a.USERINFO_GAME_GLOBAL_CONFIG_UPDATE_TIME_LONG, Long.valueOf(Util.nowSecond()));
                }
            }
            release();
        }
        AppMethodBeat.o(89933);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r0 != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void I(boolean r9, int r10) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.commlib.b.I(boolean, int):void");
    }
}
