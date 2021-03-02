package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ben extends a {
    public cbm LOl;
    public int LOm = -1;
    public int LOn = -1;
    public boolean LOo = false;
    public int LOp = -1;
    public int type = -1;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122490);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.LOl != null) {
                aVar.ni(2, this.LOl.computeSize());
                this.LOl.writeFields(aVar);
            }
            aVar.aM(3, this.LOm);
            aVar.aM(4, this.LOn);
            aVar.cc(5, this.LOo);
            aVar.aM(6, this.LOp);
            AppMethodBeat.o(122490);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.LOl != null) {
                bu += g.a.a.a.nh(2, this.LOl.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.LOm) + g.a.a.b.b.a.bu(4, this.LOn) + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.LOp);
            AppMethodBeat.o(122490);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122490);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ben ben = (ben) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ben.type = aVar3.UbS.zi();
                    AppMethodBeat.o(122490);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cbm cbm = new cbm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cbm.populateBuilderWithField(aVar4, cbm, a.getNextFieldNumber(aVar4))) {
                        }
                        ben.LOl = cbm;
                    }
                    AppMethodBeat.o(122490);
                    return 0;
                case 3:
                    ben.LOm = aVar3.UbS.zi();
                    AppMethodBeat.o(122490);
                    return 0;
                case 4:
                    ben.LOn = aVar3.UbS.zi();
                    AppMethodBeat.o(122490);
                    return 0;
                case 5:
                    ben.LOo = aVar3.UbS.yZ();
                    AppMethodBeat.o(122490);
                    return 0;
                case 6:
                    ben.LOp = aVar3.UbS.zi();
                    AppMethodBeat.o(122490);
                    return 0;
                default:
                    AppMethodBeat.o(122490);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122490);
            return -1;
        }
    }
}
