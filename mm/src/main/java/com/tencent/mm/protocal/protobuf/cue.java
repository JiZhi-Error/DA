package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cue extends a {
    public String desc;
    public int id;
    public String lHM;
    public String nickname;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152630);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.id);
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.lHM != null) {
                aVar.e(3, this.lHM);
            }
            if (this.desc != null) {
                aVar.e(4, this.desc);
            }
            AppMethodBeat.o(152630);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0;
            if (this.nickname != null) {
                bu += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.lHM != null) {
                bu += g.a.a.b.b.a.f(3, this.lHM);
            }
            if (this.desc != null) {
                bu += g.a.a.b.b.a.f(4, this.desc);
            }
            AppMethodBeat.o(152630);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152630);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cue cue = (cue) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cue.id = aVar3.UbS.zi();
                    AppMethodBeat.o(152630);
                    return 0;
                case 2:
                    cue.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(152630);
                    return 0;
                case 3:
                    cue.lHM = aVar3.UbS.readString();
                    AppMethodBeat.o(152630);
                    return 0;
                case 4:
                    cue.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(152630);
                    return 0;
                default:
                    AppMethodBeat.o(152630);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152630);
            return -1;
        }
    }
}
