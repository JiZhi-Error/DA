package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ecu extends a {
    public int Ndg;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152701);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            aVar.aM(2, this.Ndg);
            AppMethodBeat.o(152701);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Ndg);
            AppMethodBeat.o(152701);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152701);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecu ecu = (ecu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ecu.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152701);
                    return 0;
                case 2:
                    ecu.Ndg = aVar3.UbS.zi();
                    AppMethodBeat.o(152701);
                    return 0;
                default:
                    AppMethodBeat.o(152701);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152701);
            return -1;
        }
    }
}
