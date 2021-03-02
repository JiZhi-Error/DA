package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dgl extends a {
    public int LPy;
    public LinkedList<dgk> MLd = new LinkedList<>();
    public int oTz;

    public dgl() {
        AppMethodBeat.i(155449);
        AppMethodBeat.o(155449);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155450);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LPy);
            aVar.aM(2, this.oTz);
            aVar.e(3, 8, this.MLd);
            AppMethodBeat.o(155450);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LPy) + 0 + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.MLd);
            AppMethodBeat.o(155450);
            return bu;
        } else if (i2 == 2) {
            this.MLd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155450);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgl dgl = (dgl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dgl.LPy = aVar3.UbS.zi();
                    AppMethodBeat.o(155450);
                    return 0;
                case 2:
                    dgl.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(155450);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dgk dgk = new dgk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dgk.populateBuilderWithField(aVar4, dgk, a.getNextFieldNumber(aVar4))) {
                        }
                        dgl.MLd.add(dgk);
                    }
                    AppMethodBeat.o(155450);
                    return 0;
                default:
                    AppMethodBeat.o(155450);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155450);
            return -1;
        }
    }
}
