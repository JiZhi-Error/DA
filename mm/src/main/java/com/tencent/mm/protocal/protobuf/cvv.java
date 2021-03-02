package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cvv extends a {
    public String LpH;
    public String LpI;
    public int MBo;
    public String MBp;
    public String MBq;
    public String appId;
    public String gCv;
    public String nickName;
    public String userName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152637);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.e(1, this.userName);
            }
            if (this.nickName != null) {
                aVar.e(2, this.nickName);
            }
            if (this.gCv != null) {
                aVar.e(3, this.gCv);
            }
            if (this.LpH != null) {
                aVar.e(4, this.LpH);
            }
            if (this.LpI != null) {
                aVar.e(5, this.LpI);
            }
            aVar.aM(6, this.MBo);
            if (this.appId != null) {
                aVar.e(7, this.appId);
            }
            if (this.MBp != null) {
                aVar.e(8, this.MBp);
            }
            if (this.MBq != null) {
                aVar.e(9, this.MBq);
            }
            AppMethodBeat.o(152637);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.userName != null ? g.a.a.b.b.a.f(1, this.userName) + 0 : 0;
            if (this.nickName != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickName);
            }
            if (this.gCv != null) {
                f2 += g.a.a.b.b.a.f(3, this.gCv);
            }
            if (this.LpH != null) {
                f2 += g.a.a.b.b.a.f(4, this.LpH);
            }
            if (this.LpI != null) {
                f2 += g.a.a.b.b.a.f(5, this.LpI);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.MBo);
            if (this.appId != null) {
                bu += g.a.a.b.b.a.f(7, this.appId);
            }
            if (this.MBp != null) {
                bu += g.a.a.b.b.a.f(8, this.MBp);
            }
            if (this.MBq != null) {
                bu += g.a.a.b.b.a.f(9, this.MBq);
            }
            AppMethodBeat.o(152637);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152637);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvv cvv = (cvv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvv.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(152637);
                    return 0;
                case 2:
                    cvv.nickName = aVar3.UbS.readString();
                    AppMethodBeat.o(152637);
                    return 0;
                case 3:
                    cvv.gCv = aVar3.UbS.readString();
                    AppMethodBeat.o(152637);
                    return 0;
                case 4:
                    cvv.LpH = aVar3.UbS.readString();
                    AppMethodBeat.o(152637);
                    return 0;
                case 5:
                    cvv.LpI = aVar3.UbS.readString();
                    AppMethodBeat.o(152637);
                    return 0;
                case 6:
                    cvv.MBo = aVar3.UbS.zi();
                    AppMethodBeat.o(152637);
                    return 0;
                case 7:
                    cvv.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(152637);
                    return 0;
                case 8:
                    cvv.MBp = aVar3.UbS.readString();
                    AppMethodBeat.o(152637);
                    return 0;
                case 9:
                    cvv.MBq = aVar3.UbS.readString();
                    AppMethodBeat.o(152637);
                    return 0;
                default:
                    AppMethodBeat.o(152637);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152637);
            return -1;
        }
    }
}
