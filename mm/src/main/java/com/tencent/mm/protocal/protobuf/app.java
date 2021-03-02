package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class app extends a {
    public int LBx;
    public int LBy;
    public int LBz;
    public String country;
    public int fuA;
    public String fuJ;
    public String fuK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168946);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.country != null) {
                aVar.e(1, this.country);
            }
            if (this.fuJ != null) {
                aVar.e(2, this.fuJ);
            }
            if (this.fuK != null) {
                aVar.e(3, this.fuK);
            }
            aVar.aM(4, this.fuA);
            aVar.aM(5, this.LBx);
            aVar.aM(6, this.LBy);
            aVar.aM(7, this.LBz);
            AppMethodBeat.o(168946);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.country != null ? g.a.a.b.b.a.f(1, this.country) + 0 : 0;
            if (this.fuJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.fuJ);
            }
            if (this.fuK != null) {
                f2 += g.a.a.b.b.a.f(3, this.fuK);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.fuA) + g.a.a.b.b.a.bu(5, this.LBx) + g.a.a.b.b.a.bu(6, this.LBy) + g.a.a.b.b.a.bu(7, this.LBz);
            AppMethodBeat.o(168946);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168946);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            app app = (app) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    app.country = aVar3.UbS.readString();
                    AppMethodBeat.o(168946);
                    return 0;
                case 2:
                    app.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(168946);
                    return 0;
                case 3:
                    app.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(168946);
                    return 0;
                case 4:
                    app.fuA = aVar3.UbS.zi();
                    AppMethodBeat.o(168946);
                    return 0;
                case 5:
                    app.LBx = aVar3.UbS.zi();
                    AppMethodBeat.o(168946);
                    return 0;
                case 6:
                    app.LBy = aVar3.UbS.zi();
                    AppMethodBeat.o(168946);
                    return 0;
                case 7:
                    app.LBz = aVar3.UbS.zi();
                    AppMethodBeat.o(168946);
                    return 0;
                default:
                    AppMethodBeat.o(168946);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168946);
            return -1;
        }
    }
}
