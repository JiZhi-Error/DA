package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbx extends a {
    public String Cjw;
    public int Gaz;
    public String KBN;
    public String LWD;
    public long MhJ;
    public String MhL;
    public int MhN;
    public int MhO;
    public String MhP;
    public int nHh;
    public int pRN;
    public String pTn;
    public String qGB;
    public int state;
    public String yPK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72506);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LWD != null) {
                aVar.e(1, this.LWD);
            }
            if (this.KBN != null) {
                aVar.e(2, this.KBN);
            }
            aVar.bb(3, this.MhJ);
            aVar.aM(4, this.state);
            aVar.aM(5, this.Gaz);
            aVar.aM(6, this.pRN);
            aVar.aM(7, this.MhN);
            aVar.aM(8, this.MhO);
            if (this.MhP != null) {
                aVar.e(9, this.MhP);
            }
            if (this.pTn != null) {
                aVar.e(10, this.pTn);
            }
            if (this.yPK != null) {
                aVar.e(11, this.yPK);
            }
            if (this.qGB != null) {
                aVar.e(12, this.qGB);
            }
            if (this.Cjw != null) {
                aVar.e(13, this.Cjw);
            }
            if (this.MhL != null) {
                aVar.e(14, this.MhL);
            }
            aVar.aM(15, this.nHh);
            AppMethodBeat.o(72506);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LWD != null ? g.a.a.b.b.a.f(1, this.LWD) + 0 : 0;
            if (this.KBN != null) {
                f2 += g.a.a.b.b.a.f(2, this.KBN);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.MhJ) + g.a.a.b.b.a.bu(4, this.state) + g.a.a.b.b.a.bu(5, this.Gaz) + g.a.a.b.b.a.bu(6, this.pRN) + g.a.a.b.b.a.bu(7, this.MhN) + g.a.a.b.b.a.bu(8, this.MhO);
            if (this.MhP != null) {
                r += g.a.a.b.b.a.f(9, this.MhP);
            }
            if (this.pTn != null) {
                r += g.a.a.b.b.a.f(10, this.pTn);
            }
            if (this.yPK != null) {
                r += g.a.a.b.b.a.f(11, this.yPK);
            }
            if (this.qGB != null) {
                r += g.a.a.b.b.a.f(12, this.qGB);
            }
            if (this.Cjw != null) {
                r += g.a.a.b.b.a.f(13, this.Cjw);
            }
            if (this.MhL != null) {
                r += g.a.a.b.b.a.f(14, this.MhL);
            }
            int bu = r + g.a.a.b.b.a.bu(15, this.nHh);
            AppMethodBeat.o(72506);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72506);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbx cbx = (cbx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbx.LWD = aVar3.UbS.readString();
                    AppMethodBeat.o(72506);
                    return 0;
                case 2:
                    cbx.KBN = aVar3.UbS.readString();
                    AppMethodBeat.o(72506);
                    return 0;
                case 3:
                    cbx.MhJ = aVar3.UbS.zl();
                    AppMethodBeat.o(72506);
                    return 0;
                case 4:
                    cbx.state = aVar3.UbS.zi();
                    AppMethodBeat.o(72506);
                    return 0;
                case 5:
                    cbx.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(72506);
                    return 0;
                case 6:
                    cbx.pRN = aVar3.UbS.zi();
                    AppMethodBeat.o(72506);
                    return 0;
                case 7:
                    cbx.MhN = aVar3.UbS.zi();
                    AppMethodBeat.o(72506);
                    return 0;
                case 8:
                    cbx.MhO = aVar3.UbS.zi();
                    AppMethodBeat.o(72506);
                    return 0;
                case 9:
                    cbx.MhP = aVar3.UbS.readString();
                    AppMethodBeat.o(72506);
                    return 0;
                case 10:
                    cbx.pTn = aVar3.UbS.readString();
                    AppMethodBeat.o(72506);
                    return 0;
                case 11:
                    cbx.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(72506);
                    return 0;
                case 12:
                    cbx.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(72506);
                    return 0;
                case 13:
                    cbx.Cjw = aVar3.UbS.readString();
                    AppMethodBeat.o(72506);
                    return 0;
                case 14:
                    cbx.MhL = aVar3.UbS.readString();
                    AppMethodBeat.o(72506);
                    return 0;
                case 15:
                    cbx.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(72506);
                    return 0;
                default:
                    AppMethodBeat.o(72506);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72506);
            return -1;
        }
    }
}
