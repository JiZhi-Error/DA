package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class mt extends a {
    public String KRa;
    public String path;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212226);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.path != null) {
                aVar.e(2, this.path);
            }
            if (this.KRa != null) {
                aVar.e(3, this.KRa);
            }
            AppMethodBeat.o(212226);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.path != null) {
                f2 += g.a.a.b.b.a.f(2, this.path);
            }
            if (this.KRa != null) {
                f2 += g.a.a.b.b.a.f(3, this.KRa);
            }
            AppMethodBeat.o(212226);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212226);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mt mtVar = (mt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mtVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(212226);
                    return 0;
                case 2:
                    mtVar.path = aVar3.UbS.readString();
                    AppMethodBeat.o(212226);
                    return 0;
                case 3:
                    mtVar.KRa = aVar3.UbS.readString();
                    AppMethodBeat.o(212226);
                    return 0;
                default:
                    AppMethodBeat.o(212226);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212226);
            return -1;
        }
    }
}