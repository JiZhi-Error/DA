package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public final class cm {
    public Set<a> iGc = new HashSet();
    public boolean isRunning = false;

    public interface a {
        boolean aWC();
    }

    public cm() {
        AppMethodBeat.i(132286);
        AppMethodBeat.o(132286);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(132287);
        if (this.isRunning) {
            Log.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
            AppMethodBeat.o(132287);
            return false;
        }
        boolean add = this.iGc.add(aVar);
        AppMethodBeat.o(132287);
        return add;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(132288);
        if (this.isRunning) {
            Log.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
            AppMethodBeat.o(132288);
            return false;
        }
        boolean remove = this.iGc.remove(aVar);
        AppMethodBeat.o(132288);
        return remove;
    }
}
