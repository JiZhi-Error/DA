package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aqv extends a {
    public int continueFlag;
    public String dQx;
    public b lastBuffer;
    public LinkedList<FinderObject> tbD = new LinkedList<>();

    public aqv() {
        AppMethodBeat.i(209383);
        AppMethodBeat.o(209383);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209384);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.tbD);
            if (this.lastBuffer != null) {
                aVar.c(2, this.lastBuffer);
            }
            aVar.aM(3, this.continueFlag);
            if (this.dQx != null) {
                aVar.e(4, this.dQx);
            }
            AppMethodBeat.o(209384);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.tbD) + 0;
            if (this.lastBuffer != null) {
                c2 += g.a.a.b.b.a.b(2, this.lastBuffer);
            }
            int bu = c2 + g.a.a.b.b.a.bu(3, this.continueFlag);
            if (this.dQx != null) {
                bu += g.a.a.b.b.a.f(4, this.dQx);
            }
            AppMethodBeat.o(209384);
            return bu;
        } else if (i2 == 2) {
            this.tbD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209384);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqv aqv = (aqv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderObject.populateBuilderWithField(aVar4, finderObject, a.getNextFieldNumber(aVar4))) {
                        }
                        aqv.tbD.add(finderObject);
                    }
                    AppMethodBeat.o(209384);
                    return 0;
                case 2:
                    aqv.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209384);
                    return 0;
                case 3:
                    aqv.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209384);
                    return 0;
                case 4:
                    aqv.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(209384);
                    return 0;
                default:
                    AppMethodBeat.o(209384);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209384);
            return -1;
        }
    }
}
