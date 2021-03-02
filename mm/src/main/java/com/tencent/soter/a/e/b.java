package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.f;

public final class b {
    int RQB;
    String RQC;
    boolean RQD;
    boolean RQE;
    private a RQF;
    private boolean RQG;

    /* synthetic */ b(int i2, String str, boolean z, boolean z2, a aVar, byte b2) {
        this(i2, str, z, z2, aVar);
    }

    private b(int i2, String str, boolean z, boolean z2, a aVar) {
        this.RQB = 0;
        this.RQC = "";
        this.RQD = false;
        this.RQE = false;
        this.RQF = null;
        this.RQG = false;
        this.RQB = i2;
        this.RQC = str;
        this.RQD = z;
        this.RQE = z2;
        this.RQF = aVar;
    }

    public static class a {
        public int RQB = 0;
        private String RQC = "";
        public boolean RQD = false;
        private boolean RQE = false;
        public a RQF = null;

        public final a dF(String str, boolean z) {
            this.RQC = str;
            this.RQE = z;
            this.RQB |= 2;
            return this;
        }

        public final b hlK() {
            AppMethodBeat.i(25);
            b bVar = new b(this.RQB, this.RQC, this.RQD, this.RQE, this.RQF, (byte) 0);
            AppMethodBeat.o(25);
            return bVar;
        }
    }

    public final void hi() {
        AppMethodBeat.i(26);
        g.hlR().aj(new Runnable() {
            /* class com.tencent.soter.a.e.b.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
            /* JADX WARNING: Removed duplicated region for block: B:9:0x0037  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 460
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.soter.a.e.b.AnonymousClass1.run():void");
            }
        });
        AppMethodBeat.o(26);
    }

    static /* synthetic */ void a(b bVar, f fVar) {
        AppMethodBeat.i(27);
        if (bVar.RQF != null && !bVar.RQG) {
            if (fVar == null) {
                bVar.RQF.onError(-1, "unknown");
            } else if (fVar.isSuccess()) {
                bVar.RQF.onSuccess();
            } else {
                bVar.RQF.onError(fVar.errCode, fVar.errMsg);
            }
        }
        bVar.RQG = true;
        AppMethodBeat.o(27);
    }
}
