package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class exa extends a {
    public String Nkr;
    public String Nuu;
    public String Nuv;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91726);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.Nuu != null) {
                aVar.e(2, this.Nuu);
            }
            if (this.Nkr != null) {
                aVar.e(3, this.Nkr);
            }
            if (this.Nuv != null) {
                aVar.e(4, this.Nuv);
            }
            AppMethodBeat.o(91726);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.Nuu != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nuu);
            }
            if (this.Nkr != null) {
                f2 += g.a.a.b.b.a.f(3, this.Nkr);
            }
            if (this.Nuv != null) {
                f2 += g.a.a.b.b.a.f(4, this.Nuv);
            }
            AppMethodBeat.o(91726);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91726);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            exa exa = (exa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    exa.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91726);
                    return 0;
                case 2:
                    exa.Nuu = aVar3.UbS.readString();
                    AppMethodBeat.o(91726);
                    return 0;
                case 3:
                    exa.Nkr = aVar3.UbS.readString();
                    AppMethodBeat.o(91726);
                    return 0;
                case 4:
                    exa.Nuv = aVar3.UbS.readString();
                    AppMethodBeat.o(91726);
                    return 0;
                default:
                    AppMethodBeat.o(91726);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91726);
            return -1;
        }
    }
}
