package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cmm extends a {
    public int MrI;
    public int MrJ;
    public long hFK;
    public int pHw;
    public int scene;
    public String sessionBuffer;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184214);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.hFK);
            aVar.aM(2, this.scene);
            aVar.aM(3, this.pHw);
            aVar.aM(4, this.MrI);
            if (this.sessionBuffer != null) {
                aVar.e(5, this.sessionBuffer);
            }
            aVar.aM(6, this.MrJ);
            AppMethodBeat.o(184214);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.hFK) + 0 + g.a.a.b.b.a.bu(2, this.scene) + g.a.a.b.b.a.bu(3, this.pHw) + g.a.a.b.b.a.bu(4, this.MrI);
            if (this.sessionBuffer != null) {
                r += g.a.a.b.b.a.f(5, this.sessionBuffer);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.MrJ);
            AppMethodBeat.o(184214);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184214);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmm cmm = (cmm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmm.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(184214);
                    return 0;
                case 2:
                    cmm.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(184214);
                    return 0;
                case 3:
                    cmm.pHw = aVar3.UbS.zi();
                    AppMethodBeat.o(184214);
                    return 0;
                case 4:
                    cmm.MrI = aVar3.UbS.zi();
                    AppMethodBeat.o(184214);
                    return 0;
                case 5:
                    cmm.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(184214);
                    return 0;
                case 6:
                    cmm.MrJ = aVar3.UbS.zi();
                    AppMethodBeat.o(184214);
                    return 0;
                default:
                    AppMethodBeat.o(184214);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184214);
            return -1;
        }
    }
}
