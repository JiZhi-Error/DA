package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public enum b {
    INSTANCE;
    
    private int dEb = 0;
    private String extData = "";
    private int scene = 0;

    private b(String str) {
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(82367);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(82367);
        return bVar;
    }

    static {
        AppMethodBeat.i(82371);
        AppMethodBeat.o(82371);
    }

    public final void da(int i2, String str) {
        AppMethodBeat.i(212145);
        this.dEb = (int) (System.currentTimeMillis() / 1000);
        this.scene = i2;
        this.extData = z.bfG(str);
        AppMethodBeat.o(212145);
    }

    public final void a(String str, long j2, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(82369);
        if (j2 <= 0) {
            AppMethodBeat.o(82369);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis < 0 || currentTimeMillis > Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(82369);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(",");
        sb.append(i3).append(",");
        sb.append(i2);
        sb.append(",").append(i4).append(",").append(currentTimeMillis).append(",").append(i5).append(",").append(i6);
        Log.i("MicroMsg.AuthReport", sb.toString());
        h.INSTANCE.a(16488, str, Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Long.valueOf(currentTimeMillis), Integer.valueOf(i5), 0, Integer.valueOf(i6), Integer.valueOf(this.dEb), this.extData);
        AppMethodBeat.o(82369);
    }

    public final void aO(int i2, int i3, int i4) {
        AppMethodBeat.i(82370);
        int ape = m.ape();
        if (ape == 100) {
            ape = 0;
        }
        if (i3 < 0 || ((long) i3) > Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(82370);
            return;
        }
        h.INSTANCE.a(17614, Integer.valueOf(this.dEb), Integer.valueOf(this.scene), Integer.valueOf(i2), Integer.valueOf(ape), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(82370);
    }
}
