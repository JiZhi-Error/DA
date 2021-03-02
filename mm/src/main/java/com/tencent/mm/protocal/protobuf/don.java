package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class don extends a {
    public int KIS;
    public int Scene;
    public String Url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6427);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            aVar.aM(2, this.KIS);
            aVar.aM(3, this.Scene);
            AppMethodBeat.o(6427);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Url != null ? g.a.a.b.b.a.f(1, this.Url) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KIS) + g.a.a.b.b.a.bu(3, this.Scene);
            AppMethodBeat.o(6427);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6427);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            don don = (don) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    don.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(6427);
                    return 0;
                case 2:
                    don.KIS = aVar3.UbS.zi();
                    AppMethodBeat.o(6427);
                    return 0;
                case 3:
                    don.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(6427);
                    return 0;
                default:
                    AppMethodBeat.o(6427);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6427);
            return -1;
        }
    }
}
