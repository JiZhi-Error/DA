package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class zr extends a {
    public LinkedList<String> LkV = new LinkedList<>();
    public String LkW;
    public long LkX;
    public int oUv;

    public zr() {
        AppMethodBeat.i(6401);
        AppMethodBeat.o(6401);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6402);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            aVar.e(2, 1, this.LkV);
            if (this.LkW != null) {
                aVar.e(3, this.LkW);
            }
            aVar.bb(4, this.LkX);
            AppMethodBeat.o(6402);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0 + g.a.a.a.c(2, 1, this.LkV);
            if (this.LkW != null) {
                bu += g.a.a.b.b.a.f(3, this.LkW);
            }
            int r = bu + g.a.a.b.b.a.r(4, this.LkX);
            AppMethodBeat.o(6402);
            return r;
        } else if (i2 == 2) {
            this.LkV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6402);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zr zrVar = (zr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zrVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(6402);
                    return 0;
                case 2:
                    zrVar.LkV.add(aVar3.UbS.readString());
                    AppMethodBeat.o(6402);
                    return 0;
                case 3:
                    zrVar.LkW = aVar3.UbS.readString();
                    AppMethodBeat.o(6402);
                    return 0;
                case 4:
                    zrVar.LkX = aVar3.UbS.zl();
                    AppMethodBeat.o(6402);
                    return 0;
                default:
                    AppMethodBeat.o(6402);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6402);
            return -1;
        }
    }
}
