package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ear extends a {
    public int MSm;
    public int Nae;
    public LinkedList<dzx> Naf = new LinkedList<>();
    public int Nag;
    public int Nah;

    public ear() {
        AppMethodBeat.i(125810);
        AppMethodBeat.o(125810);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125811);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Nae);
            aVar.e(2, 8, this.Naf);
            aVar.aM(3, this.Nag);
            aVar.aM(4, this.MSm);
            aVar.aM(5, this.Nah);
            AppMethodBeat.o(125811);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Nae) + 0 + g.a.a.a.c(2, 8, this.Naf) + g.a.a.b.b.a.bu(3, this.Nag) + g.a.a.b.b.a.bu(4, this.MSm) + g.a.a.b.b.a.bu(5, this.Nah);
            AppMethodBeat.o(125811);
            return bu;
        } else if (i2 == 2) {
            this.Naf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125811);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ear ear = (ear) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ear.Nae = aVar3.UbS.zi();
                    AppMethodBeat.o(125811);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dzx dzx = new dzx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dzx.populateBuilderWithField(aVar4, dzx, a.getNextFieldNumber(aVar4))) {
                        }
                        ear.Naf.add(dzx);
                    }
                    AppMethodBeat.o(125811);
                    return 0;
                case 3:
                    ear.Nag = aVar3.UbS.zi();
                    AppMethodBeat.o(125811);
                    return 0;
                case 4:
                    ear.MSm = aVar3.UbS.zi();
                    AppMethodBeat.o(125811);
                    return 0;
                case 5:
                    ear.Nah = aVar3.UbS.zi();
                    AppMethodBeat.o(125811);
                    return 0;
                default:
                    AppMethodBeat.o(125811);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125811);
            return -1;
        }
    }
}
