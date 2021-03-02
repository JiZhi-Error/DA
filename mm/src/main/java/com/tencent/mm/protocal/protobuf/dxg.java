package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dxg extends a {
    public String KDf;
    public String KDg;
    public int KDh;
    public String KJM;
    public String eaO;
    public String eaP;
    public String pRX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114073);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.eaO != null) {
                aVar.e(1, this.eaO);
            }
            if (this.pRX != null) {
                aVar.e(2, this.pRX);
            }
            if (this.eaP != null) {
                aVar.e(3, this.eaP);
            }
            if (this.KDf != null) {
                aVar.e(4, this.KDf);
            }
            if (this.KDg != null) {
                aVar.e(5, this.KDg);
            }
            aVar.aM(6, this.KDh);
            if (this.KJM != null) {
                aVar.e(7, this.KJM);
            }
            AppMethodBeat.o(114073);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.eaO != null ? g.a.a.b.b.a.f(1, this.eaO) + 0 : 0;
            if (this.pRX != null) {
                f2 += g.a.a.b.b.a.f(2, this.pRX);
            }
            if (this.eaP != null) {
                f2 += g.a.a.b.b.a.f(3, this.eaP);
            }
            if (this.KDf != null) {
                f2 += g.a.a.b.b.a.f(4, this.KDf);
            }
            if (this.KDg != null) {
                f2 += g.a.a.b.b.a.f(5, this.KDg);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.KDh);
            if (this.KJM != null) {
                bu += g.a.a.b.b.a.f(7, this.KJM);
            }
            AppMethodBeat.o(114073);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114073);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxg dxg = (dxg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dxg.eaO = aVar3.UbS.readString();
                    AppMethodBeat.o(114073);
                    return 0;
                case 2:
                    dxg.pRX = aVar3.UbS.readString();
                    AppMethodBeat.o(114073);
                    return 0;
                case 3:
                    dxg.eaP = aVar3.UbS.readString();
                    AppMethodBeat.o(114073);
                    return 0;
                case 4:
                    dxg.KDf = aVar3.UbS.readString();
                    AppMethodBeat.o(114073);
                    return 0;
                case 5:
                    dxg.KDg = aVar3.UbS.readString();
                    AppMethodBeat.o(114073);
                    return 0;
                case 6:
                    dxg.KDh = aVar3.UbS.zi();
                    AppMethodBeat.o(114073);
                    return 0;
                case 7:
                    dxg.KJM = aVar3.UbS.readString();
                    AppMethodBeat.o(114073);
                    return 0;
                default:
                    AppMethodBeat.o(114073);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114073);
            return -1;
        }
    }
}
