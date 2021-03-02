package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class u extends a {
    public String GaS;
    public long GaT;
    public int Gaz;
    public String nickname;
    public String qFV;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222843);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.nickname != null) {
                aVar.e(1, this.nickname);
            }
            if (this.qFV != null) {
                aVar.e(2, this.qFV);
            }
            if (this.GaS != null) {
                aVar.e(3, this.GaS);
            }
            aVar.aM(4, this.type);
            aVar.aM(5, this.Gaz);
            aVar.bb(6, this.GaT);
            AppMethodBeat.o(222843);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.nickname != null ? g.a.a.b.b.a.f(1, this.nickname) + 0 : 0;
            if (this.qFV != null) {
                f2 += g.a.a.b.b.a.f(2, this.qFV);
            }
            if (this.GaS != null) {
                f2 += g.a.a.b.b.a.f(3, this.GaS);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.type) + g.a.a.b.b.a.bu(5, this.Gaz) + g.a.a.b.b.a.r(6, this.GaT);
            AppMethodBeat.o(222843);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222843);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(222843);
                    return 0;
                case 2:
                    uVar.qFV = aVar3.UbS.readString();
                    AppMethodBeat.o(222843);
                    return 0;
                case 3:
                    uVar.GaS = aVar3.UbS.readString();
                    AppMethodBeat.o(222843);
                    return 0;
                case 4:
                    uVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(222843);
                    return 0;
                case 5:
                    uVar.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(222843);
                    return 0;
                case 6:
                    uVar.GaT = aVar3.UbS.zl();
                    AppMethodBeat.o(222843);
                    return 0;
                default:
                    AppMethodBeat.o(222843);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222843);
            return -1;
        }
    }
}
