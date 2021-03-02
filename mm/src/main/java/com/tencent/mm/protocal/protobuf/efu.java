package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class efu extends a {
    public String KNW;
    public int MMP;
    public int NfN;
    public ahg NfO;
    public ahg NfP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91706);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MMP);
            aVar.aM(2, this.NfN);
            if (this.KNW != null) {
                aVar.e(3, this.KNW);
            }
            if (this.NfO != null) {
                aVar.ni(4, this.NfO.computeSize());
                this.NfO.writeFields(aVar);
            }
            if (this.NfP != null) {
                aVar.ni(5, this.NfP.computeSize());
                this.NfP.writeFields(aVar);
            }
            AppMethodBeat.o(91706);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MMP) + 0 + g.a.a.b.b.a.bu(2, this.NfN);
            if (this.KNW != null) {
                bu += g.a.a.b.b.a.f(3, this.KNW);
            }
            if (this.NfO != null) {
                bu += g.a.a.a.nh(4, this.NfO.computeSize());
            }
            if (this.NfP != null) {
                bu += g.a.a.a.nh(5, this.NfP.computeSize());
            }
            AppMethodBeat.o(91706);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91706);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efu efu = (efu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    efu.MMP = aVar3.UbS.zi();
                    AppMethodBeat.o(91706);
                    return 0;
                case 2:
                    efu.NfN = aVar3.UbS.zi();
                    AppMethodBeat.o(91706);
                    return 0;
                case 3:
                    efu.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91706);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahg ahg = new ahg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahg.populateBuilderWithField(aVar4, ahg, a.getNextFieldNumber(aVar4))) {
                        }
                        efu.NfO = ahg;
                    }
                    AppMethodBeat.o(91706);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahg ahg2 = new ahg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahg2.populateBuilderWithField(aVar5, ahg2, a.getNextFieldNumber(aVar5))) {
                        }
                        efu.NfP = ahg2;
                    }
                    AppMethodBeat.o(91706);
                    return 0;
                default:
                    AppMethodBeat.o(91706);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91706);
            return -1;
        }
    }
}
