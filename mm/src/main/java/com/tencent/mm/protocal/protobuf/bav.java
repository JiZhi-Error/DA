package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bav extends a {
    public int LKt;
    public float LKu;
    public int LKv;
    public int LKw;
    public float LKx;
    public int LKy;
    public int uUm;
    public int uUn;
    public int uUr;
    public int uUs;
    public int uUu;
    public int uUy;
    public int uUz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184205);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uUm);
            aVar.aM(2, this.uUn);
            aVar.aM(3, this.LKt);
            aVar.E(4, this.LKu);
            aVar.aM(5, this.LKv);
            aVar.aM(6, this.LKw);
            aVar.aM(7, this.uUr);
            aVar.aM(8, this.uUs);
            aVar.E(9, this.LKx);
            aVar.aM(10, this.uUu);
            aVar.aM(11, this.LKy);
            aVar.aM(12, this.uUy);
            aVar.aM(13, this.uUz);
            AppMethodBeat.o(184205);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uUm) + 0 + g.a.a.b.b.a.bu(2, this.uUn) + g.a.a.b.b.a.bu(3, this.LKt) + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.bu(5, this.LKv) + g.a.a.b.b.a.bu(6, this.LKw) + g.a.a.b.b.a.bu(7, this.uUr) + g.a.a.b.b.a.bu(8, this.uUs) + g.a.a.b.b.a.fS(9) + 4 + g.a.a.b.b.a.bu(10, this.uUu) + g.a.a.b.b.a.bu(11, this.LKy) + g.a.a.b.b.a.bu(12, this.uUy) + g.a.a.b.b.a.bu(13, this.uUz);
            AppMethodBeat.o(184205);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184205);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bav bav = (bav) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bav.uUm = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 2:
                    bav.uUn = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 3:
                    bav.LKt = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 4:
                    bav.LKu = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(184205);
                    return 0;
                case 5:
                    bav.LKv = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 6:
                    bav.LKw = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 7:
                    bav.uUr = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 8:
                    bav.uUs = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 9:
                    bav.LKx = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(184205);
                    return 0;
                case 10:
                    bav.uUu = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 11:
                    bav.LKy = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 12:
                    bav.uUy = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                case 13:
                    bav.uUz = aVar3.UbS.zi();
                    AppMethodBeat.o(184205);
                    return 0;
                default:
                    AppMethodBeat.o(184205);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184205);
            return -1;
        }
    }
}
