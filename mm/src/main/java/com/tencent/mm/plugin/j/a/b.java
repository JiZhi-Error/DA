package com.tencent.mm.plugin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class b extends a {
    public String fuD;
    public String title;
    public String type;
    public int ynP;
    public String ynQ;
    public String ynR;
    public String ynS;
    public String ynT;
    public String ynU;
    public String ynV;
    public String ynW;
    public String ynX;
    public String ynY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(25280);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.ynP);
            if (this.type != null) {
                aVar.e(2, this.type);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.ynQ != null) {
                aVar.e(4, this.ynQ);
            }
            if (this.ynR != null) {
                aVar.e(5, this.ynR);
            }
            if (this.ynS != null) {
                aVar.e(6, this.ynS);
            }
            if (this.ynT != null) {
                aVar.e(7, this.ynT);
            }
            if (this.ynU != null) {
                aVar.e(8, this.ynU);
            }
            if (this.ynV != null) {
                aVar.e(9, this.ynV);
            }
            if (this.ynW != null) {
                aVar.e(10, this.ynW);
            }
            if (this.fuD != null) {
                aVar.e(11, this.fuD);
            }
            if (this.ynX != null) {
                aVar.e(12, this.ynX);
            }
            if (this.ynY != null) {
                aVar.e(13, this.ynY);
            }
            AppMethodBeat.o(25280);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.ynP) + 0;
            if (this.type != null) {
                bu += g.a.a.b.b.a.f(2, this.type);
            }
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.ynQ != null) {
                bu += g.a.a.b.b.a.f(4, this.ynQ);
            }
            if (this.ynR != null) {
                bu += g.a.a.b.b.a.f(5, this.ynR);
            }
            if (this.ynS != null) {
                bu += g.a.a.b.b.a.f(6, this.ynS);
            }
            if (this.ynT != null) {
                bu += g.a.a.b.b.a.f(7, this.ynT);
            }
            if (this.ynU != null) {
                bu += g.a.a.b.b.a.f(8, this.ynU);
            }
            if (this.ynV != null) {
                bu += g.a.a.b.b.a.f(9, this.ynV);
            }
            if (this.ynW != null) {
                bu += g.a.a.b.b.a.f(10, this.ynW);
            }
            if (this.fuD != null) {
                bu += g.a.a.b.b.a.f(11, this.fuD);
            }
            if (this.ynX != null) {
                bu += g.a.a.b.b.a.f(12, this.ynX);
            }
            if (this.ynY != null) {
                bu += g.a.a.b.b.a.f(13, this.ynY);
            }
            AppMethodBeat.o(25280);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(25280);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.ynP = aVar3.UbS.zi();
                    AppMethodBeat.o(25280);
                    return 0;
                case 2:
                    bVar.type = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 3:
                    bVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 4:
                    bVar.ynQ = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 5:
                    bVar.ynR = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 6:
                    bVar.ynS = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 7:
                    bVar.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 8:
                    bVar.ynU = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 9:
                    bVar.ynV = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 10:
                    bVar.ynW = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 11:
                    bVar.fuD = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 12:
                    bVar.ynX = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                case 13:
                    bVar.ynY = aVar3.UbS.readString();
                    AppMethodBeat.o(25280);
                    return 0;
                default:
                    AppMethodBeat.o(25280);
                    return -1;
            }
        } else {
            AppMethodBeat.o(25280);
            return -1;
        }
    }
}
