package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dfn extends a {
    public int LsZ;
    public long Lta;
    public LinkedList<dfw> MKx = new LinkedList<>();
    public int yqb;

    public dfn() {
        AppMethodBeat.i(32381);
        AppMethodBeat.o(32381);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32382);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LsZ);
            aVar.bb(2, this.Lta);
            aVar.e(3, 8, this.MKx);
            aVar.aM(4, this.yqb);
            AppMethodBeat.o(32382);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LsZ) + 0 + g.a.a.b.b.a.r(2, this.Lta) + g.a.a.a.c(3, 8, this.MKx) + g.a.a.b.b.a.bu(4, this.yqb);
            AppMethodBeat.o(32382);
            return bu;
        } else if (i2 == 2) {
            this.MKx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32382);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfn dfn = (dfn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dfn.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32382);
                    return 0;
                case 2:
                    dfn.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(32382);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dfw dfw = new dfw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dfw.populateBuilderWithField(aVar4, dfw, a.getNextFieldNumber(aVar4))) {
                        }
                        dfn.MKx.add(dfw);
                    }
                    AppMethodBeat.o(32382);
                    return 0;
                case 4:
                    dfn.yqb = aVar3.UbS.zi();
                    AppMethodBeat.o(32382);
                    return 0;
                default:
                    AppMethodBeat.o(32382);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32382);
            return -1;
        }
    }
}
