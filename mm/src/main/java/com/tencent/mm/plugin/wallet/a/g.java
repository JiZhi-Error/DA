package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class g extends a {
    public m HEb;
    public String HEd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91291);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.HEb != null) {
                aVar.ni(1, this.HEb.computeSize());
                this.HEb.writeFields(aVar);
            }
            if (this.HEd != null) {
                aVar.e(2, this.HEd);
            }
            AppMethodBeat.o(91291);
            return 0;
        } else if (i2 == 1) {
            int nh = this.HEb != null ? g.a.a.a.nh(1, this.HEb.computeSize()) + 0 : 0;
            if (this.HEd != null) {
                nh += g.a.a.b.b.a.f(2, this.HEd);
            }
            AppMethodBeat.o(91291);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91291);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        m mVar = new m();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.HEb = mVar;
                    }
                    AppMethodBeat.o(91291);
                    return 0;
                case 2:
                    gVar.HEd = aVar3.UbS.readString();
                    AppMethodBeat.o(91291);
                    return 0;
                default:
                    AppMethodBeat.o(91291);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91291);
            return -1;
        }
    }
}
