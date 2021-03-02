package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cik extends a {
    public String Cyk;
    public String LRO;
    public String Lir;
    public String Lis;
    public String UserName;
    public int oTW;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155433);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Cyk != null) {
                aVar.e(1, this.Cyk);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            aVar.aM(3, this.oTW);
            if (this.Lir != null) {
                aVar.e(4, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(5, this.Lis);
            }
            if (this.oUJ != null) {
                aVar.e(6, this.oUJ);
            }
            if (this.LRO != null) {
                aVar.e(7, this.LRO);
            }
            AppMethodBeat.o(155433);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Cyk != null ? g.a.a.b.b.a.f(1, this.Cyk) + 0 : 0;
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(2, this.UserName);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.oTW);
            if (this.Lir != null) {
                bu += g.a.a.b.b.a.f(4, this.Lir);
            }
            if (this.Lis != null) {
                bu += g.a.a.b.b.a.f(5, this.Lis);
            }
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(6, this.oUJ);
            }
            if (this.LRO != null) {
                bu += g.a.a.b.b.a.f(7, this.LRO);
            }
            AppMethodBeat.o(155433);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155433);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cik cik = (cik) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cik.Cyk = aVar3.UbS.readString();
                    AppMethodBeat.o(155433);
                    return 0;
                case 2:
                    cik.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(155433);
                    return 0;
                case 3:
                    cik.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(155433);
                    return 0;
                case 4:
                    cik.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(155433);
                    return 0;
                case 5:
                    cik.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(155433);
                    return 0;
                case 6:
                    cik.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(155433);
                    return 0;
                case 7:
                    cik.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(155433);
                    return 0;
                default:
                    AppMethodBeat.o(155433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155433);
            return -1;
        }
    }
}
