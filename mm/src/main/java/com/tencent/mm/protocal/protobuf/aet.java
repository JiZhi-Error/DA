package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aet extends a {
    public int Lqc;
    public String Lqd;
    public String Lqe;
    public boolean enable;
    public String lDS;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209320);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.enable);
            aVar.aM(2, this.Lqc);
            if (this.lDS != null) {
                aVar.e(3, this.lDS);
            }
            if (this.Lqd != null) {
                aVar.e(4, this.Lqd);
            }
            if (this.Lqe != null) {
                aVar.e(5, this.Lqe);
            }
            if (this.title != null) {
                aVar.e(6, this.title);
            }
            AppMethodBeat.o(209320);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.bu(2, this.Lqc);
            if (this.lDS != null) {
                fS += g.a.a.b.b.a.f(3, this.lDS);
            }
            if (this.Lqd != null) {
                fS += g.a.a.b.b.a.f(4, this.Lqd);
            }
            if (this.Lqe != null) {
                fS += g.a.a.b.b.a.f(5, this.Lqe);
            }
            if (this.title != null) {
                fS += g.a.a.b.b.a.f(6, this.title);
            }
            AppMethodBeat.o(209320);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209320);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aet aet = (aet) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aet.enable = aVar3.UbS.yZ();
                    AppMethodBeat.o(209320);
                    return 0;
                case 2:
                    aet.Lqc = aVar3.UbS.zi();
                    AppMethodBeat.o(209320);
                    return 0;
                case 3:
                    aet.lDS = aVar3.UbS.readString();
                    AppMethodBeat.o(209320);
                    return 0;
                case 4:
                    aet.Lqd = aVar3.UbS.readString();
                    AppMethodBeat.o(209320);
                    return 0;
                case 5:
                    aet.Lqe = aVar3.UbS.readString();
                    AppMethodBeat.o(209320);
                    return 0;
                case 6:
                    aet.title = aVar3.UbS.readString();
                    AppMethodBeat.o(209320);
                    return 0;
                default:
                    AppMethodBeat.o(209320);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209320);
            return -1;
        }
    }
}
