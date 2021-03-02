package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ej extends a {
    public String xNH;
    public String xNI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41844);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xNH == null) {
                b bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(41844);
                throw bVar;
            } else if (this.xNI == null) {
                b bVar2 = new b("Not all required fields were included: TimeDesc");
                AppMethodBeat.o(41844);
                throw bVar2;
            } else {
                if (this.xNH != null) {
                    aVar.e(1, this.xNH);
                }
                if (this.xNI != null) {
                    aVar.e(2, this.xNI);
                }
                AppMethodBeat.o(41844);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.xNH != null ? g.a.a.b.b.a.f(1, this.xNH) + 0 : 0;
            if (this.xNI != null) {
                f2 += g.a.a.b.b.a.f(2, this.xNI);
            }
            AppMethodBeat.o(41844);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xNH == null) {
                b bVar3 = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(41844);
                throw bVar3;
            } else if (this.xNI == null) {
                b bVar4 = new b("Not all required fields were included: TimeDesc");
                AppMethodBeat.o(41844);
                throw bVar4;
            } else {
                AppMethodBeat.o(41844);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ej ejVar = (ej) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ejVar.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(41844);
                    return 0;
                case 2:
                    ejVar.xNI = aVar3.UbS.readString();
                    AppMethodBeat.o(41844);
                    return 0;
                default:
                    AppMethodBeat.o(41844);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41844);
            return -1;
        }
    }
}
