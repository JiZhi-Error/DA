package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cgy extends a {
    public LinkedList<fbv> KKx = new LinkedList<>();
    public int oTz;
    public String xLl;

    public cgy() {
        AppMethodBeat.i(197135);
        AppMethodBeat.o(197135);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(197136);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xLl != null) {
                aVar.e(1, this.xLl);
            }
            aVar.aM(2, this.oTz);
            aVar.e(3, 8, this.KKx);
            AppMethodBeat.o(197136);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xLl != null ? g.a.a.b.b.a.f(1, this.xLl) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.KKx);
            AppMethodBeat.o(197136);
            return f2;
        } else if (i2 == 2) {
            this.KKx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(197136);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgy cgy = (cgy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgy.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(197136);
                    return 0;
                case 2:
                    cgy.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(197136);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbv fbv = new fbv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbv.populateBuilderWithField(aVar4, fbv, a.getNextFieldNumber(aVar4))) {
                        }
                        cgy.KKx.add(fbv);
                    }
                    AppMethodBeat.o(197136);
                    return 0;
                default:
                    AppMethodBeat.o(197136);
                    return -1;
            }
        } else {
            AppMethodBeat.o(197136);
            return -1;
        }
    }
}
