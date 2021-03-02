package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class djv extends a {
    public aen MNM;
    public boolean MNN;
    public boolean MNO;
    public boolean MNP;
    public boolean MNQ;
    public boolean MNR;
    public boolean MNS;
    public boolean MNT;
    public boolean MNU;
    public boolean MNV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91659);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MNM != null) {
                aVar.ni(1, this.MNM.computeSize());
                this.MNM.writeFields(aVar);
            }
            aVar.cc(2, this.MNN);
            aVar.cc(3, this.MNO);
            aVar.cc(4, this.MNP);
            aVar.cc(5, this.MNQ);
            aVar.cc(6, this.MNR);
            aVar.cc(7, this.MNS);
            aVar.cc(8, this.MNT);
            aVar.cc(9, this.MNU);
            aVar.cc(10, this.MNV);
            AppMethodBeat.o(91659);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.MNM != null ? g.a.a.a.nh(1, this.MNM.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.fS(9) + 1 + g.a.a.b.b.a.fS(10) + 1;
            AppMethodBeat.o(91659);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91659);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            djv djv = (djv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aen aen = new aen();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aen.populateBuilderWithField(aVar4, aen, a.getNextFieldNumber(aVar4))) {
                        }
                        djv.MNM = aen;
                    }
                    AppMethodBeat.o(91659);
                    return 0;
                case 2:
                    djv.MNN = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                case 3:
                    djv.MNO = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                case 4:
                    djv.MNP = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                case 5:
                    djv.MNQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                case 6:
                    djv.MNR = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                case 7:
                    djv.MNS = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                case 8:
                    djv.MNT = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                case 9:
                    djv.MNU = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                case 10:
                    djv.MNV = aVar3.UbS.yZ();
                    AppMethodBeat.o(91659);
                    return 0;
                default:
                    AppMethodBeat.o(91659);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91659);
            return -1;
        }
    }
}
