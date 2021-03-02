package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bem extends a {
    public int LBF;
    public int LBG;
    public bbi LNi;
    public int LOh;
    public int LOi;
    public int LOj;
    public int LOk;
    public int count;
    public String iAR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169077);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.count);
            aVar.aM(2, this.LBF);
            aVar.aM(3, this.LBG);
            aVar.aM(4, this.LOh);
            if (this.iAR != null) {
                aVar.e(5, this.iAR);
            }
            if (this.LNi != null) {
                aVar.ni(6, this.LNi.computeSize());
                this.LNi.writeFields(aVar);
            }
            aVar.aM(7, this.LOi);
            aVar.aM(8, this.LOj);
            aVar.aM(9, this.LOk);
            AppMethodBeat.o(169077);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.count) + 0 + g.a.a.b.b.a.bu(2, this.LBF) + g.a.a.b.b.a.bu(3, this.LBG) + g.a.a.b.b.a.bu(4, this.LOh);
            if (this.iAR != null) {
                bu += g.a.a.b.b.a.f(5, this.iAR);
            }
            if (this.LNi != null) {
                bu += g.a.a.a.nh(6, this.LNi.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.LOi) + g.a.a.b.b.a.bu(8, this.LOj) + g.a.a.b.b.a.bu(9, this.LOk);
            AppMethodBeat.o(169077);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169077);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bem bem = (bem) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bem.count = aVar3.UbS.zi();
                    AppMethodBeat.o(169077);
                    return 0;
                case 2:
                    bem.LBF = aVar3.UbS.zi();
                    AppMethodBeat.o(169077);
                    return 0;
                case 3:
                    bem.LBG = aVar3.UbS.zi();
                    AppMethodBeat.o(169077);
                    return 0;
                case 4:
                    bem.LOh = aVar3.UbS.zi();
                    AppMethodBeat.o(169077);
                    return 0;
                case 5:
                    bem.iAR = aVar3.UbS.readString();
                    AppMethodBeat.o(169077);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bbi bbi = new bbi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bbi.populateBuilderWithField(aVar4, bbi, a.getNextFieldNumber(aVar4))) {
                        }
                        bem.LNi = bbi;
                    }
                    AppMethodBeat.o(169077);
                    return 0;
                case 7:
                    bem.LOi = aVar3.UbS.zi();
                    AppMethodBeat.o(169077);
                    return 0;
                case 8:
                    bem.LOj = aVar3.UbS.zi();
                    AppMethodBeat.o(169077);
                    return 0;
                case 9:
                    bem.LOk = aVar3.UbS.zi();
                    AppMethodBeat.o(169077);
                    return 0;
                default:
                    AppMethodBeat.o(169077);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169077);
            return -1;
        }
    }
}
