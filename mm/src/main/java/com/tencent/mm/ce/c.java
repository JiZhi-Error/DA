package com.tencent.mm.ce;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class c extends a {
    public int NKP = -1;
    public int NKQ;
    public int bNu;
    public int owH;
    public int owI;
    public int owJ;
    public int size;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104918);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.owH);
            aVar.aM(2, this.owI);
            aVar.aM(3, this.owJ);
            aVar.aM(41, this.NKP);
            aVar.aM(5, this.NKQ);
            aVar.aM(6, this.bNu);
            aVar.aM(7, this.size);
            AppMethodBeat.o(104918);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.owH) + 0 + g.a.a.b.b.a.bu(2, this.owI) + g.a.a.b.b.a.bu(3, this.owJ) + g.a.a.b.b.a.bu(41, this.NKP) + g.a.a.b.b.a.bu(5, this.NKQ) + g.a.a.b.b.a.bu(6, this.bNu) + g.a.a.b.b.a.bu(7, this.size);
            AppMethodBeat.o(104918);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104918);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.owH = aVar3.UbS.zi();
                    AppMethodBeat.o(104918);
                    return 0;
                case 2:
                    cVar.owI = aVar3.UbS.zi();
                    AppMethodBeat.o(104918);
                    return 0;
                case 3:
                    cVar.owJ = aVar3.UbS.zi();
                    AppMethodBeat.o(104918);
                    return 0;
                case 5:
                    cVar.NKQ = aVar3.UbS.zi();
                    AppMethodBeat.o(104918);
                    return 0;
                case 6:
                    cVar.bNu = aVar3.UbS.zi();
                    AppMethodBeat.o(104918);
                    return 0;
                case 7:
                    cVar.size = aVar3.UbS.zi();
                    AppMethodBeat.o(104918);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    cVar.NKP = aVar3.UbS.zi();
                    AppMethodBeat.o(104918);
                    return 0;
                default:
                    AppMethodBeat.o(104918);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104918);
            return -1;
        }
    }
}
