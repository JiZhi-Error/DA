package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ahe extends a {
    public int LqP;
    public ahb LqQ;
    public ahb LqR;
    public int LqS;
    public int LqT;
    public int LqU;
    public int LqV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90966);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LqP);
            if (this.LqQ != null) {
                aVar.ni(2, this.LqQ.computeSize());
                this.LqQ.writeFields(aVar);
            }
            if (this.LqR != null) {
                aVar.ni(3, this.LqR.computeSize());
                this.LqR.writeFields(aVar);
            }
            aVar.aM(4, this.LqS);
            aVar.aM(5, this.LqT);
            aVar.aM(6, this.LqU);
            aVar.aM(7, this.LqV);
            AppMethodBeat.o(90966);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LqP) + 0;
            if (this.LqQ != null) {
                bu += g.a.a.a.nh(2, this.LqQ.computeSize());
            }
            if (this.LqR != null) {
                bu += g.a.a.a.nh(3, this.LqR.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.LqS) + g.a.a.b.b.a.bu(5, this.LqT) + g.a.a.b.b.a.bu(6, this.LqU) + g.a.a.b.b.a.bu(7, this.LqV);
            AppMethodBeat.o(90966);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90966);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahe ahe = (ahe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahe.LqP = aVar3.UbS.zi();
                    AppMethodBeat.o(90966);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahb ahb = new ahb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahb.populateBuilderWithField(aVar4, ahb, a.getNextFieldNumber(aVar4))) {
                        }
                        ahe.LqQ = ahb;
                    }
                    AppMethodBeat.o(90966);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahb ahb2 = new ahb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahb2.populateBuilderWithField(aVar5, ahb2, a.getNextFieldNumber(aVar5))) {
                        }
                        ahe.LqR = ahb2;
                    }
                    AppMethodBeat.o(90966);
                    return 0;
                case 4:
                    ahe.LqS = aVar3.UbS.zi();
                    AppMethodBeat.o(90966);
                    return 0;
                case 5:
                    ahe.LqT = aVar3.UbS.zi();
                    AppMethodBeat.o(90966);
                    return 0;
                case 6:
                    ahe.LqU = aVar3.UbS.zi();
                    AppMethodBeat.o(90966);
                    return 0;
                case 7:
                    ahe.LqV = aVar3.UbS.zi();
                    AppMethodBeat.o(90966);
                    return 0;
                default:
                    AppMethodBeat.o(90966);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90966);
            return -1;
        }
    }
}
