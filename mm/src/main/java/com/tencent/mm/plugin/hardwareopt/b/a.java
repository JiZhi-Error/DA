package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbc;

public class a {
    private static volatile a yjo = null;
    private cbc yjp = null;

    private a() {
    }

    public static a dYJ() {
        a aVar;
        AppMethodBeat.i(55555);
        if (yjo == null) {
            synchronized (a.class) {
                try {
                    if (yjo == null) {
                        yjo = new a();
                    }
                    aVar = yjo;
                } finally {
                    AppMethodBeat.o(55555);
                }
            }
            return aVar;
        }
        a aVar2 = yjo;
        AppMethodBeat.o(55555);
        return aVar2;
    }

    public final cbc dYK() {
        AppMethodBeat.i(55556);
        if (this.yjp == null) {
            this.yjp = new cbc();
        }
        cbc cbc = this.yjp;
        AppMethodBeat.o(55556);
        return cbc;
    }
}
