package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bjb extends a {
    public LinkedList<String> LSP = new LinkedList<>();
    public bf Lcc;
    public String LhT;

    public bjb() {
        AppMethodBeat.i(91482);
        AppMethodBeat.o(91482);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91483);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.LSP);
            if (this.Lcc != null) {
                aVar.ni(2, this.Lcc.computeSize());
                this.Lcc.writeFields(aVar);
            }
            if (this.LhT != null) {
                aVar.e(3, this.LhT);
            }
            AppMethodBeat.o(91483);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.LSP) + 0;
            if (this.Lcc != null) {
                c2 += g.a.a.a.nh(2, this.Lcc.computeSize());
            }
            if (this.LhT != null) {
                c2 += g.a.a.b.b.a.f(3, this.LhT);
            }
            AppMethodBeat.o(91483);
            return c2;
        } else if (i2 == 2) {
            this.LSP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91483);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjb bjb = (bjb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjb.LSP.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91483);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bfVar.populateBuilderWithField(aVar4, bfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bjb.Lcc = bfVar;
                    }
                    AppMethodBeat.o(91483);
                    return 0;
                case 3:
                    bjb.LhT = aVar3.UbS.readString();
                    AppMethodBeat.o(91483);
                    return 0;
                default:
                    AppMethodBeat.o(91483);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91483);
            return -1;
        }
    }
}
