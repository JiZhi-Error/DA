package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.n.g;

public final class c {
    public int gov = -1;

    public final int F(String str, int i2) {
        AppMethodBeat.i(20042);
        this.gov = a.ezb();
        if (g.oJ(i2)) {
            if (g.Em(str)) {
                try {
                    this.gov = R.drawable.br1;
                } catch (Exception e2) {
                }
            } else if (g.En(str)) {
                try {
                    this.gov = R.drawable.br1;
                } catch (Exception e3) {
                }
            }
        }
        if (this.gov < 0) {
            this.gov = a.ezb();
        }
        int i3 = this.gov;
        AppMethodBeat.o(20042);
        return i3;
    }
}
