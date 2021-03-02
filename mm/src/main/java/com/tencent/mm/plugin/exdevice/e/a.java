package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends com.tencent.mm.bw.a {
    public int rBx;
    public String rBy;
    public String rBz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23482);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.rBx);
            if (this.rBy != null) {
                aVar.e(2, this.rBy);
            }
            if (this.rBz != null) {
                aVar.e(3, this.rBz);
            }
            AppMethodBeat.o(23482);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.rBx) + 0;
            if (this.rBy != null) {
                bu += g.a.a.b.b.a.f(2, this.rBy);
            }
            if (this.rBz != null) {
                bu += g.a.a.b.b.a.f(3, this.rBz);
            }
            AppMethodBeat.o(23482);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(23482);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.rBx = aVar3.UbS.zi();
                    AppMethodBeat.o(23482);
                    return 0;
                case 2:
                    aVar4.rBy = aVar3.UbS.readString();
                    AppMethodBeat.o(23482);
                    return 0;
                case 3:
                    aVar4.rBz = aVar3.UbS.readString();
                    AppMethodBeat.o(23482);
                    return 0;
                default:
                    AppMethodBeat.o(23482);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23482);
            return -1;
        }
    }
}
