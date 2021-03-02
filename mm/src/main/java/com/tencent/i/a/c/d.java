package com.tencent.i.a.c;

import com.tencent.i.a.a.c;
import com.tencent.i.a.b.a;
import com.tencent.i.a.h;
import com.tencent.i.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements b {
    private c SrD;
    private a SrE;

    public d(c cVar) {
        this.SrD = cVar;
    }

    @Override // com.tencent.i.a.c.b
    public final boolean b(h.a aVar, a aVar2) {
        boolean z;
        AppMethodBeat.i(214737);
        if (this.SrE != null) {
            a aVar3 = this.SrE;
            if (aVar3.mHandlerThread != null) {
                z = aVar3.mHandlerThread.isAlive();
            } else {
                z = false;
            }
            if (!z) {
                com.tencent.h.c.h.i("sensor_MasterManager", "[method: start ] mEngine is not Alive : ");
                this.SrE = null;
            }
        }
        if (this.SrE == null) {
            this.SrE = new c("master_engine", this.SrD);
        } else if (aVar.Sqr != this.SrE.hqh().Sqr) {
            this.SrE.destroy();
            this.SrE = new c("master_engine", this.SrD);
        }
        boolean a2 = this.SrE.a(aVar, aVar2);
        AppMethodBeat.o(214737);
        return a2;
    }

    @Override // com.tencent.i.a.c.b
    public final boolean a(i.a aVar) {
        long j2 = 0;
        AppMethodBeat.i(214738);
        if (this.SrE != null) {
            h.a hqh = this.SrE.hqh();
            if (hqh != null && hqh.Sqr == com.tencent.i.a.c.GESTURETYPE_SINGLE) {
                j2 = 30;
            }
            boolean a2 = this.SrE.a(aVar, j2);
            AppMethodBeat.o(214738);
            return a2;
        }
        AppMethodBeat.o(214738);
        return false;
    }
}
