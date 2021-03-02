package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class qt extends a {
    public String KXA;
    public String KXB;
    public String Url;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152989);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KXA != null) {
                aVar.e(1, this.KXA);
            }
            if (this.KXB != null) {
                aVar.e(2, this.KXB);
            }
            if (this.Url != null) {
                aVar.e(3, this.Url);
            }
            aVar.aM(4, this.oUv);
            AppMethodBeat.o(152989);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KXA != null ? g.a.a.b.b.a.f(1, this.KXA) + 0 : 0;
            if (this.KXB != null) {
                f2 += g.a.a.b.b.a.f(2, this.KXB);
            }
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(3, this.Url);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.oUv);
            AppMethodBeat.o(152989);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152989);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qt qtVar = (qt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qtVar.KXA = aVar3.UbS.readString();
                    AppMethodBeat.o(152989);
                    return 0;
                case 2:
                    qtVar.KXB = aVar3.UbS.readString();
                    AppMethodBeat.o(152989);
                    return 0;
                case 3:
                    qtVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(152989);
                    return 0;
                case 4:
                    qtVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(152989);
                    return 0;
                default:
                    AppMethodBeat.o(152989);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152989);
            return -1;
        }
    }
}
