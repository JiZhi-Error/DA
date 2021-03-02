package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dr extends a {
    public String xIB;
    public String xIJ;
    public String xNi;
    public String xNj;
    public String xNk;
    public boolean xNl;
    public boolean xNm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41833);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xIJ != null) {
                aVar.e(1, this.xIJ);
            }
            if (this.xNi != null) {
                aVar.e(2, this.xNi);
            }
            if (this.xNj != null) {
                aVar.e(3, this.xNj);
            }
            if (this.xNk != null) {
                aVar.e(4, this.xNk);
            }
            if (this.xIB != null) {
                aVar.e(5, this.xIB);
            }
            aVar.cc(6, this.xNl);
            aVar.cc(7, this.xNm);
            AppMethodBeat.o(41833);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xIJ != null ? g.a.a.b.b.a.f(1, this.xIJ) + 0 : 0;
            if (this.xNi != null) {
                f2 += g.a.a.b.b.a.f(2, this.xNi);
            }
            if (this.xNj != null) {
                f2 += g.a.a.b.b.a.f(3, this.xNj);
            }
            if (this.xNk != null) {
                f2 += g.a.a.b.b.a.f(4, this.xNk);
            }
            if (this.xIB != null) {
                f2 += g.a.a.b.b.a.f(5, this.xIB);
            }
            int fS = f2 + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.fS(7) + 1;
            AppMethodBeat.o(41833);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41833);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dr drVar = (dr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drVar.xIJ = aVar3.UbS.readString();
                    AppMethodBeat.o(41833);
                    return 0;
                case 2:
                    drVar.xNi = aVar3.UbS.readString();
                    AppMethodBeat.o(41833);
                    return 0;
                case 3:
                    drVar.xNj = aVar3.UbS.readString();
                    AppMethodBeat.o(41833);
                    return 0;
                case 4:
                    drVar.xNk = aVar3.UbS.readString();
                    AppMethodBeat.o(41833);
                    return 0;
                case 5:
                    drVar.xIB = aVar3.UbS.readString();
                    AppMethodBeat.o(41833);
                    return 0;
                case 6:
                    drVar.xNl = aVar3.UbS.yZ();
                    AppMethodBeat.o(41833);
                    return 0;
                case 7:
                    drVar.xNm = aVar3.UbS.yZ();
                    AppMethodBeat.o(41833);
                    return 0;
                default:
                    AppMethodBeat.o(41833);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41833);
            return -1;
        }
    }
}
