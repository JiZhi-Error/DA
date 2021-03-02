package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fq extends a {
    public LinkedList<csz> KJk = new LinkedList<>();
    public String pLp;

    public fq() {
        AppMethodBeat.i(212222);
        AppMethodBeat.o(212222);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212223);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KJk);
            if (this.pLp != null) {
                aVar.e(2, this.pLp);
            }
            AppMethodBeat.o(212223);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KJk) + 0;
            if (this.pLp != null) {
                c2 += g.a.a.b.b.a.f(2, this.pLp);
            }
            AppMethodBeat.o(212223);
            return c2;
        } else if (i2 == 2) {
            this.KJk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212223);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fq fqVar = (fq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        csz csz = new csz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = csz.populateBuilderWithField(aVar4, csz, a.getNextFieldNumber(aVar4))) {
                        }
                        fqVar.KJk.add(csz);
                    }
                    AppMethodBeat.o(212223);
                    return 0;
                case 2:
                    fqVar.pLp = aVar3.UbS.readString();
                    AppMethodBeat.o(212223);
                    return 0;
                default:
                    AppMethodBeat.o(212223);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212223);
            return -1;
        }
    }
}
