package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aul extends a {
    public int LFn;
    public long LFo;
    public String dMW;
    public String iAR;
    public int likeFlag;
    public String nickName;
    public long tsR;
    public int unreadFlag;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209478);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.nickName != null) {
                aVar.e(1, this.nickName);
            }
            if (this.iAR != null) {
                aVar.e(2, this.iAR);
            }
            aVar.bb(3, this.tsR);
            aVar.aM(4, this.likeFlag);
            aVar.aM(5, this.LFn);
            if (this.dMW != null) {
                aVar.e(6, this.dMW);
            }
            aVar.bb(7, this.LFo);
            aVar.aM(8, this.unreadFlag);
            AppMethodBeat.o(209478);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.nickName != null ? g.a.a.b.b.a.f(1, this.nickName) + 0 : 0;
            if (this.iAR != null) {
                f2 += g.a.a.b.b.a.f(2, this.iAR);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.tsR) + g.a.a.b.b.a.bu(4, this.likeFlag) + g.a.a.b.b.a.bu(5, this.LFn);
            if (this.dMW != null) {
                r += g.a.a.b.b.a.f(6, this.dMW);
            }
            int r2 = r + g.a.a.b.b.a.r(7, this.LFo) + g.a.a.b.b.a.bu(8, this.unreadFlag);
            AppMethodBeat.o(209478);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209478);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aul aul = (aul) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aul.nickName = aVar3.UbS.readString();
                    AppMethodBeat.o(209478);
                    return 0;
                case 2:
                    aul.iAR = aVar3.UbS.readString();
                    AppMethodBeat.o(209478);
                    return 0;
                case 3:
                    aul.tsR = aVar3.UbS.zl();
                    AppMethodBeat.o(209478);
                    return 0;
                case 4:
                    aul.likeFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209478);
                    return 0;
                case 5:
                    aul.LFn = aVar3.UbS.zi();
                    AppMethodBeat.o(209478);
                    return 0;
                case 6:
                    aul.dMW = aVar3.UbS.readString();
                    AppMethodBeat.o(209478);
                    return 0;
                case 7:
                    aul.LFo = aVar3.UbS.zl();
                    AppMethodBeat.o(209478);
                    return 0;
                case 8:
                    aul.unreadFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209478);
                    return 0;
                default:
                    AppMethodBeat.o(209478);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209478);
            return -1;
        }
    }
}
