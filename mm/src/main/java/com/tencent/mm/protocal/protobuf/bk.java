package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bk extends a {
    public boolean KES = false;
    public boolean KET = false;
    public boolean KEU = false;
    public boolean KEV = false;
    public String KEW = "";
    public String KEX = "";
    public String KEZ = "";
    public String KFa = "";
    public int KFb = -1;
    public String sII = "";

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122480);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.KES);
            aVar.cc(2, this.KET);
            aVar.cc(3, this.KEU);
            aVar.cc(4, this.KEV);
            if (this.KEW != null) {
                aVar.e(5, this.KEW);
            }
            if (this.KEX != null) {
                aVar.e(6, this.KEX);
            }
            if (this.KEZ != null) {
                aVar.e(7, this.KEZ);
            }
            if (this.KFa != null) {
                aVar.e(8, this.KFa);
            }
            aVar.aM(9, this.KFb);
            if (this.sII != null) {
                aVar.e(10, this.sII);
            }
            AppMethodBeat.o(122480);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1;
            if (this.KEW != null) {
                fS += g.a.a.b.b.a.f(5, this.KEW);
            }
            if (this.KEX != null) {
                fS += g.a.a.b.b.a.f(6, this.KEX);
            }
            if (this.KEZ != null) {
                fS += g.a.a.b.b.a.f(7, this.KEZ);
            }
            if (this.KFa != null) {
                fS += g.a.a.b.b.a.f(8, this.KFa);
            }
            int bu = fS + g.a.a.b.b.a.bu(9, this.KFb);
            if (this.sII != null) {
                bu += g.a.a.b.b.a.f(10, this.sII);
            }
            AppMethodBeat.o(122480);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122480);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bk bkVar = (bk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkVar.KES = aVar3.UbS.yZ();
                    AppMethodBeat.o(122480);
                    return 0;
                case 2:
                    bkVar.KET = aVar3.UbS.yZ();
                    AppMethodBeat.o(122480);
                    return 0;
                case 3:
                    bkVar.KEU = aVar3.UbS.yZ();
                    AppMethodBeat.o(122480);
                    return 0;
                case 4:
                    bkVar.KEV = aVar3.UbS.yZ();
                    AppMethodBeat.o(122480);
                    return 0;
                case 5:
                    bkVar.KEW = aVar3.UbS.readString();
                    AppMethodBeat.o(122480);
                    return 0;
                case 6:
                    bkVar.KEX = aVar3.UbS.readString();
                    AppMethodBeat.o(122480);
                    return 0;
                case 7:
                    bkVar.KEZ = aVar3.UbS.readString();
                    AppMethodBeat.o(122480);
                    return 0;
                case 8:
                    bkVar.KFa = aVar3.UbS.readString();
                    AppMethodBeat.o(122480);
                    return 0;
                case 9:
                    bkVar.KFb = aVar3.UbS.zi();
                    AppMethodBeat.o(122480);
                    return 0;
                case 10:
                    bkVar.sII = aVar3.UbS.readString();
                    AppMethodBeat.o(122480);
                    return 0;
                default:
                    AppMethodBeat.o(122480);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122480);
            return -1;
        }
    }
}
