package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ffi extends a {
    public int NAD;
    public String NAE;
    public String xNS;
    public String xNU;
    public String xNV;
    public int xNW;
    public String xuc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152730);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NAD);
            if (this.xuc != null) {
                aVar.e(2, this.xuc);
            }
            if (this.xNS != null) {
                aVar.e(3, this.xNS);
            }
            if (this.NAE != null) {
                aVar.e(4, this.NAE);
            }
            if (this.xNU != null) {
                aVar.e(5, this.xNU);
            }
            if (this.xNV != null) {
                aVar.e(6, this.xNV);
            }
            aVar.aM(7, this.xNW);
            AppMethodBeat.o(152730);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NAD) + 0;
            if (this.xuc != null) {
                bu += g.a.a.b.b.a.f(2, this.xuc);
            }
            if (this.xNS != null) {
                bu += g.a.a.b.b.a.f(3, this.xNS);
            }
            if (this.NAE != null) {
                bu += g.a.a.b.b.a.f(4, this.NAE);
            }
            if (this.xNU != null) {
                bu += g.a.a.b.b.a.f(5, this.xNU);
            }
            if (this.xNV != null) {
                bu += g.a.a.b.b.a.f(6, this.xNV);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.xNW);
            AppMethodBeat.o(152730);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152730);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffi ffi = (ffi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ffi.NAD = aVar3.UbS.zi();
                    AppMethodBeat.o(152730);
                    return 0;
                case 2:
                    ffi.xuc = aVar3.UbS.readString();
                    AppMethodBeat.o(152730);
                    return 0;
                case 3:
                    ffi.xNS = aVar3.UbS.readString();
                    AppMethodBeat.o(152730);
                    return 0;
                case 4:
                    ffi.NAE = aVar3.UbS.readString();
                    AppMethodBeat.o(152730);
                    return 0;
                case 5:
                    ffi.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(152730);
                    return 0;
                case 6:
                    ffi.xNV = aVar3.UbS.readString();
                    AppMethodBeat.o(152730);
                    return 0;
                case 7:
                    ffi.xNW = aVar3.UbS.zi();
                    AppMethodBeat.o(152730);
                    return 0;
                default:
                    AppMethodBeat.o(152730);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152730);
            return -1;
        }
    }
}
