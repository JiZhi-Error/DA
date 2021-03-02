package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class qy extends a {
    public int KXN;
    public int KXO;
    public int KXP;
    public LinkedList<qx> KXQ = new LinkedList<>();
    public LinkedList<qx> KXR = new LinkedList<>();

    public qy() {
        AppMethodBeat.i(133159);
        AppMethodBeat.o(133159);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133160);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KXN);
            aVar.aM(2, this.KXO);
            aVar.aM(5, this.KXP);
            aVar.e(3, 8, this.KXQ);
            aVar.e(4, 8, this.KXR);
            AppMethodBeat.o(133160);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KXN) + 0 + g.a.a.b.b.a.bu(2, this.KXO) + g.a.a.b.b.a.bu(5, this.KXP) + g.a.a.a.c(3, 8, this.KXQ) + g.a.a.a.c(4, 8, this.KXR);
            AppMethodBeat.o(133160);
            return bu;
        } else if (i2 == 2) {
            this.KXQ.clear();
            this.KXR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133160);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qy qyVar = (qy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qyVar.KXN = aVar3.UbS.zi();
                    AppMethodBeat.o(133160);
                    return 0;
                case 2:
                    qyVar.KXO = aVar3.UbS.zi();
                    AppMethodBeat.o(133160);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        qx qxVar = new qx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = qxVar.populateBuilderWithField(aVar4, qxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        qyVar.KXQ.add(qxVar);
                    }
                    AppMethodBeat.o(133160);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        qx qxVar2 = new qx();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = qxVar2.populateBuilderWithField(aVar5, qxVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        qyVar.KXR.add(qxVar2);
                    }
                    AppMethodBeat.o(133160);
                    return 0;
                case 5:
                    qyVar.KXP = aVar3.UbS.zi();
                    AppMethodBeat.o(133160);
                    return 0;
                default:
                    AppMethodBeat.o(133160);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133160);
            return -1;
        }
    }
}
