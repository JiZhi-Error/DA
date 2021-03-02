package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class auz extends a {
    public String LFM;
    public awd LFN;
    public int LFO;
    public String LFP;
    public int LFQ;
    public int LFR;
    public String content;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209492);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LFM != null) {
                aVar.e(1, this.LFM);
            }
            aVar.aM(2, this.LFQ);
            aVar.aM(3, this.LFR);
            if (this.LFN != null) {
                aVar.ni(4, this.LFN.computeSize());
                this.LFN.writeFields(aVar);
            }
            if (this.content != null) {
                aVar.e(5, this.content);
            }
            aVar.aM(6, this.LFO);
            if (this.LFP != null) {
                aVar.e(7, this.LFP);
            }
            AppMethodBeat.o(209492);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LFM != null ? g.a.a.b.b.a.f(1, this.LFM) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LFQ) + g.a.a.b.b.a.bu(3, this.LFR);
            if (this.LFN != null) {
                f2 += g.a.a.a.nh(4, this.LFN.computeSize());
            }
            if (this.content != null) {
                f2 += g.a.a.b.b.a.f(5, this.content);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.LFO);
            if (this.LFP != null) {
                bu += g.a.a.b.b.a.f(7, this.LFP);
            }
            AppMethodBeat.o(209492);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209492);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            auz auz = (auz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    auz.LFM = aVar3.UbS.readString();
                    AppMethodBeat.o(209492);
                    return 0;
                case 2:
                    auz.LFQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209492);
                    return 0;
                case 3:
                    auz.LFR = aVar3.UbS.zi();
                    AppMethodBeat.o(209492);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        awd awd = new awd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = awd.populateBuilderWithField(aVar4, awd, a.getNextFieldNumber(aVar4))) {
                        }
                        auz.LFN = awd;
                    }
                    AppMethodBeat.o(209492);
                    return 0;
                case 5:
                    auz.content = aVar3.UbS.readString();
                    AppMethodBeat.o(209492);
                    return 0;
                case 6:
                    auz.LFO = aVar3.UbS.zi();
                    AppMethodBeat.o(209492);
                    return 0;
                case 7:
                    auz.LFP = aVar3.UbS.readString();
                    AppMethodBeat.o(209492);
                    return 0;
                default:
                    AppMethodBeat.o(209492);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209492);
            return -1;
        }
    }
}
