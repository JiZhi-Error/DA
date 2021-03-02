package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fgu extends a {
    public LinkedList<fgw> Vji = new LinkedList<>();
    public LinkedList<String> Vjj = new LinkedList<>();

    public fgu() {
        AppMethodBeat.i(258814);
        AppMethodBeat.o(258814);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(258815);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Vji);
            aVar.e(2, 1, this.Vjj);
            AppMethodBeat.o(258815);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Vji) + 0 + g.a.a.a.c(2, 1, this.Vjj);
            AppMethodBeat.o(258815);
            return c2;
        } else if (i2 == 2) {
            this.Vji.clear();
            this.Vjj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(258815);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgu fgu = (fgu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fgw fgw = new fgw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fgw.populateBuilderWithField(aVar4, fgw, a.getNextFieldNumber(aVar4))) {
                        }
                        fgu.Vji.add(fgw);
                    }
                    AppMethodBeat.o(258815);
                    return 0;
                case 2:
                    fgu.Vjj.add(aVar3.UbS.readString());
                    AppMethodBeat.o(258815);
                    return 0;
                default:
                    AppMethodBeat.o(258815);
                    return -1;
            }
        } else {
            AppMethodBeat.o(258815);
            return -1;
        }
    }
}
