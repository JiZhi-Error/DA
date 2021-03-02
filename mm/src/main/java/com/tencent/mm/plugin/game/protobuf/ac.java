package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ac extends a {
    public String jfi;
    public String xIG;
    public int xJZ;
    public int xKa;
    public int xKb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41722);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xJZ);
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            aVar.aM(3, this.xKa);
            if (this.xIG != null) {
                aVar.e(4, this.xIG);
            }
            aVar.aM(5, this.xKb);
            AppMethodBeat.o(41722);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xJZ) + 0;
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(2, this.jfi);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.xKa);
            if (this.xIG != null) {
                bu2 += g.a.a.b.b.a.f(4, this.xIG);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(5, this.xKb);
            AppMethodBeat.o(41722);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41722);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ac acVar = (ac) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acVar.xJZ = aVar3.UbS.zi();
                    AppMethodBeat.o(41722);
                    return 0;
                case 2:
                    acVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(41722);
                    return 0;
                case 3:
                    acVar.xKa = aVar3.UbS.zi();
                    AppMethodBeat.o(41722);
                    return 0;
                case 4:
                    acVar.xIG = aVar3.UbS.readString();
                    AppMethodBeat.o(41722);
                    return 0;
                case 5:
                    acVar.xKb = aVar3.UbS.zi();
                    AppMethodBeat.o(41722);
                    return 0;
                default:
                    AppMethodBeat.o(41722);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41722);
            return -1;
        }
    }
}
