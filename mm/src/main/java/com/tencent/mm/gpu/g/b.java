package com.tencent.mm.gpu.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.e.e;
import com.tencent.mm.gpu.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    private static b hjH = new b();
    public String hjG = "";
    private int hjI = 0;
    private e hjJ = null;
    private boolean hjK = false;
    public a.AbstractC0347a hjL = new a.AbstractC0347a() {
        /* class com.tencent.mm.gpu.g.b.AnonymousClass1 */

        @Override // com.tencent.mm.gpu.g.a.AbstractC0347a
        public final void a(e eVar) {
            AppMethodBeat.i(186223);
            b.a(b.this);
            if (b.this.hjJ == null) {
                b.this.hjJ = eVar;
                AppMethodBeat.o(186223);
                return;
            }
            long j2 = ((long) eVar.hjt) + 0 + ((long) eVar.hjr) + ((long) eVar.hjs);
            long j3 = ((long) b.this.hjJ.hjt) + 0 + ((long) b.this.hjJ.hjr) + ((long) b.this.hjJ.hjs);
            Log.i("MicroMsg.KeyBusinessMonitor", "name:%s,time:%d,now:%d,last:%d", b.this.hjG, Integer.valueOf(b.this.hjI), Long.valueOf(j2), Long.valueOf(j3));
            if ((((double) (j2 - j3)) * 100.0d) / ((double) j3) > 0.05d) {
                b.this.hjK = true;
            }
            if (!b.this.hjK) {
                b.g(b.this);
                AppMethodBeat.o(186223);
                return;
            }
            if (b.this.hjI >= 4) {
                h.INSTANCE.kvStat(20507, "finder");
            }
            b.this.hjJ = eVar;
            AppMethodBeat.o(186223);
        }
    };

    static /* synthetic */ int a(b bVar) {
        int i2 = bVar.hjI;
        bVar.hjI = i2 + 1;
        return i2;
    }

    static /* synthetic */ void g(b bVar) {
        AppMethodBeat.i(186226);
        bVar.clear();
        AppMethodBeat.o(186226);
    }

    static {
        AppMethodBeat.i(186227);
        AppMethodBeat.o(186227);
    }

    private b() {
        AppMethodBeat.i(186224);
        AppMethodBeat.o(186224);
    }

    public static b axB() {
        return hjH;
    }

    public final void axC() {
        AppMethodBeat.i(186225);
        a.axy().a(this.hjL);
        clear();
        AppMethodBeat.o(186225);
    }

    private void clear() {
        this.hjG = "";
        this.hjI = 0;
        this.hjK = false;
        this.hjJ = null;
    }
}
