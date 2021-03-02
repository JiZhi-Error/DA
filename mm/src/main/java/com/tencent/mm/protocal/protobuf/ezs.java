package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ezs extends a {
    public String NvP;
    public String NvQ;
    public String NvR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32562);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NvP == null) {
                b bVar = new b("Not all required fields were included: Plugin");
                AppMethodBeat.o(32562);
                throw bVar;
            } else if (this.NvQ == null) {
                b bVar2 = new b("Not all required fields were included: ActivityPath");
                AppMethodBeat.o(32562);
                throw bVar2;
            } else {
                if (this.NvP != null) {
                    aVar.e(1, this.NvP);
                }
                if (this.NvQ != null) {
                    aVar.e(2, this.NvQ);
                }
                if (this.NvR != null) {
                    aVar.e(3, this.NvR);
                }
                AppMethodBeat.o(32562);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.NvP != null ? g.a.a.b.b.a.f(1, this.NvP) + 0 : 0;
            if (this.NvQ != null) {
                f2 += g.a.a.b.b.a.f(2, this.NvQ);
            }
            if (this.NvR != null) {
                f2 += g.a.a.b.b.a.f(3, this.NvR);
            }
            AppMethodBeat.o(32562);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NvP == null) {
                b bVar3 = new b("Not all required fields were included: Plugin");
                AppMethodBeat.o(32562);
                throw bVar3;
            } else if (this.NvQ == null) {
                b bVar4 = new b("Not all required fields were included: ActivityPath");
                AppMethodBeat.o(32562);
                throw bVar4;
            } else {
                AppMethodBeat.o(32562);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezs ezs = (ezs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezs.NvP = aVar3.UbS.readString();
                    AppMethodBeat.o(32562);
                    return 0;
                case 2:
                    ezs.NvQ = aVar3.UbS.readString();
                    AppMethodBeat.o(32562);
                    return 0;
                case 3:
                    ezs.NvR = aVar3.UbS.readString();
                    AppMethodBeat.o(32562);
                    return 0;
                default:
                    AppMethodBeat.o(32562);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32562);
            return -1;
        }
    }
}
