package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class epf extends a {
    public int ElR;
    public int Nnc;
    public long Nnd;
    public long Nne;
    public long Nnf;
    public long Nng;
    public long Nnh;
    public int Nni;
    public long iJF;
    public long sGB;
    public long vgi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169092);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Nnc);
            aVar.aM(2, this.ElR);
            aVar.bb(3, this.sGB);
            aVar.bb(4, this.Nnd);
            aVar.bb(5, this.Nne);
            aVar.bb(6, this.Nnf);
            aVar.bb(7, this.iJF);
            aVar.bb(8, this.Nng);
            aVar.bb(9, this.vgi);
            aVar.bb(10, this.Nnh);
            aVar.aM(11, this.Nni);
            AppMethodBeat.o(169092);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Nnc) + 0 + g.a.a.b.b.a.bu(2, this.ElR) + g.a.a.b.b.a.r(3, this.sGB) + g.a.a.b.b.a.r(4, this.Nnd) + g.a.a.b.b.a.r(5, this.Nne) + g.a.a.b.b.a.r(6, this.Nnf) + g.a.a.b.b.a.r(7, this.iJF) + g.a.a.b.b.a.r(8, this.Nng) + g.a.a.b.b.a.r(9, this.vgi) + g.a.a.b.b.a.r(10, this.Nnh) + g.a.a.b.b.a.bu(11, this.Nni);
            AppMethodBeat.o(169092);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169092);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epf epf = (epf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    epf.Nnc = aVar3.UbS.zi();
                    AppMethodBeat.o(169092);
                    return 0;
                case 2:
                    epf.ElR = aVar3.UbS.zi();
                    AppMethodBeat.o(169092);
                    return 0;
                case 3:
                    epf.sGB = aVar3.UbS.zl();
                    AppMethodBeat.o(169092);
                    return 0;
                case 4:
                    epf.Nnd = aVar3.UbS.zl();
                    AppMethodBeat.o(169092);
                    return 0;
                case 5:
                    epf.Nne = aVar3.UbS.zl();
                    AppMethodBeat.o(169092);
                    return 0;
                case 6:
                    epf.Nnf = aVar3.UbS.zl();
                    AppMethodBeat.o(169092);
                    return 0;
                case 7:
                    epf.iJF = aVar3.UbS.zl();
                    AppMethodBeat.o(169092);
                    return 0;
                case 8:
                    epf.Nng = aVar3.UbS.zl();
                    AppMethodBeat.o(169092);
                    return 0;
                case 9:
                    epf.vgi = aVar3.UbS.zl();
                    AppMethodBeat.o(169092);
                    return 0;
                case 10:
                    epf.Nnh = aVar3.UbS.zl();
                    AppMethodBeat.o(169092);
                    return 0;
                case 11:
                    epf.Nni = aVar3.UbS.zi();
                    AppMethodBeat.o(169092);
                    return 0;
                default:
                    AppMethodBeat.o(169092);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169092);
            return -1;
        }
    }
}
