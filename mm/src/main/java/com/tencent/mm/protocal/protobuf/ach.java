package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ach extends a {
    public crq LmQ;
    public boolean LmR;
    public String sGQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208701);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LmQ != null) {
                aVar.ni(1, this.LmQ.computeSize());
                this.LmQ.writeFields(aVar);
            }
            if (this.sGQ != null) {
                aVar.e(2, this.sGQ);
            }
            aVar.cc(3, this.LmR);
            AppMethodBeat.o(208701);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LmQ != null ? g.a.a.a.nh(1, this.LmQ.computeSize()) + 0 : 0;
            if (this.sGQ != null) {
                nh += g.a.a.b.b.a.f(2, this.sGQ);
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(208701);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208701);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ach ach = (ach) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        crq crq = new crq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = crq.populateBuilderWithField(aVar4, crq, a.getNextFieldNumber(aVar4))) {
                        }
                        ach.LmQ = crq;
                    }
                    AppMethodBeat.o(208701);
                    return 0;
                case 2:
                    ach.sGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(208701);
                    return 0;
                case 3:
                    ach.LmR = aVar3.UbS.yZ();
                    AppMethodBeat.o(208701);
                    return 0;
                default:
                    AppMethodBeat.o(208701);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208701);
            return -1;
        }
    }
}
