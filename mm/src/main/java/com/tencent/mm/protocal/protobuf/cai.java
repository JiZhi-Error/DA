package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cai extends a {
    public int MfA;
    public String MfB;
    public long Mfy;
    public long Mfz;
    public String nickname;
    public String username;
    public String yPH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91519);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Mfy);
            aVar.bb(2, this.Mfz);
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.yPH != null) {
                aVar.e(4, this.yPH);
            }
            aVar.aM(5, this.MfA);
            if (this.username != null) {
                aVar.e(6, this.username);
            }
            if (this.MfB != null) {
                aVar.e(7, this.MfB);
            }
            AppMethodBeat.o(91519);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Mfy) + 0 + g.a.a.b.b.a.r(2, this.Mfz);
            if (this.nickname != null) {
                r += g.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.yPH != null) {
                r += g.a.a.b.b.a.f(4, this.yPH);
            }
            int bu = r + g.a.a.b.b.a.bu(5, this.MfA);
            if (this.username != null) {
                bu += g.a.a.b.b.a.f(6, this.username);
            }
            if (this.MfB != null) {
                bu += g.a.a.b.b.a.f(7, this.MfB);
            }
            AppMethodBeat.o(91519);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91519);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cai cai = (cai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cai.Mfy = aVar3.UbS.zl();
                    AppMethodBeat.o(91519);
                    return 0;
                case 2:
                    cai.Mfz = aVar3.UbS.zl();
                    AppMethodBeat.o(91519);
                    return 0;
                case 3:
                    cai.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(91519);
                    return 0;
                case 4:
                    cai.yPH = aVar3.UbS.readString();
                    AppMethodBeat.o(91519);
                    return 0;
                case 5:
                    cai.MfA = aVar3.UbS.zi();
                    AppMethodBeat.o(91519);
                    return 0;
                case 6:
                    cai.username = aVar3.UbS.readString();
                    AppMethodBeat.o(91519);
                    return 0;
                case 7:
                    cai.MfB = aVar3.UbS.readString();
                    AppMethodBeat.o(91519);
                    return 0;
                default:
                    AppMethodBeat.o(91519);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91519);
            return -1;
        }
    }
}
