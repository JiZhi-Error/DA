package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    long count = 0;
    long qwh = Util.currentTicks();
    private String tag = BuildConfig.KINDA_DEFAULT;
    long value = 0;
    long ztD = Util.currentTicks();

    public c(String str) {
        AppMethodBeat.i(89352);
        this.tag = str;
        AppMethodBeat.o(89352);
    }

    public final void Hi(long j2) {
        AppMethodBeat.i(89353);
        if (this.count == 0) {
            this.qwh = Util.currentTicks();
        }
        this.value += j2;
        this.count++;
        this.ztD = Util.currentTicks();
        AppMethodBeat.o(89353);
    }

    public final String getValue() {
        AppMethodBeat.i(89354);
        if (this.count == 0) {
            AppMethodBeat.o(89354);
            return "";
        }
        double d2 = ((double) (this.ztD - this.qwh)) / 1000.0d;
        if (d2 == 0.0d) {
            d2 = 1.0d;
        }
        String format = String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", "", this.tag, Long.valueOf(this.count), Double.valueOf(d2), Double.valueOf((((double) this.value) * 1.0d) / ((double) this.count)), Double.valueOf((((double) this.count) * 1.0d) / d2), Double.valueOf((1.0d * ((double) this.value)) / d2), Long.valueOf(this.qwh), Long.valueOf(this.ztD), Long.valueOf(this.ztD - this.qwh));
        AppMethodBeat.o(89354);
        return format;
    }

    public final String ejv() {
        AppMethodBeat.i(89355);
        if (this.count == 0) {
            AppMethodBeat.o(89355);
            return "";
        }
        double d2 = ((double) (this.ztD - this.qwh)) / 1000.0d;
        if (d2 == 0.0d) {
            d2 = 1.0d;
        }
        String sb = new StringBuilder().append((1.0d * ((double) this.count)) / d2).toString();
        AppMethodBeat.o(89355);
        return sb;
    }

    public final void reset() {
        this.value = 0;
        this.count = 0;
    }
}
