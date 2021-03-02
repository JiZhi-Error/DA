package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public int hpS;
    public int qrD;
    public int ypP;

    public final String toString() {
        AppMethodBeat.i(25412);
        String format = String.format("IPCallUserInfo, userStatus: %d, syncKey: %d, memberId: %d", Integer.valueOf(this.hpS), Integer.valueOf(this.ypP), Integer.valueOf(this.qrD));
        AppMethodBeat.o(25412);
        return format;
    }
}
