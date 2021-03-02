package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class aaz extends IEvent {
    public a eif;

    public static final class a {
        public int dDe;
        public String eig;
        public boolean eih = false;
        public int eii = 0;
        public int eij = 0;
        public int eik = 0;
        public List eil;
        public int scene;
    }

    public aaz() {
        this((byte) 0);
    }

    private aaz(byte b2) {
        AppMethodBeat.i(110508);
        this.eif = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(110508);
    }
}
