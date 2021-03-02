package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dbx extends a {
    public String xMX;
    public int xNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133188);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMX != null) {
                aVar.e(1, this.xMX);
            }
            aVar.aM(2, this.xNF);
            AppMethodBeat.o(133188);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xMX != null ? g.a.a.b.b.a.f(1, this.xMX) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xNF);
            AppMethodBeat.o(133188);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133188);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbx dbx = (dbx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dbx.xMX = aVar3.UbS.readString();
                    AppMethodBeat.o(133188);
                    return 0;
                case 2:
                    dbx.xNF = aVar3.UbS.zi();
                    AppMethodBeat.o(133188);
                    return 0;
                default:
                    AppMethodBeat.o(133188);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133188);
            return -1;
        }
    }
}
