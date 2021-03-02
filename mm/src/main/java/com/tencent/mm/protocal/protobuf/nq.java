package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class nq extends a {
    public LinkedList<ns> KKx = new LinkedList<>();
    public boolean KTd;
    public String Title;

    public nq() {
        AppMethodBeat.i(124411);
        AppMethodBeat.o(124411);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124412);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.e(2, 8, this.KKx);
            aVar.cc(3, this.KTd);
            AppMethodBeat.o(124412);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0) + g.a.a.a.c(2, 8, this.KKx) + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(124412);
            return f2;
        } else if (i2 == 2) {
            this.KKx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124412);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nq nqVar = (nq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nqVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(124412);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ns nsVar = new ns();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = nsVar.populateBuilderWithField(aVar4, nsVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nqVar.KKx.add(nsVar);
                    }
                    AppMethodBeat.o(124412);
                    return 0;
                case 3:
                    nqVar.KTd = aVar3.UbS.yZ();
                    AppMethodBeat.o(124412);
                    return 0;
                default:
                    AppMethodBeat.o(124412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124412);
            return -1;
        }
    }
}
