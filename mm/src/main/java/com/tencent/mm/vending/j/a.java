package com.tencent.mm.vending.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    public Object[] RaR;

    public final <T> T get(int i2) {
        if (this.RaR.length <= i2) {
            return null;
        }
        return (T) this.RaR[i2];
    }

    public final int size() {
        if (this.RaR == null) {
            return 0;
        }
        return this.RaR.length;
    }

    public static <$1> b<$1> ep($1 _1) {
        AppMethodBeat.i(74899);
        b<$1> bVar = new b<>();
        bVar.RaR = new Object[]{_1};
        b<$1> bVar2 = bVar;
        AppMethodBeat.o(74899);
        return bVar2;
    }

    public static <$1, $2> c<$1, $2> Q($1 _1, $2 _2) {
        AppMethodBeat.i(74900);
        c<$1, $2> cVar = new c<>();
        cVar.RaR = new Object[]{_1, _2};
        c<$1, $2> cVar2 = cVar;
        AppMethodBeat.o(74900);
        return cVar2;
    }

    public static <$1, $2, $3> d<$1, $2, $3> i($1 _1, $2 _2, $3 _3) {
        AppMethodBeat.i(74901);
        d<$1, $2, $3> dVar = new d<>();
        dVar.RaR = new Object[]{_1, _2, _3};
        d<$1, $2, $3> dVar2 = dVar;
        AppMethodBeat.o(74901);
        return dVar2;
    }

    public static <$1, $2, $3, $4> e<$1, $2, $3, $4> b($1 _1, $2 _2, $3 _3, $4 _4) {
        AppMethodBeat.i(74902);
        e<$1, $2, $3, $4> eVar = new e<>();
        eVar.RaR = new Object[]{_1, _2, _3, _4};
        e<$1, $2, $3, $4> eVar2 = eVar;
        AppMethodBeat.o(74902);
        return eVar2;
    }

    public String toString() {
        AppMethodBeat.i(74903);
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        Object[] objArr = this.RaR;
        for (Object obj : objArr) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(obj);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(74903);
        return sb2;
    }
}
