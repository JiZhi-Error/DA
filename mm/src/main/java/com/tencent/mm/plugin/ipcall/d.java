package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.storage.ar;

public final class d {
    public static boolean dZW() {
        AppMethodBeat.i(25325);
        if (!bg.aAc()) {
            AppMethodBeat.o(25325);
            return false;
        } else if (h.aqJ().getInt("WCOEntranceSwitch", 0) > 0) {
            bg.aVF();
            c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.o(25325);
            return true;
        } else {
            bg.aVF();
            c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.o(25325);
            return false;
        }
    }
}
