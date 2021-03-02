package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ffp extends a {
    public int NAI;
    public String ixr;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32574);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ixr == null) {
                b bVar = new b("Not all required fields were included: rankid");
                AppMethodBeat.o(32574);
                throw bVar;
            } else if (this.title == null) {
                b bVar2 = new b("Not all required fields were included: title");
                AppMethodBeat.o(32574);
                throw bVar2;
            } else {
                if (this.ixr != null) {
                    aVar.e(1, this.ixr);
                }
                if (this.title != null) {
                    aVar.e(2, this.title);
                }
                aVar.aM(3, this.NAI);
                AppMethodBeat.o(32574);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.ixr != null ? g.a.a.b.b.a.f(1, this.ixr) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.NAI);
            AppMethodBeat.o(32574);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ixr == null) {
                b bVar3 = new b("Not all required fields were included: rankid");
                AppMethodBeat.o(32574);
                throw bVar3;
            } else if (this.title == null) {
                b bVar4 = new b("Not all required fields were included: title");
                AppMethodBeat.o(32574);
                throw bVar4;
            } else {
                AppMethodBeat.o(32574);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffp ffp = (ffp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ffp.ixr = aVar3.UbS.readString();
                    AppMethodBeat.o(32574);
                    return 0;
                case 2:
                    ffp.title = aVar3.UbS.readString();
                    AppMethodBeat.o(32574);
                    return 0;
                case 3:
                    ffp.NAI = aVar3.UbS.zi();
                    AppMethodBeat.o(32574);
                    return 0;
                default:
                    AppMethodBeat.o(32574);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32574);
            return -1;
        }
    }
}
