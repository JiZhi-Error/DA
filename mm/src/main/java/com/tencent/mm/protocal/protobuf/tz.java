package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class tz extends a {
    public String LcI;
    public String LcJ;
    public String LcK;
    public int LcL;
    public un LcM;
    public int LcN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113950);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LcI != null) {
                aVar.e(1, this.LcI);
            }
            if (this.LcJ != null) {
                aVar.e(2, this.LcJ);
            }
            if (this.LcK != null) {
                aVar.e(3, this.LcK);
            }
            aVar.aM(4, this.LcL);
            if (this.LcM != null) {
                aVar.ni(5, this.LcM.computeSize());
                this.LcM.writeFields(aVar);
            }
            aVar.aM(6, this.LcN);
            AppMethodBeat.o(113950);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LcI != null ? g.a.a.b.b.a.f(1, this.LcI) + 0 : 0;
            if (this.LcJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.LcJ);
            }
            if (this.LcK != null) {
                f2 += g.a.a.b.b.a.f(3, this.LcK);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.LcL);
            if (this.LcM != null) {
                bu += g.a.a.a.nh(5, this.LcM.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.LcN);
            AppMethodBeat.o(113950);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113950);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tz tzVar = (tz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tzVar.LcI = aVar3.UbS.readString();
                    AppMethodBeat.o(113950);
                    return 0;
                case 2:
                    tzVar.LcJ = aVar3.UbS.readString();
                    AppMethodBeat.o(113950);
                    return 0;
                case 3:
                    tzVar.LcK = aVar3.UbS.readString();
                    AppMethodBeat.o(113950);
                    return 0;
                case 4:
                    tzVar.LcL = aVar3.UbS.zi();
                    AppMethodBeat.o(113950);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        tzVar.LcM = unVar;
                    }
                    AppMethodBeat.o(113950);
                    return 0;
                case 6:
                    tzVar.LcN = aVar3.UbS.zi();
                    AppMethodBeat.o(113950);
                    return 0;
                default:
                    AppMethodBeat.o(113950);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113950);
            return -1;
        }
    }
}
