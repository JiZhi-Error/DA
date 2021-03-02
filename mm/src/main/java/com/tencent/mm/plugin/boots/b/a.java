package com.tencent.mm.plugin.boots.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.hp.net.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class a implements e {
    public static a pkM;
    public com.tencent.mm.plugin.boots.b.a.a pkN;

    @Override // com.tencent.mm.plugin.boots.a.e
    public final void CN(int i2) {
        AppMethodBeat.i(117369);
        d(i2, false, 0);
        AppMethodBeat.o(117369);
    }

    @Override // com.tencent.mm.plugin.boots.a.e
    public final void fb(int i2, int i3) {
        AppMethodBeat.i(117370);
        d(i2, true, i3);
        AppMethodBeat.o(117370);
    }

    private void d(int i2, boolean z, int i3) {
        int i4 = 255;
        AppMethodBeat.i(117371);
        if (this.pkN != null) {
            com.tencent.mm.plugin.boots.a.a CP = this.pkN.CP(i2);
            int CO = this.pkN.CO(i2);
            if (z && CP.field_dau != CO) {
                if (CO <= 255) {
                    i4 = CO;
                }
                h.INSTANCE.idkeyStat((long) i3, (long) i4, 1, false);
            }
            AppMethodBeat.o(117371);
            return;
        }
        Log.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
        AppMethodBeat.o(117371);
    }

    @Override // com.tencent.mm.plugin.boots.a.e
    public final List<com.tencent.mm.plugin.boots.a.a> ckR() {
        AppMethodBeat.i(117372);
        if (this.pkN != null) {
            List<com.tencent.mm.plugin.boots.a.a> ckR = this.pkN.ckR();
            AppMethodBeat.o(117372);
            return ckR;
        }
        AppMethodBeat.o(117372);
        return null;
    }

    @Override // com.tencent.mm.plugin.boots.a.e
    public final void a(String str, String str2, String str3, f fVar) {
        AppMethodBeat.i(196769);
        g.azz().a(new c(str, str2, str3, fVar), 0);
        AppMethodBeat.o(196769);
    }
}
