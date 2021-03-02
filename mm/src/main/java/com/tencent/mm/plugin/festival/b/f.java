package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class f extends a {
    public b GaF;
    public int qwL;
    public int scene;
    public int source;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261971);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.GaF != null) {
                aVar.c(1, this.GaF);
            }
            aVar.aM(2, this.scene);
            aVar.aM(3, this.qwL);
            aVar.aM(4, this.source);
            AppMethodBeat.o(261971);
            return 0;
        } else if (i2 == 1) {
            int b2 = (this.GaF != null ? g.a.a.b.b.a.b(1, this.GaF) + 0 : 0) + g.a.a.b.b.a.bu(2, this.scene) + g.a.a.b.b.a.bu(3, this.qwL) + g.a.a.b.b.a.bu(4, this.source);
            AppMethodBeat.o(261971);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261971);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.GaF = aVar3.UbS.hPo();
                    AppMethodBeat.o(261971);
                    return 0;
                case 2:
                    fVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(261971);
                    return 0;
                case 3:
                    fVar.qwL = aVar3.UbS.zi();
                    AppMethodBeat.o(261971);
                    return 0;
                case 4:
                    fVar.source = aVar3.UbS.zi();
                    AppMethodBeat.o(261971);
                    return 0;
                default:
                    AppMethodBeat.o(261971);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261971);
            return -1;
        }
    }
}
