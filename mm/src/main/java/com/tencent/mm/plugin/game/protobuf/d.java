package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class d extends a {
    public String jfi;
    public String xIC;
    public String xID;
    public String xIE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256623);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi != null) {
                aVar.e(1, this.jfi);
            }
            if (this.xIC != null) {
                aVar.e(2, this.xIC);
            }
            if (this.xID != null) {
                aVar.e(3, this.xID);
            }
            if (this.xIE != null) {
                aVar.e(4, this.xIE);
            }
            AppMethodBeat.o(256623);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.xIC != null) {
                f2 += g.a.a.b.b.a.f(2, this.xIC);
            }
            if (this.xID != null) {
                f2 += g.a.a.b.b.a.f(3, this.xID);
            }
            if (this.xIE != null) {
                f2 += g.a.a.b.b.a.f(4, this.xIE);
            }
            AppMethodBeat.o(256623);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256623);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(256623);
                    return 0;
                case 2:
                    dVar.xIC = aVar3.UbS.readString();
                    AppMethodBeat.o(256623);
                    return 0;
                case 3:
                    dVar.xID = aVar3.UbS.readString();
                    AppMethodBeat.o(256623);
                    return 0;
                case 4:
                    dVar.xIE = aVar3.UbS.readString();
                    AppMethodBeat.o(256623);
                    return 0;
                default:
                    AppMethodBeat.o(256623);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256623);
            return -1;
        }
    }
}
