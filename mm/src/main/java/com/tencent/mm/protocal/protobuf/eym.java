package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eym extends a {
    public String Title;
    public String iAc;
    public int xNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32523);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(32523);
                throw bVar;
            } else if (this.iAc == null) {
                b bVar2 = new b("Not all required fields were included: Content");
                AppMethodBeat.o(32523);
                throw bVar2;
            } else {
                aVar.aM(1, this.xNF);
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.iAc != null) {
                    aVar.e(3, this.iAc);
                }
                AppMethodBeat.o(32523);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xNF) + 0;
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(3, this.iAc);
            }
            AppMethodBeat.o(32523);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar3 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(32523);
                throw bVar3;
            } else if (this.iAc == null) {
                b bVar4 = new b("Not all required fields were included: Content");
                AppMethodBeat.o(32523);
                throw bVar4;
            } else {
                AppMethodBeat.o(32523);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eym eym = (eym) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eym.xNF = aVar3.UbS.zi();
                    AppMethodBeat.o(32523);
                    return 0;
                case 2:
                    eym.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32523);
                    return 0;
                case 3:
                    eym.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(32523);
                    return 0;
                default:
                    AppMethodBeat.o(32523);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32523);
            return -1;
        }
    }
}
