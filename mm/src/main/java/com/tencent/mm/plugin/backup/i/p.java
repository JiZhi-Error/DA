package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class p extends a {
    public String ID;
    public long oTV;
    public int oTY;
    public int oTZ;
    public int oUa;
    public long oUb;
    public long oUc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22120);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ID == null) {
                b bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22120);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.aM(2, this.oTY);
            aVar.aM(3, this.oTZ);
            aVar.aM(4, this.oUa);
            aVar.bb(5, this.oTV);
            aVar.bb(6, this.oUb);
            aVar.bb(7, this.oUc);
            AppMethodBeat.o(22120);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ID != null ? g.a.a.b.b.a.f(1, this.ID) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTY) + g.a.a.b.b.a.bu(3, this.oTZ) + g.a.a.b.b.a.bu(4, this.oUa) + g.a.a.b.b.a.r(5, this.oTV) + g.a.a.b.b.a.r(6, this.oUb) + g.a.a.b.b.a.r(7, this.oUc);
            AppMethodBeat.o(22120);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ID == null) {
                b bVar2 = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22120);
                throw bVar2;
            }
            AppMethodBeat.o(22120);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(22120);
                    return 0;
                case 2:
                    pVar.oTY = aVar3.UbS.zi();
                    AppMethodBeat.o(22120);
                    return 0;
                case 3:
                    pVar.oTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(22120);
                    return 0;
                case 4:
                    pVar.oUa = aVar3.UbS.zi();
                    AppMethodBeat.o(22120);
                    return 0;
                case 5:
                    pVar.oTV = aVar3.UbS.zl();
                    AppMethodBeat.o(22120);
                    return 0;
                case 6:
                    pVar.oUb = aVar3.UbS.zl();
                    AppMethodBeat.o(22120);
                    return 0;
                case 7:
                    pVar.oUc = aVar3.UbS.zl();
                    AppMethodBeat.o(22120);
                    return 0;
                default:
                    AppMethodBeat.o(22120);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22120);
            return -1;
        }
    }
}
