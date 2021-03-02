package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ctb extends a {
    public String MxY;
    public String MxZ;
    public int Mya;
    public int Myb;
    public int Myc;
    public int Myd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133179);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MxY != null) {
                aVar.e(1, this.MxY);
            }
            if (this.MxZ != null) {
                aVar.e(2, this.MxZ);
            }
            aVar.aM(3, this.Mya);
            aVar.aM(4, this.Myb);
            aVar.aM(5, this.Myc);
            aVar.aM(7, this.Myd);
            AppMethodBeat.o(133179);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MxY != null ? g.a.a.b.b.a.f(1, this.MxY) + 0 : 0;
            if (this.MxZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.MxZ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Mya) + g.a.a.b.b.a.bu(4, this.Myb) + g.a.a.b.b.a.bu(5, this.Myc) + g.a.a.b.b.a.bu(7, this.Myd);
            AppMethodBeat.o(133179);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133179);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctb ctb = (ctb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctb.MxY = aVar3.UbS.readString();
                    AppMethodBeat.o(133179);
                    return 0;
                case 2:
                    ctb.MxZ = aVar3.UbS.readString();
                    AppMethodBeat.o(133179);
                    return 0;
                case 3:
                    ctb.Mya = aVar3.UbS.zi();
                    AppMethodBeat.o(133179);
                    return 0;
                case 4:
                    ctb.Myb = aVar3.UbS.zi();
                    AppMethodBeat.o(133179);
                    return 0;
                case 5:
                    ctb.Myc = aVar3.UbS.zi();
                    AppMethodBeat.o(133179);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(133179);
                    return -1;
                case 7:
                    ctb.Myd = aVar3.UbS.zi();
                    AppMethodBeat.o(133179);
                    return 0;
            }
        } else {
            AppMethodBeat.o(133179);
            return -1;
        }
    }
}
