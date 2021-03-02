package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.facedetect.b.m;

public final class g implements a {
    @Override // com.tencent.mm.plugin.flash.e.a
    public final String getResultKey() {
        return "verify_result";
    }

    @Override // com.tencent.mm.plugin.flash.e.a
    public final void a(long j2, String str, String str2, String str3, String str4, int i2, float f2, int i3, i iVar) {
        AppMethodBeat.i(186706);
        com.tencent.mm.kernel.g.azz().a(new m(j2, str3, str4, str, str2, i2, f2, i3), 0);
        AppMethodBeat.o(186706);
    }

    @Override // com.tencent.mm.plugin.flash.e.a
    public final int getType() {
        return 1080;
    }
}
