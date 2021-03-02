package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dqk extends a {
    public int CreateTime;
    public String KLO;
    public String Lke;
    public String Name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134254);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.Lke != null) {
                aVar.e(2, this.Lke);
            }
            if (this.KLO != null) {
                aVar.e(3, this.KLO);
            }
            aVar.aM(4, this.CreateTime);
            AppMethodBeat.o(134254);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Name != null ? g.a.a.b.b.a.f(1, this.Name) + 0 : 0;
            if (this.Lke != null) {
                f2 += g.a.a.b.b.a.f(2, this.Lke);
            }
            if (this.KLO != null) {
                f2 += g.a.a.b.b.a.f(3, this.KLO);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.CreateTime);
            AppMethodBeat.o(134254);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(134254);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dqk dqk = (dqk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dqk.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(134254);
                    return 0;
                case 2:
                    dqk.Lke = aVar3.UbS.readString();
                    AppMethodBeat.o(134254);
                    return 0;
                case 3:
                    dqk.KLO = aVar3.UbS.readString();
                    AppMethodBeat.o(134254);
                    return 0;
                case 4:
                    dqk.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(134254);
                    return 0;
                default:
                    AppMethodBeat.o(134254);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134254);
            return -1;
        }
    }
}
