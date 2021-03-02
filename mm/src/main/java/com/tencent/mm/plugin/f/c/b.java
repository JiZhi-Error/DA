package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class b implements Runnable {
    private ca dCM;
    private int opType;

    public b(ca caVar, int i2) {
        AppMethodBeat.i(22750);
        this.dCM = caVar;
        this.opType = i2;
        Log.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.dCM.field_msgId), Integer.valueOf(this.dCM.getType()), Integer.valueOf(this.opType));
        AppMethodBeat.o(22750);
    }

    public final void run() {
        AppMethodBeat.i(22751);
        switch (this.opType) {
            case 1:
                com.tencent.mm.plugin.f.b.crW().an(this.dCM);
                AppMethodBeat.o(22751);
                return;
            default:
                Log.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.opType));
                AppMethodBeat.o(22751);
                return;
        }
    }
}
