package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ezf extends a {
    public long MKf;
    public String Username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32547);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Username == null) {
                b bVar = new b("Not all required fields were included: Username");
                AppMethodBeat.o(32547);
                throw bVar;
            }
            if (this.Username != null) {
                aVar.e(1, this.Username);
            }
            aVar.bb(2, this.MKf);
            AppMethodBeat.o(32547);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Username != null ? g.a.a.b.b.a.f(1, this.Username) + 0 : 0) + g.a.a.b.b.a.r(2, this.MKf);
            AppMethodBeat.o(32547);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Username == null) {
                b bVar2 = new b("Not all required fields were included: Username");
                AppMethodBeat.o(32547);
                throw bVar2;
            }
            AppMethodBeat.o(32547);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezf ezf = (ezf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezf.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(32547);
                    return 0;
                case 2:
                    ezf.MKf = aVar3.UbS.zl();
                    AppMethodBeat.o(32547);
                    return 0;
                default:
                    AppMethodBeat.o(32547);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32547);
            return -1;
        }
    }
}
