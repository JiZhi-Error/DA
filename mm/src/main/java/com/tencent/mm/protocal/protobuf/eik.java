package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eik extends a {
    public int KJS;
    public String LOr;
    public String MEq;
    public String MRt;
    public String Mba;
    public String Mbb;
    public String NhF;
    public String NhG;
    public int Scene;
    public String Title;
    public String iAc;
    public String pLq;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117934);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mba != null) {
                aVar.e(1, this.Mba);
            }
            if (this.MEq != null) {
                aVar.e(2, this.MEq);
            }
            if (this.iAc != null) {
                aVar.e(3, this.iAc);
            }
            if (this.NhF != null) {
                aVar.e(4, this.NhF);
            }
            if (this.NhG != null) {
                aVar.e(5, this.NhG);
            }
            if (this.LOr != null) {
                aVar.e(6, this.LOr);
            }
            if (this.Title != null) {
                aVar.e(7, this.Title);
            }
            if (this.Mbb != null) {
                aVar.e(8, this.Mbb);
            }
            aVar.aM(9, this.Scene);
            aVar.aM(10, this.KJS);
            if (this.MRt != null) {
                aVar.e(11, this.MRt);
            }
            if (this.pLq != null) {
                aVar.e(12, this.pLq);
            }
            aVar.aM(13, this.xub);
            AppMethodBeat.o(117934);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mba != null ? g.a.a.b.b.a.f(1, this.Mba) + 0 : 0;
            if (this.MEq != null) {
                f2 += g.a.a.b.b.a.f(2, this.MEq);
            }
            if (this.iAc != null) {
                f2 += g.a.a.b.b.a.f(3, this.iAc);
            }
            if (this.NhF != null) {
                f2 += g.a.a.b.b.a.f(4, this.NhF);
            }
            if (this.NhG != null) {
                f2 += g.a.a.b.b.a.f(5, this.NhG);
            }
            if (this.LOr != null) {
                f2 += g.a.a.b.b.a.f(6, this.LOr);
            }
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(7, this.Title);
            }
            if (this.Mbb != null) {
                f2 += g.a.a.b.b.a.f(8, this.Mbb);
            }
            int bu = f2 + g.a.a.b.b.a.bu(9, this.Scene) + g.a.a.b.b.a.bu(10, this.KJS);
            if (this.MRt != null) {
                bu += g.a.a.b.b.a.f(11, this.MRt);
            }
            if (this.pLq != null) {
                bu += g.a.a.b.b.a.f(12, this.pLq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(13, this.xub);
            AppMethodBeat.o(117934);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117934);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eik eik = (eik) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eik.Mba = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 2:
                    eik.MEq = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 3:
                    eik.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 4:
                    eik.NhF = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 5:
                    eik.NhG = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 6:
                    eik.LOr = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 7:
                    eik.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 8:
                    eik.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 9:
                    eik.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117934);
                    return 0;
                case 10:
                    eik.KJS = aVar3.UbS.zi();
                    AppMethodBeat.o(117934);
                    return 0;
                case 11:
                    eik.MRt = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 12:
                    eik.pLq = aVar3.UbS.readString();
                    AppMethodBeat.o(117934);
                    return 0;
                case 13:
                    eik.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(117934);
                    return 0;
                default:
                    AppMethodBeat.o(117934);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117934);
            return -1;
        }
    }
}
