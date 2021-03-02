package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ij extends a {
    public int dIZ;
    public String data;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153261);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.data != null) {
                aVar.e(2, this.data);
            }
            aVar.aM(3, this.dIZ);
            AppMethodBeat.o(153261);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.data != null) {
                f2 += g.a.a.b.b.a.f(2, this.data);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.dIZ);
            AppMethodBeat.o(153261);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153261);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ij ijVar = (ij) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ijVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(153261);
                    return 0;
                case 2:
                    ijVar.data = aVar3.UbS.readString();
                    AppMethodBeat.o(153261);
                    return 0;
                case 3:
                    ijVar.dIZ = aVar3.UbS.zi();
                    AppMethodBeat.o(153261);
                    return 0;
                default:
                    AppMethodBeat.o(153261);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153261);
            return -1;
        }
    }
}
