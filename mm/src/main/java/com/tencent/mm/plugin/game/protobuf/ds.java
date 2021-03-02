package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ds extends a {
    public String Title;
    public String xIx;
    public String xIy;
    public int xNn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41834);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.xIy != null) {
                aVar.e(2, this.xIy);
            }
            if (this.xIx != null) {
                aVar.e(3, this.xIx);
            }
            aVar.aM(4, this.xNn);
            AppMethodBeat.o(41834);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(2, this.xIy);
            }
            if (this.xIx != null) {
                f2 += g.a.a.b.b.a.f(3, this.xIx);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.xNn);
            AppMethodBeat.o(41834);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41834);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ds dsVar = (ds) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dsVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41834);
                    return 0;
                case 2:
                    dsVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41834);
                    return 0;
                case 3:
                    dsVar.xIx = aVar3.UbS.readString();
                    AppMethodBeat.o(41834);
                    return 0;
                case 4:
                    dsVar.xNn = aVar3.UbS.zi();
                    AppMethodBeat.o(41834);
                    return 0;
                default:
                    AppMethodBeat.o(41834);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41834);
            return -1;
        }
    }
}
