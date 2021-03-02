package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ehx extends a {
    public int dDG;
    public String path;
    public String qGB;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127285);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.dDG);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.qGB != null) {
                aVar.e(3, this.qGB);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            AppMethodBeat.o(127285);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.dDG) + 0;
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.qGB != null) {
                bu += g.a.a.b.b.a.f(3, this.qGB);
            }
            if (this.path != null) {
                bu += g.a.a.b.b.a.f(4, this.path);
            }
            AppMethodBeat.o(127285);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127285);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehx ehx = (ehx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ehx.dDG = aVar3.UbS.zi();
                    AppMethodBeat.o(127285);
                    return 0;
                case 2:
                    ehx.title = aVar3.UbS.readString();
                    AppMethodBeat.o(127285);
                    return 0;
                case 3:
                    ehx.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(127285);
                    return 0;
                case 4:
                    ehx.path = aVar3.UbS.readString();
                    AppMethodBeat.o(127285);
                    return 0;
                default:
                    AppMethodBeat.o(127285);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127285);
            return -1;
        }
    }
}
