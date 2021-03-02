package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class sd extends a {
    public long Id;
    public String KZP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117853);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZP == null) {
                b bVar = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(117853);
                throw bVar;
            }
            aVar.bb(1, this.Id);
            if (this.KZP != null) {
                aVar.e(2, this.KZP);
            }
            AppMethodBeat.o(117853);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Id) + 0;
            if (this.KZP != null) {
                r += g.a.a.b.b.a.f(2, this.KZP);
            }
            AppMethodBeat.o(117853);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KZP == null) {
                b bVar2 = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(117853);
                throw bVar2;
            }
            AppMethodBeat.o(117853);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sd sdVar = (sd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sdVar.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(117853);
                    return 0;
                case 2:
                    sdVar.KZP = aVar3.UbS.readString();
                    AppMethodBeat.o(117853);
                    return 0;
                default:
                    AppMethodBeat.o(117853);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117853);
            return -1;
        }
    }
}
