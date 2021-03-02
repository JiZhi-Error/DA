package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fby extends a {
    public int NxZ;
    public String Nya;
    public String Nyb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124575);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NxZ);
            if (this.Nya != null) {
                aVar.e(2, this.Nya);
            }
            if (this.Nyb != null) {
                aVar.e(3, this.Nyb);
            }
            AppMethodBeat.o(124575);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NxZ) + 0;
            if (this.Nya != null) {
                bu += g.a.a.b.b.a.f(2, this.Nya);
            }
            if (this.Nyb != null) {
                bu += g.a.a.b.b.a.f(3, this.Nyb);
            }
            AppMethodBeat.o(124575);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124575);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fby fby = (fby) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fby.NxZ = aVar3.UbS.zi();
                    AppMethodBeat.o(124575);
                    return 0;
                case 2:
                    fby.Nya = aVar3.UbS.readString();
                    AppMethodBeat.o(124575);
                    return 0;
                case 3:
                    fby.Nyb = aVar3.UbS.readString();
                    AppMethodBeat.o(124575);
                    return 0;
                default:
                    AppMethodBeat.o(124575);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124575);
            return -1;
        }
    }
}
