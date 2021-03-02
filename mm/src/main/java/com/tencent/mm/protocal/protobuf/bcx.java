package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bcx extends a {
    public LinkedList<bcu> LEy = new LinkedList<>();
    public LinkedList<bcw> LLI = new LinkedList<>();
    public LinkedList<Long> LMe = new LinkedList<>();

    public bcx() {
        AppMethodBeat.i(209686);
        AppMethodBeat.o(209686);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209687);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LLI);
            aVar.e(2, 8, this.LEy);
            aVar.e(3, 3, this.LMe);
            AppMethodBeat.o(209687);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LLI) + 0 + g.a.a.a.c(2, 8, this.LEy) + g.a.a.a.c(3, 3, this.LMe);
            AppMethodBeat.o(209687);
            return c2;
        } else if (i2 == 2) {
            this.LLI.clear();
            this.LEy.clear();
            this.LMe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209687);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcx bcx = (bcx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bcw bcw = new bcw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bcw.populateBuilderWithField(aVar4, bcw, a.getNextFieldNumber(aVar4))) {
                        }
                        bcx.LLI.add(bcw);
                    }
                    AppMethodBeat.o(209687);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bcu bcu = new bcu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bcu.populateBuilderWithField(aVar5, bcu, a.getNextFieldNumber(aVar5))) {
                        }
                        bcx.LEy.add(bcu);
                    }
                    AppMethodBeat.o(209687);
                    return 0;
                case 3:
                    bcx.LMe.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(209687);
                    return 0;
                default:
                    AppMethodBeat.o(209687);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209687);
            return -1;
        }
    }
}
