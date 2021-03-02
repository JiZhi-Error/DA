package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.s;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j implements i {
    public j() {
        AppMethodBeat.i(150802);
        g.aAg().hqi.a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        g.aAg().hqi.a(160, this);
        g.aAg().hqi.a(new n(5), 0);
        AppMethodBeat.o(150802);
    }

    private void release() {
        AppMethodBeat.i(150803);
        g.aAg().hqi.b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        g.aAg().hqi.b(160, this);
        AppMethodBeat.o(150803);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(150804);
        if (!(qVar instanceof s) || ((s) qVar).aYR() != 5) {
            Log.d("MicroMsg.LangPackageUpdater", "another scene");
            AppMethodBeat.o(150804);
            return;
        }
        int type = qVar.getType();
        if (type != 159) {
            if (type == 160) {
                if (i2 == 0 && i3 == 0) {
                    bep();
                }
                release();
            }
            AppMethodBeat.o(150804);
        } else if (i2 == 0 && i3 == 0) {
            bep();
            q[] tJ = v.bev().tJ(5);
            if (tJ == null || tJ.length == 0) {
                Log.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
                release();
                AppMethodBeat.o(150804);
                return;
            }
            q qVar2 = tJ[0];
            Log.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + qVar2.id + " version:" + qVar2.version + " status:" + qVar2.status + " type:" + qVar2.dMe);
            if (5 != qVar2.status) {
                release();
                AppMethodBeat.o(150804);
                return;
            }
            g.aAg().hqi.a(new m(qVar2.id, 5), 0);
            AppMethodBeat.o(150804);
        } else {
            release();
            AppMethodBeat.o(150804);
        }
    }

    private static void bep() {
        AppMethodBeat.i(150805);
        g.aAh().azQ().set(81939, Long.valueOf(Util.nowMilliSecond()));
        AppMethodBeat.o(150805);
    }
}
