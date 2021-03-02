package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aop extends a {
    public bei LAL;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209330);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.LAL != null) {
                aVar.ni(2, this.LAL.computeSize());
                this.LAL.writeFields(aVar);
            }
            AppMethodBeat.o(209330);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.LAL != null) {
                bu += g.a.a.a.nh(2, this.LAL.computeSize());
            }
            AppMethodBeat.o(209330);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209330);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aop aop = (aop) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aop.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209330);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bei bei = new bei();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bei.populateBuilderWithField(aVar4, bei, a.getNextFieldNumber(aVar4))) {
                        }
                        aop.LAL = bei;
                    }
                    AppMethodBeat.o(209330);
                    return 0;
                default:
                    AppMethodBeat.o(209330);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209330);
            return -1;
        }
    }
}
