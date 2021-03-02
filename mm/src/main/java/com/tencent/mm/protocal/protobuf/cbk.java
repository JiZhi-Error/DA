package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cbk extends a {
    public LinkedList<cbj> Mhm = new LinkedList<>();
    public int bwA = -1;

    public cbk() {
        AppMethodBeat.i(122508);
        AppMethodBeat.o(122508);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122509);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Mhm);
            aVar.aM(2, this.bwA);
            AppMethodBeat.o(122509);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Mhm) + 0 + g.a.a.b.b.a.bu(2, this.bwA);
            AppMethodBeat.o(122509);
            return c2;
        } else if (i2 == 2) {
            this.Mhm.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122509);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbk cbk = (cbk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cbj cbj = new cbj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cbj.populateBuilderWithField(aVar4, cbj, a.getNextFieldNumber(aVar4))) {
                        }
                        cbk.Mhm.add(cbj);
                    }
                    AppMethodBeat.o(122509);
                    return 0;
                case 2:
                    cbk.bwA = aVar3.UbS.zi();
                    AppMethodBeat.o(122509);
                    return 0;
                default:
                    AppMethodBeat.o(122509);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122509);
            return -1;
        }
    }
}
