package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class cr extends a {
    public String Title;
    public String xIB;
    public String xIJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41805);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xIJ == null) {
                b bVar = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(41805);
                throw bVar;
            }
            if (this.xIJ != null) {
                aVar.e(1, this.xIJ);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.xIB != null) {
                aVar.e(3, this.xIB);
            }
            AppMethodBeat.o(41805);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xIJ != null ? g.a.a.b.b.a.f(1, this.xIJ) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.xIB != null) {
                f2 += g.a.a.b.b.a.f(3, this.xIB);
            }
            AppMethodBeat.o(41805);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xIJ == null) {
                b bVar2 = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(41805);
                throw bVar2;
            }
            AppMethodBeat.o(41805);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cr crVar = (cr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crVar.xIJ = aVar3.UbS.readString();
                    AppMethodBeat.o(41805);
                    return 0;
                case 2:
                    crVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41805);
                    return 0;
                case 3:
                    crVar.xIB = aVar3.UbS.readString();
                    AppMethodBeat.o(41805);
                    return 0;
                default:
                    AppMethodBeat.o(41805);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41805);
            return -1;
        }
    }
}
