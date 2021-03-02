package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class evr extends a {
    public String Nta;
    public LinkedList<evn> Nts = new LinkedList<>();

    public evr() {
        AppMethodBeat.i(147803);
        AppMethodBeat.o(147803);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147804);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nta != null) {
                aVar.e(1, this.Nta);
            }
            aVar.e(2, 8, this.Nts);
            AppMethodBeat.o(147804);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Nta != null ? g.a.a.b.b.a.f(1, this.Nta) + 0 : 0) + g.a.a.a.c(2, 8, this.Nts);
            AppMethodBeat.o(147804);
            return f2;
        } else if (i2 == 2) {
            this.Nts.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147804);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evr evr = (evr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    evr.Nta = aVar3.UbS.readString();
                    AppMethodBeat.o(147804);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        evn evn = new evn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = evn.populateBuilderWithField(aVar4, evn, a.getNextFieldNumber(aVar4))) {
                        }
                        evr.Nts.add(evn);
                    }
                    AppMethodBeat.o(147804);
                    return 0;
                default:
                    AppMethodBeat.o(147804);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147804);
            return -1;
        }
    }
}
