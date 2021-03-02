package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aer extends a {
    public int kem;
    public String ken;
    public String keo;
    public String kep;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117864);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.kem);
            if (this.ken != null) {
                aVar.e(2, this.ken);
            }
            if (this.keo != null) {
                aVar.e(3, this.keo);
            }
            if (this.kep != null) {
                aVar.e(4, this.kep);
            }
            AppMethodBeat.o(117864);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.kem) + 0;
            if (this.ken != null) {
                bu += g.a.a.b.b.a.f(2, this.ken);
            }
            if (this.keo != null) {
                bu += g.a.a.b.b.a.f(3, this.keo);
            }
            if (this.kep != null) {
                bu += g.a.a.b.b.a.f(4, this.kep);
            }
            AppMethodBeat.o(117864);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117864);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aer aer = (aer) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aer.kem = aVar3.UbS.zi();
                    AppMethodBeat.o(117864);
                    return 0;
                case 2:
                    aer.ken = aVar3.UbS.readString();
                    AppMethodBeat.o(117864);
                    return 0;
                case 3:
                    aer.keo = aVar3.UbS.readString();
                    AppMethodBeat.o(117864);
                    return 0;
                case 4:
                    aer.kep = aVar3.UbS.readString();
                    AppMethodBeat.o(117864);
                    return 0;
                default:
                    AppMethodBeat.o(117864);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117864);
            return -1;
        }
    }
}
