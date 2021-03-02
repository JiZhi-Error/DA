package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class v extends a {
    public String ID;
    public int Version;
    public b oTm;
    public int oUu;
    public int oUv;
    public int oUw;
    public int oUx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22127);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ID == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: ID");
                AppMethodBeat.o(22127);
                throw bVar;
            }
            aVar.aM(1, this.oUu);
            if (this.ID != null) {
                aVar.e(2, this.ID);
            }
            if (this.oTm != null) {
                aVar.c(3, this.oTm);
            }
            aVar.aM(4, this.Version);
            aVar.aM(5, this.oUv);
            aVar.aM(6, this.oUw);
            aVar.aM(7, this.oUx);
            AppMethodBeat.o(22127);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUu) + 0;
            if (this.ID != null) {
                bu += g.a.a.b.b.a.f(2, this.ID);
            }
            if (this.oTm != null) {
                bu += g.a.a.b.b.a.b(3, this.oTm);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Version) + g.a.a.b.b.a.bu(5, this.oUv) + g.a.a.b.b.a.bu(6, this.oUw) + g.a.a.b.b.a.bu(7, this.oUx);
            AppMethodBeat.o(22127);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ID == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: ID");
                AppMethodBeat.o(22127);
                throw bVar2;
            }
            AppMethodBeat.o(22127);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vVar.oUu = aVar3.UbS.zi();
                    AppMethodBeat.o(22127);
                    return 0;
                case 2:
                    vVar.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(22127);
                    return 0;
                case 3:
                    vVar.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(22127);
                    return 0;
                case 4:
                    vVar.Version = aVar3.UbS.zi();
                    AppMethodBeat.o(22127);
                    return 0;
                case 5:
                    vVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(22127);
                    return 0;
                case 6:
                    vVar.oUw = aVar3.UbS.zi();
                    AppMethodBeat.o(22127);
                    return 0;
                case 7:
                    vVar.oUx = aVar3.UbS.zi();
                    AppMethodBeat.o(22127);
                    return 0;
                default:
                    AppMethodBeat.o(22127);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22127);
            return -1;
        }
    }
}
