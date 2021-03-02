package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class efy extends a {
    public String Liq;
    public int LoT;
    public int MKY;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32460);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.Liq != null) {
                aVar.e(2, this.Liq);
            }
            aVar.aM(3, this.MKY);
            aVar.aM(4, this.LoT);
            AppMethodBeat.o(32460);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.Liq != null) {
                f2 += g.a.a.b.b.a.f(2, this.Liq);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MKY) + g.a.a.b.b.a.bu(4, this.LoT);
            AppMethodBeat.o(32460);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32460);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efy efy = (efy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    efy.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32460);
                    return 0;
                case 2:
                    efy.Liq = aVar3.UbS.readString();
                    AppMethodBeat.o(32460);
                    return 0;
                case 3:
                    efy.MKY = aVar3.UbS.zi();
                    AppMethodBeat.o(32460);
                    return 0;
                case 4:
                    efy.LoT = aVar3.UbS.zi();
                    AppMethodBeat.o(32460);
                    return 0;
                default:
                    AppMethodBeat.o(32460);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32460);
            return -1;
        }
    }
}
