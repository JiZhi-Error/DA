package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ag extends dop {
    public int KCO;
    public ahc KCP;
    public int KCQ;
    public LinkedList<ei> KCw = new LinkedList<>();

    public ag() {
        AppMethodBeat.i(32098);
        AppMethodBeat.o(32098);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32099);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KCO);
            aVar.e(3, 8, this.KCw);
            if (this.KCP != null) {
                aVar.ni(4, this.KCP.computeSize());
                this.KCP.writeFields(aVar);
            }
            aVar.aM(5, this.KCQ);
            AppMethodBeat.o(32099);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KCO) + g.a.a.a.c(3, 8, this.KCw);
            if (this.KCP != null) {
                nh += g.a.a.a.nh(4, this.KCP.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KCQ);
            AppMethodBeat.o(32099);
            return bu;
        } else if (i2 == 2) {
            this.KCw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32099);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        agVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32099);
                    return 0;
                case 2:
                    agVar.KCO = aVar3.UbS.zi();
                    AppMethodBeat.o(32099);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ei eiVar = new ei();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eiVar.populateBuilderWithField(aVar5, eiVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        agVar.KCw.add(eiVar);
                    }
                    AppMethodBeat.o(32099);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ahc ahc = new ahc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ahc.populateBuilderWithField(aVar6, ahc, dop.getNextFieldNumber(aVar6))) {
                        }
                        agVar.KCP = ahc;
                    }
                    AppMethodBeat.o(32099);
                    return 0;
                case 5:
                    agVar.KCQ = aVar3.UbS.zi();
                    AppMethodBeat.o(32099);
                    return 0;
                default:
                    AppMethodBeat.o(32099);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32099);
            return -1;
        }
    }
}
