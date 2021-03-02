package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dqn extends a {
    public String LZy;
    public String MJR;
    public String MJS;
    public int oTz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91678);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LZy != null) {
                aVar.e(1, this.LZy);
            }
            if (this.MJS != null) {
                aVar.e(2, this.MJS);
            }
            aVar.aM(3, this.oTz);
            if (this.MJR != null) {
                aVar.e(4, this.MJR);
            }
            AppMethodBeat.o(91678);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LZy != null ? g.a.a.b.b.a.f(1, this.LZy) + 0 : 0;
            if (this.MJS != null) {
                f2 += g.a.a.b.b.a.f(2, this.MJS);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.oTz);
            if (this.MJR != null) {
                bu += g.a.a.b.b.a.f(4, this.MJR);
            }
            AppMethodBeat.o(91678);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91678);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dqn dqn = (dqn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dqn.LZy = aVar3.UbS.readString();
                    AppMethodBeat.o(91678);
                    return 0;
                case 2:
                    dqn.MJS = aVar3.UbS.readString();
                    AppMethodBeat.o(91678);
                    return 0;
                case 3:
                    dqn.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(91678);
                    return 0;
                case 4:
                    dqn.MJR = aVar3.UbS.readString();
                    AppMethodBeat.o(91678);
                    return 0;
                default:
                    AppMethodBeat.o(91678);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91678);
            return -1;
        }
    }
}
