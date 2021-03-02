package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class euf extends a {
    public LinkedList<esq> NpZ = new LinkedList<>();
    public int Nsi;
    public int Nsj;

    public euf() {
        AppMethodBeat.i(115901);
        AppMethodBeat.o(115901);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115902);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Nsi);
            aVar.aM(2, this.Nsj);
            aVar.e(3, 8, this.NpZ);
            AppMethodBeat.o(115902);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Nsi) + 0 + g.a.a.b.b.a.bu(2, this.Nsj) + g.a.a.a.c(3, 8, this.NpZ);
            AppMethodBeat.o(115902);
            return bu;
        } else if (i2 == 2) {
            this.NpZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115902);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            euf euf = (euf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    euf.Nsi = aVar3.UbS.zi();
                    AppMethodBeat.o(115902);
                    return 0;
                case 2:
                    euf.Nsj = aVar3.UbS.zi();
                    AppMethodBeat.o(115902);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esq esq = new esq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esq.populateBuilderWithField(aVar4, esq, a.getNextFieldNumber(aVar4))) {
                        }
                        euf.NpZ.add(esq);
                    }
                    AppMethodBeat.o(115902);
                    return 0;
                default:
                    AppMethodBeat.o(115902);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115902);
            return -1;
        }
    }
}
