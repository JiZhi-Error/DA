package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class cst extends a {
    public int MxI;
    public String MxJ;
    public int MxN;
    public int MxP;
    public String Vkb;
    public int Vkc;
    public long Vkd;
    public long Vke;
    public long Vkf;
    public int Vkg;
    public String sGQ;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(219129);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.scene);
            if (this.sGQ != null) {
                aVar.e(2, this.sGQ);
            }
            aVar.aM(3, this.MxI);
            if (this.MxJ != null) {
                aVar.e(4, this.MxJ);
            }
            aVar.aM(5, this.MxN);
            if (this.Vkb != null) {
                aVar.e(6, this.Vkb);
            }
            aVar.aM(7, this.MxP);
            aVar.aM(8, this.Vkc);
            aVar.bb(9, this.Vkd);
            aVar.bb(10, this.Vke);
            aVar.bb(11, this.Vkf);
            aVar.aM(12, this.Vkg);
            AppMethodBeat.o(219129);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.scene) + 0;
            if (this.sGQ != null) {
                bu += g.a.a.b.b.a.f(2, this.sGQ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.MxI);
            if (this.MxJ != null) {
                bu2 += g.a.a.b.b.a.f(4, this.MxJ);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(5, this.MxN);
            if (this.Vkb != null) {
                bu3 += g.a.a.b.b.a.f(6, this.Vkb);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(7, this.MxP) + g.a.a.b.b.a.bu(8, this.Vkc) + g.a.a.b.b.a.r(9, this.Vkd) + g.a.a.b.b.a.r(10, this.Vke) + g.a.a.b.b.a.r(11, this.Vkf) + g.a.a.b.b.a.bu(12, this.Vkg);
            AppMethodBeat.o(219129);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(219129);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cst cst = (cst) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cst.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(219129);
                    return 0;
                case 2:
                    cst.sGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(219129);
                    return 0;
                case 3:
                    cst.MxI = aVar3.UbS.zi();
                    AppMethodBeat.o(219129);
                    return 0;
                case 4:
                    cst.MxJ = aVar3.UbS.readString();
                    AppMethodBeat.o(219129);
                    return 0;
                case 5:
                    cst.MxN = aVar3.UbS.zi();
                    AppMethodBeat.o(219129);
                    return 0;
                case 6:
                    cst.Vkb = aVar3.UbS.readString();
                    AppMethodBeat.o(219129);
                    return 0;
                case 7:
                    cst.MxP = aVar3.UbS.zi();
                    AppMethodBeat.o(219129);
                    return 0;
                case 8:
                    cst.Vkc = aVar3.UbS.zi();
                    AppMethodBeat.o(219129);
                    return 0;
                case 9:
                    cst.Vkd = aVar3.UbS.zl();
                    AppMethodBeat.o(219129);
                    return 0;
                case 10:
                    cst.Vke = aVar3.UbS.zl();
                    AppMethodBeat.o(219129);
                    return 0;
                case 11:
                    cst.Vkf = aVar3.UbS.zl();
                    AppMethodBeat.o(219129);
                    return 0;
                case 12:
                    cst.Vkg = aVar3.UbS.zi();
                    AppMethodBeat.o(219129);
                    return 0;
                default:
                    AppMethodBeat.o(219129);
                    return -1;
            }
        } else {
            AppMethodBeat.o(219129);
            return -1;
        }
    }
}
