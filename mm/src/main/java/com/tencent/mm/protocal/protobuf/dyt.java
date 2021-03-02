package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dyt extends a {
    public String MYh;
    public String MYi;
    public String MYj;
    public int MYk;
    public String MYl;
    public String MYm;
    public String MYn;
    public int MYo;
    public int MYp;
    public int MYq;
    public int MYr;
    public int MYs;
    public int Scene;
    public String Title;
    public String Url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117927);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MYh == null) {
                b bVar = new b("Not all required fields were included: PickedWord");
                AppMethodBeat.o(117927);
                throw bVar;
            }
            if (this.MYh != null) {
                aVar.e(1, this.MYh);
            }
            if (this.MYi != null) {
                aVar.e(2, this.MYi);
            }
            if (this.MYj != null) {
                aVar.e(3, this.MYj);
            }
            aVar.aM(4, this.Scene);
            aVar.aM(5, this.MYk);
            if (this.Url != null) {
                aVar.e(6, this.Url);
            }
            if (this.Title != null) {
                aVar.e(7, this.Title);
            }
            if (this.MYl != null) {
                aVar.e(8, this.MYl);
            }
            if (this.MYm != null) {
                aVar.e(9, this.MYm);
            }
            if (this.MYn != null) {
                aVar.e(10, this.MYn);
            }
            aVar.aM(11, this.MYo);
            aVar.aM(12, this.MYp);
            aVar.aM(13, this.MYq);
            aVar.aM(14, this.MYr);
            aVar.aM(15, this.MYs);
            AppMethodBeat.o(117927);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MYh != null ? g.a.a.b.b.a.f(1, this.MYh) + 0 : 0;
            if (this.MYi != null) {
                f2 += g.a.a.b.b.a.f(2, this.MYi);
            }
            if (this.MYj != null) {
                f2 += g.a.a.b.b.a.f(3, this.MYj);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Scene) + g.a.a.b.b.a.bu(5, this.MYk);
            if (this.Url != null) {
                bu += g.a.a.b.b.a.f(6, this.Url);
            }
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(7, this.Title);
            }
            if (this.MYl != null) {
                bu += g.a.a.b.b.a.f(8, this.MYl);
            }
            if (this.MYm != null) {
                bu += g.a.a.b.b.a.f(9, this.MYm);
            }
            if (this.MYn != null) {
                bu += g.a.a.b.b.a.f(10, this.MYn);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.MYo) + g.a.a.b.b.a.bu(12, this.MYp) + g.a.a.b.b.a.bu(13, this.MYq) + g.a.a.b.b.a.bu(14, this.MYr) + g.a.a.b.b.a.bu(15, this.MYs);
            AppMethodBeat.o(117927);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MYh == null) {
                b bVar2 = new b("Not all required fields were included: PickedWord");
                AppMethodBeat.o(117927);
                throw bVar2;
            }
            AppMethodBeat.o(117927);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyt dyt = (dyt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dyt.MYh = aVar3.UbS.readString();
                    AppMethodBeat.o(117927);
                    return 0;
                case 2:
                    dyt.MYi = aVar3.UbS.readString();
                    AppMethodBeat.o(117927);
                    return 0;
                case 3:
                    dyt.MYj = aVar3.UbS.readString();
                    AppMethodBeat.o(117927);
                    return 0;
                case 4:
                    dyt.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117927);
                    return 0;
                case 5:
                    dyt.MYk = aVar3.UbS.zi();
                    AppMethodBeat.o(117927);
                    return 0;
                case 6:
                    dyt.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(117927);
                    return 0;
                case 7:
                    dyt.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(117927);
                    return 0;
                case 8:
                    dyt.MYl = aVar3.UbS.readString();
                    AppMethodBeat.o(117927);
                    return 0;
                case 9:
                    dyt.MYm = aVar3.UbS.readString();
                    AppMethodBeat.o(117927);
                    return 0;
                case 10:
                    dyt.MYn = aVar3.UbS.readString();
                    AppMethodBeat.o(117927);
                    return 0;
                case 11:
                    dyt.MYo = aVar3.UbS.zi();
                    AppMethodBeat.o(117927);
                    return 0;
                case 12:
                    dyt.MYp = aVar3.UbS.zi();
                    AppMethodBeat.o(117927);
                    return 0;
                case 13:
                    dyt.MYq = aVar3.UbS.zi();
                    AppMethodBeat.o(117927);
                    return 0;
                case 14:
                    dyt.MYr = aVar3.UbS.zi();
                    AppMethodBeat.o(117927);
                    return 0;
                case 15:
                    dyt.MYs = aVar3.UbS.zi();
                    AppMethodBeat.o(117927);
                    return 0;
                default:
                    AppMethodBeat.o(117927);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117927);
            return -1;
        }
    }
}
