package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class acd extends a {
    public int KJJ;
    public int LmH;
    public int LmI;
    public int count;
    public String openid;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103205);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.openid != null) {
                aVar.e(1, this.openid);
            }
            aVar.aM(2, this.KJJ);
            aVar.aM(3, this.LmH);
            aVar.aM(4, this.LmI);
            aVar.aM(5, this.scene);
            aVar.aM(6, this.count);
            AppMethodBeat.o(103205);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.openid != null ? g.a.a.b.b.a.f(1, this.openid) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KJJ) + g.a.a.b.b.a.bu(3, this.LmH) + g.a.a.b.b.a.bu(4, this.LmI) + g.a.a.b.b.a.bu(5, this.scene) + g.a.a.b.b.a.bu(6, this.count);
            AppMethodBeat.o(103205);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103205);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acd acd = (acd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acd.openid = aVar3.UbS.readString();
                    AppMethodBeat.o(103205);
                    return 0;
                case 2:
                    acd.KJJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103205);
                    return 0;
                case 3:
                    acd.LmH = aVar3.UbS.zi();
                    AppMethodBeat.o(103205);
                    return 0;
                case 4:
                    acd.LmI = aVar3.UbS.zi();
                    AppMethodBeat.o(103205);
                    return 0;
                case 5:
                    acd.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(103205);
                    return 0;
                case 6:
                    acd.count = aVar3.UbS.zi();
                    AppMethodBeat.o(103205);
                    return 0;
                default:
                    AppMethodBeat.o(103205);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103205);
            return -1;
        }
    }
}
