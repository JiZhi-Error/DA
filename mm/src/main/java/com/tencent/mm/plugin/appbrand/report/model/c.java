package com.tencent.mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Deque;
import java.util.LinkedList;

public final class c implements g, h {
    private h.a nIA;
    private final String nIv;
    private final SparseArray<h.a> nIw = new SparseArray<>();
    private final Deque<h.a> nIx = new LinkedList();
    private boolean nIy = true;
    private String nIz;

    public c(String str, String str2) {
        AppMethodBeat.i(227380);
        this.nIv = str;
        synchronized (this) {
            try {
                this.nIz = str2;
            } finally {
                AppMethodBeat.o(227380);
            }
        }
    }

    private synchronized void bUF() {
        this.nIA = null;
        this.nIz = null;
        this.nIy = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.g
    public final void a(ag agVar, ag agVar2, bx bxVar) {
        h.a r;
        AppMethodBeat.i(48098);
        synchronized (this) {
            try {
                if (this.nIy) {
                    q(agVar);
                } else if (bxVar == bx.NAVIGATE_BACK) {
                    b(agVar, agVar2);
                    AppMethodBeat.o(48098);
                } else {
                    if (this.nIA != null) {
                        bUF();
                    }
                    if (!(agVar2 == null || (r = r(agVar2)) == null)) {
                        r.nIH = new h.c(2, agVar.nna);
                    }
                    h.a aVar = new h.a(agVar);
                    aVar.nII = agVar2 == null ? null : new h.b(agVar2.nna);
                    a(aVar);
                    AppMethodBeat.o(48098);
                }
            } finally {
                AppMethodBeat.o(48098);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.g
    public final void d(ag agVar) {
        AppMethodBeat.i(48099);
        synchronized (this) {
            try {
                h.a r = r(agVar);
                if (r != null) {
                    Pair<Integer, String> t = d.t(agVar);
                    r.nIH = new h.c(((Integer) t.first).intValue(), (String) t.second);
                    AppMethodBeat.o(48099);
                }
            } finally {
                AppMethodBeat.o(48099);
            }
        }
    }

    private h.a r(ag agVar) {
        AppMethodBeat.i(48100);
        h.a bUH = bUH();
        if (bUH == null) {
            h.a aVar = new h.a(agVar);
            AppMethodBeat.o(48100);
            return aVar;
        } else if (bUH.dKv == agVar.hashCode()) {
            AppMethodBeat.o(48100);
            return bUH;
        } else {
            Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
            AppMethodBeat.o(48100);
            return bUH;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.g
    public final synchronized void e(ag agVar) {
        AppMethodBeat.i(48101);
        if (this.nIy) {
            q(agVar);
            AppMethodBeat.o(48101);
        } else {
            bUF();
            AppMethodBeat.o(48101);
        }
    }

    private synchronized void a(h.a aVar) {
        AppMethodBeat.i(48102);
        this.nIx.offerFirst(aVar);
        this.nIw.put(aVar.dKv, aVar);
        AppMethodBeat.o(48102);
    }

    private synchronized h.a bUG() {
        h.a pollFirst;
        AppMethodBeat.i(48103);
        pollFirst = this.nIx.pollFirst();
        if (pollFirst != null) {
            this.nIw.remove(pollFirst.dKv);
        }
        AppMethodBeat.o(48103);
        return pollFirst;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.h
    public final synchronized h.a bUH() {
        h.a peekFirst;
        AppMethodBeat.i(48104);
        peekFirst = this.nIx.peekFirst();
        AppMethodBeat.o(48104);
        return peekFirst;
    }

    private synchronized boolean isEmpty() {
        boolean isEmpty;
        AppMethodBeat.i(48105);
        isEmpty = this.nIx.isEmpty();
        AppMethodBeat.o(48105);
        return isEmpty;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.h
    public final synchronized boolean aeN(String str) {
        boolean z;
        AppMethodBeat.i(48106);
        if (Util.isNullOrNil(this.nIz) || !this.nIz.equals(str)) {
            z = false;
            AppMethodBeat.o(48106);
        } else {
            z = true;
            AppMethodBeat.o(48106);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.h
    public final synchronized h.a s(ag agVar) {
        h.a aVar;
        AppMethodBeat.i(48107);
        aVar = this.nIw.get(agVar.hashCode());
        if (aVar == null && this.nIA != null && this.nIA.dKv == agVar.hashCode()) {
            aVar = this.nIA;
            AppMethodBeat.o(48107);
        } else {
            AppMethodBeat.o(48107);
        }
        return aVar;
    }

    private synchronized void b(ag agVar, ag agVar2) {
        AppMethodBeat.i(48096);
        boolean aeN = aeN(agVar2.nna);
        this.nIA = r(agVar2);
        this.nIA.nIH = new h.c(1, agVar.nna);
        int hashCode = agVar.hashCode();
        while (!isEmpty() && bUH().dKv != hashCode) {
            bUG();
        }
        if (aeN) {
            a(new h.a(agVar));
        }
        r(agVar).nII = new h.b(agVar2.nna);
        r(agVar).nIH = null;
        AppMethodBeat.o(48096);
    }

    private synchronized void q(ag agVar) {
        h.b bVar;
        AppMethodBeat.i(48097);
        this.nIz = agVar.nna;
        this.nIy = false;
        a(new h.a(agVar));
        h.a bUH = bUH();
        if (Util.isNullOrNil(this.nIv)) {
            bVar = null;
        } else {
            bVar = new h.b(this.nIv);
        }
        bUH.nII = bVar;
        AppMethodBeat.o(48097);
    }
}
