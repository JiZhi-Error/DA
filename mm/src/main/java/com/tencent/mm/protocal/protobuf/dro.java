package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dro extends a {
    public String AAN;
    public String Desc;
    public int Height;
    public String MUg;
    public String MUh;
    public int MUi;
    public String ThumbUrl;
    public String Title;
    public int Width;
    public int iAb;
    public String pLq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187878);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(2, this.Desc);
            }
            if (this.ThumbUrl != null) {
                aVar.e(3, this.ThumbUrl);
            }
            if (this.AAN != null) {
                aVar.e(4, this.AAN);
            }
            aVar.aM(5, this.iAb);
            if (this.MUg != null) {
                aVar.e(6, this.MUg);
            }
            if (this.MUh != null) {
                aVar.e(7, this.MUh);
            }
            if (this.pLq != null) {
                aVar.e(8, this.pLq);
            }
            aVar.aM(9, this.MUi);
            aVar.aM(10, this.Width);
            aVar.aM(11, this.Height);
            AppMethodBeat.o(187878);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.ThumbUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            if (this.AAN != null) {
                f2 += g.a.a.b.b.a.f(4, this.AAN);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.iAb);
            if (this.MUg != null) {
                bu += g.a.a.b.b.a.f(6, this.MUg);
            }
            if (this.MUh != null) {
                bu += g.a.a.b.b.a.f(7, this.MUh);
            }
            if (this.pLq != null) {
                bu += g.a.a.b.b.a.f(8, this.pLq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.MUi) + g.a.a.b.b.a.bu(10, this.Width) + g.a.a.b.b.a.bu(11, this.Height);
            AppMethodBeat.o(187878);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187878);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dro dro = (dro) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dro.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(187878);
                    return 0;
                case 2:
                    dro.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(187878);
                    return 0;
                case 3:
                    dro.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(187878);
                    return 0;
                case 4:
                    dro.AAN = aVar3.UbS.readString();
                    AppMethodBeat.o(187878);
                    return 0;
                case 5:
                    dro.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(187878);
                    return 0;
                case 6:
                    dro.MUg = aVar3.UbS.readString();
                    AppMethodBeat.o(187878);
                    return 0;
                case 7:
                    dro.MUh = aVar3.UbS.readString();
                    AppMethodBeat.o(187878);
                    return 0;
                case 8:
                    dro.pLq = aVar3.UbS.readString();
                    AppMethodBeat.o(187878);
                    return 0;
                case 9:
                    dro.MUi = aVar3.UbS.zi();
                    AppMethodBeat.o(187878);
                    return 0;
                case 10:
                    dro.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(187878);
                    return 0;
                case 11:
                    dro.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(187878);
                    return 0;
                default:
                    AppMethodBeat.o(187878);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187878);
            return -1;
        }
    }
}
