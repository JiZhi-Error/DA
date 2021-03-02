package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class fdn extends a {
    public boolean NyX;
    public String Nzf;
    public b Nzg;
    public int Nzh;
    public int Nzi;
    public int Nzj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50123);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.NyX);
            if (this.Nzf != null) {
                aVar.e(2, this.Nzf);
            }
            if (this.Nzg != null) {
                aVar.c(3, this.Nzg);
            }
            aVar.aM(4, this.Nzh);
            aVar.aM(5, this.Nzi);
            aVar.aM(6, this.Nzj);
            AppMethodBeat.o(50123);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.Nzf != null) {
                fS += g.a.a.b.b.a.f(2, this.Nzf);
            }
            if (this.Nzg != null) {
                fS += g.a.a.b.b.a.b(3, this.Nzg);
            }
            int bu = fS + g.a.a.b.b.a.bu(4, this.Nzh) + g.a.a.b.b.a.bu(5, this.Nzi) + g.a.a.b.b.a.bu(6, this.Nzj);
            AppMethodBeat.o(50123);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50123);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdn fdn = (fdn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdn.NyX = aVar3.UbS.yZ();
                    AppMethodBeat.o(50123);
                    return 0;
                case 2:
                    fdn.Nzf = aVar3.UbS.readString();
                    AppMethodBeat.o(50123);
                    return 0;
                case 3:
                    fdn.Nzg = aVar3.UbS.hPo();
                    AppMethodBeat.o(50123);
                    return 0;
                case 4:
                    fdn.Nzh = aVar3.UbS.zi();
                    AppMethodBeat.o(50123);
                    return 0;
                case 5:
                    fdn.Nzi = aVar3.UbS.zi();
                    AppMethodBeat.o(50123);
                    return 0;
                case 6:
                    fdn.Nzj = aVar3.UbS.zi();
                    AppMethodBeat.o(50123);
                    return 0;
                default:
                    AppMethodBeat.o(50123);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50123);
            return -1;
        }
    }
}
