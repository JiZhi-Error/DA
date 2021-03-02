package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class a extends com.tencent.mm.bw.a {
    public String KBo;
    public String KBp;
    public int actionType;
    public int id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123716);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KBo == null) {
                b bVar = new b("Not all required fields were included: btnStr");
                AppMethodBeat.o(123716);
                throw bVar;
            }
            aVar.aM(1, this.id);
            aVar.aM(2, this.actionType);
            if (this.KBo != null) {
                aVar.e(3, this.KBo);
            }
            if (this.KBp != null) {
                aVar.e(4, this.KBp);
            }
            AppMethodBeat.o(123716);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0 + g.a.a.b.b.a.bu(2, this.actionType);
            if (this.KBo != null) {
                bu += g.a.a.b.b.a.f(3, this.KBo);
            }
            if (this.KBp != null) {
                bu += g.a.a.b.b.a.f(4, this.KBp);
            }
            AppMethodBeat.o(123716);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KBo == null) {
                b bVar2 = new b("Not all required fields were included: btnStr");
                AppMethodBeat.o(123716);
                throw bVar2;
            }
            AppMethodBeat.o(123716);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.id = aVar3.UbS.zi();
                    AppMethodBeat.o(123716);
                    return 0;
                case 2:
                    aVar4.actionType = aVar3.UbS.zi();
                    AppMethodBeat.o(123716);
                    return 0;
                case 3:
                    aVar4.KBo = aVar3.UbS.readString();
                    AppMethodBeat.o(123716);
                    return 0;
                case 4:
                    aVar4.KBp = aVar3.UbS.readString();
                    AppMethodBeat.o(123716);
                    return 0;
                default:
                    AppMethodBeat.o(123716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123716);
            return -1;
        }
    }
}
