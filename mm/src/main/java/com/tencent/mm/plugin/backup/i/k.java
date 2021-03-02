package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class k extends a {
    public String UserName;
    public int oTD;
    public int oTE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22114);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(22114);
                throw bVar;
            }
            aVar.aM(1, this.oTD);
            aVar.aM(2, this.oTE);
            if (this.UserName != null) {
                aVar.e(3, this.UserName);
            }
            AppMethodBeat.o(22114);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oTD) + 0 + g.a.a.b.b.a.bu(2, this.oTE);
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(3, this.UserName);
            }
            AppMethodBeat.o(22114);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.UserName == null) {
                b bVar2 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(22114);
                throw bVar2;
            }
            AppMethodBeat.o(22114);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.oTD = aVar3.UbS.zi();
                    AppMethodBeat.o(22114);
                    return 0;
                case 2:
                    kVar.oTE = aVar3.UbS.zi();
                    AppMethodBeat.o(22114);
                    return 0;
                case 3:
                    kVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(22114);
                    return 0;
                default:
                    AppMethodBeat.o(22114);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22114);
            return -1;
        }
    }
}
