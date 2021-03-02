package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class da extends a {
    public String xMK;
    public String xML;
    public boolean xMM;
    public int xuT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41814);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xML == null) {
                b bVar = new b("Not all required fields were included: MediaURL");
                AppMethodBeat.o(41814);
                throw bVar;
            }
            aVar.aM(1, this.xuT);
            if (this.xMK != null) {
                aVar.e(2, this.xMK);
            }
            if (this.xML != null) {
                aVar.e(3, this.xML);
            }
            aVar.cc(4, this.xMM);
            AppMethodBeat.o(41814);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xuT) + 0;
            if (this.xMK != null) {
                bu += g.a.a.b.b.a.f(2, this.xMK);
            }
            if (this.xML != null) {
                bu += g.a.a.b.b.a.f(3, this.xML);
            }
            int fS = bu + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(41814);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xML == null) {
                b bVar2 = new b("Not all required fields were included: MediaURL");
                AppMethodBeat.o(41814);
                throw bVar2;
            }
            AppMethodBeat.o(41814);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            da daVar = (da) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    daVar.xuT = aVar3.UbS.zi();
                    AppMethodBeat.o(41814);
                    return 0;
                case 2:
                    daVar.xMK = aVar3.UbS.readString();
                    AppMethodBeat.o(41814);
                    return 0;
                case 3:
                    daVar.xML = aVar3.UbS.readString();
                    AppMethodBeat.o(41814);
                    return 0;
                case 4:
                    daVar.xMM = aVar3.UbS.yZ();
                    AppMethodBeat.o(41814);
                    return 0;
                default:
                    AppMethodBeat.o(41814);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41814);
            return -1;
        }
    }
}
