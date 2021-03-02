package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class bro extends a {
    public String dHx;
    public String dOe;
    public String jGZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152580);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jGZ == null) {
                b bVar = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(152580);
                throw bVar;
            }
            if (this.jGZ != null) {
                aVar.e(1, this.jGZ);
            }
            if (this.dOe != null) {
                aVar.e(2, this.dOe);
            }
            if (this.dHx != null) {
                aVar.e(3, this.dHx);
            }
            AppMethodBeat.o(152580);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jGZ != null ? g.a.a.b.b.a.f(1, this.jGZ) + 0 : 0;
            if (this.dOe != null) {
                f2 += g.a.a.b.b.a.f(2, this.dOe);
            }
            if (this.dHx != null) {
                f2 += g.a.a.b.b.a.f(3, this.dHx);
            }
            AppMethodBeat.o(152580);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jGZ == null) {
                b bVar2 = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(152580);
                throw bVar2;
            }
            AppMethodBeat.o(152580);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bro bro = (bro) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bro.jGZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152580);
                    return 0;
                case 2:
                    bro.dOe = aVar3.UbS.readString();
                    AppMethodBeat.o(152580);
                    return 0;
                case 3:
                    bro.dHx = aVar3.UbS.readString();
                    AppMethodBeat.o(152580);
                    return 0;
                default:
                    AppMethodBeat.o(152580);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152580);
            return -1;
        }
    }
}
