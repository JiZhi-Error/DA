package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class n extends a {
    public int duration;
    public int height;
    public String iAz;
    public String jTB;
    public String title;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40882);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.iAz != null) {
                aVar.e(1, this.iAz);
            }
            if (this.jTB != null) {
                aVar.e(2, this.jTB);
            }
            aVar.aM(3, this.height);
            aVar.aM(4, this.width);
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            aVar.aM(6, this.duration);
            AppMethodBeat.o(40882);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.iAz != null ? g.a.a.b.b.a.f(1, this.iAz) + 0 : 0;
            if (this.jTB != null) {
                f2 += g.a.a.b.b.a.f(2, this.jTB);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.height) + g.a.a.b.b.a.bu(4, this.width);
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(5, this.title);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.duration);
            AppMethodBeat.o(40882);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40882);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.iAz = aVar3.UbS.readString();
                    AppMethodBeat.o(40882);
                    return 0;
                case 2:
                    nVar.jTB = aVar3.UbS.readString();
                    AppMethodBeat.o(40882);
                    return 0;
                case 3:
                    nVar.height = aVar3.UbS.zi();
                    AppMethodBeat.o(40882);
                    return 0;
                case 4:
                    nVar.width = aVar3.UbS.zi();
                    AppMethodBeat.o(40882);
                    return 0;
                case 5:
                    nVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(40882);
                    return 0;
                case 6:
                    nVar.duration = aVar3.UbS.zi();
                    AppMethodBeat.o(40882);
                    return 0;
                default:
                    AppMethodBeat.o(40882);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40882);
            return -1;
        }
    }
}
