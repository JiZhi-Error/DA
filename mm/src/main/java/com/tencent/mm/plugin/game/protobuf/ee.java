package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ee extends a {
    public String xIx;
    public String xIy;
    public String xJt;
    public int xNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41838);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xIx != null) {
                aVar.e(1, this.xIx);
            }
            if (this.xIy != null) {
                aVar.e(2, this.xIy);
            }
            aVar.aM(3, this.xNF);
            if (this.xJt != null) {
                aVar.e(4, this.xJt);
            }
            AppMethodBeat.o(41838);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xIx != null ? g.a.a.b.b.a.f(1, this.xIx) + 0 : 0;
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(2, this.xIy);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.xNF);
            if (this.xJt != null) {
                bu += g.a.a.b.b.a.f(4, this.xJt);
            }
            AppMethodBeat.o(41838);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41838);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ee eeVar = (ee) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eeVar.xIx = aVar3.UbS.readString();
                    AppMethodBeat.o(41838);
                    return 0;
                case 2:
                    eeVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41838);
                    return 0;
                case 3:
                    eeVar.xNF = aVar3.UbS.zi();
                    AppMethodBeat.o(41838);
                    return 0;
                case 4:
                    eeVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41838);
                    return 0;
                default:
                    AppMethodBeat.o(41838);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41838);
            return -1;
        }
    }
}
