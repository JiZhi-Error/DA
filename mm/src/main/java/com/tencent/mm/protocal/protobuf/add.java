package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class add extends a {
    public int Loq;
    public int Lor;
    public String Los;
    public String dFb;
    public String dFc;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32169);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.version);
            aVar.aM(2, this.Loq);
            aVar.aM(3, this.Lor);
            if (this.dFc != null) {
                aVar.e(4, this.dFc);
            }
            if (this.Los != null) {
                aVar.e(5, this.Los);
            }
            if (this.dFb != null) {
                aVar.e(6, this.dFb);
            }
            AppMethodBeat.o(32169);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.version) + 0 + g.a.a.b.b.a.bu(2, this.Loq) + g.a.a.b.b.a.bu(3, this.Lor);
            if (this.dFc != null) {
                bu += g.a.a.b.b.a.f(4, this.dFc);
            }
            if (this.Los != null) {
                bu += g.a.a.b.b.a.f(5, this.Los);
            }
            if (this.dFb != null) {
                bu += g.a.a.b.b.a.f(6, this.dFb);
            }
            AppMethodBeat.o(32169);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32169);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            add add = (add) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    add.version = aVar3.UbS.zi();
                    AppMethodBeat.o(32169);
                    return 0;
                case 2:
                    add.Loq = aVar3.UbS.zi();
                    AppMethodBeat.o(32169);
                    return 0;
                case 3:
                    add.Lor = aVar3.UbS.zi();
                    AppMethodBeat.o(32169);
                    return 0;
                case 4:
                    add.dFc = aVar3.UbS.readString();
                    AppMethodBeat.o(32169);
                    return 0;
                case 5:
                    add.Los = aVar3.UbS.readString();
                    AppMethodBeat.o(32169);
                    return 0;
                case 6:
                    add.dFb = aVar3.UbS.readString();
                    AppMethodBeat.o(32169);
                    return 0;
                default:
                    AppMethodBeat.o(32169);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32169);
            return -1;
        }
    }
}
