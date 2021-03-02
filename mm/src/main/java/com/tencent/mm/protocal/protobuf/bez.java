package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bez extends a {
    public int state;
    public String userName;
    public String yVk;
    public String yWG;
    public String yWH;
    public long yWo;
    public String yWp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214291);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.yWo);
            if (this.yWp != null) {
                aVar.e(2, this.yWp);
            }
            if (this.yVk != null) {
                aVar.e(3, this.yVk);
            }
            aVar.aM(4, this.state);
            if (this.yWG != null) {
                aVar.e(5, this.yWG);
            }
            if (this.userName != null) {
                aVar.e(6, this.userName);
            }
            if (this.yWH != null) {
                aVar.e(7, this.yWH);
            }
            AppMethodBeat.o(214291);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.yWo) + 0;
            if (this.yWp != null) {
                r += g.a.a.b.b.a.f(2, this.yWp);
            }
            if (this.yVk != null) {
                r += g.a.a.b.b.a.f(3, this.yVk);
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.state);
            if (this.yWG != null) {
                bu += g.a.a.b.b.a.f(5, this.yWG);
            }
            if (this.userName != null) {
                bu += g.a.a.b.b.a.f(6, this.userName);
            }
            if (this.yWH != null) {
                bu += g.a.a.b.b.a.f(7, this.yWH);
            }
            AppMethodBeat.o(214291);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214291);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bez bez = (bez) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bez.yWo = aVar3.UbS.zl();
                    AppMethodBeat.o(214291);
                    return 0;
                case 2:
                    bez.yWp = aVar3.UbS.readString();
                    AppMethodBeat.o(214291);
                    return 0;
                case 3:
                    bez.yVk = aVar3.UbS.readString();
                    AppMethodBeat.o(214291);
                    return 0;
                case 4:
                    bez.state = aVar3.UbS.zi();
                    AppMethodBeat.o(214291);
                    return 0;
                case 5:
                    bez.yWG = aVar3.UbS.readString();
                    AppMethodBeat.o(214291);
                    return 0;
                case 6:
                    bez.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(214291);
                    return 0;
                case 7:
                    bez.yWH = aVar3.UbS.readString();
                    AppMethodBeat.o(214291);
                    return 0;
                default:
                    AppMethodBeat.o(214291);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214291);
            return -1;
        }
    }
}
