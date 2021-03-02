package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class i extends a {
    public int Height;
    public int Width;
    public int xuT;
    public String xuU;
    public String xuV;
    public boolean xuW;
    public int xuX;
    public int xuY;
    public long xui;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40875);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xuT);
            if (this.xuU != null) {
                aVar.e(2, this.xuU);
            }
            if (this.xuV != null) {
                aVar.e(3, this.xuV);
            }
            aVar.aM(4, this.Width);
            aVar.aM(5, this.Height);
            aVar.cc(6, this.xuW);
            aVar.aM(7, this.xuX);
            aVar.bb(8, this.xui);
            aVar.aM(9, this.xuY);
            AppMethodBeat.o(40875);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xuT) + 0;
            if (this.xuU != null) {
                bu += g.a.a.b.b.a.f(2, this.xuU);
            }
            if (this.xuV != null) {
                bu += g.a.a.b.b.a.f(3, this.xuV);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Width) + g.a.a.b.b.a.bu(5, this.Height) + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.bu(7, this.xuX) + g.a.a.b.b.a.r(8, this.xui) + g.a.a.b.b.a.bu(9, this.xuY);
            AppMethodBeat.o(40875);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40875);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.xuT = aVar3.UbS.zi();
                    AppMethodBeat.o(40875);
                    return 0;
                case 2:
                    iVar.xuU = aVar3.UbS.readString();
                    AppMethodBeat.o(40875);
                    return 0;
                case 3:
                    iVar.xuV = aVar3.UbS.readString();
                    AppMethodBeat.o(40875);
                    return 0;
                case 4:
                    iVar.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(40875);
                    return 0;
                case 5:
                    iVar.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(40875);
                    return 0;
                case 6:
                    iVar.xuW = aVar3.UbS.yZ();
                    AppMethodBeat.o(40875);
                    return 0;
                case 7:
                    iVar.xuX = aVar3.UbS.zi();
                    AppMethodBeat.o(40875);
                    return 0;
                case 8:
                    iVar.xui = aVar3.UbS.zl();
                    AppMethodBeat.o(40875);
                    return 0;
                case 9:
                    iVar.xuY = aVar3.UbS.zi();
                    AppMethodBeat.o(40875);
                    return 0;
                default:
                    AppMethodBeat.o(40875);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40875);
            return -1;
        }
    }
}
