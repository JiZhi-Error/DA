package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eb extends a {
    public String xJt;
    public int xJv;
    public int xNu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256652);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xNu);
            aVar.aM(2, this.xJv);
            if (this.xJt != null) {
                aVar.e(3, this.xJt);
            }
            AppMethodBeat.o(256652);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xNu) + 0 + g.a.a.b.b.a.bu(2, this.xJv);
            if (this.xJt != null) {
                bu += g.a.a.b.b.a.f(3, this.xJt);
            }
            AppMethodBeat.o(256652);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256652);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eb ebVar = (eb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ebVar.xNu = aVar3.UbS.zi();
                    AppMethodBeat.o(256652);
                    return 0;
                case 2:
                    ebVar.xJv = aVar3.UbS.zi();
                    AppMethodBeat.o(256652);
                    return 0;
                case 3:
                    ebVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(256652);
                    return 0;
                default:
                    AppMethodBeat.o(256652);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256652);
            return -1;
        }
    }
}
