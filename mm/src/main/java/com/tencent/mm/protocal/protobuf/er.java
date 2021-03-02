package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class er extends a {
    public String appId;
    public int cyo;
    public int iOo;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208700);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.aM(3, this.iOo);
            aVar.aM(4, this.cyo);
            AppMethodBeat.o(208700);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.appId != null ? g.a.a.b.b.a.f(1, this.appId) + 0 : 0;
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(2, this.username);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.iOo) + g.a.a.b.b.a.bu(4, this.cyo);
            AppMethodBeat.o(208700);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208700);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            er erVar = (er) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    erVar.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(208700);
                    return 0;
                case 2:
                    erVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(208700);
                    return 0;
                case 3:
                    erVar.iOo = aVar3.UbS.zi();
                    AppMethodBeat.o(208700);
                    return 0;
                case 4:
                    erVar.cyo = aVar3.UbS.zi();
                    AppMethodBeat.o(208700);
                    return 0;
                default:
                    AppMethodBeat.o(208700);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208700);
            return -1;
        }
    }
}
