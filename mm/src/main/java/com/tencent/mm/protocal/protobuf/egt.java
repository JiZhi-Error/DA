package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class egt extends a {
    public int MlF;
    public dqi NgE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32467);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NgE == null) {
                b bVar = new b("Not all required fields were included: StatReport");
                AppMethodBeat.o(32467);
                throw bVar;
            }
            aVar.aM(1, this.MlF);
            if (this.NgE != null) {
                aVar.ni(2, this.NgE.computeSize());
                this.NgE.writeFields(aVar);
            }
            AppMethodBeat.o(32467);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MlF) + 0;
            if (this.NgE != null) {
                bu += g.a.a.a.nh(2, this.NgE.computeSize());
            }
            AppMethodBeat.o(32467);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NgE == null) {
                b bVar2 = new b("Not all required fields were included: StatReport");
                AppMethodBeat.o(32467);
                throw bVar2;
            }
            AppMethodBeat.o(32467);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egt egt = (egt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    egt.MlF = aVar3.UbS.zi();
                    AppMethodBeat.o(32467);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        egt.NgE = dqi;
                    }
                    AppMethodBeat.o(32467);
                    return 0;
                default:
                    AppMethodBeat.o(32467);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32467);
            return -1;
        }
    }
}
