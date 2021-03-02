package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class gh extends a {
    public int KKc;
    public int KKd;
    public int KKe;
    public int KKf;
    public int KKg;
    public String KKh;
    public int KKi;
    public int height;
    public long pHr;
    public String url;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103201);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            aVar.aM(2, this.KKc);
            aVar.aM(3, this.KKd);
            aVar.bb(4, this.pHr);
            aVar.aM(5, this.width);
            aVar.aM(6, this.height);
            aVar.aM(10, this.KKe);
            aVar.aM(11, this.KKf);
            aVar.aM(12, this.KKg);
            if (this.KKh != null) {
                aVar.e(13, this.KKh);
            }
            aVar.aM(15, this.KKi);
            AppMethodBeat.o(103201);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KKc) + g.a.a.b.b.a.bu(3, this.KKd) + g.a.a.b.b.a.r(4, this.pHr) + g.a.a.b.b.a.bu(5, this.width) + g.a.a.b.b.a.bu(6, this.height) + g.a.a.b.b.a.bu(10, this.KKe) + g.a.a.b.b.a.bu(11, this.KKf) + g.a.a.b.b.a.bu(12, this.KKg);
            if (this.KKh != null) {
                f2 += g.a.a.b.b.a.f(13, this.KKh);
            }
            int bu = f2 + g.a.a.b.b.a.bu(15, this.KKi);
            AppMethodBeat.o(103201);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103201);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            gh ghVar = (gh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ghVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(103201);
                    return 0;
                case 2:
                    ghVar.KKc = aVar3.UbS.zi();
                    AppMethodBeat.o(103201);
                    return 0;
                case 3:
                    ghVar.KKd = aVar3.UbS.zi();
                    AppMethodBeat.o(103201);
                    return 0;
                case 4:
                    ghVar.pHr = aVar3.UbS.zl();
                    AppMethodBeat.o(103201);
                    return 0;
                case 5:
                    ghVar.width = aVar3.UbS.zi();
                    AppMethodBeat.o(103201);
                    return 0;
                case 6:
                    ghVar.height = aVar3.UbS.zi();
                    AppMethodBeat.o(103201);
                    return 0;
                case 7:
                case 8:
                case 9:
                case 14:
                default:
                    AppMethodBeat.o(103201);
                    return -1;
                case 10:
                    ghVar.KKe = aVar3.UbS.zi();
                    AppMethodBeat.o(103201);
                    return 0;
                case 11:
                    ghVar.KKf = aVar3.UbS.zi();
                    AppMethodBeat.o(103201);
                    return 0;
                case 12:
                    ghVar.KKg = aVar3.UbS.zi();
                    AppMethodBeat.o(103201);
                    return 0;
                case 13:
                    ghVar.KKh = aVar3.UbS.readString();
                    AppMethodBeat.o(103201);
                    return 0;
                case 15:
                    ghVar.KKi = aVar3.UbS.zi();
                    AppMethodBeat.o(103201);
                    return 0;
            }
        } else {
            AppMethodBeat.o(103201);
            return -1;
        }
    }
}
