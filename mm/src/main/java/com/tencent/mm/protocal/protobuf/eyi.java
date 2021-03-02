package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eyi extends a {
    public String MD5;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32518);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MD5 == null) {
                b bVar = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(32518);
                throw bVar;
            }
            aVar.aM(1, this.oUv);
            if (this.MD5 != null) {
                aVar.e(2, this.MD5);
            }
            AppMethodBeat.o(32518);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0;
            if (this.MD5 != null) {
                bu += g.a.a.b.b.a.f(2, this.MD5);
            }
            AppMethodBeat.o(32518);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MD5 == null) {
                b bVar2 = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(32518);
                throw bVar2;
            }
            AppMethodBeat.o(32518);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyi eyi = (eyi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyi.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32518);
                    return 0;
                case 2:
                    eyi.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(32518);
                    return 0;
                default:
                    AppMethodBeat.o(32518);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32518);
            return -1;
        }
    }
}
