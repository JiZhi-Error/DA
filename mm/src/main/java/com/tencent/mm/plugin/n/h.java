package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.f;
import com.tencent.mm.sdk.platformtools.Util;

public final class h {
    public long bdG = 0;
    private int businessType;
    public long eiq = 0;
    private boolean guh;
    public boolean rsr = true;
    public boolean rss = false;
    boolean zrA = false;
    public long zrr = 0;
    public long zrs = -1;
    public long zrt = 0;
    public long zru = 0;
    public long zrv = 0;
    public long zrw = 10;
    public boolean zrx = true;
    public boolean zry = false;
    boolean zrz = false;

    public h(boolean z, int i2) {
        this.guh = z;
        this.businessType = i2;
    }

    public final String info() {
        AppMethodBeat.i(133910);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(133910);
        return sb;
    }

    public final void aFh(String str) {
        AppMethodBeat.i(133911);
        if (!this.zrx) {
            AppMethodBeat.o(133911);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat((long) ejh(), 152, 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(ejg(), 500, Long.valueOf(Util.nowSecond()), str);
        AppMethodBeat.o(133911);
    }

    public final void aFi(String str) {
        AppMethodBeat.i(133912);
        if (!this.zrx) {
            AppMethodBeat.o(133912);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat((long) ejh(), 153, 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(ejg(), 501, Long.valueOf(Util.nowSecond()), str);
        AppMethodBeat.o(133912);
    }

    public final void ejf() {
        AppMethodBeat.i(133913);
        if (!this.zrx) {
            AppMethodBeat.o(133913);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat((long) ejh(), 155, 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(ejg(), 503, Long.valueOf(Util.nowSecond()), "");
        AppMethodBeat.o(133913);
    }

    public final int ejg() {
        if (this.businessType == 1) {
            return 20439;
        }
        return 13836;
    }

    public final int ejh() {
        if (this.businessType == 1) {
            return 1427;
        }
        return f.CTRL_INDEX;
    }
}
