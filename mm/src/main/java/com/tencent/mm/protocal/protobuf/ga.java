package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.p;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ga extends a {
    public p KJP;
    public long lastUpdateTime;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124387);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KJP != null) {
                aVar.ni(1, this.KJP.computeSize());
                this.KJP.writeFields(aVar);
            }
            aVar.bb(2, this.lastUpdateTime);
            AppMethodBeat.o(124387);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.KJP != null ? g.a.a.a.nh(1, this.KJP.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.lastUpdateTime);
            AppMethodBeat.o(124387);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124387);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ga gaVar = (ga) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        p pVar = new p();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = pVar.populateBuilderWithField(aVar4, pVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gaVar.KJP = pVar;
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                case 2:
                    gaVar.lastUpdateTime = aVar3.UbS.zl();
                    AppMethodBeat.o(124387);
                    return 0;
                default:
                    AppMethodBeat.o(124387);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124387);
            return -1;
        }
    }
}
