package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class esc extends a {
    public String Npd;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(239539);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.Npd != null) {
                aVar.e(2, this.Npd);
            }
            AppMethodBeat.o(239539);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.Npd != null) {
                f2 += g.a.a.b.b.a.f(2, this.Npd);
            }
            AppMethodBeat.o(239539);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(239539);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esc esc = (esc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    esc.username = aVar3.UbS.readString();
                    AppMethodBeat.o(239539);
                    return 0;
                case 2:
                    esc.Npd = aVar3.UbS.readString();
                    AppMethodBeat.o(239539);
                    return 0;
                default:
                    AppMethodBeat.o(239539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(239539);
            return -1;
        }
    }
}
