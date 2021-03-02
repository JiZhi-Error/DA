package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class nt extends a {
    public String KTl;
    public String KTm;
    public int KTn;
    public int KTp;
    public String KTq;
    public String KTr;
    public int KTs;
    public String name;
    public int type;
    public int ver;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124416);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KTl != null) {
                aVar.e(1, this.KTl);
            }
            aVar.aM(2, this.type);
            if (this.KTm != null) {
                aVar.e(3, this.KTm);
            }
            if (this.name != null) {
                aVar.e(4, this.name);
            }
            aVar.aM(5, this.ver);
            aVar.aM(6, this.KTn);
            aVar.aM(7, this.KTp);
            if (this.KTq != null) {
                aVar.e(8, this.KTq);
            }
            if (this.KTr != null) {
                aVar.e(9, this.KTr);
            }
            aVar.aM(10, this.KTs);
            AppMethodBeat.o(124416);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KTl != null ? g.a.a.b.b.a.f(1, this.KTl) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type);
            if (this.KTm != null) {
                f2 += g.a.a.b.b.a.f(3, this.KTm);
            }
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(4, this.name);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.ver) + g.a.a.b.b.a.bu(6, this.KTn) + g.a.a.b.b.a.bu(7, this.KTp);
            if (this.KTq != null) {
                bu += g.a.a.b.b.a.f(8, this.KTq);
            }
            if (this.KTr != null) {
                bu += g.a.a.b.b.a.f(9, this.KTr);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.KTs);
            AppMethodBeat.o(124416);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124416);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nt ntVar = (nt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ntVar.KTl = aVar3.UbS.readString();
                    AppMethodBeat.o(124416);
                    return 0;
                case 2:
                    ntVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(124416);
                    return 0;
                case 3:
                    ntVar.KTm = aVar3.UbS.readString();
                    AppMethodBeat.o(124416);
                    return 0;
                case 4:
                    ntVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(124416);
                    return 0;
                case 5:
                    ntVar.ver = aVar3.UbS.zi();
                    AppMethodBeat.o(124416);
                    return 0;
                case 6:
                    ntVar.KTn = aVar3.UbS.zi();
                    AppMethodBeat.o(124416);
                    return 0;
                case 7:
                    ntVar.KTp = aVar3.UbS.zi();
                    AppMethodBeat.o(124416);
                    return 0;
                case 8:
                    ntVar.KTq = aVar3.UbS.readString();
                    AppMethodBeat.o(124416);
                    return 0;
                case 9:
                    ntVar.KTr = aVar3.UbS.readString();
                    AppMethodBeat.o(124416);
                    return 0;
                case 10:
                    ntVar.KTs = aVar3.UbS.zi();
                    AppMethodBeat.o(124416);
                    return 0;
                default:
                    AppMethodBeat.o(124416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124416);
            return -1;
        }
    }
}
