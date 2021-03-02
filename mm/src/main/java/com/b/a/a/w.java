package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import com.b.a.a.d;
import com.b.a.a.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w extends n {
    private static w cmU;
    private boolean cmV;
    private int cmW;
    private long cmX;
    private long cmY;

    static w JC() {
        AppMethodBeat.i(87951);
        if (cmU == null) {
            cmU = new w();
        }
        w wVar = cmU;
        AppMethodBeat.o(87951);
        return wVar;
    }

    w() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d, com.b.a.a.a
    public final void a(Context context, Handler handler, d.a aVar) {
        AppMethodBeat.i(87952);
        if (this.cmV) {
            if (k.Jc().chu) {
                k.Jc().IY();
            }
        } else if (!k.Jc().chu) {
            try {
                k.Jc().a(context, this);
            } catch (Exception e2) {
            }
        }
        super.a(context, handler, aVar);
        AppMethodBeat.o(87952);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d, com.b.a.a.n, com.b.a.a.b
    public final synchronized void a(Handler handler, d.a aVar) {
        AppMethodBeat.i(87953);
        this.cmV = false;
        super.a(handler, aVar);
        AppMethodBeat.o(87953);
    }

    @Override // com.b.a.a.m, com.b.a.a.b
    public final void a(p pVar) {
        boolean z;
        AppMethodBeat.i(87954);
        long j2 = pVar.ckf;
        if (!this.cmV || j2 - this.cmY <= this.cmX) {
            z = false;
        } else {
            stop();
            z = true;
        }
        if (z) {
            AppMethodBeat.o(87954);
            return;
        }
        super.a(pVar);
        AppMethodBeat.o(87954);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.n, com.b.a.a.b
    public final void a(int i2, String str, long j2, long j3) {
        AppMethodBeat.i(87956);
        if (this.cmV) {
            stop();
        }
        super.a(i2, str, j2, j3);
        AppMethodBeat.o(87956);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.n, com.b.a.a.b
    public final void a(x xVar, long j2, long j3) {
        boolean z;
        AppMethodBeat.i(87955);
        if (xVar.cnc == null) {
            xVar.cnc = new x.a();
        }
        float f2 = xVar.cnc.cnf;
        if (!this.cmV || f2 < ((float) this.cmW)) {
            z = false;
        } else {
            stop();
            z = true;
        }
        if (z) {
            AppMethodBeat.o(87955);
            return;
        }
        super.a(xVar, j2, j3);
        AppMethodBeat.o(87955);
    }
}
