package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class czi extends a {
    public long MED;
    public czh MEE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207013);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.MED);
            if (this.MEE != null) {
                aVar.ni(2, this.MEE.computeSize());
                this.MEE.writeFields(aVar);
            }
            AppMethodBeat.o(207013);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.MED) + 0;
            if (this.MEE != null) {
                r += g.a.a.a.nh(2, this.MEE.computeSize());
            }
            AppMethodBeat.o(207013);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207013);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czi czi = (czi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    czi.MED = aVar3.UbS.zl();
                    AppMethodBeat.o(207013);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        czh czh = new czh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = czh.populateBuilderWithField(aVar4, czh, a.getNextFieldNumber(aVar4))) {
                        }
                        czi.MEE = czh;
                    }
                    AppMethodBeat.o(207013);
                    return 0;
                default:
                    AppMethodBeat.o(207013);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207013);
            return -1;
        }
    }
}
