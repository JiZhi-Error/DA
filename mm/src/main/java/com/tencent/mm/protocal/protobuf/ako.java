package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ako extends a {
    public int Lty;
    public String key;
    public String oxJ;
    public String title;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(215275);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.oxJ != null) {
                aVar.e(3, this.oxJ);
            }
            aVar.aM(4, this.Lty);
            aVar.aM(5, this.type);
            AppMethodBeat.o(215275);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.oxJ != null) {
                f2 += g.a.a.b.b.a.f(3, this.oxJ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Lty) + g.a.a.b.b.a.bu(5, this.type);
            AppMethodBeat.o(215275);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(215275);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ako ako = (ako) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ako.key = aVar3.UbS.readString();
                    AppMethodBeat.o(215275);
                    return 0;
                case 2:
                    ako.title = aVar3.UbS.readString();
                    AppMethodBeat.o(215275);
                    return 0;
                case 3:
                    ako.oxJ = aVar3.UbS.readString();
                    AppMethodBeat.o(215275);
                    return 0;
                case 4:
                    ako.Lty = aVar3.UbS.zi();
                    AppMethodBeat.o(215275);
                    return 0;
                case 5:
                    ako.type = aVar3.UbS.zi();
                    AppMethodBeat.o(215275);
                    return 0;
                default:
                    AppMethodBeat.o(215275);
                    return -1;
            }
        } else {
            AppMethodBeat.o(215275);
            return -1;
        }
    }
}
