package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ad extends a {
    public int oUA;
    public int oUC;
    public int oUD;
    public int oUF;
    public String oUz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22136);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oUz == null) {
                b bVar = new b("Not all required fields were included: DataID");
                AppMethodBeat.o(22136);
                throw bVar;
            }
            if (this.oUz != null) {
                aVar.e(1, this.oUz);
            }
            aVar.aM(2, this.oUA);
            aVar.aM(3, this.oUC);
            aVar.aM(4, this.oUD);
            aVar.aM(5, this.oUF);
            AppMethodBeat.o(22136);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.oUz != null ? g.a.a.b.b.a.f(1, this.oUz) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUA) + g.a.a.b.b.a.bu(3, this.oUC) + g.a.a.b.b.a.bu(4, this.oUD) + g.a.a.b.b.a.bu(5, this.oUF);
            AppMethodBeat.o(22136);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oUz == null) {
                b bVar2 = new b("Not all required fields were included: DataID");
                AppMethodBeat.o(22136);
                throw bVar2;
            }
            AppMethodBeat.o(22136);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ad adVar = (ad) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    adVar.oUz = aVar3.UbS.readString();
                    AppMethodBeat.o(22136);
                    return 0;
                case 2:
                    adVar.oUA = aVar3.UbS.zi();
                    AppMethodBeat.o(22136);
                    return 0;
                case 3:
                    adVar.oUC = aVar3.UbS.zi();
                    AppMethodBeat.o(22136);
                    return 0;
                case 4:
                    adVar.oUD = aVar3.UbS.zi();
                    AppMethodBeat.o(22136);
                    return 0;
                case 5:
                    adVar.oUF = aVar3.UbS.zi();
                    AppMethodBeat.o(22136);
                    return 0;
                default:
                    AppMethodBeat.o(22136);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22136);
            return -1;
        }
    }
}