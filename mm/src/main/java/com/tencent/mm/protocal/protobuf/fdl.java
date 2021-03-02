package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fdl extends a {
    public int KXD;
    public String MxW;
    public String path;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123705);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.MxW != null) {
                aVar.e(2, this.MxW);
            }
            aVar.aM(3, this.KXD);
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            AppMethodBeat.o(123705);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.MxW != null) {
                f2 += g.a.a.b.b.a.f(2, this.MxW);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KXD);
            if (this.path != null) {
                bu += g.a.a.b.b.a.f(4, this.path);
            }
            AppMethodBeat.o(123705);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123705);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdl fdl = (fdl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdl.username = aVar3.UbS.readString();
                    AppMethodBeat.o(123705);
                    return 0;
                case 2:
                    fdl.MxW = aVar3.UbS.readString();
                    AppMethodBeat.o(123705);
                    return 0;
                case 3:
                    fdl.KXD = aVar3.UbS.zi();
                    AppMethodBeat.o(123705);
                    return 0;
                case 4:
                    fdl.path = aVar3.UbS.readString();
                    AppMethodBeat.o(123705);
                    return 0;
                default:
                    AppMethodBeat.o(123705);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123705);
            return -1;
        }
    }
}
