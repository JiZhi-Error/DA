package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class er extends a {
    public String xJL;
    public String xNS;
    public String xNT;
    public String xNU;
    public String xNV;
    public int xNW;
    public String xNX;
    public String xNY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41848);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJL != null) {
                aVar.e(1, this.xJL);
            }
            if (this.xNS != null) {
                aVar.e(2, this.xNS);
            }
            if (this.xNT != null) {
                aVar.e(3, this.xNT);
            }
            if (this.xNU != null) {
                aVar.e(4, this.xNU);
            }
            if (this.xNV != null) {
                aVar.e(5, this.xNV);
            }
            aVar.aM(6, this.xNW);
            if (this.xNX != null) {
                aVar.e(7, this.xNX);
            }
            if (this.xNY != null) {
                aVar.e(8, this.xNY);
            }
            AppMethodBeat.o(41848);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xJL != null ? g.a.a.b.b.a.f(1, this.xJL) + 0 : 0;
            if (this.xNS != null) {
                f2 += g.a.a.b.b.a.f(2, this.xNS);
            }
            if (this.xNT != null) {
                f2 += g.a.a.b.b.a.f(3, this.xNT);
            }
            if (this.xNU != null) {
                f2 += g.a.a.b.b.a.f(4, this.xNU);
            }
            if (this.xNV != null) {
                f2 += g.a.a.b.b.a.f(5, this.xNV);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.xNW);
            if (this.xNX != null) {
                bu += g.a.a.b.b.a.f(7, this.xNX);
            }
            if (this.xNY != null) {
                bu += g.a.a.b.b.a.f(8, this.xNY);
            }
            AppMethodBeat.o(41848);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41848);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            er erVar = (er) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    erVar.xJL = aVar3.UbS.readString();
                    AppMethodBeat.o(41848);
                    return 0;
                case 2:
                    erVar.xNS = aVar3.UbS.readString();
                    AppMethodBeat.o(41848);
                    return 0;
                case 3:
                    erVar.xNT = aVar3.UbS.readString();
                    AppMethodBeat.o(41848);
                    return 0;
                case 4:
                    erVar.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(41848);
                    return 0;
                case 5:
                    erVar.xNV = aVar3.UbS.readString();
                    AppMethodBeat.o(41848);
                    return 0;
                case 6:
                    erVar.xNW = aVar3.UbS.zi();
                    AppMethodBeat.o(41848);
                    return 0;
                case 7:
                    erVar.xNX = aVar3.UbS.readString();
                    AppMethodBeat.o(41848);
                    return 0;
                case 8:
                    erVar.xNY = aVar3.UbS.readString();
                    AppMethodBeat.o(41848);
                    return 0;
                default:
                    AppMethodBeat.o(41848);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41848);
            return -1;
        }
    }
}
