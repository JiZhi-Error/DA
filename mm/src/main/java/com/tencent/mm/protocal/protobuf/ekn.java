package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ekn extends a {
    public long duration;
    public String path;
    public long wKD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201303);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.path == null) {
                b bVar = new b("Not all required fields were included: path");
                AppMethodBeat.o(201303);
                throw bVar;
            }
            if (this.path != null) {
                aVar.e(1, this.path);
            }
            aVar.bb(2, this.wKD);
            aVar.bb(3, this.duration);
            AppMethodBeat.o(201303);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.path != null ? g.a.a.b.b.a.f(1, this.path) + 0 : 0) + g.a.a.b.b.a.r(2, this.wKD) + g.a.a.b.b.a.r(3, this.duration);
            AppMethodBeat.o(201303);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.path == null) {
                b bVar2 = new b("Not all required fields were included: path");
                AppMethodBeat.o(201303);
                throw bVar2;
            }
            AppMethodBeat.o(201303);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekn ekn = (ekn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ekn.path = aVar3.UbS.readString();
                    AppMethodBeat.o(201303);
                    return 0;
                case 2:
                    ekn.wKD = aVar3.UbS.zl();
                    AppMethodBeat.o(201303);
                    return 0;
                case 3:
                    ekn.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(201303);
                    return 0;
                default:
                    AppMethodBeat.o(201303);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201303);
            return -1;
        }
    }
}
