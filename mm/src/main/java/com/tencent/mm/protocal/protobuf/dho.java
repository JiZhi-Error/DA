package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dho extends a {
    public String LuS;
    public int MMx;
    public String rBy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32394);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.rBy != null) {
                aVar.e(1, this.rBy);
            }
            aVar.aM(2, this.MMx);
            if (this.LuS != null) {
                aVar.e(3, this.LuS);
            }
            AppMethodBeat.o(32394);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.rBy != null ? g.a.a.b.b.a.f(1, this.rBy) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MMx);
            if (this.LuS != null) {
                f2 += g.a.a.b.b.a.f(3, this.LuS);
            }
            AppMethodBeat.o(32394);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32394);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dho dho = (dho) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dho.rBy = aVar3.UbS.readString();
                    AppMethodBeat.o(32394);
                    return 0;
                case 2:
                    dho.MMx = aVar3.UbS.zi();
                    AppMethodBeat.o(32394);
                    return 0;
                case 3:
                    dho.LuS = aVar3.UbS.readString();
                    AppMethodBeat.o(32394);
                    return 0;
                default:
                    AppMethodBeat.o(32394);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32394);
            return -1;
        }
    }
}
