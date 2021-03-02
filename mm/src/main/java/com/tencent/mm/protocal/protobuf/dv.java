package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dv extends a {
    public String KHR;
    public LinkedList<ecv> KHS = new LinkedList<>();
    public String title;

    public dv() {
        AppMethodBeat.i(32112);
        AppMethodBeat.o(32112);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32113);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHR != null) {
                aVar.e(1, this.KHR);
            }
            aVar.e(2, 8, this.KHS);
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            AppMethodBeat.o(32113);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KHR != null ? g.a.a.b.b.a.f(1, this.KHR) + 0 : 0) + g.a.a.a.c(2, 8, this.KHS);
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(3, this.title);
            }
            AppMethodBeat.o(32113);
            return f2;
        } else if (i2 == 2) {
            this.KHS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32113);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dv dvVar = (dv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvVar.KHR = aVar3.UbS.readString();
                    AppMethodBeat.o(32113);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ecv ecv = new ecv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ecv.populateBuilderWithField(aVar4, ecv, a.getNextFieldNumber(aVar4))) {
                        }
                        dvVar.KHS.add(ecv);
                    }
                    AppMethodBeat.o(32113);
                    return 0;
                case 3:
                    dvVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(32113);
                    return 0;
                default:
                    AppMethodBeat.o(32113);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32113);
            return -1;
        }
    }
}
