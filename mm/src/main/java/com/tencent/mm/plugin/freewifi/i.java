package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i {
    private b wMN;

    /* synthetic */ i(byte b2) {
        this();
    }

    public static class a {
        private static i wMX = new i((byte) 0);

        static {
            AppMethodBeat.i(24676);
            AppMethodBeat.o(24676);
        }
    }

    private i() {
        AppMethodBeat.i(24677);
        this.wMN = j.dNo();
        AppMethodBeat.o(24677);
    }

    public final synchronized long Fk(String str) {
        long j2 = 0;
        synchronized (this) {
            AppMethodBeat.i(24678);
            if (m.eP(str)) {
                AppMethodBeat.o(24678);
            } else {
                try {
                    String axY = this.wMN.axY(str);
                    if (m.eP(axY)) {
                        AppMethodBeat.o(24678);
                    } else {
                        j2 = Long.valueOf(axY).longValue();
                        AppMethodBeat.o(24678);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(24678);
                }
            }
        }
        return j2;
    }

    public final synchronized int getInt(String str, int i2) {
        AppMethodBeat.i(24679);
        if (m.eP(str)) {
            AppMethodBeat.o(24679);
        } else {
            try {
                String axY = this.wMN.axY(str);
                if (m.eP(axY)) {
                    AppMethodBeat.o(24679);
                } else {
                    i2 = Integer.valueOf(axY).intValue();
                    AppMethodBeat.o(24679);
                }
            } catch (Exception e2) {
                AppMethodBeat.o(24679);
            }
        }
        return i2;
    }

    public final synchronized void at(String str, long j2) {
        AppMethodBeat.i(24680);
        this.wMN.hv(str, String.valueOf(j2));
        AppMethodBeat.o(24680);
    }

    public final synchronized void dU(String str, int i2) {
        AppMethodBeat.i(24681);
        this.wMN.hv(str, String.valueOf(i2));
        AppMethodBeat.o(24681);
    }
}
