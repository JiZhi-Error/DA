package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class epo extends a {
    public long KHA;
    public String jGZ;
    public String jHi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152721);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jGZ == null) {
                b bVar = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(152721);
                throw bVar;
            } else if (this.jHi == null) {
                b bVar2 = new b("Not all required fields were included: verify_ticket");
                AppMethodBeat.o(152721);
                throw bVar2;
            } else {
                if (this.jGZ != null) {
                    aVar.e(1, this.jGZ);
                }
                if (this.jHi != null) {
                    aVar.e(2, this.jHi);
                }
                aVar.bb(3, this.KHA);
                AppMethodBeat.o(152721);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.jGZ != null ? g.a.a.b.b.a.f(1, this.jGZ) + 0 : 0;
            if (this.jHi != null) {
                f2 += g.a.a.b.b.a.f(2, this.jHi);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.KHA);
            AppMethodBeat.o(152721);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jGZ == null) {
                b bVar3 = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(152721);
                throw bVar3;
            } else if (this.jHi == null) {
                b bVar4 = new b("Not all required fields were included: verify_ticket");
                AppMethodBeat.o(152721);
                throw bVar4;
            } else {
                AppMethodBeat.o(152721);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epo epo = (epo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    epo.jGZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152721);
                    return 0;
                case 2:
                    epo.jHi = aVar3.UbS.readString();
                    AppMethodBeat.o(152721);
                    return 0;
                case 3:
                    epo.KHA = aVar3.UbS.zl();
                    AppMethodBeat.o(152721);
                    return 0;
                default:
                    AppMethodBeat.o(152721);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152721);
            return -1;
        }
    }
}
