package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class evh extends a {
    public float KGp;
    public String LnW;
    public String Ntg;
    public String Nth;
    public String Nti;
    public int Ntj;
    public float Ntk;
    public String Ntl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147791);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ntg != null) {
                aVar.e(1, this.Ntg);
            }
            if (this.LnW != null) {
                aVar.e(2, this.LnW);
            }
            if (this.Nth != null) {
                aVar.e(3, this.Nth);
            }
            if (this.Nti != null) {
                aVar.e(4, this.Nti);
            }
            aVar.aM(5, this.Ntj);
            aVar.E(6, this.KGp);
            aVar.E(7, this.Ntk);
            if (this.Ntl != null) {
                aVar.e(8, this.Ntl);
            }
            AppMethodBeat.o(147791);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Ntg != null ? g.a.a.b.b.a.f(1, this.Ntg) + 0 : 0;
            if (this.LnW != null) {
                f2 += g.a.a.b.b.a.f(2, this.LnW);
            }
            if (this.Nth != null) {
                f2 += g.a.a.b.b.a.f(3, this.Nth);
            }
            if (this.Nti != null) {
                f2 += g.a.a.b.b.a.f(4, this.Nti);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Ntj) + g.a.a.b.b.a.fS(6) + 4 + g.a.a.b.b.a.fS(7) + 4;
            if (this.Ntl != null) {
                bu += g.a.a.b.b.a.f(8, this.Ntl);
            }
            AppMethodBeat.o(147791);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147791);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evh evh = (evh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evh.Ntg = aVar3.UbS.readString();
                    AppMethodBeat.o(147791);
                    return 0;
                case 2:
                    evh.LnW = aVar3.UbS.readString();
                    AppMethodBeat.o(147791);
                    return 0;
                case 3:
                    evh.Nth = aVar3.UbS.readString();
                    AppMethodBeat.o(147791);
                    return 0;
                case 4:
                    evh.Nti = aVar3.UbS.readString();
                    AppMethodBeat.o(147791);
                    return 0;
                case 5:
                    evh.Ntj = aVar3.UbS.zi();
                    AppMethodBeat.o(147791);
                    return 0;
                case 6:
                    evh.KGp = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(147791);
                    return 0;
                case 7:
                    evh.Ntk = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(147791);
                    return 0;
                case 8:
                    evh.Ntl = aVar3.UbS.readString();
                    AppMethodBeat.o(147791);
                    return 0;
                default:
                    AppMethodBeat.o(147791);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147791);
            return -1;
        }
    }
}
