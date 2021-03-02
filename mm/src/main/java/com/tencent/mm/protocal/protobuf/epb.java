package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class epb extends a {
    public long LmC;
    public String LmD;
    public String key;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(121106);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key == null) {
                b bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(121106);
                throw bVar;
            }
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            aVar.bb(2, this.LmC);
            if (this.LmD != null) {
                aVar.e(3, this.LmD);
            }
            AppMethodBeat.o(121106);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0) + g.a.a.b.b.a.r(2, this.LmC);
            if (this.LmD != null) {
                f2 += g.a.a.b.b.a.f(3, this.LmD);
            }
            AppMethodBeat.o(121106);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.key == null) {
                b bVar2 = new b("Not all required fields were included: key");
                AppMethodBeat.o(121106);
                throw bVar2;
            }
            AppMethodBeat.o(121106);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epb epb = (epb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    epb.key = aVar3.UbS.readString();
                    AppMethodBeat.o(121106);
                    return 0;
                case 2:
                    epb.LmC = aVar3.UbS.zl();
                    AppMethodBeat.o(121106);
                    return 0;
                case 3:
                    epb.LmD = aVar3.UbS.readString();
                    AppMethodBeat.o(121106);
                    return 0;
                default:
                    AppMethodBeat.o(121106);
                    return -1;
            }
        } else {
            AppMethodBeat.o(121106);
            return -1;
        }
    }
}
