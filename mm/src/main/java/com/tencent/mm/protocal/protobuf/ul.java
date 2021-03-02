package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ul extends a {
    public LinkedList<ud> LdI = new LinkedList<>();
    public String LdU;

    public ul() {
        AppMethodBeat.i(113962);
        AppMethodBeat.o(113962);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113963);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LdI);
            if (this.LdU != null) {
                aVar.e(2, this.LdU);
            }
            AppMethodBeat.o(113963);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LdI) + 0;
            if (this.LdU != null) {
                c2 += g.a.a.b.b.a.f(2, this.LdU);
            }
            AppMethodBeat.o(113963);
            return c2;
        } else if (i2 == 2) {
            this.LdI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113963);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ul ulVar = (ul) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ud udVar = new ud();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = udVar.populateBuilderWithField(aVar4, udVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ulVar.LdI.add(udVar);
                    }
                    AppMethodBeat.o(113963);
                    return 0;
                case 2:
                    ulVar.LdU = aVar3.UbS.readString();
                    AppMethodBeat.o(113963);
                    return 0;
                default:
                    AppMethodBeat.o(113963);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113963);
            return -1;
        }
    }
}
