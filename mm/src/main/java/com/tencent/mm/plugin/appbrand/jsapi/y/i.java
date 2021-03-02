package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class i implements a {
    public static i mqN = new i();
    private a mqO = new a() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.y.i.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
        public final int bID() {
            return 20;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
        public final int bIE() {
            return 200;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
        public final boolean a(f fVar, bc bcVar) {
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
        public final boolean bIF() {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
        public final boolean bIG() {
            return false;
        }
    };

    public i() {
        AppMethodBeat.i(137645);
        AppMethodBeat.o(137645);
    }

    static {
        AppMethodBeat.i(137650);
        AppMethodBeat.o(137650);
    }

    private a bII() {
        AppMethodBeat.i(137646);
        if (e.M(a.class) != null) {
            a aVar = (a) e.M(a.class);
            AppMethodBeat.o(137646);
            return aVar;
        }
        a aVar2 = this.mqO;
        AppMethodBeat.o(137646);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final int bID() {
        AppMethodBeat.i(137647);
        int bID = bII().bID();
        AppMethodBeat.o(137647);
        return bID;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final int bIE() {
        AppMethodBeat.i(137648);
        int bIE = bII().bIE();
        AppMethodBeat.o(137648);
        return bIE;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final boolean a(f fVar, bc bcVar) {
        AppMethodBeat.i(193696);
        boolean a2 = bII().a(fVar, bcVar);
        AppMethodBeat.o(193696);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final boolean bIF() {
        AppMethodBeat.i(193697);
        boolean bIF = bII().bIF();
        AppMethodBeat.o(193697);
        return bIF;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final boolean bIG() {
        AppMethodBeat.i(193698);
        boolean bIG = bII().bIG();
        AppMethodBeat.o(193698);
        return bIG;
    }
}
