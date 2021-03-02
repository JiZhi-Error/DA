package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class vd extends a {
    public String Lfq;
    public String Lfr;
    public int Lfs;
    public int Lft;
    public int Lfu;
    public int Lfv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123560);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lfq != null) {
                aVar.e(1, this.Lfq);
            }
            if (this.Lfr != null) {
                aVar.e(2, this.Lfr);
            }
            aVar.aM(3, this.Lfs);
            aVar.aM(4, this.Lft);
            aVar.aM(5, this.Lfu);
            aVar.aM(6, this.Lfv);
            AppMethodBeat.o(123560);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Lfq != null ? g.a.a.b.b.a.f(1, this.Lfq) + 0 : 0;
            if (this.Lfr != null) {
                f2 += g.a.a.b.b.a.f(2, this.Lfr);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Lfs) + g.a.a.b.b.a.bu(4, this.Lft) + g.a.a.b.b.a.bu(5, this.Lfu) + g.a.a.b.b.a.bu(6, this.Lfv);
            AppMethodBeat.o(123560);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123560);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vd vdVar = (vd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vdVar.Lfq = aVar3.UbS.readString();
                    AppMethodBeat.o(123560);
                    return 0;
                case 2:
                    vdVar.Lfr = aVar3.UbS.readString();
                    AppMethodBeat.o(123560);
                    return 0;
                case 3:
                    vdVar.Lfs = aVar3.UbS.zi();
                    AppMethodBeat.o(123560);
                    return 0;
                case 4:
                    vdVar.Lft = aVar3.UbS.zi();
                    AppMethodBeat.o(123560);
                    return 0;
                case 5:
                    vdVar.Lfu = aVar3.UbS.zi();
                    AppMethodBeat.o(123560);
                    return 0;
                case 6:
                    vdVar.Lfv = aVar3.UbS.zi();
                    AppMethodBeat.o(123560);
                    return 0;
                default:
                    AppMethodBeat.o(123560);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123560);
            return -1;
        }
    }
}
