package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bzz extends a {
    public LinkedList<cnb> LoV = new LinkedList<>();
    public String Name;

    public bzz() {
        AppMethodBeat.i(125736);
        AppMethodBeat.o(125736);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125737);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            aVar.e(2, 8, this.LoV);
            AppMethodBeat.o(125737);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Name != null ? g.a.a.b.b.a.f(1, this.Name) + 0 : 0) + g.a.a.a.c(2, 8, this.LoV);
            AppMethodBeat.o(125737);
            return f2;
        } else if (i2 == 2) {
            this.LoV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125737);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzz bzz = (bzz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bzz.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(125737);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cnb cnb = new cnb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cnb.populateBuilderWithField(aVar4, cnb, a.getNextFieldNumber(aVar4))) {
                        }
                        bzz.LoV.add(cnb);
                    }
                    AppMethodBeat.o(125737);
                    return 0;
                default:
                    AppMethodBeat.o(125737);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125737);
            return -1;
        }
    }
}
