package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class x extends a {
    public b oTm;
    public int oUA;
    public int oUB;
    public int oUC;
    public int oUD;
    public int oUE;
    public int oUF;
    public String oUz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22129);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oUz == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: DataID");
                AppMethodBeat.o(22129);
                throw bVar;
            }
            if (this.oUz != null) {
                aVar.e(1, this.oUz);
            }
            aVar.aM(2, this.oUA);
            aVar.aM(3, this.oUB);
            aVar.aM(4, this.oUC);
            aVar.aM(5, this.oUD);
            aVar.aM(6, this.oUE);
            if (this.oTm != null) {
                aVar.c(7, this.oTm);
            }
            aVar.aM(8, this.oUF);
            AppMethodBeat.o(22129);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.oUz != null ? g.a.a.b.b.a.f(1, this.oUz) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUA) + g.a.a.b.b.a.bu(3, this.oUB) + g.a.a.b.b.a.bu(4, this.oUC) + g.a.a.b.b.a.bu(5, this.oUD) + g.a.a.b.b.a.bu(6, this.oUE);
            if (this.oTm != null) {
                f2 += g.a.a.b.b.a.b(7, this.oTm);
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.oUF);
            AppMethodBeat.o(22129);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oUz == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: DataID");
                AppMethodBeat.o(22129);
                throw bVar2;
            }
            AppMethodBeat.o(22129);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xVar.oUz = aVar3.UbS.readString();
                    AppMethodBeat.o(22129);
                    return 0;
                case 2:
                    xVar.oUA = aVar3.UbS.zi();
                    AppMethodBeat.o(22129);
                    return 0;
                case 3:
                    xVar.oUB = aVar3.UbS.zi();
                    AppMethodBeat.o(22129);
                    return 0;
                case 4:
                    xVar.oUC = aVar3.UbS.zi();
                    AppMethodBeat.o(22129);
                    return 0;
                case 5:
                    xVar.oUD = aVar3.UbS.zi();
                    AppMethodBeat.o(22129);
                    return 0;
                case 6:
                    xVar.oUE = aVar3.UbS.zi();
                    AppMethodBeat.o(22129);
                    return 0;
                case 7:
                    xVar.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(22129);
                    return 0;
                case 8:
                    xVar.oUF = aVar3.UbS.zi();
                    AppMethodBeat.o(22129);
                    return 0;
                default:
                    AppMethodBeat.o(22129);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22129);
            return -1;
        }
    }
}
