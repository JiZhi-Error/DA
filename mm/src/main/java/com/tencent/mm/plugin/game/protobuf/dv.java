package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dv extends a {
    public String ixw;
    public String xHA;
    public String xNo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149418);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ixw != null) {
                aVar.e(1, this.ixw);
            }
            if (this.xHA != null) {
                aVar.e(2, this.xHA);
            }
            if (this.xNo != null) {
                aVar.e(3, this.xNo);
            }
            AppMethodBeat.o(149418);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ixw != null ? g.a.a.b.b.a.f(1, this.ixw) + 0 : 0;
            if (this.xHA != null) {
                f2 += g.a.a.b.b.a.f(2, this.xHA);
            }
            if (this.xNo != null) {
                f2 += g.a.a.b.b.a.f(3, this.xNo);
            }
            AppMethodBeat.o(149418);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(149418);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dv dvVar = (dv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dvVar.ixw = aVar3.UbS.readString();
                    AppMethodBeat.o(149418);
                    return 0;
                case 2:
                    dvVar.xHA = aVar3.UbS.readString();
                    AppMethodBeat.o(149418);
                    return 0;
                case 3:
                    dvVar.xNo = aVar3.UbS.readString();
                    AppMethodBeat.o(149418);
                    return 0;
                default:
                    AppMethodBeat.o(149418);
                    return -1;
            }
        } else {
            AppMethodBeat.o(149418);
            return -1;
        }
    }
}
