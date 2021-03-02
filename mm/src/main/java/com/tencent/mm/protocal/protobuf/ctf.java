package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ctf extends a {
    public int Brl;
    public long Brn;
    public int xKb;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43113);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xNH != null) {
                aVar.e(1, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(2, this.xNG);
            }
            aVar.aM(3, this.Brl);
            aVar.aM(4, this.xKb);
            aVar.bb(5, this.Brn);
            AppMethodBeat.o(43113);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xNH != null ? g.a.a.b.b.a.f(1, this.xNH) + 0 : 0;
            if (this.xNG != null) {
                f2 += g.a.a.b.b.a.f(2, this.xNG);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Brl) + g.a.a.b.b.a.bu(4, this.xKb) + g.a.a.b.b.a.r(5, this.Brn);
            AppMethodBeat.o(43113);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43113);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctf ctf = (ctf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctf.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(43113);
                    return 0;
                case 2:
                    ctf.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(43113);
                    return 0;
                case 3:
                    ctf.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(43113);
                    return 0;
                case 4:
                    ctf.xKb = aVar3.UbS.zi();
                    AppMethodBeat.o(43113);
                    return 0;
                case 5:
                    ctf.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(43113);
                    return 0;
                default:
                    AppMethodBeat.o(43113);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43113);
            return -1;
        }
    }
}
