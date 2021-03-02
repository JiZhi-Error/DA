package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cty extends a {
    public String KUC;
    public String KUD;
    public String KZQ;
    public String Mzi;
    public int Mzj;
    public String Mzk;
    public int Mzl;
    public int duration;
    public int height;
    public String iAq;
    public String title;
    public String vid;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(176147);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mzi != null) {
                aVar.e(1, this.Mzi);
            }
            aVar.aM(2, this.duration);
            if (this.KUC != null) {
                aVar.e(3, this.KUC);
            }
            if (this.KUD != null) {
                aVar.e(4, this.KUD);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.iAq != null) {
                aVar.e(6, this.iAq);
            }
            aVar.aM(7, this.Mzj);
            aVar.aM(8, this.width);
            aVar.aM(9, this.height);
            if (this.KZQ != null) {
                aVar.e(10, this.KZQ);
            }
            if (this.vid != null) {
                aVar.e(11, this.vid);
            }
            if (this.Mzk != null) {
                aVar.e(12, this.Mzk);
            }
            aVar.aM(13, this.Mzl);
            AppMethodBeat.o(176147);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Mzi != null ? g.a.a.b.b.a.f(1, this.Mzi) + 0 : 0) + g.a.a.b.b.a.bu(2, this.duration);
            if (this.KUC != null) {
                f2 += g.a.a.b.b.a.f(3, this.KUC);
            }
            if (this.KUD != null) {
                f2 += g.a.a.b.b.a.f(4, this.KUD);
            }
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(5, this.title);
            }
            if (this.iAq != null) {
                f2 += g.a.a.b.b.a.f(6, this.iAq);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.Mzj) + g.a.a.b.b.a.bu(8, this.width) + g.a.a.b.b.a.bu(9, this.height);
            if (this.KZQ != null) {
                bu += g.a.a.b.b.a.f(10, this.KZQ);
            }
            if (this.vid != null) {
                bu += g.a.a.b.b.a.f(11, this.vid);
            }
            if (this.Mzk != null) {
                bu += g.a.a.b.b.a.f(12, this.Mzk);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(13, this.Mzl);
            AppMethodBeat.o(176147);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(176147);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cty cty = (cty) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cty.Mzi = aVar3.UbS.readString();
                    AppMethodBeat.o(176147);
                    return 0;
                case 2:
                    cty.duration = aVar3.UbS.zi();
                    AppMethodBeat.o(176147);
                    return 0;
                case 3:
                    cty.KUC = aVar3.UbS.readString();
                    AppMethodBeat.o(176147);
                    return 0;
                case 4:
                    cty.KUD = aVar3.UbS.readString();
                    AppMethodBeat.o(176147);
                    return 0;
                case 5:
                    cty.title = aVar3.UbS.readString();
                    AppMethodBeat.o(176147);
                    return 0;
                case 6:
                    cty.iAq = aVar3.UbS.readString();
                    AppMethodBeat.o(176147);
                    return 0;
                case 7:
                    cty.Mzj = aVar3.UbS.zi();
                    AppMethodBeat.o(176147);
                    return 0;
                case 8:
                    cty.width = aVar3.UbS.zi();
                    AppMethodBeat.o(176147);
                    return 0;
                case 9:
                    cty.height = aVar3.UbS.zi();
                    AppMethodBeat.o(176147);
                    return 0;
                case 10:
                    cty.KZQ = aVar3.UbS.readString();
                    AppMethodBeat.o(176147);
                    return 0;
                case 11:
                    cty.vid = aVar3.UbS.readString();
                    AppMethodBeat.o(176147);
                    return 0;
                case 12:
                    cty.Mzk = aVar3.UbS.readString();
                    AppMethodBeat.o(176147);
                    return 0;
                case 13:
                    cty.Mzl = aVar3.UbS.zi();
                    AppMethodBeat.o(176147);
                    return 0;
                default:
                    AppMethodBeat.o(176147);
                    return -1;
            }
        } else {
            AppMethodBeat.o(176147);
            return -1;
        }
    }
}
