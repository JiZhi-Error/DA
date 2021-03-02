package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends IListener<ce> implements i {
    private ce wEY;
    private boolean wEZ = false;

    public b() {
        AppMethodBeat.i(160794);
        this.__eventId = ce.class.getName().hashCode();
        AppMethodBeat.o(160794);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ce ceVar) {
        AppMethodBeat.i(64291);
        boolean a2 = a(ceVar);
        AppMethodBeat.o(64291);
        return a2;
    }

    private boolean a(ce ceVar) {
        AppMethodBeat.i(64289);
        if (!g.aAc()) {
            Log.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
            AppMethodBeat.o(64289);
            return false;
        }
        this.wEZ = false;
        if (ceVar instanceof ce) {
            this.wEY = ceVar;
            Log.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
            g.aAi();
            g.aAg().hqi.a(385, this);
            d dVar = new d(ceVar.dFo.dFq);
            g.aAi();
            g.aAg().hqi.a(dVar, 0);
            AppMethodBeat.o(64289);
            return true;
        }
        AppMethodBeat.o(64289);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64290);
        if (qVar instanceof d) {
            ce.b bVar = new ce.b();
            Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + i3 + " errmsg" + str);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
                bVar.retCode = 0;
            } else {
                Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
                bVar.retCode = i3;
            }
            g.aAi();
            g.aAg().hqi.b(385, this);
            this.wEY.dFp = bVar;
            this.wEZ = true;
            if (this.wEY.callback != null) {
                this.wEY.callback.run();
            }
            if (this.wEZ) {
                this.wEY = null;
            }
        }
        AppMethodBeat.o(64290);
    }
}
