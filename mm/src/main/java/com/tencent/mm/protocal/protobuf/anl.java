package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class anl extends a {
    public String FeZ;
    public String Lyk;
    public int ckU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127485);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.FeZ == null) {
                b bVar = new b("Not all required fields were included: tagName");
                AppMethodBeat.o(127485);
                throw bVar;
            } else if (this.Lyk == null) {
                b bVar2 = new b("Not all required fields were included: tagPinYin");
                AppMethodBeat.o(127485);
                throw bVar2;
            } else {
                if (this.FeZ != null) {
                    aVar.e(1, this.FeZ);
                }
                if (this.Lyk != null) {
                    aVar.e(2, this.Lyk);
                }
                aVar.aM(3, this.ckU);
                AppMethodBeat.o(127485);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.FeZ != null ? g.a.a.b.b.a.f(1, this.FeZ) + 0 : 0;
            if (this.Lyk != null) {
                f2 += g.a.a.b.b.a.f(2, this.Lyk);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.ckU);
            AppMethodBeat.o(127485);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.FeZ == null) {
                b bVar3 = new b("Not all required fields were included: tagName");
                AppMethodBeat.o(127485);
                throw bVar3;
            } else if (this.Lyk == null) {
                b bVar4 = new b("Not all required fields were included: tagPinYin");
                AppMethodBeat.o(127485);
                throw bVar4;
            } else {
                AppMethodBeat.o(127485);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anl anl = (anl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anl.FeZ = aVar3.UbS.readString();
                    AppMethodBeat.o(127485);
                    return 0;
                case 2:
                    anl.Lyk = aVar3.UbS.readString();
                    AppMethodBeat.o(127485);
                    return 0;
                case 3:
                    anl.ckU = aVar3.UbS.zi();
                    AppMethodBeat.o(127485);
                    return 0;
                default:
                    AppMethodBeat.o(127485);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127485);
            return -1;
        }
    }
}
