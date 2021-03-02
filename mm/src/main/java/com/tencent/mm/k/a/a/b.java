package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class b extends a {
    public String gCv;
    public int gCw;
    public String gCx;
    public String userName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42662);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.e(1, this.userName);
            }
            if (this.gCv != null) {
                aVar.e(2, this.gCv);
            }
            aVar.aM(3, this.gCw);
            if (this.gCx != null) {
                aVar.e(4, this.gCx);
            }
            AppMethodBeat.o(42662);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.userName != null ? g.a.a.b.b.a.f(1, this.userName) + 0 : 0;
            if (this.gCv != null) {
                f2 += g.a.a.b.b.a.f(2, this.gCv);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.gCw);
            if (this.gCx != null) {
                bu += g.a.a.b.b.a.f(4, this.gCx);
            }
            AppMethodBeat.o(42662);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(42662);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(42662);
                    return 0;
                case 2:
                    bVar.gCv = aVar3.UbS.readString();
                    AppMethodBeat.o(42662);
                    return 0;
                case 3:
                    bVar.gCw = aVar3.UbS.zi();
                    AppMethodBeat.o(42662);
                    return 0;
                case 4:
                    bVar.gCx = aVar3.UbS.readString();
                    AppMethodBeat.o(42662);
                    return 0;
                default:
                    AppMethodBeat.o(42662);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42662);
            return -1;
        }
    }
}
