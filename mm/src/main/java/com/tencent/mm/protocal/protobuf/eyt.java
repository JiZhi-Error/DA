package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eyt extends a {
    public boolean Nvv;
    public String Username;
    public String rBI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32532);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Username == null) {
                b bVar = new b("Not all required fields were included: Username");
                AppMethodBeat.o(32532);
                throw bVar;
            } else if (this.rBI == null) {
                b bVar2 = new b("Not all required fields were included: Language");
                AppMethodBeat.o(32532);
                throw bVar2;
            } else {
                if (this.Username != null) {
                    aVar.e(1, this.Username);
                }
                if (this.rBI != null) {
                    aVar.e(2, this.rBI);
                }
                aVar.cc(3, this.Nvv);
                AppMethodBeat.o(32532);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Username != null ? g.a.a.b.b.a.f(1, this.Username) + 0 : 0;
            if (this.rBI != null) {
                f2 += g.a.a.b.b.a.f(2, this.rBI);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(32532);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Username == null) {
                b bVar3 = new b("Not all required fields were included: Username");
                AppMethodBeat.o(32532);
                throw bVar3;
            } else if (this.rBI == null) {
                b bVar4 = new b("Not all required fields were included: Language");
                AppMethodBeat.o(32532);
                throw bVar4;
            } else {
                AppMethodBeat.o(32532);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyt eyt = (eyt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyt.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(32532);
                    return 0;
                case 2:
                    eyt.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(32532);
                    return 0;
                case 3:
                    eyt.Nvv = aVar3.UbS.yZ();
                    AppMethodBeat.o(32532);
                    return 0;
                default:
                    AppMethodBeat.o(32532);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32532);
            return -1;
        }
    }
}
