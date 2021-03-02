package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fgh extends a {
    public String ViN;
    public int ViO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259340);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ViN != null) {
                aVar.e(101, this.ViN);
            }
            aVar.aM(102, this.ViO);
            AppMethodBeat.o(259340);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ViN != null ? g.a.a.b.b.a.f(101, this.ViN) + 0 : 0) + g.a.a.b.b.a.bu(102, this.ViO);
            AppMethodBeat.o(259340);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259340);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgh fgh = (fgh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 101:
                    fgh.ViN = aVar3.UbS.readString();
                    AppMethodBeat.o(259340);
                    return 0;
                case 102:
                    fgh.ViO = aVar3.UbS.zi();
                    AppMethodBeat.o(259340);
                    return 0;
                default:
                    AppMethodBeat.o(259340);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259340);
            return -1;
        }
    }
}
