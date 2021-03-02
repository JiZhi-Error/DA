package com.tencent.mm.plugin.sns.ui.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.m.c;
import com.tencent.mm.vending.g.g;

public final class c {
    public int EMi = 0;
    public b ESM = new b();
    public c.a ESN = null;
    public boolean hasInit = false;

    public c() {
        AppMethodBeat.i(99838);
        AppMethodBeat.o(99838);
    }

    private void b(String str, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(99839);
        b bVar = this.ESM;
        if (bVar.EKQ != null) {
            g.a(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)).c(bVar.EKQ.FgB);
        }
        AppMethodBeat.o(99839);
    }

    private void c(String str, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(99840);
        b bVar = this.ESM;
        if (bVar.EKQ != null) {
            g.a(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)).c(bVar.EKQ.FgC);
        }
        AppMethodBeat.o(99840);
    }

    public final void d(String str, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(99841);
        if (!this.hasInit) {
            AppMethodBeat.o(99841);
            return;
        }
        if (this.EMi == 0) {
            b(str, z, z2, i2);
        }
        AppMethodBeat.o(99841);
    }

    public final void e(String str, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(99842);
        if (!this.hasInit) {
            AppMethodBeat.o(99842);
            return;
        }
        if (this.EMi == 0) {
            c(str, z, z2, i2);
        }
        AppMethodBeat.o(99842);
    }
}
