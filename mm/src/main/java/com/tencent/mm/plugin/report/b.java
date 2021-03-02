package com.tencent.mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private long Cxq;
    private HashMap<Integer, Long> Cxr = new HashMap<>();
    private int mID = 463;
    private long mInterval = 300000;

    public b() {
        AppMethodBeat.i(125118);
        AppMethodBeat.o(125118);
    }

    public final void l(int i2, int i3, long j2) {
        AppMethodBeat.i(125119);
        synchronized (this) {
            try {
                az(i2, j2);
                az(i3, 1);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.Cxq > this.mInterval) {
                    for (Map.Entry<Integer, Long> entry : this.Cxr.entrySet()) {
                        e.INSTANCE.idkeyStat((long) this.mID, (long) entry.getKey().intValue(), entry.getValue().longValue(), false);
                    }
                    this.Cxq = currentTimeMillis;
                }
            } finally {
                AppMethodBeat.o(125119);
            }
        }
    }

    private void az(int i2, long j2) {
        AppMethodBeat.i(125120);
        Long l = this.Cxr.get(Integer.valueOf(i2));
        if (l != null) {
            j2 += l.longValue();
        }
        this.Cxr.put(Integer.valueOf(i2), Long.valueOf(j2));
        AppMethodBeat.o(125120);
    }
}
