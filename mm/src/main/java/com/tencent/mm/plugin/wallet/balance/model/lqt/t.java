package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ddd;

public final class t {
    public final ddd Htw;
    public final int sQn;

    public t(a aVar) {
        this.Htw = aVar.Htw;
        this.sQn = aVar.sQn;
    }

    public static class a {
        public ddd Htw;
        public int sQn = -1;

        public final t fMT() {
            AppMethodBeat.i(213849);
            t tVar = new t(this);
            AppMethodBeat.o(213849);
            return tVar;
        }
    }
}
