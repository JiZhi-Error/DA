package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class r extends a {
    public String GaO;
    public String GaP;
    public String GaQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222840);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.GaO != null) {
                aVar.e(1, this.GaO);
            }
            if (this.GaP != null) {
                aVar.e(2, this.GaP);
            }
            if (this.GaQ != null) {
                aVar.e(3, this.GaQ);
            }
            AppMethodBeat.o(222840);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.GaO != null ? g.a.a.b.b.a.f(1, this.GaO) + 0 : 0;
            if (this.GaP != null) {
                f2 += g.a.a.b.b.a.f(2, this.GaP);
            }
            if (this.GaQ != null) {
                f2 += g.a.a.b.b.a.f(3, this.GaQ);
            }
            AppMethodBeat.o(222840);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222840);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rVar.GaO = aVar3.UbS.readString();
                    AppMethodBeat.o(222840);
                    return 0;
                case 2:
                    rVar.GaP = aVar3.UbS.readString();
                    AppMethodBeat.o(222840);
                    return 0;
                case 3:
                    rVar.GaQ = aVar3.UbS.readString();
                    AppMethodBeat.o(222840);
                    return 0;
                default:
                    AppMethodBeat.o(222840);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222840);
            return -1;
        }
    }
}
