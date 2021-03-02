package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.b.n;

public final class f implements a {
    @Override // com.tencent.mm.plugin.flash.e.a
    public final String getResultKey() {
        return "faceregister_ticket";
    }

    @Override // com.tencent.mm.plugin.flash.e.a
    public final int getType() {
        return 918;
    }

    @Override // com.tencent.mm.plugin.flash.e.a
    public final void a(long j2, String str, String str2, String str3, String str4, int i2, float f2, int i3, i iVar) {
        AppMethodBeat.i(186705);
        g.azz().a(new n(j2, str, str2), 0);
        AppMethodBeat.o(186705);
    }
}
