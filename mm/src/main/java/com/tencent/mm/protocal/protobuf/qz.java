package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class qz extends dop {
    public String CpJ;
    public String KHM;
    public String KHN;
    public String KHO;
    public int KHQ;
    public b KXS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91365);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KHM != null) {
                aVar.e(2, this.KHM);
            }
            if (this.KHN != null) {
                aVar.e(3, this.KHN);
            }
            if (this.CpJ != null) {
                aVar.e(4, this.CpJ);
            }
            aVar.aM(5, this.KHQ);
            if (this.KXS != null) {
                aVar.c(6, this.KXS);
            }
            if (this.KHO != null) {
                aVar.e(7, this.KHO);
            }
            AppMethodBeat.o(91365);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KHM != null) {
                nh += g.a.a.b.b.a.f(2, this.KHM);
            }
            if (this.KHN != null) {
                nh += g.a.a.b.b.a.f(3, this.KHN);
            }
            if (this.CpJ != null) {
                nh += g.a.a.b.b.a.f(4, this.CpJ);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KHQ);
            if (this.KXS != null) {
                bu += g.a.a.b.b.a.b(6, this.KXS);
            }
            if (this.KHO != null) {
                bu += g.a.a.b.b.a.f(7, this.KHO);
            }
            AppMethodBeat.o(91365);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91365);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qz qzVar = (qz) objArr[1];
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
                        qzVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91365);
                    return 0;
                case 2:
                    qzVar.KHM = aVar3.UbS.readString();
                    AppMethodBeat.o(91365);
                    return 0;
                case 3:
                    qzVar.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(91365);
                    return 0;
                case 4:
                    qzVar.CpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91365);
                    return 0;
                case 5:
                    qzVar.KHQ = aVar3.UbS.zi();
                    AppMethodBeat.o(91365);
                    return 0;
                case 6:
                    qzVar.KXS = aVar3.UbS.hPo();
                    AppMethodBeat.o(91365);
                    return 0;
                case 7:
                    qzVar.KHO = aVar3.UbS.readString();
                    AppMethodBeat.o(91365);
                    return 0;
                default:
                    AppMethodBeat.o(91365);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91365);
            return -1;
        }
    }
}
