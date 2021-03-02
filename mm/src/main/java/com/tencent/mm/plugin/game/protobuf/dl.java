package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dl extends a {
    public String xMX;
    public String xMY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(182780);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMX == null) {
                b bVar = new b("Not all required fields were included: Key");
                AppMethodBeat.o(182780);
                throw bVar;
            }
            if (this.xMX != null) {
                aVar.e(1, this.xMX);
            }
            if (this.xMY != null) {
                aVar.e(2, this.xMY);
            }
            AppMethodBeat.o(182780);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xMX != null ? g.a.a.b.b.a.f(1, this.xMX) + 0 : 0;
            if (this.xMY != null) {
                f2 += g.a.a.b.b.a.f(2, this.xMY);
            }
            AppMethodBeat.o(182780);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xMX == null) {
                b bVar2 = new b("Not all required fields were included: Key");
                AppMethodBeat.o(182780);
                throw bVar2;
            }
            AppMethodBeat.o(182780);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dl dlVar = (dl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlVar.xMX = aVar3.UbS.readString();
                    AppMethodBeat.o(182780);
                    return 0;
                case 2:
                    dlVar.xMY = aVar3.UbS.readString();
                    AppMethodBeat.o(182780);
                    return 0;
                default:
                    AppMethodBeat.o(182780);
                    return -1;
            }
        } else {
            AppMethodBeat.o(182780);
            return -1;
        }
    }
}
