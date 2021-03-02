package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class c extends a {
    public int KAB;
    public int KAC;
    public o KAD;
    public o KAE;
    public int KAF;
    public int KAG;
    public int ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143942);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.ret);
            aVar.aM(2, this.KAB);
            aVar.aM(3, this.KAC);
            if (this.KAD != null) {
                aVar.ni(4, this.KAD.computeSize());
                this.KAD.writeFields(aVar);
            }
            if (this.KAE != null) {
                aVar.ni(5, this.KAE.computeSize());
                this.KAE.writeFields(aVar);
            }
            aVar.aM(6, this.KAF);
            aVar.aM(7, this.KAG);
            AppMethodBeat.o(143942);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.ret) + 0 + g.a.a.b.b.a.bu(2, this.KAB) + g.a.a.b.b.a.bu(3, this.KAC);
            if (this.KAD != null) {
                bu += g.a.a.a.nh(4, this.KAD.computeSize());
            }
            if (this.KAE != null) {
                bu += g.a.a.a.nh(5, this.KAE.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.KAF) + g.a.a.b.b.a.bu(7, this.KAG);
            AppMethodBeat.o(143942);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143942);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.ret = aVar3.UbS.zi();
                    AppMethodBeat.o(143942);
                    return 0;
                case 2:
                    cVar.KAB = aVar3.UbS.zi();
                    AppMethodBeat.o(143942);
                    return 0;
                case 3:
                    cVar.KAC = aVar3.UbS.zi();
                    AppMethodBeat.o(143942);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        o oVar = new o();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.KAD = oVar;
                    }
                    AppMethodBeat.o(143942);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        o oVar2 = new o();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = oVar2.populateBuilderWithField(aVar5, oVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        cVar.KAE = oVar2;
                    }
                    AppMethodBeat.o(143942);
                    return 0;
                case 6:
                    cVar.KAF = aVar3.UbS.zi();
                    AppMethodBeat.o(143942);
                    return 0;
                case 7:
                    cVar.KAG = aVar3.UbS.zi();
                    AppMethodBeat.o(143942);
                    return 0;
                default:
                    AppMethodBeat.o(143942);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143942);
            return -1;
        }
    }
}
