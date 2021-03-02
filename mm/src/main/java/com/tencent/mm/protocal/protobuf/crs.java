package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class crs extends a {
    public long MwJ;
    public long MwK;
    public long MwL;
    public long duration;
    public long hlf;
    public long igp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208706);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.hlf);
            aVar.bb(2, this.igp);
            aVar.bb(3, this.MwJ);
            aVar.bb(4, this.MwK);
            aVar.bb(5, this.MwL);
            aVar.bb(6, this.duration);
            AppMethodBeat.o(208706);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.hlf) + 0 + g.a.a.b.b.a.r(2, this.igp) + g.a.a.b.b.a.r(3, this.MwJ) + g.a.a.b.b.a.r(4, this.MwK) + g.a.a.b.b.a.r(5, this.MwL) + g.a.a.b.b.a.r(6, this.duration);
            AppMethodBeat.o(208706);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208706);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crs crs = (crs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crs.hlf = aVar3.UbS.zl();
                    AppMethodBeat.o(208706);
                    return 0;
                case 2:
                    crs.igp = aVar3.UbS.zl();
                    AppMethodBeat.o(208706);
                    return 0;
                case 3:
                    crs.MwJ = aVar3.UbS.zl();
                    AppMethodBeat.o(208706);
                    return 0;
                case 4:
                    crs.MwK = aVar3.UbS.zl();
                    AppMethodBeat.o(208706);
                    return 0;
                case 5:
                    crs.MwL = aVar3.UbS.zl();
                    AppMethodBeat.o(208706);
                    return 0;
                case 6:
                    crs.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(208706);
                    return 0;
                default:
                    AppMethodBeat.o(208706);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208706);
            return -1;
        }
    }
}
