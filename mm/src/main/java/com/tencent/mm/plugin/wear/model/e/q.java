package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class q {
    public HashMap<Integer, a> IyG = new HashMap<>();

    public q() {
        AppMethodBeat.i(30108);
        AppMethodBeat.o(30108);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(30109);
        for (Integer num : aVar.fWe()) {
            int intValue = num.intValue();
            Log.d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", Integer.valueOf(intValue), aVar);
            this.IyG.put(Integer.valueOf(intValue), aVar);
        }
        AppMethodBeat.o(30109);
    }

    public final a afj(int i2) {
        AppMethodBeat.i(30110);
        a aVar = this.IyG.get(Integer.valueOf(i2));
        AppMethodBeat.o(30110);
        return aVar;
    }
}
