package com.tencent.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements com.tencent.g.b.a {
    private g SoO;
    private boolean aqH = true;

    protected a(g gVar) {
        this.SoO = gVar;
    }

    @Override // com.tencent.g.b.a
    public final void F(String str, Object obj) {
        AppMethodBeat.i(62811);
        if (!this.aqH) {
            AppMethodBeat.o(62811);
            return;
        }
        f hpQ = f.hpQ();
        if (obj == null) {
            h hVar = new h("TpfServiceCenter|registerService|name or service should not be null");
            AppMethodBeat.o(62811);
            throw hVar;
        }
        synchronized (hpQ.SoU) {
            try {
                hpQ.SoS.put(str, obj);
            } finally {
                AppMethodBeat.o(62811);
            }
        }
    }
}
