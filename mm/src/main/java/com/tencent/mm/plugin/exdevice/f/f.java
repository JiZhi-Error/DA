package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class f extends i {
    public b rBN;
    public b rBO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23490);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.rCb != null) {
                aVar.ni(1, this.rCb.computeSize());
                this.rCb.writeFields(aVar);
            }
            if (this.rBN != null) {
                aVar.c(2, this.rBN);
            }
            if (this.rBO != null) {
                aVar.c(3, this.rBO);
            }
            AppMethodBeat.o(23490);
            return 0;
        } else if (i2 == 1) {
            int nh = this.rCb != null ? g.a.a.a.nh(1, this.rCb.computeSize()) + 0 : 0;
            if (this.rBN != null) {
                nh += g.a.a.b.b.a.b(2, this.rBN);
            }
            if (this.rBO != null) {
                nh += g.a.a.b.b.a.b(3, this.rBO);
            }
            AppMethodBeat.o(23490);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = i.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = i.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(23490);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, i.getNextFieldNumber(aVar4))) {
                        }
                        fVar.rCb = dVar;
                    }
                    AppMethodBeat.o(23490);
                    return 0;
                case 2:
                    fVar.rBN = aVar3.UbS.hPo();
                    AppMethodBeat.o(23490);
                    return 0;
                case 3:
                    fVar.rBO = aVar3.UbS.hPo();
                    AppMethodBeat.o(23490);
                    return 0;
                default:
                    AppMethodBeat.o(23490);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23490);
            return -1;
        }
    }
}
