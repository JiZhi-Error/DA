package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class n extends a {
    public String name;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(96164);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name == null) {
                b bVar = new b("Not all required fields were included: name");
                AppMethodBeat.o(96164);
                throw bVar;
            }
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.aM(2, this.type);
            AppMethodBeat.o(96164);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type);
            AppMethodBeat.o(96164);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.name == null) {
                b bVar2 = new b("Not all required fields were included: name");
                AppMethodBeat.o(96164);
                throw bVar2;
            }
            AppMethodBeat.o(96164);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(96164);
                    return 0;
                case 2:
                    nVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(96164);
                    return 0;
                default:
                    AppMethodBeat.o(96164);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96164);
            return -1;
        }
    }
}
