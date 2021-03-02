package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bnx extends a {
    public String nnB;
    public String path;
    public String qGB;
    public String title;
    public int type;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123579);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qGB != null) {
                aVar.e(1, this.qGB);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            aVar.aM(3, this.type);
            if (this.nnB != null) {
                aVar.e(4, this.nnB);
            }
            if (this.username != null) {
                aVar.e(5, this.username);
            }
            if (this.path != null) {
                aVar.e(6, this.path);
            }
            AppMethodBeat.o(123579);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.qGB != null ? g.a.a.b.b.a.f(1, this.qGB) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.type);
            if (this.nnB != null) {
                bu += g.a.a.b.b.a.f(4, this.nnB);
            }
            if (this.username != null) {
                bu += g.a.a.b.b.a.f(5, this.username);
            }
            if (this.path != null) {
                bu += g.a.a.b.b.a.f(6, this.path);
            }
            AppMethodBeat.o(123579);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123579);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnx bnx = (bnx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnx.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(123579);
                    return 0;
                case 2:
                    bnx.title = aVar3.UbS.readString();
                    AppMethodBeat.o(123579);
                    return 0;
                case 3:
                    bnx.type = aVar3.UbS.zi();
                    AppMethodBeat.o(123579);
                    return 0;
                case 4:
                    bnx.nnB = aVar3.UbS.readString();
                    AppMethodBeat.o(123579);
                    return 0;
                case 5:
                    bnx.username = aVar3.UbS.readString();
                    AppMethodBeat.o(123579);
                    return 0;
                case 6:
                    bnx.path = aVar3.UbS.readString();
                    AppMethodBeat.o(123579);
                    return 0;
                default:
                    AppMethodBeat.o(123579);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123579);
            return -1;
        }
    }
}
