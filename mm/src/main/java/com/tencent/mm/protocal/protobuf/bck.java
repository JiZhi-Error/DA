package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bck extends a {
    public String JTr;
    public String LIb;
    public String LLA;
    public String LLy;
    public String LLz;
    public String iUO;
    public String kHV;
    public String tPa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196094);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LLy != null) {
                aVar.e(1, this.LLy);
            }
            if (this.LLz != null) {
                aVar.e(2, this.LLz);
            }
            if (this.kHV != null) {
                aVar.e(3, this.kHV);
            }
            if (this.LLA != null) {
                aVar.e(4, this.LLA);
            }
            if (this.iUO != null) {
                aVar.e(5, this.iUO);
            }
            if (this.JTr != null) {
                aVar.e(6, this.JTr);
            }
            if (this.LIb != null) {
                aVar.e(7, this.LIb);
            }
            if (this.tPa != null) {
                aVar.e(8, this.tPa);
            }
            AppMethodBeat.o(196094);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LLy != null ? g.a.a.b.b.a.f(1, this.LLy) + 0 : 0;
            if (this.LLz != null) {
                f2 += g.a.a.b.b.a.f(2, this.LLz);
            }
            if (this.kHV != null) {
                f2 += g.a.a.b.b.a.f(3, this.kHV);
            }
            if (this.LLA != null) {
                f2 += g.a.a.b.b.a.f(4, this.LLA);
            }
            if (this.iUO != null) {
                f2 += g.a.a.b.b.a.f(5, this.iUO);
            }
            if (this.JTr != null) {
                f2 += g.a.a.b.b.a.f(6, this.JTr);
            }
            if (this.LIb != null) {
                f2 += g.a.a.b.b.a.f(7, this.LIb);
            }
            if (this.tPa != null) {
                f2 += g.a.a.b.b.a.f(8, this.tPa);
            }
            AppMethodBeat.o(196094);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196094);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bck bck = (bck) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bck.LLy = aVar3.UbS.readString();
                    AppMethodBeat.o(196094);
                    return 0;
                case 2:
                    bck.LLz = aVar3.UbS.readString();
                    AppMethodBeat.o(196094);
                    return 0;
                case 3:
                    bck.kHV = aVar3.UbS.readString();
                    AppMethodBeat.o(196094);
                    return 0;
                case 4:
                    bck.LLA = aVar3.UbS.readString();
                    AppMethodBeat.o(196094);
                    return 0;
                case 5:
                    bck.iUO = aVar3.UbS.readString();
                    AppMethodBeat.o(196094);
                    return 0;
                case 6:
                    bck.JTr = aVar3.UbS.readString();
                    AppMethodBeat.o(196094);
                    return 0;
                case 7:
                    bck.LIb = aVar3.UbS.readString();
                    AppMethodBeat.o(196094);
                    return 0;
                case 8:
                    bck.tPa = aVar3.UbS.readString();
                    AppMethodBeat.o(196094);
                    return 0;
                default:
                    AppMethodBeat.o(196094);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196094);
            return -1;
        }
    }
}
