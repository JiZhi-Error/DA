package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ace extends a {
    public int Gaz;
    public int KJL;
    public int LmJ;
    public String LmK;
    public int LmL;
    public int LmM;
    public int LmN;
    public int LmO;
    public String content;
    public String openid;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103206);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.content != null) {
                aVar.e(1, this.content);
            }
            if (this.openid != null) {
                aVar.e(3, this.openid);
            }
            aVar.aM(4, this.Gaz);
            aVar.aM(5, this.KJL);
            aVar.aM(6, this.LmJ);
            if (this.LmK != null) {
                aVar.e(7, this.LmK);
            }
            aVar.aM(8, this.LmL);
            aVar.aM(9, this.LmM);
            aVar.aM(10, this.LmN);
            aVar.aM(11, this.LmO);
            AppMethodBeat.o(103206);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.content != null ? g.a.a.b.b.a.f(1, this.content) + 0 : 0;
            if (this.openid != null) {
                f2 += g.a.a.b.b.a.f(3, this.openid);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Gaz) + g.a.a.b.b.a.bu(5, this.KJL) + g.a.a.b.b.a.bu(6, this.LmJ);
            if (this.LmK != null) {
                bu += g.a.a.b.b.a.f(7, this.LmK);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.LmL) + g.a.a.b.b.a.bu(9, this.LmM) + g.a.a.b.b.a.bu(10, this.LmN) + g.a.a.b.b.a.bu(11, this.LmO);
            AppMethodBeat.o(103206);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103206);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ace ace = (ace) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ace.content = aVar3.UbS.readString();
                    AppMethodBeat.o(103206);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(103206);
                    return -1;
                case 3:
                    ace.openid = aVar3.UbS.readString();
                    AppMethodBeat.o(103206);
                    return 0;
                case 4:
                    ace.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(103206);
                    return 0;
                case 5:
                    ace.KJL = aVar3.UbS.zi();
                    AppMethodBeat.o(103206);
                    return 0;
                case 6:
                    ace.LmJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103206);
                    return 0;
                case 7:
                    ace.LmK = aVar3.UbS.readString();
                    AppMethodBeat.o(103206);
                    return 0;
                case 8:
                    ace.LmL = aVar3.UbS.zi();
                    AppMethodBeat.o(103206);
                    return 0;
                case 9:
                    ace.LmM = aVar3.UbS.zi();
                    AppMethodBeat.o(103206);
                    return 0;
                case 10:
                    ace.LmN = aVar3.UbS.zi();
                    AppMethodBeat.o(103206);
                    return 0;
                case 11:
                    ace.LmO = aVar3.UbS.zi();
                    AppMethodBeat.o(103206);
                    return 0;
            }
        } else {
            AppMethodBeat.o(103206);
            return -1;
        }
    }
}
