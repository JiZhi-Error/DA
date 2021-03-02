package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class cmy extends a {
    public String md5;
    public String uuid;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169218);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.md5 == null) {
                b bVar = new b("Not all required fields were included: md5");
                AppMethodBeat.o(169218);
                throw bVar;
            }
            if (this.md5 != null) {
                aVar.e(1, this.md5);
            }
            if (this.uuid != null) {
                aVar.e(2, this.uuid);
            }
            AppMethodBeat.o(169218);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.md5 != null ? g.a.a.b.b.a.f(1, this.md5) + 0 : 0;
            if (this.uuid != null) {
                f2 += g.a.a.b.b.a.f(2, this.uuid);
            }
            AppMethodBeat.o(169218);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.md5 == null) {
                b bVar2 = new b("Not all required fields were included: md5");
                AppMethodBeat.o(169218);
                throw bVar2;
            }
            AppMethodBeat.o(169218);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmy cmy = (cmy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmy.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(169218);
                    return 0;
                case 2:
                    cmy.uuid = aVar3.UbS.readString();
                    AppMethodBeat.o(169218);
                    return 0;
                default:
                    AppMethodBeat.o(169218);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169218);
            return -1;
        }
    }
}
