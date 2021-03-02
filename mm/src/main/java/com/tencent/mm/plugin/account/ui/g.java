package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;

public final class g extends SecurityImage.b {
    private static g kmK = null;
    public String account = null;
    public String kdq = null;
    public byte[] kdr = null;
    public String kds = null;
    public String kdt = null;
    public String kmI = null;
    public int kmJ = 0;

    @Override // com.tencent.mm.ui.applet.SecurityImage.b
    public final void bnH() {
        AppMethodBeat.i(128184);
        if (!Util.isNullOrNil(this.kmI)) {
            com.tencent.mm.kernel.g.azz().a(new t(this.account, this.kmI, this.ONI.getSecCodeType(), "", "", "", 0, "", false, true), 0);
            AppMethodBeat.o(128184);
            return;
        }
        com.tencent.mm.kernel.g.azz().a(new t(this.account, this.kdq, this.ONI.getSecCodeType(), "", "", "", 0, "", false, false), 0);
        AppMethodBeat.o(128184);
    }

    public static void a(g gVar) {
        kmK = gVar;
    }

    public static String bpk() {
        if (kmK != null) {
            return kmK.account;
        }
        return null;
    }

    public static String bpl() {
        if (kmK != null) {
            return kmK.kdq;
        }
        return null;
    }
}
