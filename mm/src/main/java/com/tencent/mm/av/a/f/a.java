package com.tencent.mm.av.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.b;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a implements Runnable {
    private final b jaJ = this.jbK.jaJ;
    private final c jaR;
    private final com.tencent.mm.av.a.c.b jaT;
    private final com.tencent.mm.av.a.c.c jaU;
    private final com.tencent.mm.av.a.b jbK;
    private final d jbL;
    private final String url;

    public a(String str, c cVar, com.tencent.mm.av.a.b bVar, d dVar) {
        AppMethodBeat.i(130433);
        this.url = str;
        this.jbK = bVar;
        if (cVar == null) {
            this.jaR = this.jaJ.jaR;
        } else {
            this.jaR = cVar;
        }
        this.jbL = dVar;
        if (this.jaR.jaU != null) {
            this.jaU = this.jaR.jaU;
        } else {
            this.jaU = this.jaJ.jaU;
        }
        this.jaT = this.jaJ.jaT;
        AppMethodBeat.o(130433);
    }

    public final void run() {
        AppMethodBeat.i(130434);
        new com.tencent.mm.av.a.d.b();
        com.tencent.mm.av.a.d.b OV = this.jaU.OV(this.url);
        if (OV == null) {
            if (this.jbL != null) {
                this.jbL.a(false, this.jaR.jbE);
                AppMethodBeat.o(130434);
                return;
            }
        } else if ((BitmapUtil.decodeByteArray(OV.data, 10, 10) != null || !this.jaR.jbz) && this.jaT.a(this.url, OV.data, this.jaR)) {
            if (this.jbL != null) {
                this.jbL.a(true, this.jaR.jbE);
                AppMethodBeat.o(130434);
                return;
            }
        } else if (this.jbL != null) {
            this.jbL.a(false, this.jaR.jbE);
        }
        AppMethodBeat.o(130434);
    }
}
