package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.ui.applet.SecurityImage;

/* access modifiers changed from: package-private */
public final class i extends SecurityImage.b {
    protected byte[] kdr = null;
    protected String kds = "";
    protected String kdt = "";
    protected int kmJ = 0;

    i() {
    }

    @Override // com.tencent.mm.ui.applet.SecurityImage.b
    public final void bnH() {
        AppMethodBeat.i(39073);
        bg.azz().a(new t(this.kmJ, "", this.kds, this.kdt), 0);
        AppMethodBeat.o(39073);
    }
}
