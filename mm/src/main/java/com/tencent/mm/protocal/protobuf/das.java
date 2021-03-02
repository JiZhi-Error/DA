package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class das extends dop {
    public int KCx;
    public int LbX;
    public bf Lcc;
    public String MFU;
    public String MFV;
    public b MFW;
    public int MFX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91598);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MFU != null) {
                aVar.e(2, this.MFU);
            }
            if (this.MFV != null) {
                aVar.e(3, this.MFV);
            }
            if (this.MFW != null) {
                aVar.c(4, this.MFW);
            }
            aVar.aM(5, this.LbX);
            aVar.aM(6, this.KCx);
            aVar.aM(7, this.MFX);
            if (this.Lcc != null) {
                aVar.ni(8, this.Lcc.computeSize());
                this.Lcc.writeFields(aVar);
            }
            AppMethodBeat.o(91598);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MFU != null) {
                nh += g.a.a.b.b.a.f(2, this.MFU);
            }
            if (this.MFV != null) {
                nh += g.a.a.b.b.a.f(3, this.MFV);
            }
            if (this.MFW != null) {
                nh += g.a.a.b.b.a.b(4, this.MFW);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.LbX) + g.a.a.b.b.a.bu(6, this.KCx) + g.a.a.b.b.a.bu(7, this.MFX);
            if (this.Lcc != null) {
                bu += g.a.a.a.nh(8, this.Lcc.computeSize());
            }
            AppMethodBeat.o(91598);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91598);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            das das = (das) objArr[1];
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
                        das.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91598);
                    return 0;
                case 2:
                    das.MFU = aVar3.UbS.readString();
                    AppMethodBeat.o(91598);
                    return 0;
                case 3:
                    das.MFV = aVar3.UbS.readString();
                    AppMethodBeat.o(91598);
                    return 0;
                case 4:
                    das.MFW = aVar3.UbS.hPo();
                    AppMethodBeat.o(91598);
                    return 0;
                case 5:
                    das.LbX = aVar3.UbS.zi();
                    AppMethodBeat.o(91598);
                    return 0;
                case 6:
                    das.KCx = aVar3.UbS.zi();
                    AppMethodBeat.o(91598);
                    return 0;
                case 7:
                    das.MFX = aVar3.UbS.zi();
                    AppMethodBeat.o(91598);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfVar.populateBuilderWithField(aVar5, bfVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        das.Lcc = bfVar;
                    }
                    AppMethodBeat.o(91598);
                    return 0;
                default:
                    AppMethodBeat.o(91598);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91598);
            return -1;
        }
    }
}
