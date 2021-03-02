package com.tencent.mm.plugin.box.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.b.a;

public final class b implements i, e {
    private com.tencent.mm.plugin.box.c.b plU;
    public a plV;

    public b(com.tencent.mm.plugin.box.c.b bVar) {
        AppMethodBeat.i(76341);
        this.plU = bVar;
        g.azz().a(1869, this);
        AppMethodBeat.o(76341);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(76342);
        if (qVar.equals(this.plV)) {
            this.plU.cla().f(this.plV.dPI, i3, str, this.plV.plN.KWF);
            if (i3 == 0 && i3 == 0) {
                com.tencent.mm.plugin.box.a.a.pl(3);
                AppMethodBeat.o(76342);
                return;
            }
            com.tencent.mm.plugin.box.a.a.pl(4);
        }
        AppMethodBeat.o(76342);
    }

    @Override // com.tencent.mm.plugin.box.webview.e
    public final void fc(String str, String str2) {
        AppMethodBeat.i(76343);
        if (this.plV != null) {
            g.azz().a(this.plV);
        }
        this.plV = new a(str, str2);
        g.azz().a(this.plV, 0);
        com.tencent.mm.plugin.box.a.a.pl(2);
        AppMethodBeat.o(76343);
    }
}
