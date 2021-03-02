package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class acl extends a {
    public String Hwr;
    public String LmX;
    public String LmY;
    public String pTL;
    public int uSc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200196);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LmX != null) {
                aVar.e(1, this.LmX);
            }
            if (this.LmY != null) {
                aVar.e(2, this.LmY);
            }
            aVar.aM(3, this.uSc);
            if (this.pTL != null) {
                aVar.e(4, this.pTL);
            }
            if (this.Hwr != null) {
                aVar.e(5, this.Hwr);
            }
            AppMethodBeat.o(200196);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LmX != null ? g.a.a.b.b.a.f(1, this.LmX) + 0 : 0;
            if (this.LmY != null) {
                f2 += g.a.a.b.b.a.f(2, this.LmY);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.uSc);
            if (this.pTL != null) {
                bu += g.a.a.b.b.a.f(4, this.pTL);
            }
            if (this.Hwr != null) {
                bu += g.a.a.b.b.a.f(5, this.Hwr);
            }
            AppMethodBeat.o(200196);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200196);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acl acl = (acl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acl.LmX = aVar3.UbS.readString();
                    AppMethodBeat.o(200196);
                    return 0;
                case 2:
                    acl.LmY = aVar3.UbS.readString();
                    AppMethodBeat.o(200196);
                    return 0;
                case 3:
                    acl.uSc = aVar3.UbS.zi();
                    AppMethodBeat.o(200196);
                    return 0;
                case 4:
                    acl.pTL = aVar3.UbS.readString();
                    AppMethodBeat.o(200196);
                    return 0;
                case 5:
                    acl.Hwr = aVar3.UbS.readString();
                    AppMethodBeat.o(200196);
                    return 0;
                default:
                    AppMethodBeat.o(200196);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200196);
            return -1;
        }
    }
}
