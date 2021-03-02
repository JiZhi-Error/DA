package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class arl extends a {
    public LinkedList<aqq> gCs = new LinkedList<>();
    public long iVn;
    public String username;

    public arl() {
        AppMethodBeat.i(168968);
        AppMethodBeat.o(168968);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168969);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.gCs);
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.bb(3, this.iVn);
            AppMethodBeat.o(168969);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.gCs) + 0;
            if (this.username != null) {
                c2 += g.a.a.b.b.a.f(2, this.username);
            }
            int r = c2 + g.a.a.b.b.a.r(3, this.iVn);
            AppMethodBeat.o(168969);
            return r;
        } else if (i2 == 2) {
            this.gCs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168969);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            arl arl = (arl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aqq aqq = new aqq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aqq.populateBuilderWithField(aVar4, aqq, a.getNextFieldNumber(aVar4))) {
                        }
                        arl.gCs.add(aqq);
                    }
                    AppMethodBeat.o(168969);
                    return 0;
                case 2:
                    arl.username = aVar3.UbS.readString();
                    AppMethodBeat.o(168969);
                    return 0;
                case 3:
                    arl.iVn = aVar3.UbS.zl();
                    AppMethodBeat.o(168969);
                    return 0;
                default:
                    AppMethodBeat.o(168969);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168969);
            return -1;
        }
    }
}
