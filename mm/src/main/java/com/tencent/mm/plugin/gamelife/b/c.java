package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class c extends a {
    public long ybb;
    public long ybc;
    public m ybd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225886);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.ybb);
            aVar.bb(2, this.ybc);
            if (this.ybd != null) {
                aVar.ni(3, this.ybd.computeSize());
                this.ybd.writeFields(aVar);
            }
            AppMethodBeat.o(225886);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.ybb) + 0 + g.a.a.b.b.a.r(2, this.ybc);
            if (this.ybd != null) {
                r += g.a.a.a.nh(3, this.ybd.computeSize());
            }
            AppMethodBeat.o(225886);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225886);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.ybb = aVar3.UbS.zl();
                    AppMethodBeat.o(225886);
                    return 0;
                case 2:
                    cVar.ybc = aVar3.UbS.zl();
                    AppMethodBeat.o(225886);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        m mVar = new m();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.ybd = mVar;
                    }
                    AppMethodBeat.o(225886);
                    return 0;
                default:
                    AppMethodBeat.o(225886);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225886);
            return -1;
        }
    }
}
