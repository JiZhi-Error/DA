package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ciy extends a {
    public String KDS;
    public String MnL;
    public String MnR;
    public String nickname;
    public String qFV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207503);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MnR != null) {
                aVar.e(1, this.MnR);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.qFV != null) {
                aVar.e(3, this.qFV);
            }
            if (this.MnL != null) {
                aVar.e(4, this.MnL);
            }
            if (this.KDS != null) {
                aVar.e(5, this.KDS);
            }
            AppMethodBeat.o(207503);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MnR != null ? g.a.a.b.b.a.f(1, this.MnR) + 0 : 0;
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.qFV != null) {
                f2 += g.a.a.b.b.a.f(3, this.qFV);
            }
            if (this.MnL != null) {
                f2 += g.a.a.b.b.a.f(4, this.MnL);
            }
            if (this.KDS != null) {
                f2 += g.a.a.b.b.a.f(5, this.KDS);
            }
            AppMethodBeat.o(207503);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207503);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ciy ciy = (ciy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ciy.MnR = aVar3.UbS.readString();
                    AppMethodBeat.o(207503);
                    return 0;
                case 2:
                    ciy.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(207503);
                    return 0;
                case 3:
                    ciy.qFV = aVar3.UbS.readString();
                    AppMethodBeat.o(207503);
                    return 0;
                case 4:
                    ciy.MnL = aVar3.UbS.readString();
                    AppMethodBeat.o(207503);
                    return 0;
                case 5:
                    ciy.KDS = aVar3.UbS.readString();
                    AppMethodBeat.o(207503);
                    return 0;
                default:
                    AppMethodBeat.o(207503);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207503);
            return -1;
        }
    }
}
