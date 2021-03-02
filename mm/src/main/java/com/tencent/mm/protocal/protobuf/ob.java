package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ob extends a {
    public String iFF;
    public String key;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212232);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key == null) {
                b bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(212232);
                throw bVar;
            } else if (this.iFF == null) {
                b bVar2 = new b("Not all required fields were included: val");
                AppMethodBeat.o(212232);
                throw bVar2;
            } else {
                if (this.key != null) {
                    aVar.e(1, this.key);
                }
                if (this.iFF != null) {
                    aVar.e(2, this.iFF);
                }
                AppMethodBeat.o(212232);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0;
            if (this.iFF != null) {
                f2 += g.a.a.b.b.a.f(2, this.iFF);
            }
            AppMethodBeat.o(212232);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.key == null) {
                b bVar3 = new b("Not all required fields were included: key");
                AppMethodBeat.o(212232);
                throw bVar3;
            } else if (this.iFF == null) {
                b bVar4 = new b("Not all required fields were included: val");
                AppMethodBeat.o(212232);
                throw bVar4;
            } else {
                AppMethodBeat.o(212232);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ob obVar = (ob) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    obVar.key = aVar3.UbS.readString();
                    AppMethodBeat.o(212232);
                    return 0;
                case 2:
                    obVar.iFF = aVar3.UbS.readString();
                    AppMethodBeat.o(212232);
                    return 0;
                default:
                    AppMethodBeat.o(212232);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212232);
            return -1;
        }
    }
}
