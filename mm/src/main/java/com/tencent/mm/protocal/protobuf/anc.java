package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class anc extends a {
    public String Desc;
    public int KHd;
    public String KHe;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(138174);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(2, this.Desc);
            }
            aVar.aM(3, this.KHd);
            if (this.KHe != null) {
                aVar.e(4, this.KHe);
            }
            AppMethodBeat.o(138174);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.Desc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KHd);
            if (this.KHe != null) {
                bu += g.a.a.b.b.a.f(4, this.KHe);
            }
            AppMethodBeat.o(138174);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(138174);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anc anc = (anc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anc.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(138174);
                    return 0;
                case 2:
                    anc.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(138174);
                    return 0;
                case 3:
                    anc.KHd = aVar3.UbS.zi();
                    AppMethodBeat.o(138174);
                    return 0;
                case 4:
                    anc.KHe = aVar3.UbS.readString();
                    AppMethodBeat.o(138174);
                    return 0;
                default:
                    AppMethodBeat.o(138174);
                    return -1;
            }
        } else {
            AppMethodBeat.o(138174);
            return -1;
        }
    }
}
