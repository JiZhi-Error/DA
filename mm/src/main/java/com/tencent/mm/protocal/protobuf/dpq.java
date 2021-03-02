package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dpq extends a {
    public dqe KEP;
    public String KNW;
    public ehf Lov;
    public int MSP;
    public int MSQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91674);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MSP);
            aVar.aM(2, this.MSQ);
            if (this.KEP != null) {
                aVar.ni(3, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            if (this.Lov != null) {
                aVar.ni(4, this.Lov.computeSize());
                this.Lov.writeFields(aVar);
            }
            if (this.KNW != null) {
                aVar.e(5, this.KNW);
            }
            AppMethodBeat.o(91674);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MSP) + 0 + g.a.a.b.b.a.bu(2, this.MSQ);
            if (this.KEP != null) {
                bu += g.a.a.a.nh(3, this.KEP.computeSize());
            }
            if (this.Lov != null) {
                bu += g.a.a.a.nh(4, this.Lov.computeSize());
            }
            if (this.KNW != null) {
                bu += g.a.a.b.b.a.f(5, this.KNW);
            }
            AppMethodBeat.o(91674);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91674);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dpq dpq = (dpq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dpq.MSP = aVar3.UbS.zi();
                    AppMethodBeat.o(91674);
                    return 0;
                case 2:
                    dpq.MSQ = aVar3.UbS.zi();
                    AppMethodBeat.o(91674);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqe.populateBuilderWithField(aVar4, dqe, a.getNextFieldNumber(aVar4))) {
                        }
                        dpq.KEP = dqe;
                    }
                    AppMethodBeat.o(91674);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehf.populateBuilderWithField(aVar5, ehf, a.getNextFieldNumber(aVar5))) {
                        }
                        dpq.Lov = ehf;
                    }
                    AppMethodBeat.o(91674);
                    return 0;
                case 5:
                    dpq.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91674);
                    return 0;
                default:
                    AppMethodBeat.o(91674);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91674);
            return -1;
        }
    }
}
