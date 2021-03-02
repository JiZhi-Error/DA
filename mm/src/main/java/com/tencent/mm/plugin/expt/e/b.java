package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public long sJS;
    public long sJT;
    public String sJU;
    public boolean sJV;
    public String value;

    public b() {
    }

    public b(long j2, String str, long j3, boolean z) {
        AppMethodBeat.i(220618);
        this.sJS = j2;
        this.value = str;
        this.sJT = j3;
        this.sJV = z;
        this.sJU = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(j3));
        AppMethodBeat.o(220618);
    }

    public final String toString() {
        AppMethodBeat.i(220619);
        String str = this.sJU + ":" + this.value;
        AppMethodBeat.o(220619);
        return str;
    }
}
