package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class k extends a {
    public c UqV;
    public String jlz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261977);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UqV != null) {
                aVar.ni(1, this.UqV.computeSize());
                this.UqV.writeFields(aVar);
            }
            if (this.jlz != null) {
                aVar.e(2, this.jlz);
            }
            AppMethodBeat.o(261977);
            return 0;
        } else if (i2 == 1) {
            int nh = this.UqV != null ? g.a.a.a.nh(1, this.UqV.computeSize()) + 0 : 0;
            if (this.jlz != null) {
                nh += g.a.a.b.b.a.f(2, this.jlz);
            }
            AppMethodBeat.o(261977);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261977);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = new c();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.UqV = cVar;
                    }
                    AppMethodBeat.o(261977);
                    return 0;
                case 2:
                    kVar.jlz = aVar3.UbS.readString();
                    AppMethodBeat.o(261977);
                    return 0;
                default:
                    AppMethodBeat.o(261977);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261977);
            return -1;
        }
    }
}
