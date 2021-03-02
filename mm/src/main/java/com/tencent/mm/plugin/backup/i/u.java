package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class u extends a {
    public String fQY;
    public String mediaId;
    public int oUr;
    public int oUs;
    public long oUt;
    public String path;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22126);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUr);
            if (this.fQY != null) {
                aVar.e(2, this.fQY);
            }
            if (this.mediaId != null) {
                aVar.e(3, this.mediaId);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            aVar.aM(5, this.type);
            aVar.aM(6, this.oUs);
            aVar.bb(7, this.oUt);
            AppMethodBeat.o(22126);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUr) + 0;
            if (this.fQY != null) {
                bu += g.a.a.b.b.a.f(2, this.fQY);
            }
            if (this.mediaId != null) {
                bu += g.a.a.b.b.a.f(3, this.mediaId);
            }
            if (this.path != null) {
                bu += g.a.a.b.b.a.f(4, this.path);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.type) + g.a.a.b.b.a.bu(6, this.oUs) + g.a.a.b.b.a.r(7, this.oUt);
            AppMethodBeat.o(22126);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(22126);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.oUr = aVar3.UbS.zi();
                    AppMethodBeat.o(22126);
                    return 0;
                case 2:
                    uVar.fQY = aVar3.UbS.readString();
                    AppMethodBeat.o(22126);
                    return 0;
                case 3:
                    uVar.mediaId = aVar3.UbS.readString();
                    AppMethodBeat.o(22126);
                    return 0;
                case 4:
                    uVar.path = aVar3.UbS.readString();
                    AppMethodBeat.o(22126);
                    return 0;
                case 5:
                    uVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(22126);
                    return 0;
                case 6:
                    uVar.oUs = aVar3.UbS.zi();
                    AppMethodBeat.o(22126);
                    return 0;
                case 7:
                    uVar.oUt = aVar3.UbS.zl();
                    AppMethodBeat.o(22126);
                    return 0;
                default:
                    AppMethodBeat.o(22126);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22126);
            return -1;
        }
    }
}
