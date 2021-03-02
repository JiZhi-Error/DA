package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cjw extends a {
    public String Mpp;
    public int end;
    public int start;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225974);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mpp != null) {
                aVar.e(1, this.Mpp);
            }
            aVar.aM(2, this.start);
            aVar.aM(3, this.end);
            AppMethodBeat.o(225974);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Mpp != null ? g.a.a.b.b.a.f(1, this.Mpp) + 0 : 0) + g.a.a.b.b.a.bu(2, this.start) + g.a.a.b.b.a.bu(3, this.end);
            AppMethodBeat.o(225974);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225974);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjw cjw = (cjw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjw.Mpp = aVar3.UbS.readString();
                    AppMethodBeat.o(225974);
                    return 0;
                case 2:
                    cjw.start = aVar3.UbS.zi();
                    AppMethodBeat.o(225974);
                    return 0;
                case 3:
                    cjw.end = aVar3.UbS.zi();
                    AppMethodBeat.o(225974);
                    return 0;
                default:
                    AppMethodBeat.o(225974);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225974);
            return -1;
        }
    }
}
