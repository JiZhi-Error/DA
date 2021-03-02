package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cvu extends a {
    public String nickName;
    public int status;
    public String userName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152636);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.e(1, this.userName);
            }
            aVar.aM(2, this.status);
            if (this.nickName != null) {
                aVar.e(3, this.nickName);
            }
            AppMethodBeat.o(152636);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.userName != null ? g.a.a.b.b.a.f(1, this.userName) + 0 : 0) + g.a.a.b.b.a.bu(2, this.status);
            if (this.nickName != null) {
                f2 += g.a.a.b.b.a.f(3, this.nickName);
            }
            AppMethodBeat.o(152636);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152636);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvu cvu = (cvu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvu.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(152636);
                    return 0;
                case 2:
                    cvu.status = aVar3.UbS.zi();
                    AppMethodBeat.o(152636);
                    return 0;
                case 3:
                    cvu.nickName = aVar3.UbS.readString();
                    AppMethodBeat.o(152636);
                    return 0;
                default:
                    AppMethodBeat.o(152636);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152636);
            return -1;
        }
    }
}
