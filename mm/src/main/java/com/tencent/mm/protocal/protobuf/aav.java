package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class aav extends a {
    public int Scene;
    public String Version;
    public String xJD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110847);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJD == null) {
                b bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(110847);
                throw bVar;
            }
            if (this.xJD != null) {
                aVar.e(1, this.xJD);
            }
            if (this.Version != null) {
                aVar.e(2, this.Version);
            }
            aVar.aM(3, this.Scene);
            AppMethodBeat.o(110847);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xJD != null ? g.a.a.b.b.a.f(1, this.xJD) + 0 : 0;
            if (this.Version != null) {
                f2 += g.a.a.b.b.a.f(2, this.Version);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Scene);
            AppMethodBeat.o(110847);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xJD == null) {
                b bVar2 = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(110847);
                throw bVar2;
            }
            AppMethodBeat.o(110847);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aav aav = (aav) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aav.xJD = aVar3.UbS.readString();
                    AppMethodBeat.o(110847);
                    return 0;
                case 2:
                    aav.Version = aVar3.UbS.readString();
                    AppMethodBeat.o(110847);
                    return 0;
                case 3:
                    aav.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(110847);
                    return 0;
                default:
                    AppMethodBeat.o(110847);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110847);
            return -1;
        }
    }
}
