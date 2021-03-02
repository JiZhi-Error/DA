package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class un extends a {
    public String Hwr;
    public String Hws;
    public int IhZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113965);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Hwr != null) {
                aVar.e(1, this.Hwr);
            }
            if (this.Hws != null) {
                aVar.e(2, this.Hws);
            }
            aVar.aM(3, this.IhZ);
            AppMethodBeat.o(113965);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Hwr != null ? g.a.a.b.b.a.f(1, this.Hwr) + 0 : 0;
            if (this.Hws != null) {
                f2 += g.a.a.b.b.a.f(2, this.Hws);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.IhZ);
            AppMethodBeat.o(113965);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113965);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            un unVar = (un) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    unVar.Hwr = aVar3.UbS.readString();
                    AppMethodBeat.o(113965);
                    return 0;
                case 2:
                    unVar.Hws = aVar3.UbS.readString();
                    AppMethodBeat.o(113965);
                    return 0;
                case 3:
                    unVar.IhZ = aVar3.UbS.zi();
                    AppMethodBeat.o(113965);
                    return 0;
                default:
                    AppMethodBeat.o(113965);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113965);
            return -1;
        }
    }
}
