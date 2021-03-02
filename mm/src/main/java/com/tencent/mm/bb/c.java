package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c implements i {
    private static c jgG;
    private boolean gYQ = false;
    private int jgF = 3;

    public static c beo() {
        AppMethodBeat.i(150790);
        if (jgG == null) {
            jgG = new c();
        }
        c cVar = jgG;
        AppMethodBeat.o(150790);
        return cVar;
    }

    public final void update() {
        AppMethodBeat.i(150791);
        Log.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.gYQ);
        Log.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.aAh().isSDCardAvailable());
        if (!this.gYQ && g.aAh().isSDCardAvailable()) {
            release();
            this.gYQ = true;
            g.aAg().hqi.a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
            g.aAg().hqi.a(new n(7), 0);
        }
        AppMethodBeat.o(150791);
    }

    private void release() {
        AppMethodBeat.i(150792);
        this.gYQ = false;
        g.aAg().hqi.b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        AppMethodBeat.o(150792);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(150793);
        if (qVar.getType() == 159) {
            Log.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0) {
                g.aAh().azQ().set(81938, Long.valueOf(Util.nowSecond()));
            } else {
                int i4 = this.jgF - 1;
                this.jgF = i4;
                if (i4 < 0) {
                    g.aAh().azQ().set(81938, Long.valueOf(((Util.nowMilliSecond() - Util.MILLSECONDS_OF_DAY) + Util.MILLSECONDS_OF_HOUR) / 1000));
                    this.jgF = 3;
                }
            }
            release();
        }
        AppMethodBeat.o(150793);
    }
}
