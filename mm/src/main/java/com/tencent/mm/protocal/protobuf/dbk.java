package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dbk extends a {
    public String MGu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43122);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MGu == null) {
                b bVar = new b("Not all required fields were included: PhoneNum");
                AppMethodBeat.o(43122);
                throw bVar;
            }
            if (this.MGu != null) {
                aVar.e(1, this.MGu);
            }
            AppMethodBeat.o(43122);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MGu != null ? g.a.a.b.b.a.f(1, this.MGu) + 0 : 0;
            AppMethodBeat.o(43122);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MGu == null) {
                b bVar2 = new b("Not all required fields were included: PhoneNum");
                AppMethodBeat.o(43122);
                throw bVar2;
            }
            AppMethodBeat.o(43122);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbk dbk = (dbk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dbk.MGu = aVar3.UbS.readString();
                    AppMethodBeat.o(43122);
                    return 0;
                default:
                    AppMethodBeat.o(43122);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43122);
            return -1;
        }
    }
}