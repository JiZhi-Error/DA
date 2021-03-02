package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class d extends a {
    public int dXJ;
    public String desc;
    public String tfO;
    public String thumbPath;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(94810);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.thumbPath != null) {
                aVar.e(3, this.thumbPath);
            }
            aVar.aM(4, this.dXJ);
            if (this.tfO != null) {
                aVar.e(5, this.tfO);
            }
            AppMethodBeat.o(94810);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.thumbPath != null) {
                f2 += g.a.a.b.b.a.f(3, this.thumbPath);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.dXJ);
            if (this.tfO != null) {
                bu += g.a.a.b.b.a.f(5, this.tfO);
            }
            AppMethodBeat.o(94810);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(94810);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(94810);
                    return 0;
                case 2:
                    dVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(94810);
                    return 0;
                case 3:
                    dVar.thumbPath = aVar3.UbS.readString();
                    AppMethodBeat.o(94810);
                    return 0;
                case 4:
                    dVar.dXJ = aVar3.UbS.zi();
                    AppMethodBeat.o(94810);
                    return 0;
                case 5:
                    dVar.tfO = aVar3.UbS.readString();
                    AppMethodBeat.o(94810);
                    return 0;
                default:
                    AppMethodBeat.o(94810);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94810);
            return -1;
        }
    }
}
