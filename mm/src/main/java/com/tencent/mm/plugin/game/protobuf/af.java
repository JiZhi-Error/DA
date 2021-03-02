package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class af extends a {
    public String UserName;
    public String xKd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41725);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(41725);
                throw bVar;
            } else if (this.xKd == null) {
                b bVar2 = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(41725);
                throw bVar2;
            } else {
                if (this.UserName != null) {
                    aVar.e(1, this.UserName);
                }
                if (this.xKd != null) {
                    aVar.e(2, this.xKd);
                }
                AppMethodBeat.o(41725);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.xKd != null) {
                f2 += g.a.a.b.b.a.f(2, this.xKd);
            }
            AppMethodBeat.o(41725);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.UserName == null) {
                b bVar3 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(41725);
                throw bVar3;
            } else if (this.xKd == null) {
                b bVar4 = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(41725);
                throw bVar4;
            } else {
                AppMethodBeat.o(41725);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            af afVar = (af) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    afVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(41725);
                    return 0;
                case 2:
                    afVar.xKd = aVar3.UbS.readString();
                    AppMethodBeat.o(41725);
                    return 0;
                default:
                    AppMethodBeat.o(41725);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41725);
            return -1;
        }
    }
}
