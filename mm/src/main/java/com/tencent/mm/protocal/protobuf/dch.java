package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dch extends a {
    public String LoI;
    public String MHc;
    public String MHd;
    public String MHe;
    public String MHf;
    public String Title;
    public String URL;
    public String iAc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209783);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.iAc != null) {
                aVar.e(2, this.iAc);
            }
            if (this.MHc != null) {
                aVar.e(3, this.MHc);
            }
            if (this.MHd != null) {
                aVar.e(4, this.MHd);
            }
            if (this.MHe != null) {
                aVar.e(6, this.MHe);
            }
            if (this.LoI != null) {
                aVar.e(7, this.LoI);
            }
            if (this.URL != null) {
                aVar.e(8, this.URL);
            }
            if (this.MHf != null) {
                aVar.e(9, this.MHf);
            }
            AppMethodBeat.o(209783);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.iAc != null) {
                f2 += g.a.a.b.b.a.f(2, this.iAc);
            }
            if (this.MHc != null) {
                f2 += g.a.a.b.b.a.f(3, this.MHc);
            }
            if (this.MHd != null) {
                f2 += g.a.a.b.b.a.f(4, this.MHd);
            }
            if (this.MHe != null) {
                f2 += g.a.a.b.b.a.f(6, this.MHe);
            }
            if (this.LoI != null) {
                f2 += g.a.a.b.b.a.f(7, this.LoI);
            }
            if (this.URL != null) {
                f2 += g.a.a.b.b.a.f(8, this.URL);
            }
            if (this.MHf != null) {
                f2 += g.a.a.b.b.a.f(9, this.MHf);
            }
            AppMethodBeat.o(209783);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209783);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dch dch = (dch) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dch.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(209783);
                    return 0;
                case 2:
                    dch.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(209783);
                    return 0;
                case 3:
                    dch.MHc = aVar3.UbS.readString();
                    AppMethodBeat.o(209783);
                    return 0;
                case 4:
                    dch.MHd = aVar3.UbS.readString();
                    AppMethodBeat.o(209783);
                    return 0;
                case 5:
                default:
                    AppMethodBeat.o(209783);
                    return -1;
                case 6:
                    dch.MHe = aVar3.UbS.readString();
                    AppMethodBeat.o(209783);
                    return 0;
                case 7:
                    dch.LoI = aVar3.UbS.readString();
                    AppMethodBeat.o(209783);
                    return 0;
                case 8:
                    dch.URL = aVar3.UbS.readString();
                    AppMethodBeat.o(209783);
                    return 0;
                case 9:
                    dch.MHf = aVar3.UbS.readString();
                    AppMethodBeat.o(209783);
                    return 0;
            }
        } else {
            AppMethodBeat.o(209783);
            return -1;
        }
    }
}
