package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bus extends a {
    public String MaX;
    public int MaY;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187871);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Scene);
            if (this.MaX != null) {
                aVar.e(2, this.MaX);
            }
            aVar.aM(3, this.MaY);
            AppMethodBeat.o(187871);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Scene) + 0;
            if (this.MaX != null) {
                bu += g.a.a.b.b.a.f(2, this.MaX);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.MaY);
            AppMethodBeat.o(187871);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187871);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bus bus = (bus) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bus.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(187871);
                    return 0;
                case 2:
                    bus.MaX = aVar3.UbS.readString();
                    AppMethodBeat.o(187871);
                    return 0;
                case 3:
                    bus.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(187871);
                    return 0;
                default:
                    AppMethodBeat.o(187871);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187871);
            return -1;
        }
    }
}
