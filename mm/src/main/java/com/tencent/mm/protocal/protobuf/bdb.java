package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bdb extends a {
    public long LMP;
    public String LMQ;
    public LinkedList<String> LMR = new LinkedList<>();
    public LinkedList<bcv> LMS = new LinkedList<>();
    public LinkedList<String> LMT = new LinkedList<>();
    public int style;

    public bdb() {
        AppMethodBeat.i(209689);
        AppMethodBeat.o(209689);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209690);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.LMP);
            aVar.aM(2, this.style);
            if (this.LMQ != null) {
                aVar.e(3, this.LMQ);
            }
            aVar.e(4, 1, this.LMR);
            aVar.e(5, 8, this.LMS);
            aVar.e(6, 1, this.LMT);
            AppMethodBeat.o(209690);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.LMP) + 0 + g.a.a.b.b.a.bu(2, this.style);
            if (this.LMQ != null) {
                r += g.a.a.b.b.a.f(3, this.LMQ);
            }
            int c2 = r + g.a.a.a.c(4, 1, this.LMR) + g.a.a.a.c(5, 8, this.LMS) + g.a.a.a.c(6, 1, this.LMT);
            AppMethodBeat.o(209690);
            return c2;
        } else if (i2 == 2) {
            this.LMR.clear();
            this.LMS.clear();
            this.LMT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209690);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdb bdb = (bdb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bdb.LMP = aVar3.UbS.zl();
                    AppMethodBeat.o(209690);
                    return 0;
                case 2:
                    bdb.style = aVar3.UbS.zi();
                    AppMethodBeat.o(209690);
                    return 0;
                case 3:
                    bdb.LMQ = aVar3.UbS.readString();
                    AppMethodBeat.o(209690);
                    return 0;
                case 4:
                    bdb.LMR.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209690);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bcv bcv = new bcv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bcv.populateBuilderWithField(aVar4, bcv, a.getNextFieldNumber(aVar4))) {
                        }
                        bdb.LMS.add(bcv);
                    }
                    AppMethodBeat.o(209690);
                    return 0;
                case 6:
                    bdb.LMT.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209690);
                    return 0;
                default:
                    AppMethodBeat.o(209690);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209690);
            return -1;
        }
    }
}
