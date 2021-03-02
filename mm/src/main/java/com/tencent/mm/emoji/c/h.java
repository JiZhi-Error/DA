package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    private static h hco;
    public String extraInfo = "";
    public long hcf;
    public int hcg;
    public int hch;
    public int hcp;
    public int hcq;
    public int hcr;
    public int scene;

    public static h awf() {
        AppMethodBeat.i(104484);
        if (hco == null) {
            hco = new h();
        }
        h hVar = hco;
        AppMethodBeat.o(104484);
        return hVar;
    }

    public final void zj(long j2) {
        this.hcf = j2;
        this.hcg = 1;
    }

    public final void b(int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(104485);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16029, str, str2, str3, str4, Integer.valueOf(this.scene), Long.valueOf(currentTimeMillis - this.hcf), Integer.valueOf(this.hcg), Integer.valueOf(this.hcp), Integer.valueOf(this.hcq), 0, Integer.valueOf(i2), Integer.valueOf(this.hcr), 0, 0, Integer.valueOf(this.hch), this.extraInfo, Long.valueOf(currentTimeMillis), Long.valueOf(this.hcf));
        this.hcg++;
        AppMethodBeat.o(104485);
    }
}
