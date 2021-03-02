package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cyq extends a {
    public String MDE;
    public String MDF;
    public String MDG;
    public String MDH;
    public un MDI;
    public String MDJ;
    public int MtC;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114049);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MDE != null) {
                aVar.e(1, this.MDE);
            }
            if (this.MDF != null) {
                aVar.e(2, this.MDF);
            }
            if (this.MDG != null) {
                aVar.e(3, this.MDG);
            }
            aVar.aM(4, this.MtC);
            if (this.MDH != null) {
                aVar.e(5, this.MDH);
            }
            if (this.MDI != null) {
                aVar.ni(6, this.MDI.computeSize());
                this.MDI.writeFields(aVar);
            }
            if (this.MDJ != null) {
                aVar.e(7, this.MDJ);
            }
            AppMethodBeat.o(114049);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MDE != null ? g.a.a.b.b.a.f(1, this.MDE) + 0 : 0;
            if (this.MDF != null) {
                f2 += g.a.a.b.b.a.f(2, this.MDF);
            }
            if (this.MDG != null) {
                f2 += g.a.a.b.b.a.f(3, this.MDG);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.MtC);
            if (this.MDH != null) {
                bu += g.a.a.b.b.a.f(5, this.MDH);
            }
            if (this.MDI != null) {
                bu += g.a.a.a.nh(6, this.MDI.computeSize());
            }
            if (this.MDJ != null) {
                bu += g.a.a.b.b.a.f(7, this.MDJ);
            }
            AppMethodBeat.o(114049);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114049);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyq cyq = (cyq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cyq.MDE = aVar3.UbS.readString();
                    AppMethodBeat.o(114049);
                    return 0;
                case 2:
                    cyq.MDF = aVar3.UbS.readString();
                    AppMethodBeat.o(114049);
                    return 0;
                case 3:
                    cyq.MDG = aVar3.UbS.readString();
                    AppMethodBeat.o(114049);
                    return 0;
                case 4:
                    cyq.MtC = aVar3.UbS.zi();
                    AppMethodBeat.o(114049);
                    return 0;
                case 5:
                    cyq.MDH = aVar3.UbS.readString();
                    AppMethodBeat.o(114049);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cyq.MDI = unVar;
                    }
                    AppMethodBeat.o(114049);
                    return 0;
                case 7:
                    cyq.MDJ = aVar3.UbS.readString();
                    AppMethodBeat.o(114049);
                    return 0;
                default:
                    AppMethodBeat.o(114049);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114049);
            return -1;
        }
    }
}
