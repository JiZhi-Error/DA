package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eze extends a {
    public String MRZ;
    public int MWA;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32546);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                b bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32546);
                throw bVar;
            }
            if (this.MRZ != null) {
                aVar.e(1, this.MRZ);
            }
            aVar.aM(2, this.MWA);
            AppMethodBeat.o(32546);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MRZ != null ? g.a.a.b.b.a.f(1, this.MRZ) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MWA);
            AppMethodBeat.o(32546);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                b bVar2 = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32546);
                throw bVar2;
            }
            AppMethodBeat.o(32546);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eze eze = (eze) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eze.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32546);
                    return 0;
                case 2:
                    eze.MWA = aVar3.UbS.zi();
                    AppMethodBeat.o(32546);
                    return 0;
                default:
                    AppMethodBeat.o(32546);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32546);
            return -1;
        }
    }
}
