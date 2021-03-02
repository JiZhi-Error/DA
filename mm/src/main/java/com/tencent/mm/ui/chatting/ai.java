package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai {
    private static ai PjY;
    int PjZ = 0;
    private int Pka = 0;

    public static ai gOk() {
        AppMethodBeat.i(34840);
        if (PjY == null) {
            PjY = new ai();
        }
        ai aiVar = PjY;
        AppMethodBeat.o(34840);
        return aiVar;
    }

    public final void amq(int i2) {
        AppMethodBeat.i(34841);
        if (this.PjZ > 0) {
            this.PjZ--;
            AppMethodBeat.o(34841);
            return;
        }
        if (i2 != this.Pka) {
            Log.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", Integer.valueOf(i2));
            nl nlVar = new nl();
            nlVar.dTC.dTD = i2;
            EventCenter.instance.publish(nlVar);
        }
        if (i2 == 1 || i2 == 4) {
            this.Pka = i2;
        }
        AppMethodBeat.o(34841);
    }
}
