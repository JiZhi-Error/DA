package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbf extends a {
    public String MgT;
    public String MgU;
    public String MgV;
    public String MgW;
    public String MgX;
    public String MgY;
    public String MgZ;
    public String igW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91521);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MgT != null) {
                aVar.e(1, this.MgT);
            }
            if (this.MgU != null) {
                aVar.e(2, this.MgU);
            }
            if (this.igW != null) {
                aVar.e(3, this.igW);
            }
            if (this.MgV != null) {
                aVar.e(4, this.MgV);
            }
            if (this.MgW != null) {
                aVar.e(5, this.MgW);
            }
            if (this.MgX != null) {
                aVar.e(6, this.MgX);
            }
            if (this.MgY != null) {
                aVar.e(7, this.MgY);
            }
            if (this.MgZ != null) {
                aVar.e(8, this.MgZ);
            }
            AppMethodBeat.o(91521);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MgT != null ? g.a.a.b.b.a.f(1, this.MgT) + 0 : 0;
            if (this.MgU != null) {
                f2 += g.a.a.b.b.a.f(2, this.MgU);
            }
            if (this.igW != null) {
                f2 += g.a.a.b.b.a.f(3, this.igW);
            }
            if (this.MgV != null) {
                f2 += g.a.a.b.b.a.f(4, this.MgV);
            }
            if (this.MgW != null) {
                f2 += g.a.a.b.b.a.f(5, this.MgW);
            }
            if (this.MgX != null) {
                f2 += g.a.a.b.b.a.f(6, this.MgX);
            }
            if (this.MgY != null) {
                f2 += g.a.a.b.b.a.f(7, this.MgY);
            }
            if (this.MgZ != null) {
                f2 += g.a.a.b.b.a.f(8, this.MgZ);
            }
            AppMethodBeat.o(91521);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91521);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbf cbf = (cbf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbf.MgT = aVar3.UbS.readString();
                    AppMethodBeat.o(91521);
                    return 0;
                case 2:
                    cbf.MgU = aVar3.UbS.readString();
                    AppMethodBeat.o(91521);
                    return 0;
                case 3:
                    cbf.igW = aVar3.UbS.readString();
                    AppMethodBeat.o(91521);
                    return 0;
                case 4:
                    cbf.MgV = aVar3.UbS.readString();
                    AppMethodBeat.o(91521);
                    return 0;
                case 5:
                    cbf.MgW = aVar3.UbS.readString();
                    AppMethodBeat.o(91521);
                    return 0;
                case 6:
                    cbf.MgX = aVar3.UbS.readString();
                    AppMethodBeat.o(91521);
                    return 0;
                case 7:
                    cbf.MgY = aVar3.UbS.readString();
                    AppMethodBeat.o(91521);
                    return 0;
                case 8:
                    cbf.MgZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91521);
                    return 0;
                default:
                    AppMethodBeat.o(91521);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91521);
            return -1;
        }
    }
}
